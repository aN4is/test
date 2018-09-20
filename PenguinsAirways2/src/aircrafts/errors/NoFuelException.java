package aircrafts.errors;

public class NoFuelException extends RuntimeException {

    public NoFuelException(String message) {
        super(message);
    }


    //since we've added a constuctor with parameter default constuctor is gone, and we have to create it explicitely
    //so if you pass a message parameter to throw new NoFuelException("Your_message") then 1st constructor will be called, if not then default one
    public NoFuelException() {
    }
}
