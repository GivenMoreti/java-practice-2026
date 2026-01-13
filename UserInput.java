import java.util.Scanner;

public class UserInput
{ 

	public static void main(String[] args){ 

		System.out.println("hello world");

		String name;
		System.out.println("Enter your name: ");
        Scanner scan = new Scanner(System.in);
		name = scan.next();

		//validate user input
		if(!name.isBlank()){
			System.out.println(" Hello " + name);
		}





	}
}
