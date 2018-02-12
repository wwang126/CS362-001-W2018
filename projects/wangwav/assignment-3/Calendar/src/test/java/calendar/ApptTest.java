package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void testConstructor()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
							startMinute ,
							startDay ,
							startMonth ,
							startYear ,
							title,
							description);
		 //assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
	 }

	 @Test
	  public void testHour()  throws Throwable  {
	 	int startHour=0;
	 	int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
			 startMinute ,
			 startDay ,
			 startMonth ,
			 startYear ,
			 title,
			 description);
		//Check initial validity
		assertTrue(appt.getValid());
		//Check hour validity for smaller than zero

		appt.setStartHour(-1);
		assertFalse(appt.getValid());
		assertEquals(-1, appt.getStartHour());

		//Reset hour
		appt.setStartHour(23);
		assertTrue(appt.getValid());
		assertEquals(23, appt.getStartHour());

		//Check hour validity for larger than 23

		appt.setStartHour(24);
		assertFalse(appt.getValid());
		assertEquals(24, appt.getStartHour());
	 }
	@Test
	public void testMinute()  throws Throwable  {
		int startHour=0;
		int startMinute=0;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		//Check initial validity
		assertTrue(appt.getValid());
		//Check hour validity for smaller than zero

		appt.setStartMinute(-1);
		assertFalse(appt.getValid());
		assertEquals(-1, appt.getStartMinute());

		//Reset hour
		appt.setStartMinute(59);
		assertTrue(appt.getValid());
		assertEquals(59, appt.getStartMinute());

		//Check hour validity for larger than 23

		appt.setStartMinute(60);
		assertFalse(appt.getValid());
		assertEquals(60, appt.getStartMinute());
	}
	@Test
	public void testDay()  throws Throwable  {
		int startHour=0;
		int startMinute=30;
		int startDay=1;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		//Check initial validity
		assertTrue(appt.getValid());
		//Check hour validity for smaller than zero

		appt.setStartDay(-1);
		assertFalse(appt.getValid());
		assertEquals(-1, appt.getStartDay());

		//Reset Day
		appt.setStartDay(31);
		assertTrue(appt.getValid());
		assertEquals(31, appt.getStartDay());

		//Check hour validity for larger than days in jan

		appt.setStartDay(32);
		assertFalse(appt.getValid());
		assertEquals(32, appt.getStartDay());
	}
	@Test
	public void testMonth()  throws Throwable  {
		int startHour=0;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		//Check initial validity
		assertTrue(appt.getValid());
		//Check month day setting

		//Make sure that the days are being set properly
		appt.setStartMonth(2);
		appt.setStartDay(30);
		assertFalse(appt.getValid());
		assertEquals(2, appt.getStartMonth());
		assertEquals(30, appt.getStartDay());

		//Reset Month
		appt.setStartMonth(11);
		appt.setStartDay(30);
		assertTrue(appt.getValid());
		assertEquals(11, appt.getStartMonth());
		assertEquals(30, appt.getStartDay());
	}

	@Test
	public void testYear()  throws Throwable  {
		int startHour=0;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		//Check initial validity
		assertTrue(appt.getValid());
		//Check setting year
		appt.setStartYear(2019);
		assertEquals(2019, appt.getStartYear());
	}

	@Test
	public void testTitleDesc()  throws Throwable  {
		int startHour=0;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		//Check initial validity
		assertTrue(title.equals(appt.getTitle()));
		assertEquals("Birthday Party",appt.getTitle());
		assertTrue(description.equals(appt.getDescription()));
		assertEquals("This is my birthday party.",appt.getDescription());



		//Reset title and description
		appt.setTitle("Potluck");
		appt.setDescription("John's potluck, bring food.");
		assertTrue(appt.getValid());
		assertEquals("Potluck", appt.getTitle());
		assertEquals("John's potluck, bring food.", appt.getDescription());

		//Set title Null
		appt.setTitle(null);
		appt.setDescription(null);
		assertEquals("",appt.getTitle());
		assertEquals("",appt.getDescription());

	}
	@Test
	public void testRecur()  throws Throwable  {
		int startHour=0;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		//Check initial validity
		assertFalse(appt.isRecurring());

		int[] days = {1,2};

		//Set recurrence
		appt.setRecurrence(days, 3, 4, 5);
		//Check recurrence
		assertTrue(appt.isRecurring());
		assertEquals(days, appt.getRecurDays());
		assertEquals(3, appt.getRecurBy());
		assertEquals(4, appt.getRecurIncrement());
		assertEquals(5, appt.getRecurNumber());

		//Check recurrence null
		appt.setRecurrence(null, 3, 4, 5);
		//Check recurrence
		assertTrue(appt.isRecurring());
		int[] empty = new int[0];
		assertEquals(0,appt.getRecurDays().length);
		assertEquals(3, appt.getRecurBy());
		assertEquals(4, appt.getRecurIncrement());
		assertEquals(5, appt.getRecurNumber());
	}
	@Test
	public void testToString()  throws Throwable  {
		int startHour=0;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		//Check initial validity
		String output = "\t1/15/2018 at 12:30am ,Birthday Party, This is my birthday party.\n";
		assertEquals(output, appt.toString());
		appt.setStartHour(24);
		assertEquals(null,appt.toString());
		appt.setStartHour(12);
		output = "\t1/15/2018 at 12:30pm ,Birthday Party, This is my birthday party.\n";
		assertEquals(output,appt.toString());
	}
	@Test
	public void testComparator()  throws Throwable  {
		int startHour=0;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		Appt appt2 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		startYear = 2019;
		Appt appt3 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		//Test Comparator
		assertEquals(0,appt1.compareTo(appt2));
		assertEquals(-1,appt2.compareTo(appt3));
	 }

	
}
