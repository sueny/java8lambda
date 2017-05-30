
package java8lambda;

public class MethodReferenceExample1 {

    public static void main(String[] args) {
        Thread t = new Thread(MethodReferenceExample1::printMessage); // () -> method()
        
        t.start();
    }
    
    public static void printMessage(){
        System.out.println("hello");
    }
}
