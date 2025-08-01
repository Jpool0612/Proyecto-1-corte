/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 *
 * @author Jean pool
 */

import DAO.ConsultaDAO;
import DTO.ConsultaDTO;
import excepciones.ConsultaInvalidaException;
import excepciones.MascotaNoEncontradaException;
import java.util.ArrayList;
import java.util.List;

public class ControladorConsulta {

    private final ConsultaDAO dao;
    private ArrayList<ConsultaDTO> listaConsultas;

    public ControladorConsulta() {
        this.dao = ConsultaDAO.getInstancia();
        this.listaConsultas = dao.listar(); // Cargar la lista inicial desde archivo
    }

    public ArrayList<ConsultaDTO> listar() {
        // Siempre se actualiza la lista más reciente
        listaConsultas = dao.listar();
        return listaConsultas;
    }
    public boolean registrarConsulta(ConsultaDTO dto) {
        try {
            validar(dto);
            dao.guardarConsultas(dto);
            listaConsultas =listar();
            System.out.println("Consulta registrada con éxito.");
            return true;
        } catch (Exception e) {
            System.err.println("Error al registrar consulta: " + e.getMessage());
            return false;
        }
    }

    public boolean editarConsulta(String codigo, ConsultaDTO consulta) {
        try {
            validar(consulta);
            return dao.actualizar(codigo,consulta);
        } catch (ConsultaInvalidaException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarConsulta(String codigo) {
        try {
            return dao.eliminarConsulta(codigo);
        } catch (ConsultaInvalidaException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    public ConsultaDTO buscarConsulta(String codigo) {
        try {
            return dao.buscarConsultaPorCodigo(codigo);
        } catch (MascotaNoEncontradaException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public List<ConsultaDTO> listarMascotas() {
        return dao.listar();
    }
    
  private void validar(ConsultaDTO dto) {
    if (dto.getCodigo() == null || dto.getCodigo().isBlank()) {
        throw new IllegalArgumentException("El código no puede estar vacío.");
    }
    if (dto.getFecha() == null) {
        throw new IllegalArgumentException("La fecha no puede ser nula.");
    }
    if (dto.getMotivo() == null || dto.getMotivo().isBlank()) {
        throw new IllegalArgumentException("El motivo no puede estar vacío.");
    }
}

    }
   /* private ConsultaDAO dao = new ConsultaDAO();
    private Veterinario veterinario;

    public ControladorConsulta() {
        this.veterinario = new Veterinario("VET001", "Dr. Carlos Ruiz", "1032456789", "Cirugía"); // veterinario predefinido
    }

    public void registrarConsulta(String idConsulta, String idMascota, String descripcion) throws CampoVacioException {
        if (idConsulta.isEmpty()) throw new CampoVacioException("ID Consulta");
        if (idMascota.isEmpty()) throw new CampoVacioException("ID Mascota");
        if (descripcion.isEmpty()) throw new CampoVacioException("Descripción");

        Consulta consulta = new Consulta(idConsulta, idMascota, descripcion, veterinario);
        try {
            dao.guardarConsulta(consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
