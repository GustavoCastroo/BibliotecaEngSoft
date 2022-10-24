package view;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import controller.EmprestimoController;
import controller.LivroController;
import factory.EmprestimoFactory;
import factory.Factory;
import factory.LivroFactory;
import main.Console;
import model.Emprestimo;
import model.Entidade;
import model.Livro;
import persistence.EmprestimoPersistence;

public class EmprestimoMenu extends Menu{
	
	public void mostrarMenu() throws IOException {
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
	
	private void cadastrarEmprestimo() throws IOException {
		EmprestimoFactory emprestimoFactory = (EmprestimoFactory) Factory.getFactory("Emprestimo");		
		EmprestimoController emprestimoController = (EmprestimoController) emprestimoFactory.createController();
		Emprestimo emprestimo = (Emprestimo) emprestimoFactory.createEntidade();
		
		
		System.out.println("Vamos cadastrar o Emprestimo!");
		
		System.out.print("\nDigite o identificador numérico do Emprestimo: ");
		Integer idEmprestimo = Integer.parseInt(Console.readLine());
		
		System.out.print("\nDigite o nome do Aluno: ");
		String nomeAluno = Console.readLine();
		
		System.out.print("\nDigite a matricula do Aluno: ");
		String matriculaAluno = Console.readLine();
		
		emprestimo.setId(idEmprestimo);
		emprestimo.setNomeAluno(nomeAluno);
		emprestimo.setMatriculaAluno(matriculaAluno);
		
		if (gerenciaListaDeLivros(emprestimo)) {
			
			emprestimoController.cadastrar(emprestimo);
			System.out.println("Empréstimo realizado com sucesso!");
			
		}else {
			 System.out.println("Empréstimo Cancelado!");			 
		}
	}
	
	private boolean gerenciaListaDeLivros(Emprestimo emprestimo) throws IOException {
		boolean executando = true;
		boolean retorno = false;
		
        while (executando) {
            System.out.println("Opções de gerenciamento da lista de livros: ");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Remover Livro");
            System.out.println("3 - Exibir Lista de Livros");
            System.out.println("4 - Confirmar Emprestimo");
            System.out.println("5 - Cancelar Emprestimo"); 
            System.out.println("6 - Confirmar Alteração da Lista(Usado quando se está alterando um empréstimo já cadastrado)");       
            
            System.out.print("\nDigite a opção desejada: ");
            int opcao = Integer.parseInt(Console.readLine());          
            
            switch (opcao) {
                case 1:
                	
                    adicionarLivroNaLista(emprestimo);
                    break;
                case 2:
                	
                	removerLivroDaLista(emprestimo);
                    break;
                case 3:										
                    
                	exibirLivrosDaLista(emprestimo);
                    break;
                case 4:
                	
                	if (emprestimo.getLivros().isEmpty()) {
            			System.out.println("Nenhum livro foi adicionado! Para realizar um empréstimo você deve adicionar pelo menos 1 livro!");
                	}else {
                		retorno = true;
                		executando = false;
                	} 
                	break;
                case 5:                                                                   
                    retorno = false;
                	executando = false;  
                	break;                	
                case 6:                                                                   
                	if (emprestimo.getLivros().isEmpty()) {
            			System.out.println("Nenhum livro foi adicionado! Para realizar um empréstimo você deve adicionar pelo menos 1 livro!");
                	}else {
                		retorno = true;
                		executando = false;
                	} 
                	break;               
                default:
                    System.out.println("Opcao invalida!");
            }	
        }
        
        return retorno;
	}
	
	private void adicionarLivroNaLista(Emprestimo emprestimo) throws IOException {
		LivroFactory livroFactory = (LivroFactory) Factory.getFactory("Livro");		
		LivroController livroController = (LivroController) livroFactory.createController();
		Livro livro = (Livro) livroFactory.createEntidade();
		
		boolean achou = false;
		
		boolean executando = true;
		 
        while (executando) {
            System.out.println("\nDeseja pesquisar o livro usando:");
            System.out.println("1 - Identificador numérico");
            System.out.println("2 - Nome do Livro");
            
            System.out.print("\nDigite a opção desejada: ");
            int opcao = Integer.parseInt(Console.readLine());
            
            switch (opcao) {
                case 1:                	 
                	System.out.println("\nQual o identificador do livro que vc deseja adicionar?");
            		Integer idLivro = Integer.parseInt(Console.readLine());
            		
            		livro = (Livro) livroController.buscar(idLivro);
            		
            		if (livro != null) {
            			achou = true;
            		} else {
            			System.out.println("Livro não está cadastrado");
            		}
               	 	executando = false;
               	 	
                    break;
                case 2:               	 	
                	List<Entidade> resultadoBusca = new LinkedList<Entidade>();
                	
                	System.out.println("\nQual o nome do livro que vc deseja adicionar?");
            		String nomeLivro = Console.readLine();
            		
            		resultadoBusca = livroController.buscar(nomeLivro);
            		
            		if (!resultadoBusca.isEmpty()) {
            			for(Entidade livro2 : resultadoBusca) {
            			
            				emprestimo.getLivros().add(((Livro) livro2));
            	        	System.out.println("Livro adicionado com sucesso!");
            			}            		
            		} else {
            			System.out.println("Livro não está cadastrado");
            		}
            		
            		executando = false;
            		                	
                    break;            
                default:
                    System.out.println("Opcao invalida!");
            }	
        }

        if(achou) {
        	emprestimo.getLivros().add(livro);
        	System.out.println("Livro adicionado com sucesso!");
        }
	}
	
	private void removerLivroDaLista(Emprestimo emprestimo) throws IOException {
		LivroFactory livroFactory = (LivroFactory) Factory.getFactory("Livro");	
		LivroController livroController = (LivroController) livroFactory.createController();
		Livro livro = (Livro) livroFactory.createEntidade();
		
		if (emprestimo.getLivros().isEmpty()) {
			
			System.out.println("A lista está vazia, nenhum livro foi adicionado!");
		
		}else {
			
			exibirLivrosDaLista(emprestimo);
	           
	        System.out.print("\nDigite o identificador do livro que você deseja remover: ");
	        int idLivro = Integer.parseInt(Console.readLine());
	            
	        livro = (Livro) livroController.buscar(idLivro);
	        
	        if (livro != null) {
	        	
	        	emprestimo.getLivros().remove(livro);
	        	System.out.println("O livro foi removido com sucesso da lista! ");
	        	
	        } else {
	        	
	        	System.out.println("O identificador que você digitou não corresponde a nenhum livro da lista! ");
	        }
		}	
	}
	
	private void exibirLivrosDaLista (Emprestimo emprestimo) {
				
		if (emprestimo.getLivros().isEmpty()) {
			System.out.println("A lista está vazia, nenhum livro foi adicionado!");
		}else {
			System.out.println("Lista dos livros do emprestimo: ");		
			
			for (Livro livro : emprestimo.getLivros()) {
				
				System.out.println("   " + livro.toString());		
			}
		}		
	}
	
	private void alterarEmprestimo() throws IOException {
		EmprestimoFactory emprestimoFactory = (EmprestimoFactory) Factory.getFactory("Emprestimo");		
		EmprestimoController emprestimoController = (EmprestimoController) emprestimoFactory.createController();	
		Emprestimo emprestimo =  (Emprestimo) emprestimoFactory.createEntidade();
		boolean achou = false;	
		
		System.out.println("\nQual o identificador numérico do empréstimo que vc deseja excluir/devolver?");
		Integer idEmprestimo = Integer.parseInt(Console.readLine());
		
		emprestimo = (Emprestimo) emprestimoController.buscar(idEmprestimo);
		
		if (emprestimo != null) {
			achou = true;
		} else {
			System.out.println("Emprestimo não está cadastrado");
		}   	 
        
        if (achou) {
        	System.out.print("\nDigite o identificador numérico do Emprestimo: ");
    		Integer novoIdEmprestimo = Integer.parseInt(Console.readLine());
    		
    		System.out.print("\nDigite o nome do Aluno: ");
    		String nomeAluno = Console.readLine();
    		
    		System.out.print("\nDigite a matricula do Aluno: ");
    		String matriculaAluno = Console.readLine();
    		
    		emprestimo.setId(novoIdEmprestimo);
    		emprestimo.setNomeAluno(nomeAluno);
    		emprestimo.setMatriculaAluno(matriculaAluno);
    		
    		gerenciaListaDeLivros(emprestimo);    			
			emprestimoController.alterar(emprestimo);
			System.out.println("Empréstimo alterado com sucesso!");    			    
        }
	}
	
	private void excluirEmprestimo() throws IOException {		
		EmprestimoFactory emprestimoFactory = (EmprestimoFactory) Factory.getFactory("Emprestimo");		
		EmprestimoController emprestimoController = (EmprestimoController) emprestimoFactory.createController();	
		Emprestimo emprestimo =  (Emprestimo) emprestimoFactory.createEntidade();
		boolean achou = false;		
        	                    	 
    	System.out.println("\nQual o identificador numérico do empréstimo que vc deseja excluir/devolver?");
		Integer idEmprestimo = Integer.parseInt(Console.readLine());
		
		emprestimo = (Emprestimo) emprestimoController.buscar(idEmprestimo);
		
		if (emprestimo != null) {
			achou = true;
		} else {
			System.out.println("Emprestimo não está cadastrado");
		}   	 
        
        if (achou) {
        	emprestimoController.excluir(emprestimo);
        	System.out.println("Emprestimo excluído com sucesso!");
        }
		
	}

	private void exibirEmprestimo() throws IOException {
		EmprestimoFactory emprestimoFactory = (EmprestimoFactory) Factory.getFactory("Emprestimo");		
		EmprestimoController emprestimoController = (EmprestimoController) emprestimoFactory.createController();	
		Emprestimo emprestimo =  (Emprestimo) emprestimoFactory.createEntidade();
		boolean achou = false;		
		boolean executando = true;
		 
        while (executando) {
            System.out.println("\nExibição dos empréstimos:");
            System.out.println("1 - Exibir um empréstimo específico a partir do identificador do empréstimo");
            System.out.println("2 - Exibir todos empréstimos de um aluno através de sua matrícula");
            
            System.out.print("\nDigite a opção desejada: ");
            int opcao = Integer.parseInt(Console.readLine());
            
            switch (opcao) {
                case 1:                	 
                	System.out.println("\nQual o identificador do empréstimo que vc deseja exibir?");
            		Integer idEmprestimo = Integer.parseInt(Console.readLine());
            		
            		emprestimo = (Emprestimo) emprestimoController.buscar(idEmprestimo);
            		
            		if (emprestimo != null) {
            			achou = true;
            		} else {
            			System.out.println("Emprestimo não está cadastrado");
            		}
               	 	executando = false;
               	 	
                    break;
                case 2:
               	 	List<Entidade> resultadoBusca = new LinkedList<Entidade>();
               	 	
                	System.out.println("\nQual a matrícula do aluno que você deseja exibir o empréstimo?");
            		String matriculaAluno = Console.readLine();            		            
            		
            		resultadoBusca = emprestimoController.buscar(matriculaAluno);
            		
            		if (!resultadoBusca.isEmpty()) {
            			
            			for(Entidade empres : resultadoBusca) {
            				System.out.println(((Emprestimo)empres).toString());
            			}
            			
            		} else {
            			System.out.println("Emprestimo não encontrado");
            		}
            		
            		executando = false;
                    break;            
                default:
                    System.out.println("Opcao invalida!");
            }	
        }
        
        if (achou) {
        	System.out.println(emprestimo.toString());
        }
	}

	private void realizarDevolucao() throws IOException {
		excluirEmprestimo();
	}
}
