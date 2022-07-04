/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier.lookup.interfaces;

import com.avbravo.jmoordb.core.annotation.Referenced;
import static com.mongodb.client.model.Aggregates.lookup;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public class LookupSupplier {
    
   
    
    // <editor-fold defaultstate="collapsed" desc="Bson get(Referenced referenced,String parent)">
    /**
     * 
     * @param referenced
     * @param parent
     * @return Un Bson correspondiente al lookup generado que verifica la recursividad
     */

    public static Bson get(Referenced referenced,String parent){
        Bson b = new Document();
           
        try {
            String localField = localFieldRecursive(referenced, parent);       
             return lookup(referenced.from(),localField, referenced.foreignField(),  referenced.as());
        } catch (Exception e) {
            System.out.println("");
        }
        return lookup(referenced.from(),referenced.localField(), referenced.foreignField(),  referenced.as());
    }
    // </editor-fold>
    
    
     // <editor-fold defaultstate="collapsed" desc="String localFieldRecursive(Referenced referenced, String parent)">

    /**
     * Devuelve el from
     * @param referenced
     * @param parent
     * @return  localFieldRecursive es usado para recursividad cuando se invoca desde una clase superior.
     */
    public static String localFieldRecursive(Referenced referenced, String parent){
        String result = referenced.localField();
        try {
             if(!parent.equals("")){
                parent+=".";
                result = parent + referenced.localField();
            }
          
        } catch (Exception e) {
            System.out.println("LookupSupplier() "+e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
}
