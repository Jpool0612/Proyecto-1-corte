/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tallerexcepciones;

import excepciones.EdadInvalidaExcepcion;
import excepciones.NombreVacioExcepcion;
import excepciones.NombreCortoExcepcion;
import java.util.Scanner;
import modelo.Mascotas;

/**
 *
 * @author Jean Pool
 */
public class TallerExcepciones {

    
    public static void main(String[] args) {
        System.out.println("🔵 Inicio del programa...");

        // 🔹 Simulación de NullPointerException
        try {
            Mascotas m1 = null;
            m1.mostrar();
        } catch (NullPointerException e) {
            System.out.println("⚠️ Error: objeto no inicializado (NullPointerException).");
        }

        // 🔹 Simulación de ArithmeticException
        try {
            int edad = 10;
            int divisor = 0;
            int resultado = edad / divisor;
        } catch (ArithmeticException e) {
            System.out.println("⚠️ Error aritmético: división por cero (ArithmeticException).");
        }

        // 🔹 Validación con excepciones personalizadas
        try {
            Mascotas m2 = new Mascotas("", 5); // nombre vacío
        } catch (NombreVacioExcepcion e) {
            System.out.println("⚠️ Excepción personalizada: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("⚠️ Otro error inesperado: " + e.getMessage());
        }

        try {
            Mascotas m3 = new Mascotas("Toby", -3); // edad negativa
        } catch (EdadInvalidaExcepcion e) {
            System.out.println("⚠️ Excepción personalizada: " + e.getMessage());
        }

        try {
            Mascotas m4 = new Mascotas("m", 2); // nombre muy corto
        } catch (NombreCortoExcepcion e) {
            System.out.println("⚠️ Excepción personalizada: " + e.getMessage());
        }

        // 🔹 Entrada de usuario con validaciones
        Scanner sc = new Scanner(System.in);
        System.out.println("\n🟢 Ingrese los datos de una mascota:");

        try {
            System.out.print("📌 Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("📌 Edad: ");
            int edad = Integer.parseInt(sc.nextLine());

            Mascotas m5 = new Mascotas(nombre, edad);
            m5.mostrar();

        } catch (NombreVacioExcepcion | NombreCortoExcepcion | EdadInvalidaExcepcion e) {
            System.out.println("❌ Validación fallida: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: la edad debe ser un número entero.");
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }

        System.out.println("🔴 Fin del programa.");
    }
}