package java8lambda;

public class Java8lambda {

    public void greet(Greeting greeting) {
        greeting.perform();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Java8lambda j8l = new Java8lambda();
        
        Greeting lambdaGreeting = () -> System.out.println("Hello world lambda!");
        
        Greeting innerClassGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello world!");
            }
        };
        
        j8l.greet(lambdaGreeting);
        j8l.greet(innerClassGreeting);
    }
    
}
