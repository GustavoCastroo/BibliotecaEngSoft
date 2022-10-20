package view;

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
                	LivroMenu instanceLivroMenu = new LivroMenu();
                	instanceLivroMenu.mostrarMenu();
                    break;
                case 2:
                	EmprestimoMenu instanceEmprestimoMenu = new EmprestimoMenu();
                	instanceEmprestimoMenu.mostrarMenu();
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
