/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;    
    private String  descripcionE;

    //constructores

    public Educacion() {
    }

    public Educacion(String NombredeEducacion, String descripcionE) {
        this.nombreE = NombredeEducacion;
        this.descripcionE = descripcionE;
    }
    
 //getter y setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombredeEducacion() {
        return nombreE;
    }

    public void setNombreE(String NombredeEducacion) {
        this.nombreE = NombredeEducacion;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }      
   
    }   

