package Testcase;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(String filePath) {
        if (extent == null) {
            extent = new ExtentReports(filePath, true);
            extent
                    .addSystemInfo("Host Name", "Leon Pin")
                    .addSystemInfo("Environment", "QA Engineer")
                    .addSystemInfo("Version", "1.0 Build 24");
        }
        return extent;
    }
}