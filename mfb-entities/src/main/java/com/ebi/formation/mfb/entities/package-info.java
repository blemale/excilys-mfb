@TypeDef(defaultForType = org.joda.time.DateTime.class, typeClass = PersistentDateTime.class)
@NamedQueries({
		@NamedQuery(name = "findUserDetailsByUsername", query = "SELECT p FROM Person p WHERE p.username = :username"),
		@NamedQuery(name = "findComptesByUsername", query = "SELECT p.comptes FROM Person p WHERE p.username = :username"),
		@NamedQuery(name = "checkCompteOwnershipByUsernameAndCompteId", query = "SELECT COUNT(c) FROM Person p, Compte c WHERE p.username = :username AND c.id = :compteId AND c MEMBER OF p.comptes"),
		@NamedQuery(name = "findPersonByUsername", query = "SELECT p FROM Person p WHERE p.username = :username"),
		@NamedQuery(name = "findTotalOperationsCarteByMonth", query = "SELECT SUM(o.montant) FROM Operation o WHERE o.type.label = :type AND o.compte.id = :idcompte "
				+ "and o.dateValeur BETWEEN :dateValeur AND :datePlusUnMois"),
		@NamedQuery(name = "findNumberOfOperationsByTypeByMonth", query = "SELECT COUNT(o) FROM Operation o WHERE o.type.label = :type AND o.compte.id = :idcompte "
				+ "and o.dateValeur BETWEEN :dateValeur AND :datePlusUnMois"),
		@NamedQuery(name = "findNumberOfOperationsWithoutTypeByMonth", query = "SELECT COUNT(o) FROM Operation o WHERE o.type.label != :type AND o.compte.id = :idcompte "
				+ "and o.dateValeur BETWEEN :dateValeur AND :datePlusUnMois"),
		@NamedQuery(name = "findOperationsWithoutCarteByMonthPaginated", query = "SELECT o FROM Operation o WHERE o.type.label <> 'CARTE' AND o.compte.id = :idcompte "
				+ "and o.dateValeur BETWEEN :dateValeur AND :datePlusUnMois ORDER BY o.dateValeur DESC"),
		@NamedQuery(name = "findOperationsCarteByMonthPaginated", query = "SELECT o FROM Operation o WHERE o.type.label = 'CARTE' AND o.compte.id = :idcompte "
				+ "and o.dateValeur BETWEEN :dateValeur AND :datePlusUnMois ORDER BY o.dateValeur DESC"),
		@NamedQuery(name = "findVirementByMonthPaginated", query = "SELECT o FROM Operation o WHERE o.type.label = 'VIREMENT' AND o.compte.id = :idCompte "
				+ "and o.dateValeur BETWEEN :dateValeur AND :datePlusUnMois ORDER BY o.dateValeur DESC"),
		@NamedQuery(name = "findCompteById", query = "SELECT c FROM Compte c WHERE c.id = :id"),
		@NamedQuery(name = "findOperationsBeforeDate", query = "SELECT o FROM Operation o WHERE o.dateValeur < :today"),
		@NamedQuery(name = "updateCompteWithValue", query = "UPDATE Compte c SET c.solde=c.solde+:valeur WHERE c=:operation"),
		@NamedQuery(name = "findSoldeCompte", query = "SELECT c.solde FROM Compte c WHERE c.id = :id"),
		@NamedQuery(name = "findOperationTypeByType", query = "SELECT ot FROM OperationType ot WHERE ot.label = :type") })
package com.ebi.formation.mfb.entities;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.TypeDef;
import org.jadira.usertype.dateandtime.joda.PersistentDateTime;

