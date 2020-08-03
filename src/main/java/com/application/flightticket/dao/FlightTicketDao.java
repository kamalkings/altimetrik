package com.application.flightticket.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.application.flightticket.entity.SearchResultDto;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
@Component
public interface FlightTicketDao extends CrudRepository<SearchResultDto, String> {

	List<SearchResultDto> findByDestinationCity(String destinationCity);

}
