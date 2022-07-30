/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.Educacion;
import com.portfolio.demo.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class EducacionService {
    @Autowired
    IEducacionRepository rEducacion;
            
    public List<Educacion> list() {
          return rEducacion.findAll();
    }

    public Optional <Educacion> getOne(int id) {
        return rEducacion.findById(id);
    }

    public Optional<Educacion> getByNombreE(String nombreE) {
        return rEducacion.findByNombreE(nombreE);
    }

    public void save(Educacion exp) {
        rEducacion.save(exp);
    }
    
    public void delete(int id) {
        rEducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    public boolean existsByNombreE(String nombreE) {
        return rEducacion.existsByNombreE(nombreE);
    }
    
}    

