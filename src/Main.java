import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    static Scanner input = new Scanner(System.in);
    public static ArrayList<String> produtos;
    public static ArrayList<Double> precoProduto;
    public static ArrayList<String> nomeVendas;
    public static ArrayList<Double> qntVendas;
    public static ArrayList<Double> precoVendas;


    //Programa
    public static void main(String[] args) {

        int opcao;

        produtos=new ArrayList<>();
        precoProduto=new ArrayList<>();
        nomeVendas=new ArrayList<>();
        qntVendas=new ArrayList<>();
        precoVendas=new ArrayList<>();


        do{
            menu();
            System.out.print("Opção: ");
            opcao=input.nextInt();

            input.nextLine();
            limpa();

            switch (opcao){
                case 1:
                    registarProduto();
                    break;
                case 2:
                    if (produtos.size()==0){
                        System.out.println("Não há produtos registados.\n");
                    }
                    else {
                        editarProduto();
                    }
                    break;
                case 3:
                    if (produtos.size()==0){
                        System.out.println("Não há produtos registados.\n");
                    }
                    else {
                        buscarProduto();
                    }
                    break;
                case 4:
                    if (produtos.size()==0){
                        System.out.println("Não há produtos registados.\n");
                    }
                    else {
                        listarProdutos();
                    }
                    break;
                case 5:
                    registarVenda();
                    break;
                case 6:
                    if (nomeVendas.size()==0){
                        System.out.println("Não há vendas registadas.\n");
                    }
                    else {
                        listarVendas();
                    }
                    break;
                case 0:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

            enter();
            limpa();

        }while (opcao!=0);

    }

    //Funcoes
    public static void menu(){
        System.out.println("\n===== Mercado =====\n");
        System.out.println("1 - Registar produto.");
        System.out.println("2 - Editar produto.");
        System.out.println("3 - Buscar produto por baliza de preços.");
        System.out.println("4 - Listar todos os produtos.");
        System.out.println();
        System.out.println("5 - Registar venda.");
        System.out.println("6 - Listar todas as vendas.");
        System.out.println();
        System.out.println("0 - Sair.\n");
    }


    public static void registarProduto(){
        String nome_produto;
        double preco;

        System.out.print("Digite o nome do produto a ser registado: ");
        nome_produto=input.nextLine();
        produtos.add(nome_produto);
        System.out.print("Digite o preço do produto: ");
        preco=input.nextDouble();
        precoProduto.add(preco);
        System.out.println("\nSUCESSO!");
        input.nextLine();

    }

    public static void editarProduto(){

        int codigo;
        String novonome;
        double novopreco;

        for (int i=0; i<produtos.size(); i++){
            System.out.println("(" + (i) + ") - {" + produtos.get(i) + "} [" + precoProduto.get(i) + "€]");
        }

        System.out.print("\nDigite o código do produto a ser editado (0 até " + (produtos.size()-1) + "): ");
        codigo=input.nextInt();
        input.nextLine();
        System.out.println();
        System.out.print("Digite o nome do produto a ser registado: ");
        novonome=input.nextLine();
        produtos.set(codigo, novonome);
        System.out.print("Digite o preço deste produto: ");
        novopreco=input.nextDouble();
        input.nextLine();
        precoProduto.set(codigo, novopreco);
        System.out.println("\nSUCESSO!");


    }


    public static void buscarProduto() {

        String busca;
        boolean encontrado = false;
        double min, max;


        System.out.print("Digite o valor mínimo de preço para a busca: ");
        min = input.nextDouble();
        System.out.print("Digite o valor máximo de preço para a busca: ");
        max = input.nextDouble();
        for (int i = 0; i < precoProduto.size(); i++) {
            if (precoProduto.get(i)>=min && precoProduto.get(i)<=max) {
                System.out.println("(" + i + ") - {" + produtos.get(i) + "} [" + precoProduto.get(i) + " €]");
            }

        }
        input.nextLine();

    }

    public static void listarProdutos(){
        System.out.println("==== Lista ====\n");
        for (int i=0; i<produtos.size(); i++){
            System.out.println("(" + i + ") - {" + produtos.get(i) + "} [" + precoProduto.get(i) + " €]");
        }
    }


    public static void registarVenda(){
        int escolha;
        double qnt_venda;


        listarProdutos();
        System.out.println();
        System.out.print("Digite o código do produto a ser vendido de (0 até " +(produtos.size()-1)+ "): ");
        escolha= input.nextInt();
        nomeVendas.add(produtos.get(escolha));
        System.out.println();
        System.out.println("(" + escolha + ") - {" + produtos.get(escolha) + "} [" + precoProduto.get(escolha) + " €]\n");
        System.out.print("Digite a quantidade a ser vendida deste produto: ");
        qnt_venda= input.nextDouble();
        qntVendas.add(qnt_venda);
        precoVendas.add(precoProduto.get(escolha)*qnt_venda);
        System.out.printf("\n("+nomeVendas.get(escolha)+") x "+qnt_venda+" = [%.2f]", precoVendas.get(precoVendas.size()-1));
        System.out.println("\n\nSUCESSO!");
        input.nextLine();
    }


    public static void listarVendas(){
        double saldo=0;

        System.out.println("==== Vendas ====\n");
        for (int i=0; i<nomeVendas.size(); i++){
            System.out.printf("("+nomeVendas.get(i)+") x "+qntVendas.get(i)+" = [%.2f]\n",precoVendas.get(i));
            saldo+=precoVendas.get(i);

        }

        System.out.println();
        System.out.printf("Saldo total das vendas: (%.2f)", saldo);

    }




















        public static void enter(){

            String enter;

            System.out.println("\nPressione ENTER para continuar...");
            enter = input.nextLine();
        }


    public static void aguarde(int ms){
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException erro){
            erro.printStackTrace();
        }
    }

    public static void limpa(){
        for(int i=0; i<15; i++){
            System.out.println();
        }
    }

}