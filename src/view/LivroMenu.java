package view;

import main.Console;

public class LivroMenu extends Menu{

	public void mostrarMenu() {
		 boolean executando = true;
		 
         while (executando) {
             System.out.println("Menu Livro");
             System.out.println("1 - Cadastrar Livro");
             System.out.println("2 - Alterar Livro");
             System.out.println("3 - Excluir Livro");
             System.out.println("4 - Exibir Livro");                        
             System.out.println("0 - Sair");
             
             int opcao = Integer.parseInt(Console.readLine());
             
             switch (opcao) {
                 case 1:                	 
                	 
                	 cadastrarLivro();
                     break;
                 case 2:
                	 
                	 alterarLivro();
                     break;
                 case 3:										
                	 
                	 excluirLivro();
                     break;
                 case 4:

                	 exibirLivro();
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

	private void cadastrarLivro() {
		
		/*System.out.println("Vamos cadastrar o Livro!");
		
		System.out.println("Digite o nome do Livro");
		String nomeLivro = Console.readLine();*/	
	}
	
	private void alterarLivro() {
		// TODO Auto-generated method stub
		
	}
	
	private void excluirLivro() {
		// TODO Auto-generated method stub
		
	}
	
	private void exibirLivro() {
		// TODO Auto-generated method stub
		
	}
}
