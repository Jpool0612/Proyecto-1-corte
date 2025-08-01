/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import excepciones.MascotaNoEncontradaException;
import java.util.ArrayList;
import persistencia.GestorPersistencia;
import DTO.MascotasDTO;

/**
 *
 * @author Jean pool
 */
public class MascotasDAO {
    
  private final String ruta = "data/mascotas.dat";
    private final GestorPersistencia gestor = GestorPersistencia.getInstance();

    public MascotasDAO() {
    }

    private static MascotasDAO instancia;
    
    public static MascotasDAO getInstancia(){
         if(instancia == null){
             instancia = new MascotasDAO();
         }
         return instancia;
    }
    
    public boolean guardar(MascotasDTO mascota) {
        ArrayList<MascotasDTO> lista = listar();
        lista.add(mascota);
       gestor.guardarLista(ruta, lista);
       return true;
    }
   

    public ArrayList<MascotasDTO> listar() {
        ArrayList<MascotasDTO> lista = gestor.cargarLista(ruta);
        return lista != null ? lista : new ArrayList<>();
    }

  public boolean eliminar(int id) {
    ArrayList<MascotasDTO> lista = listar();
    for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getId() == id) {
            lista.remove(i);
            gestor.guardarLista(ruta, lista);
            return true; // ✅ eliminó correctamente
        }
    }
    // ❌ Si no lo encontró, lanza la excepción
    throw new MascotaNoEncontradaException("La mascota con Id " + id + " no se pudo eliminar.");
}

    public MascotasDTO buscarMascotaPorId(int id) {
        ArrayList<MascotasDTO> lista = listar();
        for (MascotasDTO m : lista) {
            if (m.getId() == id ) {   // ID es int
                return m;
            }
        }  
        throw new MascotaNoEncontradaException("La mascota con ID " + id + " no fue encontrada.");
    }

    public boolean actualizar(int id, MascotasDTO mascotaActualizada) {
        ArrayList<MascotasDTO> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.set(i, mascotaActualizada);
                gestor.guardarLista(ruta, lista);
                return true;
            }
        }
        return false;
    }
    
}



        
    

 /*   private List<Mascotas> listaMascotas;

    public MascotasDAO() {
        this.listaMascotas = new ArrayList<>();
        archivo = new ArchivoManager("data/mascotas.txt");
    }

    public void agregarMascota(Mascotas mascota) {
        listaMascotas.add(mascota);
        archivo.escribirLinea(mascota.toLineaArchivo());
    }

    public Mascotas buscarMascotaPorId(int id) throws MascotaNoEncontradaException {
        for (Mascotas m : listaMascotas) {
            if (m.getId() == id) {   // ID es int
                return m;
            }
        }
        throw new MascotaNoEncontradaException("La mascota con ID " + id + " no fue encontrada.");
    }

    public List<Mascotas> listarMascotas() {
        List<Mascotas> mascotas = new ArrayList<>();
        for (String linea : archivo.leerLineas()) {
            Mascotas m = (Mascotas) Mascotas.desdeLineaArchivo(linea);
            if (m != null) mascotas.add(m);
        }
        return mascotas;
    }

    public boolean eliminarMascota(int id) throws MascotaNoEncontradaException {
        Mascotas m = buscarMascotaPorId(id);
        boolean removed = listaMascotas.remove(m);
        if (removed) guardarEnArchivo();
        return removed;
        
        
        
    }

    public boolean editarMascota(Mascotas mascotaEditada) throws MascotaNoEncontradaException {
        for (int i = 0; i < listaMascotas.size(); i++) {
            if (listaMascotas.get(i).getId() == mascotaEditada.getId()) {
                listaMascotas.set(i, mascotaEditada);
                sobrescribirArchivo(listaMascotas);
                return true;            }
        }
        throw new MascotaNoEncontradaException("No se puede editar. Mascota con ID " + mascotaEditada.getId() + " no encontrada.");
    }
    
     private void sobrescribirArchivo(List<Mascotas> lista) {
        List<String> lineas = new ArrayList<>();
        for (Mascotas m : lista) {
            lineas.add(m.toLineaArchivo());
        }
        archivo.sobrescribirArchivo(lineas);
    }
     

    private void guardarEnArchivo() {
        List<String> lineas = new ArrayList<>();
        for (Mascotas m : listaMascotas) {
            lineas.add(m.toLineaArchivo());
        }
        archivo.sobrescribirArchivo(lineas);
    }*/

