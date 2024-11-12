package org.iesalandalus.programacion.damas.modelo;

public class Dama {
    //1-Atributos
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    //3-Constructor para inicializar
    public Dama() {
        this.color = Color.BLANCO;
        this.posicion = crearPosicionInicial(color.BLANCO);
        this.esDamaEspecial = false;
    }

    //4.1-Constructor para crear dama blanca
    public Dama(Color color) {
        if (color == null) {
            throw new NullPointerException("El color no puede ser nulo.");
        }
        this.color = color;
        this.esDamaEspecial = false; // Inicialmente no es especial

        // Crear posición inicial válida en función del color
        this.posicion = crearPosicionInicial(color);
    }
    //4.2-Constructor para determinar posición inicial
    private Posicion crearPosicionInicial(Color color) {
        int fila;
        char[] columnasNegras;
        //4.2.1-Determinar posición inicial: filas
        if (color == Color.BLANCO) {
            fila = (int) (Math.random() * 3) + 1; // Filas entre 1 y 3 para blancas
        } else {
            fila = (int) (Math.random() * 3) + 6; // Filas entre 6 y 8 para negras
        }
        //4.2.2-Determinar posición inicial: columnas (negras)
        if (fila % 2 == 0) {
            columnasNegras = new char[]{'a', 'c', 'e', 'g'}; // Casillas negras disponibles para filas pares
        } else {
            columnasNegras = new char[]{'b', 'd', 'f', 'h'}; // Casillas negras disponibles para filas impares
        }
        char columna = columnasNegras[(int) (Math.random() * columnasNegras.length)];
        return new Posicion(fila, columna);
    }

    //2.1-Métodos get y set con la excepción de color
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        if (color == null) {
            throw new NullPointerException("El color no puede ser nulo.");
        }
        this.color = color;
    }
    //2.2-Métodos get y set con la excepción de posicion
    public Posicion getPosicion() {
        return posicion;
    }
    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new NullPointerException("La posicion no puede ser nula.");
        }
        this.posicion = posicion;
    }
    //2.3-Métodos get y set con la excepción de esDamaEspecial.
    public boolean isEsDamaEspecial() {
        return esDamaEspecial;
    }
    public void setEsDamaEspecial(boolean esDamaEspecial) {
        this.esDamaEspecial = esDamaEspecial;
    }
}
