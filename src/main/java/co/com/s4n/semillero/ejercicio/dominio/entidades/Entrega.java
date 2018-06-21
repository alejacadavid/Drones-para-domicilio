package co.com.s4n.semillero.ejercicio.dominio.entidades;

    public final class Entrega {
        String ruta;


        public Entrega(){
            ruta = "";
        }
        public Entrega(String ruta){
            this.ruta=ruta;
        }

        public String getRuta(){
            return ruta;
        }

    }
