-- Table PERSON
INSERT INTO person VALUES(DEFAULT, 'user','b14361404c078ffd549c03db443c3fede2f3e534d73f78f77301ed97d4a436a9fd9db05ee8b325c0ad36438b43fec8510c204fc1c1edb21d0941c00e9e2c1ce2','Tahar', 'Bakir');
INSERT INTO person VALUES(DEFAULT, 'admin','c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec','Bastien', 'Lemale');
INSERT INTO person VALUES(DEFAULT, 'useradmin','c6b1f50a490e0167874da05f61114d01c7562c2ebb53eb1c91407acb4eabada7bc3edbdff9d89a1181f4c16ff20789b639783082c6577da45e1a5b836b007ea9','François', 'Guillain');

-- Table AUTHORITY
INSERT INTO authority VALUES(1,1);
INSERT INTO authority VALUES(2,2);
INSERT INTO authority VALUES(3,1);
INSERT INTO authority VALUES(3,2);

-- Table COMPTE
INSERT INTO compte VALUES(DEFAULT, 'COMPTE 1 user', 1000, '00-000-01');
INSERT INTO compte VALUES(DEFAULT, 'COMPTE 2 user', 2000, '00-000-02');
INSERT INTO compte VALUES(DEFAULT, 'COMPTE 1 useradmin', 3000, '00-000-03');

-- Table PERSON_COMPTE
INSERT INTO person_compte VALUES(1,1);
INSERT INTO person_compte VALUES(2,1);
INSERT INTO person_compte VALUES(3,2);

-- Table OPERATION
-- 21 virement dans le compte "1" appartenant à l'utilisateur "user"
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);
INSERT INTO operation VALUES(DEFAULT, 'un virement', 10, current_timestamp, current_timestamp, 1, 1);

INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);
INSERT INTO operation VALUES(DEFAULT, 'une opération carte', 10, current_timestamp, current_timestamp, 2, 2);

