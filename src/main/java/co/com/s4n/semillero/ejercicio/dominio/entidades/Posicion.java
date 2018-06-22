package co.com.s4n.semillero.ejercicio.dominio.entidades;

import co.com.s4n.semillero.ejercicio.dominio.valueObject.Orientacion;

public final class Posicion {

    public int x;
    public int y;
    public Orientacion orientacion;

    public Posicion(){
        this.x = 0;
        this.y = 0;
        this.orientacion = Orientacion.Norte;
    }

    public Posicion(int x, int y, Orientacion orientacion){
        this.x = x;
        this.y = y;
        this.orientacion = orientacion;
    }

    public String convToString(){
        String res = "("+this.x+", "+this.y+") Direccion "+this.orientacion.toString();
        return res;
    }


}
