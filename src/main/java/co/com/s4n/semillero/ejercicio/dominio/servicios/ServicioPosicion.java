package co.com.s4n.semillero.ejercicio.dominio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Posicion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Instruccion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Orientacion;

public class ServicioPosicion {

    public static Posicion cambiarPosicion(Posicion p, Instruccion i){

        Posicion posicionRes = new Posicion();

        switch (i){
            case A:
                switch(p.orientacion){
                    case Norte:
                        posicionRes = new Posicion(p.x,p.y+1,p.orientacion);
                        break;
                    case Sur:
                        posicionRes = new Posicion(p.x,p.y-1,p.orientacion);
                        break;
                    case Oeste:
                        posicionRes = new Posicion(p.x-1,p.y,p.orientacion);
                        break;
                    case Este:
                        posicionRes = new Posicion(p.x+1,p.y,p.orientacion);
                        break;
                }
                break;
            case D:
                switch(p.orientacion){
                    case Norte:
                        posicionRes = new Posicion(p.x,p.y, Orientacion.Este);
                        break;
                    case Sur:
                        posicionRes = new Posicion(p.x,p.y,Orientacion.Oeste);
                        break;
                    case Oeste:
                        posicionRes = new Posicion(p.x,p.y,Orientacion.Norte);
                        break;
                    case Este:
                        posicionRes = new Posicion(p.x,p.y,Orientacion.Sur);
                        break;
                }
                break;
            case I:
                switch(p.orientacion){
                    case Norte:
                        posicionRes = new Posicion(p.x,p.y, Orientacion.Oeste);
                        break;
                    case Sur:
                        posicionRes = new Posicion(p.x,p.y,Orientacion.Este);
                        break;
                    case Oeste:
                        posicionRes = new Posicion(p.x,p.y,Orientacion.Sur);
                        break;
                    case Este:
                        posicionRes = new Posicion(p.x,p.y,Orientacion.Norte);
                        break;
                }
                break;
        }
        return posicionRes;

    }





}
