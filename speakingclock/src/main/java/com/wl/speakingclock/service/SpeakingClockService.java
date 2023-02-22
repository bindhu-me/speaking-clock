package com.wl.speakingclock.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;


@Service
public class SpeakingClockService {
	
	private String ones[] = {"one ","two ","three ","four ","five ","six ","seven ","eight ","nine "};
	
	private String teens[] = {"ten "," eleven "," twelwe "," thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	
	private String tens[] = {"", "ten","twenty", "thirty","fourty","fifty","sixty"};

	public String getCurrentTime(String time){
		if(time == null || time.isEmpty()) {
			return "Please enter Time";
		}
		String[] timeArr = time.split(":");
		StringBuffer timeInWords = new StringBuffer();
		//Calendar calendar = Calendar.getInstance();
		/*
		 * int hour = calendar.get(Calendar.HOUR_OF_DAY); int minute =
		 * calendar.get(Calendar.MINUTE);
		 */
		
		int hour = Integer.parseInt(timeArr[0]);
		int minute = Integer.parseInt(timeArr[1]);
		timeInWords.append("It's ").append(getHoursInWords(hour)).append(getMinutesInWords(minute));
		return timeInWords.toString();
	}
	
	private String getHoursInWords(int hour) {
		String hoursInWords = "";
		if(hour == 12) {
			hoursInWords = "Midday";
		} else if(hour == 24 || hour == 0) {
			hoursInWords = "Midnight";
		}
		else {
			if(hour < 10) {
				hoursInWords = ones[hour]+" ";
			} else if(hour < 20) {
				hoursInWords = teens[hour%10]+ " ";
			} else {
				hoursInWords = tens[(int) Math.floor(hour/10)] +" "+ ones[hour%10];
			}
		}
		return hoursInWords;
		
	}
	
	private String getMinutesInWords(int minute) {
		String minutesInWords = "";
		if(minute == 0) {
			minutesInWords = "";
		} else if(minute<10) {
			minutesInWords = ones[minute];
		} else if(minute < 20) {
			minutesInWords = teens[minute%10];
		} else {
			minutesInWords = tens[(int) Math.floor(minute/10)] +" "+ ones[(minute%10)];
		}
		return minutesInWords;
	}

}
