package co.com.s4n.semillero.ejercicio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Posicion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Instruccion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Orientacion;
import org.junit.Test;

import static co.com.s4n.semillero.ejercicio.dominio.servicios.ServicioPosicion.cambiarPosicion;
import static org.junit.Assert.*;

public class ServicioPosicion {

    @Test
    public void cambiarPosicionDrone(){
        assertEquals(new Posicion(0,1,Orientacion.Norte).convToString(),
                cambiarPosicion(new Posicion(0,0,Orientacion.Norte),Instruccion.A).convToString());
        assertEquals(new Posicion(0,0,Orientacion.Sur).convToString(),
                cambiarPosicion(new Posicion(0,0,Orientacion.Este),Instruccion.D).convToString());
        assertEquals(new Posicion(0,0,Orientacion.Norte).convToString(),
                cambiarPosicion(new Posicion(0,0,Orientacion.Este),Instruccion.I).convToString());
    }
}
