package view;

import model.Base;

import model.Inventario;
import model.Rebelde;
import service.BaseService;
import service.RebeldeService;


import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseView {
    private Scanner entrada;
    private BaseService baseService;
    private Base base;

    public BaseView(){
        entrada = new Scanner(System.in);
        baseService = new BaseService();
        base = new Base();
    }

    public void incializacao(){
        int escolha;

        do {
            menu();
            escolha = selecionaEscolhaUsuario();

            switch (escolha) {
                case 1 -> baseService.consultaTodasBases();
                case 2 -> {
                    System.out.println("Digite a coluna que você deseja consultar: ");
                    String column = entrada.nextLine();
                    baseService.consultaColunaEspecifica(column);
                }
                case 3 -> {
                    System.out.println("Digite o nome da base que deseja inserir: ");
                    String nome = entrada.nextLine();
                    base.setNome(nome);
                    System.out.println("digite o id do item :");
                    Long itemId = entrada.nextLong();
                    base.setItensId(itemId);
                    System.out.println("digite o id do rebelde");
                    Long rebeldeId = entrada.nextLong();
                    baseService.inseriBase(nome,itemId,rebeldeId);

                }
                case 4 -> {
                    System.out.println("Digite o id que deseja atualizar: ");
                    Long idParaAtualizar = entrada.nextLong();
                    entrada.nextLine();
                    System.out.println("Digite o campo que deseja atualizar: ");
                    String campoAtualizar = entrada.nextLine();
                    System.out.println("digite o dado que deseja alterar");
                    String dadoAtualizar = entrada.nextLine();
                    baseService.atualizaCampoBase(idParaAtualizar, campoAtualizar, dadoAtualizar);
                }
                case 5 -> {
                    System.out.println("Digite o id que deseja deletar: ");
                    Long idParaDeletar = entrada.nextLong();
                    entrada.nextLine();
                    baseService.deletaDadosNaBase(idParaDeletar);
                }
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Escolha inválida. Insira de 1 - 6");
            }
        }while(escolha != 6);
    }

    public void menu(){
        System.out.println("THE FORCE BE WITH YOU!!");
        System.out.println("Digite uma das opções abaixo");
        System.out.println("1 - Consulta todos as bases");
        System.out.println("2 - Consulta base por campo específico");
        System.out.println("3 - cadastro nova base");
        System.out.println("4 - Atualiza um dado da base");
        System.out.println("5 - excluir uma base existente");
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
