package PeopleControl;

public class Person {
	
	private String name;
	private String cpf;
	
	public Person(String name, String cpf) {
		this.name = name;
		this.cpf = cpf;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getName (String name) {
		return name;
	}
	
	public void setCpf (String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf () {
		return cpf; 
	}
}
