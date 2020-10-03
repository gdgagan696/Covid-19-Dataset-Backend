package com.dataset.covid19dataset.dto;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class DataPropertyDto {

	private String Message;
	private HashMap<String, BigInteger> Global;
	private List<CountryDataDto> Countries;
	private Date Date;

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public HashMap<String, BigInteger> getGlobal() {
		return Global;
	}

	public void setGlobal(HashMap<String, BigInteger> global) {
		Global = global;
	}

	public List<CountryDataDto> getCountries() {
		return Countries;
	}

	public void setCountries(List<CountryDataDto> countries) {
		Countries = countries;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}
	

}
