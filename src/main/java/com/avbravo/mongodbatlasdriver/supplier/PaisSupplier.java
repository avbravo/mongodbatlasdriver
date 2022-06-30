/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.supplier;

import com.avbravo.mongodbatlasdriver.model.Idioma;
import com.avbravo.mongodbatlasdriver.model.Musica;
import com.avbravo.mongodbatlasdriver.model.Pais;
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

    public static Pais get(Supplier<? extends Pais> s, Document document) {
        Pais pais = s.get();
        try {

            System.out.println("Document " + document.toJson());

            pais.setIdpais(String.valueOf(document.get("idpais")));
            pais.setPais(String.valueOf(document.get("pais")));

            /**
             * Embebido Simple
             * 
             */
            Document doc = (Document) document.get("idioma");
            Jsonb jsonb = JsonbBuilder.create();
            Idioma idioma = jsonb.fromJson(doc.toJson(), Idioma.class);
            pais.setIdioma(idioma);
            
            /**
             * Lista @Embedded
             */
            List<Musica> musicaList = new ArrayList<>();
            List<Document> musicDoc= (List)document.get("musica");
            for(Document docm:musicDoc){
                Musica musica = jsonb.fromJson(docm.toJson(), Musica.class);
                musicaList.add(musica);
            }
            pais.setMusica(musicaList);
            /*
          @Referenced Planeta
             */
            // pais.setPlaneta(PlanetaSupplier.get(Planeta::new, document));

        } catch (Exception e) {
            System.out.println("PaisSupplier.get() " + e.getLocalizedMessage());
        }

        return pais;

    }

}
