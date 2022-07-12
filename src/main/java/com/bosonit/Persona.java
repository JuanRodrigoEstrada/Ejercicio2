package com.bosonit;

import java.lang.String;
import java.util.stream.*;
import java.util.List;
import java.util.*;

public class Persona{


    public  Integer edad;
    public  String nombre;
    public  String poblacion;

    public static int Linea=0;

    public Persona(String nombre, String poblacion, Integer edad) {
        this.edad = edad;
        this.nombre = nombre;
        this.poblacion =poblacion;




    }
    @Override
    public String toString(){
        Linea++;
        String Salida = "";
        Salida += " Linea:" + Linea + " nombre: " + nombre;
        Optional<String>opt = Optional.ofNullable(poblacion);
        if(!opt.isPresent()){
            Salida += " Poblacion:desconocida";

        }
        else{
            Salida+=" Poblacion: " + poblacion;

        }
        Optional<Integer>optedad = Optional.ofNullable(edad);
        if(!optedad.isPresent()){
            Salida += "Edad: desconocida";
        }
        else{
            Salida += " Edad: " + edad;
        }
        return Salida;
    }
    public static void main(String[] args) {
        Persona p1 = new Persona("Jesus", "Logroño", 41);
        Persona p2 = new Persona("Andres", "Madrid", 19);
        Persona p3 = new Persona("Angel Mari", "valencia", null);
        Persona p4 = new Persona("Laura Saenz", null, 23);
        Persona p5 = new Persona("Maria Calvo", null, 38);

        List<Persona> Personas = new ArrayList<Persona>();
        Personas.add(p1);
        Personas.add(p2);
        Personas.add(p3);
        Personas.add(p4);
        Personas.add(p5);

        List<Persona> Listafiltrada = Personas.stream()
                .filter(persona->Objects.nonNull(persona.edad))
                .filter(persona -> persona.edad < 25)
                .collect(Collectors.toList());
        Listafiltrada.forEach(System.out::println);




    }
}













