/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jean pool
 */

public class Propietario extends Persona {
    private String documento;
 
    public Propietario(String nombre, String documento, String telefono, String codigo) {
        super( nombre, telefono, codigo);
        setDocumento(documento);
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getTipoPersona() {
        return "Propietario";
    }

    public String getTelefono() {
        return telefono;
    }
}
