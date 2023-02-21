package com.wl.speakingclock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wl.speakingclock.service.SpeakingClockService;

@RestController
@RequestMapping("speakingclock/")
public class SpeakingClockController {
	
	@Autowired
	private SpeakingClockService speakingClockService;
	
	
	
	@GetMapping("gettime")
	public String getCurrentTime() {
		return speakingClockService.getCurrentTime();
		
	}

}
