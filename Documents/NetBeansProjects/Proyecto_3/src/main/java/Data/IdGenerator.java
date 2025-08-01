/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author Jean pool
 */
public class IdGenerator {

    private static int currentId = 0;

    public static int generateId() {
        return ++currentId;
    }
}


