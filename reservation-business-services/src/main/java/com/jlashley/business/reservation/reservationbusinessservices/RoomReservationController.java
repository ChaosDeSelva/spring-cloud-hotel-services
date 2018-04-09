package com.jlashley.business.reservation.reservationbusinessservices;

import com.jlashley.business.reservation.reservationbusinessservices.client.RoomService;
import com.jlashley.business.reservation.reservationbusinessservices.domain.Room;
import com.jlashley.business.reservation.reservationbusinessservices.domain.RoomReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Api(value="RoomReservations", description = "Business process service operations on rooms and reservations", tags=("roomReservations"))
public class RoomReservationController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomReservationBusinessProcess businessProcess;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    @ApiOperation(value = "Get All Rooms", notes = "Gets all rooms in the system", nickname = "getRooms")
    public List<Room> getAllRooms() {
//        ResponseEntity<List<Room>> roomResponse = this.restTemplate.exchange(
//                "http://ROOMSERVICES/rooms", HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<Room>>() {
//                });
//
//        return roomResponse.getBody();

        return this.roomService.findAll(null);
    }

    @RequestMapping(value = "/roomReservations/{date}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Room Reservations", notes = "Gets all reservations for a specific date", nickname = "getReservationsForDate")
    public List<RoomReservation> getRoomReservationsForDate(@PathVariable("date") String date) {
        return this.businessProcess.getRoomReservationsForDate(date);
    }

}
