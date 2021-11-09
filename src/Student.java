
public class Student {

	//Attributes for the Student Class//
	
	public int id;
	public String fName;
	public String lName;
	public AssignmentMarks mathMarks;
	public AssignmentMarks englishMarks;
	
	// Constructor for the class//
	
	public Student() {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
	}
	
	// Method for returning the full students name (display and remove student method purposes) //
	
	public String getFullName() {
		String fullName = this.fName + " " + this.lName;
		return fullName;
	}
}
