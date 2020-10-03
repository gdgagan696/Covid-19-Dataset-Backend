package com.dataset.covid19dataset.dto;

import java.math.BigInteger;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class CountryStatisticsDto {
	private String Continent;
	private BigInteger Population;
	private Double PopulationDensity;
	private Double MedianAge;
	private Double Aged65Older;
	private Double Aged70Older;
	private Double ExtremePoverty;
	private Double GdpPerCapita;
	private Double CvdDeathRate;
	private Double DiabetesPrevalence;
	private Double HandwashingFacilities;
	private Double HospitalBedsPerThousand;
	private Double LifeExpectancy;
	private Double FemaleSmokers;
	private Double MaleSmokers;

	public String getContinent() {
		return Continent;
	}

	public void setContinent(String continent) {
		Continent = continent;
	}

	public BigInteger getPopulation() {
		return Population;
	}

	public void setPopulation(BigInteger population) {
		Population = population;
	}

	public Double getPopulationDensity() {
		return PopulationDensity;
	}

	public void setPopulationDensity(Double populationDensity) {
		PopulationDensity = populationDensity;
	}

	public Double getMedianAge() {
		return MedianAge;
	}

	public void setMedianAge(Double medianAge) {
		MedianAge = medianAge;
	}

	public Double getAged65Older() {
		return Aged65Older;
	}

	public void setAged65Older(Double aged65Older) {
		Aged65Older = aged65Older;
	}

	public Double getAged70Older() {
		return Aged70Older;
	}

	public void setAged70Older(Double aged70Older) {
		Aged70Older = aged70Older;
	}

	public Double getExtremePoverty() {
		return ExtremePoverty;
	}

	public void setExtremePoverty(Double extremePoverty) {
		ExtremePoverty = extremePoverty;
	}

	public Double getGdpPerCapita() {
		return GdpPerCapita;
	}

	public void setGdpPerCapita(Double gdpPerCapita) {
		GdpPerCapita = gdpPerCapita;
	}

	public Double getCvdDeathRate() {
		return CvdDeathRate;
	}

	public void setCvdDeathRate(Double cvdDeathRate) {
		CvdDeathRate = cvdDeathRate;
	}

	public Double getDiabetesPrevalence() {
		return DiabetesPrevalence;
	}

	public void setDiabetesPrevalence(Double diabetesPrevalence) {
		DiabetesPrevalence = diabetesPrevalence;
	}

	public Double getHandwashingFacilities() {
		return HandwashingFacilities;
	}

	public void setHandwashingFacilities(Double handwashingFacilities) {
		HandwashingFacilities = handwashingFacilities;
	}

	public Double getHospitalBedsPerThousand() {
		return HospitalBedsPerThousand;
	}

	public void setHospitalBedsPerThousand(Double hospitalBedsPerThousand) {
		HospitalBedsPerThousand = hospitalBedsPerThousand;
	}

	public Double getLifeExpectancy() {
		return LifeExpectancy;
	}

	public void setLifeExpectancy(Double lifeExpectancy) {
		LifeExpectancy = lifeExpectancy;
	}

	public Double getFemaleSmokers() {
		return FemaleSmokers;
	}

	public void setFemaleSmokers(Double femaleSmokers) {
		FemaleSmokers = femaleSmokers;
	}

	public Double getMaleSmokers() {
		return MaleSmokers;
	}

	public void setMaleSmokers(Double maleSmokers) {
		MaleSmokers = maleSmokers;
	}

}
