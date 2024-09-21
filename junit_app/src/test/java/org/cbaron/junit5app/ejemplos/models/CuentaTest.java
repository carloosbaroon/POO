package org.cbaron.junit5app.ejemplos.models;

import org.cbaron.junit5app.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testNombreCuenta() {
        Cuenta cuenta = new Cuenta("Aleph", new BigDecimal("1000.12345"));
        String esperado = "Aleph";
        String real = cuenta.getPersona();

        assertNotNull(real, () -> "La cuenta no puede ser nula");
        assertEquals(esperado, real, () -> "El nombre de la cuenta no es el que se esperaba");
        assertTrue(real.equals("Aleph"), () -> "Nombre de la cuenta esperada debe ser igual a la real");
    }

    @Test
    void testSaldoCuenta() {
        Cuenta cuenta = new Cuenta("Aleph", new BigDecimal("1000.12345"));

        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testReferenciaCuenta() {
        Cuenta cuenta = new Cuenta("Aleph", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("Aleph", new BigDecimal("8900.9997"));

        assertEquals(cuenta, cuenta2);
    }

    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("Aleph", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal("100"));

        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());

    }

    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("Aleph", new BigDecimal("1000.12345"));
        cuenta.credito(new BigDecimal("100"));

        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString());

    }

    @Test
    void testDineroInsuficienteException() {
        Cuenta cuenta = new Cuenta("Aleph", new BigDecimal("1000.12345"));

        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1500));
        });

        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
    }

    @Test
    void testTransferirDineroCuentas() {
        Cuenta cuenta1 = new Cuenta("Aleph Baron", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Carlos Baron", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.setNombre("Banco de Mexico");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));

        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
        assertEquals("3000", cuenta1.getSaldo().toPlainString());
    }

    @Test
    void testRelacionBancoCuentas() {
        Cuenta cuenta1 = new Cuenta("Aleph Baron", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Carlos Baron", new BigDecimal("1500.8989"));

        Banco banco = new Banco();

        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);
        banco.setNombre("Banco de Mexico");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));

        assertAll(() -> assertEquals("1000.8989", cuenta2.getSaldo().toPlainString()),
                () -> assertEquals("3000", cuenta1.getSaldo().toPlainString()),
                () -> assertEquals(2, banco.getCuentas().size()),
                () -> assertEquals("Banco de Mexico", cuenta1.getBanco().getNombre()),
                () -> assertEquals("Aleph Baron", banco.getCuentas().stream()
                    .filter(c -> c.getPersona().equals("Aleph Baron"))
                    .findFirst()
                    .get().getPersona()),
                () -> assertTrue(banco.getCuentas().stream()
                    .anyMatch(c -> c.getPersona().equals("Carlos Baron")))
        );
    }
}