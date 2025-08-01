/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Jean Pool
 */
public class Historial {

  private ArrayList<Consulta> consultas;

    public Historial() {
        this.consultas = new ArrayList<>();
    }

    public void agregarConsulta(Consulta consulta) {
        if (consulta != null) {
            consultas.add(consulta);
        }
    }

    public ArrayList<Consulta> getConsultas() {
        return new ArrayList<>(consultas);
    }
}

