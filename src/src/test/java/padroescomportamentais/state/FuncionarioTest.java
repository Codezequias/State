package padroescomportamentais.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    Funcionario funcionario;

    @BeforeEach
    public void setUp() {
        funcionario = new Funcionario();
    }

    @Test
    public void naoDeveAtivarFuncionarioAtivo() {
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        assertFalse(funcionario.ativar());
    }

    @Test
    public void deveAposentarFuncionarioAtivo() {
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        assertTrue(funcionario.aposentar());
        assertEquals(FuncionarioEstadoAposentado.getInstance(), funcionario.getEstado());
    }

    @Test
    public void deveAfastarFuncionarioAtivo() {
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        assertTrue(funcionario.afastar());
        assertEquals(FuncionarioEstadoAfastado.getInstance(), funcionario.getEstado());
    }

    @Test
    public void deveDemitirFuncionarioAtivo() {
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        assertTrue(funcionario.demitir());
        assertEquals(FuncionarioEstadoDemitido.getInstance(), funcionario.getEstado());
    }

    @Test
    public void deveDesligarFuncionarioAtivo() {
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        assertTrue(funcionario.desligar());
        assertEquals(FuncionarioEstadoDesligado.getInstance(), funcionario.getEstado());
    }

    @Test
    public void deveTransferirFuncionarioAtivo() {
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        assertTrue(funcionario.transferir());
        assertEquals(FuncionarioEstadoTransferido.getInstance(), funcionario.getEstado());
    }

    @Test
    public void deveAtivarFuncionarioAfastado() {
        funcionario.setEstado(FuncionarioEstadoAfastado.getInstance());
        assertTrue(funcionario.ativar());
        assertEquals(FuncionarioEstadoAtivo.getInstance(), funcionario.getEstado());
    }

    @Test
    public void deveDemitirFuncionarioAfastado() {
        funcionario.setEstado(FuncionarioEstadoAfastado.getInstance());
        assertTrue(funcionario.demitir());
        assertEquals(FuncionarioEstadoDemitido.getInstance(), funcionario.getEstado());
    }

    @Test
    public void deveDesligarFuncionarioAfastado() {
        funcionario.setEstado(FuncionarioEstadoAfastado.getInstance());
        assertTrue(funcionario.desligar());
        assertEquals(FuncionarioEstadoDesligado.getInstance(), funcionario.getEstado());
    }

    @Test
    public void naoDeveAlterarFuncionarioAposentado() {
        funcionario.setEstado(FuncionarioEstadoAposentado.getInstance());
        assertFalse(funcionario.ativar());
        assertFalse(funcionario.afastar());
        assertFalse(funcionario.demitir());
        assertFalse(funcionario.desligar());
        assertFalse(funcionario.transferir());
    }

    @Test
    public void naoDeveAlterarFuncionarioDemitido() {
        funcionario.setEstado(FuncionarioEstadoDemitido.getInstance());
        assertFalse(funcionario.ativar());
        assertFalse(funcionario.aposentar());
        assertFalse(funcionario.afastar());
        assertFalse(funcionario.desligar());
        assertFalse(funcionario.transferir());
    }

    @Test
    public void deveDemitirFuncionarioDesligado() {
        funcionario.setEstado(FuncionarioEstadoDesligado.getInstance());
        assertTrue(funcionario.demitir());
        assertEquals(FuncionarioEstadoDemitido.getInstance(), funcionario.getEstado());
    }

    @Test
    public void naoDeveAlterarFuncionarioTransferido() {
        funcionario.setEstado(FuncionarioEstadoTransferido.getInstance());
        assertFalse(funcionario.ativar());
        assertFalse(funcionario.aposentar());
        assertFalse(funcionario.afastar());
        assertFalse(funcionario.demitir());
        assertFalse(funcionario.desligar());
    }

    @Test
    public void deveRetornarNomeEstadoFuncionario() {
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        assertEquals("Ativo", funcionario.getNomeEstado());
    }
}
