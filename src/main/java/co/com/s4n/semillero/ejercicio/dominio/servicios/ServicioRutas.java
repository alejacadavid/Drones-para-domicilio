package co.com.s4n.semillero.ejercicio.dominio.servicios;

import co.com.s4n.semillero.ejercicio.dominio.valueObject.Instruccion;
import io.vavr.collection.List;

import java.util.ArrayList;

public class ServicioRutas {

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
                //case default:
                //   instrucciones1 =Validation.invalid(new Error("Archivo contiene instrucciones inválidas"));
                //break;
            }
        }
        instrucciones1 = List.ofAll(arrayList);
        return instrucciones1;
    }
}
