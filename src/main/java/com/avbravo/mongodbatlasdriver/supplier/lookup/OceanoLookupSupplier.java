/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier.lookup;

import com.avbravo.jmoordb.core.annotation.Referenced;
import com.avbravo.jmoordb.core.util.Test;
import com.avbravo.mongodbatlasdriver.model.Oceano;
import static com.mongodb.client.model.Aggregates.lookup;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public class OceanoLookupSupplier {
// <editor-fold defaultstate="collapsed" desc="Oceano get(Supplier<? extends Oceano> s, Document document)">

    /**
     * Como es una clase que no tiene padres se puede implmentar JSON-B para
     * convertirlo directamente a Objeto.
     *
     * @param s
     * @param document
     * @return
     */
    public static List<Bson> get(Supplier<? extends Oceano> s, Referenced referenced) {
        List<Bson> list = new ArrayList<>();
        Bson pipeline;
        try {
            pipeline = lookup(referenced.from(), referenced.localField(), referenced.foreignField(),  referenced.as());
            list.add(pipeline);
      
/**
 * 
 * Cada supplier debe verificar las clases @Referenciadas e invocar la superior
 */
        } catch (Exception e) {
            System.out.println("OceanoLookupSupplier.get() "+e.getLocalizedMessage());
        }

        return list;

    }
// </editor-fold>
}
