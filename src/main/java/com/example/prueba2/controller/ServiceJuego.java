package com.example.prueba2.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ServiceJuego {
    List<String> animales = new ArrayList<>(Arrays.asList("leon",
            "elefante", "tigre", "cebra", "jirafa", "delfin", "ballena", "gorila", "panda",
            "guila", "hipopotamo", "koala", "lobo", "oso", "canguro"));
    List<String> frutas = new ArrayList<>(Arrays.asList("manzana", "platano", "kiwi",
            "mango", "pera", "uva", "fresa", "naranja", "piña", "sandía",
            "cereza", "melon", "papaya", "limon", "higo"));
    List<String> paises = new ArrayList<>(Arrays.asList("Mexico", "Canada", "Brasil"
            , "España", "Francia", "Italia", "Alemania", "Japon",
            "Australia", "Argentina", "Chile", "Peru", "Estados Unidos", "China", "India"));

    public String seleccionarPalabra( String tema, int longitud){
          List<String> lista;
          switch (tema){
              case "animales": {
                  lista = animales;
                  break;
              }
              case "frutas":{
                  lista = frutas;
                  break;
              }
              case "paises":{
                  lista = paises;
                  break;
              }
              default:{
                  lista = new ArrayList<>();
              }
          }
         List<String> palabrasFiltradas = new ArrayList<>();
          for(String palabra : lista){
              if (palabra.length()== longitud){
                  palabrasFiltradas.add(palabra);
              }
          }
          if (palabrasFiltradas.isEmpty()){
              return "No hay palabras con esa longitud";
          }
          else {
             return getRandomWord(palabrasFiltradas);
          }
    }


    public List<String> getAnimales() {
        return animales;
    }

    public List<String> getFrutas() {
        return frutas;
    }

    public List<String> getPaises() {
        return paises;
    }

    public String getRandomWord(List<String> lista){
        Random random = new Random();
        return lista.get(random.nextInt(lista.size()));
    }
}
