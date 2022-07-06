/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.avbravo.jmoordb.core.lookup.enumerations.LookupSupplierLevel;
import com.avbravo.jmoordb.core.util.ConsoleUtil;
import com.avbravo.jmoordb.core.util.Test;
import com.avbravo.mongodbatlasdriver.model.Corregimiento;
import com.avbravo.mongodbatlasdriver.model.Persona;
import java.util.List;
import java.util.function.Supplier;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
public class PersonaSupplier {
  // <editor-fold defaultstate="collapsed" desc="level">
        LookupSupplierLevel levelLocal= LookupSupplierLevel.THREE;
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Persona get(Supplier<? extends Persona> s, Document document)">
    public static Persona get(Supplier<? extends Persona> s, Document document) {
        Persona persona = s.get();
        try {
ConsoleUtil.info(Test.nameOfClassAndMethod() + "Document.toJson()  "+document.toJson());

           persona.setIdpersona(String.valueOf(document.get("idpersona")));
          persona.setNombre(String.valueOf(document.get("nombre")));

          Boolean istListReferecendToCorregimiento= false;
            /**
             * Esto aplica para nivel 2 donde hay que conocer los padres que
             * tiene Se debe conocer de la entidad de siguente nivel Pais cuales
             * son sus referencias para pasarlos como List<Document>
             * Persona{
             *    @Referenced Provincia{
             *                @Referenced Pais {
             *                            @Referenced Planeta planeta;
             *                            @Referenced List<Oceano> oceano;
             *                            @Embedded Idioma idioma;
             *                           @Embedded List<Musica> musica; 
             *                        }            
             *             }         
             * }
             * 
             * Se puede observar que hay referencias de nivel 3:
             * Nivel3              Nivel 2        Nivel 1    Nivel 0
             * Persona --> @R Provincia--> @Pais   -->@R Planeta
             * Persona --> @R Provincia--> @Pais   -->@R (List<Oceano>
             * Persona --> @R Provincia--> @Pais   -->@E (Idioma)
             * Persona --> @R Provincia--> @Pais   -->@E (List<Music>
             *
             */
                     

            List<Document> documentCorregimientoList = (List<Document>) document.get("corregimiento");
            List<Document> documentProvinciaList = (List<Document>) document.get("provincia");
            List<Document> documentPaisList = (List<Document>) document.get("pais");
            List<Document> documentPlanetaList = (List<Document>) document.get("planeta");
            List<Document> documentOceanoList = (List<Document>) document.get("oceano");

            Document docPais;
            if (! istListReferecendToCorregimiento ) {
             persona.setCorregimiento(CorregimientoSupplier.get(Corregimiento::new, documentCorregimientoList,documentProvinciaList, documentPaisList, documentPlanetaList, documentOceanoList));
            } else {
                Test.warning(Test.nameOfClassAndMethod() + " No se permite @Referenced List<>");
                /**
                 * En nivel 2 no se permiten @Referenced List<Nivel1>
                 * de una entidad de nivel 1 ya que complica la evaluación
                 * 
                 */
                
                 /**
                 * Lista de Referenciados Recorre cada elemento y lo carga en un
                 * List<Entidad>
                 * Luego lo asigna al atributo de la entidad superior
                 */
//                List<Pais> paisList = new ArrayList<>();
//                if (documentPaisList.isEmpty() || documentPaisList.size() == 0) {
//                    Test.warning("No hay registros de pais");
//                } else {
//                    documentPaisList.forEach(varDoc -> {
//                       paisList.add(PaisSupplier.get(Pais::new, varDoc));
//                    });
//                }
//                provincia.setPais(paisList);

            }

        } catch (Exception e) {
            Test.error(Test.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }

        return persona ;

    }
// </editor-fold>

}
