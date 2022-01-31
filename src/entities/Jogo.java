package entities;

public class Jogo {
	private Jogador jogador1;
	private Jogador jogador2;
	private static int conta_vez;
	private char[][] tabuleiro = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
	
	public Jogo(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		conta_vez = 0;
	}

	public Jogador getJogador1() {
		return jogador1;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}
	
	public void mostrarTabuleiro() {
		System.out.println("   A  B  C");  //Exibindo índices das colunas
		for (int i=0; i<3; i++) {
			switch (i) {  //Exibindo índices das linhas
				case 0: 
					System.out.print("a ");
					break;
				case 1: 
					System.out.print("b ");
					break;
				case 2:
					System.out.print("c ");
					break;
			}
			for (int j=0; j<3; j++) {
				System.out.printf("|%c|", tabuleiro[i][j]); //Exibindo os elementos do tabuleiro
			}
			System.out.println();
		}
	}
	
	public void jogar(char linha, char coluna) {
		int linhaInt = -1;
		int colunaInt = -1;
		
		if (linha == 'a'){
			linhaInt = 0;
		}else if (linha == 'b'){
			linhaInt = 1;
		}else if (linha == 'c'){
			linhaInt = 2;
		}else {
			System.out.println("Valor de linha inválido");
		}
		
		if (coluna == 'A'){
			colunaInt = 0;
		}else if (coluna == 'B'){
			colunaInt = 1;
		}else if (coluna == 'C'){
			colunaInt = 2;
		}else {
			System.out.println("Valor de coluna inválido");
		}
		
		if(linhaInt != -1 && colunaInt != -1) {
			if (conta_vez % 2 == 0 && tabuleiro[linhaInt ][colunaInt] == ' ') {
				tabuleiro[linhaInt ][colunaInt] = jogador1.getSimbolo();
			}else if (tabuleiro[linhaInt ][colunaInt] == ' '){
				tabuleiro[linhaInt ][colunaInt] = jogador2.getSimbolo();
			}else {
				System.out.println("Espaço já está ocupado !");
			}
			conta_vez++;
		}
		
	}
	
	public void mostrarVencedor(int linha, int coluna) {
		if(tabuleiro[linha][coluna] == jogador1.getSimbolo()) {
			System.out.println(jogador1.getNome() + " venceu a partida !");
			jogador1.setVitorias(1);
		}else{
			System.out.println(jogador2.getNome() + " venceu a partida !");
			jogador2.setVitorias(1);
		}
	}
	
	public boolean fimDoJogo() {
		//Verificando vitória por linha:
		for (int i=0; i<3; i++) {
			if(tabuleiro[i][0] != ' ') {
				if(tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
					this.mostrarVencedor(i,0);
					return true;
				}
			}
		}
		
		//Verificando vitória por coluna:
		for (int j=0; j<3; j++) {
			if(tabuleiro[0][j] != ' ') {
				if(tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[1][j] == tabuleiro[2][j]) {
					this.mostrarVencedor(0,j);
					return true;
				}
			}
		}
		
		//Verificando vitória por diagonal:
		if(tabuleiro[1][1] != ' ')
			if(tabuleiro[1][1] == tabuleiro[0][2] && tabuleiro[0][2] == tabuleiro[2][0]) {
				this.mostrarVencedor(1,1);
				return true;
			}
		if(tabuleiro[1][1] != ' ')
			if(tabuleiro[1][1] == tabuleiro[0][0] && tabuleiro[0][0] == tabuleiro[2][2]) {
				this.mostrarVencedor(1,1);
				return true;
			}
		
		return false;
	}

	@Override
	public String toString() {
		return "Jogo [jogador1=" + jogador1 + ", jogador2=" + jogador2 + "]";
	}
}