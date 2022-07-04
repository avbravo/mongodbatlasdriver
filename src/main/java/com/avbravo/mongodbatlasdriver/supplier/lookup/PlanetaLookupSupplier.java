/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier.lookup;

import com.avbravo.jmoordb.core.annotation.Referenced;
import com.avbravo.mongodbatlasdriver.model.Planeta;
import com.avbravo.mongodbatlasdriver.supplier.lookup.interfaces.LookupSupplier;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public class PlanetaLookupSupplier {
// <editor-fold defaultstate="collapsed" desc="Planeta get(Supplier<? extends Planeta> s, Document document, String parent)">

    /**
     * Como es una clase que no tiene padres se puede implmentar JSON-B para
     * convertirlo directamente a Objeto.
     *
     * @param s
     * @param document
     * @return
     */
    public static List<Bson> get(Supplier<? extends Planeta> s, Referenced referenced, String parent) {
        List<Bson> list = new ArrayList<>();
        Bson pipeline;
        try {
           
//            pipeline = lookup(referenced.from(), parent+referenced.localField(), referenced.foreignField(),  referenced.as());
//            list.add(pipeline);
            
            list.add(LookupSupplier.get(referenced,parent));
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
