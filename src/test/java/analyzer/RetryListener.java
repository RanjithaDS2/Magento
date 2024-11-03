package analyzer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.IRetryAnalyzer;
 
public class RetryListener implements IAnnotationTransformer{
	
	
	    @Override
	    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	        // Check if the retry analyzer is already set, if not, set it
	        if (annotation.getRetryAnalyzerClass() == null) {
	            annotation.setRetryAnalyzer(RetryAnalyzer.class);
	        }
	    }
	}

