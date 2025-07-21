/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import modelo.Historial;
import DTO.MascotasDTO;
import java.util.ArrayList;
import java.util.List;
import modelo.Consulta;
import modelo.Mascotas;

/**
 *
 * @author MI PC
 */
public class MascotasDAO {
    
    
    private List<Mascotas> listaMascotas;

    public MascotasDAO() {
        listaMascotas = new ArrayList<>();
    }

    // Agregar una nueva mascota
    public boolean agregarMascota(Mascotas mascota) {
        if (mascota == null) {
            return false;
        }

        // Validar que el ID no se repita
        for (Mascotas m : listaMascotas) {
            if (m.getId() == mascota.getId()) {
                return false; // ID ya existe
            }
        }
        listaMascotas.add(mascota);
        return true;
    }

    // Obtener todas las mascotas
    public List<Mascotas> obtenerMascotas() {
        return new ArrayList<>(listaMascotas); // Devolver una copia
    }

    // Buscar mascota por ID
    public Mascotas buscarPorId(int id) {
        for (Mascotas m : listaMascotas) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    // Eliminar mascota por ID
    public boolean eliminarMascota(int id) {
        Mascotas mascota = buscarPorId(id);
        if (mascota != null) {
            listaMascotas.remove(mascota);
            return true;
        }
        return false;
    }
    
    

    public boolean editarMascota(Mascotas mascotaEditada) {
        for (int i = 0; i < listaMascotas.size(); i++) {
            Mascotas m = listaMascotas.get(i);
            if (m.getId() == mascotaEditada.getId()) {
                listaMascotas.set(i, mascotaEditada);  // Actualiza directamente la lista
                return true;
            }
        }
        return false;
    }
}