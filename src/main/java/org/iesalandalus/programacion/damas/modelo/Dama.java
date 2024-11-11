package org.iesalandalus.programacion.damas.modelo;

public class Dama {
    //1-Atributos
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

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
