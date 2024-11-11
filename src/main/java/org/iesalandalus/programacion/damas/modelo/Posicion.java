package org.iesalandalus.programacion.damas.modelo;

public class Posicion {
    //Atributos
    private int fila;
    private char columna;

    //Constructor que valida y asigna los parámetros si son correctos al llamar a los métodos set
    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }

    //Métodos get y set con la excepción de Fila
    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        if (fila < 1 || fila > 8) {
            throw new IllegalArgumentException("ERROR: Sólo hay filas entre la 1 y la 8.");
        }
        this.fila = fila;
    }
    //Métodos get y set con la excepción de Columna
    public char getColumna() {
        return columna;
    }
    public void setColumna(char columna) {
        if (columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("ERROR: Sólo hay columnas entre la a y la h.");
        }
        this.columna = columna;
    }




}
