package com.infoshare.myfitwebapp.service;

import com.infoshare.myfitwebapp.mapper.Mapper;
import com.infoshare.myfitwebapp.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final Mapper mapper;
    private final Repository repository;


    @Autowired
    public ProductService(Mapper mapper, Repository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

}
