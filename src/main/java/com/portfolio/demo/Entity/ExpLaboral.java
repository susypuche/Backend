/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import lombok.Getter;
//import lombok.Setter;


@Entity

public class ExpLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;    
    private String  descripcionE;

    //constructores

    public ExpLaboral() {
    }

    public ExpLaboral(String NombredeEmpresa, String descripcionE) {
        this.nombreE = NombredeEmpresa;
        this.descripcionE = descripcionE;
    }
    
 //getter y setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombredeEmpresa() {
        return nombreE;
    }

    public void setNombreE(String NombredeEmpresa) {
        this.nombreE = NombredeEmpresa;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }      
   
    }



