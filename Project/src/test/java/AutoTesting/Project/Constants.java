package AutoTesting.Project;

public class Constants {
	
	private static final String DRIVERLOC = "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe";
	
	private static final String URL1 = "http://localhost:3000/";
	
	private static final String reportFilepath = "C:\\Users\\Admin\\Desktop\\Testing Exam Reports\\";
	
	private static final String reportFileName = "ProjectTesting.html";
	


	public static String getUrl1() {
		return URL1;
	}

	public static String getReportfilepath() {
		return reportFilepath;
	}

	public static String getReportfilename() {
		return reportFileName;
	}


	public static String getDriverloc() {
		return DRIVERLOC;
	}
	
	

}


