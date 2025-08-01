/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author Jean Pool
 */
public class MascotasDTO implements Serializable{
    private int id;
    private String nombre;
    private String especie;
    private int edad;
    private String documentoPropietario;

    public MascotasDTO(String nombre, String especie, int edad, String documentoPropietario, int id) {
        setNombre(nombre);
        setEspecie(especie);
        setEdad(edad);
        setDocumentoPropietario(documentoPropietario);
        setId(id);
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDocumentoPropietario() {
        return documentoPropietario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDocumentoPropietario(String documentoPropietario) {
        this.documentoPropietario = documentoPropietario;
    }
    
    
}
