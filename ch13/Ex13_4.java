import javax.swing.JOptionPane;

public class Ex13_4 {
	public static void main(String[] args) throws Exception {		
		// Single Thread
		String input = JOptionPane.showInputDialog("Show Me the Letter~!");
		System.out.println("You typed "+input+":)");
		
		// input 출력 후, 카운트다운 시작
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {Thread.sleep(1000);} // 시간을 1초 지연
			catch(Exception e) {}
		}
	}
}