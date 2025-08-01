/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Jean Pool
 */
import java.util.Date;

public class VacunaDTO {
    private String nombre;
    private Date fecha;

    public VacunaDTO(String nombre, Date fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre; 
    }
    public Date getFecha() {
        return fecha;
    }
}
