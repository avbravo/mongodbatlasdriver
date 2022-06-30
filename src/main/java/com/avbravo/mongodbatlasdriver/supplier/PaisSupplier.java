/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.avbravo.mongodbatlasdriver.model.Idioma;
import com.avbravo.mongodbatlasdriver.model.Pais;
import com.avbravo.mongodbatlasdriver.model.Planeta;
import java.util.function.Supplier;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
public class PaisSupplier {

    public static Pais get(Supplier<? extends Pais> s, Document document) {
        Pais pais = s.get();
        try {
      
                  System.out.println("Document "+document.toJson());
                  
            pais.setIdpais(String.valueOf(document.get("idpais")));
            pais.setPais(String.valueOf(document.get("pais")));
            pais.setIdioma((Idioma)document.get("idioma"));
            /*
          @Referenced Planeta
             */
           // pais.setPlaneta(PlanetaSupplier.get(Planeta::new, document));

        } catch (Exception e) {
            System.out.println("PaisSupplier.get() " + e.getLocalizedMessage());
        }

        return pais;

    }

}
