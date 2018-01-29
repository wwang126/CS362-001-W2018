package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;


import org.junit.Test;

import javax.swing.text.html.HTMLDocument;

import static org.junit.Assert.*;

public class CalDayTest {

	@Test
	public void testConstructor()  throws Throwable  {
		 Calendar curr = Calendar.getInstance();
		 GregorianCalendar cal = new GregorianCalendar();
		 CalDay calday = new CalDay(cal);
		 assertEquals(true, calday.isValid());
		 assertEquals(curr.get(Calendar.DAY_OF_MONTH), calday.getDay());
		 assertEquals(curr.get(Calendar.MONTH), calday.getMonth());
		 assertEquals(curr.get(Calendar.YEAR), calday.getYear());
		 String output = "\t --- "+calday.getMonth() +
				 "/"+ calday.getDay() +
				 "/"+ calday.getYear()+ " --- \n" +
				 " --- -------- Appointments ------------ --- \n\n";
		 assertEquals(output, calday.toString());
	}
	@Test
		public void testDefaultConstructor()  throws Throwable  {
		CalDay calday = new CalDay();
		assertFalse(calday.isValid());

	}
	@Test
	public void testAppts()  throws Throwable  {
		//Generate Day
		Calendar curr = Calendar.getInstance();
		GregorianCalendar cal = new GregorianCalendar(2018,2,2);
		CalDay calday = new CalDay(cal);
		assertEquals(true, calday.isValid());
		//Generate Appointments
		int startHour=0;
		int startMinute=30;
		int startDay= 2;
		int startMonth= 3;
		int startYear=2018;
		String title="Appointment 1";
		String description="Test Text 1";
		//Construct a new Appointment object with the initial data
		Appt appt1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		startHour = 4;
		title = "Appointment 2";
		description = "Test Text 2";
		Appt appt2 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		startHour = 1;
		title = "Appointment 3";
		description = "Test Text 3";
		Appt appt3 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		calday.addAppt(appt1);
		calday.addAppt(appt2);
		calday.addAppt(appt3);
		String output = "\t --- 2/2/2018 --- \n" +
				" --- -------- Appointments ------------ --- \n" +
				"\t3/2/2018 at 12:30am ,Appointment 1, Test Text 1\n" +
				" \t3/2/2018 at 1:30am ,Appointment 3, Test Text 3\n" +
				" \t3/2/2018 at 4:30am ,Appointment 2, Test Text 2\n \n";
		assertEquals(output,calday.toString());
		assertEquals(3,calday.getSizeAppts());
	}
	@Test
	public void testIterator()  throws Throwable  {
		CalDay test = new CalDay();
		assertEquals(null, test.iterator());
	}
//add more unit tests as you needed	
}
