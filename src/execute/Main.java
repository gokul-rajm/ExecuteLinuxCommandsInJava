package execute;

import java.io.*;
import java.util.Scanner; 

public class Main{
	public static void main(String[] args) throws IOException {
		Main obj = new Main();
		
		System.out.println("Enter a Number between 1 to 4");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt(); 
		
		switch (number) {
		  case 1:
			obj.CreateDirectory();
		    break;
		  case 2:
			obj.moveDirectory(); 
		    break;
		  case 3:
			obj.copyDirectory();
		    break;
		  case 4:
			obj.deleteDirectory();
		    break;
		  default:
			System.out.println("Please enter a NUmber between 1 to 4");
			break;
		}
	}
	
	private void CreateDirectory() {
		{ 
			File file = new File("/home/vvdn/Downloads/123"); 
			if (file.mkdir() == true) { 
				System.out.println("Directory has been created successfully"); 
			} 
			else { 
				System.out.println("Directory cannot be created"); 
			} 
		} 
	}
	
	private void moveDirectory() {
		String[] shCommand = {"/bin/sh", "-c", "mv /home/vvdn/Downloads/myFile.csv /home/vvdn/Downloads/123"}; 
		Runtime rt = Runtime.getRuntime();
		try
		{
			rt.exec(shCommand);
		}
		catch (Exception e)
		{
			System.out.println("Execute Command Error:");
			e.printStackTrace();
		}
	}
		
	private void copyDirectory() {
		String[] shCommand = {"/bin/sh", "-c", "cp /home/vvdn/Downloads/123/myFile.csv /home/vvdn/Downloads/1234"}; 
	    Runtime rt = Runtime.getRuntime();
	    try
	    {
	        rt.exec(shCommand);
	    }
	    catch (Exception e)
	    {
	        System.out.println("Execute Command Error:");
	        e.printStackTrace();
	    }
	}
	
	private void deleteDirectory() {
		String[] b = new String[] {"/bin/sh", "-c", "rm -r /home/vvdn/Downloads/123"};
		try {
			Runtime.getRuntime().exec(b);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}