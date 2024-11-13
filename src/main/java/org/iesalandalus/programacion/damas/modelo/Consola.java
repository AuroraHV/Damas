package org.iesalandalus.programacion.damas.modelo;

public class Consola {

    // Constructor privado para evitar la creación de instancias ya que sólo contendrá métodos estáticos
    private Consola() {
    }
    //Menú para las opciones de la aplicación
    public static void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Crear dama por defecto");
        System.out.println("2. Crear dama eligiendo el color");
        System.out.println("3. Mover dama");
        System.out.println("4. Salir");
    }




}
