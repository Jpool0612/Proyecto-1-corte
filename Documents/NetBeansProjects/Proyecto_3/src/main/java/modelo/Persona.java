/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jean Pool
 */
import java.io.Serializable;

public abstract class Persona implements Serializable {
    protected String telefono;
    protected String nombre;
    private String codigo;

    public Persona( String nombre, String telefono, String codigo) {
        this.nombre = nombre;
        this.codigo= codigo;
        this.telefono = telefono;
    }

    public abstract String getTipoPersona(); // Aqui se aplica el Polimorfismo

    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getCodigo() { return codigo; }
}
