package com.cenfotec.app.service;

import com.cenfotec.app.domian.Antologia;
import com.cenfotec.app.domian.Articulo;
import com.cenfotec.app.repo.AntologiaRepository;
import com.cenfotec.app.repo.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AntologiaServiceImpl implements AntologiaService {

    @Autowired
    AntologiaRepository antologiaRepository;
    @Autowired
    ArticuloRepository articuloRepository;

    @Override
    public void save(Antologia antologia) {
        antologiaRepository.save(antologia);
    }

    @Override
    public void saveArticulo(Articulo articulo, Long idAntologia) {
        Antologia antologia = antologiaRepository.getById(idAntologia);
        articulo.setAntologia(antologia);
        articuloRepository.save(articulo);
    }

    @Override
    public Optional<Antologia> get(Long id) {
        return antologiaRepository.findById(id);
    }

    @Override
    public List<Antologia> getAll() {
        return antologiaRepository.findAll();
    }

    @Override
    public List<Antologia> find(String nombre) {
        return antologiaRepository.findByNombreContaining(nombre);
    }
}
