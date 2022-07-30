package com.virtualkey.practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class VirtualKey {
	
	public File file;

	public File getfile() {
		return file;
	}
	//checking file existing or not, If not Create new file
	public File createFile(String fileName) {
		try {
		
			 file = new File("E:\\Practice programs\\Programs\\virtual key for your repositories\\directory\\" + fileName);
			 if (file != null && file.exists()){
				 System.out.println(fileName +" Already Exist\n");
				 return(file);
			 }
			 file.createNewFile();
			 System.out.println(fileName + " created\n");
			 
		}
		catch (Exception message) {
			System.out.println(message.getMessage());
		}
		return file;
	}

	//Write the content in the file
	
	public boolean writeFile(String write) {
		FileWriter writer=null;
		try {
			writer = new FileWriter(file);
			writer.write(write);
			System.out.println("File Write Successfully\n");
			return true;
		}
		catch(IOException message) {
			System.out.println("Failed to write in file\n");
		}
		finally {
			try {
			writer.close();
			}catch(Exception message) {
				message.printStackTrace();
			}
		}
		return false;
	}
	
	//if the giving input file is present it will deleted or it shows file not exist
	
	public static void deleteFile(String searchFile,File location) {
		try {
		boolean existing = new File(location,searchFile).exists();
		if(existing ==true) {
			File deleteFile = new File(location,searchFile);
			deleteFile.delete();
			System.out.println("File deleted Successfully");
		}
		else {
			System.out.println("File not exist");
		}
		}catch(Exception message) {
		System.out.println("Invalid text: "+message);
		}
	}
	
	
	//it search a file is exist or not
	public static void searching(String search,File location) {
		//try {
		File array[] = location.listFiles();
		int i =0;
		int length = array.length;
		boolean found = false;
		try {
		while(i<array.length) {
	        	if(array[i].getName().startsWith(search)) {
	        		System.out.print("File Exists");
	        		System.out.println("\n");
	        		found=true;
	        		i= array.length;
	        	}
	        	else {
	        		i++;
	        	}
		 }
		 if(found==false) {
	        	System.out.println("File not Exists\n");
	    }
	}catch(Exception message) {
		System.out.println("Invalid text format");
	}
}
	
	//main function
	
	public static void main(String[] args) {
		
		File location = new File("E:\\Practice programs\\Programs\\virtual key for your repositories\\directory\\");
		location.mkdirs();
		
		Scanner input = new Scanner(System.in);
		System.out.println("\nWelcome to VirtualKey!");
		System.out.println("Developer: N.Boobalan\n");
	
		VirtualKey object = new VirtualKey();
		
		boolean loop = true;
		while(loop==true) {
		
		System.out.println("1.Retrive the file names in an Ascending order\n2.Business-level operations\n3.Close the Application");
	
		System.out.print("\nEnter your choice: ");
		
		int choice=0;
		try {
		choice = input.nextInt();
		}catch(Exception e) {
			System.out.println("\nInvalid Input...!");
		}
		switch(choice){
			
			case 1:try {
				File array[] = location.listFiles();
					Arrays.sort(array);
					
					for(int i =0;i<array.length;i++) {
						System.out.println(array[i]+"\n");
					}
				}catch(Exception message) {
				System.out.println("Invalid input: "+message);
				}
					break;
				
			case 2:
				
				boolean temp =true;
				while(temp==true) {
					int option;
				try {
					System.out.println("\n1.To Add a file in the existing Directory\n2.To Delete a file from the existing Directory.\n"
					+ "3.To Search a user specified file from the Directory\n4.Back to the previous menu");
			
				System.out.print("\nEnter your option: ");
				
				
				option = input.nextInt();
				}catch(Exception message) {
				System.out.println("Invalid input..!");
				break;
			}
				
				switch(option) {

					case 1:
						System.out.println("Enter file name: ");
						String create = input.next();
						File file = object.createFile(create + ".txt");
						System.out.print("Would you like to write a text in that file? yes or no: ");
						String write = input.next();
						if(write.equals("yes")) {
				
						String contentToFile = "";
						String nextLine = "";
					    do{
					    	contentToFile += nextLine;
					      nextLine += input.nextLine();
					      //System.out.println("nextLine:" + nextLine);
					    } while(!nextLine.contains("exit"));   //give exit only close the loop

					object.writeFile(contentToFile);
					}
					break;
					
					case 2:System.out.println("Enter a file name: ");
							String searchFile = input.next();
							
							object.deleteFile(searchFile,location);
							break;
					
					case 3:System.out.println("Enter a file name to search");
							String search = input.next();
							
							object.searching(search,location);
							break;
					case 4:
						temp=false;
						System.out.println("\nBack to main menu\n");
						break;
						
					default:System.out.println("Invalid Option..!");
					break;
					}
				}
				break;
				
			case 3: 
				//loop =false;
				System.out.println("\n**********Program closed Successfully**********");
				System.exit(0);
				break;
			
			default:
				System.out.println("\nInvalid option..!\n");
				loop=true;
			break;
				
			}
		}
	}
}