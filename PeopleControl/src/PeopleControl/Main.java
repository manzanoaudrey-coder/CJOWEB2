package PeopleControl;

import java.util.Scanner;

public class Main {
	
	private Scanner scanner = new Scanner(System.in);
	
	public static int menu() {
		System.out.println("----------------------------------");
		System.out.println("--Sistema de Controle de Pessoas--");
		System.out.println("----------MENU DE OPÇÕES----------");
		System.out.println("----------------------------------");
		System.out.println("1- Cadastrar");
		System.out.println("2- Buscar pelo CPF");
		System.out.println("3- Atualizar");
		System.out.println("4- Remover");
		System.out.println("5- Sair");
		System.out.println("-----------------------------------");
		System.out.println("Escolha uma opção: ");
		return scanner.nextInt();
	}
	
	public static void register() {
		System.out.println("Digite o nome: ");
		String name = scanner.nextLine();
		System.out.println("Digite o CPF: ");
		String cpf = scanner.nextLine();
		Person person = new Person(name, cpf);
		if(manager.save(person)) {
			System.out.println("Pessoa cadastrada com sucesso!");
			System.out.println(manager.getPeopleList());
		}else {
			System.out.println("Erro ao cadastrar a pessoa");
		}
	}
	
	public static void main(String[] args) {
		int opcao;
		Person person;
		do {
			opcao = menu();
			switch(opcao) {
			case 1
			}
		}while(opcao != 5);
	}
}
