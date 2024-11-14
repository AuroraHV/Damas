package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;

public class Dama {

    //1-Atributos
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    //3-Constructor para inicializar
    public Dama() {
        setColor(Color.BLANCO);
        setPosicion(crearPosicionInicial(Color.BLANCO));
        setEsDamaEspecial(false);

    }

    //4.1-Constructor para crear dama blanca
    public Dama(Color color) {
        if (color == null) {
            throw new NullPointerException("ERROR: El color no puede ser nulo.");
        }
        setColor(color);
        setEsDamaEspecial(false); // Inicialmente no es especial

        // Crear posición inicial válida en función del color
        setPosicion(crearPosicionInicial(color));
    }

    //2.1-Métodos get y set con la excepción de color
    public Color getColor() {
        return color;
    }
    private void setColor(Color color) {
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
        char columnasNegras;

        //4.2.1-Determinar posición inicial: filas
        if (color == Color.BLANCO) {
            fila = (int) (Math.random() * 3) + 1; // Filas entre 1 y 3 para blancas
        } else {
            fila = (int) (Math.random() * 3) + 6; // Filas entre 6 y 8 para negras
        }
        //4.2.2-Determinar posición inicial: columnas (negras)
        do {
            columnasNegras = (char) ((int) (Math.random() * 8) + 'a');

        } while ((fila + columnasNegras) % 2 != 0);
            return new Posicion(fila, columnasNegras);
    }

    //5-Determinar movimiento
    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException{

        // i. Verificar que la dirección no sea nula
        if (direccion == null) {
            throw new NullPointerException("ERROR: La dirección no puede ser nula.");
        }
        // i.a- Verificar la dirección permitida para una dama no especial
        if (!esDamaEspecial) {
            if (color == Color.BLANCO) {
                if (direccion != Direccion.NORESTE && direccion != Direccion.NOROESTE) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
                }
            } else if (color == Color.NEGRO) {
                if (direccion != Direccion.SURESTE && direccion != Direccion.SUROESTE) {
                    throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
                }
            }
        }

        // ii. Verificar que el número de casillas sea positivo, mayor o igual que 1
        if (pasos < 1) {
            throw new IllegalArgumentException("El número de casillas a avanzar debe ser mayor o igual a 1.");
        }

        //Cálculo de la nueva posición
        int nuevaFila = posicion.getFila();
        char nuevaColumna = posicion.getColumna();

        // Movimiento de la dama según la dirección
        for (int i = 0; i < pasos; i++) {
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

            // ii.a- Si la dama no es especial, solo podrá moverse una casilla
            if (!esDamaEspecial && pasos > 1) {
                throw new OperationNotSupportedException ("ERROR: Las damas normales solo se pueden mover 1 casilla.");
            }

            // iv. Verificar si la nueva posición se sale del tablero
            if (nuevaFila < 1 || nuevaFila > 8 || nuevaColumna < 'a' || nuevaColumna > 'h') {
                throw new OperationNotSupportedException ("ERROR: Movimiento no permitido.");
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
        return "color=" + color + ", posicion=(" + posicion + ")";
    }
}
