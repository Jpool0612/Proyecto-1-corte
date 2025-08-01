/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import excepciones.PersonaNoValidoException;
import java.util.ArrayList;
import DTO.PersonaDTO;
import persistencia.GestorPersistencia;
/**
 *
 * @author Jean Pool
 */


public class PersonaDAO {
 private final String ruta = "data/personas.dat";
    private final GestorPersistencia gestor = GestorPersistencia.getInstance();

    public PersonaDAO() {
    }

    private static PersonaDAO instancia;
    
    public static PersonaDAO getInstancia(){
         if(instancia == null){
             instancia = new PersonaDAO();
         }
         return instancia;
    }
    
    public boolean guardarPersona(PersonaDTO persona) {
        ArrayList<PersonaDTO> lista = listar();
        lista.add(persona);
       gestor.guardarLista(ruta, lista);
       return true;
    }
   

    public ArrayList<PersonaDTO> listar() {
        ArrayList<PersonaDTO> lista = gestor.cargarLista(ruta);
        return lista != null ? lista : new ArrayList<>();
    }

    public boolean eliminarPersona(String codigo) {
        ArrayList<PersonaDTO> lista = listar();
         for (int i = 0; i < lista.size(); i++){
        if (lista.get(i).getCodigo().equals(codigo)) {
            lista.remove(i);
            gestor.guardarLista(ruta, lista);
            return true;
        }
         }
        throw new PersonaNoValidoException("La persona con codigo " + codigo + " no se pudo eliminar.");
    }
     
    public PersonaDTO buscarPersonaPorCodigo(String codigo) {
        ArrayList<PersonaDTO> lista = listar();
        for (PersonaDTO m : lista) {
            if (m.getCodigo().equals(codigo) ) {  
                return m;
            }
        }  
        throw new PersonaNoValidoException("La persona con codigo " + codigo + " no fue encontrada.");
    }

    public boolean actualizarPersona(String codigo, PersonaDTO persona) {
        ArrayList<PersonaDTO> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCodigo().equals(codigo)) {
                lista.set(i, persona);
                gestor.guardarLista(ruta, lista);
                return true;
            }
        }
        return false;
    }
}