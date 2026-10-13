public class JuegoTurnos {

    private CListaCircularSE jugadores;
    private NodoJugador jugadorActual;

    public JuegoTurnos() {
        this.jugadores = new CListaCircularSE();
        this.jugadorActual = null;

    }


    public void agregarJugador(String nombre, int puntuacionInicial) {

        // 1. Verificamos el estado antes de alterar la estructura
        boolean estabaVacia = this.jugadores.estaVacia();

        // 2. Delegamos la inserción en la lista circular
        this.jugadores.agregar(nombre, puntuacionInicial);

        // 3. Si era el primer jugador, inauguramos el sistema de turnos
        if (estabaVacia) {
            this.jugadorActual = this.jugadores.getPrimero();
        }
    }


        public void eliminarJugador (String nombre){

            NodoJugador aEliminar = this.jugadores.buscar(nombre);
            if (aEliminar == null) {
                System.out.println("El jugador no existe");
                return;
            }

            if (aEliminar == this.jugadorActual){

                if (this.jugadorActual.siguiente == this.jugadorActual){
                    this.jugadorActual = null;
                } else {
                    this.jugadorActual = this.jugadorActual.siguiente;
                }
            }

this.jugadores.eliminar(nombre);
        }


        public void siguienteTurno () {

            if (this.jugadorActual != null) {

                this.jugadorActual = this.jugadorActual.siguiente;
            } else {
                System.out.println("No hay jugdores en la partido ");
            }

        }
        public void mostrarJugadores () {


                this.jugadores.mostrar();

        }


        public NodoJugador getJugadorActual () {
        return this.jugadorActual;
        }
    }
