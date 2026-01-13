
public class HelloWorld
{ 

	public static void main(String[] args){ 

		System.out.println("hello world");
		System.out.println("foo " + args[0]); //PS C:\Users\Givenchie\Desktop\2026\java> java HelloWorld.java bar
		/*
		* where bar is the arg parsed in the terminal
		 */

	}
}

//which java == Your shell should print the complete path to the java executable file in the bin directory of the distribution you just expanded. 
// java -version
// echo $JAVA_HOME
//java HelloWorld.java	== to execute
// javac HelloWorld.java == compile
