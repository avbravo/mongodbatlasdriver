/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.avbravo.jmoordb.core.util.Test;
import com.avbravo.mongodbatlasdriver.model.Provincia;
import com.avbravo.mongodbatlasdriver.model.Pais;
import java.util.List;
import java.util.function.Supplier;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
public class ProvinciaSupplier {

    // <editor-fold defaultstate="collapsed" desc="Provincia get(Supplier<? extends Provincia> s, Document document)">
    public static Provincia get(Supplier<? extends Provincia> s, Document document) {
        Provincia provincia = s.get();
        try {
            
            Test.box("ProvinciaSupplier.get()");
            Test.msgTab("ProvinciaSupplier.document.toJson()"+document.toJson());
            provincia.setIdprovincia(String.valueOf(document.get("idprovincia")));
            provincia.setProvincia(String.valueOf(document.get("provincia")));
            
            /**
             * No es entidad final
             * No tiene embebido simple
             * No tiene Embedded List<>
             * Tiene Referenced simple
             */

            
            /**
             * @Referenced
             * Nota:
             *     Las referencias generadas mediante lookup nos devuelven un List<>
             *     Por lo tanto debemos verificar si es una entidad simple
             *     o un @Referenced List<Entidad>
             */
            /*
            -------------------------------------------------------
         */
    
            // (if simple )
            Test.box("Revisare los paises");
            Boolean isSimplePais = true;
            List<Document> docPaisList = (List<Document>) document.get("pais");
            Test.msgTab("Obtuve la lista");
            Document docPais;
            if (isSimplePais) {

                if (docPaisList.isEmpty() || docPaisList.size() == 0) {
                    Test.warning("No hay registros de pais");
                } else {
                    Test.msgTab("Obteniendo el primer pais");
                    docPais = docPaisList.get(0);
                    Test.msgTab("docPais ="+docPais.toJson());
                    Test.msgTab(" invocando a PaisSupplier.get()");
                    provincia.setPais(PaisSupplier.get(Pais::new, docPais));
                    Test.msgTab("docPais obtenido:" + docPais);
                }

            } else {
               // Esta seccion es para @Referenced List<>
            }
            

        } catch (Exception e) {
            System.out.println("ProvinciaSupplier.get() " + e.getLocalizedMessage());
        }

        return provincia;

    }
// </editor-fold>
}
