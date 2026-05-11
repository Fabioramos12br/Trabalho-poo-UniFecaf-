package model;
import Controller.MarcaController;
import java.util.Scanner;


public class Moto {

    private int id;
    private String modelo;
    private int ano_fab;
    private String cor;
    private float preco;
    private float quilometragem;
    private boolean stt_disp;
    private String marca;
    
    Scanner sc = new Scanner(System.in);
    
    public void exibirMoto() {
        System.out.println("==================  INFORMAÇÕES DA MOTO  ===================");
        System.out.println("ID: " + this.id);
        System.out.println("MODELO: " + this.modelo);
        System.out.println("ANO DE FABRICAÇÃO: " + this.ano_fab);
        System.out.println("COR: " + this.cor);
        System.out.println("PREÇO: " + this.preco);
        System.out.println("QUILOMETRAGEM: " + this.quilometragem);
        System.out.println("STATUS DE DISPONIBILIDADE: " + this.stt_disp);  
        System.out.println("MARCA: " + this.marca);
        
    }

    public void CadastrarMoto() {
        MarcaController marcaController = new MarcaController();
        
        System.out.print("Informe o modelo da Moto:");
        this.modelo = sc.nextLine();
        System.out.print("Informe o ano de fabricação da Moto:");
        this.ano_fab = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Informe a cor da Moto:");
        this.cor = sc.nextLine();
        System.out.print("Informe o preço da Moto:");
        this.preco = sc.nextFloat();
        System.out.print("Informe a quilometragem da Moto:");
        this.quilometragem = sc.nextFloat();
        System.out.print("Informe o status de disponibilidade da Moto (true/false):");
        this.stt_disp = sc.nextBoolean();
        sc.nextLine(); 
        
        boolean marcaExiste = false;
        
        while (!marcaExiste) {
            System.out.print("Informe a marca da Moto:");
            this.marca = sc.nextLine();
            
            marcaExiste = marcaController.validarMarca(this.marca);
            
            if (!marcaExiste) {
                System.out.println("Marca inválida! Tente novamente");
            }
        }
        System.out.println("Moto cadastrada com sucesso!");


    }

    public void AtualizarMoto() {
        System.out.println("Informe o ID da Moto que deseja atualizar:");
        this.id = sc.nextInt();
        sc.nextLine();
        System.out.print("Informe o modelo da Moto:");
        this.modelo = sc.nextLine();
        System.out.print("Informe o ano de fabricação da Moto:");
        this.ano_fab = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Informe a cor da Moto:");
        this.cor = sc.nextLine();
        System.out.print("Informe o preço da Moto:");
        this.preco = sc.nextFloat();
        System.out.print("Informe a quilometragem da Moto:");
        this.quilometragem = sc.nextFloat();
        System.out.print("Informe o status de disponibilidade da Moto (true/false):");
        this.stt_disp = sc.nextBoolean();
        sc.nextLine(); 
        System.out.println("Informe a marca da Moto:");
        this.marca = sc.nextLine();
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public int getAno_fab() {
        return ano_fab;
    }


    public void setAno_fab(int ano_fab) {
        this.ano_fab = ano_fab;
    }


    public String getCor() {
        return cor;
    }


    public void setCor(String cor) {
        this.cor = cor;
    }


    public float getPreco() {
        return preco;
    }


    public void setPreco(float preco) {
        this.preco = preco;
    }


    public float getQuilometragem() {
        return quilometragem;
    }


    public void setQuilometragem(float quilometragem) {
        this.quilometragem = quilometragem;
    }


    public boolean isStt_disp() {
        return stt_disp;
    }


    public void setStt_disp(boolean stt_disp) {
        this.stt_disp = stt_disp;
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }

    

    

}