package hello.webpservice.client;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.webpservice.client.response.Country;
import hello.wsdl.GetCountryResponse;

@RestController
public class CountryClientInvokeService {

	@Autowired
	private CountryClient countryClient;

	@GetMapping("/countryInvoke")
	public Country getCountry(@RequestParam("country") String country) {
		GetCountryResponse countryResponse = countryClient.getCountry(country);

		Country retVal = new Country();
		BeanUtils.copyProperties(countryResponse.getCountry(), retVal);
		return retVal;

	}

}
