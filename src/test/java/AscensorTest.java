import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AscensorTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private Ascensor ascensor;

    @Before
    public final void before(){
        //1. Preparacin de la prueba
        ascensor = new Ascensor();
        System.out.println("Inicializando Prueba..." + ascensor.toString());
    }

    @Test
    public void ascensorListo(){
        //3. Verificacion o Assert
        assertEquals(1,ascensor.ocupado(1,1));
    }

    @Test
    public void existePersona(){
        assertEquals(true,ascensor.crearPersona());
    }

    @Test
    public void noExistePersona(){
        assertEquals(-1, ascensor.getPisoPersona());
    }

    @Test
    public void verificarNuevoDestino() throws Exception {
        ascensor.establecerDestino(2);
        assertEquals(2, ascensor.getPisoDestino());
    }

    @Test
    public void verificarNuevoDestinoIncorrecto() throws Exception {
        exception.expect(Exception.class);
        ascensor.establecerDestino(4);
    }

    @Test
    public void verificarLlamadaPrimeraPersona() throws Exception {
        //creamos a la primera persona y luego la seteamos en el piso 1
        ascensor.setPisoPersona(0);
        ascensor.llamarPiso(0);
        assertEquals(-1, ascensor.getPisoDestino());
    }

    @Test
    public void verificarLlamada() throws Exception {
        //creamos a la primera persona
        ascensor.crearPersona();
        ascensor.setPisoPersona(1);
        int pisoPersona = ascensor.getPisoPersona();
        ascensor.llamarPiso(pisoPersona);
        assertEquals(pisoPersona, ascensor.getPisoDestino());
    }
}