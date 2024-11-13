package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;

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

    //4.2-Determinar posición inicial
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

    //5-Determinar movimiento
    public void mover(Direccion direccion, int casillas) throws OperationNotSupportedException{

        // i. Verificar que la dirección no sea nula
        if (direccion == null) {
            throw new NullPointerException("La dirección no puede ser nula.");
        }
        // i.a- Verificar la dirección permitida para una dama no especial
        if (!esDamaEspecial) {
            if (color == Color.BLANCO) {
                if (direccion != Direccion.NORESTE && direccion != Direccion.NOROESTE) {
                    throw new IllegalArgumentException("La dama blanca no especial solo puede moverse en dirección noreste o noroeste.");
                }
            } else if (color == Color.NEGRO) {
                if (direccion != Direccion.SURESTE && direccion != Direccion.SUROESTE) {
                    throw new IllegalArgumentException("La dama negra no especial solo puede moverse en dirección sureste o suroeste.");
                }
            }
        }

        // ii. Verificar que el número de casillas sea positivo, mayor o igual que 1
        if (casillas < 1) {
            throw new IllegalArgumentException("El número de casillas a avanzar debe ser mayor o igual a 1.");
        }
        // ii.a- Si la dama no es especial, solo podrá moverse una casilla
        if (!esDamaEspecial && casillas > 1) {
            throw new OperationNotSupportedException ("La dama no especial solo puede moverse 1 paso.");
        }

        //Cálculo de la nueva posición
        int nuevaFila = posicion.getFila();
        char nuevaColumna = posicion.getColumna();

        // Movimiento de la dama según la dirección
        for (int i = 0; i < casillas; i++) {
            switch (direccion) {
                case NORESTE:
                    nuevaFila++;
                    nuevaColumna++;
                    break;
                case NOROESTE:
                    nuevaFila++;
                    nuevaColumna--;
                    break;
                case SURESTE:
                    nuevaFila--;
                    nuevaColumna++;
                    break;
                case SUROESTE:
                    nuevaFila--;
                    nuevaColumna--;
                    break;
                default:
                    throw new IllegalArgumentException("Dirección no válida.");
            }

            // iv. Verificar si la nueva posición se sale del tablero
            if (nuevaFila < 1 || nuevaFila > 8 || nuevaColumna < 'a' || nuevaColumna > 'h') {
                throw new OperationNotSupportedException ("El movimiento sale del tablero.");
            }
        }

        // iii. Verificar si se convierte en dama especial
        if ((color == Color.BLANCO && nuevaFila == 8) || (color == Color.NEGRO && nuevaFila == 1)) {
            esDamaEspecial = true;
        }

        // Actualizar la posición de la dama
        posicion = new Posicion(nuevaFila, nuevaColumna);

    }

    //6-Atributos de la dama para sout
    @Override
    public String toString() {
        return "Dama{" + "color=" + color + ", posicion=" + posicion + ", esDamaEspecial=" + esDamaEspecial + '}';
    }
}
