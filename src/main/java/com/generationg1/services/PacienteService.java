package com.generationg1.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.generationg1.models.Paciente;
import com.generationg1.repositories.PacienteRepository;

@Service
@Transactional
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    //guardar un paciente
    public void guardarPaciente(@Valid Paciente paciente) {
        pacienteRepository.save(paciente);

    }
    /**obtener una lista de pacientes*/
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarId(Long id) {
        return pacienteRepository.findById(id).get();//.get() especifica el tipo de datos que necesitamos
    }

    public void eliminarPorId(Long id) {

        pacienteRepository.deleteById(id);
    }
    /*public List<Paciente> buscarNombre(String nombre) {
        //llamado a un metodo propio
        //return pacienteRepository.buscarNombre(nombre); //Query Tradicional
        return pacienteRepository.findAllPacienteNombre(nombre);//Query por objeto
    }

    //PAGINACION
    //variable estatica, cantidad de datos a mostrar por pagina
    private static final int LOTE = 5;
    //deprecado = new PageRequest(...)
    public Page<Paciente> paginarPacientes(int numeroPagina){
        PageRequest pageRequest = PageRequest.of(numeroPagina, LOTE,Sort.Direction.DESC,"velocidad");
        //Page<Paciente> pacientes = pacienteRepository.findAll(pageRequest);
        return pacienteRepository.findAll(pageRequest);
    }*/


}