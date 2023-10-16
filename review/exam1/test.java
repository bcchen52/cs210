public class test 
{
    
    public static void main(String args[]){
        School s = new School("Binghamton");
    
        Person p1 = new Person("Bob", 20);
        p1.toString();

        Person p2 = new Person("Jim", 25);

        Student s1 = new Student("Mike", 21);
        s1.toString();
        System.out.println(s1.getName());


        Person s2 = new Student("Kevin", 20);

        System.out.println(s2.toString());
        System.out.println(s2.getClass());
        s2.exercise(50);

        s.addPerson(p1);
        s.addPerson(p2);
        s.addPerson(s1);
        s.addPerson(s2);

        s.printRoster();
        /*
        Person p;
        p = new Person("hello", 15);
        p.exercise(10);
        Student s;
        s = new Student("hello", 12, "Stuy", "s,s");
        System.out.println(s.toString());
        */
    } 
    







}