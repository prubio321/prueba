package com.generationg1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generationg1.models.CitaMedica;
import com.generationg1.models.Paciente;
import com.generationg1.services.CitaMedicaService;
import com.generationg1.services.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    @Autowired//inyeccion de dependencia de clase
    PacienteService pacienteService;


    @RequestMapping("/obtener/pacientes")
    public List<Paciente> obtenerListaPacientes(){
        List<Paciente> listaPacientes = pacienteService.findAll();
        return listaPacientes;
    }

    @Autowired//inyeccion de dependencia de clase
    CitaMedicaService citaMedicaService;


    @RequestMapping("/obtener/citamedicas")
    public List<CitaMedica> obtenerListaCitaMedicas(){
        List<CitaMedica> listaCitaMedica = citaMedicaService.findAll();
        return listaCitaMedica;
    }
    
    //API (JSON)..
}
