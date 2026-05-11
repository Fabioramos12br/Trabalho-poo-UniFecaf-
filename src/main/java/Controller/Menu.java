package Controller;

import java.util.Scanner;
import database.Conexao;
import model.Marca;
import model.Moto;
import model.Carro;


public class Menu {

    public void Exec_menu() {
        Boolean exit = false;
        Scanner sc = new Scanner(System.in);
        Conexao conexao = new Conexao();
        conexao.getConnection();
        MarcaController marcaController = new MarcaController();
        CarroController carroController = new CarroController();
        MotoController motoController = new MotoController();



        while (!exit) {
            System.out.println("--------------------- BEM VINDO! ---------------------");
            System.out.println("1 - Cadastrar Marca");
            System.out.println("2 - Cadastrar Veiculo ");
            System.out.println("3 - Consultar Veiculos");
            System.out.println("4 - Atualizar Veiculos");
            System.out.println("5 - Deletar Veiculos");
            System.out.println("6 - Sair");
        
            System.out.print("Escolha uma opção:");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: //cadastrar marca

                    Marca marca = new Marca();
                    marca.CadastrarMarca();

                    Boolean valida = marcaController.cadastrar(marca);

                    if (valida)
                        System.out.println();
                    else
                        System.out.println("Erro ao cadastrar marca!");

                    break;

                case 2: //cadastra veiculos


                    System.out.println("1 - Carro");
                    System.out.println("2 - Moto");
                    System.out.print("você deseja cadastrar carro ou moto?");

                    int opcaoCadastro = sc.nextInt();
                    sc.nextLine();

                    switch (opcaoCadastro) {
                        case 1:
                            Carro carro = new Carro();
                            carro.CadastrarCarro();

                            Boolean validaCarro = carroController.cadastrarCarros(carro);

                            if (validaCarro)
                                System.out.println();
                            else
                                System.out.println("Erro ao cadastrar carro!");
                            
                            break;
                    
                        case 2:
                            Moto moto = new Moto();
                            moto.CadastrarMoto();

                            Boolean validaMoto = motoController.cadastrarMotos(moto);

                            if (validaMoto)
                                System.out.println();
                            else
                                System.out.println("Erro ao cadastrar moto!");

                            break;
                    
                        default:
                            break;
                    }
                
                    break;

                case 3: //consultar

                    System.out.println("1 - Carro");
                    System.out.println("2 - Moto");
                    System.out.print("você deseja consultar carro ou moto?");

                    int opcaoConsulta = sc.nextInt();
                    sc.nextLine();

                    switch (opcaoConsulta) {
                        case 1:
                            carroController.consultarCarros();
                            break;
                        
                        case 2:
                            motoController.consultarMotos();
                            break;
                    
                        default:
                            break;
                    }

                    break;

                case 4: //atualizar
                    System.out.println("1 - Carro");
                    System.out.println("2 - Moto");
                    System.out.print("você deseja atualizar carro ou moto?");

                    int opcaoatualizar = sc.nextInt();
                    sc.nextLine();

                    switch (opcaoatualizar) {
                        case 1:
                            carroController.consultarCarros();
                            Carro carro = new Carro();
                            carro.AtualizarCarro();

                            boolean validaAtualizar = carroController.atualizarCarros(carro);

                            if (validaAtualizar)
                                System.out.println();
                            else
                                System.out.println("Erro ao atualizar carro!");

                            break;
                        
                        case 2:
                            motoController.consultarMotos();
                            Moto moto = new Moto();
                            moto.AtualizarMoto();

                            boolean validaAtualizarMoto = motoController.atualizarMotos(moto);

                            if (validaAtualizarMoto) {
                                System.out.println();
                            } else {
                                System.out.println("Erro ao atualizar moto!");
                            }
                            
                            break;
                    
                        default:
                            break;
                        }
                    break;

                case 5: //deletar

                    System.out.println("1 - Carro");
                    System.out.println("2 - Moto");
                    System.out.print("você deseja deletar carro ou moto?");

                    int opcaoDeletar = sc.nextInt();
                    sc.nextLine();

                    switch (opcaoDeletar) {
                        case 1:
                            carroController.consultarCarros();
                            System.out.print("Informe o ID do carro que deseja deletar:");
                            int id = sc.nextInt();
                            sc.nextLine();
                            
                            boolean validaDeletar = carroController.deletarCarros(id);

                            if (validaDeletar)
                                System.out.println();
                            else
                                System.out.println("Erro ao deletar carro!");


                            break;

                        case 2:
                            motoController.consultarMotos();
                            System.out.print("Informe o ID da moto que deseja deletar:");
                            int idMoto = sc.nextInt();
                            sc.nextLine();
                            
                            boolean validaDeletarMoto = motoController.deletarMotos(idMoto);

                            if (validaDeletarMoto)
                                System.out.println();
                            else
                                System.out.println("Erro ao deletar moto!");

                            break;
                        
                        default:
                            break;
                    }
                
                    break;

                case 6:
                    exit = true;
                    sc.close();
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
