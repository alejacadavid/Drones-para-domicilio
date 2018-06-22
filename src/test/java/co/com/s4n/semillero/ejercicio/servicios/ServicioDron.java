package co.com.s4n.semillero.ejercicio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Posicion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Instruccion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Orientacion;
import io.vavr.collection.List;
import org.junit.Test;

import static co.com.s4n.semillero.ejercicio.dominio.servicios.ServicioDron.cargarInstruccion;
import static co.com.s4n.semillero.ejercicio.dominio.servicios.ServicioDron.realizarEntregas;
import static org.junit.Assert.*;

public class ServicioDron {

    @Test
    public void cargarInstruccionSucess(){
        assertEquals(cargarInstruccion("AID"),List.of(Instruccion.A,Instruccion.I,Instruccion.D));
    }

    @Test
    public void cargarInstruccionCaracteresInvalidos(){
        assertEquals(cargarInstruccion("*****"),List.of());
        assertEquals(cargarInstruccion("A**I"),List.of(Instruccion.A,Instruccion.I));
        assertEquals(cargarInstruccion("aIooo"),List.of(Instruccion.I));
    }

    @Test
    public void realizarEntregaExitosa(){
        String reporte = realizarEntregas(new Dron(0,new Posicion(0,0,Orientacion.Norte)),List.of("AAAAI","AAAAI"));
        String expected = "== Reporte de entregas ==\n(0, 4) Direccion Oeste\n(-4, 4) Direccion Sur\n";
        assertEquals(reporte,expected);
    }

    @Test
    public void realizarEntregaExitosa2(){
        String reporte = realizarEntregas(new Dron(0,new Posicion(0,0,Orientacion.Norte)),List.of("AAAAI","AAAAI","AAAAI"));
        String expected = "== Reporte de entregas ==\n(0, 4) Direccion Oeste\n(-4, 4) Direccion Sur\n(-4, 0) Direccion Este\n";
        assertEquals(reporte,expected);
    }

    @Test
    public void realizarEntregaExitosa3(){
        String reporte = realizarEntregas(new Dron(0,new Posicion(0,0,Orientacion.Norte)),List.of("AAAAI","AAAAI","AAAAI","AAAA"));
        String expected = "== Reporte de entregas ==\n(0, 4) Direccion Oeste\n(-4, 4) Direccion Sur\n(-4, 0) Direccion Este\n(0, 4) Direccion Norte\n";
        assertEquals(reporte,expected);
    }

    @Test
    public void realizarEntregaExitosa4(){
        String reporte = realizarEntregas(new Dron(0,new Posicion(0,0,Orientacion.Norte)),List.of("AAAAI","AAAAI","AAAAI","AAAA","AD"));
        String expected = "== Reporte de entregas ==\n(0, 4) Direccion Oeste\n(-4, 4) Direccion Sur\n(-4, 0) Direccion Este\n(0, 4) Direccion Norte\n(0, 5) Direccion Este\n";
        assertEquals(reporte,expected);
    }

    @Test
    public void realizarEntregaExitosa5(){
        String reporte = realizarEntregas(new Dron(0,new Posicion(0,0,Orientacion.Norte)),List.of("AAAAI","AAAAI","AAAAI","AAAA","AD","IA*"));
        String expected = "== Reporte de entregas ==\n(0, 4) Direccion Oeste\n(-4, 4) Direccion Sur\n(-4, 0) Direccion Este\n(0, 4) Direccion Norte\n(0, 5) Direccion Este\n(0, 6) Direccion Norte\n";
        assertEquals(reporte,expected);
    }

    @Test
    public void realizarEntregaExitosa6(){
        System.out.println(realizarEntregas(new Dron(0,new Posicion(0,0,Orientacion.Norte)),List.of("AAAAI","AAAAI","AAAAI","AAAA","AD","IA*","D")));
        String reporte = realizarEntregas(new Dron(0,new Posicion(0,0,Orientacion.Norte)),List.of("AAAAI","AAAAI","AAAAI","AAAA","AD","IA*","D"));
        String expected = "== Reporte de entregas ==\n(0, 4) Direccion Oeste\n(-4, 4) Direccion Sur\n(-4, 0) Direccion Este\n(0, 4) Direccion Norte\n(0, 5) Direccion Este\n(0, 6) Direccion Norte\n(0, 0) Direccion Este\n";
        assertEquals(reporte,expected);
    }


    @Test
    public void realizarentrega(){
        String reporte = realizarEntregas(new Dron(0,new Posicion(0,0,Orientacion.Norte)),List.of("AAAAI","AAAAI","AAAAI","AAAAAAAAAAAAA","AD","IA*","D"));
        String expected = "== Reporte de entregas ==\n(0, 4) Direccion Oeste\n(-4, 4) Direccion Sur\n(-4, 0) Direccion Este\n(0, 10) Direccion Norte\n(0, 10) Direccion Este\n(0, 10) Direccion Norte\n(0, 0) Direccion Este\n";
        System.out.println(reporte);
    }

}
