package view;

import main.Console;

public class EmprestimoSubMenu extends Menu{

	public void mostrarMenu() {
		
		boolean executando = true;
		
        while (executando) {
            System.out.println("Menu Cadastro de Emprestimo");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Remover Livro");
            System.out.println("3 - Exibir Listas de Livro");
            System.out.println("4 - Confirmar Emprestimo");
            System.out.println("5 - Cancelar Emprestimo");                        
            
            int opcao = Integer.parseInt(Console.readLine());
            
            switch (opcao) {
                case 1:
                	
                    adicionarLivro();
                    break;
                case 2:
                	
                	removerLivro();
                    break;
                case 3:										
                    
                	exibirLivros();
                    break;
                case 4:
                    
                	confirmarEmprestimo();
                    break;       
                case 5:
                                                                   
                    executando = false;
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }	
        }
        
        EmprestimoMenu instanceMenuEmprestimo = new EmprestimoMenu();
		instanceMenuEmprestimo.mostrarMenu();
	}

	private void adicionarLivro() {
		// TODO Auto-generated method stub
		
	}

	private void removerLivro() {
		// TODO Auto-generated method stub
		
	}

	private void exibirLivros() {
		// TODO Auto-generated method stub
		
	}

	private void confirmarEmprestimo() {
		// TODO Auto-generated method stub
		
	}
}
