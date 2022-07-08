package com.generationg1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.generationg1.models.Paciente;
import com.generationg1.services.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @RequestMapping("")
    public String inicio(@ModelAttribute("paciente") Paciente paciente) {

        return "registroPaciente.jsp";
    }

    @PostMapping("registro")
    public String guardarPaciente(@Valid @ModelAttribute("paciente") Paciente paciente,
                              BindingResult resultado,
                              Model model) {


        if(resultado.hasErrors()) {
            model.addAttribute("msgError","Datos erroneos");
            return "registroPaciente.jsp";
        }else {
            //enviamos el obeto a persistir en base datos
            pacienteService.guardarPaciente(paciente);
            //obtener una lista de Pacientes
            List<Paciente> listaPacientes = pacienteService.findAll();
            //pasamos la lista de Pacientes al jsp
            model.addAttribute("pacientesCapturados", listaPacientes);
            return "mostrarPaciente.jsp";
        }
    }

    //solo mostrar el listado de Pacientes
    @RequestMapping("/mostrar")
    public String mostrar(Model model) {
        //obtener una lista de Pacientes
        List<Paciente> listaPacientes = pacienteService.findAll();
        //pasamos la lista de Pacientes al jsp
        model.addAttribute("pacientesCapturados", listaPacientes);
        return "mostrarPaciente.jsp";
    }

    @RequestMapping("/editar/{id}") //editar para el despliegue
    public String editar(@PathVariable("id") Long id,
                         Model model) {
        System.out.println("el id es: "+id);

        Paciente paciente = pacienteService.buscarId(id);
        model.addAttribute("paciente", paciente);//pasar al jsp

        return "editarPaciente.jsp";//redireccionar a otra url o path
    }

    //localhost:8080/Paciente/actualizar/{id} -> //actualizar para la persistencia en la bd

    @PostMapping("actualizar/{id}")
    public String actualizarPaciente(@PathVariable("id") Long id,@Valid @ModelAttribute("paciente") Paciente paciente,
                                 BindingResult resultado,
                                 Model model) {
        System.out.println("el id al actualizar es: "+id +" getId "+paciente.getId());


        if(resultado.hasErrors()) {
            model.addAttribute("msgError","Datos erroneos");
            return "editarPaciente.jsp";
        }else {
            paciente.setId(id); //-> agregar el id al objeto

            //enviamos el obeto a persistir en base datos
            pacienteService.guardarPaciente(paciente);

            return "redirect:/paciente/mostrar";
        }
    }

    @RequestMapping("eliminar/{id}")
    public String eliminarPaciente(@PathVariable("id") Long id) {

        pacienteService.eliminarPorId(id);

        return "redirect:/paciente/mostrar";

    }
    /*@PostMapping("/buscar")
    public String buscar(@RequestParam(value="nombre") String nombre, Model model ) {

        List<Paciente> listaPacientes = pacienteService.buscarNombre(nombre);
        model.addAttribute("pacientesCapturados", listaPacientes);
        return "mostrarPacientes.jsp";
    }*/

    /*@RequestMapping("/pagina/{numeroPagina}")
    public String paginarPacientes(@PathVariable("numeroPagina") int numeroPagina, Model model) {

        //los iterables siempre empiezan con el indice cero (0)
        Page<Paciente> listaPacientes = pacienteService.paginarPacientes(numeroPagina - 1);

        model.addAttribute("pacientesCapturados", listaPacientes);
        //TotalPages= total_elementos / LOTE;
        model.addAttribute("totalPaginas", listaPacientes.getTotalPages());

        return "pacientesPaginados.jsp";
    }*/

    /*@RequestMapping("/editarPacienteAjax") //editar para el despliegue
    public String editaPacienteAjax() {




        return "editarPacienteAjax.jsp";//redireccionar a otra url o path*/
    }



