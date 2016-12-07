package test.date;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pshrestha on 12/7/2016.
 */
public class DateTest {

    public void testDate() throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String endDateStr = "11/23/2015";
        Date endDate = dateFormat.parse(endDateStr);
        System.out.println("EndDate: " + endDate);
//        String practice.date = dateFormat.format(new Date("2015-01-01")) ;
//        Date practice.date = new Date("03/27/2015");
        Date date = new Date();
//        Date practice.date = new Date("2015-01-30");
        System.out.println("Date1: " + date);
        System.out.println("Date2: " + dateFormat.parse(dateFormat.format(date)));

        if (endDate.after(dateFormat.parse(dateFormat.format(date))) || endDate.equals(dateFormat.parse(dateFormat.format(date)))) {
            System.out.println("True");

        } else {
            System.out.println("False");
        }
    }

    public void testDate2() throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T' HH:mm:ss.SSSZ");
        DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");

        String endDateStr = "12/01/2015";
        Date date = new Date();
        Date newDate = dateFormat2.parse(endDateStr);


        System.out.println("Date1: " + date);
        System.out.println("Date2: " + dateFormat.format(date).replaceAll("([-+]\\d\\d)(\\d\\d)", "$1:$2"));
        System.out.println("Date3: " + newDate);
        System.out.println("Date2: " + dateFormat.format(newDate).replaceAll("([-+]\\d\\d)(\\d\\d)", "$1:$2"));
    }


    public void testDobValidation() {

        boolean valid = isThisDateValid("06/06/1906", "MM/dd/yyyy");
        System.out.println("\nvalid: " + valid);

    }

    public boolean isThisDateValid(String dateToValidate, String dateFormat) {

        if (dateToValidate == null) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
//            Date currentDate = new Date();
//            currentDate.setYear(currentDate.getYear()- 13);
//            Calendar cal = Calendar.getInstance();
//            Date daysAgo = new DateTime(new Date()).minusYears(13).toDate();
            Date eligibleMinAgeDate = new DateTime(new Date()).minusYears(13).toDate();
            Date eligibleMaxAgeDate = new DateTime(new Date()).minusYears(110).toDate();
            System.out.println(date);
            System.out.println(new Date());
            if (date.after(eligibleMinAgeDate) || date.before(eligibleMaxAgeDate)) {
                return false;
            }

        } catch (Exception e) {

            System.out.println("Invalid Date: " + dateToValidate);
            return false;
        }

        return true;
    }

}
