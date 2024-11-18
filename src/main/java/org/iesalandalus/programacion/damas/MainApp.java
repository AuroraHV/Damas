package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Consola;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.damas.modelo.Dama;

public class MainApp {

    private static void inicio(){
        System.out.println("=========================");
        System.out.println("   JUEGO DE LAS DAMAS");
    }
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

    //3-crearDamaDefecto (1)
    private static void crearDamaDefecto() {
        try {
            dama = new Dama();
            System.out.println("Dama creada correctamente.");
        }
        catch(IllegalArgumentException | NullPointerException e)
        {
            System.out.println(e.getMessage());
        }
    }

    //4-crearDamaColor (2)
    private static void crearDamaColor() {
        boolean error=false;
        do {
            try {
                Color color = Consola.elegirColor();
                dama = new Dama(color);
                System.out.println("Dama de color <" + color + "> creada correctamente.");
            }
            catch(IllegalArgumentException | NullPointerException e)
            {
                System.out.println("ERROR: La dama no ha sido creada.");
                System.out.println(e.getMessage());
                error=true;
            }
        } while (error);
    }

    //5-mover (3)
    private static void mover() {
        if (dama == null) {
            System.out.println("Primero debes crear una dama.");
            return;
        }
        Consola.mostrarMenuDirecciones();
        //Pedir la dirección
        Direccion direccion = Consola.elegirDireccion();
        //Pedir casillas (cambian si la dama es especial)
        int pasos;
        if (dama.isEsDamaEspecial()) {
            pasos = Consola.elegirPasos();
        } else pasos = 1;

        try {
            dama.mover(direccion, pasos);
            if (dama.isEsDamaEspecial()) {
                System.out.println("La dama especial se ha movido " + pasos + " casilla/s al " + direccion + ".");
            } else System.out.println("La dama se ha movido " + pasos + " casilla al " + direccion + ".");

        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    //6-mostrarDama (4)
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
        inicio();
        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcionMenu();
            ejecutarOpcion(opcion);
        } while (opcion != 5);
    }
}


