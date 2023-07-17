package view;


import model.RelatorioTraidor;
import service.RelatorioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RelatorioView {
    private Scanner entrada;
    private RelatorioService relatorioService;
    private RelatorioTraidor relatorioTraidor;

    public RelatorioView(){
        entrada = new Scanner(System.in);
        relatorioService = new RelatorioService();
        relatorioTraidor = new RelatorioTraidor();
    }

    public void incializacao(){
        int escolha;

        do {
            menu();
            escolha = selecionaEscolhaUsuario();

            switch (escolha) {
                case 1 -> relatorioService.consultaTodosRelatorios();
                case 2 -> {
                    System.out.println("Digite a coluna que você deseja consultar: ");
                    String column = entrada.nextLine();
                    relatorioService.consultaColunaEspecifica(column);
                }
                case 3 -> {
                    System.out.println("Digite o id do relator: ");
                    Long idRelator = entrada.nextLong();
                    relatorioTraidor.setRebeldeIdRelator(idRelator);
                    System.out.println("digite o id do relatado :");
                    Long idRelatado = entrada.nextLong();
                    relatorioTraidor.setRebeldeIdRelatado(idRelatado);
                    relatorioService.inseriRelatorio(idRelator,idRelatado);

                }
                case 4 -> {
                    System.out.println("Digite o id que deseja atualizar: ");
                    Long idParaAtualizar = entrada.nextLong();
                    entrada.nextLine();
                    System.out.println("Digite o campo que deseja atualizar: ");
                    String campoAtualizar = entrada.nextLine();
                    System.out.println("digite o dado que deseja alterar");
                    String dadoAtualizar = entrada.nextLine();
                    relatorioService.atualizaCampoRelatorio(idParaAtualizar, campoAtualizar, dadoAtualizar);
                }
                case 5 -> {
                    System.out.println("Digite o id que deseja deletar: ");
                    Long idParaDeletar = entrada.nextLong();
                    entrada.nextLine();
                    relatorioService.deletaDadosRelatorio(idParaDeletar);
                }
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Escolha inválida. Insira de 1 - 6");
            }
        }while(escolha != 6);
    }

    public void menu(){
        System.out.println("THE FORCE BE WITH YOU!!");
        System.out.println("Digite uma das opções abaixo");
        System.out.println("1 - Consulta todos os relatorios");
        System.out.println("2 - Consulta relatorios por campo específico");
        System.out.println("3 - cadastro novo relatorios");
        System.out.println("4 - Atualiza um dado do relatorios");
        System.out.println("5 - excluir um relatorio existente");
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
