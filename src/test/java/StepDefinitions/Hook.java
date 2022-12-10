package StepDefinitions;


import Utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
    DriverManager driverManager = new DriverManager();

    @Before
    public void beforeScenario(){
        System.out.println("The execution Start Now");
    }

    @After
    public void afterScenario(){
      driverManager.closeBrowser();
      System.out.println("The execution End");
    }
}
