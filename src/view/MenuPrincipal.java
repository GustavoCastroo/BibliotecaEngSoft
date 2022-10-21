package view;

import factory.Factory;
import main.Console;

public class MenuPrincipal extends Menu {

	public void mostrarMenu() {
		boolean executando = true;
        
        while (executando) {
            System.out.println("Menu Principal");
            System.out.println("1 - Livro");
            System.out.println("2 - Emprestimo");
            System.out.println("0 - Sair");
            
            int opcao = Integer.parseInt(Console.readLine());
            
            switch (opcao) {
                case 1:
                	Factory livroFactory = Factory.getFactory("Livro");
                	LivroMenu livroMenu = (LivroMenu) livroFactory.createMenu();
                	livroMenu.mostrarMenu();
                    break;
                case 2:
                	Factory emprestimoFactory = Factory.getFactory("Emprestimo");
                	EmprestimoMenu emprestimoMenu = (EmprestimoMenu) emprestimoFactory.createMenu();
                	emprestimoMenu.mostrarMenu();
                    break;
                case 0: 
                    System.out.println("Volte Sempre!");
                    executando = false;
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }	
        }
	}
}