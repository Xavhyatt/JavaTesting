package com.qa.quickstart.AutomatedTestingExam;

public class Constants {
	
	private static final String url1 = "http://localhost:8080/";
	
	private static final String reportFilepath = "C:\\Users\\Admin\\Desktop\\Testing Exam Reports\\";
	
	private static final String reportFileName = "JenkinsTesting.html";
	
	private static final String dataFilepath = "C:\\Users\\Admin\\Desktop\\Testing Exam Reports\\";
	
	private static final String dataFileName = "ExamTestResults.xlsx";
	
	private static final String userName = "LastBreath";
	
	private static final String password = "testing";

	private static final String fullName = "Xav Hyatt";

	private static final String email = "xavier.hyatt@academytrainee.com";

	public static String getUsername() {
		return userName;
	}

	public static String getPassword() {
		return password;
	}

	public static String getFullname() {
		return fullName;
	}

	public static String getEmail() {
		return email;
	}

	public static String getUrl1() {
		return url1;
	}

	public static String getReportfilepath() {
		return reportFilepath;
	}

	public static String getReportfilename() {
		return reportFileName;
	}

	public static String getDatafilepath() {
		return dataFilepath;
	}

	public static String getDatafilename() {
		return dataFileName;
	}
	

}


