/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository;

import com.avbravo.mongodbatlasdriver.model.Pais;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
public interface PaisRepository {
    public List<Pais> findAll();
    public Optional<Pais> findById(String id);
    public List<Pais> findByPais(String contry);
    public Pais save(Pais pais);
    public void deleteById(String id);
}
