/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Jean pool
 */
public class PersonaNoValidoException extends RuntimeException {
    public PersonaNoValidoException(String mensaje) {
        super(mensaje);
    }
}
