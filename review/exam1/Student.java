import java.io.*;
import java.util.ArrayList;

public class Student extends Person
{
    private String school;
    private ArrayList<String> classes;

    /*
    public Student(String name, int age, String schl, String clss)
    {
        super(name, age);
        school = schl;
        
        classes = new ArrayList<String>();
        String[] lass = clss.split(",");
        for( int i = 0; i < lass.length; i++)
        {
            classes.add(lass[i]);

        }
    }
    */

    public Student(String name, int age)
    {
        super(name, age);
        school = "";
        
        classes = new ArrayList<String>();
  
    }

    public String getSchool()
    {
        return school;
    }

    public ArrayList<String> getClasses()
    {
        return classes;
    }

    @Override
    public String toString()
    {
        return super.toString() + " and is a student at " + school;
    }
    
    @Override
    public void exercise(int time)
    {
        System.out.println("The student exercises for " + time + " minutes");
    }
}
