package Main5;

import java.util.Random;

import javax.swing.JOptionPane;

public class Main5 {
	
	public static void main(String[] args) {
		// instanciar um objeto da classe Random
		Random numberGenerator = new Random();
		// declaração de variáveis
		int face1, face2, sumFaces, tries, option, userBet;
		boolean Nailit;
		// repetição do jogo
		do {
			face1 = numberGenerator.nextInt(6) + 1;
			face2 = numberGenerator.nextInt(6) + 1;
			sumFaces = face1 + face2;
			tries = 3;
			// imprimir os valores para teste
			System.out.println("Face 1: " + face1 + "- Face 2: " + face2 + "- Soma: " + sumFaces);
			Nailit = false;
			while(!Nailit && tries > 0) {
				tries--;
				userBet = Integer.parseInt(JOptionPane.showInputDialog("Digite sua aposta: "));
				if(userBet == sumFaces) {
					Nailit = true;
				}else {
					JOptionPane.showMessageDialog(null, "Voce errou!");
				}
			}
			if(Nailit) {
				JOptionPane.showMessageDialog(null, "Parabéns voce acertou!");
			}else {
				JOptionPane.showMessageDialog(null, "Game Over");
			}
			option = JOptionPane.showMessageDialog(null, "Deseja jogar novamente?");
		}while(option == 0); // enquanto for zero, o usuário continua jogando
	}

}
