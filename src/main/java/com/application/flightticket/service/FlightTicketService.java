package com.application.flightticket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.flightticket.dao.FlightTicketDao;
import com.application.flightticket.entity.SearchPojo;
import com.application.flightticket.entity.SearchResultDto;

@Service
public class FlightTicketService {

	@Autowired
	FlightTicketDao flightTicketDao;
	
	
	public List<SearchResultDto> fetchDetails(SearchPojo searchPojo) {
		List<SearchResultDto> resultList = flightTicketDao.findByDestinationCity(searchPojo.getDestinationCity());
		resultList.sort((SearchResultDto s1, SearchResultDto s2) -> Integer.valueOf(s1.getPrice())
				.compareTo(Integer.valueOf(s2.getPrice())));
		return resultList;
	}
	
	public void insert() {
		List<SearchResultDto> insertList = new ArrayList<>();
		insertSampleDataForCoimbatore(insertList);
		insertSampleDataForTirunelveli(insertList);
	}
	
	
	private void insertSampleDataForTirunelveli(List<SearchResultDto> insertList) {
		SearchResultDto searchResultDto = new SearchResultDto();
		// 1st record
		searchResultDto.setArrivalTime("11 AM");
		searchResultDto.setFlightNumber("TN 14 S206");
		searchResultDto.setDepartureTime("9 PM");
		searchResultDto.setDestinationCity("Tirunelveli");
		searchResultDto.setDuration("14 HRS");
		searchResultDto.setAirlaneName("Vicky");
		searchResultDto.setPrice("1500");
		searchResultDto.setSourceCity("Chennai");
		flightTicketDao.save(searchResultDto);
		// 2nd record
		searchResultDto.setArrivalTime("9 AM");
		searchResultDto.setFlightNumber("TN 14 S207");
		searchResultDto.setDepartureTime("7 PM");
		searchResultDto.setDestinationCity("Tirunelveli");
		searchResultDto.setDuration("14 HRS");
		searchResultDto.setAirlaneName("Siva");
		searchResultDto.setPrice("1200");
		searchResultDto.setSourceCity("Chennai");
		flightTicketDao.save(searchResultDto);
		// 3rd record
		searchResultDto.setArrivalTime("7 AM");
		searchResultDto.setFlightNumber("TN 14 S210");
		searchResultDto.setDepartureTime("5 PM");
		searchResultDto.setDestinationCity("Tirunelveli");
		searchResultDto.setDuration("14 HRS");
		searchResultDto.setAirlaneName("Sanjay");
		searchResultDto.setPrice("900");
		searchResultDto.setSourceCity("Chennai");
		flightTicketDao.save(searchResultDto);
	}

	/**
	 * insertSampleDataForCoimbatore inserts Dump Data
	 * 
	 * @param insertList
	 */
	private void insertSampleDataForCoimbatore(List<SearchResultDto> insertList) {
		SearchResultDto searchResultDto = new SearchResultDto();
		// 1st record
		searchResultDto.setArrivalTime("4 PM");
		searchResultDto.setFlightNumber("TN 14 S208");
		searchResultDto.setDepartureTime("10 AM");
		searchResultDto.setDestinationCity("Coimbatore");
		searchResultDto.setDuration("6 HRS");
		searchResultDto.setAirlaneName("Madhan");
		searchResultDto.setPrice("800");
		searchResultDto.setSourceCity("Chennai");
		flightTicketDao.save(searchResultDto);
		// 2nd record
		searchResultDto.setArrivalTime("6 PM");
		searchResultDto.setFlightNumber("TN 14 S209");
		searchResultDto.setDepartureTime("12 AM");
		searchResultDto.setDestinationCity("Coimbatore");
		searchResultDto.setDuration("6 HRS");
		searchResultDto.setAirlaneName("Arun");
		searchResultDto.setPrice("900");
		searchResultDto.setSourceCity("Chennai");
		flightTicketDao.save(searchResultDto);
	}

}
