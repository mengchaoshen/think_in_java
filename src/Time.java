import java.util.Calendar;


public class Time {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long currentTime = 1400221816152l-1400221726036l;//1400221726036//1400221816152
		System.out.println(currentTime);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(2990117l);
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY)-8+":"+
				calendar.get(Calendar.MINUTE)+":"+
				calendar.get(Calendar.SECOND));
	}

}
