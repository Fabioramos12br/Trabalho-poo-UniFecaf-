package Controller;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import database.Conexao;   
import model.Marca;



public class MarcaController {
    
    public Boolean cadastrar (Marca marca) {

        try {
            Conexao conexao = new Conexao();
            Connection objConnection = conexao.getConnection();
            Statement stmt = objConnection.createStatement();

            String queryCadastrar = "Insert into tbl_marca (nome) values('" + marca.getNome() + "')";

            stmt.executeUpdate(queryCadastrar);
            System.out.println("Marca cadastrada com sucesso!");

            return true;

        }catch (Exception e) {
            System.out.println(e);
            return false;
        }
        

    }

    public boolean validarMarca (String marca) {

        try{ 
            Conexao conexao = new Conexao();
            Connection objConnection = conexao.getConnection();
            Statement stmt = objConnection.createStatement();

            String queryConsulta = "SELECT * FROM tbl_marca WHERE nome = '" + marca + "'";

            ResultSet rs = stmt.executeQuery(queryConsulta);

            return rs.next();

        }catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }




}

