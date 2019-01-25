package AutoTesting.Project;

import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Admin\\Desktop\\Eclipse WS\\Project\\formAccurate.feature" )
public class ProjectRunner {
public static ExtentReports report = new ExtentReports(Constants.getReportfilepath()+Constants.getReportfilename());
	
	public static int counter = 0;
}
