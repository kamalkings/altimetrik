package com.application.flightticket.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.application.flightticket.entity.SearchPojo;
import com.application.flightticket.entity.SearchResultDto;
import com.application.flightticket.service.FlightTicketService;

@Controller
public class HomeController {
	
	private static final int ONE = 1;
	private static final String LINE_BREAK = "\n";
	private static final String PROVIDES = "==>";
	private static final String AIRPLANE_NO = "AirPlan No : ";
	private static final String EMPTY_MESSAGE = "There are no Planes available";
	private static final String PLANES_AVAILABLE = " Planes available";
	private static final String PLANE_AVAILABLE = " Plane available";
	private static final String THERE_ARE = "There are ";
	private static final String THERE_IS_ONLY = "There is only ";
	private static final String DRIVER_NAME = "Driver Name : ";
	private static final String DEPARTURE_TIME = "Departure Time : ";
	private static final String ARRIVAL_TIME = "Arrival Time : ";
	private static final String TRAVEL_DURATION = "Travel Duration : ";
	private static final String TICKET_PRICE = "Ticket Price : ";
	private static final String INR = " INR";

	
	@Autowired 
	FlightTicketService flightTicketService;
	
	@RequestMapping("/home")
	public String start() {
		return "index.jsp";
	};
	
	/**
	 * submit method retrieves necessary data and decorates Detail Page
	 * 
	 * @param searchPojo
	 * @return ModelAndView
	 */
	@RequestMapping("/book")
	public ModelAndView submit(SearchPojo searchPojo) {
		List<SearchResultDto> resultList = flightTicketService.fetchDetails(searchPojo);
		ModelAndView view = new ModelAndView();
		StringBuilder detailString = new StringBuilder();
		int totalBusCount = resultList.size();
		if (totalBusCount == 0) {
			detailString.append(EMPTY_MESSAGE);
			detailString.append(LINE_BREAK);
		} else if (totalBusCount > ONE) {
			detailString.append(THERE_ARE).append(totalBusCount).append(PLANES_AVAILABLE);
			detailString.append(LINE_BREAK);
			detailString.append(LINE_BREAK);
		} else if (totalBusCount == ONE) {
			detailString.append(THERE_IS_ONLY).append(totalBusCount).append(PLANE_AVAILABLE);
			detailString.append(LINE_BREAK);
			detailString.append(LINE_BREAK);
		}
		AtomicInteger busNumeral = new AtomicInteger(1);
		resultList.stream().forEach(bus -> {
			detailString.append(busNumeral.getAndIncrement()).append(PROVIDES);
			detailString.append(LINE_BREAK);
			detailString.append(LINE_BREAK);
			detailString.append(AIRPLANE_NO).append(bus.getFlightNumber());
			detailString.append(LINE_BREAK);
			detailString.append(DRIVER_NAME).append(bus.getAirlaneName());
			detailString.append(LINE_BREAK);
			detailString.append(DEPARTURE_TIME).append(bus.getDepartureTime());
			detailString.append(LINE_BREAK);
			detailString.append(ARRIVAL_TIME).append(bus.getArrivalTime());
			detailString.append(LINE_BREAK);
			detailString.append(TRAVEL_DURATION).append(bus.getDuration());
			detailString.append(LINE_BREAK);
			detailString.append(TICKET_PRICE).append(bus.getPrice()).append(INR);
			detailString.append(LINE_BREAK);
			detailString.append(LINE_BREAK);
		});
		view.addObject("details", detailString);
		view.setViewName("detailPage.jsp");
		return view;
	};

}
