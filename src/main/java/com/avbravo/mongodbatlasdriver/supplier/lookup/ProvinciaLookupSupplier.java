/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier.lookup;

import com.avbravo.jmoordb.core.annotation.Referenced;
import com.avbravo.mongodbatlasdriver.model.Pais;
import com.avbravo.mongodbatlasdriver.model.Provincia;
import com.avbravo.mongodbatlasdriver.supplier.lookup.interfaces.LookupSupplier;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public class ProvinciaLookupSupplier {
// <editor-fold defaultstate="collapsed" desc="Planeta get(Supplier<? extends Planeta> s, Document document, String parent)">

    /**
     * Como es una clase que no tiene padres se puede implmentar JSON-B para
     * convertirlo directamente a Objeto.
     *
     * @param s
     * @param document
     * @return
     */

    public static List<Bson> get(Supplier<? extends Provincia> s, Referenced referenced, String parent) {
       List<Bson> list = new ArrayList<>();
        Bson pipeline;
        try {
//            pipeline = lookup(referenced.from(),referenced.localField(), referenced.foreignField(),  referenced.as());
//             list.add(pipeline);
             
             list.add(LookupSupplier.get(referenced,parent));
             
             
/**
 * 
 * Cada supplier debe verificar las clases @Referenciadas e invocar la superior
 */

 Referenced paisReferenced = new Referenced() {
                @Override
                public String from() {
                    return "pais";
                }

                @Override
                public String localField() {
                    return "pais.idpais";
                }

                @Override
                public String foreignField() {
                    return "idpais";
                }

                @Override
                public String as() {
                    return "pais";
                }

                @Override
                public boolean lazy() {
                    return false;
                }

                @Override
                public Class<? extends Annotation> annotationType() {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
            };
 
     List<Bson>  pipelinePais = PaisLookupSupplier.get(Pais::new, paisReferenced, parent);
              if(pipelinePais.isEmpty() || pipelinePais.size() == 0){
                  
              }else{
                  pipelinePais.forEach(b -> {
                      list.add(b);
                });
              }
       
         
        } catch (Exception e) {
      System.out.println("ProvinciaLookupSupplier.get() "+e.getLocalizedMessage());
        }

        return list;

    }
// </editor-fold>

}
