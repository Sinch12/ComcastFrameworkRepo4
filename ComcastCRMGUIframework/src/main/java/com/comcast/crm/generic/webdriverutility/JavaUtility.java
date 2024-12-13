package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random r = new Random();
		int res = r.nextInt(5000);
		return res;
	}
	public String getSystemDateYYYYDDMM() {
		Date d = new Date();
		System.out.println(d.toString());
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String actdate = sim.format(d);
		return actdate;
	}
	public String getReqDateYYYYDDMM(int days) {
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		sim.format(d);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqdate = sim.format(cal.getTime());
		return reqdate;
	}

}
