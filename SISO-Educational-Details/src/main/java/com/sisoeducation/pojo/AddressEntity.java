package com.sisoeducation.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="address")

public class AddressEntity {

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long addressId;
		private String doorNo;
		private String street;
		private String district;
		private String city ;
		private String State;
		
		@Column(name="zip_code")
		private Integer zipCode;
		
		
		@JsonBackReference("employee-addressEntity")
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="employee_id")
		private EmployeeEntity employee;
		

		
		public AddressEntity() {
			
		}



		public AddressEntity(Long addressId, String doorNo, String street, String district, String city, String state,
				Integer zipCode, EmployeeEntity employee) {
			super();
			this.addressId = addressId;
			this.doorNo = doorNo;
			this.street = street;
			this.district = district;
			this.city = city;
			State = state;
			this.zipCode = zipCode;
			this.employee = employee;
		}



		public Long getAddressId() {
			return addressId;
		}



		public void setAddressId(Long addressId) {
			this.addressId = addressId;
		}



		public String getDoorNo() {
			return doorNo;
		}



		public void setDoorNo(String doorNo) {
			this.doorNo = doorNo;
		}



		public String getStreet() {
			return street;
		}



		public void setStreet(String street) {
			this.street = street;
		}



		public String getDistrict() {
			return district;
		}



		public void setDistrict(String district) {
			this.district = district;
		}



		public String getCity() {
			return city;
		}



		public void setCity(String city) {
			this.city = city;
		}



		public String getState() {
			return State;
		}



		public void setState(String state) {
			State = state;
		}



		public Integer getZipCode() {
			return zipCode;
		}



		public void setZipCode(Integer zipCode) {
			this.zipCode = zipCode;
		}



		public EmployeeEntity getEmployee() {
			return employee;
		}



		public void setEmployee(EmployeeEntity employee) {
			this.employee = employee;
		}
		

	}

