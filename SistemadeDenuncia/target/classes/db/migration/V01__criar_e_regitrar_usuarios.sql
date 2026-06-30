CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  password varchar(150) NOT NULL,
  birth_date date NOT NULL,
  gender varchar(30) NOT NULL,
  active tinyint(1) NOT NULL,
  adress varchar(50) NOT NULL,
  neighborhood varchar(50) NOT NULL,
  country varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user (id, name, email, password, birth_date, gender, active, adress, neighborhood, country) 
	values (1, 'Fernando Duarte', 'fernandoduarte@ifsp.edu.br', '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji', '1975-11-16', 'MASCULINO', 'Rua dos Banks 800', 'Uberlandia', Brasil, 1);
INSERT INTO user (id, name, email, password, birth_date, gender, active, adress, neighborhood, country) 
	values (2, 'Juliana Silva', 'julianasilva@ifsp.edu.br', '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji', '1980-01-01', 'FEMININO', 'Rua dos Bobos 0 ', 'Lugar Nenhum', 'Brasil' , 1);
	
	