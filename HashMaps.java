import java.util.Scanner;
import java.util.HashMap;
import java.io.*;

public class HashMaps {
	static Scanner sc=new Scanner(System.in);
	static int key;
	static String value;
	static HashMap<Integer, String> myMap = new HashMap<Integer, String>();
	static File file = new File("Hello1.txt");

	public static void main(String[] args) {

		Read();
		System.out.println("Enter a key :");
		key = sc.nextInt();
		if(myMap.containsKey(key))
		{
			System.out.println(myMap.get(key));
		}
		else
		{
			System.out.println("Value not present");
			System.out.println("enter a value for the key:");
			value=sc.next();
			myMap.put(key, value);
			System.out.println(myMap.get(key));
		}
		Write();

	}
	public static void Write()
	{
		try{

			file.createNewFile();
			FileWriter writer = new FileWriter(file); 
			for(int k:myMap.keySet())
			{
				writer.write(k +","+ myMap.get(k)+"\n"); 
			}
			writer.flush();
			writer.close();
		}
		catch(IOException e)
		{
			e.getMessage().toString();
		}
	}
	public static void Read() 
	{
		try
		{
			Scanner input =new Scanner(file);
			while(input.hasNextLine())
			{
				String line =input.nextLine();
				String []keyval=line.split(",");
				int newkey=Integer.parseInt(keyval[0]);
				myMap.put(newkey, keyval[1]);
			}
			input.close();

		}
		catch(IOException e)
		{
			e.getMessage().toString();
		}
	}



}
