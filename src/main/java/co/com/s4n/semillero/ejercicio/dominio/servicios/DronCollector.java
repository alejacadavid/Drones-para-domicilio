package co.com.s4n.semillero.ejercicio.dominio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.entidades.Posicion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Instruccion;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Orientacion;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static co.com.s4n.semillero.ejercicio.dominio.servicios.ServicioPosicion.cambiarPosicion;

public class DronCollector implements Collector<Instruccion, Dron, Dron> {

    private Dron dron = null;

    public DronCollector(Dron dron) {
        this.dron = dron;
    }

    @Override
    public Supplier<Dron> supplier() {
        return Dron::new;
    }

    @Override
    public BiConsumer<Dron, Instruccion> accumulator() {
        return (Dron d, Instruccion i) -> {
            d.posicion = cambiarPosicion(d.posicion, i);
        };
    }

    @Override
    public BinaryOperator<Dron> combiner() {

        return (Dron d1, Dron d2) -> d1;
    }

    @Override
    public Function<Dron, Dron> finisher() {
        return (Dron df) -> {
            return df;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.UNORDERED);
    }
}