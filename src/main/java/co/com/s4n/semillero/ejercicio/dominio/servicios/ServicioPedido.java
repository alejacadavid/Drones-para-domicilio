package co.com.s4n.semillero.ejercicio.dominio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Posicion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Instruccion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Orientacion;
import io.vavr.collection.List;
import io.vavr.control.Try;

import java.io.*;
import java.util.ArrayList;

public class ServicioPedido {

    public static Try<List<String>> cargarRutas(String rutaArchivo){

        Try<List<String>> rutasEntrega = Try.of(() -> new FileReader(new File(rutaArchivo)))
                .flatMap(f -> Try.of(() -> new BufferedReader(f)))
                .flatMap(b -> Try.of(() -> List.ofAll(b.lines())));

        return rutasEntrega;

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


    public static Dron enviarDron(Dron dron, String instrucciones){
        Dron dronFinal = cargarInstruccion(instrucciones)
                .collect(new DronCollector(dron));
        return dronFinal;

    }

    public static Try<Dron> enviarDron(String instruccion){
        Dron dronFinal = cargarInstruccion(instruccion)
                .collect(new DronCollector(new Dron(1,new Posicion(0,0,Orientacion.Norte))));
        return Try.of(() -> dronFinal);
    }


    public static List<Dron> realizarEntregas(Dron d, List<String> pedidos){

        Dron[] dron = {d};
        int[] cont = {0};
        List<Dron> listDrones = pedidos
                    .map(entrega -> {
                        List<Instruccion> movimientos = cargarInstruccion(entrega);
                        for (int i = 0; i < movimientos.length(); i++) {
                            if(dron[0].posicion.x<=10 || dron[0].posicion.y<=10) {
                                if (cont[0] == 3) {
                                    dron[0] = d;
                                    cont[0] = 0;
                                }
                                dron[0] = new Dron(0, ServicioPosicion.cambiarPosicion(dron[0].posicion, movimientos.get(i)));
                            }else{
                                new Error("Pedido por fuera del rango");
                            }
                        }
                        cont[0] = cont[0] + 1;
                        return dron[0];
                    });
        return listDrones;
    }

    public static String reportarEntregas(Dron dron, List<String> pedidos){
        final String[] reporte = {"== Reporte de entregas ==\n"};

        realizarEntregas(dron, pedidos).forEach(dron0-> {
            reporte[0] += dron0.posicion.convToString() + "\n";
        });
        return reporte[0];
    }

    public static Try<String> generarReporte(String reporte, String rutaArchivo){
        return Try.of(()->new File(rutaArchivo))
                .flatMap(f->Try.of(()->new FileWriter(f))
                        .flatMap(p -> Try.of(()-> new PrintWriter(p))
                        .flatMap(fw ->Try.of(()->new BufferedWriter(fw))
                                .flatMap(bw ->Try.of(()->{
                                    bw.write(reporte);
                                    bw.close();
                                    return "Escritura exitosa";
                                })
                ))));
    }





}

