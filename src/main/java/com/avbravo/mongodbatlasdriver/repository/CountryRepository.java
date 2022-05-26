/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository;

import com.avbravo.mongodbatlasdriver.model.Country;
import java.util.List;

/**
 *
 * @author avbravo
 */
public interface CountryRepository {
    public List<Country> findAll();
}
