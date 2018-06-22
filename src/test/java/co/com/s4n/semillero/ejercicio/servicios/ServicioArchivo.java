package co.com.s4n.semillero.ejercicio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Posicion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Orientacion;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.junit.Test;

import java.io.FileNotFoundException;

import static co.com.s4n.semillero.ejercicio.dominio.servicios.ServicioArchivo.escribirReporte;
import static co.com.s4n.semillero.ejercicio.dominio.servicios.ServicioArchivo.importarInstruccionesPedido;
import static co.com.s4n.semillero.ejercicio.dominio.servicios.ServicioDron.realizarEntregas;
import static org.junit.Assert.assertEquals;

public class ServicioArchivo {

    @Test
    public void importarInstruccionesPedidoSuccess(){
        Try<List<String>> rutas = importarInstruccionesPedido("./src/test/resources/in1.txt");
        assertEquals(Try.of(()->List.of("AAAAIAAD","AAD")),rutas);
    }

    @Test
    public void importarInstruccionesPedidoFail(){
        Try<List<String>> rutas = importarInstruccionesPedido("./src/test/resources/in0.txt");
        assertEquals("Archivo o ruta invalida",
                Try.failure(new FileNotFoundException("./src/test/resources/in0.txt (El sistema no puede encontrar el" +
                        " archivo especificado)")),rutas);
    }

    @Test
    public void importarInstruccionesPedidoArchivoVacio(){
        Try<List<String>> rutas = importarInstruccionesPedido("./src/test/resources/in.txt");
        assertEquals("Archivo vacio",Try.of(() -> List.of("")).toString(),rutas.toString());
    }

    @Test
    public void escribirReportes(){
        String reporte = realizarEntregas(new Dron(0,new Posicion(0,0,Orientacion.Norte)),List.of("AAAAI","AAAAI","AAAAI","AAAA","AD","IA*","D"));
        String rutaArchivo = "./src/resources/out.txt";
        assertEquals(Try.of(() -> "Escritura exitosa"),escribirReporte(reporte, rutaArchivo));
    }

}
