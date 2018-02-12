package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

    @Test
    public void testApptRange()  throws Throwable  {

        TimeTable timetable = new TimeTable();
        LinkedList<Appt> apptList = new LinkedList<Appt>();

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
        startMonth = 3;
        title = "Appointment 3";
        description = "Test Text 3";
        Appt appt3 = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);
        startHour = 1;
        startMonth = 7;
        title = "Appointment 4";
        description = "Test Text 4";
        Appt appt4 = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);
        apptList.add(appt1);
        apptList.add(appt2);
        apptList.add(appt3);
        apptList.add(appt4);

        Calendar rightnow = Calendar.getInstance();

        int thisMonth = rightnow.get(Calendar.MONTH);
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

        GregorianCalendar startCal = new GregorianCalendar(2018,3,2);
        GregorianCalendar endCal = new GregorianCalendar(2018,3,5);
        LinkedList<CalDay> output = timetable.getApptRange(apptList,startCal,endCal);
        String testString = "[\t --- 3/2/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t3/2/2018 at 12:30am ,Appointment 1, Test Text 1\n" +
                " \t3/2/2018 at 1:30am ,Appointment 3, Test Text 3\n" +
                " \t3/2/2018 at 4:30am ,Appointment 2, Test Text 2\n" +
                " \n" +
                ", \t --- 3/3/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/4/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                "]";
        assertEquals(testString,output.toString());

	 }
    @Test
    public void testPermute()  throws Throwable  {

        TimeTable timetable = new TimeTable();
        LinkedList<Appt> apptList = new LinkedList<Appt>();

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
        startMonth = 3;
        title = "Appointment 3";
        description = "Test Text 3";
        Appt appt3 = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);
        startHour = 1;
        startMonth = 7;
        title = "Appointment 4";
        description = "Test Text 4";
        Appt appt4 = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);
        apptList.add(appt1);
        apptList.add(appt2);
        apptList.add(appt3);
        apptList.add(appt4);

        Calendar rightnow = Calendar.getInstance();

        int thisMonth = rightnow.get(Calendar.MONTH);
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

        int [] perInt = {3,2,1,0};
        LinkedList<Appt> output = timetable.permute(apptList,perInt);
        String testString = "[\t3/2/2018 at 12:30am ,Appointment 1, Test Text 1\n" +
                ", \t3/2/2018 at 4:30am ,Appointment 2, Test Text 2\n" +
                ", \t3/2/2018 at 1:30am ,Appointment 3, Test Text 3\n" +
                ", \t7/2/2018 at 1:30am ,Appointment 4, Test Text 4\n" +
                "]";
        assertEquals(testString,output.toString());

    }
    @Test
    public void testDelete()  throws Throwable  {

        TimeTable timetable = new TimeTable();
        LinkedList<Appt> apptList = new LinkedList<Appt>();

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
        startMonth = 3;
        title = "Appointment 3";
        description = "Test Text 3";
        Appt appt3 = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);
        startHour = 1;
        startMonth = 7;
        title = "Appointment 4";
        description = "Test Text 4";
        Appt appt4 = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);
        apptList.add(appt1);
        apptList.add(appt2);
        apptList.add(appt3);
        apptList.add(appt4);

        Calendar rightnow = Calendar.getInstance();

        int thisMonth = rightnow.get(Calendar.MONTH);
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

        LinkedList<Appt> output = timetable.deleteAppt(apptList,appt3);
        String testString = "[\t3/2/2018 at 12:30am ,Appointment 1, Test Text 1\n" +
                ", \t3/2/2018 at 4:30am ,Appointment 2, Test Text 2\n" +
                ", \t7/2/2018 at 1:30am ,Appointment 4, Test Text 4\n" +
                "]";
        assertEquals(testString,output.toString());

    }
//add more unit tests as you needed
}
