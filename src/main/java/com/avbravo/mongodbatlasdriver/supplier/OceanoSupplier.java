/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.avbravo.jmoordb.core.util.Test;
import com.avbravo.mongodbatlasdriver.model.Country;
import com.avbravo.mongodbatlasdriver.model.Oceano;
import com.mongodb.client.FindIterable;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
public class OceanoSupplier {
// <editor-fold defaultstate="collapsed" desc="Oceano get(Supplier<? extends Oceano> s, Document document)">

    /**
     * Como es una clase que no tiene padres se puede implmentar JSON-B para
     * convertirlo directamente a Objeto.
     *
     * @param s
     * @param document
     * @return
     */

    public static Oceano get(Supplier<? extends Oceano> s, Document document) {
        Oceano oceano = s.get();
        try {
/**
 * Es una entidad final
 */      
            Jsonb jsonb = JsonbBuilder.create();
            oceano = jsonb.fromJson(document.toJson(), Oceano.class);
        } catch (Exception e) {
            System.out.println("OceanoSupplier.get() " + e.getLocalizedMessage());
        }
        return oceano;

    }
// </editor-fold>
}
