package view;

import model.Base;
import model.Item;
import service.BaseService;
import service.ItemService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ItemView {
    private Scanner entrada;
    private ItemService itemService;
    private Item item;

    public ItemView(){
        entrada = new Scanner(System.in);
        itemService = new ItemService();
        item = new Item();
    }

    public void incializacao(){
        int escolha;

        do {
            menu();
            escolha = selecionaEscolhaUsuario();

            switch (escolha) {
                case 1 -> itemService.consultaTodosItens();
                case 2 -> {
                    System.out.println("Digite a coluna que você deseja consultar: ");
                    String column = entrada.nextLine();
                    itemService.consultaColunaEspecifica(column);
                }
                case 3 -> {
                    System.out.println("Digite o nome do item que deseja inserir: ");
                    String nome = entrada.nextLine();
                    item.setNome(nome);
                    System.out.println("digite o valor do item :");
                    Double valor = entrada.nextDouble();
                    item.setValor(valor);
                    System.out.println("digite o id da base");
                    Long baseId = entrada.nextLong();
                    itemService.inseriItem(nome,valor,baseId);

                }
                case 4 -> {
                    System.out.println("Digite o id que deseja atualizar: ");
                    Long idParaAtualizar = entrada.nextLong();
                    entrada.nextLine();
                    System.out.println("Digite o campo que deseja atualizar: ");
                    String campoAtualizar = entrada.nextLine();
                    System.out.println("digite o dado que deseja alterar");
                    String dadoAtualizar = entrada.nextLine();
                    itemService.atualizaCampoItem(idParaAtualizar, campoAtualizar, dadoAtualizar);
                }
                case 5 -> {
                    System.out.println("Digite o id que deseja deletar: ");
                    Long idParaDeletar = entrada.nextLong();
                    entrada.nextLine();
                    itemService.deletaDadosItem(idParaDeletar);
                }
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Escolha inválida. Insira de 1 - 6");
            }
        }while(escolha != 6);
    }

    public void menu(){
        System.out.println("THE FORCE BE WITH YOU!!");
        System.out.println("Digite uma das opções abaixo");
        System.out.println("1 - Consulta todos os itens");
        System.out.println("2 - Consulta item por campo específico");
        System.out.println("3 - cadastro novo item");
        System.out.println("4 - Atualiza um dado do item");
        System.out.println("5 - excluir uma item existente");
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
