package com.generationg1.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generationg1.models.CitaMedica;
import com.generationg1.repositories.CitaMedicaRepository;

@Service
@Transactional
public class CitaMedicaService {
    @Autowired
    CitaMedicaRepository citaMedicaRepository;

    //guardar un citaMedica
    public void guardarCitaMedica(@Valid CitaMedica citaMedica) {
        citaMedicaRepository.save(citaMedica);

    }
    /**obtener una lista de citaMedicas*/
    public List<CitaMedica> findAll() {
        return citaMedicaRepository.findAll();
    }

    public CitaMedica buscarId(Long id) {
        return citaMedicaRepository.findById(id).get();//.get() especifica el tipo de datos que necesitamos
    }

    public void eliminarPorId(Long id) {

        citaMedicaRepository.deleteById(id);
    }
    /*public List<CitaMedica> buscarNombre(String nombre) {
        //llamado a un metodo propio
        //return citaMedicaRepository.buscarNombre(nombre); //Query Tradicional
        return citaMedicaRepository.findAllCitaMedicaNombre(nombre);//Query por objeto
    }

    //PAGINACION
    //variable estatica, cantidad de datos a mostrar por pagina
    private static final int LOTE = 5;
    //deprecado = new PageRequest(...)
    public Page<CitaMedica> paginarCitaMedicas(int numeroPagina){
        PageRequest pageRequest = PageRequest.of(numeroPagina, LOTE,Sort.Direction.DESC,"velocidad");
        //Page<CitaMedica> citaMedicas = citaMedicaRepository.findAll(pageRequest);
        return citaMedicaRepository.findAll(pageRequest);
    }*/


}