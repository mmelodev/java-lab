
public class EstudoGetSet {
	//também posso chamar de public class Cursos
	
	private String nomeCurso;
	
	public void setNomeCurso (String nome) {
		nomeCurso = nome;
	} //armazeando o nomeCurso dentro de uma nova variavel chamada de nome
	
	public String getNomeCurso() {
		return nomeCurso;
	} //faz o return do nomeCurso e finaliza esse metodo e (vamos ver) exibe na tela
	
	public void Mensagem() {
		System.out.printf("\nSeu curso é: %s\n", getNomeCurso()); //pelo fato de eu estar acionando um metodo preciso colocar os parenteses
	}
}
