package org.iesalandalus.programacion.damas.modelo;

public enum Direccion {
    //Enumerado con literales
    NORESTE ("Noreste"), SURESTE ("Sureste"), SUROESTE ("Suroeste"), NOROESTE("Noroeste");

    //Atributo
    private String cadenaAMostrar;

    //Constructor
    private Direccion(String cadenaAMostrar) {this.cadenaAMostrar=cadenaAMostrar;}

    //Representación en texto de los literales
    @Override
    public String toString() {return cadenaAMostrar;}
}

