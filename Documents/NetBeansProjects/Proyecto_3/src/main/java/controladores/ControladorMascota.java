/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import DAO.MascotasDAO;
import DTO.MascotasDTO;
import excepciones.MascotaNoEncontradaException;
import java.util.ArrayList;
import java.util.List;

public class ControladorMascota {
   
private final MascotasDAO dao;
    private ArrayList<MascotasDTO> listaMascotas;

    public ControladorMascota() {
        this.dao = MascotasDAO.getInstancia();
        this.listaMascotas = dao.listar(); // Cargar la lista inicial desde archivo
    }

    public ArrayList<MascotasDTO> listar() {
        // Siempre se actualiza la lista más reciente
        listaMascotas = dao.listar();
        return listaMascotas;
    }
    public boolean registrarMascota(MascotasDTO dto) {
        try {
            validar(dto);
            dao.guardar(dto);
            listaMascotas =listar();
            System.out.println("Mascota registrada con éxito.");
            return true;
        } catch (Exception e) {
            System.err.println("Error al registrar mascota: " + e.getMessage());
            return false;
        }
    }

    public boolean editarMascota(int id, MascotasDTO mascotaActualizada) {
        try {
            validar(mascotaActualizada);
            return dao.actualizar(id,mascotaActualizada);
        } catch (MascotaNoEncontradaException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarMascota(int id) {
        try {
             return dao.eliminar(id);
            
        } catch (MascotaNoEncontradaException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    public MascotasDTO buscarMascota(int id) {
        try {
            return dao.buscarMascotaPorId(id);
        } catch (MascotaNoEncontradaException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public List<MascotasDTO> listarMascotas() {
        return dao.listar();
    }
    
    private void validar(MascotasDTO dto) {
        if (dto.getId() <= 0){
            throw new IllegalArgumentException("El Id es invalido.");
        }
        if (dto.getNombre() == null || dto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
            }
        if (dto.getEspecie() == null || dto.getEspecie().isBlank()) {
            throw new IllegalArgumentException("La especie no puede estar vacía.");
        }
        
        if (dto.getEdad() < 0) {
            throw new IllegalArgumentException("Edad inválida.");
        }
        if (dto.getDocumentoPropietario() == null || dto.getDocumentoPropietario().isBlank()){
            throw new IllegalArgumentException("El documento es invalido");
        }
        
    }
}