package framework.core;

import framework.exceptionManager.LocatorNotSetException;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;

public class Actions extends Page{

    public void scrollTo(HashMap<String, HashMap> locatorMap) throws LocatorNotSetException {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", getLocator(locatorMap));
    }

    public void scrollUp() {

    }

    public void scrollUp(int scrollTimes) {

    }

    public void scrollDown() {

    }

    public void scrollDown(int scrollTimes) {

    }

    public void swipleLeft() {

    }

    public void swipleLeft(int swipeTimes) {

    }

    public void swipleRight() {

    }

    public void swipleRight(int swipeTimes) {

    }

    public void zoomIn() {

    }

    public void zoomOut() {

    }
}
