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
public class PersonaDTO implements Serializable{
    private String nombre;
    private String telefono;
    private String codigo;
    public PersonaDTO(String nombre, String telefono,String codigo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() { 
        return nombre; 
    }
    
    public String getTelefono() { 
        return telefono; 
    }
}
