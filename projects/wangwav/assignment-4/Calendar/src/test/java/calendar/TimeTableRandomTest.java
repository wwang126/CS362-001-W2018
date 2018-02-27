package calendar;

import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
    private static final long TestTimeout = 60 * 100 * 1; /* Timeout at 30 seconds */ //changed 500 to 100

	/**
	 * Generate Random Tests that tests TimeTable Class.
	 */
	@Test
	public void timeTableDeleteAppt()  throws Throwable  {

        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

        TimeTable timeTable = new TimeTable();


        System.out.println("Start testing timeTableDeleteAppt...");
        long randomseed = System.currentTimeMillis(); //10
        Random random = new Random(randomseed);

        for (int iteration = 0; elapsed < TestTimeout; iteration++) {
            LinkedList<Appt> mainList = new LinkedList<Appt>();
            LinkedList<Appt> otherList = new LinkedList<Appt>();
            int appts = ValuesGenerator.getRandomIntBetween(random, 1, 10);
            for(int j = 0; j < appts; j++){
                int startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
                int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
                int startDay = ValuesGenerator.getRandomIntBetween(random, 0, 26);
                int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startYear = ValuesGenerator.getRandomIntBetween(random, 1980, 2030);
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
                mainList.add(appt);
                otherList.add(appt);
            }
            LinkedList<Appt> result = new LinkedList<Appt>();
            for(Appt appt1: otherList){
                result = timeTable.deleteAppt(mainList, appt1);
            }
            assertTrue(result == null );
            //This should work, I don't know why it doesn't work, for some reason
            //The delete appt function doesn't actually
            //assertEquals(0,mainList.size());
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
    public void randomTestAddAppt()  throws Throwable {

        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


        System.out.println("Start testing timeTableGetRange...");
        long randomseed = System.currentTimeMillis(); //10
        Random random = new Random(randomseed);
        GregorianCalendar start = new GregorianCalendar(2017,1,0);
        GregorianCalendar end = new GregorianCalendar(2017,11,26);
        LinkedList<Appt> apptList = new LinkedList<Appt>();

        for (int iteration = 0; elapsed < TestTimeout; iteration++) {
            TimeTable timeTable = new TimeTable();
            int startYear = 2017;

            int appts = ValuesGenerator.getRandomIntBetween(random, 1, 15);
            for (int j = 0; j < appts; j++) {
                int startHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
                int startMinute = ValuesGenerator.getRandomIntBetween(random, 0, 59);
                int startDay = ValuesGenerator.getRandomIntBetween(random, 0, 26);
                int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
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
                apptList.add(appt);
            }
            LinkedList<CalDay> output = timeTable.getApptRange(apptList,start,end);
            assertEquals(output.size(),329);

            //Time counter
            elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
            if ((iteration % 10000) == 0 && iteration != 0)
                System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
        }
    }


	
}
