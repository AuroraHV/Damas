package org.iesalandalus.programacion.damas.modelo;

public enum Direccion {
    //1-Enumerado con literales
    NORESTE ("Noreste"), SURESTE ("Sureste"), SUROESTE ("Suroeste"), NOROESTE("Noroeste");

    //2-Atributo
    private String cadenaAMostrar;

    //3-Constructor
    private Direccion(String cadenaAMostrar) {this.cadenaAMostrar=cadenaAMostrar;}

    //4-Representación en texto de los literales
    @Override
    public String toString() {return cadenaAMostrar;}
}

