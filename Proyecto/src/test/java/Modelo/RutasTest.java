package Modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RutasTest {
    @Test
    void testExisteUsuario() {
        Rutas test = new Rutas();
        assertFalse(test.ExisteUsuario("12345678"),"Si el usuario existe lanza false");
    }
    @Test
    void testLeerUsario() {
        Rutas test = new Rutas();
        assertFalse(test.ExisteUsuario("12345678"),"Si el usuario existe lanza false");
    }
}
