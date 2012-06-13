@TypeDef(defaultForType = org.joda.time.DateTime.class, typeClass = PersistentDateTime.class)
@NamedQueries({
		@NamedQuery(name = "findUserDetailsByUsername", query = "SELECT p FROM Person p WHERE p.username = :username"),
		@NamedQuery(name = "findComptesByUsername", query = "SELECT p.comptes FROM Person p WHERE p.username = :username"),
		@NamedQuery(name = "checkCompteOwnershipByUsernameAndCompteId", query = "SELECT COUNT(c) FROM Person p, Compte c WHERE p.username = :username AND c.id = :compteId AND c MEMBER OF p.comptes"),
		@NamedQuery(name = "findPersonByUsername", query = "SELECT p FROM Person p WHERE p.username = :username"),
		@NamedQuery(name = "findTotalOperationsCarteByMonth", query = "SELECT SUM(o.montant) FROM Operation o WHERE o.type.label = :type AND o.compte.id = :idcompte "
				+ "AND o.dateValeur BETWEEN :dateValeur AND :datePlusUnMois"),
		@NamedQuery(name = "findNumberOfOperationsByTypeByMonth", query = "SELECT COUNT(o) FROM Operation o WHERE o.type.label = :type AND o.compte.id = :idcompte "
				+ "AND o.dateValeur BETWEEN :dateValeur AND :datePlusUnMois"),
		@NamedQuery(name = "findNumberOfOperationsWithoutTypeByMonth", query = "SELECT COUNT(o) FROM Operation o WHERE o.type.label != :type AND o.compte.id = :idcompte "
				+ "AND o.dateValeur BETWEEN :dateValeur AND :datePlusUnMois"),
		@NamedQuery(name = "findOperationsWithoutCarteByMonthPaginated", query = "SELECT o FROM Operation o WHERE o.type.label <> 'CARTE' AND o.compte.id = :idcompte "
				+ "AND o.dateValeur BETWEEN :dateValeur AND :datePlusUnMois ORDER BY o.dateValeur DESC"),
		@NamedQuery(name = "findOperationsCarteByMonthPaginated", query = "SELECT o FROM Operation o WHERE o.type.label = 'CARTE' AND o.compte.id = :idcompte "
				+ "AND o.dateValeur BETWEEN :dateValeur AND :datePlusUnMois ORDER BY o.dateValeur DESC"),
		@NamedQuery(name = "findVirementByMonthPaginated", query = "SELECT o FROM Operation o WHERE o.type.label = 'VIREMENT' AND o.compte.id = :idCompte "
				+ "AND o.dateValeur BETWEEN :dateValeur AND :datePlusUnMois ORDER BY o.dateValeur DESC"),
		@NamedQuery(name = "findCompteById", query = "SELECT c FROM Compte c WHERE c.id = :id"),
		@NamedQuery(name = "findCompteByNumeroCompte", query = "SELECT c FROM Compte c WHERE c.numeroCompte = :numeroCompte"),
		@NamedQuery(name = "findOperationsNotDone", query = "SELECT o FROM Operation o WHERE o.operationDone = false AND o.dateValeur <= :today"),
		@NamedQuery(name = "updateCompteSolde", query = "UPDATE Compte c SET c.solde = c.solde+ :valeur WHERE c.id = :compteOperationId"),
		@NamedQuery(name = "updateCompteSoldeAndEncoursCarte", query = "UPDATE Compte c SET c.solde = c.solde+ :valeur, c.encoursCarte = c.encoursCarte- :valeur WHERE c.id = :compteOperationId"),
		@NamedQuery(name = "updateOperationNotDone", query = "UPDATE Operation o SET o.operationDone = true WHERE o.id = :operationId"),
		@NamedQuery(name = "updateComptes", query = "UPDATE Compte c SET c.soldePrevisionnel=c.solde"),
		@NamedQuery(name = "findSoldeCompte", query = "SELECT c.solde FROM Compte c WHERE c.id = :id"),
		@NamedQuery(name = "findEncoursCarteCompte", query = "SELECT c.encoursCarte FROM Compte c WHERE c.id = :id"),
		@NamedQuery(name = "findAllOperationsByMonthByCompte", query = "SELECT o FROM Operation o WHERE o.compte.id = :idcompte "
				+ "AND o.dateValeur BETWEEN :dateValeur AND :datePlusUnMois ORDER BY o.dateValeur DESC"),
		@NamedQuery(name = "findOperationTypeByType", query = "SELECT ot FROM OperationType ot WHERE ot.label = :type"),
		@NamedQuery(name = "findAllPersons", query = "SELECT p FROM Person p"),
		@NamedQuery(name = "findRoleByRight", query = "SELECT r FROM Role r WHERE r.right=:right"),
		@NamedQuery(name = "findAllRights", query = "SELECT r.right FROM Role r"),
		@NamedQuery(name = "findAllOperationTypes", query = "SELECT ot.label FROM OperationType ot"),
		@NamedQuery(name = "findAllComptes", query = "SELECT c FROM Compte c"),
		@NamedQuery(name = "updateCompteEncoursCarteAndSoldePrevisionnel", query = "UPDATE Compte c SET c.encoursCarte = c.encoursCarte+ :valeur, c.soldePrevisionnel = c.soldePrevisionnel+ :valeur WHERE c.id = :compteOperationId"),
		@NamedQuery(name = "updateCompteSoldePrevisionnel", query = "UPDATE Compte c SET c.soldePrevisionnel = c.soldePrevisionnel+ :valeur WHERE c.id = :compteOperationId"),
		@NamedQuery(name = "updateCompteSoldeAndSoldePrevisionnel", query = "UPDATE Compte c SET c.solde = c.solde+ :valeur, c.soldePrevisionnel = c.soldePrevisionnel+ :valeur WHERE c.id = :compteOperationId"), })
package com.ebi.formation.mfb.entities;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.TypeDef;
import org.jadira.usertype.dateandtime.joda.PersistentDateTime;

