import java.util.ArrayList;

public class TestStudents 
{

    public static void main( String[] args ) {
        Module EE443 = new Module("BE Project","EE443"); //ECE, EE
        Module CT417 = new Module("Software Engineering III", "CT417"); //ECE, CS
        Module CT475 = new Module("Machine Learning & Data Mining", "CT475"); //ECE, CS
        Module EE451 = new Module("System on Chip Design", "EE451"); //ECE, EE
        
        CourseProgramme CS = new CourseProgramme("Computer Science"); //1, 7
        CourseProgramme ECE = new CourseProgramme("Electronic & Computer Engineering"); // 3, 4, 5, 6, 8, 9
        CourseProgramme EEE = new CourseProgramme("Electrical and Electronic Engineering"); //0, 2
        
    	ArrayList<Student> allstudents = new ArrayList<Student>();
        allstudents = createlistofStudents(allstudents); //creates a list of students to use for modules
        //populate modules with students
        EE443.addStudent(allstudents.get(0)); EE443.addStudent(allstudents.get(2)); //EE Students
        EE443.addStudent(allstudents.get(3)); EE443.addStudent(allstudents.get(4)); //ECE Students
        EE443.addStudent(allstudents.get(5)); EE443.addStudent(allstudents.get(6)); //..
        EE443.addStudent(allstudents.get(8)); EE443.addStudent(allstudents.get(9)); //ECE Students
        
        EE451.addStudent(allstudents.get(0)); EE451.addStudent(allstudents.get(2)); //EE Students
        EE451.addStudent(allstudents.get(3)); EE451.addStudent(allstudents.get(4)); //ECE Students
        EE451.addStudent(allstudents.get(5)); EE451.addStudent(allstudents.get(6)); //..
        EE451.addStudent(allstudents.get(8)); EE451.addStudent(allstudents.get(9)); //ECE Students
        
        CT417.addStudent(allstudents.get(3)); CT417.addStudent(allstudents.get(4)); //ECE Students
        CT417.addStudent(allstudents.get(5)); CT417.addStudent(allstudents.get(6)); //..
        CT417.addStudent(allstudents.get(8)); CT417.addStudent(allstudents.get(9)); //ECE Students
        CT417.addStudent(allstudents.get(1)); CT417.addStudent(allstudents.get(7)); //CS Students
        
        CT475.addStudent(allstudents.get(3)); CT475.addStudent(allstudents.get(4)); //ECE Students
        CT475.addStudent(allstudents.get(5)); CT475.addStudent(allstudents.get(6)); //..
        CT475.addStudent(allstudents.get(8)); CT475.addStudent(allstudents.get(9)); //ECE Students
        CT475.addStudent(allstudents.get(1)); CT475.addStudent(allstudents.get(7)); //CS Students

        CS.addModule(CT475); CS.addModule(CT417); //add modules to courses
        ECE.addModule(EE451); ECE.addModule(CT475); ECE.addModule(CT417); ECE.addModule(EE443);
        EEE.addModule(EE451); EEE.addModule(EE443);
    	
        ArrayList<CourseProgramme> allCourses = new ArrayList<CourseProgramme>();
        allCourses.add(EEE); allCourses.add(ECE); allCourses.add(CS);
    	
        System.out.println("List of students: \n");
        
        ArrayList<Student> checkedStudents = new ArrayList<Student>(); //list of students who have already been printed to console 
        
    	for(CourseProgramme course : allCourses) { //iterate through each course
    		for(Module module : course.listModules()) { //iterate through each module in each course
    			for(Student student : module.listStudents()) { //iterate through each student in each course
        			if(!checkedStudents.contains(student)) { //if student already done, skip if they appear again in other modules
        				checkedStudents.add(student); //adds student to list so can be skippedi n future
    				ArrayList<Module> listofmods  = new ArrayList<Module>(); //list of modules that student takes
    				for(CourseProgramme cc : allCourses) {
    					for(Module mod : cc.listModules()){
    						//if mod not already present in listofmods and student is in mod, add to student's list of mods
    						if((mod.listStudents().contains(student)) && !(listofmods.contains(mod))) listofmods.add(mod);
    					}
    				}
    				//Prints out student username and course name depending on which modules student has
    				if( listofmods.contains(EE443) && listofmods.contains(CT475) ) 
    					System.out.println(student.getUsername() + ": " + ECE.getName());
    				if( listofmods.contains(EE443) && !listofmods.contains(CT475) ) 
    					System.out.println(student.getUsername() + ": " + EEE.getName());
    				if( listofmods.contains(CT475) && !listofmods.contains(EE443) ) 
    					System.out.println(student.getUsername() + ": " + CS.getName());
    				for(Module m : listofmods) {
    					System.out.print(m.getName() + ". "); //prints student's modules
    					}
    				System.out.println("");
    				}
    				}
    			}
    		}
    }
    
    /**
     * Fills allstudents with 10 students
     */
	private static ArrayList<Student> createlistofStudents(ArrayList<Student> list) {
		list.add(new Student("Jack Smith", 1, 02, 1994));
		list.add(new Student("Eamon Dunphy", 12, 06, 1993));
		list.add(new Student("Jeff Hendrick", 5, 11, 1991));
		list.add(new Student("Wes Hoolahan", 13, 9, 1992));
		list.add(new Student("Seamus Coleman", 1, 12, 1994));
		list.add(new Student("Gareth Bale", 4, 9, 1990));
		list.add(new Student("William Hill", 14, 05, 1995));
		list.add(new Student("James Byrne", 19, 8, 1998));
		list.add(new Student("Alice Coleman", 21, 03, 1993));
		list.add(new Student("Shauna Bourke", 19, 11, 1994));		
		
		return list;
	}
}
