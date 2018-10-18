package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/app")
public class MainController {

	@Autowired
	HotelRepository HotelRepository;

	@RequestMapping("/")
	public String welcome() {//Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping(value = "/hotels", method = RequestMethod.GET)
	public Iterable<Hotel> getAllNotes() {
		return HotelRepository.findAll();
	}

	@RequestMapping(value ="/hotels/{Id}", method = RequestMethod.GET)
	public Hotel getHotelById(@PathParam(value = "id") Integer cityId) {
		return HotelRepository.findById(cityId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", cityId));
	}


}
