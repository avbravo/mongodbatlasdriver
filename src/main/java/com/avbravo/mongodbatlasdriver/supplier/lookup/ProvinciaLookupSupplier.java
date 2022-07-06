/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier.lookup;

import com.avbravo.jmoordb.core.annotation.Referenced;
import com.avbravo.jmoordb.core.util.Test;
import com.avbravo.mongodbatlasdriver.level.LookupSupplierLevel;
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
    LookupSupplierLevel levelLocal= LookupSupplierLevel.TWO;
// <editor-fold defaultstate="collapsed" desc="List<Bson> get(Supplier<? extends Planeta> s, Document document, String parent, LookupSupplierLevel level,Boolean applyFromNextLevel)">

    /**
     * Como es una clase que no tiene padres se puede implmentar JSON-B para
     * convertirlo directamente a Objeto.
      *
     * @param s
     * @param document
     * @param applyFromNextLevell : true  Aplica al siguiente nivel y a todos los superiores
     *                            : false aplica al superior del nivel superior
     * @return
     */

    public static List<Bson> get(Supplier<? extends Provincia> s, Referenced referenced, String parent,LookupSupplierLevel level, Boolean... applyFromThisLevel) {
       List<Bson> list = new ArrayList<>();
        Bson pipeline;
        try {
             Boolean apply = true;
            if (applyFromThisLevel.length != 0) {
                apply = applyFromThisLevel[0];

            }


             list.add(LookupSupplier.get(referenced,parent,level, apply));
             

            /**
             *
             * Cada supplier debe verificar las clases @Referenciadas e invocar
             * la superior
             *
             * Esta aplica en false del lookup ya que genera a partir del
             * siguiente Aplica para el siguiente
             */
            if (!apply) {
                apply = Boolean.TRUE;
            }

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
 
     List<Bson>  pipelinePais = PaisLookupSupplier.get(Pais::new, paisReferenced, parent, level,apply);
              if(pipelinePais.isEmpty() || pipelinePais.size() == 0){
                  
              }else{
                  pipelinePais.forEach(b -> {
                      list.add(b);
                });
              }
       
         
        } catch (Exception e) {
     Test.error(Test.nameOfClassAndMethod() + " "+e.getLocalizedMessage());
        }

        return list;

    }
// </editor-fold>

}
