package view;

import model.Inventario;
import model.Rebelde;
import service.RebeldeService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RebeldeView {
    private Scanner entrada;
    private RebeldeService rebeldeService;
    private Rebelde rebelde;

    public RebeldeView(){
        entrada = new Scanner(System.in);
        rebeldeService = new RebeldeService();
        rebelde = new Rebelde();
    }

    public void incializacao(){
        int escolha;

        do {
            menu();
            escolha = selecionaEscolhaUsuario();

            switch (escolha) {
                case 1 -> rebeldeService.consultaTodosRebeldes();
                case 2 -> {
                    System.out.println("Digite a coluna que você deseja consultar: ");
                    String column = entrada.nextLine();
                    rebeldeService.consultaColunaEspecifica(column);
                }
                case 3 -> {
                    System.out.println("Digite o nome que deseja inserir: ");
                    String nome = entrada.nextLine();
                    rebelde.setNome(nome);
                    System.out.println("digite a idade do rebelde :");
                    int idade = entrada.nextInt();
                    entrada.nextLine();
                    rebelde.setIdade(idade);
                    System.out.println("digite o genero do rebelde");
                    String genero = entrada.nextLine();
                    rebelde.setGenero(genero);
                    System.out.println("marque true ou false para saber se é traidor");
                    boolean isTraidor = entrada.nextBoolean();
                    rebelde.setTraidor(isTraidor);
                    System.out.println("informe a id da base: ");
                    Long idBase = entrada.nextLong();
                    rebelde.setLocalizacao(idBase);
                    System.out.println("informe o id do inventario");
                    Long idInventario = entrada.nextLong();
                    System.out.println("informe o id do item");
                    Long idItem = entrada.nextLong();
                    Inventario inventario = new Inventario(idInventario, rebelde.getId(), idItem);
                    rebelde.setInventario(inventario);
                    rebeldeService.inseriRebelde(nome, idade, genero, isTraidor, idBase, inventario);
                }
                case 4 -> {
                    System.out.println("Digite o id que deseja atualizar: ");
                    Long idParaAtualizar = entrada.nextLong();
                    entrada.nextLine();
                    System.out.println("Digite o campo que deseja atualizar: ");
                    String campoAtualizar = entrada.nextLine();
                    System.out.println("digite o dado que deseja alterar");
                    String dadoAtualizar = entrada.nextLine();
                    rebeldeService.atualizaCampoRebelde(idParaAtualizar, campoAtualizar, dadoAtualizar);
                }
                case 5 -> {
                    System.out.println("Digite o id que deseja deletar: ");
                    Long idParaDeletar = entrada.nextLong();
                    entrada.nextLine();
                    rebeldeService.deletaDadosNaTabela(idParaDeletar);
                }
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Escolha inválida. Insira de 1 - 6");
            }
        }while(escolha != 6);
    }

    public void menu(){
        System.out.println("THE FORCE BE WITH YOU!!");
        System.out.println("Digite uma das opções abaixo");
        System.out.println("1 - Consulta todos os rebeldes");
        System.out.println("2 - Consulta rebelde por campo específico");
        System.out.println("3 - cadastro novo rebelde");
        System.out.println("4 - Atualiza um dado do rebelde");
        System.out.println("5 - excluir um rebelde existente");
        System.out.println("6 - Sair do menu");
    }

    public int selecionaEscolhaUsuario(){
        try{
            int escolha = entrada.nextInt();
            entrada.nextLine();
            return escolha;
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
            entrada.nextLine();
        }
        return 1;
    }

}

