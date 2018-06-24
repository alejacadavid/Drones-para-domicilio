package co.com.s4n.semillero.ejercicio.dominio.servicios;

import io.vavr.collection.List;
import io.vavr.control.Try;

import java.io.*;

public class ServicioArchivo {

    public static Try<List<String>> importarInstruccionesPedido(String rutaArchivo){

        Try<List<String>> rutasEntrega = Try.of(() -> new FileReader(new File(rutaArchivo)))
                .flatMap(f -> Try.of(() -> new BufferedReader(f)))
                .flatMap(b -> Try.of(() -> List.ofAll(b.lines())));
        return rutasEntrega;
    }



    public static Try<String> escribirReporte(String reporte, String rutaArchivo){
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
