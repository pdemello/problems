import java.util.*;

public class epi2_1 {
	public static void main(String[] args) {
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();

		for (int x = 0; x < 256; ++x) {
			int count = 0;
			int num = x;
			for (int y = 0; y < 8; ++y) {
				count += num & 1;
				num >>= 1;
			}
			m.put(x, count);
		}
		System.out.println("small number 255:" + m.get(255));

		int bigNum = 0xffefffff;
		int bigCount = 0;
		for (int y = 0; y < 4; ++y) {
			bigCount += m.get(bigNum & 0xff);
			bigNum >>= 8;
		}
		System.out.println("big number:" + bigCount);
	}
}
