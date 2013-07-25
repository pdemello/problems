public class template {
	public static void main(String[] args) {
        long startTime = System.nanoTime();

        System.out.println("Hi.");

        System.out.println((System.nanoTime()-startTime)/100000 + "ms");
    }
}
