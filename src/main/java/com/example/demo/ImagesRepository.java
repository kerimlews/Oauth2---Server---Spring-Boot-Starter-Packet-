package com.example.demo;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ImagesRepository extends PagingAndSortingRepository<Images , Long> {
    public Images findByname (String name);
    public Images findById (int id);
}
