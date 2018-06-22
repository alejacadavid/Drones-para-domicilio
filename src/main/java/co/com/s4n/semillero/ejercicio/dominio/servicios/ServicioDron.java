package co.com.s4n.semillero.ejercicio.dominio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.entidades.Dron;
import co.com.s4n.semillero.ejercicio.dominio.valueObject.Instruccion;
import io.vavr.collection.Iterator;
import io.vavr.collection.List;

import java.util.ArrayList;


public class ServicioDron {

    static final int MAX_ENTREGAS = 3;

    public static String realizarEntregas(Dron d, List<String> pedidos){
        final String[] reporte = {"== Reporte de entregas ==\n"};
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
                    reporte[0] += dron[0].posicion.convToString() + "\n";
                    return dron[0];

                });


        return reporte[0];
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
