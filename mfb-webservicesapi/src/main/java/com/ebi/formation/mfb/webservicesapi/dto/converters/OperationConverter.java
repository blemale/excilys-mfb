package com.ebi.formation.mfb.webservicesapi.dto.converters;

import java.util.ArrayList;
import java.util.List;

import com.ebi.formation.mfb.entities.Operation;
import com.ebi.formation.mfb.webservicesapi.dto.OperationDTO;

/**
 * Convertit les {@link Operation} en {@link OperationDTO}
 * 
 * @author excilys
 * 
 */
public final class OperationConverter {

	/**
	 * Empeche la classe OperationConverter d'être instanciée
	 */
	private OperationConverter() {
	}

	/**
	 * Convertit un Operation en OperationDTO
	 * 
	 * @param operation
	 * @return
	 */
	public static OperationDTO convertOperationToOperationDTO(Operation operation) {
		return new OperationDTO(operation.getId(), operation.getType(), operation.getMontant(),
				operation.getDateValeur(), operation.getDateEffet(), operation.getLabel());
	}

	public static List<OperationDTO> convertOperationListToOperationDTOList(List<Operation> operationList) {
		List<OperationDTO> operationDtoList = new ArrayList<OperationDTO>();
		for (Operation operation : operationList) {
			operationDtoList.add(convertOperationToOperationDTO(operation));
		}
		return operationDtoList;
	}
}
