/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.controller;

import com.avbravo.mongodbatlasdriver.model.Country;
import com.avbravo.mongodbatlasdriver.repository.CountryRepositoryImpl;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author avbravo
 */
@Path("/country")
//@Tag(name = "Config Retrieval service", description = "Get the value for user")
public class CountryController {


    @Inject
    CountryRepositoryImpl countryRepository;

    // <editor-fold defaultstate="collapsed" desc="@GET">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Country> get() {
        List<Country> list = new ArrayList<>();
        try {
            System.out.println("[ CountryController ]");
            list = countryRepository.findAll();

        } catch (Exception e) {
            System.out.println("CountryController.get() " + e.getLocalizedMessage());
        }

        return list;
    }

}
