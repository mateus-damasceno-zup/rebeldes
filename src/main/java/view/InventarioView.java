package view;

import model.Inventario;
import model.Rebelde;
import service.InventarioService;
import service.RebeldeService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InventarioView {
    private Scanner entrada;
    private InventarioService inventarioService;
    private Inventario inventario;

    public InventarioView(){
        entrada = new Scanner(System.in);
        inventarioService = new InventarioService();
        inventario = new Inventario();
    }

    public void incializacao(){
        int escolha;

        do {
            menu();
            escolha = selecionaEscolhaUsuario();

            switch (escolha) {
                case 1 -> inventarioService.consultaTodosInventarios();
                case 2 -> {
                    System.out.println("Digite a coluna que você deseja consultar: ");
                    String column = entrada.nextLine();
                    inventarioService.consultaColunaEspecifica(column);
                }
                case 3 -> {
                    System.out.println("Digite o id do inventario que deseja inserir: ");
                    Long idInventario = entrada.nextLong();
                    inventario.setId(idInventario);
                    System.out.println("digite o id do rebelde: ");
                    Long rebeldeId = entrada.nextLong();
                    inventario.setRebeldeId(rebeldeId);
                    System.out.println("digite o id do item");
                    Long itemId = entrada.nextLong();
                    inventario.setItemId(itemId);
                    inventarioService.inseriInventario(idInventario,rebeldeId,itemId);
                }
                case 4 -> {
                    System.out.println("Digite o id que deseja atualizar: ");
                    Long idParaAtualizar = entrada.nextLong();
                    entrada.nextLine();
                    System.out.println("Digite o campo que deseja atualizar: ");
                    String campoAtualizar = entrada.nextLine();
                    System.out.println("digite o dado que deseja alterar");
                    String dadoAtualizar = entrada.nextLine();
                    inventarioService.atualizaCampoInventario(idParaAtualizar, campoAtualizar, dadoAtualizar);
                }
                case 5 -> {
                    System.out.println("Digite o id que deseja deletar: ");
                    Long idParaDeletar = entrada.nextLong();
                    entrada.nextLine();
                    inventarioService.deletaDadosNoInventario(idParaDeletar);
                }
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Escolha inválida. Insira de 1 - 6");
            }
        }while(escolha != 6);
    }

    public void menu(){
        System.out.println("THE FORCE BE WITH YOU!!");
        System.out.println("Digite uma das opções abaixo");
        System.out.println("1 - Consulta todos os inventarios");
        System.out.println("2 - Consulta inventarios por campo específico");
        System.out.println("3 - cadastro novo inventario");
        System.out.println("4 - Atualiza um dado do inventarios");
        System.out.println("5 - excluir um inventarios existente");
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
