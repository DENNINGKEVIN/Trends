import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //show home page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<EndangeredAnimal> animals = EndangeredAnimal.all();
            model.put("animals",animals);
            model.put("sightings",Sighting.all());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get all animals
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<EndangeredAnimal> animals = EndangeredAnimal.all();
            model.put("animals",animals);
            model.put("sightings",Sighting.all());
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //get all sightings
        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sightings = Sighting.all();
            model.put("animals", EndangeredAnimal.all());
            model.put("sightings", sightings);
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        //get animal by id
        get("/animal-details/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfEndangeredAnimal=Integer.parseInt(req.params("id"));
            EndangeredAnimal foundEndangeredAnimal=EndangeredAnimal.find(idOfEndangeredAnimal);
            model.put("foundEndangeredAnimal",foundEndangeredAnimal);
            model.put("sightings",Sighting.all());
            return new ModelAndView(model, "animals.details.hbs");
        }, new HandlebarsTemplateEngine());

        //get sighting by id
        get("/sighting-details/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfSighting=Integer.parseInt(req.params("id"));
            Sighting foundSighting=Sighting.find(idOfSighting);
            model.put("foundSighting",foundSighting);
            model.put("animals",EndangeredAnimal.all());
            return new ModelAndView(model, "sighting-details.hbs");
        }, new HandlebarsTemplateEngine());

        //show new animal form
        get("/posts/animals/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            model.put("animals",EndangeredAnimal.all());
            model.put("sightings",Sighting.all());
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        //show new endangered animal form
        get("/posts/endangered-animals/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            model.put("animals",EndangeredAnimal.all());
            model.put("sightings",Sighting.all());
            return new ModelAndView(model, "endangered-animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        //show new sighting form
        get("/posts/sightings/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            model.put("sightings",Sighting.all());
            model.put("animals",EndangeredAnimal.all());
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete an individual animal
        get("/animals/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfAnimalToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
            EndangeredAnimal deleteAnimal = EndangeredAnimal.find(idOfAnimalToDelete); //use it to find post
            deleteAnimal.delete();
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete an individual sighting
        get("/sightings/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSightingToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Sighting deleteSighting = Sighting.find(idOfSightingToDelete); //use it to find post
            deleteSighting.delete();
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        //process new animals form
        post("/posts/animals/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String health = req.queryParams("health");
            String age = req.queryParams("age");
            EndangeredAnimal animal = new EndangeredAnimal(name,health,age);
            animal.save();
            model.put("sightings",Sighting.all());
            model.put("animals",EndangeredAnimal.all());
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());

        //process new sightings form
        post("/posts/sightings/new",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            String location = req.queryParams("location");
            String rangername = req.queryParams("rangername");
            String animalid = Integer.parseInt(req.queryParams("animalid"));
            Sighting sighting = new Sighting(location,rangername,animalid);
            animal.save();
            model.put("sightings",Sighting.all());
            model.put("animals",EndangeredAnimal.all());
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
