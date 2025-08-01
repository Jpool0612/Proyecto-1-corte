/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jean Pool
 */

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class IdGenerator implements Serializable {

    private static final long serialVersionUID = 1L;
    private static IdGenerator instancia;
    private static final String ARCHIVO = "data/idgenerator.dat";
    private Map<String, Integer> mapaIDs;

    private IdGenerator() {
        mapaIDs = new HashMap<>();
    }

    public static IdGenerator getInstancia() {
        if (instancia == null) {
            instancia = cargarDesdeArchivo();
        }
        return instancia;
    }

    public synchronized int generarID(String clase) {
        int nuevoID = mapaIDs.getOrDefault(clase, 0) + 1;
        mapaIDs.put(clase, nuevoID);
        guardarEnArchivo();
        return nuevoID;
    }

    private static IdGenerator cargarDesdeArchivo() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            return new IdGenerator();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (IdGenerator) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error cargando IDGenerator: " + e.getMessage());
            return new IdGenerator();
        }
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.err.println("Error guardando IDGenerator: " + e.getMessage());
        }
    }
}


