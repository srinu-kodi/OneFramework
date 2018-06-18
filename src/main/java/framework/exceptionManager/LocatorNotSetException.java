package framework.exceptionManager;

public class LocatorNotSetException extends Exception{
    public LocatorNotSetException() {
        super("Either locator was not set or not found");
    }
}
