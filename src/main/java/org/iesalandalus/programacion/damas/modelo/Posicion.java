package org.iesalandalus.programacion.damas.modelo;

public class Posicion {

    private int fila;
    private char columna;

    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        if (fila < 1 || fila > 8) {
            throw new IllegalArgumentException("ERROR: Sólo hay filas entre la 1 y la 8.");
        }
        this.fila = fila;
    }

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
