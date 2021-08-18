import static spark.Spark.*;
import  java.util.Map;
import java.util.HashMap;
import java.util.Objects;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model, "layout.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
