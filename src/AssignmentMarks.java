import java.util.Scanner;

public class AssignmentMarks {

	//Attributes for the Assignment Marks Class//
	
	private String courseName;
	private int assignment1;
	private int assignment2;
	private int assignment3;
	private String grade;
	
	//Constructor//
	
	public AssignmentMarks(String courseName, int assignment1, int assignment2, int assignment3) {
		this.courseName = courseName;
		this.assignment1 = assignment1;
		this.assignment2 = assignment2;
		this.assignment3 = assignment3;
	}
	
	// getter and setter methods //
	public int getAssignment1() {
		return assignment1;
	}
	public int getAssignment2() {
		return assignment2;
	}
	public int getAssignment3() {
		return assignment3;
	}
	
	public void setMark(int assignmentNumber, int mark) {
		
		if (assignmentNumber == assignment1) {
			assignment1 = mark;
		} else if(assignmentNumber == assignment2){
			assignment2 = mark;
		} else {
			assignment3 = mark;
		}
	}
	
	public int getMark(int assignmentNumber) {
		int studentMark = assignmentNumber;
		do{
			
		// Checking the range of the input is correct //
			
		if(studentMark < 0 || studentMark > 100) {
			System.out.println("Mark is outside the correct range, enter again.");
			Scanner scanner = new Scanner(System.in);
			studentMark = scanner.nextInt();
			scanner.close();
		}
		}while(studentMark < 0 || studentMark > 100);
		
		// assign the mark to the correct assignment //
		
		if (assignmentNumber == assignment1) {
			assignment1 = studentMark;
		} else if(assignmentNumber == assignment2){
			assignment2 = studentMark;
		} else{
			assignment3 = studentMark;
		}
		
		return studentMark;
	}
	
	public String getGrade(int assignmentNumber) {
		this.markToGrade(assignmentNumber);
		return grade;
		}
	
	
	public int getAverageMark() {
		return ((assignment1 + assignment2 + assignment3) / 3);
	}
	
	public String markToGrade(int mark) {
		
		// if/else to return correct grade //
		if(mark > 94 && mark < 101) {
			grade = "A+";
		} else if (mark > 89 && mark < 95) {
			grade = "A";
		} else if (mark > 84 && mark < 90) {
			grade = "A-";
		} else if (mark > 79 && mark < 85) {
			grade = "B+";
		} else if (mark > 74 && mark < 80) {
			grade = "B";
		} else if (mark > 69 && mark < 75) {
			grade = "B-";
		} else if (mark > 59 && mark < 70) {
			grade = "C+";
		} else if (mark > 49 && mark < 60) {
			grade = "C";
		} else if (mark > 40 && mark < 50) {
			grade = "C-";
		} else {
			grade = "D";
		}
		return grade;
	}
	
	public String getAverageGrade(int getAverageMark) {
		String averageGrade;
		
		// if/else to return correct average grade//
		
		if(getAverageMark > 94 && getAverageMark < 101) {
			averageGrade = "A+";
		} else if (getAverageMark > 89 && getAverageMark < 95) {
			averageGrade = "A";
		} else if (getAverageMark > 84 && getAverageMark < 90) {
			averageGrade = "A-";
		} else if (getAverageMark > 79 && getAverageMark < 85) {
			averageGrade = "B+";
		} else if (getAverageMark > 74 && getAverageMark < 80) {
			averageGrade = "B";
		} else if (getAverageMark > 69 && getAverageMark < 75) {
			averageGrade = "B-";
		} else if (getAverageMark > 59 && getAverageMark < 70) {
			averageGrade = "C+";
		} else if (getAverageMark > 49 && getAverageMark < 60) {
			averageGrade = "C";
		} else if (getAverageMark > 40 && getAverageMark < 50) {
			averageGrade = "C-";
		} else {
			averageGrade = "D";
		}
		return averageGrade;
	}
	
	/*public String setCourseName(String name) { 		//Useable for a future assignment that employs more courses.
		this.courseName = name;
		return name;
	}*/
	
	public String getCourseName() {
		return courseName;
	}
	
}
