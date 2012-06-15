package com.ebi.formation.mfb.webservicesapi.dto.converters;

import java.util.ArrayList;
import java.util.List;

import com.ebi.formation.mfb.entities.Compte;
import com.ebi.formation.mfb.webservicesapi.dto.CompteDTO;

/**
 * Convertit les {@link Compte} en {@link CompteDTO}
 * 
 * @author excilys
 * 
 */
public final class CompteConverter {

	/**
	 * Empeche la classe CompteConverter d'être instanciée
	 */
	private CompteConverter() {
	}

	/**
	 * Convertit un Compte en CompteDTO
	 * 
	 * @param compte
	 * @return
	 */
	public static CompteDTO convertCompteToCompteDTO(Compte compte) {
		return new CompteDTO(compte.getId(), compte.getLabel(), compte.getSolde(), compte.getSoldePrevisionnel(),
				compte.getEncoursCarte(), compte.getNumeroCompte());
	}

	/**
	 * Convertit une liste de Compte en une liste de CompteDTO
	 * 
	 * @param comptesList
	 * @return
	 */
	public static List<CompteDTO> convertCompteListToCompteDTOList(List<Compte> comptesList) {
		List<CompteDTO> compteDtoList = new ArrayList<CompteDTO>();
		for (Compte compte : comptesList) {
			compteDtoList.add(convertCompteToCompteDTO(compte));
		}
		return compteDtoList;
	}
}
