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

public class Consulta implements Serializable {
    private String idConsulta;
    private String idMascota;
    private String descripcion;
    private Veterinario veterinario;

    public Consulta(String idConsulta, String idMascota, String descripcion, Veterinario veterinario) {
        this.idConsulta = idConsulta;
        this.idMascota = idMascota;
        this.descripcion = descripcion;
        this.veterinario = veterinario;
    }

    public String getIdConsulta() { 
        return idConsulta;
    }
    public String getIdMascota() {
        return idMascota; 
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Veterinario getVeterinario() {
        return veterinario; 
    }
}