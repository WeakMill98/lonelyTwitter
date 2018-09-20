package ca.ualberta.cs.lonelytwitter;

// Can be accessed from anywhere in the program
public class Student {
    private String name;
    private int age;

    // CTOR
    // Example of overloading as the names are the same but parameters are different
    public Student(){
    }

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }


    // Allows for you to modify and control the type of input
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

}
