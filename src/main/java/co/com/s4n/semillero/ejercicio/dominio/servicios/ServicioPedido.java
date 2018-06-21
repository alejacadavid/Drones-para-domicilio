package co.com.s4n.semillero.ejercicio.dominio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Posicion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Instruccion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Orientacion;
import io.vavr.collection.List;

import java.util.function.Consumer;

public class ServicioPedido {

    public static Dron enviarDron(Dron dron, String instruccion){
        Dron dronFinal = ServicioRutas.cargarInstruccion(instruccion)
                .collect(new DronCollector(dron));

        return dronFinal;
    }

    public static Dron enviarDron(String instruccion){
        Dron dronFinal = ServicioRutas.cargarInstruccion(instruccion)
                .collect(new DronCollector(new Dron(1,new Posicion(0,0,Orientacion.Norte))));
        return dronFinal;
    }

    public static List<Posicion> mapear(Dron d, List<String> pedidos){
        return pedidos.map(p -> enviarDron(d,p).posicion);
    }
    public static Dron realizarEntregas(Dron dron, List<String> pedidos){
        final Dron[] dron1 = new Dron[1];

        pedidos.forEach(p-> {
            dron1[0] = enviarDron(dron1[0],p);
            System.out.println(dron1[0].posicion.convToString());
        });
        return dron1[0];
    };


}
