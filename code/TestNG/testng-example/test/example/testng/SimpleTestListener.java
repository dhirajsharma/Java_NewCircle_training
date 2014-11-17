package example.testng;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class SimpleTestListener extends TestListenerAdapter {
    private int charCounter = 0;

    @Override
    public void onTestFailure(ITestResult testResult) {
        this.log('F');
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        this.log('S');
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        this.log('.');
    }

    private void log(char ch) {
        System.out.print(ch);
        if (++this.charCounter % 75 == 0) {
            System.out.println();
        }
    }
}
