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

import com.generationg1.models.CitaMedica;
import com.generationg1.services.CitaMedicaService;

@Controller
@RequestMapping("/citaMedica")
public class CitaMedicaController {
    @Autowired
    CitaMedicaService citaMedicaService;

    @RequestMapping("")
    public String inicio(@ModelAttribute("citaMedica") CitaMedica citaMedica) {

        return "registroCitaMedica.jsp";
    }

    @PostMapping("registro")
    public String guardarCitaMedica(@Valid @ModelAttribute("citaMedica") CitaMedica citaMedica,
                              BindingResult resultado,
                              Model model) {


        if(resultado.hasErrors()) {
            model.addAttribute("msgError","Datos erroneos");
            return "registroCitaMedica.jsp";
        }else {
            //enviamos el obeto a persistir en base datos
            citaMedicaService.guardarCitaMedica(citaMedica);
            //obtener una lista de CitaMedicas
            List<CitaMedica> listaCitaMedicas = citaMedicaService.findAll();
            //pasamos la lista de CitaMedicas al jsp
            model.addAttribute("citaMedicasCapturados", listaCitaMedicas);
            return "mostrarCitaMedica.jsp";
        }
    }

    //solo mostrar el listado de CitaMedicas
    @RequestMapping("/mostrar")
    public String mostrar(Model model) {
        //obtener una lista de CitaMedicas
        List<CitaMedica> listaCitaMedicas = citaMedicaService.findAll();
        //pasamos la lista de CitaMedicas al jsp
        model.addAttribute("citaMedicasCapturados", listaCitaMedicas);
        return "mostrarCitaMedica.jsp";
    }

    @RequestMapping("/editar/{id}") //editar para el despliegue
    public String editar(@PathVariable("id") Long id,
                         Model model) {
        System.out.println("el id es: "+id);

        CitaMedica citaMedica = citaMedicaService.buscarId(id);
        model.addAttribute("citaMedica", citaMedica);//pasar al jsp

        return "editarCitaMedica.jsp";//redireccionar a otra url o path
    }

    //localhost:8080/CitaMedica/actualizar/{id} -> //actualizar para la persistencia en la bd

    @PostMapping("actualizar/{id}")
    public String actualizarCitaMedica(@PathVariable("id") Long id,@Valid @ModelAttribute("citaMedica") CitaMedica citaMedica,
                                 BindingResult resultado,
                                 Model model) {
        System.out.println("el id al actualizar es: "+id +" getId "+citaMedica.getId());


        if(resultado.hasErrors()) {
            model.addAttribute("msgError","Datos erroneos");
            return "editarCitaMedica.jsp";
        }else {
            citaMedica.setId(id); //-> agregar el id al objeto

            //enviamos el obeto a persistir en base datos
            citaMedicaService.guardarCitaMedica(citaMedica);

            return "redirect:/citaMedica/mostrar";
        }
    }

    @RequestMapping("eliminar/{id}")
    public String eliminarCitaMedica(@PathVariable("id") Long id) {

        citaMedicaService.eliminarPorId(id);

        return "redirect:/citaMedica/mostrar";

    }
    /*@PostMapping("/buscar")
    public String buscar(@RequestParam(value="nombre") String nombre, Model model ) {

        List<CitaMedica> listaCitaMedicas = citaMedicaService.buscarNombre(nombre);
        model.addAttribute("citaMedicasCapturados", listaCitaMedicas);
        return "mostrarCitaMedicas.jsp";
    }*/

    /*@RequestMapping("/pagina/{numeroPagina}")
    public String paginarCitaMedicas(@PathVariable("numeroPagina") int numeroPagina, Model model) {

        //los iterables siempre empiezan con el indice cero (0)
        Page<CitaMedica> listaCitaMedicas = citaMedicaService.paginarCitaMedicas(numeroPagina - 1);

        model.addAttribute("citaMedicasCapturados", listaCitaMedicas);
        //TotalPages= total_elementos / LOTE;
        model.addAttribute("totalPaginas", listaCitaMedicas.getTotalPages());

        return "citaMedicasPaginados.jsp";
    }*/

    /*@RequestMapping("/editarCitaMedicaAjax") //editar para el despliegue
    public String editaCitaMedicaAjax() {




        return "editarCitaMedicaAjax.jsp";//redireccionar a otra url o path*/
    }



