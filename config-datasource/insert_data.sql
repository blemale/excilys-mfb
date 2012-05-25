-- Table ROLE
INSERT INTO role VALUES(1,'ROLE_CLIENT');
INSERT INTO role VALUES(2,'ROLE_ADMIN');

-- Table PERSON
INSERT INTO person VALUES(1, 'user','b14361404c078ffd549c03db443c3fede2f3e534d73f78f77301ed97d4a436a9fd9db05ee8b325c0ad36438b43fec8510c204fc1c1edb21d0941c00e9e2c1ce2','Tahar', 'Bakir');
INSERT INTO person VALUES(2, 'admin','c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec','Bastien', 'Lemale');
INSERT INTO person VALUES(3, 'useradmin','c6b1f50a490e0167874da05f61114d01c7562c2ebb53eb1c91407acb4eabada7bc3edbdff9d89a1181f4c16ff20789b639783082c6577da45e1a5b836b007ea9','François', 'Guillain');

-- Table AUTHORITY
INSERT INTO authority VALUES(1,1);
INSERT INTO authority VALUES(2,2);
INSERT INTO authority VALUES(3,1);
INSERT INTO authority VALUES(3,2);

-- Table COMPTE
INSERT INTO compte VALUES(1,'CSL A',1500.000, '00000001');
INSERT INTO compte VALUES(2,'CSL B',253.456, '00000002');
INSERT INTO compte VALUES(3,'CSL C',153.456, '00000003');
INSERT INTO compte VALUES(4,'CSL D',789.456, '00000004');
INSERT INTO compte VALUES(5,'PROUT A',-658454653.98, '00000005');
INSERT INTO compte VALUES(6, 'COMPTE QUE CARTES', 1664, '00000006');
INSERT INTO compte VALUES(7, 'COMPTE PAS DE CARTES', 33, '00000007');
INSERT INTO compte VALUES(8, 'COMPTE TOUT', 86, '00000008');

-- Table PERSON_COMPTE
INSERT INTO person_compte VALUES(1,1);
INSERT INTO person_compte VALUES(2,1);
INSERT INTO person_compte VALUES(3,3);
INSERT INTO person_compte VALUES(4,3);
INSERT INTO person_compte VALUES(5,1);
INSERT INTO person_compte VALUES(6,1);
INSERT INTO person_compte VALUES(7,1);
INSERT INTO person_compte VALUES(8,1);

-- Table OPERATIONTYPE
INSERT INTO operationtype VALUES(0,'VIREMENT');
INSERT INTO operationtype VALUES(1,'CARTE');
INSERT INTO operationtype VALUES(2,'ESPECE');
INSERT INTO operationtype VALUES(3,'CHEQUE');

-- Table OPERATION
INSERT INTO operation VALUES(0, 'une opération', 150.56, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(1, 'une opération', -5.551, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(2, 'une opération', 8415.485, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(3, 'une opération', 84114.48, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(4, 'une opération', -8487, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(5, 'une opération', 8451.185, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(6, 'une opération', 912154.45, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(7, 'une opération', -112, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(8, 'une opération', 12543.41564, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(9, 'une opération', 1454, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(10, 'une opération', 34784.4564, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(11, 'une opération', -484.454, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(12, 'une opération', 142.52, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(13, 'une opération', -789335.4456, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(14, 'une opération', 7845.14, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(15, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(16, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(17, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(18, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(19, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(20, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(21, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(22, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(23, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(24, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(25, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(26, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(27, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(28, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(29, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(30, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(31, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(32, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);
INSERT INTO operation VALUES(33, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 6);

INSERT INTO operation VALUES(34, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 7);
INSERT INTO operation VALUES(35, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 7);
INSERT INTO operation VALUES(36, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 7);
INSERT INTO operation VALUES(37, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 7);
INSERT INTO operation VALUES(38, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 7);
INSERT INTO operation VALUES(39, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 7);
INSERT INTO operation VALUES(40, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 7);
INSERT INTO operation VALUES(41, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 7);
INSERT INTO operation VALUES(42, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 7);
INSERT INTO operation VALUES(43, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 7);
INSERT INTO operation VALUES(44, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 7);
INSERT INTO operation VALUES(45, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 7);
INSERT INTO operation VALUES(46, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 7);
INSERT INTO operation VALUES(47, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 7);
INSERT INTO operation VALUES(48, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 7);
INSERT INTO operation VALUES(49, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 7);
INSERT INTO operation VALUES(50, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 7);
INSERT INTO operation VALUES(51, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 7);
INSERT INTO operation VALUES(52, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 7);
INSERT INTO operation VALUES(53, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 7);
INSERT INTO operation VALUES(54, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 7);
INSERT INTO operation VALUES(55, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 7);
INSERT INTO operation VALUES(56, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 7);
INSERT INTO operation VALUES(57, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 7);
INSERT INTO operation VALUES(58, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 7);
INSERT INTO operation VALUES(59, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 7);
INSERT INTO operation VALUES(60, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 7);
INSERT INTO operation VALUES(61, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 7);
INSERT INTO operation VALUES(62, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 7);
INSERT INTO operation VALUES(63, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 7);
INSERT INTO operation VALUES(64, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 7);
INSERT INTO operation VALUES(65, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 7);
INSERT INTO operation VALUES(66, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 7);

INSERT INTO operation VALUES(67, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 8);
INSERT INTO operation VALUES(68, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 8);
INSERT INTO operation VALUES(69, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 8);
INSERT INTO operation VALUES(70, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 8);
INSERT INTO operation VALUES(71, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 8);
INSERT INTO operation VALUES(72, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 8);
INSERT INTO operation VALUES(73, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 8);
INSERT INTO operation VALUES(74, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 8);
INSERT INTO operation VALUES(75, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 8);
INSERT INTO operation VALUES(76, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 8);
INSERT INTO operation VALUES(77, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 8);
INSERT INTO operation VALUES(78, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 8);
INSERT INTO operation VALUES(79, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 8);
INSERT INTO operation VALUES(80, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 8);
INSERT INTO operation VALUES(81, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 8);
INSERT INTO operation VALUES(82, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 8);
INSERT INTO operation VALUES(83, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 8);
INSERT INTO operation VALUES(84, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 8);
INSERT INTO operation VALUES(85, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 8);
INSERT INTO operation VALUES(86, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 8);
INSERT INTO operation VALUES(87, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 8);
INSERT INTO operation VALUES(88, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 8);
INSERT INTO operation VALUES(89, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 8);
INSERT INTO operation VALUES(90, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 8);
INSERT INTO operation VALUES(91, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 8);
INSERT INTO operation VALUES(92, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 8);
INSERT INTO operation VALUES(93, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 8);
INSERT INTO operation VALUES(94, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 8);
INSERT INTO operation VALUES(95, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 8);
INSERT INTO operation VALUES(96, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 1, 8);
INSERT INTO operation VALUES(97, 'une opération', -150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 2, 8);
INSERT INTO operation VALUES(98, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 3, 8);
INSERT INTO operation VALUES(99, 'une opération', 150.00, '2012-05-15 11:27:00', '2012-05-17 11:27:00', 0, 8);