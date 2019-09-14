import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class App {
    public static void main(String[]args){


        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            List<Squad> tasks = taskDao.getAll();
//            model.put("tasks", tasks);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
