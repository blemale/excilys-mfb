package com.ebi.formation.mfb.web.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * @author fguillain
 * 
 */
public class DateTimeUtils {

	private DateTime dateTime;

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
