package br.com.unifecaf.demo;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import Controller.Menu;
import database.Conexao;


@SpringBootApplication
public class App {
    Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("Spring Boot iniciado com sucesso!");
        Conexao conexao = new Conexao();
        conexao.getConnection();
		Menu menu = new Menu();
		menu.Exec_menu();
	}

}
