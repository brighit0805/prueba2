package com.example.prueba2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerJuego {
    ServiceJuego serviceJuego = new ServiceJuego();
@GetMapping("/configuracion")
    public  String config (Model model){
    model.addAttribute("error","");
    return "configuracion";
}
@PostMapping ("/configuracionJuego")
    public String configuracionJuego(@RequestParam ("longitud") Integer longitud,
                                     @RequestParam("intentos") Integer intentos,
                                     @RequestParam("tema") String tema, Model model){
    System.out.println("La longitud es"+longitud+ "los intentos son:" +intentos+ "y el tema" +tema);
    String palabra = serviceJuego.seleccionarPalabra(tema, longitud);
    System.out.println(palabra);
    if(palabra.equals("No hay palabras con esa longitud")){
        model.addAttribute("error", "No hay palabra existente");
        return "configuracion";
    }else{
        model.addAttribute("error","");
        return "configuracion";
    }

}



}
