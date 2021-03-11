package com.evoke.evoke.entitys;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_driver")
public class Driver {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driver_generator")
	@SequenceGenerator(name="driver_generator", sequenceName = "driver_seq", allocationSize=500)

	@Column(name = "driver_id")
	private long driverId;
	
	private String driverName;
	private String vehicleNumber;
	private String vehicleType;
	private String accountNumber;
	private String vehicleRc;
	private String vehicleName;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "driver")
    private Set<Organization> organization = new HashSet<>();

    public Driver() {

    }
	
	
	public long getDriverId() {
		return driverId;
	}
	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getVehicleRc() {
		return vehicleRc;
	}
	public void setVehicleRc(String vehicleRc) {
		this.vehicleRc = vehicleRc;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}


	public Set<Organization> getOrganization() {
		return organization;
	}


	public void setOrganization(Set<Organization> organization) {
		this.organization = organization;
	}
	
	
}
