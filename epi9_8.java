import java.util.*;

public class epi9_8 {
	public static void main(String[] args) {
		String letter = "hellotherehowareyoutodayxxxxx,./";
		String magazine = "ivjgscffdrfgzqewwaertdyugihojpjlghkjfhgfdsazxcvbnmklpoiuytrewqasdfgyhjklkmnbvcxzsaertyuiolkjhgfdswqazxcvbnm,lkjhgfdsertyhnbvcdfghbvcfdtgybhgvcfdercxszwedawqw2esawq3edrxftcdrftgyvyhubuijnhuijkolij9o0plkoi0pkijuytfdresrdytfughwrceibhsvgebvewytwy2hfnvjifb3v6792geiyhufocnxbvcdxwyhjgkoty7v67cgvhjfbuvytdXcvzbmxoiftduywhcmgjdfhgdy97veg2fiou3roeyfiu";
		Map<Character,Integer> m = new HashMap<Character,Integer>();
		for (int i = 0; i < letter.length(); ++i) {
			Integer oldCount = m.get(letter.charAt(i));
			m.put(letter.charAt(i), oldCount == null ? 1 : oldCount+1);
		}
		for (int i = 0; i < magazine.length() && !m.isEmpty(); ++i) {
			if (m.containsKey(magazine.charAt(i))) {
				int count = m.get(magazine.charAt(i));
				if (count == 1)
					m.remove(magazine.charAt(i));
				else
					m.put(magazine.charAt(i), count - 1);
			}
		}
		System.out.println(m.isEmpty() ? "true" : "false");	
	}
}
