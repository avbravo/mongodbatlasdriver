/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier.lookup;

import com.avbravo.jmoordb.core.annotation.Referenced;
import com.avbravo.mongodbatlasdriver.model.Pais;
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
public class PaisLookupSupplier {
// <editor-fold defaultstate="collapsed" desc="Planeta get(Supplier<? extends Planeta> s, Document document)">

    /**
     * Como es una clase que no tiene padres se puede implmentar JSON-B para
     * convertirlo directamente a Objeto.
     *
     * @param s
     * @param document
     * @return
     */

    public static List<Bson> get(Supplier<? extends Pais> s, Referenced referenced) {
       List<Bson> list = new ArrayList<>();
        Bson pipeline;
        try {
            pipeline = lookup(referenced.from(),referenced.localField(), referenced.foreignField(),  referenced.as());
             list.add(pipeline);
           /**
            * Analiza la entidad y verifica si tiene mas referenced
            * y los busca y los agrega al pipeline
            * 
            */
       //   List<Bson> listPlaneta =PlanetaLookupSupplier.get(Planeta::new, s.get().getPlaneta());
          
//          for(Bson b:listPlaneta){
//              list.add(b);
//          }
            
         
        } catch (Exception e) {

        }

        return list;

    }
// </editor-fold>

}
