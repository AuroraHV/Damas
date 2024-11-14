package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Consola;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.damas.modelo.Dama;

public class MainApp {
    //1-Atributo
    private static Dama dama;

    //2-Ejecutar opción según métodos
    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearDamaDefecto();
                break;
            case 2:
                crearDamaColor();
                break;
            case 3:
                mover();
                break;
            case 4:
                mostrarDama();
                break;
            case 5:
                Consola.despedirse();
                break;
            default:
                break;
        }
    }

    //3-crearDamaDefecto
    private static void crearDamaDefecto() {
        try {
            dama = new Dama();
            System.out.println("Dama creada correctamente.");
            System.out.println("-----------------------------");
        }
        catch(IllegalArgumentException | NullPointerException e)
        {
            System.out.println(e.getMessage());
        }
    }

    //4-crearDamaColor
    private static void crearDamaColor() {
        boolean error=false;
        do {
        try {
            Color color = Consola.elegirColor();
            dama = new Dama(color);
            System.out.println("Dama de color " + color + " creada correctamente.");
            System.out.println("-----------------------------");
        }
        catch(IllegalArgumentException | NullPointerException e)
        {
            System.out.println("ERROR: La dama no ha sido creada.");
            System.out.println(e.getMessage());
            error=true;
        }
        } while (error);
    }

    //5-mover
    private static void mover() {
        if (dama == null) {
            System.out.println("Primero debes crear una dama.");
            return;
        }
        try {
            Consola.mostrarMenuDirecciones();
            //Pedir la dirección
            Direccion direccion = Consola.elegirDireccion();
            //int pasos = Consola.elegirPasos();
            int pasos;
            //Pedir casillas (cambian si la dama es especial)
            if (dama.isEsDamaEspecial()) {
                pasos = Consola.elegirPasos();
            } else pasos = 1;

            dama.mover(direccion, pasos);
            System.out.println("La dama se ha movido " + pasos + " casilla(s) al " + direccion + ".");
        } catch (IllegalArgumentException | OperationNotSupportedException e) {
            System.out.println("ERROR: Movimiento no válido.");
            System.out.println(e.getMessage());
        }
    }

    //6-mostrarDama
    private static void mostrarDama() {
        if (dama != null) {
            System.out.println(dama);
        } else {
            System.out.println("Aún no se ha creado ninguna dama.");
        }
    }

    //7-Main
    public static void main(String[] args) {
        int opcion;
        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcionMenu();
            ejecutarOpcion(opcion);
        } while (opcion != 5);
    }






}


