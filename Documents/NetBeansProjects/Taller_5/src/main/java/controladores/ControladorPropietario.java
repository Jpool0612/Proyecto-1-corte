/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import DAO.PropietarioDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Propietario;

/**
 *
 * @author Jean Pool
 */
public class ControladorPropietario {
      
    private PropietarioDAO daoPropietario;

    public ControladorPropietario() {
        daoPropietario = new PropietarioDAO();
    }

    public boolean guardarPropietario(Propietario propietario) {
        if (propietario == null) {
            return false;
        }
        return daoPropietario.agregarPropietario(propietario);
    }

    public List<Propietario> listarPropietarios() {
        return daoPropietario.obtenerPropietarios();
    }

    public Propietario buscarPropietario(String documento) {
        return daoPropietario.buscarPorDocumento(documento);
    }

    public boolean eliminarPropietario(String documento) {
        return daoPropietario.eliminarPropietario(documento);
    }
    

    private List<Propietario> listaPropietarios = new ArrayList<>(); // Lista principal

    public boolean editarPropietario(Propietario propietarioEditado) {
        for (int i = 0; i < listaPropietarios.size(); i++) {
            Propietario p = listaPropietarios.get(i);
            if (p.getDocumento().equals(propietarioEditado.getDocumento())) {
                listaPropietarios.set(i, propietarioEditado); // Reemplaza con los datos nuevos
                return true;
            }
        }
        return false;
    }
}