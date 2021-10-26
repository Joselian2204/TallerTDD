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
    public void pisoDestinoDiferentePisoPersona(){
        ascensor.setPisoActual(2);
        assertEquals(1,ascensor.llamarPiso(1));
    }

    @Test
    public void primerViajePersona(){
        assertEquals(true,ascensor.primerViaje());
    }


}