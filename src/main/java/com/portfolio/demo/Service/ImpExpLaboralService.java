
package com.portfolio.demo.Service;

import com.portfolio.demo.Entity.ExpLaboral;
import com.portfolio.demo.Repository.IExpLaboralRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpExpLaboralService {
    @Autowired
    IExpLaboralRepository rExpLaboral;
            
    public List<ExpLaboral> list() {
          return rExpLaboral.findAll();
    }

    public Optional <ExpLaboral> getOne(int id) {
        return rExpLaboral.findById(id);
    }

    public Optional<ExpLaboral> getByNombreE(String nombreE) {
        return rExpLaboral.findByNombreE(nombreE);
    }

    public void save(ExpLaboral exp) {
        rExpLaboral.save(exp);
    }
    
    public void delete(int id) {
        rExpLaboral.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExpLaboral.existsById(id);
    }
    public boolean existsByNombreE(String nombreE) {
        return rExpLaboral.existsByNombreE(nombreE);
    }
    
}
 