package com.dataset.covid19dataset.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class DetailedCountryInfoDto{

	private CountryStatisticsDto CountryStats;

	public CountryStatisticsDto getCountryStats() {
		return CountryStats;
	}

	public void setCountryStats(CountryStatisticsDto countryStats) {
		CountryStats = countryStats;
	}
	

}
