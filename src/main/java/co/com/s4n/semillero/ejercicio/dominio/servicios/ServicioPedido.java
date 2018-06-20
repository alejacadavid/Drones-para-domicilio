package co.com.s4n.semillero.ejercicio.dominio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Posicion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Orientacion;
import io.vavr.collection.List;

public class ServicioPedido {

    public static Dron entregarPedido(Dron dron, String instruccion){
        Dron dronFinal = ServicioRutas.cargarInstruccion(instruccion)
                .collect(new DronCollector(dron));

        return dronFinal;
    }

    public static Dron entregarPedido(String instruccion){
        Dron dronFinal = ServicioRutas.cargarInstruccion(instruccion)
                .collect(new DronCollector(new Dron(1,new Posicion(0,0,Orientacion.Norte))));

        return dronFinal;
    }

    public static Dron entregarPedido(Dron dron, List<String> pedidos){


    }




}
