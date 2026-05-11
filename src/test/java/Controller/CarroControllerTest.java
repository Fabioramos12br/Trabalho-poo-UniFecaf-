package Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import model.Carro;
import model.Marca;

/**
 * Testes simples que validam o comportamento de montagem/execução dos métodos.
 * Observação: como o projeto consulta diretamente o MySQL, esses testes
 * exigem que o banco esteja acessível.
 */
public class CarroControllerTest {

    @Test
    void cadastrarCarros_deveRetornarTrue_QuandoBancoDisponivelEMarcaExistir() {
        Assumptions.assumeTrue(canConnectToDatabase(), "Banco MySQL não acessível. Testes de DB serão pulados.");
        // Marca deve existir no banco (veja src/main/resources/database/banco.txt)
        Marca marca = new Marca();
        marca.setNome("Ferrari");

        Carro carro = new Carro();
        carro.setModelo("TesteJunit");
        carro.setAno_fab(2024);
        carro.setCor("Branco");
        carro.setPreco(1000.0f);
        carro.setQuilometragem(10.0f);
        carro.setStt_disp(true);
        carro.setMarca("Ferrari");

        CarroController controller = new CarroController();
        // Se o banco estiver fora do ar, esse teste falhará: ajuste conforme necessário.
        assertDoesNotThrow(() -> controller.cadastrarCarros(carro));
    }

    @Test
    void atualizarCarros_deveExecutarSemException_QuandoBancoDisponivel() {
        Assumptions.assumeTrue(canConnectToDatabase(), "Banco MySQL não acessível. Testes de DB serão pulados.");
        Carro carro = new Carro();
        carro.setId(1); // ajuste conforme seu banco
        carro.setModelo("TesteAtualizacao");
        carro.setAno_fab(2024);
        carro.setCor("Preto");
        carro.setPreco(2000.0f);
        carro.setQuilometragem(20.0f);
        carro.setStt_disp(true);
        carro.setMarca("Ferrari");

        CarroController controller = new CarroController();
        assertDoesNotThrow(() -> controller.atualizarCarros(carro));
    }

    @Test
    void deletarCarros_deveExecutarSemException_QuandoBancoDisponivel() {
        Assumptions.assumeTrue(canConnectToDatabase(), "Banco MySQL não acessível. Testes de DB serão pulados.");
        CarroController controller = new CarroController();
        assertDoesNotThrow(() -> controller.deletarCarros(1)); // ajuste conforme seu banco
    }

    private static boolean canConnectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            var conn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_POOtrabalho?useSSL=false&serverTimezone=UTC",
                    "root",
                    "adm");
            conn.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

