package Validadores;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidadoresTest {
    @Test
    void testValidaEmail() {
        assertFalse(Email.validaEmail(("tes.@2t@example.com")),"PUNTO");
        assertFalse(Email.validaEmail(("56yh ju7ik89@example.com")),"espacio");
        assertTrue(Email.validaEmail(("5ik89@6yhbjnu7m8v.gvyhjg")),"MANO AL TECLADO");
        assertTrue(Email.validaEmail(("5i_89@6yhbjnu7m8v.gvyhjg")),"GUION BAJO");
        assertFalse(Email.validaEmail(("5i,_89@6yhbjnu7m8v.gvyhjg")),"COMA");
        assertFalse(Email.validaEmail(("5i,_89@6yh.bjnu7.m8v.gvyhjg")),"doble punto despues del @");
    }

    @Test
    void testTelefono(){
        assertFalse(Telefono.validarTelefono(("998877665")),"9 numeros en vez de 8");
        assertFalse(Telefono.validarTelefono(("2CV #!$")),"MANO AL TECLADO");
        assertFalse(Telefono.validarTelefono(("882233 44")),"NUMEROS CON ESPACIO");
    }
}
