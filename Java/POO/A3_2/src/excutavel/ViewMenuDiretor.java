package excutavel;

import java.util.Scanner;
import java.util.List;

import entidades.Aluno;
import entidades.Professor;
import entidades.Turma;
import entidades.NotaAluno;


public class ViewMenuDiretor {
	
	//Menu Coordenador
	public static void menuCoordenador(Scanner scanner) {
		for (int i = 0; i < 30; i++) {
			System.out.println(" ");
		}
        while (true) {
            System.out.println("\n=== Menu Coordenador ===");
            System.out.println("1 - Gerenciar Professores");
            System.out.println("2 - Gerenciar Alunos");
            System.out.println("3 - Gerenciamento de IDs (Busca/Exclusão)");
            System.out.println("4 - Gerenciar Turmas");
            System.out.println("5 - Voltar ao menu inicial");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine().trim();
            
            switch (opcao) {
                case "1":
                    menu1(scanner);
                    break;
                case "2":
                    menu2(scanner);
                    break;
                case "3":
                    menu3(scanner);
                    break;
                case "4":
                	menu4(scanner);
                	break;
                case "5":
                    return;  // Volta ao menu principal
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
	
	//OPÇÃO 1:Gerenciar Professores
	public static void menu1(Scanner scanner) {
		while(true) {
			System.out.println("\n=== Gerenciar professores ===");
			System.out.println("1 - Cadastrar Professor");
			System.out.println("2 - Buscar Professor");
			System.out.println("3 - Listar Professores");
			System.out.println("4 - Voltar");
			System.out.print("Opção: ");
	        String opcao = scanner.nextLine().trim();
	        
	        switch (opcao) {
	        case "1":
	            cadastrarProfessor(scanner);
	            break;
	        case "2":
	            buscarProfessorNome(scanner);
	            break;
	        case "3":
	        	listarProfessores(scanner);
	        	break;
	        case "4":
	            return;  
	        default:
	            System.out.println("Opção inválida.");
	            break;
	        }
		}
	}
	
		//Cadastrar professor
		public static void cadastrarProfessor(Scanner scanner) {
			System.out.println("\n=== Cadastro de Professor ===");
			
			System.out.println("Nome: ");
			String nomeProfessor = scanner.nextLine().trim();
			
			System.out.println("Idade: ");
			int idade = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("CPF: (APENAS NUMEROS)");
			String cpf = scanner.nextLine().trim();
			
			System.out.println("Nome da turma inicial: ");
			String nomeTurma = scanner.nextLine().trim();
			
			System.out.println("Dia e horário da aula da turma " + nomeTurma + ": \n (Ex: Seg e ter 8:50 às 11:40)");
			String diaHorario = scanner.nextLine().trim();
			
			String idGerado = entidades.Professor.cadastrarProfessor(nomeProfessor, idade, cpf);
			
			entidades.Turma.criarTurma(nomeTurma, nomeProfessor, diaHorario);
			
			System.out.println("Professor " + nomeProfessor + " cadastrado com sucesso");
			System.out.println("Turma " + nomeTurma + " criada com sucesso");
			
		}
		
		//Buscar Professor nome 
		public static void buscarProfessorNome(Scanner scanner) {
			boolean usouBuscaID = false;
			System.out.println("Digite o nome COMPLETO para buscar");
			String nome = scanner.nextLine().trim();
			
			Professor professorEncontrado = entidades.Professor.buscarProfessorNome(nome);
			
			if (professorEncontrado != null) {
				mostrarOpcoesTurmas(scanner, professorEncontrado, usouBuscaID);
				return;
			}
			
			while (true) {
				System.out.println("Nenhum professor encontrado!");
				System.out.println("Deseja usar a busca por ID?");
		        System.out.println("1 - Sim");
		        System.out.println("2 - Não");
		        String opcao = scanner.nextLine().trim();
		        
		        switch (opcao) {
		        	case "1":
		        		Professor profID = buscarProfessorID(scanner);
		        		usouBuscaID = true;
		        		
		        		if (profID != null) {
		        			mostrarOpcoesTurmas(scanner, profID, usouBuscaID);
		        		}
		        		return;
		        	case "2":
		        		return;
		        	default:
		        		System.out.println("Opcão inválida");
		        		break;
		        }
			}
		}
			//Mostrar opções de turma do professor
			public static void mostrarOpcoesTurmas(Scanner scanner, Professor professor, boolean usouBuscaID) {
				if (!usouBuscaID) {
					System.out.println("Professor encontrado");
					System.out.println(professor);
				}
				System.out.println("Deseja ver suas turmas?");
				System.out.println("1 - Sim");
				System.out.println("2 - Não");
				String opcao = scanner.nextLine().trim();
				
				switch (opcao) {
					case "1":
						List<Turma> listaTurmas = entidades.Turma.getTurmas();
						boolean temTurma = false;
						for (Turma turma : listaTurmas) {
							if (turma.getNomeProfessor().equalsIgnoreCase(professor.getNome()) ) {
								temTurma = true;
								System.out.println("Turma: " + turma.getNomeTurma() + ", ID: " + turma.getId() + ", Horário: " + turma.getDiaHorario());
								
							}
						}
						if (!temTurma) {
				            System.out.println("   (Nenhuma turma cadastrada para este professor)");
				        }
						
						break;
					case "2":
						break;
					default:
						System.out.println("Opção inválida");						
				}
			}
		//listar professores
		public static void listarProfessores(Scanner scanner) {
			List<Professor> lista = Professor.getProfessores();
			List<Turma> listaTurmas = entidades.Turma.getTurmas();
			
			System.out.println("\n=== Lista de Professores ===");
			if (lista.isEmpty()) {
				System.out.println("Nenhum professor cadastrado.");
				return;
			}
			for (Professor professor : lista) {
				System.out.println("\n" + professor);				
				System.out.println("Turmas desse professor:");
				boolean temTurma = false;
				for (Turma turma : listaTurmas) {
					if (turma.getNomeProfessor().equalsIgnoreCase(professor.getNome()) ) {
						temTurma = true;
						System.out.println("Turma: " + turma.getNomeTurma() + ", ID: " + turma.getId() + ", Horário: " + turma.getDiaHorario());
						
					}
				}
				if (!temTurma) {
		            System.out.println("   (Nenhuma turma cadastrada para este professor)");
		        }
				
			}
		}
	
	//OPÇÃO 2: Gerenciar alunos
	public static void menu2(Scanner scanner) {
		while (true) {
			System.out.println("\n=== Gerenciar Aluno ===");
			System.out.println("1 - Cadastrar Aluno");
			System.out.println("2 - Buscar Aluno por nome");
			System.out.println("3 - Listar Alunos");
			System.out.println("4 - Voltar");
			System.out.print("Opção: ");
	        String opcao = scanner.nextLine().trim();
	        
	        switch (opcao) {
	            case "1":
	                cadastrarAluno(scanner);
	                break;
	            case "2":
	                buscarAlunoNome(scanner);
	                break;
	            case "3":
	            	listarAlunos(scanner);
	            	break;
	            case "4":
	                return;  
	            default:
	                System.out.println("Opção inválida.");
	                break;
        	}
		}
	}
		//Cadastrar aluno
		public static void cadastrarAluno(Scanner scanner) {
			System.out.println("\n=== Cadastro de Aluno===");
			
			System.out.println("Nome: ");
			String nome = scanner.nextLine().trim();
			
			System.out.println("Idade: ");
			int idade = scanner.nextInt();
			scanner.nextLine().trim();
			
			System.out.println("CPF: (APENAS NUMEROS)");
			String cpf = scanner.next();
			
			System.out.println("Semestre: ");
			String semestre = scanner.nextLine().trim();
			
			
			String idGerado = entidades.Aluno.cadastrarAlunos(nome, idade, semestre, cpf);
			Aluno alunoCriado = entidades.Aluno.buscarAlunoID(idGerado);
			
			System.out.println("Aluno cadastrado com sucesso!");
			System.out.println("ID do aluno: " + idGerado);
			
			System.out.println("\nDeseja matricular este aluno em uma turma existente?");
		    System.out.println("1 - Sim");
		    System.out.println("2 - Não");
		    String opcao = scanner.nextLine().trim();
		    
		    switch (opcao) {
		    	case "1":
			    	List<Turma> listaTurmas = entidades.Turma.getTurmas();
			        if (listaTurmas.isEmpty()) {
			            System.out.println("\nNenhuma turma cadastrada no sistema.");
			            return;
			        }
			        System.out.println("\n=== Turmas Disponíveis ===");
			        for (Turma t : listaTurmas) {
			        	System.out.println("Turma: "+ t.getNomeTurma() + ", ID: " + t.getId() + ", Professor: " + t.getNomeProfessor());
			        }
			        
			        System.out.println("\nDigite o ID da turma que deseja matricular o aluno:");
			        String idTurma = scanner.nextLine().trim();

			        Turma turmaEncontrada = entidades.Turma.buscarTurmaPorId(idTurma);

			        if (turmaEncontrada == null) {
			            System.out.println("Turma não encontrada. Aluno cadastrado, mas não matriculado.");
			            return;
			        }
			        
			        turmaEncontrada.adicionarAluno(alunoCriado);

			        System.out.println("\nAluno " + alunoCriado.getNome() + 
			                           " matriculado na turma " + turmaEncontrada.getNomeTurma() +
			                           " com sucesso!");
		    	case "2":
		    		return;
		    }
		}
		
		//Buscar aluno nome
		public static void buscarAlunoNome(Scanner scanner) {
			System.out.println("Digite o nome COMPLETO para buscar");
			String nome = scanner.nextLine().trim();
			
			Aluno alunoEncontrado = entidades.Aluno.buscarAlunoNome(nome);
			
			if (alunoEncontrado != null) {
				System.out.println("Aluno encontrado: ");
				System.out.println(alunoEncontrado);
			} else {
				while (true) {
					System.out.println("Nenhum aluno encontrado!");
					System.out.println("Deseja usar a busca por ID?");
					System.out.println("Opções: ");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					String opcao = scanner.nextLine().trim();
					
					switch (opcao) {
						case "1":
							buscarAlunoID(scanner);
							return;
						case "2":
							return;
						default:
							System.out.println("Opção inválida");
							break;
					}
				}
				
			}
			
		}
		
		//Listar alunos
		public static void listarAlunos(Scanner scanner) {
			List<Aluno> lista = Aluno.getAlunos();
			
			System.out.println("\n=== Lista de Alunos ===");
			if (lista.isEmpty()) {
				System.out.println("Nenhum aluno cadastrado.");
				return;
			}
			for (Aluno aluno : lista) {
				System.out.println(aluno);
			}
		}
		
	
	//OPÇÃO 3: Gerenciar ID
	public static void menu3(Scanner scanner) {
		while (true) {
			System.out.println("\n=== Menu ID ===");
			System.out.println("1 - ID Aluno");
			System.out.println("2 - ID Professor");
			System.out.println("3 - ID Turma");
			System.out.println("4 - Voltar");
			System.out.print("Opção: ");
	        String opcao = scanner.nextLine().trim();
	        
	        switch (opcao) {
	            case "1":
	                idAluno(scanner);
	                break;
	            case "2":
	            	idProfessor(scanner);
	                break;
	            case "3":
	            	idTurma(scanner);
	            	break;
	            case "4":
	                return;  
	            default:
	                System.out.println("Opção inválida.");
	                break;
        	}
		}
	}
		//ID Professor
		public static void idProfessor(Scanner scanner) {
			while (true) {
				System.out.println("\n=== Gerenciar ID Professor ===");
				System.out.println("1 - Bucar Professor por ID");
				System.out.println("2 - Excluir Professor por ID");
				System.out.println("3 - Voltar");
				System.out.print("Opção: ");
		        String opcao = scanner.nextLine().trim();
		        
		        switch (opcao) {
		            case "1":
		            	buscarProfessorID(scanner);
		                break;
		            case "2":
		            	excluirProfessor(scanner);
		                break;
		            case "3":
		                return;  
		            default:
		                System.out.println("Opção inválida.");
		                break;
	        	}
			}
		}
		
			//Buscar Professor por ID
			public static entidades.Professor buscarProfessorID(Scanner scanner) {
				System.out.println("Digige o ID para buscar");
				String id = scanner.nextLine().trim();
				
				Professor professorEncontrado = entidades.Professor.buscarProfessorID(id);
				
				if (professorEncontrado != null) {
					System.out.println("Professor encontrado: ");
					System.out.println(professorEncontrado);
				} else {
					System.out.println("Nenhum professor encontrado");
				}
				return professorEncontrado;
			}
			
			//Excluir professor por ID
			private static void excluirProfessor(Scanner scanner) {
				Professor professorEncontrado = buscarProfessorID(scanner);
				
				if (professorEncontrado == null) {
					return;
				}
				System.out.println("Tem certeza que deseja excluir esse professor?");
				System.out.println("1 - Confirmar");
				System.out.println("2 - Cancelar");
				String opcao = scanner.nextLine().trim();
				
				if (opcao.equals("1")) {
					boolean removido = entidades.Professor.excluirProfessor(professorEncontrado);
					
					if (removido) {
						System.out.println("Professor removido com sucesso!");
						
					} else {
						System.out.println("Erro ao remover professor.");
					}
				} else {
					System.out.println("Operação cancelada");
				}
				while (true) {
					System.out.println("Deseja excluir sua turma também?");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					String opcao2 = scanner.nextLine().trim();
					
					switch (opcao2) {
						case "1":
							excluirTurma(scanner);
							break;
						case "2":
							return;
						default:
			                System.out.println("Opção inválida.");
			                break;
								
					}
				}
			}
	
		//ID Aluno
		public static void idAluno(Scanner scanner) {
			while (true) {
				System.out.println("\n=== Gerenciar ID Alunos ===");
				System.out.println("1 - Bucar aluno por ID");
				System.out.println("2 - Excluir aluno por ID");
				System.out.println("3 - Voltar");
				System.out.print("Opção: ");
		        String opcao = scanner.nextLine().trim();
		        
		        switch (opcao) {
		            case "1":
		                buscarAlunoID(scanner);
		                break;
		            case "2":
		              excluirAluno(scanner);
		                break;
		            case "3":
		                return;  
		            default:
		                System.out.println("Opção inválida.");
		                break;
	        	}
			}
		}
	
			//Buscar aluno por ID
			public static entidades.Aluno buscarAlunoID(Scanner scanner) {
				System.out.println("Digite o ID para buscar");
				String id = scanner.nextLine().trim();
				
				Aluno alunoEncontrado = entidades.Aluno.buscarAlunoID(id);
				
				if (alunoEncontrado != null) {
					System.out.println("Aluno encontrado: ");
					System.out.println(alunoEncontrado);
				} else {
					System.out.println("Nenhum aluno encontrado");
				}
				return alunoEncontrado;							
			}
			
			//Excluir aluno
			public static void excluirAluno(Scanner scanner) {
				Aluno alunoEncontrado = buscarAlunoID(scanner);
				
				if (alunoEncontrado == null) {
					return;
				}
				System.out.println("Tem certeza que deseja excluir esse aluno?");
				System.out.println("1 - Confirmar");
				System.out.println("2 - Cancelar");
				String opcao = scanner.nextLine().trim();
				
				if (opcao.equals("1")) {
					boolean removido = entidades.Aluno.excluirAluno(alunoEncontrado);
					
					if (removido) {
						System.out.println("Aluno removido com sucesso!");
					} else {
						System.out.println("Erro ao remover aluno.");
					}
				} else {
					System.out.println("Operação cancelada");
				}
			}
		//ID Turma
			public static void idTurma(Scanner scanner) {
			    while (true) {
			        System.out.println("\n=== Gerenciar ID Turma ===");
			        System.out.println("1 - Buscar Turma por ID");
			        System.out.println("2 - Excluir Turma por ID");
			        System.out.println("3 - Voltar");
			        System.out.print("Opção: ");
			        String opcao = scanner.nextLine().trim();
			        
			        switch (opcao) {
			            case "1":
			                buscarTurmaPorID(scanner);
			                break;
			            case "2":
			                excluirTurma(scanner);
			                break;
			            case "3":
			                return;
			            default:
			                System.out.println("Opção inválida");
			        }
			    }
			}
			
			//Buscar turma ID
			public static Turma buscarTurmaPorID(Scanner scanner) {
			    System.out.println("Digite o ID da turma para buscar:");
			    String id = scanner.nextLine().trim();

			    Turma turmaEncontrada = entidades.Turma.buscarTurmaPorId(id);

			    if (turmaEncontrada != null) {
			        System.out.println("Turma encontrada:");
			        System.out.println(turmaEncontrada);
			    } else {
			        System.out.println("Nenhuma turma encontrada com esse ID.");
			    }

			    return turmaEncontrada;
			}
			
			//excluir turma
			public static void excluirTurma(Scanner scanner) {
				Turma turmaEncontrada = buscarTurmaPorID(scanner);
				
				if (turmaEncontrada == null) {
					return;
				}
				
				System.out.println("Tem certeza que deseja excluir essa turma?");
				System.out.println("1 - Confirmar");
			    System.out.println("2 - Cancelar");
			    String opcao = scanner.nextLine().trim();
			    
			    if (!opcao.equals("1")) {
			        System.out.println("Operação cancelada.");
			        return;
			    }

			    boolean removida = entidades.Turma.getTurmas().remove(turmaEncontrada);

			    if (removida) {
			        System.out.println("Turma removida com sucesso!");
			    } else {
			        System.out.println("Erro ao remover turma.");
			    }
			}
	
	//OPÇÃO 4: Gerenciar turmas
	public static void menu4(Scanner scanner) {
		while (true) {
			System.out.println("\n=== Gerenciar Turmas ===");
			System.out.println("1 - Criar turma");
			System.out.println("2 - Listar turmas");
			System.out.println("3 - Buscar turma/Gerenciar turma");
			System.out.println("4 - Matricular aluno em turma");
			System.out.println("5 - Desmatricular aluno de turma");
			System.out.println("6 - Voltar");
			System.out.print("Opção: ");
	        String opcao = scanner.nextLine().trim();
	        
	        switch (opcao) {
	            case "1":
	                criarTurma(scanner);
	                break;
	            case "2":
	            	listarTurmas();
	                break;
	            case "3":
	            	buscarEGerenciarTurmas(scanner);
	            	break;
	            case "4":
	            	matricularAlunoEmTurma(scanner);
	            	break;
	            case "5":
	            	desmatricularAlunoDeTurma(scanner);
	            	break;
	            case "6":
	                return;  
	            default:
	                System.out.println("Opção inválida.");
	                break;
        	}
		}
	}
		
		//criar uma turma
		public static void criarTurma(Scanner scanner) {
			while (true) {
				System.out.println("\n=== Criar Turma ===");
				System.out.println("Deseja criar uma turma a partir de um novo professor?");
				System.out.println("Opções :");
				System.out.println("1 - Sim");
				System.out.println("2 - Não (Uma turma será criada sem professor)");
				String opcao = scanner.nextLine().trim();
				switch (opcao) {
	            case "1":
	                cadastrarProfessor(scanner);
	                return;
	            case "2":
	            	System.out.println("Digite o nome da turma:");
	            	String nomeTurma = scanner.nextLine().trim();
	            	
	            	System.out.println("Digite o dia e horário da turma " + nomeTurma + "\nEx: Seg e ter 8:50 às 11:40:");
	            	String diaHorario = scanner.nextLine().trim();
	            	
	            	String idTurma = entidades.Turma.criarTurma(nomeTurma, "Sem professor definido", diaHorario);
	            	
	            	System.out.println("Turma " + nomeTurma + " criada com sucesso!");
	            	System.out.println("ID da tutma: " + idTurma);
	                return;  
	            default:
	                System.out.println("Opção inválida.");
	                return;
				}
			}
		}
		
			
		//listar turma
		public static void listarTurmas() {
			List<Turma> listaTurmas = entidades.Turma.getTurmas();
			
			System.out.println("\n === Lista de Turmas ===");
			if (listaTurmas.isEmpty()) {
				System.out.println("Nenhuma turma cadastrada");
				return;
			}
			
			for (Turma turma : listaTurmas) {
				System.out.println(turma);
			}
		}
		
		//buscar e gerenciar turma
		public static void buscarEGerenciarTurmas(Scanner scanner) {
			System.out.println("Turmas Disponíveis");
			listarTurmas();
			System.out.println("\nDigite o ID da turma para buscar");
			String idTurma = scanner.nextLine().trim();
			
			Turma turmaEncontrada = entidades.Turma.buscarTurmaPorId(idTurma);
			
			if (turmaEncontrada == null) {
				System.out.println("Nenhuma turma encontrada com esse ID");
				return;
			}
			
			System.out.println("Turma encontrada: ");
			System.out.println(turmaEncontrada);
			
			while (true) {
				System.out.println("\nO que deseja fazer?");
			    System.out.println("1 - Ver alunos da turma");
			    System.out.println("2 - Lançar/alterar nota de um aluno");
			    System.out.println("3 - Alterar professor da turma");
			    System.out.println("4 - Voltar");
			    String opcao = scanner.nextLine().trim();
			    
			    switch (opcao) {
			        case "1":
			            turmaEncontrada.listarAlunosDaTurma();
			            break;
			        case "2":
			            lancarOuAlterarNota(scanner, turmaEncontrada);
			            break;
			        case "3":
			            alterarProfessorDaTurma(scanner, turmaEncontrada);
			            break;
			        case "4":
			            return;
			        default:
			            System.out.println("Opção inválida.");
				}
			}
		}
		
		//Matricular aluno em turma
		public static void matricularAlunoEmTurma(Scanner scanner) {
			System.out.println("\n=== Matricula Aluno em Turma ===");
			
			System.out.println("Turmas Disponíveis");
			listarTurmas();
			System.out.println("\nDigite o ID da turma:");
			String idTurma = scanner.nextLine().trim();
			Turma turma = entidades.Turma.buscarTurmaPorId(idTurma);
			
			if (turma == null) {
				System.out.println("Turma não encontrada.");
				return;
			}
			while (true) {
				System.out.println("Menu cadastro de ALuno na turma ");
				listarAlunos(scanner);
				System.out.println("\nDigite o ID do aluno:");
				System.out.println("Ou digite 2 para sair");
				String idAluno = scanner.nextLine().trim();
				if (idAluno.equals("2")) {
					return;
				} else {
				Aluno aluno = entidades.Aluno.buscarAlunoID(idAluno);
				
				if (aluno == null) {
					System.out.println("Aluno não encontrado");
					return;
				}
				
				turma.adicionarAluno(aluno);
				System.out.println("Aluno " + aluno.getNome() + " matriculado na turma " + turma.getNomeTurma() + " com sucesso!");
				}
			}
		}
		
		//lançar/alterar nota
		public static void lancarOuAlterarNota(Scanner scanner, Turma turma) {
			turma.listarAlunosDaTurma();
			System.out.println("Digite o id do aluno na turma:");
			String idAluno = scanner.nextLine().trim();
			
			NotaAluno notaAluno = turma.buscarNotaAlunoPorId(idAluno);
			
			if (notaAluno == null) {
				System.out.println("Esse aluno não está matriculado nesta turma.");
				return;
			}
			
			System.out.println("Aluno encontrado: " + notaAluno.getNome() + ", Nota atual: " + notaAluno.getNota());
			System.out.println("Digite a nova nota: (Utilize virgula Ex: 7,5)");
			double novaNota = scanner.nextDouble();
			scanner.nextLine().trim();
			
			notaAluno.setNota(novaNota);
	
			System.out.println("Nota atualizada com sucesso!");
			System.out.println("\nAluno: " + notaAluno.getNome() + ", Nota atual: " + notaAluno.getNota() + ", Aprovado: " + notaAluno.getAprovado());
		}
		
		//Desmatricular aluno de uma turma
		public static void desmatricularAlunoDeTurma(Scanner scanner) {
			System.out.println("\n=== Desmatricular Aluno de Turma ===");
			listarTurmas();
		    System.out.println("\nDigite o ID da turma:");
		    String idTurma = scanner.nextLine().trim();
		    Turma turma = entidades.Turma.buscarTurmaPorId(idTurma);
		    
		    if (turma == null) {
		        System.out.println("Turma não encontrada.");
		        return;
		    }
		    
		    System.out.println("\nDigite o ID do aluno que deseja desmatricular:");
		    turma.listarAlunosDaTurma();
		    String idAluno = scanner.nextLine().trim();
		    
		    boolean removido = turma.removerAlunoDaTurmaPorId(idAluno);
		    
		    if (removido) {
		        System.out.println("Aluno desmatriculado da turma " + turma.getNomeTurma() + " com sucesso!");
		    } else {
		        System.out.println("Esse aluno não está matriculado nesta turma.");
		    }
		}
		
		//Alterar professor de uma turma
		public static void alterarProfessorDaTurma(Scanner scanner, Turma turma) {
		    System.out.println("\n=== Alterar Professor da Turma ===");
		    System.out.println("Turma: " + turma.getNomeTurma() + " | Professor atual: " + turma.getNomeProfessor());

		  
		    List<Professor> listaProfessores = Professor.getProfessores();
		    
		    if (listaProfessores.isEmpty()) {
		        System.out.println("Nenhum professor cadastrado no sistema.");
		        return;
		    }

		    
		    System.out.println("\n=== Professores Disponíveis ===");
		    for (Professor prof : listaProfessores) {
		        System.out.println("Nome: " + prof.getNome() + " | ID: " + prof.getId());
		    }

		    
		    System.out.println("\nDigite o ID do professor que deseja associar a esta turma:");
		    String idProfessor = scanner.nextLine().trim();

		    Professor professorSelecionado = entidades.Professor.buscarProfessorID(idProfessor);

		    if (professorSelecionado == null) {
		        System.out.println("Nenhum professor encontrado com esse ID.");
		        return;
		    }

		    
		    turma.setNomeProfessor(professorSelecionado.getNome());

		    System.out.println("\nProfessor da turma atualizado com sucesso!");
		    System.out.println("Turma: " + turma.getNomeTurma() + 
		                       " | Novo professor: " + turma.getNomeProfessor());
		}
}
