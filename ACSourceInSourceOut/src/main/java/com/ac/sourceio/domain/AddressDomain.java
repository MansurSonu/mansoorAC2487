package com.ac.sourceio.domain;

public class AddressDomain {
	private Long addressId;
	private String doorNo;
	private String street;
	private String district;
	private String city ;
	private String State;
	private int zipCode;
	public AddressDomain() {
		
	}
	public AddressDomain(Long addressId, String doorNo, String street, String district, String city, String state,
			int zipCode) {
		super();
		this.addressId = addressId;
		this.doorNo = doorNo;
		this.street = street;
		this.district = district;
		this.city = city;
		State = state;
		this.zipCode = zipCode;
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
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "AddressDomain [addressId=" + addressId + ", doorNo=" + doorNo + ", street=" + street + ", district="
				+ district + ", city=" + city + ", State=" + State + ", zipCode=" + zipCode + "]";
	}
	

}
