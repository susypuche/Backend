/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.demo.Controller;

import com.portfolio.demo.Dto.dtoEducacion;
import com.portfolio.demo.Entity.Educacion;
import com.portfolio.demo.Security.Controller.Mensaje;
import com.portfolio.demo.Service.EducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Educacion")
@CrossOrigin (origins = "http://localhost:4200")
public class EducacionController {
  @Autowired 
  EducacionService educacionService;
  
  @GetMapping("/lista")
  public ResponseEntity<List<Educacion>> list(){
     List<Educacion> list = educacionService.list();
     return new ResponseEntity(list, HttpStatus.OK);
  }
  
  @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu){
    if(StringUtils.isBlank(dtoedu.getNombreE())) {
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    }
    if(educacionService.existsByNombreE(dtoedu.getNombreE())){
        return new ResponseEntity(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);
    }
    Educacion educacion = new Educacion(dtoedu.getNombreE(), dtoedu.getDescripcionE());
    educacionService.save(educacion);
    
    return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
  }
  
  
  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoexp) { 
      //validamos si ya existe el ID
      if(!educacionService.existsById(id)){
          return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
      }
      //compara nombre de educacion
      if(educacionService.existsByNombreE(dtoexp.getNombreE()) && educacionService.getByNombreE(dtoexp.getNombreE()).get().getId() != id){
           return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
      }
      //No puede estar vacio
      if(StringUtils.isBlank(dtoexp.getNombreE()))
          return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
      
       Educacion educacion = educacionService.getOne(id).get();
       educacion.setNombreE(dtoexp.getNombreE());
       educacion.setDescripcionE((dtoexp.getDescripcionE()));
       
      educacionService.save(educacion);
      return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
  }
  
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //validamos si existe el ID
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        educacionService.delete(id);
        
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
}    

