/**
 * 
 */
package hw3;

public class Student {

	private float tuition;
	private String name;
	
	/**
	 * @param name
	 */
	public Student(StudentStatus status, String name) {
		super();
		this.tuition = status.getTuition();
		this.name = name;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Getting tuition from ENUM\n");

		Student XYZ = new Student(StudentStatus.INSTATE, "FROM");
		Student XYZ2 = new Student(StudentStatus.OUTSTATE, "GET");
		Student XYZ3 = new Student(StudentStatus.INTERNATIONAL, "NAME");
		
		System.out.println("Tuition and Student name: " + XYZ.getTuition() + ", " + XYZ.getName());
		System.out.println("Tuition and Student name: " + XYZ2.getTuition() + ", " + XYZ2.getName());
		System.out.println("Tuition and Student name: " + XYZ3.getTuition() + ", " + XYZ3.getName());
	}

	public float getTuition() {
		return tuition;
	}

	public String getName() {
		return name;
	}

}
