package entidades;

public class GeradorID {
	
	//contador dos IDS
	private static int contAluno = 1;
	private static int contProfessor = 1;
	//private static int contDiretor = 1;
	private static int contTurma = 1;
	
	//Gerador ID aluno
	public static String gerarIdAluno(String cpf) {
		String inicioCPF = cpf.substring(0, 3);
		String id = "A" + inicioCPF + String.format("%03d", contAluno++);
		return id;
	}
	
	//Gerador ID professor
	public static String gerarIdProfessor(String cpf) {
		String inicioCPF = cpf.substring(0, 3);
		String id = "P" + inicioCPF + String.format("%03d", contProfessor++);
		return id;
	}
	
	//Gerador ID diretor
	/*public static String gerarIdDiretor(String cpf) {
		String inicioCPF = cpf.substring(0, 3);
		String id = "D" + inicioCPF + String.format("%03d", contDiretor++);
		return id;
	}*/
	
	//Gerador ID turma
	public static String gerarIdTurma() {
		String id = "T" + String.format("%03d", contTurma++);
		return id;
	}
}
