public class Person implements Person_I
{
    private String name;
    private int age;

    public Person(String n, int a){
        name = n;
        age = a;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getAge()
    {
        return age;
    }

    @Override
    public void exercise(int time)
    {
        System.out.println("The " + name + " went running for " + time + " minutes");
    }

    @Override
    public String toString()
    {
        return "A person named " + name + " that is " + age + " years old";
    }

}