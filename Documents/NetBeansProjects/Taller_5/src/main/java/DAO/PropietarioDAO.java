/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import modelo.Propietario;

/**
 *
 * @author Jean Pool
 */
public class PropietarioDAO {
    private List<Propietario> listaPropietarios;

    public PropietarioDAO() {
        listaPropietarios = new ArrayList<>();
    }

    // Agregar propietario
    public boolean agregarPropietario(Propietario propietario) {
        if (propietario == null) {
            return false;
        }

        // Validar que el documento no se repita
        for (Propietario p : listaPropietarios) {
            if (p.getDocumento().equals(propietario.getDocumento())) {
                return false; // Documento ya existe
            }
        }
        listaPropietarios.add(propietario);
        return true;
    }

    // Obtener todos los propietarios
    public List<Propietario> obtenerPropietarios() {
        return new ArrayList<>(listaPropietarios);
    }

    // Buscar propietario por documento
    public Propietario buscarPorDocumento(String documento) {
        for (Propietario p : listaPropietarios) {
            if (p.getDocumento().equals(documento)) {
                return p;
            }
        }
        return null;
    }

    // Eliminar propietario por documento
    public boolean eliminarPropietario(String documento) {
        Propietario prop = buscarPorDocumento(documento);
        if (prop != null) {
            listaPropietarios.remove(prop);
            return true;
        }
        return false;
    }
}