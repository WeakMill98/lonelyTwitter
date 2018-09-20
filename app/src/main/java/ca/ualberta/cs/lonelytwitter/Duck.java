package ca.ualberta.cs.lonelytwitter;

public class Duck extends Animal implements FlyingBehavior{
    String flystatus;

    public void fly(){
        this.flystatus = "I love to fly";
    }
}
