package co.com.s4n.semillero.ejercicio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Posicion;

import static co.com.s4n.semillero.ejercicio.dominio.servicios.ServicioPedido.*;
import static co.com.s4n.semillero.ejercicio.dominio.servicios.ServicioPosicion.cambiarPosicion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Instruccion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Orientacion;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClasePrueba {

    @Test
    public void testCargarArchivo(){
        Try<List<String>> rutas = cargarRutas("./src/test/resources/in.txt");
        assertEquals(Try.of(()->List.of("AAAAIAAD","AAD")),rutas);
    }

    @Test
    public void testCambiarPosicionConUnaInstruccion(){
        Posicion posInicial = new Posicion(0,0, Orientacion.Norte);
        Posicion posFinal = cambiarPosicion(posInicial, Instruccion.A);

    }

    @Test
    public void testCambiarPosicionConVariasInstrucciones(){

        Dron dron = new Dron(1, new Posicion(0,0,Orientacion.Norte));
        Dron dron1 = enviarDron(dron,"AAAAIAAD");
        assertEquals(dron1.posicion.convToString(),"(-2, 4) Dirección Norte");
    }


    @Test
    public void testRutaPedidos(){

        List<Dron> listDrones = realizarEntregas(new Dron(1, new Posicion(0, 0, Orientacion.Norte)), List.of("AAAAI", "AAAAI","AAAAI","AAAA"));
        listDrones.forEach(p-> {
            System.out.println(p.posicion.convToString());
        });

        List<Dron> listDrones1 = realizarEntregas(new Dron(1, new Posicion(0, 0, Orientacion.Norte)), List.of("AAAAIAAD"));
        listDrones1.forEach(p-> {
            System.out.println(p.posicion.convToString());
        });
    }



    @Test
    public void entregarReporte(){

        generarReporte(reportarEntregas(new Dron(1, new Posicion(0, 0, Orientacion.Norte)),List.of("AAAAAI", "AAAAI","AAAAI","AAAA")),"./src/test/resources/out.txt");
        generarReporte(reportarEntregas(new Dron(1, new Posicion(0, 0, Orientacion.Norte)),List.of("AAAAIAAD")),"./src/test/resources/out.txt");

    }









}
