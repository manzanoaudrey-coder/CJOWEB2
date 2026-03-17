package main4;

import javax.swing.JOptionPane;

public class Main4 {
	public static void main(String[] args) {
		// declarar variáveis
		int number1, number2, sum;
		
		number1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro"));
		number2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro número inteiro"));
		
		sum = number1 + number2;
		
		JOptionPane.showMessageDialog(null; "Soma = " + sum);
	}
}
