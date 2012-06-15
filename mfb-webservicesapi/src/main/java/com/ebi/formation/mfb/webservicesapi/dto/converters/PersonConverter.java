package com.ebi.formation.mfb.webservicesapi.dto.converters;

import java.util.ArrayList;
import java.util.List;

import com.ebi.formation.mfb.entities.Person;
import com.ebi.formation.mfb.webservicesapi.dto.PersonDTO;

/**
 * Convertit les {@link Person} en {@link PersonDTO}
 * 
 * @author excilys
 * 
 */
public final class PersonConverter {

	/**
	 * Empeche la classe PersonConverter d'être instanciée
	 */
	private PersonConverter() {
	}

	/**
	 * Convertit un Person en PersonDTO
	 * 
	 * @param person
	 * @return
	 */
	public static PersonDTO convertPersonToPersonDTO(Person person) {
		return new PersonDTO(person.getId(), person.getUsername(), person.getPassword(), person.getFirstName(),
				person.getLastName());
	}

	/**
	 * Convertit une liste de Person en une liste de PersonDTO
	 * 
	 * @param personList
	 * @return
	 */
	public static List<PersonDTO> convertPersonListToPersonDTOList(List<Person> personList) {
		List<PersonDTO> personDtoList = new ArrayList<PersonDTO>();
		for (Person person : personList) {
			personDtoList.add(convertPersonToPersonDTO(person));
		}
		return personDtoList;
	}
}
