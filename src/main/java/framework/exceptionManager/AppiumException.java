package framework.exceptionManager;

public class AppiumException extends Exception{
    public AppiumException() {
        super("Unable to start/stop the appium instance");
    }
}
