import static spark.Spark.*;
import  java.util.Map;
import java.util.HashMap;
import java.util.Objects;

import models.RangerAnimal;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model, "layout.hbs");
        }, new HandlebarsTemplateEngine());


        get("/about", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "about.hbs");
        }, new HandlebarsTemplateEngine());

        //Ranger
        //Create A ranger
        get("wildlifeRanger/new", (request, response) -> {
           Map<String, Object> model = new HashMap<String , Object>();
           return new ModelAndView(model, "Wildliferangerform.hbs");
        }, new HandlebarsTemplateEngine());

        //Post a new Ranger
        post("/wildlifeRanger", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("rangerName");
            int tag = Integer.parseInt(request.queryParams("rangerTag"));
            int phone = Integer.parseInt(request.queryParams("rangerPhone"));
            String email = request.queryParams("rangerEmail");
            RangerAnimal testRanger = new RangerAnimal(name, tag, phone, email);
            model.put("ranger", testRanger);
            return new ModelAndView(model, "Wildliferangerform.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
