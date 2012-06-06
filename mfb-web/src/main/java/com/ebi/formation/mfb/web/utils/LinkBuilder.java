package com.ebi.formation.mfb.web.utils;

/**
 * Classe qui construit des liens
 * 
 * @author excilys
 * 
 */
public class LinkBuilder {

	/**
	 * Constructeur empechant la classe LinkBuilder d'être instanciée
	 */
	private LinkBuilder() {
	}

	/**
	 * Retourne une URL comme ceci : /arg1/arg2/arg3/arg4...
	 * 
	 * @param params
	 * @return
	 */
	public static String getLink(Object... params) {
		if (params != null) {
			StringBuilder sb = new StringBuilder();
			for (Object param : params) {
				sb.append("/").append(param);
			}
			return sb.toString();
		} else {
			return "";
		}
	}
}
