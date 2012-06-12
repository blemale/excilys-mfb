package com.ebi.formation.mfb.web.utils;

import java.math.BigDecimal;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
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
public final class ExcelGenerator {

	private static CellStyle styleVert;
	private static CellStyle styleRouge;
	private static CellStyle styleCentre;
	private static CellStyle styleAlligneDroite;
	private static CellStyle styleAlligneGauche;
	private static CellStyle styleCentreGras;
	private static CellStyle styleBorderEncadreHaut;
	private static int i;
	private static final int FONT_GRAS_FONT_HEIGHT = 200;
	private static final int END_MERGE_REGION = 4;
	private static final int START_MERGE_REGION = 0;
	private static final int DATE_EFFET_COLUMN = 0;
	private static final int DATE_VALEUR_COLUMN = 1;
	private static final int TYPE_COLUMN  = 2;
	private static final int LIBELLE_COLUMN = 3;
	private static final int MONTANT_COLUMN = 4;

	/**
	 * Constructeur empechant la classe ExcelGenerator d'être instanciée
	 */
	private ExcelGenerator() {
	}

	/**
	 * Méthode statique renvoyant la feuille excel générée.
	 * 
	 * @param idCompte
	 * 
	 * @param nomCompte
	 * @param month
	 * @param year
	 * @param listeOperations
	 * @param owners
	 * @return
	 */
	public static Workbook getWorkBook(Long idCompte, String nomCompte, int month, int year,
			List<Operation> listeOperations) {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("Compte");
		i = 0;
		definitStyles(wb);
		creeTitrePageEtTitresColonnes(idCompte, sheet, nomCompte, month, year);
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
		styleVert.setBorderTop(CellStyle.BORDER_THIN);
		/**/
		styleRouge = wb.createCellStyle();
		Font fontRouge = wb.createFont();
		fontRouge.setColor(HSSFColor.RED.index);
		styleRouge.setAlignment(CellStyle.ALIGN_RIGHT);
		styleRouge.setFont(fontRouge);
		styleRouge.setBorderTop(CellStyle.BORDER_THIN);
		/**/
		styleCentre = wb.createCellStyle();
		styleCentre.setAlignment(CellStyle.ALIGN_CENTER);
		styleCentre.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		styleCentre.setFillPattern(CellStyle.BIG_SPOTS);
		Font fontBlanc = wb.createFont();
		fontBlanc.setColor(HSSFColor.WHITE.index);
		styleCentre.setFont(fontBlanc);
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
		fontGras.setFontHeight((short) FONT_GRAS_FONT_HEIGHT);
		styleCentreGras.setFont(fontGras);
		/**/
		styleBorderEncadreHaut = wb.createCellStyle();
		styleBorderEncadreHaut.setBorderTop(CellStyle.BORDER_THIN);
	}

	/**
	 * Explicite.
	 * 
	 * @param idCompte
	 * 
	 * @param sheet
	 * @param nomCompte
	 * @param month
	 * @param year
	 * @param owners
	 */
	private static void creeTitrePageEtTitresColonnes(Long idCompte, Sheet sheet, String nomCompte, int month, int year) {
		sheet.createRow(i).createCell(0)
				.setCellValue("Relevé du compte n°" + idCompte + " \"" + nomCompte + "\" de " + month + "/" + year);
		sheet.addMergedRegion(new CellRangeAddress(i, i, START_MERGE_REGION, END_MERGE_REGION));
		sheet.getRow(i).getCell(0).setCellStyle(styleCentreGras);
		i += 2;
		sheet.createRow(i).createCell(DATE_EFFET_COLUMN).setCellValue("Date d'effet");
		sheet.getRow(i).getCell(DATE_EFFET_COLUMN).setCellStyle(styleCentre);
		sheet.getRow(i).createCell(DATE_VALEUR_COLUMN).setCellValue("Date de valeur");
		sheet.getRow(i).getCell(DATE_VALEUR_COLUMN).setCellStyle(styleCentre);
		sheet.getRow(i).createCell(TYPE_COLUMN).setCellValue("Type");
		sheet.getRow(i).getCell(TYPE_COLUMN).setCellStyle(styleCentre);
		sheet.getRow(i).createCell(LIBELLE_COLUMN).setCellValue("Libellé");
		sheet.getRow(i).getCell(LIBELLE_COLUMN).setCellStyle(styleCentre);
		sheet.getRow(i).createCell(MONTANT_COLUMN).setCellValue("Montant");
		sheet.getRow(i).getCell(MONTANT_COLUMN).setCellStyle(styleCentre);
	}

	/**
	 * Explicite.
	 * 
	 * @param sheet
	 * @param listeOperations
	 */
	private static void remplitTableau(Sheet sheet, List<Operation> listeOperations) {
		i++;
		BigDecimal in = BigDecimal.ZERO;
		BigDecimal out = BigDecimal.ZERO;
		for (Operation operation : listeOperations) {
			sheet.createRow(i)
					.createCell(DATE_EFFET_COLUMN)
					.setCellValue(
							operation.getDateEffet().getDayOfMonth() + "/" + operation.getDateEffet().getMonthOfYear()
									+ "/" + operation.getDateEffet().getYear());
			sheet.getRow(i)
					.createCell(DATE_VALEUR_COLUMN)
					.setCellValue(
							operation.getDateValeur().getDayOfMonth() + "/"
									+ operation.getDateValeur().getMonthOfYear() + "/"
									+ operation.getDateValeur().getYear());
			sheet.getRow(i).createCell(TYPE_COLUMN).setCellValue(operation.getType().getLabel().name());
			sheet.getRow(i).createCell(LIBELLE_COLUMN).setCellValue(operation.getLabel());
			sheet.getRow(i).getCell(DATE_EFFET_COLUMN).setCellStyle(styleBorderEncadreHaut);
			sheet.getRow(i).getCell(DATE_VALEUR_COLUMN).setCellStyle(styleBorderEncadreHaut);
			sheet.getRow(i).getCell(TYPE_COLUMN).setCellStyle(styleBorderEncadreHaut);
			sheet.getRow(i).getCell(LIBELLE_COLUMN).setCellStyle(styleBorderEncadreHaut);
			if (operation.getMontant().compareTo(BigDecimal.ZERO) == 1) {
				sheet.getRow(i).createCell(MONTANT_COLUMN).setCellValue("+ " + operation.getMontant().doubleValue());
				sheet.getRow(i).getCell(MONTANT_COLUMN).setCellStyle(styleVert);
				in = in.add(operation.getMontant());
			} else {
				sheet.getRow(i).createCell(MONTANT_COLUMN).setCellValue("- " + (-1 * operation.getMontant().doubleValue()));
				sheet.getRow(i).getCell(MONTANT_COLUMN).setCellStyle(styleRouge);
				out = out.add(operation.getMontant());
			}
			i++;
		}
		out = out.multiply(new BigDecimal(-1));
		i = i + 2;
		sheet.createRow(i).createCell(LIBELLE_COLUMN).setCellValue("Crédits : ");
		sheet.getRow(i).createCell(MONTANT_COLUMN).setCellValue("+ " + in.doubleValue());
		sheet.getRow(i).getCell(LIBELLE_COLUMN).setCellStyle(styleAlligneDroite);
		sheet.getRow(i).getCell(MONTANT_COLUMN).setCellStyle(styleAlligneDroite);
		i++;
		sheet.createRow(i).createCell(LIBELLE_COLUMN).setCellValue("Débits : ");
		sheet.getRow(i).createCell(MONTANT_COLUMN).setCellValue("- " + out.doubleValue());
		sheet.getRow(i).getCell(LIBELLE_COLUMN).setCellStyle(styleAlligneDroite);
		sheet.getRow(i).getCell(MONTANT_COLUMN).setCellStyle(styleAlligneDroite);
		/****/
		sheet.setColumnWidth(DATE_EFFET_COLUMN, 3200);
		sheet.setColumnWidth(DATE_VALEUR_COLUMN, 3200);
		sheet.setColumnWidth(TYPE_COLUMN, 3200);
		sheet.setColumnWidth(LIBELLE_COLUMN, 9000);
		sheet.setColumnWidth(MONTANT_COLUMN, 4000);
	}
}
