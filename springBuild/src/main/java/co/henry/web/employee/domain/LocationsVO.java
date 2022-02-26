package co.henry.web.employee.domain;

import lombok.Data;

@Data
public class LocationsVO {
	private long locationId;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	private String countryId;
}
