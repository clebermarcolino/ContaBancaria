package test;

import banco.ContaBanco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ContaBancoTest {
    private ContaBanco conta;

    @BeforeEach
    public void setUp() {
        conta = new ContaBanco();
    }

    @Test
    public void testAbrirContaCC() {
        conta.abrirConta("cc");
        assertTrue(conta.isStatus());
        assertEquals("cc", conta.getTipoConta());
        assertEquals(50, conta.getSaldo());
    }

    @Test
    public void testAbrirContaCP() {
        conta.abrirConta("cp");
        assertTrue(conta.isStatus());
        assertEquals("cp", conta.getTipoConta());
        assertEquals(150, conta.getSaldo());
    }

    @Test
    public void testDepositar() {
        conta.abrirConta("cc");
        double valorDeposito = 100;
        conta.depositar(valorDeposito);
        assertEquals(150, conta.getSaldo());
    }

    @Test
    public void testSacar() {
        conta.abrirConta("cc");
        conta.depositar(100);
        double valorSaque = 70;
        conta.sacar(valorSaque);
        assertEquals(80, conta.getSaldo());
    }

    @Test
    public void testFecharContaComSaldo() {
        conta.abrirConta("cc");
        conta.depositar(100);
        conta.fecharConta();
        assertTrue(conta.isStatus());
    }

    @Test
    public void testFecharContaSemSaldo() {
        conta.abrirConta("cc");
        conta.sacar(50);
        conta.fecharConta();
        assertFalse(conta.isStatus());
    }

    @Test
    public void testPagarMensalidadeContaCorrente() {
        conta.abrirConta("cc");
        conta.depositar(100);

        conta.pagarMensalidade();
        assertEquals(138, conta.getSaldo());
    }

    @Test
    public void testPagarMensalidadeContaPoupanca() {
        conta.abrirConta("cp");
        conta.depositar(90);

        conta.pagarMensalidade();
        assertEquals(220, conta.getSaldo());
    }
}
