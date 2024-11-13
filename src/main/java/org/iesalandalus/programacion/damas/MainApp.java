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

    // Crear dama por defecto
    private static void crearDamaDefecto() {
        dama = new Dama();
        System.out.println("Dama creada.");
    }

    // Determinar color
    private static void crearDamaColor() {
        Color color = Consola.elegirColor();
        dama = new Dama(color);
        System.out.println("Dama de color " + color + " creada.");
    }





}


