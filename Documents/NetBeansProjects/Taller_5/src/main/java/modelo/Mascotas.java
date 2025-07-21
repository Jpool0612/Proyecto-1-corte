/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
public class Mascotas {
    private int Id;
    private String nombre;
    private String especie;
    private int edad;
    private Historial historial;
    private String documentoPropietario;

    public Mascotas(String nombre, String especie, int edad, int Id) {
        setNombre(nombre);
        setEspecie(especie);
        setEdad(edad);
        setId(Id);
        this.historial = new Historial();
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void agregarConsulta(Consulta consulta) {
        historial.agregarConsulta(consulta); 
    }

    public void mostrarHistorial() {
        System.out.println("Mascota: " + nombre + " | Especie: " + especie + " | Edad: " + edad + " años");
        System.out.println("Historial de consultas:");
        historial.mostrarConsultas(); 
    }
    
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre inválido.");
        }
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        if (especie == null || especie.isBlank()) {
            throw new IllegalArgumentException("Especie inválida.");
        }
        this.especie = especie;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Edad no puede ser negativa.");
        }
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }
     public String getDocumentoProp() {
        return documentoPropietario;
    }

    public void setDocumentoProp(String documentoProp) {
      if(documentoProp == null || documentoProp.length() < 5){
            throw new IllegalArgumentException("Documento invalido, revise bien su documento");
        }
        this.documentoPropietario = documentoProp;
    }


    
}
