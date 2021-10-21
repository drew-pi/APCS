public class StatsDriver{

	public static void main (String [] args){
		Stats calc = new Stats();
		
		//int avg tests
		System.out.println("================ Int Avg Tests ================");
		System.out.println(calc.mean(10, 10)); // mean should be 10
		System.out.println(calc.mean(-2, 4)); // mean should be 1
		System.out.println(calc.mean(0, 30)); // mean should be 15

		//double avg tests
		System.out.println("================ double Avg Tests ================");
		System.out.println(calc.mean(2.5, 7.5)); // mean should be 5
		System.out.println(calc.mean(-1.5, 3)); // mean should be 0.75 
		System.out.println(calc.mean(3.0, 2.0)); // mean should be 2.5

		//int max tests
		System.out.println("================ Int Max Tests ================");
		System.out.println(calc.max(45, 89)); // max should be 89
		System.out.println(calc.max(36, -780)); // max should be 36
		System.out.println(calc.max(6, 0)); // max should be 6
		
		//double max tests
		System.out.println("================ Double Max Tests ================");
		System.out.println(calc.max(4.5, 8.9)); // max should be 8.9
		System.out.println(calc.max(1.9, 1.99)); // max should be 1.99
		System.out.println(calc.max(667.2, -5.6)); // max should be 667.2
		
		//int geoMean tests
		System.out.println("================ Int GeoMean Tests ================");
		System.out.println(calc.geoMean(10, 10)); // geoMean should be 10
		System.out.println(calc.geoMean(4, 64)); // geoMean should be 16
		System.out.println(calc.geoMean(5, 45)); // geoMean should be 15
		
		//double GeoMean tests
		System.out.println("================ double GeoMean Tests ================");
		System.out.println(calc.geoMean(10.0,10.0)); // geoMean should be
		System.out.println(calc.geoMean(4.0,64.0)); // geoMean should be
		System.out.println(calc.geoMean(5.0,45.0)); // geoMean should be



		System.out.println("\n\n\n\n================ Three Inputs ================\n\n\n\n");



		// System.out.println("================ Int Avg Tests ================");
		// System.out.println(calc.mean(10,10,10)); // mean should be 10
		// System.out.println(calc.mean(-2, 4, 2)); // mean should be 3
		// System.out.println(calc.mean(0,0,30)); // mean should be 15

		// //double avg tests
		// System.out.println("================ double Avg Tests ================");
		// System.out.println(calc.mean(2.5, 7.5,2)); // mean should be 6
		// System.out.println(calc.mean(-1.5, 3, 0.75)); // mean should be 0.75 
		// System.out.println(calc.mean(3.0, 2.0,2.0)); // mean should be 2.5

		//int max tests
		System.out.println("================ Int Max Tests ================");
		System.out.println(calc.max(45, 89,100)); // max should be 100
		System.out.println(calc.max(36, -780,0)); // max should be 36
		System.out.println(calc.max(6, 0,-3)); // max should be 6

		//double max tests
		System.out.println("================ Double Max Tests ================");
		System.out.println(calc.max(4.5, 8.9,.78)); // max should be 8.9
		System.out.println(calc.max(1.9, 1.99,01100.3)); // max should be 01100.3
		System.out.println(calc.max(667.2, -5.6,0)); // max should be 667.2

		//int geoMean tests
		System.out.println("================ Int GeoMean Tests ================");
		System.out.println(calc.geoMean(10, 10,10)); // geoMean should be 10
		System.out.println(calc.geoMean(4, 64,4)); // geoMean should be 10
		System.out.println(calc.geoMean(5, 45,8)); // geoMean should be 12
		//double GeoMean tests
		System.out.println("================ double GeoMean Tests ================");
		System.out.println(calc.geoMean(10.0,10.0,10.0)); // geoMean should be
		System.out.println(calc.geoMean(4.0,64.0,4.0)); // geoMean should be
		System.out.println(calc.geoMean(5.0,45.0,8.0)); // geoMean should be 14.9836859



	}
}