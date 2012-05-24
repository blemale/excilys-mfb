@TypeDef(defaultForType = org.joda.time.DateTime.class, typeClass = PersistentDateTime.class)
@NamedQueries({
		@NamedQuery(name = "findUserDetailsByUsername", query = "SELECT p FROM Person p WHERE p.username = :username"),
		@NamedQuery(name = "findComptesByUsername", query = "SELECT p.comptes FROM Person p WHERE p.username = :username"),
		@NamedQuery(name = "findPersonByUsername", query = "SELECT p FROM Person p WHERE p.username = :username"),
		@NamedQuery(name = "findTotalOperationsCarteByMonth", query = "SELECT SUM(o.montant) FROM Operation o WHERE o.type.label = :type AND o.compte.id = :idcompte "
				+ "and o.dateEffet BETWEEN :dateEffet AND :datePlusUnMois"),
		@NamedQuery(name = "findNumberOfOperationsCarteByMonth", query = "SELECT COUNT(o) FROM Operation o WHERE o.type.label = :type AND o.compte.id = :idcompte "
				+ "and o.dateEffet BETWEEN :dateEffet AND :datePlusUnMois"),
		@NamedQuery(name = "findOperationsWithoutCarteByMonthPaginated", query = "SELECT o FROM Operation o WHERE o.type.label <> 'CARTE' AND o.compte.id = :idcompte "
				+ "and o.dateEffet BETWEEN :dateEffet AND :datePlusUnMois ORDER BY o.dateEffet"),
		@NamedQuery(name = "findOperationsCarteByMonthPaginated", query = "SELECT o FROM Operation o WHERE o.type.label = 'CARTE' AND o.compte.id = :idcompte "
				+ "and o.dateEffet BETWEEN :dateEffet AND :datePlusUnMois ORDER BY o.dateEffet") })
package com.ebi.formation.mfb.entities;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.TypeDef;
import org.jadira.usertype.dateandtime.joda.PersistentDateTime;

