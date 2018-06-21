package co.com.s4n.semillero.ejercicio.dominio.entidades;

import co.com.s4n.semillero.ejercicio.dominio.valueObject.Orientacion;

public final class Dron {

    public int id;
    public Posicion posicion;

    public Dron(){
        this.id = 0;
        this.posicion = new Posicion(0,0, Orientacion.Norte);
    }

    public Dron(int id, Posicion posicion){
        this.id = id;
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public Posicion getPosicion() {
        return posicion;
    }
}
