package view;

import controller.LivroController;
import factory.Factory;
import factory.LivroFactory;
import main.Console;
import model.Livro;

public class LivroMenu extends Menu{

	public void mostrarMenu() {
		 boolean executando = true;
		 
         while (executando) {
             System.out.println("\nMenu Livro");
             System.out.println("1 - Cadastrar Livro");
             System.out.println("2 - Alterar Livro");
             System.out.println("3 - Excluir Livro");
             System.out.println("4 - Exibir Livro");                        
             System.out.println("0 - Sair");
             
             System.out.print("\nDigite a opção desejada: ");
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
		LivroFactory livroFactory = (LivroFactory) Factory.getFactory("Livro");		
		LivroController livroController = (LivroController) livroFactory.createController();
		
		System.out.println("Vamos cadastrar o Livro!");
		
		System.out.print("\nDigite o nome do Livro:");
		String nomeLivro = Console.readLine();
	
		if (livroController.buscar(nomeLivro) == null) {	// Verificando se o livro já não está cadastrado
			
			System.out.print("\nDigite o identificador numérico do Livro: ");
			Integer idLivro = Integer.parseInt(Console.readLine());
			
			System.out.print("\nDigite o autor do Livro: ");
			String autorLivro = Console.readLine();
			
			System.out.print("\nDigite edicao do Livro: ");
			Integer edicaoLivro = Integer.parseInt(Console.readLine());
			
			Livro livro = (Livro) livroFactory.createEntidade();
			
			livro.setAutor(autorLivro);
			livro.setEdicao(edicaoLivro);
			livro.setId(idLivro);
			livro.setNome(nomeLivro);
			
			livroController.cadastrar(livro);
			
			System.out.println("\nCadastro realizado com sucesso!");
			
		}else {
			
			System.out.println("\nO Livro já está cadastrado no sistema!");
		}
		
	}
	
	private void alterarLivro() {
		
		/*System.out.println("Qual o nome do livro que vc deseja alterar?");
		String nomeLivro = Console.readLine();
		
		Livro livro = controller.busca(nomeLivro);*/
	
	}
	
	private void excluirLivro() {
		// TODO Auto-generated method stub
		
	}
	
	private void exibirLivro() {
		LivroFactory livroFactory = (LivroFactory) Factory.getFactory("Livro");
		LivroController livroController = (LivroController) livroFactory.createController();
		Livro livro = (Livro) livroFactory.createEntidade();
		
		System.out.println("Vamos exibir o Livro!");
		
		System.out.println("Digite o nome do Livro");
		String nomeLivro = Console.readLine();
		
		livro = (Livro) livroController.buscar(nomeLivro);
		
		System.out.println(livro.toString());
	}
}
