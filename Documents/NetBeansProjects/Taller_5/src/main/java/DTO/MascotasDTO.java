/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import modelo.Historial;

/**
 *
 * @author Jean Pool
 */
public class MascotasDTO {
        private int Id;
    private String nombre;
    private String especie;
    private int edad;
    private Historial historial;
    private String documentoPropietario;

    public MascotasDTO() {
        
        setNombre(nombre);
        setEspecie(especie);
        setEdad(edad);
        setId(Id);
        this.historial = new Historial();
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    // ✅ Nuevos setters con validación
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre inválido.");
        }
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        if (especie == null || especie.isBlank()) {
            throw new IllegalArgumentException("Especie inválida.");
        }
        this.especie = especie;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Edad no puede ser negativa.");
        }
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }
     public String getDocumentoProp() {
        return documentoPropietario;
    }

}
