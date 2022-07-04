/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier.lookup;

import com.avbravo.jmoordb.core.annotation.Referenced;
import com.avbravo.jmoordb.core.util.Test;
import com.avbravo.mongodbatlasdriver.model.Planeta;
import static com.mongodb.client.model.Aggregates.lookup;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public class PlanetaLookupSupplier {
// <editor-fold defaultstate="collapsed" desc="Planeta get(Supplier<? extends Planeta> s, Document document)">

    /**
     * Como es una clase que no tiene padres se puede implmentar JSON-B para
     * convertirlo directamente a Objeto.
     *
     * @param s
     * @param document
     * @return
     */
    public static List<Bson> get(Supplier<? extends Planeta> s, Referenced referenced) {
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
            System.out.println("PlanetaLookupSupplier.get() "+e.getLocalizedMessage());
        }

        return list;

    }
// </editor-fold>
}
