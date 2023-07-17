package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    private Scanner entrada;

    private BaseView baseView;
    private InventarioView inventarioView;
    private ItemView itemView;
    private RebeldeView rebeldeView;
    private RelatorioView relatorioView;

    public MenuView(){
        entrada = new Scanner(System.in);
        baseView = new BaseView();
        inventarioView = new InventarioView();
        itemView = new ItemView();
        rebeldeView = new RebeldeView();
        relatorioView = new RelatorioView();


    }

    public void incializacao(){
        int escolha;

        do {
            menu();
            escolha = selecionaEscolhaUsuario();

            switch (escolha) {
                case 1 -> baseView.incializacao();
                case 2 -> {
                   inventarioView.incializacao();
                }
                case 3 -> {
                    itemView.incializacao();

                }
                case 4 -> {
                    rebeldeView.incializacao();
                }
                case 5 -> {
                    relatorioView.incializacao();
                }
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Escolha inválida. Insira de 1 - 6");
            }
        }while(escolha != 6);
    }

    public void menu(){
        System.out.println("THE FORCE BE WITH YOU!!");
        System.out.println("Digite uma das opções abaixo");
        System.out.println("1 - Menu base");
        System.out.println("2 - Menu Inventario");
        System.out.println("3 - Menu Item");
        System.out.println("4 - Menu Rebelde");
        System.out.println("5 - Menu Relatorios");
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
