package org.iesalandalus.programacion.damas.modelo;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    //2-Constructor privado para evitar la creación de instancias ya que sólo contendrá métodos estáticos
    private Consola() {
    }
    //3-Menú para las opciones de la aplicación
    public static void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Crear dama por defecto");
        System.out.println("2. Crear dama eligiendo el color");
        System.out.println("3. Mover dama");
        System.out.println("4. Salir");
    }

    //4-Elegir opción y verificar que esté en el rango
    public static int elegirOpcionMenu() {
        int opcion;

        do {
            System.out.print("Elija una opción (1-4): ");
            opcion = Entrada.entero();
            if (opcion < 1 || opcion > 4) {
                System.out.println("Opción inválida. Debe ser un número entre 1 y 4.");
            }
        } while (opcion < 1 || opcion > 4); // Verificar que la opción esté en el rango correcto

        return opcion;
    }




}
