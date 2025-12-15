
public class Curriculo {

	private String xp = "";
	private String nome = "";
	
	public void setXp (String empresa) {
		if(!xp.isEmpty()) {
			xp += "\n";
		}
		
		xp += empresa;
	} 
	
	public void setNome (String seunome) {
		nome = seunome;
	}
		
	public String getXp() {
		return xp;
	}
	
	public String getNome () {
		return nome;
	}
		
	public void Mensagem() {
		System.out.printf("\nParábens %s! Seu Curriculo atual:\n-> %s\n",getNome(), getXp());
	}
	
}
