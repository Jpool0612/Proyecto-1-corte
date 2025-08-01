/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Jean Pool
 */
public class PropietarioDTO extends PersonaDTO{

    public PropietarioDTO( String nombre, String documento, String telefono) {
        super( nombre, telefono,documento);
    }

 
    
    public String getTipoPersona() {
        return "Propietario";
    }
} 
