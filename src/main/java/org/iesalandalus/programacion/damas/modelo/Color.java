package org.iesalandalus.programacion.damas.modelo;

public enum Color {
    //1-Enumerado con literales
    BLANCO("Blanco"),
    NEGRO("Negro");

    //2-Atributo
    private String cadenaAMostrar;

    //3-Constructor
    private Color(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    //4-Representación en texto de los literales
    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
