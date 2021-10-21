package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
	public static void main(String[] args) {
		
		for (int i = 1; i <= 50; i++) {
			List<String> loc = new ArrayList<>();
			int temp = i;
			for (int j = 1; j <= 50; j++) {
				if (j == temp) {
					loc.add(">");
				}else {
					loc.add("-");
				}
				System.out.print(loc.get(j-1));
			}
			System.out.println();
		}
		
		
		
		
	}
}