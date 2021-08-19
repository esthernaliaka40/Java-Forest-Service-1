import static spark.Spark.*;

import java.util.List;
import  java.util.Map;
import java.util.HashMap;
import java.util.Objects;


import models.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import javax.management.openmbean.CompositeData;

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


        //Sighting
        //Animal Spotted
        get("/animalSighting/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "sightingForm.hbs");
        }, new HandlebarsTemplateEngine());

        //post sighting
        post("/animalSighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int rangerId = Integer.parseInt(request.queryParams("ranger"));
            int animalId = Integer.parseInt(request.queryParams("animal"));
            int locationId = Integer.parseInt(request.queryParams("location"));
            String animalRangerName = request.queryParams("animalRanger");
            String name = request.queryParams("name");
            String location = request.queryParams("location");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String species = request.queryParams("species");

            if (species.equals("name")) {
                Wildlife testWildlife = new Wildlife(name);
                testWildlife.save();
                AnimalSighting testSighting = new AnimalSighting(name, location, animalRangerName);
                testSighting.save();
            }else if(species.equals("endangered")){
                EndangeredAnimal testEndangered = new EndangeredAnimal(name, health, age);
                testEndangered.save();
                AnimalSighting testAnotherSighting = new AnimalSighting(testEndangered.getId(), location, animalRangerName);
                testAnotherSighting.save();
            }

            List<AnimalSighting> animalSighting = AnimalSighting.getAll();
            List<EndangeredAnimal> wildlife = EndangeredAnimal.all();
            model.put("animalSightings", animalSighting);
            model.put("wildlife", wildlife);

            return new ModelAndView(model, "sighting.hbs");
        }, new HandlebarsTemplateEngine());

        //get all sighting
        get("/animalSighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<AnimalSighting> sightings = AnimalSighting.getAll();
            model.put("sighting", sightings);
            return new ModelAndView(model, "sighting.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
