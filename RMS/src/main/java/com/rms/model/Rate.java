package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Rate{
	
	//need validation
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long rateId;
	private String rateDescription;
	private String rateEffectiveDate;
	private String rateExpirationDate;
	private int rate;
	
	@Transient
	private String surcharge;
	
	public String getSurcharge() {
		return surcharge;
	}
	public void setSurcharge(String surcharge) {
		this.surcharge = surcharge;
	}
	public long getRateId() {
		return rateId;
	}
	public void setRateId(long rateId) {
		this.rateId = rateId;
	}
	public String getRateDescription() {
		return rateDescription;
	}
	public void setRateDescription(String rateDescription) {
		this.rateDescription = rateDescription;
	}
	public String getRateEffectiveDate() {
		return rateEffectiveDate;
	}
	public void setRateEffectiveDate(String rateEffectiveDate) {
		this.rateEffectiveDate = rateEffectiveDate;
	}
	public String getRateExpirationDate() {
		return rateExpirationDate;
	}
	public void setRateExpirationDate(String rateExpirationDate) {
		this.rateExpirationDate = rateExpirationDate;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rate;
		result = prime * result + ((rateDescription == null) ? 0 : rateDescription.hashCode());
		result = prime * result + ((rateEffectiveDate == null) ? 0 : rateEffectiveDate.hashCode());
		result = prime * result + ((rateExpirationDate == null) ? 0 : rateExpirationDate.hashCode());
		result = prime * result + (int) (rateId ^ (rateId >>> 32));
		result = prime * result + ((surcharge == null) ? 0 : surcharge.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rate other = (Rate) obj;
		if (rate != other.rate)
			return false;
		if (rateDescription == null) {
			if (other.rateDescription != null)
				return false;
		} else if (!rateDescription.equals(other.rateDescription))
			return false;
		if (rateEffectiveDate == null) {
			if (other.rateEffectiveDate != null)
				return false;
		} else if (!rateEffectiveDate.equals(other.rateEffectiveDate))
			return false;
		if (rateExpirationDate == null) {
			if (other.rateExpirationDate != null)
				return false;
		} else if (!rateExpirationDate.equals(other.rateExpirationDate))
			return false;
		if (rateId != other.rateId)
			return false;
		if (surcharge == null) {
			if (other.surcharge != null)
				return false;
		} else if (!surcharge.equals(other.surcharge))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Rate [rateId=" + rateId + ", rateDescription=" + rateDescription + ", rateEffectiveDate="
				+ rateEffectiveDate + ", rateExpirationDate=" + rateExpirationDate + ", rate=" + rate + ", surcharge="
				+ surcharge + "]";
	}
}