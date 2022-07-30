
package com.portfolio.demo.Repository;

import com.portfolio.demo.Entity.ExpLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IExpLaboralRepository extends JpaRepository<ExpLaboral, Integer> {
   public Optional<ExpLaboral> findByNombreE(String nombreE);
   public boolean existsByNombreE(String nombreE);
}
