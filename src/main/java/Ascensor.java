public class Ascensor {
    // El ascensor al comenzar el día espera con su puerta cerrada en el primer piso del edificio
    // El ascensor siempre sabe en que piso esta y cual es su piso de destino.
    private int pisoActual = 1;
    private int pisoDestino;
    private int pisoPersona;
    private boolean primerviaje = false;

    final int ULTIMO_PISO = 3;
    final int PRIMER_PISO = 1;
    public int ocupado(int pisoPersona, int pisoActual){
        if(pisoPersona == pisoActual){
            return 1;
        }else{
            return 0;
        }
    }
    // El programa debe tener una función para “Crear persona”, cuando se invoque a esta función, el programa deberá crear una persona y colocarla en un piso.
    public void crearPersona(){
        //  El piso en el que aparecerá la persona se determinara aleatoriamente.
        pisoPersona = (int) (1 + Math.random()*(ULTIMO_PISO-1));
    }

    public void llamarPiso(int pisoLlamada) throws Exception {
        // El piso de destino de la persona nunca es igual al piso en el que se crea esa persona.
        if(pisoLlamada != pisoActual){
            establecerDestino(pisoLlamada);
        }
    }

    public void establecerDestino(int destino) throws Exception {
        if(destino >= PRIMER_PISO && destino <= ULTIMO_PISO){
            pisoDestino=destino;
        }else{
            throw new Exception("Destino incorrecto:"+destino);
        }
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    public void setPisoDestino(int pisoDestino) {
        this.pisoDestino = pisoDestino;
    }

    public int getPisoPersona() {
        return pisoPersona;
    }

    public void setPisoPersona(int pisoPersona) {
        this.pisoPersona = pisoPersona;
    }
}
