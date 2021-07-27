package com.rms.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rms.model.Rate;

@ExtendWith(MockitoExtension.class)
class RmsControllerTest {

	@InjectMocks
	RmsController rmsController;
	
	@Autowired
	MockMvc mockMvc;
	
    @BeforeEach 
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(rmsController).build();

    }
    
	@Test
	public void testGetRate() throws Exception {
		
		 mockMvc.perform(get("/api/rate/12"))
		 .andExpect(status().isOk())
		 .andExpect(jsonPath("$.rate").value(21000))
		 .andExpect(jsonPath("$.rateExpirationDate").value("23-Sep-2021"))
		 .andExpect(jsonPath("$.rateEffectiveDate").value("22-Jul-2021"))
		 .andExpect(jsonPath("$.rateDescription").value("rate of product"))
		 .andExpect(jsonPath("$.surcharge").value("abc"));
		
	}
	
	 	@Test
	    public void testPostRate() throws Exception {
	    
	    	Rate rate=new Rate();
	    	rate.setRate(4500);
	    	rate.setRateDescription("Rate of product");
	    	rate.setRateEffectiveDate("12-Jun-2021");
	    	rate.setRateExpirationDate("25-Aug-2021");
	    	rate.setRateId(123);
	    	
	    	JSONObject j=new JSONObject();
	    	j.put("rate", rate);
	    	
	    	this.mockMvc.perform(post("/api/rate")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(j.toString()))
	                .andExpect(status().isCreated());
	    }
	 
	 	@Test
		public void testDeleteRate() throws Exception {
			
			 mockMvc.perform(delete("/api/rate/12"))
			 .andExpect(status().isOk());	
		}

	 	@Test
	    public void testUpdateRate() throws Exception {
	    
	    	Rate rate=new Rate();
	    	rate.setRate(5400);
	    	rate.setRateDescription("Rate of product XYZ");
	    	rate.setRateEffectiveDate("12-Jun-2021");
	    	rate.setRateExpirationDate("25-Aug-2021");
	    	rate.setRateId(123);
	    	
	    	JSONObject j=new JSONObject();
	    	j.put("rate", rate);
	    	
	    	this.mockMvc.perform(put("/api/rate")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(j.toString()))
	                .andExpect(status().isCreated());
	    }
	 
}
