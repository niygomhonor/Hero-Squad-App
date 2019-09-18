import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.HashMap;

import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Hero> hero = Hero.all();
            List<Squad> squads = Squad.all();
            model.put("hero", hero);
            model.put("squads", squads);
            return new ModelAndView(model, "indexe.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "all.hbs");

        }, new HandlebarsTemplateEngine());
        get("/heros/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");

        }, new HandlebarsTemplateEngine());

        //task: process new hero form
        post("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            System.out.print(name);
            Hero newIdentity = new Hero(name, age, power, weakness);
            model.put("heroes", newIdentity);
            return new ModelAndView(model, "hero-success.hbs");
        }, new HandlebarsTemplateEngine());

        //getting heroes by their id which was returned by find method //

        get("/heroes/:hid", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int heroIdToFind = Integer.parseInt(request.params("hId"));
            Hero findHero = Hero.findById(heroIdToFind);
            model.put("hero", findHero);

            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());


        get("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new Squad form
        post("/squads/list", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String sName = request.queryParams("sName");
            String cause = request.queryParams("cause");
            int size = Integer.parseInt(request.queryParams("size"));

            Squad newIdentitySquad = new Squad(sName, cause, size);
            model.put("squads", newIdentitySquad);
            return new ModelAndView(model, "squadSuccessful.hbs");
        }, new HandlebarsTemplateEngine());

        //route to handle displaying found squad returned by the find method in class Hero
        get("/squads/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            int squadHeroId = Integer.parseInt(request.params("id"));
            Squad squadId = Squad.findSquadById(squadHeroId);
            model.put("squad", squadId);
//            model.put("template", "templates/squad.vtl");
            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());


    }

}
