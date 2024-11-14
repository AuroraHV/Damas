package org.iesalandalus.programacion.damas.modelo;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    //2-Constructor privado para evitar la creación de instancias ya que sólo contendrá métodos estáticos
    private Consola() {
    }
    //3-Menú para las opciones de la aplicación
    public static void mostrarMenu() {
        System.out.println("=========================");
        System.out.println("Menú de opciones:");
        System.out.println("=========================");
        System.out.println("1. Crear dama por defecto.");
        System.out.println("2. Crear dama eligiendo el color.");
        System.out.println("3. Mover dama.");
        System.out.println("4. Mostrar información de la dama.");
        System.out.println("5. Salir.");
        System.out.println("-----------------------------");
    }

    //4-Elegir opción y verificar que esté en el rango
    public static int elegirOpcionMenu() {
        int opcion;

        do {
            System.out.print("Elige una opción (1-5): ");
            opcion = Entrada.entero();
            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción no válida.");
                System.out.println("-----------------------------");
            }
        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

    //5-Elegir opción de color y verificar que sea válido
    public static Color elegirColor()
    {
        int opcionColor;
        Color color=Color.BLANCO;

        do
        {
            System.out.println("Elige un color para la dama:");
            System.out.println("1. BLANCA");
            System.out.println("2. NEGRA");
            System.out.print("Introduce el color (1 o 2): ");
            opcionColor = Entrada.entero();

            if (opcionColor!=1 && opcionColor!=2) {
                System.out.println("Opción no válida.");
                System.out.println("-----------------------------");
            }
        }while (opcionColor!=1 && opcionColor!=2);

        if (opcionColor==1) {
            color=Color.BLANCO;
        } else color=Color.NEGRO;

        return color;
    }

    // 6-Menú con direcciones
    public static void mostrarMenuDirecciones() {
        System.out.println("Elige la dirección de la dama:");
        System.out.println("1.NORESTE");
        System.out.println("2.SURESTE");
        System.out.println("3.NOROESTE");
        System.out.println("4.SUROESTE");
    }

    // 7-Elegir dirección y verificar
    public static Direccion elegirDireccion() {
        int opcionDireccion;
        Direccion direccion = Direccion.NORESTE;

        do {
            System.out.print("Introduce una dirección (1-4): ");
            opcionDireccion= Entrada.entero();

            if (opcionDireccion<1 || opcionDireccion>4) {
                System.out.println("Opción no válida.");
                System.out.println("-----------------------------");
                mostrarMenuDirecciones();
            }
        }while (opcionDireccion<1 || opcionDireccion>4);

        switch(opcionDireccion)
        {
            case 1:
                direccion=Direccion.NORESTE;
                break;
            case 2:
                direccion=Direccion.SURESTE;
                break;
            case 3:
                direccion=Direccion.NOROESTE;
                break;
            case 4:
                direccion=Direccion.SUROESTE;
                break;
            default:
                break;
        }
        return direccion;
    }
    //7-Elegir pasos y verificar
    public static int elegirPasos() {
        int pasos;

        do {
            System.out.print("Introduce el número de casillas: ");
            pasos = Entrada.entero();

            if (pasos < 1) {
                System.out.println("Número inválido. Debe ser un entero positivo mayor o igual a 1.");
            }
        } while (pasos < 1);

        return pasos;
    }

    public static void despedirse() {
        System.out.println("Gracias por jugar. ¡Hasta la próxima!");
    }
}
