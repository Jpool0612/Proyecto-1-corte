/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excepciones.EdadInvalidaExcepcion;
import excepciones.NombreVacioExcepcion;
import excepciones.NombreCortoExcepcion;
/**
 *
 * @author Jen pool
 */
public class Mascotas {
    private String nombre;
    private int edad;

    public Mascotas(String nombre, int edad) {
        // Validar nombre no vacío
        if (nombre == null || nombre.isBlank()) {
            throw new NombreVacioExcepcion("El nombre no puede estar vacío.");
        }
        if(nombre.length()<=3){
            throw new NombreCortoExcepcion("El nombre no puede puedes tener menos de 3 carcateres");
        }       
        
       
        // Validar edad no negativa
        if (edad < 0) {
            throw new EdadInvalidaExcepcion("La edad no puede ser negativa.");
        }

        this.nombre = nombre;
        this.edad = edad;
    }

    public void mostrar() {
        System.out.println("Mascota: " + nombre + ", Edad: " + edad);
    }
}


