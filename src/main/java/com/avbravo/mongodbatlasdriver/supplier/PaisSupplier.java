 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.avbravo.jmoordb.core.util.Test;
import com.avbravo.mongodbatlasdriver.model.Idioma;
import com.avbravo.mongodbatlasdriver.model.Musica;
import com.avbravo.mongodbatlasdriver.model.Oceano;
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
            Test.msgTab("PaisSupplier  voy a leer pais");
            pais.setIdpais(String.valueOf(document.get("idpais")));
            pais.setPais(String.valueOf(document.get("pais")));

            Test.msgTab("PaisSupplier  voy a leer idioma");
            /**
             * No es entidad final
             */

            /**
             * --------------------------------------------- Embebido Simple
             * Obtiene directamente
             * ----------------------------------------------
             */
            Document doc = (Document) document.get("idioma");
            Jsonb jsonb = JsonbBuilder.create();
            Idioma idioma = jsonb.fromJson(doc.toJson(), Idioma.class);
            pais.setIdioma(idioma);
            Test.msgTab("PaisSupplier  voy a leer musica");
            /**
             * ------------------------------------------------ Lista @Embedded
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
             * @Referenced Nota: Las referencias generadas mediante lookup nos
             * devuelven un List<>
             * Por lo tanto debemos verificar si es una entidad simple o un
             * @Referenced List<Entidad>
             */
            /*
            -------------------------------------------------------
             */
            Test.msgTab("PaisSupplier  voy a leer planeta");
            // (if simple )
            Boolean isSimplePlaneta = true;
            List<Document> docPlanetaList = (List<Document>) document.get("planeta");
            Document docPlaneta;
            if (isSimplePlaneta) {
                Test.msgTab("PaisSupplier  isSimple");
                if (docPlanetaList.isEmpty() || docPlanetaList.size() == 0) {
                    Test.warning("No hay registros de planetas");
                } else {
                    docPlaneta = docPlanetaList.get(0);
                    pais.setPlaneta(PlanetaSupplier.get(Planeta::new, docPlaneta));
                    Test.msgTab("docPlaneta obtenido:" + docPlaneta);
                }

            } else {
                Test.msgTab("PaisSupplier  is Referenced");
                /**
                 * Lista de Referenciados Recorre cada elemento y lo carga en un
                 * List<Entidad>
                 * Luego lo asigna al atributo de la entidad superior Ejemplo de
                 * Implementación
                 */

//                 List<Planeta> planetaList = new ArrayList<>();
//                 if (docPlanetaList.isEmpty() || docPlanetaList.size() == 0) {
//                    Test.warning("No hay registros de  planeta");
//                } else {
//                     docPlanetaList.forEach(varDoc -> {
//                         planetaList.add(PlanetaSupplier.get(Planeta::new, varDoc));
//                    });
//                 }
//                pais.setPlaneta(planetaList);
            }
            Test.msgTab("PaisSupplier  voy a leer oceano...");
            /**
             * *
             * Oceano
             */
            Boolean isSimpleOceano = false;
            List<Document> docOceanoList = (List<Document>) document.get("oceano");
            Document docOceano;
            if (isSimpleOceano) {

//                if (docOceanoList.isEmpty() || docOceanoList.size() == 0) {
//                    Test.warning("No hay registros de oceano");
//                } else {
//                    docOceano = docOceanoList.get(0);
//                    pais.setOceano(OceanoSupplier.get(Oceano::new, docOceano));
//                    Test.msgTab("docOceano obtenido:" + docOceano);
//                }
            } else {
                /**
                 * Lista de Referenciados Recorre cada elemento y lo carga en un
                 * List<Entidad>
                 * Luego lo asigna al atributo de la entidad superior
                 */
                List<Oceano> oceanoList = new ArrayList<>();
                if (docOceanoList.isEmpty() || docOceanoList.size() == 0) {
                    Test.warning("No hay registros de oceano");
                } else {
                    docOceanoList.forEach(varDoc -> {
                        oceanoList.add(OceanoSupplier.get(Oceano::new, varDoc));
                    });
                }
                pais.setOceano(oceanoList);

            }
            Test.msgTab("PaisSupplier  retornar pais");

        } catch (Exception e) {
            System.out.println("PaisSupplier.get() " + e.getLocalizedMessage());
        }

        return pais;

    }
// </editor-fold>
}
