



public class Time{
	public static void main(String[] args){


		int hour,minute,second;
		hour = 17;
		minute = 34;
		second = 10;

		int newHour,newMin,newSec;
		newHour = 17;
		newMin = 43;
		newSec = 3;


		System.out.println("seconds since midnight");
		System.out.println((hour*60*60)+(minute*60)+second);
		
		System.out.println("seconds remaining in the day");
		System.out.println((24*60*60)-((hour*60*60)+(minute*60)+second));

		System.out.println("Percent of the day that passed");
		System.out.println((((hour*60.0*60.0)+(minute*60.0)+second)/(24.0*60.0*60.0))*100);

		System.out.println("Time passed since writing");
		System.out.println(((newHour*60*60)+(newMin*60)+newSec)-((hour*60*60)+(minute*60)+second));
	}
}