package Controller;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import database.Conexao;
import model.Moto;

public class MotoController {

    public void consultarMotos () {

        try {

            Conexao conexao = new Conexao();

            Connection objConnection = conexao.getConnection();

            Statement stmt = objConnection.createStatement();

            String queryConsulta = "SELECT c.id, m.nome AS marca, c.modelo, c.ano_fab, c.cor, c.preco, c.quilometragem, c.stt_disp FROM tbl_moto c INNER JOIN tbl_marca m ON c.id_marca = m.id";

            ResultSet rs = stmt.executeQuery(queryConsulta);

            while (rs.next()) {
                
                Moto moto = new Moto();

                moto.setId(rs.getInt("id"));
                moto.setModelo(rs.getString("modelo"));
                moto.setAno_fab(rs.getInt("ano_fab"));
                moto.setCor(rs.getString("cor"));
                moto.setPreco(rs.getFloat("preco"));
                moto.setQuilometragem(rs.getFloat("quilometragem"));
                moto.setStt_disp(rs.getBoolean("stt_disp"));
                moto.setMarca(rs.getString("marca"));

                moto.exibirMoto();

               
            }


        } catch (Exception e) {
            System.out.println(e);
        }





    }

    public Boolean cadastrarMotos (Moto moto) {

        try {

            Conexao conexao = new Conexao();
            Connection objConnection = conexao.getConnection();
            Statement stmt = objConnection.createStatement();

            String queryCadastrar = "INSERT INTO tbl_moto (modelo, ano_fab, cor, preco, quilometragem, stt_disp, id_marca) VALUES ("
             + "'" + moto.getModelo() + "', "
             + moto.getAno_fab() + ", "
             + "'" + moto.getCor() + "', "
             + moto.getPreco() + ", "
             + moto.getQuilometragem() + ", "
             + moto.isStt_disp() + ", "
             + "(SELECT id FROM tbl_marca WHERE nome = '" + moto.getMarca() + "'))"; 

            stmt.executeUpdate(queryCadastrar);
            System.out.println("Moto cadastrada com sucesso!");
            return true;

        }catch (Exception e) {
            System.out.println(e);
            return false;
        }


    }

    public boolean atualizarMotos (Moto moto) {

        try {
            Conexao conexao = new Conexao();
            Connection objConnection = conexao.getConnection();
            Statement stmt = objConnection.createStatement();

            String queryAtualizar = "UPDATE tbl_moto SET" +
            " modelo = '" + moto.getModelo() + "', " +
            " ano_fab = " + moto.getAno_fab() + ", " +
            " cor = '" + moto.getCor() + "', " +
            " preco = " + moto.getPreco() + ", " +
            " quilometragem = " + moto.getQuilometragem() + ", " +
            " stt_disp = " + moto.isStt_disp() + ", " +
            " id_marca = (SELECT id FROM tbl_marca WHERE nome = '" + moto.getMarca() + "')" +
            " WHERE id = " + moto.getId();

            stmt.executeUpdate(queryAtualizar);
            System.out.println("Moto atualizada com sucesso!");
            return true;
        
            }catch (Exception e) {
            System.out.println(e);
            return false;
        }
       

    }

    public boolean deletarMotos (int id) {
        
        try {
            Conexao conexao = new Conexao();
            Connection objConnection = conexao.getConnection();
            Statement stmt = objConnection.createStatement();

            String queryDeletar = "DELETE FROM tbl_moto WHERE id = " + id;

            stmt.executeUpdate(queryDeletar);
            System.out.println("Moto deletada com sucesso!");
            return true;


        }catch (Exception e) {
            System.out.println(e);
            return false;
        }
        



    }

    

}
