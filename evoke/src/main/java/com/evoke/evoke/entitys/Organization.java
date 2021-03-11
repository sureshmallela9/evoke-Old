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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_organization")
public class Organization {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_generator")
	@SequenceGenerator(name="org_generator", sequenceName = "org_seq", allocationSize=500)
	@Column(name = "org_id")
	private long orgId;
	
	private String orgname;

	private String address;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "org_driver", joinColumns = { @JoinColumn(name = "org_id") }, inverseJoinColumns = {
			@JoinColumn(name = "driver_id") })
	private Set<Driver> driver = new HashSet<>();

	public Organization() {

	}
	
	
	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Set<Driver> getDriver() {
		return driver;
	}


	public void setDriver(Set<Driver> driver) {
		this.driver = driver;
	}

	
}
