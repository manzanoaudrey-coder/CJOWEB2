package bankaccount;

public class Main6 {
	public static void main(String[] args) {
		// instanciar um objeto da classe BankAccount
		BankAccount account1 = new BankAccount();
		
		System.out.println(account1);
		account1.displayDetails();
		account1.deposit(1000);
		System.out.println("[Show Atribute], New Balance " + account1.balance);
		account1.withdraw(1500);
		System.out.println("[Show Atribute], New Balance " + account1.balance);
		account1.clientName = "Dandicus Dancifer";
		account1.displayDetails();
	}
}
