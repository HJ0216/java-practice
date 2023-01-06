
public class AuthApp3 {

	public static void main(String[] args) {
		
		String[] users = {"Ann", "Eun", "Young"};
		String inputid = args[0];
		
		boolean isLogined = false;
		for(int i=0; i<users.length; i++) {
			String currentid = users[i];
				if(currentid.equals(inputid)) {
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
