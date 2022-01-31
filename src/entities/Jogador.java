package entities;

public class Jogador {
	private String nome;
	private char simbolo;
	private int vitorias;
	
	public Jogador(String nome, char simbolo) {
		this.nome = nome;
		this.simbolo = simbolo;
		this.vitorias = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias += vitorias;
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", simbolo=" + simbolo + "]";
	}
	
	
}
