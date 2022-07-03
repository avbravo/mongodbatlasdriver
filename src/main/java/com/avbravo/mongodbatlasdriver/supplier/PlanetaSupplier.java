/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.avbravo.mongodbatlasdriver.model.Planeta;
import java.util.function.Supplier;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
public class PlanetaSupplier {
// <editor-fold defaultstate="collapsed" desc="Planeta get(Supplier<? extends Planeta> s, Document document)">

    /**
     * Como es una clase que no tiene padres se puede implmentar JSON-B para
     * convertirlo directamente a Objeto.
     *
     * @param s
     * @param document
     * @return
     */

    public static Planeta get(Supplier<? extends Planeta> s, Document document) {
        Planeta planeta = s.get();
        try {
/**
 * Es una entidad final
 */      
            Jsonb jsonb = JsonbBuilder.create();
            planeta = jsonb.fromJson(document.toJson(), Planeta.class);
        } catch (Exception e) {
            System.out.println("PlanetaSupplier.get() " + e.getLocalizedMessage());
        }
        return planeta;

    }
// </editor-fold>
}
