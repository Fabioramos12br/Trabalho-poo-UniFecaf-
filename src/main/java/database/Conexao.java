package database;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
    private String servidor, banco, usuario, senha;
    public Connection conexao;
    
    public Conexao() {
        servidor = "localhost";
        banco = "db_POOtrabalho";
        usuario = "root"; // <--- altere para conectar ao seu banco
        senha = "adm"; // <--- altere para conectar ao seu banco
    }

    public boolean connectDrive() {
        try{

            this.conexao = DriverManager.getConnection("jdbc:mysql://" + 
            this.servidor + 
            "/" + this.banco, 
            this.usuario, 
            this.senha);
            return true;

        }catch(Exception e){
            System.out.println(e);
            return false;

        }
        

    } 

    public Connection getConnection() {
        boolean validaConexao = connectDrive();  
        
        if (validaConexao) {
            return this.conexao;
        }
        return null;
    }

















}







