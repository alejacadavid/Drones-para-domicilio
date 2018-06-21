package co.com.s4n.semillero.ejercicio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Posicion;
import co.com.s4n.semillero.ejercicio.dominio.servicios.ServicioPedido;
import co.com.s4n.semillero.ejercicio.dominio.servicios.ServicioPosicion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Instruccion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Orientacion;
import io.vavr.collection.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClasePrueba {

    @Test
    public void testCambiarPosicionConUnaInstruccion(){
        Posicion posInicial = new Posicion(0,0, Orientacion.Norte);
        Posicion posFinal = ServicioPosicion.cambiarPosicion(posInicial, Instruccion.A);

    }

    @Test
    public void testCambiarPosicionConVariasInstrucciones(){

        Dron dron = new Dron(1, new Posicion(0,0,Orientacion.Norte));
        Dron dron1 = ServicioPedido.enviarDron(dron,"AAAAIAAD");
        assertEquals(dron1.posicion.convToString(),"(-2, 4) direccion Norte");
    }

    @Test
    public void testRutasVariosPedidos(){
        List<String> pedidos = List.of("AAAAI", "AAAAI", "AAAAI");
        Dron dron = new Dron(1, new Posicion(0,0,Orientacion.Norte));
        System.out.print(ServicioPedido.realizarEntregas(dron,pedidos).posicion.convToString());
    }









}
