package Main3;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		//instanciar um objeto da classe Scanner
		Scanner input;
		input = new Scanner(System.in);
		//Scanner teclado = new Scanner(System.in);
		// Declarar as variáveis
		int number1, number2, sum;
		System.out.println("Digite um número inteiro: ");
		number1 = input.nextInt();
		System.out.println("Digite outro número inteiro: ");
		number2 = input.nextInt();
		
		sum = number1 + number2;
		
		System.out.println("Sum = " + sum);
		
		//fechar o teclado
		input.close();
		
	}
}
