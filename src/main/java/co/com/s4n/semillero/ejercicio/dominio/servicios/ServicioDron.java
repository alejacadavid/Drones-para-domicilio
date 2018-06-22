package co.com.s4n.semillero.ejercicio.dominio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Posicion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Instruccion;
import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import io.vavr.control.Try;

import java.util.ArrayList;


public class ServicioDron {

    static final int MAX_ENTREGAS = 3;
    static final int LIMITE_RANGO_DRON = 10;

    public static String realizarEntregas(Dron d, List<String> pedidos){
        final String[] reporte = {"== Reporte de entregas ==\n"};
        final Dron[] dron = new Dron[1];
        Iterator<List<String>> pedidoAgru = pedidos.grouped(MAX_ENTREGAS);
        pedidoAgru.forEach(s ->{
            reporte[0] += enviarDron(d, s);
        });

        return reporte[0];
    }



    public static String enviarDron(Dron d, List<String> pedidos){
        final String[] reporte = {""};
        Dron[] dron = {d};
        pedidos.map(entrega -> {
                    List<Instruccion> movimientos = cargarInstruccion(entrega);

                    movimientos.forEach(i->{
                        if(validarRangoDron(dron[0],i).isSuccess()) {
                                dron[0] = new Dron(0, ServicioPosicion.cambiarPosicion(dron[0].posicion, i));

                        }else{
                            dron[0] = new Dron(0,new Posicion(dron[0].posicion.x, dron[0].posicion.y,dron[0].posicion.orientacion));
                            System.out.println(dron[0].posicion.convToString());
                        }


                    });
            reporte[0] += dron[0].posicion.convToString() + "\n";
            return dron[0];
                });


        return reporte[0];
    }

    public static Try<String> validarRangoDron(Dron d, Instruccion i){
            Dron d1 = new Dron(0, ServicioPosicion.cambiarPosicion(d.posicion, i));
            if (d1.posicion.x<=LIMITE_RANGO_DRON && d1.posicion.y>= -LIMITE_RANGO_DRON
                    && d1.posicion.y<=LIMITE_RANGO_DRON && d1.posicion.y>= -LIMITE_RANGO_DRON){
                return Try.of(()-> "");
            }else{
                return Try.of(()-> { throw new Error("Direccion por fuera del rango");});
            }


    }

    public static List<Instruccion> cargarInstruccion(String instrucciones){
        ArrayList<Instruccion> arrayList = new ArrayList<Instruccion>();
        List<Instruccion> instrucciones1;
        for(int i=0;i<instrucciones.length();i++){
            switch (instrucciones.charAt(i)){
                case 'A':
                    arrayList.add(Instruccion.A);
                    break;
                case 'D':
                    arrayList.add(Instruccion.D);
                    break;
                case 'I':
                    arrayList.add(Instruccion.I);
                    break;
            }
        }
        instrucciones1 = List.ofAll(arrayList);
        return instrucciones1;
    }




}
