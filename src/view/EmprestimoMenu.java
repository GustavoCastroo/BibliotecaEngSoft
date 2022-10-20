package view;
import main.Console;

public class EmprestimoMenu extends Menu{
	
	public void mostrarMenu() {
		boolean executando = true;
		
        while (executando) {
            System.out.println("Menu Emprestimo");
            System.out.println("1 - Cadastrar Emprestimo");
            System.out.println("2 - Alterar Emprestimo");
            System.out.println("3 - Excluir Emprestimo");
            System.out.println("4 - Exibir Emprestimo");                        
            System.out.println("5 - Realizar Devolucao");                        
            System.out.println("0 - Sair");
            
            int opcao = Integer.parseInt(Console.readLine());
            
            switch (opcao) {
                case 1:
                	
                	cadastrarEmprestimo();                	
                    break;
                case 2:
                    
                	alterarEmprestimo();
                    break;
                case 3:										
                    
                	excluirEmprestimo();
                    break;
                case 4:
                    
                	exibirEmprestimo();
                    break;       
                case 5:
                    
                	realizarDevolucao();
                    break;                        
                case 0:                                 
                    executando = false;
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }	
        }
        
        MenuPrincipal instanceMenuPrincipal = new MenuPrincipal();
		instanceMenuPrincipal.mostrarMenu();	
	}
	
	private void cadastrarEmprestimo() {
		EmprestimoSubMenu instanceEmprestimoSubMenu = new EmprestimoSubMenu();
		instanceEmprestimoSubMenu.mostrarMenu();
		
	}
	
	private void alterarEmprestimo() {
		// TODO Auto-generated method stub
		
	}
	
	private void excluirEmprestimo() {
		// TODO Auto-generated method stub
		
	}

	private void exibirEmprestimo() {
		// TODO Auto-generated method stub
		
	}

	private void realizarDevolucao() {
		// TODO Auto-generated method stub
		
	}
}
