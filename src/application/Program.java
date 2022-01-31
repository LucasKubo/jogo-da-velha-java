package application;

import java.util.Scanner;
import entities.Jogador;
import entities.Jogo;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Jogador j1 = new Jogador("Lucas", 'X');
		Jogador j2 = new Jogador("Pedro", 'O');
		Jogo jogo1 = new Jogo(j1,j2);
		
		char linha, coluna;
		
		jogo1.mostrarTabuleiro();
		
		while(!jogo1.fimDoJogo()) {
			
			System.out.println("Digite as coordenadas (x,y): ");
			linha = sc.next().charAt(0);
			coluna = sc.next().charAt(0);
			
			jogo1.jogar(linha,coluna);
			jogo1.mostrarTabuleiro();
	
		}
		
		sc.close();
	}

}
