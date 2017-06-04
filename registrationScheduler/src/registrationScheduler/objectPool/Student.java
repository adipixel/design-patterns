package registrationScheduler.objectPool;

import java.util.List;

import registrationScheduler.util.Logger;

import java.util.ArrayList;

public class Student {
	public String name;
	public List<String> prefer = new ArrayList<String>();
	public int pref_score = 0;
	public List<String> allocated = new ArrayList<String>();
	
	/**
	 * It is the constructor of this class Student
	 * 
	 * @param  nameIn	the name or number of student
	 * @param  pref1In	the first course preference
	 * @param  pref2In	the second course preference
	 * @param  pref3In	the third course preference
	 * @param  pref4In	the fourth course preference
	 * @param  pref5In	the fifth course preference
	 * @return      none
	 */
	public Student()
	{
		//constructor
		Logger.writeMessage("In Student, constructor", Logger.DebugLevel.CONSTRUCTOR);
	}
	public Student(String nameIn, String pref1In, String pref2In, String pref3In, String pref4In, String pref5In) {
		name = nameIn;
		prefer.add(0, pref1In);
		prefer.add(1, pref2In);
		prefer.add(2, pref3In);
		prefer.add(3, pref4In);
		prefer.add(4, pref5In);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", prefer=" + prefer + ", pref_score=" + pref_score + ", allocated="
				+ allocated + "]";
	}

	
}