import java.io.*;
import java.util.*;

public class FirstJavaDemo {

	public static void main(String[] args) {

		Console console = System.console();
		if (console == null) {
			System.out.println("Console not found");
			System.out.println("Please re-run from a command line, shell, or console window");
			System.exit(0);
		}

		System.out.print("Tell me something about yourself: ");
		String something = console.readLine();
		
		System.out.println("Interesting!  You said: " + something);
	}
}
