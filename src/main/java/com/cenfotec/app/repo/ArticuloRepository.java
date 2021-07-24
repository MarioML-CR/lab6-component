package com.cenfotec.app.repo;

import com.cenfotec.app.domian.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}
