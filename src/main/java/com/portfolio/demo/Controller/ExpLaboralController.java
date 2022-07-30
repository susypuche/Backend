
package com.portfolio.demo.Controller;




import com.portfolio.demo.Dto.dtoExpLaboral;
import com.portfolio.demo.Entity.ExpLaboral;
import com.portfolio.demo.Security.Controller.Mensaje;
import com.portfolio.demo.Service.ImpExpLaboralService;
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
@RequestMapping("ExpLaboral")
@CrossOrigin (origins = "http://localhost:4200")
public class ExpLaboralController {
  @Autowired 
  ImpExpLaboralService impExpLaboralService;
  
  @GetMapping("/lista")
  public ResponseEntity<List<ExpLaboral>> list(){
     List<ExpLaboral> list = impExpLaboralService.list();
     return new ResponseEntity(list, HttpStatus.OK);
  }
  
  @PostMapping("/create")
  public ResponseEntity<?> create(@RequestBody dtoExpLaboral dtoexp){
    if(StringUtils.isBlank(dtoexp.getNombreE())) 
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    if(impExpLaboralService.existsByNombreE(dtoexp.getNombreE()))
        return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
    
    ExpLaboral explaboral = new ExpLaboral(dtoexp.getNombreE(), dtoexp.getDescripcionE());
    impExpLaboralService.save(explaboral);
    
    return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
  }
  
  
  @PutMapping("/update/{id}")
  public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExpLaboral dtoexp) { 
      //validamos si ya existe el ID
      if(!impExpLaboralService.existsById(id))
          return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
      //compara nombre de experiencias
      if(impExpLaboralService.existsByNombreE(dtoexp.getNombreE()) && impExpLaboralService.getByNombreE(dtoexp.getNombreE()).get().getId() != id)
      return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
      //No puede estar vacio
      if(StringUtils.isBlank(dtoexp.getNombreE()))
          return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
      
       ExpLaboral explaboral = impExpLaboralService.getOne(id).get();
       explaboral.setNombreE(dtoexp.getNombreE());
       explaboral.setDescripcionE((dtoexp.getDescripcionE()));
       
      impExpLaboralService.save(explaboral);
      return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
  }
  
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //validamos si existe el ID
        if(!impExpLaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        impExpLaboralService.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}