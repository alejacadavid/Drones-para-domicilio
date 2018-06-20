package co.com.s4n.semillero.ejercicio.dominio.servicios;

import io.vavr.collection.List;
import io.vavr.control.Try;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ServicioArchivos {

    public static Try<List<String>> importarRutasEntrega(String rutaArchivo){

        Try<List<String>> rutasEntrega = Try.of(() -> new FileReader(new File(rutaArchivo)))
                .flatMap(f -> Try.of(() -> new BufferedReader(f)))
                .flatMap(b -> Try.of(() -> List.ofAll(b.lines())));

        return rutasEntrega;

    }




}
