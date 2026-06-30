CREATE TABLE denunciation (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	type VARCHAR(20) NOT NULL,
	denunciation_date DATE NOT NULL,
	distance DOUBLE NOT NULL,
	duration INT NOT NULL,
	user_id BIGINT(20) NOT NULL,
	FOREIGN KEY (user_id) REFERENCES user(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO denunciation (type, denunciation_date, distance, duration, user_id ) values ('MAUS TRATOS A ANIMAIS', '2025-04-18', 8.0, 42, 1);
INSERT INTO denunciation (type, denunciation_date, distance, duration, user_id ) values ('ROUBO', '2025-04-16', 8.0, 43, 1);
INSERT INTO denunciation (type, denunciation_date, distance, duration, user_id ) values ('ASSASSINATO', '2025-04-18', 5.0, 55, 2);

