package com.wl.speakingclock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.wl.speakingclock.controller.SpeakingClockController;
import com.wl.speakingclock.service.SpeakingClockService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {SpeakingClockController.class, SpeakingClockService.class})
@WebMvcTest
public class SpeakingClockApplicationTimeTests  extends SpeakingclockApplicationTests{
	
	@Autowired
    private MockMvc mockMvc;
	
	private String time;

    @Test
    public void testGetBirthdayDOW() throws Exception {
    	testTime(time, "08:34");
    	testTime(time, "12:00");
    	testTime(time, "00:00");
    	testTime(time, "18:00");
    }
    
    private void testTime(String time, String value) throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/speakingclock/gettime")
                .content(time)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String resultValue = result.getResponse().getContentAsString();
        assertNotNull(resultValue);
        assertEquals(value, resultValue);
    }
	

}
