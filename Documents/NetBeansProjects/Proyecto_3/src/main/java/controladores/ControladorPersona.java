/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import DAO.PersonaDAO;
import DTO.PersonaDTO;
import excepciones.PersonaNoValidoException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jean Pool
 */
public class ControladorPersona {


    private final PersonaDAO dao;
    private ArrayList<PersonaDTO> listaPersonas;

    public ControladorPersona() {
        this.dao = PersonaDAO.getInstancia();
        this.listaPersonas = dao.listar(); // Cargar la lista inicial desde archivo
    }

    public ArrayList<PersonaDTO> listar() {
        // Siempre se actualiza la lista más reciente
        listaPersonas = dao.listar();
        return listaPersonas;
    }
    public boolean registrarPersona(PersonaDTO dto) {
        
        try {
            validar(dto);
            dao.guardarPersona(dto);
            listaPersonas =listar();
            System.out.println("Persona registrada con éxito.");
            return true;
        } catch (Exception e) {
            System.err.println("Error al registrar persona: " + e.getMessage());
            return false;
        }
    }

    public boolean editarPersona(String codigo, PersonaDTO persona) {
        try {
            validar(persona);
            return dao.actualizarPersona(codigo,persona);
        } catch (PersonaNoValidoException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarPersona(String codigo) {
        try {
            return dao.eliminarPersona(codigo);
        } catch (PersonaNoValidoException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    public PersonaDTO buscarPersona(String codigo) {
        try {
            return dao.buscarPersonaPorCodigo(codigo);
        } catch (PersonaNoValidoException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public List<PersonaDTO> listarMascotas() {
        return dao.listar();
    }
    
private void validar(PersonaDTO dto) {
    if (dto.getNombre() == null || dto.getNombre().isBlank()) {
        throw new IllegalArgumentException("El nombre no puede estar vacío.");
    }
    if (dto.getTelefono() == null || dto.getTelefono().isBlank()) {
        throw new IllegalArgumentException("El teléfono no puede estar vacío.");
    }
    if (dto.getCodigo() == null || dto.getCodigo().isBlank()) {
        throw new IllegalArgumentException("El código no puede estar vacío.");
    }
}

}



