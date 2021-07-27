package com.rms.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rms.exceptions.BusinessException;
import com.rms.exceptions.DataNotFoundException;
import com.rms.model.Rate;
import com.rms.repository.RmsRepository;

@Service
public class RmsServiceImpl implements RmsService{

	private static final String URI="https://surcharge.free.beeceptor.com/surcharge";
	@Autowired
	private RmsRepository rmsRepository;
	
	@Override
	public Rate saveRate(Rate rate) {
		return rmsRepository.save(rate);
	}

	@Override
	public Optional<Rate> getRate(long rateId) {
		
		RestTemplate restTemplate=new RestTemplate();
		
		Map<String, Long> params = new HashMap<>();
		params.put("rateId", rateId);
		 
		//Parse the string after getting the response
		String surcharge = restTemplate.getForObject(URI, String.class, params);
		
		System.out.println("charge ::"+surcharge);
		
		Rate rate=rmsRepository.getById(rateId);
				
		Optional<Rate> opt = Optional.ofNullable(rate);
		
		if(opt.isPresent())
		{
			rate=opt.get();
			rate.setSurcharge(surcharge);
		}
		
	    return opt;
		
	}

	@Override
	public void updateRate(Rate rate) throws BusinessException {
		Optional<Rate> rateObj = rmsRepository.findById(rate.getRateId());
		if(rateObj.isPresent()) 
			rmsRepository.save(rateObj.get());
		else
			throw new BusinessException("Internal Server Error. Please contact admin");
	}

	@Override
	public void deleteRate(long rateId) {
		rmsRepository.deleteById(rateId);
	}
}
