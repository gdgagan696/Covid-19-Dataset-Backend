package com.dataset.covid19dataset.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dataset.covid19dataset.dto.CSVResponseDto;
import com.dataset.covid19dataset.dto.CountryStatisticsDto;
import com.dataset.covid19dataset.dto.DataPropertyDto;
import com.opencsv.CSVWriter;

@RestController
public class DataSetController {

	@Value("${covid19.data.url}")
	private String covid19DataUrl;

	@Value("${header.key}")
	private String headerKey;

	@Value("${header.value}")
	private String headerValue;

	@Value("${file.name}")
	private String fileName;

	@Value("${file.type}")
	private String fileType;

	@Value("${content.type}")
	private String contentType;

	@PostMapping("/covid-19/allCountries/csv")
	public ResponseEntity<Resource> getAllCountriesDataInCSV() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set(headerKey, headerValue);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<DataPropertyDto> response = null;
		try {
			response = restTemplate.exchange(covid19DataUrl, HttpMethod.GET, entity,
					new ParameterizedTypeReference<DataPropertyDto>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (response.getStatusCode().is2xxSuccessful() && Objects.nonNull(response.getBody())
				&& !response.getBody().getCountries().isEmpty()) {
			CSVResponseDto csvResponseDto = convertToCSV(response.getBody());
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION,
							"attachment; filename=\"" + csvResponseDto.getFileName() + "\"")
					.contentType(MediaType.parseMediaType(csvResponseDto.getFileType()))
					.contentLength(csvResponseDto.getContent().contentLength()).body(csvResponseDto.getContent());
		}
		else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/covid-19/allCountries")
	public ResponseEntity<DataPropertyDto> getAllCountriesData() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set(headerKey, headerValue);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<DataPropertyDto> response = null;
		try {
			response = restTemplate.exchange(covid19DataUrl, HttpMethod.GET, entity,
					new ParameterizedTypeReference<DataPropertyDto>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (response.getStatusCode().is2xxSuccessful() && Objects.nonNull(response.getBody())
				&& !response.getBody().getCountries().isEmpty()) {
			response.getBody().getCountries().stream().forEach(country -> country
					.setTotalActive(country.getTotalConfirmed().subtract(country.getTotalRecovered())));
			return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private CSVResponseDto convertToCSV(DataPropertyDto dataPropertyDto) {
		int currentYear = Year.now().getValue();
		String finalFileName = fileName + currentYear + "-" + (int) (Math.random() * 10) + fileType;
		CSVResponseDto csvResponseDto = new CSVResponseDto();
		csvResponseDto.setFileName(finalFileName);
		csvResponseDto.setFileType(contentType);
//		File file=new File(filePath+"/"+finalFileName);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
//			FileWriter output=new FileWriter(file);
			CSVWriter writer = new CSVWriter(new PrintWriter(out));
			String[] header = { "Country Name", "Country Code", "Total Confirmed", "Total Active", "Total Recovered",
					"Total Deaths", "Continent", "Population", "PopulationDensity", "MedianAge", "Aged65Older",
					"Aged70Older", "ExtremePoverty", "GdpPerCapita", "CvdDeathRate", "DiabetesPrevalence",
					"HandwashingFacilities", "HospitalBedsPerThousand", "LifeExpectancy", "FemaleSmokers",
					"MaleSmokers" };
			writer.writeNext(header);
			List<String[]> content = new ArrayList<>();
			dataPropertyDto.getCountries().stream().forEach(country -> {
				List<String> temp = new ArrayList<>();
				country.setTotalActive(country.getTotalConfirmed().subtract(country.getTotalRecovered()));
				temp.add(country.getCountry());
				temp.add(country.getCountryCode());
				temp.add(String.valueOf(country.getTotalConfirmed()));
				temp.add(String.valueOf(country.getTotalActive()));
				temp.add(String.valueOf(country.getTotalRecovered()));
				temp.add(String.valueOf(country.getTotalDeaths()));
				CountryStatisticsDto countryStatistics = country.getPremium().getCountryStats();
				temp.add(countryStatistics.getContinent());
				temp.add(String.valueOf(countryStatistics.getPopulation()));
				temp.add(String.valueOf(countryStatistics.getPopulationDensity()));
				temp.add(String.valueOf(countryStatistics.getMedianAge()));
				temp.add(String.valueOf(countryStatistics.getAged65Older()));
				temp.add(String.valueOf(countryStatistics.getAged70Older()));
				temp.add(String.valueOf(countryStatistics.getExtremePoverty()));
				temp.add(String.valueOf(countryStatistics.getGdpPerCapita()));
				temp.add(String.valueOf(countryStatistics.getCvdDeathRate()));
				temp.add(String.valueOf(countryStatistics.getDiabetesPrevalence()));
				temp.add(String.valueOf(countryStatistics.getHandwashingFacilities()));
				temp.add(String.valueOf(countryStatistics.getHospitalBedsPerThousand()));
				temp.add(String.valueOf(countryStatistics.getLifeExpectancy()));
				temp.add(String.valueOf(countryStatistics.getFemaleSmokers()));
				temp.add(String.valueOf(countryStatistics.getMaleSmokers()));
				content.add(temp.stream().toArray(String[]::new));
			});
			writer.writeAll(content);
			writer.flush();
			writer.close();
			csvResponseDto.setContent(new ByteArrayResource(out.toByteArray()));
//			csvResponseDto.setContent(new InputStreamResource(new ByteArrayInputStream(out.toByteArray())));
			return csvResponseDto;
		}

		catch (IOException e) {
			e.printStackTrace();
			return new CSVResponseDto();
		}
	}

}
