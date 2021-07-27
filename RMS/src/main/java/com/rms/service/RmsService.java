package com.rms.service;

import java.util.Optional;

import com.rms.exceptions.BusinessException;
import com.rms.model.Rate;

public interface RmsService {

	public Rate saveRate(Rate rate);
	
	public Optional<Rate> getRate(long rateId);

	public void updateRate(Rate rate) throws BusinessException ;

	public void deleteRate(long rateId);
}
