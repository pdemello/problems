public class template {
	public static void main(String[] args) {
        long startTime = System.nanoTime();

        System.out.println("Hi.");

        System.out.printf("\n%d ms\n", (System.nanoTime()-startTime)/100000);
    }
}
