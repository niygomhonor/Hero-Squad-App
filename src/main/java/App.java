import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.*;

public class App {
    public static void main(String[]args){
        staticFileLocation("/public");

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//
            return new ModelAndView(model, "indexe.hbs");
        }, new HandlebarsTemplateEngine());


        // getting all heroes  showing all hero details
        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("heroes", Hero.all());
//            model.put("template", "templates/heroes.vtl");
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        //getting heroes by their id which was returned by find method //

        get("/heroes/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
            model.put("hero", hero);

            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heros/new",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"hero-form.hbs");

        },new HandlebarsTemplateEngine());
        //task: process new hero form
        post ("/heroesP",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String name =request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power= request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newIdentity =new Hero(name,age,power,weakness);
            model.put("hero",newIdentity);
            return new ModelAndView(model,"hero-success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

//post: process new Squad form

        post("/squads/list", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");
            Squad newSquad= new Squad(name,cause,size);
//
            return new ModelAndView(model, "squadSuccessful.hbs");
        }, new HandlebarsTemplateEngine());


        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Squad> squad = (ArrayList<Squad>) Squad.all();
            model.put("squads", Squad.all());
//            model.put("template", "templates/squads.vtl");
            return new ModelAndView(model,"squads.hbs" );
        }, new HandlebarsTemplateEngine());

        //route to handle displaying found squad returned by the find method in class Hero
        get("/squads/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
//            model.put("template", "templates/squad.vtl");
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        // route to handle a form for adding new heroes to squads specific squad using the squad id
        get("squads/:id/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
//            model.put("template", "templates/squadHeroesForm.vtl");
            return new ModelAndView(model, "squad-hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            Squad squad = Squad.find(Integer.parseInt(request.queryParams("squadId")));

            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name, age, power, weakness);
            // check if hero is already in the squad
            if (Squad.heroAlreadyExists(newHero)) {
                String heroExists = "Hero " + name + " is already in the squad";
                model.put("heroExists", heroExists);
            }
            //check that squad members dont exceed users specified number of heroes
            else if (squad.gethHeroes().size() >= squad.getsSize()) {
                String sizeMet = "Squad is full";
                model.put("sizeMet", sizeMet);
            }
            // add the hero
            else{
                squad.addHero(newHero);
            }

            model.put("squad", squad);

            return new ModelAndView(model, "squad-hero-successful.hbs");
        }, new HandlebarsTemplateEngine());

    }

}
