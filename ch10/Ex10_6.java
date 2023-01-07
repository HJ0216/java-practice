import java.text.DecimalFormat;

public class Ex10_6 {
	public static void main(String[] args) {
		double number = 1234567.89;
		String[] pattern = {
			"0", // 1234568
			"#", // 1234568
			
			"0.0", // 1234567.9
			"#.#", // 1234567.9

			"00,00.00", // 1,23,45,67.89
			"##,##.##",	// 1,23,45,67.89		
			
			"000,000,000.0", // 001,234,567.9
			"###,###,###.#", // 1,234,567.9

            "000,000,000.000",            
            "###,###,###.###",

            "#.####E0",	// 1.2346E6 - 5자리*10^n
            "my number: ###.##%", // 123456789%: 1 = 100%	
            "'#' ###,###.###", // # 1,234,567.89		
            "'0' 000,000.000", // 0 1,234,567.890
            
            // x.xxEx의 형태로 나타냄
            "#.E0",				// 1.E6
            "#.#E0",			// 1.2E6
            "#.##E0",			// 1.23E6
            "#.###E0",			// 1.235E6
            "#.####E0",			// 1.2346E6
            "#.#####E0",		// 1.23457E6
            "#.######E0",		// 1.234568E6
            "#.#######E0",		// 1.2345679E6
            "#.########E0",		// 1.23456789E6
            "#.#########E0",	// 1.23456789E6
            
            "#.E0",				// 1.E6
            "##.E0",			// 1.2E6
            "###.E0",			// 1.23E6
            "####.E0",			// 123.5E4
            "#####.E0",			// 12.346E5
            "######.E0",		// 1.23457E6
            "#######.E0",		// 1234568E0
            "########.E0",		// 1234567.9E0
            "#########.E0",		// 1234567.89E0
            "##########.E0",	// 1234567.89E0
		};

		for(int i=0; i<pattern.length; i++) {
			DecimalFormat df = new DecimalFormat(pattern[i]);
			System.out.printf("%19s : %s%n", pattern[i], df.format(number));
		}
	}
}