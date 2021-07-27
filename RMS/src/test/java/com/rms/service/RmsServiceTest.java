package com.rms.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rms.model.Rate;
import com.rms.repository.RmsRepository;

public class RmsServiceTest {

	@InjectMocks
	RmsService rmsService;
     
    @Mock
    RmsRepository repo;
 
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    public void createRateTest()
    {
    	Rate rate=new Rate();
    	rate.setRate(4500);
    	rate.setRateDescription("Rate of product");
    	rate.setRateEffectiveDate("12-Jun-2021");
    	rate.setRateExpirationDate("25-Aug-2021");
    	rate.setRateId(123); 
        rmsService.saveRate(rate);
         
        verify(repo, times(1)).save(rate);
    }
    
    @Test
    public void getRateByIdTest()
    {
    	Rate rate=new Rate();
    	rate.setRate(4500);
    	rate.setRateDescription("Rate of product");
    	rate.setRateEffectiveDate("12-Jun-2021");
    	rate.setRateExpirationDate("25-Aug-2021");
    	rate.setRateId(1); 
        when(repo.getById(1L)).thenReturn(rate);
         
        Optional<Rate> ra = rmsService.getRate(1L);
        
        assertEquals(4500, ra.get().getRate());
        assertEquals("12-Jun-2021", ra.get().getRateEffectiveDate());
        assertEquals("25-Aug-2021", ra.get().getRateExpirationDate());
    }
     
}
