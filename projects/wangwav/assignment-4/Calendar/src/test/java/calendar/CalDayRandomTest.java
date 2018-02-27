package calendar;



import org.junit.Test;


import java.util.*;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 100 * 1; /* Timeout at 30 seconds */ //changed 500 to 100
	
	/**
	* Generate Random Tests that tests CalDay Class.
	*/
	@Test
	public void randomTestAddAppt()  throws Throwable {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing isValid()...");
		long randomseed = System.currentTimeMillis(); //10
		Random random = new Random(randomseed);

		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			//Generate random calday
			int startDay = ValuesGenerator.getRandomIntBetween(random, 0, 26);
			int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			int startYear = ValuesGenerator.getRandomIntBetween(random, 1980, 2030);
			GregorianCalendar cal = new GregorianCalendar(startYear,startMonth,startDay);
			CalDay calday = new CalDay(cal);
			String day = "\t --- "+calday.getMonth() +
					"/"+ calday.getDay() +
					"/"+ calday.getYear()+ " --- \n" +
					" --- -------- Appointments ------------ --- \n";
			StringBuilder expected = new StringBuilder(day);

			int appts = ValuesGenerator.getRandomIntBetween(random,1,15);
			List<Integer> apptHours = new ArrayList<Integer>();
			for(int i = 0; i < appts; i++){
				apptHours.add(ValuesGenerator.getRandomIntBetween(random,0,23));
			}
			Collections.sort(apptHours);
			for(int j = 0; j < appts; j++){
				int startHour = apptHours.get(j);
				int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
				String title = ValuesGenerator.getString(random);
				String description = ValuesGenerator.getString(random);
				//Construct a new Appointment object with the initial data
				Appt appt = new Appt(startHour,
						startMinute,
						startDay,
						startMonth,
						startYear,
						title,
						description);
				calday.addAppt(appt);
				if(appt.toString() != null){
					expected.append(appt.toString() + " ");
				}

			}
			expected.append("\n");
			String result = expected.toString();
			String output = calday.toString();
			assertEquals(result,output);
			//Time counter
			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			if ((iteration % 10000) == 0 && iteration != 0)
			 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
		 }
	}
	/**
	 * Generate Random Tests that tests CalDay Class.
	 */
	@Test
	public void randomTestAddApptBadOrder()  throws Throwable {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing isValid()...");
		long randomseed = System.currentTimeMillis(); //10
		Random random = new Random(randomseed);

		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			//Generate random calday
			int startDay = ValuesGenerator.getRandomIntBetween(random, 0, 26);
			int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
			int startYear = ValuesGenerator.getRandomIntBetween(random, 1980, 2030);
			GregorianCalendar cal = new GregorianCalendar(startYear,startMonth,startDay);
			CalDay calday = new CalDay(cal);
			String day = "\t --- "+calday.getMonth() +
					"/"+ calday.getDay() +
					"/"+ calday.getYear()+ " --- \n" +
					" --- -------- Appointments ------------ --- \n";
			StringBuilder expected = new StringBuilder(day);

			int appts = ValuesGenerator.getRandomIntBetween(random,1,15);
			List<Integer> apptHours = new ArrayList<Integer>();
			for(int i = 0; i < appts; i++){
				int startHour = ValuesGenerator.getRandomIntBetween(random,0,23);
				apptHours.add(startHour);
				int startMinute = 8;
				String title = "Test Text";
				String description = "Test Text";
				//Construct a new Appointment object with the initial data
				Appt appt = new Appt(startHour,
						startMinute,
						startDay,
						startMonth,
						startYear,
						title,
						description);
				calday.addAppt(appt);
			}
			Collections.sort(apptHours);
			for(int j = 0; j < appts; j++){
				int startHour = apptHours.get(j);
				int startMinute = 8;
				String title = "Test Text";
				String description = "Test Text";
				//Construct a new Appointment object with the initial data
				Appt appt = new Appt(startHour,
						startMinute,
						startDay,
						startMonth,
						startYear,
						title,
						description);
				if(appt.toString() != null){
					expected.append(appt.toString() + " ");
				}

			}
			expected.append("\n");
			String result = expected.toString();
			String output = calday.toString();
			assertEquals(result,output);
			//Time counter
			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			if ((iteration % 10000) == 0 && iteration != 0)
				System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
		}
	}
}
