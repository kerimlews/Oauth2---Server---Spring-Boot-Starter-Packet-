package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class HomeController {
    private ImagesService imagesService;
    private ObjectMapper objectMapper;
    @Autowired
    public HomeController(ImagesService imagesService,ObjectMapper objectMapper) {
        this.imagesService = imagesService;
        this.objectMapper = objectMapper;
    }
    @RequestMapping("/Images")
    public String getAllImages (){
        String json ="";
        try {
            json = this.objectMapper.writeValueAsString(this.imagesService.getAll());
        }catch (Exception ex){
            json = ex.getMessage();
        }
        return json;
    }
    @RequestMapping(value = "/Images/{id}" , method = RequestMethod.GET)
    public String getImageById(@PathVariable String id){
        String json =" ";
        try {
            json = this.objectMapper.writeValueAsString(this.imagesService.findById(Integer.parseInt(id)));
        }catch (Exception ex){
            json = ex.getMessage();
        }
        return json;
    }
    @RequestMapping(value="/Images" , method = RequestMethod.DELETE)
    public String deleteImage(@RequestBody Images images){
        String json =" ";
        try {
            json = "{'delete' : true}";
            this.imagesService.deleteImage(images);
        }catch (Exception ex){
            json = "{'delete' : false}";
        }
        return json;
    }
    @RequestMapping(value="/Images" , method = RequestMethod.POST)
    public String addOrUpdate(@RequestBody Images images){
        String json =" ";
        try {
            json = "{'add' : true}";
            this.imagesService.saveOrUpdateImage(images);
        }catch (Exception ex){
            json = "{'add' : false}";
        }
        return json;
    }
}
