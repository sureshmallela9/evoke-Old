package com.evoke.evoke.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evoke.evoke.entitys.Driver;
import com.evoke.evoke.entitys.Organization;
import com.evoke.evoke.repository.DriverRepository;
import com.evoke.evoke.repository.OrganizationRepository;

@RestController
@RequestMapping("cab")
public class CabController {
	
	private static final Logger logger = LoggerFactory.getLogger(CabController.class);

	
	@Autowired
	private OrganizationRepository orgrepo;//organizationRepository
	
	@Autowired
	private DriverRepository driverrepo;//driverRepository
	
	@GetMapping("/status")
	public String getApplicationStatus() {
		return "Application is running";
	}
	
	@PostMapping("/saveOrg")
	public String saveOrg(
			@RequestParam(required = false) String address,
			@RequestParam(required = false) String orgName,
			@RequestParam(required = false) String accountNumber,
			@RequestParam(required = false) String vehicleNumber,
			@RequestParam(required = false) String vehicleName,
			@RequestParam(required = false) String vehicleType,
			@RequestParam(required = false) String DriverName
			) {//Need to object instead of request parametere.
		logger.info("request Reached Server side  :: Request Parms-> Address "+address +"Org Name"+ orgName +"Account Number : "+ accountNumber +"Vehicle Number : "+vehicleNumber+
				"VechileType : "+ vehicleType+" Date :: "+new Date());
		Organization org=new Organization();
		Driver driver=new Driver();
		org.setAddress(address);
		org.setOrgname(orgName);
		driver.setAccountNumber(accountNumber);
		driver.setDriverName(DriverName);
		driver.setVehicleName(vehicleName);
		driver.setVehicleNumber(vehicleNumber);
		driver.setVehicleType(vehicleType);
		Set<Driver> drset = new HashSet<Driver>();
		drset.add(driver);
		org.setDriver(drset);
		orgrepo.save(org);//-> Services -> Service repository
		//Instead of passing object directtly , object constructions needs to be done at service layer
		return "Org Saved successfully";//send record id back
	}
}