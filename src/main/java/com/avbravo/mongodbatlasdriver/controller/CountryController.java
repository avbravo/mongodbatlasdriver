/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.controller;

import com.avbravo.mongodbatlasdriver.model.Country;
import com.avbravo.mongodbatlasdriver.repository.CountryRepositoryImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author avbravo
 */
@Path("/country")
//@Tag(name = "Config Retrieval service", description = "Get the value for user")
public class CountryController {

 private static final Supplier<WebApplicationException> NOT_FOUND =
            () -> new WebApplicationException(Response.Status.NOT_FOUND);
    @Inject
    CountryRepositoryImpl countryRepository;

    // <editor-fold defaultstate="collapsed" desc="@GET">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Country> get() {
        List<Country> list = new ArrayList<>();
        try {
          
            list = countryRepository.findAll();

        } catch (Exception e) {
            System.out.println("get() " + e.getLocalizedMessage());
        }

        return list;
    }

     @GET
    @Path("/{id}")
    public Country findById(@PathParam("id") String id) {
        return countryRepository.findById(id).orElseThrow(NOT_FOUND);
    }
}
