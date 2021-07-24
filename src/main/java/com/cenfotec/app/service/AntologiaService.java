package com.cenfotec.app.service;

import com.cenfotec.app.domian.Antologia;
import com.cenfotec.app.domian.Articulo;

import java.util.List;
import java.util.Optional;

public interface AntologiaService {
    public void save(Antologia antologia);
    public void saveArticulo(Articulo articulo, Long idAntologia);
    public Optional<Antologia> get(Long id);
    public List<Antologia> getAll();
    public List<Antologia> find(String nombre);

}
