package org.cbaron.junit5app.ejemplos.models;

import org.cbaron.junit5app.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//This will allow us to create all test method in only one instance, so it'll not be stateless!
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CuentaTest {

    Cuenta cuenta;
    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicializando el test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando el test");
    }

    @BeforeEach
    void initMetodoTest(TestInfo testInfo, TestReporter testReporter) {
        this.cuenta = new Cuenta("Aleph", new BigDecimal("1000.12345"));
        this.testInfo = testInfo;
        this.testReporter = testReporter;

        System.out.println("Iniciando el metodo de prueba");
        testReporter.publishEntry("Ejecutando: " + testInfo.getDisplayName() + " " + testInfo.getTestMethod().orElse(null).getName()
                + " con la etiquetas " + testInfo.getTags());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando el metodo de prueba");
    }

    @Tag("cuenta")
    @Nested
    @DisplayName("Probando atributos de Cuenta")
    class CuentaTestNombreYSaldo {
        @Test
        //@Disabled
        @DisplayName("Probando el nombre de la cuenta corriente!")
        void testNombreCuenta() {
            //fail();
            String esperado = "Aleph";
            String real = cuenta.getPersona();

            System.out.println(testInfo.getTags());

            if (testInfo.getTags().contains("cuenta")) {
                System.out.println("Hacer algo con la etiqueta");
            }

            assertNotNull(real, () -> "La cuenta no puede ser nula");
            assertEquals(esperado, real, () -> "El nombre de la cuenta no es el que se esperaba");
            assertTrue(real.equals("Aleph"), () -> "Nombre de la cuenta esperada debe ser igual a la real");
        }

        @Test
        @DisplayName("Probando el saldo de la cuenta corriente")
        void testSaldoCuenta() {
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
    }

    @Nested
    class CuentaOperacionesTest {
        @Test
        @Tag("cuenta")
        void testDebitoCuenta() {
            cuenta.debito(new BigDecimal("100"));

            assertNotNull(cuenta.getSaldo());
            assertEquals(900, cuenta.getSaldo().intValue());
            assertEquals("900.12345", cuenta.getSaldo().toPlainString());

        }

        @Test
        @Tag("cuenta")
        void testCreditoCuenta() {
            cuenta.credito(new BigDecimal("100"));

            assertNotNull(cuenta.getSaldo());
            assertEquals(1100, cuenta.getSaldo().intValue());
            assertEquals("1100.12345", cuenta.getSaldo().toPlainString());

        }


        @Test
        @Tag("cuenta")
        @Tag("banco")
        void testTransferirDineroCuentas() {
            Cuenta cuenta1 = new Cuenta("Aleph Baron", new BigDecimal("2500"));
            Cuenta cuenta2 = new Cuenta("Carlos Baron", new BigDecimal("1500.8989"));

            Banco banco = new Banco();
            banco.setNombre("Banco de Mexico");
            banco.transferir(cuenta2, cuenta1, new BigDecimal(500));

            assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
            assertEquals("3000", cuenta1.getSaldo().toPlainString());
        }
    }

    @Test
    @Tag("cuenta")
    @Tag("exception")
    void testDineroInsuficienteException() {
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1500));
        });

        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
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

    @Nested
    class SistemaOperativoTest {
        @Test
        @EnabledOnOs(OS.WINDOWS)
        void testSoloWindows() {
        }

        @Test
        @EnabledOnOs({OS.LINUX, OS.MAC})
        void testSoloLinuxMac() {
        }

        @Test
        @DisabledOnOs({OS.LINUX, OS.MAC})
        void testNoLinuxMac() {
        }
    }

    @Nested
    class JavaVersionTest {
        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void soloJdk8() {
        }

        @Test
        @EnabledOnJre(JRE.JAVA_17)
        void soloJdk17() {
        }

        @Test
        @DisabledOnJre(JRE.JAVA_17)
        void disable() {
        }
    }

    @Nested
    class SystemPropertiesTest {
        @Test
        void imprimirSystemProperties() {
            Properties properties = System.getProperties();
            properties.forEach((key, value) -> System.out.println(key + ":" + value));
        }

        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = "17.*")
        void testJavaVersion() {
        }

        @Test
        @DisabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
        void testDisable64() {
        }

        @Test
        @EnabledIfSystemProperty(named = "user.name", matches = "cbaron")
        void testUsername() {
        }

        @Test
        @EnabledIfSystemProperty(named = "ENV", matches = "dev")
        void testDev() {
        }
    }

    @Nested
    class VariableAmbienteTest {
        @Test
        void imprimirVariablesEnv() {
            Map<String, String> getenv = System.getenv();
            getenv.forEach((key, value) -> System.out.println(key + ":" + value));
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = "/Users/cbaron/java/jdk-17.0.2.jdk/Contents/Home")
        void testJavaHome() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "USER", matches = "cbaron")
        void testUser() {
        }

        @Test
        void testSaldoCuentaDev() {
            boolean esDev = "DEV".equals(System.getProperty("ENV"));

            assumeTrue(esDev);
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @Test
        void testSaldoCuentaDev2() {
            boolean esDev = "DEV".equals(System.getProperty("ENV"));
            //This will execute the method, but only the block inside the assumingThat will be "ignored"
            assumingThat(esDev, () -> {
                assertNotNull(cuenta.getSaldo());
                assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            });
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }
    }


    @RepeatedTest(value = 5, name = "Repeticion numero {currentRepetition} de {totalRepetitions}")
    void testDebitoCuentaRepetido(RepetitionInfo info) {

        if (info.getCurrentRepetition() == 3) {
            System.out.println("Estamos en la repeticion: " + info.getCurrentRepetition());
        }

        cuenta.debito(new BigDecimal("100"));

        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Tag("param")
    @Nested
    class PruebasParemetrizadasTest {
        @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
        @ValueSource(strings = {"100", "200", "500", "700", "1000"})
        void testDebitoCuentaValueSource(String monto) {
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
        @CsvSource({"1,100", "2,200", "3,500", "4,700", "5,1000"})
        void testDebitoCuentaCsvSource(String index, String monto) {
            System.out.println(index + "->" + monto);
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
        @CsvSource({"200, 100, Aleph, Aleph", "250, 200, Carlos, Carlos", "550, 500, Baron, Baron", "750, 700, Gonzalez, Gonzalez", "1050, 1000, Andres, Andres"})
        void testDebitoCuentaCsvSource2(String saldo, String monto, String esperado, String actual) {
            System.out.println(saldo + "->" + monto);
            cuenta.setPersona(actual);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado,actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
        @CsvFileSource(resources = "/data.csv")
        void testDebitoCuentaCsvFileSource(String monto) {
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
        @CsvFileSource(resources = "/data2.csv")
        void testDebitoCuentaCsvFileSource2(String saldo, String monto, String esperado, String actual) {
            cuenta.setPersona(actual);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado,actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }
    }

    @Tag("param")
    @ParameterizedTest(name = "numero {index} ejecutando con valor {argumentsWithNames}")
    @MethodSource("montoList")
    void testDebitoCuentaMethodSource(String monto) {
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    static List<String> montoList() {
        return Arrays.asList("100", "200", "500", "700", "1000");
    }
}