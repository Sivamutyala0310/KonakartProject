package com.atmecs.konakart.dataallocators;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.konakart.constants.ConstantFilePaths;
import com.atmecs.konakart.utils.ReadLocatorsFile;

public class KonaKartValidationDataAllocators
{
	String expectedProductDescription;
	String expectedspecificationsTab;
	String expectedFilterRecentDate;
	String expectedFilterPastdate;
	
	Properties properties;
	public void getData() throws IOException {
		properties = ReadLocatorsFile.loadProperty(ConstantFilePaths.ValidationTESTDATA_FILE);
		setExpectedProductDescription();
		setExpectedspecificationsTab();
		setExpectedFilterRecentDate();
		setExpectedFilterPastdate();
		
		
		
		
	}
	
	public String getExpectedProductDescription() {
		return expectedProductDescription;
	}
	public void setExpectedProductDescription() {
		expectedProductDescription = properties.getProperty("expectedProductDescription");
	}
	public String getExpectedspecificationsTab() {
		return expectedspecificationsTab;
	}
	public void setExpectedspecificationsTab() {
		expectedspecificationsTab = properties.getProperty("expectedspecificationsTab");
	}
	public String getExpectedFilterRecentDate() {
		return expectedFilterRecentDate;
	}
	public void setExpectedFilterRecentDate() {
		expectedFilterRecentDate = properties.getProperty("expectedFilterRecentDate");
	}
	public String getExpectedFilterPastdate() {
		return expectedFilterPastdate;
	}
	public void setExpectedFilterPastdate() {
		expectedFilterPastdate = properties.getProperty("expectedFilterPastdate");
	}
	public static void main(String[] args) throws IOException {
		KonaKartValidationDataAllocators  keys = new KonaKartValidationDataAllocators ();
		keys.getData();
	}
	
	
	
}
