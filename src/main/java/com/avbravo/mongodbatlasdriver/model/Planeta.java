/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.model;

import com.avbravo.jmoordb.core.annotation.Entity;
import com.avbravo.jmoordb.core.annotation.Id;
import org.bson.types.ObjectId;



/**
 *
 * @author avbravo
 */
@Entity
public class Planeta {
//     ObjectId objectId = new ObjectId(stringId);
     ObjectId _id;
    @Id
    private String idplaneta;
      private String planeta;

    public Planeta() {
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }
  

    
    
    public String getIdplaneta() {
        return idplaneta;
    }

    public void setIdplaneta(String idplaneta) {
        this.idplaneta = idplaneta;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }
    
    
    
}
