
public class AuthApp4 {

	public static void main(String[] args) {
		
//		String[] users = {"Ann", "Eun", "Young"};
		String[][] users = {
				{"Ann", "1111"},
				{"Eun", "2222"},
				{"Young", "3333"}

		};

		String inputid = args[0];
		String inputpw = args[1];
		
		boolean isLogined = false;
		for(int i=0; i<users.length; i++) {
			String[] current = users[i];
				if(
						current[0].equals(inputid)&&
						current[1].equals(inputpw)
				) {
					isLogined = true;
					break;
				}
		}
		System.out.println("Hello, ");
		if(isLogined) {
			System.out.println("Friend!");
		} else {
			System.out.println("Who are you?");
		}
	}

}
