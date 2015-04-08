package concurrency.example;

public class Test {

	public static void test(int [] coupons,Integer total){
		coupons[0] = 5;
		coupons[1] = 4;
		coupons[2] = 3;
		coupons[3] = 4;
		total = 16;
	}
	
	public static void test(String demo){
		demo = demo +"sssssss";
	}
	
	public static void main(String[] args) {
		int [] coupons = new int[4];
		Integer total = 0;
		test(coupons,total);
		for (int i : coupons) {
			System.out.println(i);
		}
		System.out.println(total);
		String demo = "h";
		test(demo);
		System.out.println(demo);
	}
}
