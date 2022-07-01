/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ITicket.controller;

import com.ITicket.entity.Conciertos;
import com.ITicket.entity.ITickets;
import com.ITicket.service.IConciertosService;
import com.ITicket.service.IITicketsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author XLight
 */
@Controller
public class ConciertosController {
    @Autowired
    private IConciertosService conciertosService;
    
    @Autowired
    private IITicketsService iticketsService;
    
    @GetMapping("/Conciertos") //cuando reciba esto (localhost/persona) en el navegador va a reconocer que tiene que realizar toda esta accion
    public String index (Model model){
        List<Conciertos> listaConciertos = conciertosService.getAllConciertos();
        model.addAttribute("titulo","Tabla Conciertos");
        model.addAttribute("Conciertos",listaConciertos);
        return "Conciertos";
    }

    @GetMapping("/ConciertosN")
    public String crearConciertos (Model model){
        List<ITickets> listaITickets = iticketsService.ListITickets();
        model.addAttribute("Conciertos",new Conciertos());
        model.addAttribute("ITickets",listaITickets);
        return "crear";
    }
    
    @PostMapping("/save")
    public String guardarVerduras (@ModelAttribute Conciertos Conciertos){
        conciertosService.saveConciertos(Conciertos); //con esto lo guardo en mi base de datos
        return "redirect:/Conciertos";
    }
    
     @GetMapping("/editConciertos/{id}")
    public String editarVerduras (@PathVariable("id") Long idVerduras, Model model){
        Conciertos Conciertos = conciertosService.getConciertosById(idVerduras);
        List<ITickets> listaITickets = iticketsService.ListITickets();
        model.addAttribute("verduras",Conciertos);
        model.addAttribute("verdulerias",listaITickets);
        return "crear";
    }
    
    @GetMapping("/delete/{id}")
    public String eliminarVerduras (@PathVariable("id") Long idVerduras){
        conciertosService.delete(idVerduras);
        return "redirect:/verduras";
    }
}
