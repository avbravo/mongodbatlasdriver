/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.avbravo.jmoordb.core.util.Test;
import com.avbravo.mongodbatlasdriver.model.Idioma;
import com.avbravo.mongodbatlasdriver.model.Musica;
import com.avbravo.mongodbatlasdriver.model.Pais;
import com.avbravo.mongodbatlasdriver.model.Planeta;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
public class PaisSupplier {

    // <editor-fold defaultstate="collapsed" desc="Pais get(Supplier<? extends Pais> s, Document document)">
    public static Pais get(Supplier<? extends Pais> s, Document document) {
        Pais pais = s.get();
        try {
            Test.box("PaisSupplier");
            Test.msg("PaisSupplier.Document " + document.toJson());

            pais.setIdpais(String.valueOf(document.get("idpais")));
            pais.setPais(String.valueOf(document.get("pais")));

            /**
             * ---------------------------------------------
             * Embebido Simple
             * Obtiene directamente
             *----------------------------------------------
             */
            Document doc = (Document) document.get("idioma");
            Jsonb jsonb = JsonbBuilder.create();
            Idioma idioma = jsonb.fromJson(doc.toJson(), Idioma.class);
            pais.setIdioma(idioma);

            /**
             * ------------------------------------------------
             * Lista @Embedded
             * Debe utilizar una lista temporal para almacenar los valores
             * 
             * --------------------------------------------------
             */
            List<Musica> musicaList = new ArrayList<>();
            List<Document> musicDoc = (List) document.get("musica");
            for (Document docm : musicDoc) {
                Musica musica = jsonb.fromJson(docm.toJson(), Musica.class);
                musicaList.add(musica);
            }
            pais.setMusica(musicaList);
            
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
            Boolean isSimple = true;
            List<Document> docPlanetaList = (List<Document>) document.get("planeta");
            Document docPlaneta;
            if (isSimple) {

                if (docPlanetaList.isEmpty() || docPlanetaList.size() == 0) {
                    Test.warning("No hay registros de planetas");
                } else {
                    docPlaneta = docPlanetaList.get(0);
                    pais.setPlaneta(PlanetaSupplier.get(Planeta::new, docPlaneta));
                    Test.msgTab("docPlaneta obtenido:" + docPlaneta);
                }

            } else {
                /**
                 * Lista de Referenciados
                 * Recorre cada elemento y lo carga en un List<Entidad>
                 * Luego lo asigna al atributo de la entidad superior
                 * Ejemplo de Implementación
                  List<Planeta> planetaList = new ArrayList<>();
                   for(Document varDoc:docPlanetaList){                       
                       planetaList.add(PlanetaSupplier.get(Planeta::new, varDoc));
                   }
                   pais.setPlaneta(planetaList);
                 */
               
                
            }

        } catch (Exception e) {
            System.out.println("PaisSupplier.get() " + e.getLocalizedMessage());
        }

        return pais;

    }
// </editor-fold>
}
