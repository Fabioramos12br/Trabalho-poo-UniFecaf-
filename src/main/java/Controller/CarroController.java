package Controller;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import database.Conexao;
import model.Carro;

public class CarroController {

    public void consultarCarros () {

        try {

            Conexao conexao = new Conexao();

            Connection objConnection = conexao.getConnection();

            Statement stmt = objConnection.createStatement();

            String queryConsulta = "SELECT c.id, m.nome AS marca, c.modelo, c.ano_fab, c.cor, c.preco, c.quilometragem, c.stt_disp FROM tbl_carro c INNER JOIN tbl_marca m ON c.id_marca = m.id";

            ResultSet rs = stmt.executeQuery(queryConsulta);

            while (rs.next()) {
                
                Carro carro = new Carro();

                carro.setId(rs.getInt("id"));
                carro.setModelo(rs.getString("modelo"));
                carro.setAno_fab(rs.getInt("ano_fab"));
                carro.setCor(rs.getString("cor"));
                carro.setPreco(rs.getFloat("preco"));
                carro.setQuilometragem(rs.getFloat("quilometragem"));
                carro.setStt_disp(rs.getBoolean("stt_disp"));
                carro.setMarca(rs.getString("marca"));

                carro.exibirCarro();

               
            }


        } catch (Exception e) {
            System.out.println(e);
        }





    }

    public Boolean cadastrarCarros (Carro carro) {

        try {

            Conexao conexao = new Conexao();
            Connection objConnection = conexao.getConnection();
            Statement stmt = objConnection.createStatement();

            String queryCadastrar = "INSERT INTO tbl_carro (modelo, ano_fab, cor, preco, quilometragem, stt_disp, id_marca) VALUES ("
             + "'" + carro.getModelo() + "', "
             + carro.getAno_fab() + ", "
             + "'" + carro.getCor() + "', "
             + carro.getPreco() + ", "
             + carro.getQuilometragem() + ", "
             + carro.isStt_disp() + ", "
             + "(SELECT id FROM tbl_marca WHERE nome = '" + carro.getMarca() + "'))"; 

            stmt.executeUpdate(queryCadastrar);
            System.out.println("Carro cadastrado com sucesso!");
            return true;

        }catch (Exception e) {
            System.out.println(e);
            return false;
        }


    }

    public boolean atualizarCarros (Carro carro) {

        try {
            Conexao conexao = new Conexao();
            Connection objConnection = conexao.getConnection();
            Statement stmt = objConnection.createStatement();

            String queryAtualizar = "UPDATE tbl_carro SET" +
            " modelo = '" + carro.getModelo() + "', " +
            " ano_fab = " + carro.getAno_fab() + ", " +
            " cor = '" + carro.getCor() + "', " +
            " preco = " + carro.getPreco() + ", " +
            " quilometragem = " + carro.getQuilometragem() + ", " +
            " stt_disp = " + carro.isStt_disp() + ", " +
            " id_marca = (SELECT id FROM tbl_marca WHERE nome = '" + carro.getMarca() + "')" +
            " WHERE id = " + carro.getId();

            stmt.executeUpdate(queryAtualizar);
            System.out.println("Carro atualizado com sucesso!");
            return true;
        
            }catch (Exception e) {
            System.out.println(e);
            return false;
        }
       

    }

    public boolean deletarCarros (int id) {
        
        try {
            Conexao conexao = new Conexao();
            Connection objConnection = conexao.getConnection();
            Statement stmt = objConnection.createStatement();

            String queryDeletar = "DELETE FROM tbl_carro WHERE id = " + id;

            stmt.executeUpdate(queryDeletar);
            System.out.println("Carro deletado com sucesso!");
            return true;


        }catch (Exception e) {
            System.out.println(e);
            return false;
        }
        



    }

    

}
