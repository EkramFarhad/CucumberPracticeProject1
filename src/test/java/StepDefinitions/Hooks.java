package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

// hooks is a pre- and post-condition which is not care the code in between
public class Hooks extends CommonMethods {
    @Before

    public void preCondition() {
        openBrowserAndLaunchApplication();
    }

    @After
    public void postCondition(Scenario scenario) throws InterruptedException {

        byte[] pic;
        if (scenario.isFailed()) {
            pic = takeScreenshot("failed/" + scenario.getName());
        } else {
            pic = takeScreenshot("passed/" + scenario.getName());
        }

        scenario.attach(pic, "image/png", scenario.getName());


        Thread.sleep(8000);
        closeBrowser();
    }

    //Hooks:


}
