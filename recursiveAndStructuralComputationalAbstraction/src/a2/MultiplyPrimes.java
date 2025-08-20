package a2;

public class MultiplyPrimes {
	
	/**
	 * Computes the product of two large prime values and tests if the product is
	 * equal to the true value.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		String sa = "162259276829213363391578010288127"; // 2^107 - 1
		String sb = "618970019642690137449562111"; // 2^89 - 1
		String exp = "100433627766186892221372630609062766858404681029709092356097";
		String prod = LongMult.multiply(sa, sb);
		System.out.println(prod);
		System.out.println("equals expected value: " + prod.equals(exp));
	}
}
