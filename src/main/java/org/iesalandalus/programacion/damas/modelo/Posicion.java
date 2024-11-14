package org.iesalandalus.programacion.damas.modelo;

import java.util.Objects;

public class Posicion {
    //1-Atributos
    private int fila;
    private char columna;

    //3-Constructor que valida y asigna los parámetros si son correctos al llamar a los métodos set
    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }

    //4-Constructor copia (con excepción para que no sea nula la posición)
    public Posicion(Posicion posicion) {
        if (posicion == null) {
            throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
        }
        setColumna(posicion.getColumna());
        setFila(posicion.getFila());
    }

    //2.1-Métodos get y set con la excepción de Fila
    public int getFila() {
        return fila;
    }
    private void setFila(int fila) {
        if (fila < 1 || fila > 8) {
            throw new IllegalArgumentException("ERROR: Fila no válida.");
        }
        this.fila = fila;
    }
    //2.2-Métodos get y set con la excepción de Columna
    public char getColumna() {
        return columna;
    }
    private void setColumna(char columna) {
        if (columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("ERROR: Columna no válida.");
        }
        this.columna = columna;
    }

    //5.1-HashCode para optimizar la búsqueda y organización de las posiciones ocupadas en colecciones.
    @Override
    public int hashCode() {
        return Objects.hash(fila,columna);
    }
    //5.2-Equals para comparar si dos posiciones en el tablero tienen las mismas coordenadas).
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Posicion posicion= (Posicion) obj;
        return fila == posicion.fila && columna == posicion.columna;
    }

    //6-Representación en texto para mostrar los atributos especificados en un sout
    @Override
    public String toString() {
        return "fila=" + fila + ", columna=" + columna;
    }

}
