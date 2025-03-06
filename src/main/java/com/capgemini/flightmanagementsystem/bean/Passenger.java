package com.capgemini.flightmanagementsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passenger {
	
	@Id
	@Column(name="pnr_number")
	private int pnrnum;
	
	@Column(name="passenger_name")
	private String passengerName;
	
	@Column(name="passenger_age")
	private int passengerAge;
	
	@Column(name="passenger_uin")
	private int passengerUin;
	
	public int getPnrnum() {
		return pnrnum;
	}
	public void setPnrnum(int pnrnum) {
		this.pnrnum = pnrnum;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public int getPassengerUin() {
		return passengerUin;
	}
	public void setPassengerUin(int passengerUin) {
		this.passengerUin = passengerUin;
	}

}
