package Testcase;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class Login extends BaseClass{

    @Test
    public void passTest() throws IOException, InterruptedException {
        test = extent.startTest("TC001");
        takeScreenShot("TC001");
        Thread.sleep(5000);
        takeScreenShot("TC002");
        openNotification();
        Thread.sleep(5000);
        closeNotification();
        Thread.sleep(5000);

        test.log(LogStatus.PASS, "Pass");
        Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
    }

    @Test
    public void passTest1() throws IOException, InterruptedException {
        test = extent.startTest("TC002");
        takeScreenShot("TC001");
        Thread.sleep(5000);
        takeScreenShot("TC002");
        openNotification();
        Thread.sleep(5000);
        closeNotification();
        Thread.sleep(5000);

        test.log(LogStatus.PASS, "Pass");
        Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
    }

}
