package com.ebi.formation.mfb.web.utils;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * Classe utilisée pour le front
 * 
 * @author fguillain
 * 
 */
public class DateTimeUtils {

	private DateTime dateTime;
	private static final int NUM_OF_DATE = 4;
	public static final String OBJECT_DATES_VALEUR = "datesValeur";

	/**
	 * @return
	 */
	public static List<DateTimeUtils> getDates() {
		List<DateTimeUtils> listDates = new ArrayList<DateTimeUtils>();
		for (int i = 0; i < NUM_OF_DATE; i++) {
			listDates.add(new DateTimeUtils(new DateTime().plusDays(i)));
		}
		return listDates;
	}

	/**
	 * @param dateTime
	 */
	public DateTimeUtils(DateTime dateTime) {
		super();
		this.dateTime = dateTime;
	}

	/**
	 * @return the dateTime
	 */
	public DateTime getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime
	 *            the dateTime to set
	 */
	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return
	 */
	public String getDateTimeFormat() {
		return dateTime.toString(DateTimeFormat.forPattern("dd/MM/yyyyy"));
	}
}
