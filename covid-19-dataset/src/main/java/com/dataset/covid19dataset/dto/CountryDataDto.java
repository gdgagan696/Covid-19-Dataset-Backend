package com.dataset.covid19dataset.dto;

import java.math.BigInteger;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class CountryDataDto {
	private String Country;
	private String CountryCode;
	private BigInteger TotalConfirmed;
	private BigInteger TotalDeaths;
	private BigInteger TotalRecovered;
	private BigInteger TotalActive;
	private DetailedCountryInfoDto Premium;

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}

	public BigInteger getTotalConfirmed() {
		return TotalConfirmed;
	}

	public void setTotalConfirmed(BigInteger totalConfirmed) {
		TotalConfirmed = totalConfirmed;
	}

	public BigInteger getTotalDeaths() {
		return TotalDeaths;
	}

	public void setTotalDeaths(BigInteger totalDeaths) {
		TotalDeaths = totalDeaths;
	}

	public BigInteger getTotalRecovered() {
		return TotalRecovered;
	}

	public void setTotalRecovered(BigInteger totalRecovered) {
		TotalRecovered = totalRecovered;
	}

	public BigInteger getTotalActive() {
		return TotalActive;
	}

	public void setTotalActive(BigInteger totalActive) {
		TotalActive = totalActive;
	}

	public DetailedCountryInfoDto getPremium() {
		return Premium;
	}

	public void setPremium(DetailedCountryInfoDto premium) {
		Premium = premium;
	}

}
