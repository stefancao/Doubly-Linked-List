import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Stefan
 * Last Name: Cao
 * Lab Section: 1A
 * email address: stefanc1@uci.edu
 *
 *
 * Assignment: lab2
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 
 


public class Main {

	public static void main(String[] args) {
		
		if(args[0].equals("numberFile.txt")){
		
			// Reading numberFile.txt - list of numbers with comma-deliminated
			DoublyLinkedList <Integer> intLinkedList = new DoublyLinkedList<Integer>();
			
			File intFile = new File("numberFile.txt");
					
			System.out.println("Reading numberFile.txt...");
			try{
				Scanner s1 = new Scanner(intFile).useDelimiter(",");
						
				int lcindex = 0;
						
				while(s1.hasNextInt()){	
					intLinkedList.add(lcindex, s1.nextInt());
					lcindex++;
				}
					      
				s1.close();			 
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			
			System.out.println("Reading numberFile.txt complete!");
			System.out.println("Here is the content of the file...");
			intLinkedList.displayList();
			System.out.println("\n\n");
			
			System.out.println("Let's add some numbers to the list...");
			System.out.println("intLinkedList.add(2, 1000); ");
			intLinkedList.add(2, 1000);
			System.out.println("intLinkedList.add(7, 5000); ");
			intLinkedList.add(7, 5000);
			System.out.println("intLinkedList.add(20, 8000); ");
			intLinkedList.add(20, 8000);
			
			System.out.println("Here's the updated List");
			intLinkedList.displayList();
			System.out.println("\n\n");
			
			System.out.println("Let's try to remove some item from the list by index");
			System.out.println("intLinkedList.remove(1000); ");
			Object temp = intLinkedList.remove(1000);
			if(temp == null){
				System.out.println("Invalid index");
			}
			else{
				System.out.println("Item removed is:" + temp);
			}
			
			System.out.println("intLinkedList.remove(10); ");
			temp = intLinkedList.remove(10);
			if(temp == null){
				System.out.println("Invalid index");
			}
			else{
				System.out.println("Item removed is:" + temp);
			}
			
			System.out.println("intLinkedList.remove(11); ");
			temp = intLinkedList.remove(11);
			if(temp == null){
				System.out.println("Invalid index");
			}
			else{
				System.out.println("Item removed is:" + temp);
				
			}
			
			System.out.println("Here's the updated List");
			intLinkedList.displayList();
			System.out.println("\n\n");
			
			System.out.println("Now, Let's try to remove by object");
			System.out.println("intLinkedList.remove(new Integer(567)); ");
			temp = intLinkedList.remove(new Integer(567));
			if(temp == null){
				System.out.println("No such object exists");
			}
			else{
				System.out.println("Item removed is:" + temp);
			}
			
			System.out.println("intLinkedList.remove(new Integer(5000)); ");
			temp = intLinkedList.remove(new Integer(5000));
			if(temp == null){
				System.out.println("No such object exists");
			}
			else{
				System.out.println("Item removed is:" + temp);
			}
			
			System.out.println("intLinkedList.remove(new Integer(8000)); ");
			temp = intLinkedList.remove(new Integer(8000));
			if(temp == null){
				System.out.println("No such object exists");
			}
			else{
				System.out.println("Item removed is:" + temp);
			}
		
			System.out.println("Here's the updated List");
			intLinkedList.displayList();
			System.out.println("\n\n");
			
			System.out.println("Now, Let's try get method by index");
			System.out.println("intLinkedList.get(2); ");
			temp = intLinkedList.get(2);
			if(temp == null){
				System.out.println("Invalid Index");
			}
			else{
				System.out.println("Item obtained is:" + temp);
			}
			
			System.out.println("intLinkedList.get(2000); ");
			temp = intLinkedList.get(2000);
			if(temp == null){
				System.out.println("Invalid Index");
			}
			else{
				System.out.println("Item obtained is:" + temp);
			}
			
			System.out.println("intLinkedList.get(10); ");
			temp = intLinkedList.get(10);
			if(temp == null){
				System.out.println("Invalid Index");
			}
			else{
				System.out.println("Item obtained is:" + temp);
			}
			
			System.out.println("\n\n");
			
			System.out.println("Now let's try the size() method");
			System.out.println("intLinkedList.size(); ");
			temp = intLinkedList.size();
			System.out.println("Size of list is:" + temp);
			System.out.println("Here's the List to make sure it works!");
			intLinkedList.displayList();
			System.out.println("\n\n");
			
			System.out.println("Let's try the isEmpty() method");
			System.out.println("intLinkedList.isEmpty()");
			temp = intLinkedList.isEmpty();
			System.out.println("isEmpty(): " + temp);
			
			System.out.println("Now let's delete all the items... in the list");
			System.out.println("temp_size = intLinkedList.size();\n"
								+ "for (int i = 0; i < intLinkedList.size(); i++){\n   "
								+ "\t intLinkedList.remove(i)"
								+ "\n}");
			
			int temp_size = intLinkedList.size();
			for (int i = 0; i < temp_size; i++){
				intLinkedList.remove(0);
			}
			System.out.println("Here's the updated List");
			intLinkedList.displayList();
			System.out.println("\n\n");
			
			System.out.println("Now let's try size() again...");
			System.out.println("intLinkedList.size(); ");
			temp = intLinkedList.size();
			System.out.println("size() = " + temp);
			System.out.println("\n\n");
			
			System.out.println("Now let's try isEmpty() again...");
			System.out.println("intLinkedList.isEmpty(); ");
			temp = intLinkedList.isEmpty();
			System.out.println("isEmpty() = " + temp);
			System.out.println("\n\n");
		}
		
		
		/*****************************************************/
		
		else if(args[0].equals("words5.dict")){
			DoublyLinkedList <String> stringLinkedList = new DoublyLinkedList<String>();
		
			DoublyLinkedList <String> TempstringLinkedList = new DoublyLinkedList<String>();
			

			File stringFile = new File("words5.dict");
			
			System.out.println("Reading words5.dict...");
			try{
				Scanner s2 = new Scanner(stringFile).useDelimiter("\n");
						
				int lcindex = 0;
				
						
				while(s2.hasNext()){	
					TempstringLinkedList.add(lcindex, s2.next());
					lcindex++;
				}
					      
				s2.close();			 
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			finally{
				
			}
			
			
			System.out.println("Reading words5.dict complete!");
			System.out.println("Here is the content of the file...");
			TempstringLinkedList.displayList();
			System.out.println("\n\n");
			
			System.out.println("There are a lot of words in this file....Let's just use the first 20 elements for easier debugging");
			for(int i = 0; i < 20; i++){
				stringLinkedList.add(i, TempstringLinkedList.get(i));
			}
			
			System.out.println("Here is the updated List...");
			stringLinkedList.displayList();
			System.out.println("\n\n");

			System.out.println("Let's add some words in CAP to the list...");
			System.out.println("stringLinkedList.add(2, 'HELLO'); ");
			stringLinkedList.add(2, "HELLO");
			System.out.println("stringLinkedList.add(7, 'BYE'); ");
			stringLinkedList.add(7, "BYE");
			System.out.println("stringLinkedList.add(20, 'TESTING'); ");
			stringLinkedList.add(20, "TESTING");
			
			System.out.println("Here's the updated List");
			stringLinkedList.displayList();
			System.out.println("\n\n");
			
			System.out.println("Let's try to remove some item from the list by index");
			System.out.println("stringLinkedList.remove(1000); ");
			
			Object temp = stringLinkedList.remove(1000);
			if(temp == null){
				System.out.println("Invalid index");
			}
			else{
				System.out.println("Item removed is:" + temp);
			}
			
			System.out.println("stringLinkedList.remove(10); ");
			temp = stringLinkedList.remove(10);
			if(temp == null){
				System.out.println("Invalid index");
			}
			else{
				System.out.println("Item removed is:" + temp);
			}
			
			System.out.println("stringLinkedList.remove(11); ");
			temp = stringLinkedList.remove(11);
			if(temp == null){
				System.out.println("Invalid index");
			}
			else{
				System.out.println("Item removed is:" + temp);
				
			}
			
			System.out.println("Here's the updated List");
			stringLinkedList.displayList();
			System.out.println("\n\n");
			
			System.out.println("Now, Let's try to remove by object");
			System.out.println("stringLinkedList.remove(new String('NOTHING')); ");
			temp = stringLinkedList.remove(new String("NOTHING"));
			if(temp == null){
				System.out.println("No such object exists");
			}
			else{
				System.out.println("Item removed is:" + temp);
			}
			
			System.out.println("stringLinkedList.remove(new String('abaca')); ");
			temp = stringLinkedList.remove(new String("abaca"));
			if(temp == null){
				System.out.println("No such object exists");
			}
			else{
				System.out.println("Item removed is:" + temp);
			}
			
			System.out.println("stringLinkedList.remove(new String('HELLO')); ");
			temp = stringLinkedList.remove(new String("HELLO"));
			if(temp == null){
				System.out.println("No such object exists");
			}
			else{
				System.out.println("Item removed is:" + temp);
			}
		
			System.out.println("Here's the updated List");
			stringLinkedList.displayList();
			System.out.println("\n\n");
			
			System.out.println("Now, Let's try get method by index");
			System.out.println("stringLinkedList.get(2); ");
			temp = stringLinkedList.get(2);
			if(temp == null){
				System.out.println("Invalid Index");
			}
			else{
				System.out.println("Item obtained is:" + temp);
			}
			
			System.out.println("stringLinkedList.get(20000); ");
			temp = stringLinkedList.get(20000);
			if(temp == null){
				System.out.println("Invalid Index");
			}
			else{
				System.out.println("Item obtained is:" + temp);
			}
			
			System.out.println("stringLinkedList.get(10); ");
			temp = stringLinkedList.get(10);
			if(temp == null){
				System.out.println("Invalid Index");
			}
			else{
				System.out.println("Item obtained is:" + temp);
			}
			
			System.out.println("\n\n");
			
			System.out.println("Now let's try the size() method");
			System.out.println("stringLinkedList.size(); ");
			temp = stringLinkedList.size();
			System.out.println("Size of list is:" + temp);
			System.out.println("Here's the List to make sure it works!");
			stringLinkedList.displayList();
			System.out.println("\n\n");
			
			System.out.println("Let's try the isEmpty() method");
			System.out.println("stringLinkedList.isEmpty()");
			temp = stringLinkedList.isEmpty();
			System.out.println("isEmpty(): " + temp);
			
			System.out.println("Now let's delete all the items... in the list");
			System.out.println("temp_size = stringLinkedList.size();\n"
								+ "for (int i = 0; i < stringLinkedList.size(); i++){\n   "
								+ "\t stringLinkedList.remove(i)"
								+ "\n}");
			
			int temp_size = stringLinkedList.size();
			for (int i = 0; i < temp_size; i++){
				stringLinkedList.remove(0);
			}
			System.out.println("Here's the updated List");
			stringLinkedList.displayList();
			System.out.println("\n\n");
			
			System.out.println("Now let's try size() again...");
			System.out.println("stringLinkedList.size(); ");
			temp = stringLinkedList.size();
			System.out.println("size() = " + temp);
			System.out.println("\n\n");
			
			System.out.println("Now let's try isEmpty() again...");
			System.out.println("stringLinkedList.isEmpty(); ");
			temp = stringLinkedList.isEmpty();
			System.out.println("isEmpty() = " + temp);
			System.out.println("\n\n");
		}
		
		
		
		/*****************************************************/
		
		System.out.println("Lastly last try one more when adding index 0 as in the example in labspecs");
		
		DoublyLinkedList <Integer> numLinkedList = new DoublyLinkedList<Integer>();
		
		System.out.println("numLinkedList.add(0, 1);\n"
				+"numLinkedList.add(0, 5);\n"
				+"numLinkedList.add(0, 6);\n");
		numLinkedList.add(0, 1);
		numLinkedList.add(0, 5);
		numLinkedList.add(0, 6);

		System.out.println("Here is the list...");
		numLinkedList.displayList();
		
		System.out.println("Now let's remove some items...");
		System.out.println("numLinkedList.remove(0);\n"
							+"numLinkedList.remove(new Integer(5));\n");
		
		numLinkedList.remove(0);
		numLinkedList.remove(new Integer(5));
		
		System.out.println("Here is the updated list...");
		numLinkedList.displayList();

	}

}
