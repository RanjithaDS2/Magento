package analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//public class RetryAnalyzer implements IRetryAnalyzer{
 /*
	int counter =0;
	int retryLimit=3;
	
	public boolean retry(ITestResult result)
	{
		if(counter<retryLimit)
		{
			counter++;
			System.out.println("Retrying " + result.getName() + "again the issue is" +(counter+1));
			return true;
		}
		else
		{
			return false;
		}
	}
	*/
	
	
	public class RetryAnalyzer implements IRetryAnalyzer {
	    private int retryCount = 0;
	    private static final int maxRetryCount = 2; // Set your retry count here
	 
	    @Override
	    public boolean retry(ITestResult result) {
	        if (retryCount < maxRetryCount) {
	            retryCount++;
	            return true;
	        }
	        return false;
	    }
	
}
