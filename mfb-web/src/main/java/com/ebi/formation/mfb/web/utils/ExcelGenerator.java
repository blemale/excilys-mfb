package com.ebi.formation.mfb.web.utils;

import java.math.BigDecimal;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.ebi.formation.mfb.entities.Operation;

/**
 * Crée une feuille excel avec les informations d'un compte donné et le renvoie.
 * 
 * @author kpogorzelski
 * 
 */
public class ExcelGenerator {

	private static CellStyle styleVert;
	private static CellStyle styleRouge;
	private static CellStyle styleCentre;
	private static CellStyle styleAlligneDroite;
	private static CellStyle styleAlligneGauche;
	private static CellStyle styleCentreGras;
	private static int i;

	/**
	 * Méthode statique renvoyant la feuille excel générée.
	 * 
	 * @param nomCompte
	 * @param month
	 * @param year
	 * @param listeOperations
	 * @param owners
	 * @return
	 */
	public static Workbook getWorkBook(String nomCompte, int month, int year, List<Operation> listeOperations) {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("Compte");
		i = 0;
		definitStyles(wb);
		creeTitrePageEtTitresColonnes(sheet, nomCompte, month, year);
		remplitTableau(sheet, listeOperations);
		/****/
		return wb;
	}

	/**
	 * Méthode pour définir les styles.
	 * 
	 * @param wb
	 */
	private static void definitStyles(Workbook wb) {
		styleVert = wb.createCellStyle();
		Font fontVert = wb.createFont();
		fontVert.setColor(HSSFColor.GREEN.index);
		styleVert.setAlignment(CellStyle.ALIGN_RIGHT);
		styleVert.setFont(fontVert);
		/**/
		styleRouge = wb.createCellStyle();
		Font fontRouge = wb.createFont();
		fontRouge.setColor(HSSFColor.RED.index);
		styleRouge.setAlignment(CellStyle.ALIGN_RIGHT);
		styleRouge.setFont(fontRouge);
		/**/
		styleCentre = wb.createCellStyle();
		styleCentre.setAlignment(CellStyle.ALIGN_CENTER);
		/**/
		styleAlligneDroite = wb.createCellStyle();
		styleAlligneDroite.setAlignment(CellStyle.ALIGN_RIGHT);
		/**/
		styleAlligneGauche = wb.createCellStyle();
		styleAlligneGauche.setAlignment(CellStyle.ALIGN_LEFT);
		/**/
		styleCentreGras = wb.createCellStyle();
		styleCentreGras.setAlignment(CellStyle.ALIGN_CENTER);
		Font fontGras = wb.createFont();
		fontGras.setBoldweight(Font.BOLDWEIGHT_BOLD);
		fontGras.setFontHeight((short) 200);
		styleCentreGras.setFont(fontGras);
	}

	/**
	 * Explicite.
	 * 
	 * @param sheet
	 * @param nomCompte
	 * @param month
	 * @param year
	 * @param owners
	 */
	private static void creeTitrePageEtTitresColonnes(Sheet sheet, String nomCompte, int month, int year) {
		sheet.createRow(i).createCell(0)
				.setCellValue("Relevé du compte \"" + nomCompte + "\" de " + month + "/" + year);
		sheet.addMergedRegion(new CellRangeAddress(i, i, 0, 4));
		sheet.getRow(i).getCell(0).setCellStyle(styleCentreGras);
		i += 2;
		sheet.createRow(i).createCell(0).setCellValue("Date d'effet");
		sheet.getRow(i).getCell(0).setCellStyle(styleCentre);
		sheet.getRow(i).createCell(1).setCellValue("Date de valeur");
		sheet.getRow(i).getCell(1).setCellStyle(styleCentre);
		sheet.getRow(i).createCell(2).setCellValue("Type");
		sheet.getRow(i).getCell(2).setCellStyle(styleCentre);
		sheet.getRow(i).createCell(3).setCellValue("Libellé");
		sheet.getRow(i).getCell(3).setCellStyle(styleCentre);
		sheet.getRow(i).createCell(4).setCellValue("Montant");
		sheet.getRow(i).getCell(4).setCellStyle(styleCentre);
	}

	/**
	 * Explicite.
	 * 
	 * @param sheet
	 * @param listeOperations
	 */
	private static void remplitTableau(Sheet sheet, List<Operation> listeOperations) {
		i++;
		BigDecimal in = new BigDecimal(0);
		BigDecimal out = new BigDecimal(0);
		for (Operation operation : listeOperations) {
			sheet.createRow(i)
					.createCell(0)
					.setCellValue(
							operation.getDateEffet().getDayOfMonth() + "/" + operation.getDateEffet().getMonthOfYear()
									+ "/" + operation.getDateEffet().getYear());
			sheet.getRow(i)
					.createCell(1)
					.setCellValue(
							operation.getDateValeur().getDayOfMonth() + "/"
									+ operation.getDateValeur().getMonthOfYear() + "/"
									+ operation.getDateValeur().getYear());
			sheet.getRow(i).createCell(2).setCellValue(operation.getType().getLabel().name());
			sheet.getRow(i).createCell(3).setCellValue(operation.getLabel());
			if (operation.getMontant().compareTo(new BigDecimal(0)) == 1) {
				sheet.getRow(i).createCell(4).setCellValue("+ " + operation.getMontant().doubleValue());
				sheet.getRow(i).getCell(4).setCellStyle(styleVert);
				in = in.add(operation.getMontant());
			} else {
				sheet.getRow(i).createCell(4).setCellValue("- " + (-1 * operation.getMontant().doubleValue()));
				sheet.getRow(i).getCell(4).setCellStyle(styleRouge);
				out = out.add(operation.getMontant());
			}
			i++;
		}
		out = out.multiply(new BigDecimal(-1));
		i = i + 2;
		sheet.createRow(i).createCell(3).setCellValue("Crédits : ");
		sheet.getRow(i).createCell(4).setCellValue("+ " + in.toString());
		sheet.getRow(i).getCell(3).setCellStyle(styleAlligneDroite);
		sheet.getRow(i).getCell(4).setCellStyle(styleAlligneDroite);
		i++;
		sheet.createRow(i).createCell(3).setCellValue("Débits : ");
		sheet.getRow(i).createCell(4).setCellValue("- " + out.toString());
		sheet.getRow(i).getCell(3).setCellStyle(styleAlligneDroite);
		sheet.getRow(i).getCell(4).setCellStyle(styleAlligneDroite);
		/****/
		sheet.setColumnWidth(0, 3200);
		sheet.setColumnWidth(1, 3200);
		sheet.setColumnWidth(2, 3200);
		sheet.setColumnWidth(3, 9000);
		sheet.setColumnWidth(4, 4000);
	}
}
