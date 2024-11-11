package org.iesalandalus.programacion.damas.modelo;

public enum Color {
    //Enumerado con literales
    BLANCO("Blanco"), NEGRO("Negro");

    //Atributo
    private String cadenaAMostrar;

    //Constructor
    private Color(String cadenaAMostrar) {this.cadenaAMostrar=cadenaAMostrar;}

    //Representación en texto de los literales
    @Override
    public String toString() {return cadenaAMostrar;}
}
