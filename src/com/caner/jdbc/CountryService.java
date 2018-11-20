package com.caner.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountryService {

	static HashMap<Integer, Country> countryIdMap = getCountryIdMap();

	public CountryService() {
		super();

		if (countryIdMap == null) {
			countryIdMap = new HashMap<Integer, Country>();
			// Creating some objects of Country while initializing
			Country turkeyCountry = new Country(1, "Turkey", 10000);
			Country chinaCountry = new Country(4, "China", 20000);
			Country arjantinaCountry = new Country(3, "Arjantin", 8000);
			Country russiaCountry = new Country(2, "Russia", 7000);

			countryIdMap.put(1, turkeyCountry);
			countryIdMap.put(4, chinaCountry);
			countryIdMap.put(3, arjantinaCountry);
			countryIdMap.put(2, russiaCountry);
		}
	}

	public List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<Country>(countryIdMap.values());
		return countries;
	}

	public Country getCountry(int id) {
		Country country = countryIdMap.get(id);
		return country;
	}

	public Country addCountry(Country country) {
		country.setId(countryIdMap.size() + 1);
		countryIdMap.put(country.getId(), country);
		return country;
	}

	public Country updateCountry(Country country) {
		if (country.getId() <= 0)
			return null;
		countryIdMap.put(country.getId(), country);
		return country;

	}

	public void deleteCountry(int id) {
		countryIdMap.remove(id);
	}

	public static HashMap<Integer, Country> getCountryIdMap() {
		return countryIdMap;
	}
}
