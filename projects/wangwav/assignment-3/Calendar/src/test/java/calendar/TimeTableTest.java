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

        //add reccurence to appt1
        int[] days = {0,1,2,4};
        appt1.setRecurrence(days,1,1,6);
        apptList.add(appt1);
        apptList.add(appt2);
        apptList.add(appt3);
        apptList.add(appt4);

        Calendar rightnow = Calendar.getInstance();

        int thisMonth = rightnow.get(Calendar.MONTH);
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

        GregorianCalendar startCal = new GregorianCalendar(2018,3,2);
        GregorianCalendar endCal = new GregorianCalendar(2018,3,29);
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
                "\t3/2/2018 at 12:30am ,Appointment 1, Test Text 1\n" +
                " \n" +
                ", \t --- 3/5/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/6/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/7/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/8/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t3/2/2018 at 12:30am ,Appointment 1, Test Text 1\n" +
                " \n" +
                ", \t --- 3/9/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t3/2/2018 at 12:30am ,Appointment 1, Test Text 1\n" +
                " \n" +
                ", \t --- 3/10/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/11/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t3/2/2018 at 12:30am ,Appointment 1, Test Text 1\n" +
                " \n" +
                ", \t --- 3/12/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/13/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/14/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/15/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t3/2/2018 at 12:30am ,Appointment 1, Test Text 1\n" +
                " \n" +
                ", \t --- 3/16/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t3/2/2018 at 12:30am ,Appointment 1, Test Text 1\n" +
                " \n" +
                ", \t --- 3/17/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/18/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/19/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/20/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/21/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/22/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/23/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/24/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/25/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/26/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/27/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 3/28/2018 --- \n" +
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
        startHour = -1;
        startMonth = 7;
        title = "Appointment 4";
        description = "Test Text 4";
        Appt appt5 = new Appt(startHour,
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

        //add/delete invalid appointment
        apptList.add(appt5);
        output = timetable.deleteAppt(apptList,appt5);
        assertEquals(null,output);

    }
}
