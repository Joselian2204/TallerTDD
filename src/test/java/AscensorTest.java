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
        ascensor.crearPersona();
        int pisoPersona = ascensor.getPisoPersona();
        //verificamos si la persona fue creada en un piso correcto
        assertTrue(pisoPersona >= 1 && pisoPersona <= 3);
    }

    @Test
    public void noExistePersona(){
        assertEquals(0, ascensor.getPisoPersona());
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

    //Si la primera persona del día aparece en el piso 1, puede subirse de inmediato al ascensor (después de presionar el botón de llamada).
    @Test
    public void verificarBotonLlamadaPrimeraPersona() throws Exception {
        //creamos a la primera persona en el piso 1
        ascensor.setPisoPersona(1);
        ascensor.llamarPiso(1);
        assertEquals(0, ascensor.getPisoDestino());
    }

    // Si la primera persona aparece en el piso 2, el elevador deberá dirigirse al piso 2 y recoger a la persona.
    @Test
    public void verificarBotonLlamadaPiso2() throws Exception {
        //creamos una persona en el piso 2
        ascensor.crearPersona();
        ascensor.setPisoPersona(2);
        int pisoPersona = ascensor.getPisoPersona();
        ascensor.llamarPiso(pisoPersona);
        assertEquals(pisoPersona, ascensor.getPisoDestino());
    }
    @Test
    public void verificarBotonLlamada() throws Exception {
        ascensor.crearPersona();
        ascensor.setPisoPersona(3);
        int pisoPersona = ascensor.getPisoPersona();
        ascensor.llamarPiso(pisoPersona);
        assertEquals(pisoPersona, ascensor.getPisoDestino());
    }
}