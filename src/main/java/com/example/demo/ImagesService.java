package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImagesService {
    private ImagesRepository imagesRepository;
    @Autowired
    public ImagesService(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }
    public List<Images> getAll(){
        List<Images> list = new ArrayList<>();
        this.imagesRepository.findAll().forEach(list::add);
        return list;
    }
    public Images findById(int id){
        return this.imagesRepository.findById(id);
    }
    public void saveOrUpdateImage (Images images) {
        this.imagesRepository.save(images);
    }
    public void deleteImage(Images images) {
        this.imagesRepository.delete(images);
    }
}
