package chapter04;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
//		Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
//		TimeZone tz = TimeZone.getDefault();
//		System.out.println(aLocale + " " + tz);

		// 팩토리 메서드, new X
		// 기본 그레고리 달력
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		printDate(cal);

		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DATE, 25);
		printDate(cal);

		cal.set(1999, 10, 18);
		cal.add(Calendar.DATE, 12345);
		printDate(cal);

	}

	private static void printDate(Calendar cal) {

		final String[] DAYS = { "일", "월", "화", "수", "목", "금", "토" };

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; // 0 ~ 11
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1 ~ 7 (SUN, ... , SAT)

		int hours = cal.get(Calendar.HOUR);
		int minutes = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);

		System.out.println(
				year + "-" + month + "-" + date + " " + DAYS[day - 1] + "요일 " + hours + ":" + minutes + ":" + seconds);
	}

}
