import java.util.ArrayList;

public class School
{
    private String name;
    private ArrayList<Person> attendees;

    public School(){
        attendees = new ArrayList<Person>();
    }

    public School(String n){
        this();
        name = n;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Person> getAttendees(){
        return attendees;
    }

    public void addPerson(Person p ){
        attendees.add(p);
    }

    public void printRoster(){
        for( Person p: attendees){
            System.out.println(p.toString());
            System.out.println(p.getClass());
        }
    }
}