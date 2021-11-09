import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Main {

//----------------------------------------Attributes---------------------------------------------------------------//
	
	public static LinkedList<Student> allStudents;	
	public static Integer menuChoice;
	public static boolean status = true;
	
	
//----------------------------------------Main Method--------------------------------------------------------------//
	
	public static void main(String[] args) {
		allStudents = new LinkedList<Student>();
		
		//read a file source.txt file and it should return true or false// <--File read test code//
		
		//if(readFile("!!insert file path for student.txt file here!!")) { <--File read test code//
		
		while(status) {
			
		//System.out.println("File read okay!\n");  						<--File read test code//
		
		//display options//
			
		displayMenu();
		
		//take input//
		
		selectMenuOption();	 
		}
		/*}else {															<--File read test code//				
			System.out.println("Something has gone wrong here...");			<--File read test code//
		}																	<--File read test code// */
	}

	
//----------------------------Other Methods of the Main Class------------------------------------------------------//

	private static void displayMenu() {
		
		// menu display for the user
		
		System.out.println("Student Assignment Marks & Grades Database (Math & English)\n"
				+ "1) Display Student Marks\n"
				+ "2) Display Student Grades\n"
				+ "3) Add a new Student\n"
				+ "4) Remove an existing Student\n"
				+ "5) Exit\n\n"
				+ "Menu option: \n");
	}
	
	
	private static int selectMenuOption() {
		
		// menu selection for the user //
		
		Scanner scanner = new Scanner(System.in);
		
		//menuChoice = testCode();    <----Test code for the programme
		
		// testing for format Exceptions in the users menu choice
		
		do {
			 String n = scanner.next();
		     try {
		    	 
		         // Parse the input if it is successful, it will set a non null value to menuChoice//
		    	 
		         menuChoice = Integer.parseInt(n);
		         break;
		     } catch (NumberFormatException e) {
		    	 
		         // The input value was not an integer so menuChoice remains null//
		    	 
		         System.out.println("Incorrect format, must be in the form of a number. Please try again:\n");
		     }
		 } while (menuChoice == null);
		
		//using switch cases to choose between menu options//
		
				switch(menuChoice) {
				case 1: {
					displayReportByMarks();
					pressAnyKeyToContinue();
					break;
				}
				case 2: {
					displayReportByGrades();
					pressAnyKeyToContinue();
					break;
				}
				case 3: {
					addNewStudent();
					pressAnyKeyToContinue();
					break;
				}
				case 4: {
					removeStudent();
					pressAnyKeyToContinue();
					break;
				}
				case 5: {
					System.out.println("Exiting programme...");
					System.exit(0);
				}
				default: {
					System.out.println("Invalid input\n");
					break;
				}
			}
			return menuChoice;
	}
	
	
	
	/*public static boolean readFile(String fileName) {									<--File read test code//
		
		// Reads the text file of the supplied students ids, marks (etc.) provided //	
		
		File file = new File(fileName);													
		
		try {																			
			Scanner scanner = new Scanner(file);										
			while(scanner.hasNextLine()){												
		        String[] words = scanner.nextLine().split(",");
		        
		        int id = Integer.parseInt(words[0]);
		        String firstName = words[1];
		        String lastName = words[2];
		        int mathMark1 = Integer.parseInt(words[3]);
		        int mathMark2 = Integer.parseInt(words[4]);
		        int mathMark3 = Integer.parseInt(words[5]);
		        int englishMark1 = Integer.parseInt(words[6]);
		        int englishMark2 = Integer.parseInt(words[7]);
		        int englishMark3 = Integer.parseInt(words[8]);
		        
		        //calls addStudent() method for the file//
		        
		        addStudent(id,firstName,lastName,mathMark1,mathMark2,mathMark3,englishMark1,englishMark2,englishMark3);

	        }
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Failed to read file");
		}
	    return true;

	}																			<--File read test code//*/
	
	
	private static void addStudent(int id, String firstName, String lastName, int mathMark1, int mathMark2, int mathMark3, int englishMark1, int englishMark2, int englishMark3){
		
		// adds Student object //
		
		Student aStudent = new Student();
		AssignmentMarks finalMath = new AssignmentMarks("Math", mathMark1, mathMark2, mathMark3);  
		AssignmentMarks finalEnglish = new AssignmentMarks("English", englishMark1, englishMark2, englishMark3);
		aStudent.id = id;
		aStudent.fName = firstName;
		aStudent.lName = lastName;
		aStudent.mathMarks = finalMath;
		aStudent.englishMarks = finalEnglish;
		
		// Pushes the new record to the linked list//
		
		allStudents.add(aStudent);
	}
	
	private static void displayReportByMarks() {
		
		// Print out table headings//
		
		System.out.println(""
				+ "----------------------------------------------------------------------------------------------------------------------");
		System.out.println("ID" + "\t" + "Full Name" + "\t" + "Subject" + "\t\t" + "A1" + "\t" + "A2" + "\t" + "A3" + "\t" + "Ave" + "\t" + "Subject" + "\t\t" + "A1" + "\t" + "A2" + "\t" + "A3" + "\t" + "Ave");
		System.out.println(""
				+ "----------------------------------------------------------------------------------------------------------------------\n");
		// for loop printing out the Student data and marks of the LinkedListed Students//
		
		for (Student s : allStudents) {
			String nameFormat1 = String.format("%-10s", s.getFullName());
			System.out.println(s.id + "\t" + nameFormat1 + "\t" + s.mathMarks.getCourseName() + "\t\t" + s.mathMarks.getAssignment1() + "\t" + s.mathMarks.getAssignment2() + "\t" + s.mathMarks.getAssignment3() + "\t" + s.mathMarks.getAverageMark() +"\t" + s.englishMarks.getCourseName() + "\t\t" + s.englishMarks.getAssignment1() + "\t" + s.englishMarks.getAssignment2() + "\t" + s.englishMarks.getAssignment3() + "\t" + s.englishMarks.getAverageMark());		 
		}
	}
	
	private static void displayReportByGrades() {
		
		// Print out table headings//
		
		System.out.println(""
				+ "----------------------------------------------------------------------------------------------------------------------");
		System.out.println("ID" + "\t" + "Full Name" + "\t" + "Subject" + "\t\t" + "A1" + "\t" + "A2" + "\t" + "A3" + "\t" + "Ave" + "\t" + "Subject" + "\t\t" + " A1" + "\t" + "A2" + "\t" + "A3" + "\t" + "Ave");
		System.out.println(""
				+ "----------------------------------------------------------------------------------------------------------------------\n");		
		// for loop printing out the Student data and grades of the LinkedListed Students//
		
		for (Student s : allStudents) {
		String nameFormat2 = String.format("%-10s", s.getFullName());
		System.out.println(s.id + "\t" + nameFormat2 + "\t" + s.mathMarks.getCourseName() + "\t\t" + s.mathMarks.getGrade(s.mathMarks.getAssignment1()) + "\t" + s.mathMarks.getGrade(s.mathMarks.getAssignment2()) + "\t" + s.mathMarks.getGrade(s.mathMarks.getAssignment3()) + "\t" + s.mathMarks.getAverageGrade(s.mathMarks.getAverageMark()) +"\t" + s.englishMarks.getCourseName() + "\t\t" + s.englishMarks.getGrade(s.englishMarks.getAssignment1()) + "\t" + s.englishMarks.getGrade(s.englishMarks.getAssignment2()) + "\t" + s.englishMarks.getGrade(s.englishMarks.getAssignment3()) + "\t" + s.englishMarks.getAverageGrade(s.englishMarks.getAverageMark()));  //ID able to access at it is public. => video 10
		}
	}
	
	private static void addNewStudent() {
		
		// adding a new student from User input//
		
		Student aStudent = new Student();
		Scanner scanner = new Scanner(System.in);
		int mathMark1 = 0, mathMark2 = 0, mathMark3 = 0;
		int englishMark1 = 0, englishMark2 = 0, englishMark3 = 0;
		
		String course1 = "Math", course2 = "English"; //Changeable in the future if user wishes to set a new Course.
		
		aStudent.mathMarks  = new AssignmentMarks(course1, mathMark1, mathMark2, mathMark3);  
		aStudent.englishMarks = new AssignmentMarks(course2, englishMark1, englishMark2, englishMark3);
		
		// User input for creating the new Student object //
		
		System.out.println("Enter new ID\n");
		int studentID = correctFormat(); // format exception check
		aStudent.id = studentID;
		System.out.println("\nEnter students first name\n");
		aStudent.fName = scanner.next();
		System.out.println("\nEnter students last name\n");
		aStudent.lName = scanner.next();
		
		//System.out.println("Enter the name of this course?"); // Code for setting the course
		//aStudent.mathMarks.setCourseName(scanner.next());
		//aStudent.mathMarks.getCourseName();
		
		System.out.println("\nEnter grade for Maths Assignment 1\n");
		int math1 = correctFormat2(); // format exception check
		aStudent.mathMarks.setMark(aStudent.mathMarks.getAssignment1(), math1);
		aStudent.mathMarks.getMark(aStudent.mathMarks.getAssignment1());
		
		System.out.println("\nEnter grade for Maths Assignment 2\n");
		int math2 = correctFormat2();// format exception check
		aStudent.mathMarks.setMark(aStudent.mathMarks.getAssignment2(), math2);
		aStudent.mathMarks.getMark(aStudent.mathMarks.getAssignment2());
		
        System.out.println("\nEnter grade for Maths Assignment 3\n");
        int math3 = correctFormat2();// format exception check
        aStudent.mathMarks.setMark(aStudent.mathMarks.getAssignment3(), math3);
        aStudent.mathMarks.getMark(aStudent.mathMarks.getAssignment3());
        
        //System.out.println("Enter the name of this course?");  // Code for setting the course
      	//aStudent.mathMarks.setCourseName(scanner.next());
      	//aStudent.mathMarks.getCourseName();
        
        System.out.println("\nEnter grade for English Assignment 1\n");
        int english1 = correctFormat2();// format exception check
        aStudent.englishMarks.setMark(aStudent.englishMarks.getAssignment1(), english1);
        aStudent.englishMarks.getMark(aStudent.englishMarks.getAssignment1());
        
        System.out.println("\nEnter grade for English Assignment 2\n");
        int english2 = correctFormat2();// format exception check
        aStudent.englishMarks.setMark(aStudent.englishMarks.getAssignment2(), english2);
        aStudent.englishMarks.getMark(aStudent.englishMarks.getAssignment2());
        
        System.out.println("\nEnter grade for English Assignment 3\n");
        int english3 = correctFormat2();// format exception check
        aStudent.englishMarks.setMark(aStudent.englishMarks.getAssignment3(), english3);
        aStudent.englishMarks.getMark(aStudent.englishMarks.getAssignment3());
        
        allStudents.add(aStudent);
        pressAnyKeyToContinue();
        displayMenu();
        selectMenuOption();
    	   
	}
	
	private static void removeStudent() {
		
		// remove student from the Linked List //
		Student rightID = new Student();
		boolean foundThem = false;
		Scanner scanner = new Scanner(System.in);
		
		// finding the student to remove from the LinkedList//
		
		System.out.println("\nPlease enter the id of the student you wish to remove.\n");
		int findID = correctFormat2();

		for (int i =0; i < allStudents.size(); i++) { //Iterate through the Linked List to find the input ID
			
			if(allStudents.get(i).id == findID) { 
				System.out.println("\nStudent ID: " + findID + " exists.\n");
				foundThem = true;
				break;
				}
		}
			if(!foundThem){
					System.out.println("\nStudent not found.\n");
					
				} 
		
		while(foundThem) {
			
		// Displaying to the user the details of the Student ID found (to avoid removing the wrong student) //
			
			for (Student removeMe : allStudents) {
				if(removeMe.id == findID) {
				System.out.println("\nDelete Student: " + removeMe.id + " " + removeMe.getFullName() + "? (enter y to delete)\n");
				String deleteStudent = scanner.next();
				if (deleteStudent.equals("y")) {
					allStudents.remove(removeMe);
					System.out.println("\nStudent removed\n");
				}else {
					System.out.println("\nStudent not removed\n");
				}
				foundThem = false;
				break;
				}
			}
			
		}
		
		}
	
	
	 
	 private static int correctFormat() {
		 
		 //Format checks for inputs by the user for Student ID//
		 
		 Scanner scanner = new Scanner(System.in);
		 Integer i = null;
		 boolean duplicate = true;
		 
		 // Loop as long as i is null//
		 
		 while(duplicate) {
		 do {
			 
		     // Get the input from the user//
			 
			 String n = scanner.next();
		     try {
		    	 
		         // Parse the input if it is successful, it will set a non null value to i//
		    	 
		         i = Integer.parseInt(n);
		         break;
		     } catch (NumberFormatException e) {
		    	 
		         // The input value was not an integer so i remains null//
		    	 
		         System.out.println("\nIncorrect format, must be in the form of a number. Please try again:\n");
		     }
		 } while (i == null);
		
		 i = i - 1;
			int found = -1;
			for (int j =0; j < allStudents.size(); j++) {
				
				allStudents.get(j);
				
				int allStudentsElement = j;
				
				if (allStudentsElement == i) {
					
					found = j+1;
					break;
				}
			}
			if (found == -1) {
				duplicate = false;
			} else { System.out.println("\nStudent ID: " + found + " already exists. Please enter again.\n");
			
			}
		 }
		 return i+1;
	 }
private static int correctFormat2() {
		 
		 //Format checks for inputs by the user for Student Marks and remove user//
		 
		 Scanner scanner = new Scanner(System.in);
		 Integer i = null;
		 
		 
		 // Loop as long as i is null//
		 
		 
		 do {
			 
		     // Get the input from the user//
			 
			 String n = scanner.next();
		     try {
		    	 
		         // Parse the input if it is successful, it will set a non null value to i//
		    	 
		         i = Integer.parseInt(n);
		         break;
		     } catch (NumberFormatException e) {
		    	 
		         // The input value was not an integer so i remains null//
		    	 
		         System.out.println("\nIncorrect format, must be in the form of a number. Please try again:\n");
		     }
		 } while (i == null);
		 
		 return i;
}
	 
	 private static void pressAnyKeyToContinue()
	 
	 	// For use between options for the user//
	 { 
	        System.out.println("\nPress Enter to continue...\n");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	 }
	 
	 //Test Code to check the file has been read correctly//
	 /*              
	 private static int testCode() {														<--File read test code//
		 return 1;
		 
	 } */

}


