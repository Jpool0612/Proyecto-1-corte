/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;
import modelo.Mascotas;
import DAO.MascotasDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jean Pool
 */

public class ControladorMascota {
    private MascotasDAO daoMascota;

    public ControladorMascota() {
        daoMascota = new MascotasDAO();
    }

    public boolean guardarMascota(Mascotas mascota) {
        if (mascota == null) {
            return false;
        }
        return daoMascota.agregarMascota(mascota);
    }

    public List<Mascotas> listarMascotas() {
        return daoMascota.obtenerMascotas();
    }

    public Mascotas buscarMascotaPorId(int id) {
        return daoMascota.buscarPorId(id);
    }

    public boolean eliminarMascota(int id) {
        return daoMascota.eliminarMascota(id);
    }
    

   private List<Mascotas> listaMascotas = new ArrayList<>(); // Lista principal

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
