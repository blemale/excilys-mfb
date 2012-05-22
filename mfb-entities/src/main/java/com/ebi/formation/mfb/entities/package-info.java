@TypeDef(defaultForType = org.joda.time.DateTime.class, typeClass = PersistentDateTime.class)
@NamedQueries({
		@NamedQuery(name = "findUserDetailsByUsername", query = "SELECT p FROM Person p WHERE p.username = :username"),
		@NamedQuery(name = "findComptesByUsername", query = "SELECT p.comptes FROM Person p WHERE p.username = :username") })
package com.ebi.formation.mfb.entities;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.TypeDef;
import org.jadira.usertype.dateandtime.joda.PersistentDateTime;

