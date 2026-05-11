package Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import model.Marca;

public class MarcaControllerTest {

    @Test
    void validarMarca_deveRetornarTrue_paraFerrari_SeExistirNoBanco() {
        Assumptions.assumeTrue(canConnectToDatabase(), "Banco MySQL não acessível. Testes de DB serão pulados.");

        MarcaController controller = new MarcaController();
        assertTrue(controller.validarMarca("Ferrari"));
    }

    @Test
    void cadastrar_deveRetornarTrue_quandoBancoDisponivel() {
        Assumptions.assumeTrue(canConnectToDatabase(), "Banco MySQL não acessível. Testes de DB serão pulados.");

        // Recomendação: se "JunitMarca" já existir no banco, esse teste pode falhar.
        Marca marca = new Marca();
        marca.setNome("JunitMarca");

        MarcaController controller = new MarcaController();
        assertDoesNotThrow(() -> controller.cadastrar(marca));
    }

    private static boolean canConnectToDatabase() {
        try {
            // Credenciais devem bater com database.Conexao.
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

