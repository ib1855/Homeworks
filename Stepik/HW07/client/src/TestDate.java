import java.util.Calendar;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
//        Date date1 = new Date();
//        System.out.println(date1);
//        Date date2;
//        date1.setTime(10000);
//        System.out.println(date1);
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.SECOND, 10);
        System.out.println(calendar2.getTime());

    }
}
