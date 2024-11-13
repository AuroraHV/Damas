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
        }
    }

    //3-crearDamaDefecto
    private static void crearDamaDefecto() {
        dama = new Dama();
        System.out.println("Dama creada.");
    }

    //4-crearDamaColor
    private static void crearDamaColor() {
        Color color = Consola.elegirColor();
        dama = new Dama(color);
        System.out.println("Dama de color " + color + " creada.");
    }

    //5-mover
    private static void mover() {
        if (dama == null) {
            System.out.println("Primero debes crear una dama.");
            return;
        }
        //Pedir la dirección
        Direccion direccion = Consola.elegirDireccion();
        //Pedir casillas (cambian si la dama es especial)
        int casillas;
        if (dama.isEsDamaEspecial()) {
            casillas = Consola.elegirPasos();
        } else casillas = 1;

        try {
            dama.mover(direccion, casillas);
            System.out.println("La dama se ha movido " + casillas + " casilla(s).");
        } catch (IllegalArgumentException | OperationNotSupportedException e) {
            System.out.println("Error: " + e.getMessage());
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






}


