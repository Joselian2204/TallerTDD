public class Ascensor {
    private int pisoActual = 0;
    private int pisoDestino = -1;
    private int pisoPersona = -1;
    private boolean primerviaje = false;

    public int ocupado(int pp, int pa){
        if(pp == pa){
            return 1;
        }else{
            return 0;
        }
    }

    public boolean crearPersona(){
        pisoPersona = (int) (Math.random()*2);
        if(pisoPersona >= 0 && pisoPersona < 3){
            return true;
        }
        else
        {
            return false;
        }
    }

    public void llamarPiso(int pisoLlamada) throws Exception {
        if(pisoLlamada != pisoActual){
            establecerDestino(pisoLlamada);
        }
    }

    public void establecerDestino(int destino) throws Exception {
        if(destino >= 0 && destino < 3){
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
