package view;

import model.Rebelde;
import service.RebeldeService;

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

            switch (escolha){
                case 1:
                    rebeldeService.consultaTodosDadosDaTabela();
                    break;
                case 2:
                    System.out.println("Digite a coluna que você deseja consultar: ");
                    String column = entrada.nextLine();
                    rebeldeService.consultaColunaEspecifica(column);
                    break;
                case 3:
                    System.out.println("Digite o nome que deseja inserir: ");
                    String nome = entrada.nextLine();
                    usuario.setNome(nome);
                    rebeldeService.inserirDadosNaTabela(usuario.getNome());
                    break;
                case 4:
                    System.out.println("Digite o id que deseja atualizar: ");
                    Long idParaAtualizar = entrada.nextLong();
                    entrada.nextLine();
                    System.out.println("Digite o novo dado que deseja inserir: ");
                    String nomeParaAtualizar = entrada.nextLine();
                    usuario.setNome(nomeParaAtualizar);
                    rebeldeService.atualizaDadosNaTabela(idParaAtualizar, usuario.getNome());
                    break;
                case 5:
                    System.out.println("Digite o id que deseja deletar: ");
                    Long idParaDeletar = entrada.nextLong();
                    entrada.nextLine();
                    rebeldeService.deletaDadosNaTabela(idParaDeletar);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Escolha inválida. Insira de 1 - 6");
                    break;
            }
        }while(escolha != 6);
    }

    public void menu(){
        System.out.println("BEM VINDO!");
        System.out.println("Digite uma das opções abaixo");
        System.out.println("1 - Consulta todos os dados");
        System.out.println("2 - Consulta dados por coluna específica");
        System.out.println("3 - Insira um novo dado");
        System.out.println("4 - Atualiza um dado existente");
        System.out.println("5 - Deleta um dado existente");
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
}
