import static spark.Spark.*;
import  java.util.Map;
import java.util.HashMap;
import java.util.Objects;

import Dao.AnimalLocationDao;
import models.AnimalLocation;
import models.EndangeredAnimal;
import models.RangerAnimal;
import models.Wildlife;
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


        //Location of animal
        //Get a location
        get("/animalLocation", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "locationForm.hbs");
        }, new HandlebarsTemplateEngine());

        //Post location where animal was spotted
        post("/animalLocation", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("location");
            AnimalLocation testLocation = new AnimalLocation(name);
//            AnimalLocationDao.add(testLocation);
            model.put("location", testLocation);
            return new ModelAndView(model, "location.hbs");
        });

        //Update location
        get("/animalLocation", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfLocationToEdit = Integer.parseInt(req.params("id"));
//            Location editLocation = locationDao.findById(idOfLocationToEdit);
            model.put("editedLocation", idOfLocationToEdit);
            return new ModelAndView(model, "locationForm.hbs");
        }, new HandlebarsTemplateEngine());

        //process a form to update location
        post("/animalLocation/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("location");
            int idOfLocationToEdit = Integer.parseInt(request.params("id"));
//            Location editLocation = locationDao.findById(idOfLocationToEdit);
//            locationDao.update(idOfLocationToEdit, name);
            return new ModelAndView(model, "locations.hbs");
        }, new HandlebarsTemplateEngine());

        //delete location
        get("/animalLocation/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
//            locationDao.clearAllLocations();
            return new ModelAndView(model, "locations.hbs");
        }, new HandlebarsTemplateEngine());

        get("/locations/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfLocationToDelete = Integer.parseInt(req.params("id"));
//            locationDao.deleteById(idOfLocationToDelete);
//            model.put("location", locationDao.getAll());
            return new ModelAndView(model, "locations.hbs");
        }, new HandlebarsTemplateEngine());

        //Animals
        get("/wildlife/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "wildlifeForm.hbs");
        }, new HandlebarsTemplateEngine());

        //post animal
        post("/wildlife", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("wildlifeName");
            String age = request.queryParams("wildlifeAge");
            String health = request.queryParams("endangeredAnimalHealth");
            Wildlife testWildlife = new Wildlife(name, age, health);
            model.put("wildlife", testWildlife);
            return new ModelAndView(model, "animalForm.hbs");
        },new HandlebarsTemplateEngine());


    }
}
