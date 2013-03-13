package org.giavacms.timer.util;

import java.util.Date;

import javax.ejb.ScheduleExpression;

public class TimerUtils {
	public static ScheduleExpression fromDate(Date date) {
		ScheduleExpression calendarSchedule = new ScheduleExpression();
		calendarSchedule.dayOfMonth(date.getDay()).month(date.getMonth())
				.year(date.getYear()).hour(date.getHours())
				.minute(date.getMinutes()).second(date.getSeconds());
		return calendarSchedule;

	}
}
