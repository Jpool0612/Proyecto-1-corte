/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Jean Pool
 */
public class VeterinarioDTO extends PersonaDTO{
    private String especialidad;

    public VeterinarioDTO( String nombre, String especialidad,String telefono,String codigo) {
        super( nombre,telefono, codigo);
        setEspecialidad(especialidad);
    }

    public String getTipoPersona() {
        return "Veterinario"; // Se selecciona que tipo de persona es
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
   