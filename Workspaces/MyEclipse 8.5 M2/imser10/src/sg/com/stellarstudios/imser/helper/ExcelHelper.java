package sg.com.stellarstudios.imser.helper;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import sg.com.stellarstudios.imser.common.GlobalKeys;
import sg.com.stellarstudios.imser.common.Utility;
import sg.com.stellarstudios.imser.entity.UserRegistration;

public class ExcelHelper extends BaseHelper {
	public void writeEvaluationForms(List userRegistrations, OutputStream os) {
		HSSFWorkbook wb = null;
		wb = new HSSFWorkbook();

		final String[]tableHeader = {"First Name","Last Name","Title","Company","Email","Track",
				"Song Tang Yih PQ","Song Tang Yih CR","John McAdam PQ","John McAdam CR",
				"Dan Matte PQ","Dan Matte CR","Erik Giesa PQ","Erik Giesa CR",
				"Darien Nagle PQ","Darien Nagle CR","Mark Fabbi PQ","Mark Fabbi CR",
				"Erik Giesa PQ","Erik Giesa CR","Mark Anderson PQ","Mark Anderson CR",
				"Michael Dodds PQ","Michael Dodds CR",
				"Jack Poon PQ","Jack Poon CR","Jason Needham PQ","Jason Needham CR",
				"Calvin Rowland PQ","Calvin Rowland CR","Sean Wong PQ","Sean Wong CR",
				"Vladimir Yordanov PQ","Vladimir Yordanov CR","Martin Wooding PQ","Martin Wooding CR",
				"Sean Wong PQ","Sean Wong CR","Jason Needham 1 PQ","Jason Needham 1 CR",
				"Colin Walker PQ","Colin Walker CR","Jason Needham 2 PQ","Jason Needham 2 CR",
				
				"Business Track - 1st APAC Partner Advisory Council Agenda/Format","Business Track - 1st APAC Partner Advisory Council CR",
				"Will you participate again?","Morning Session Comments",
				
				"Welcome Cocktail","Hi-5 Pump it Up Awards Party","Third F5 Hi-5 Golf Tournament",
				"Go-Kart","Horse Back Riding","Spa Indrani","City Tour","Social Events Comments",
				
				"Ground transportation quality","Ground transportation ease of use",
				"Your hotel room comfort","Your hotel room cleanliness",
				"Event food quality","Event food tastiness",
				"Hotel service overall politeness","Hotel service overall usefulness",
				"Hi-5 2008 Registration Desk usefulness","Hi-5 2008 Registration Desk hours of operations","Hi-5 2008 Registration Desk staff",
				"Hotel/F5 service comments",
				
				"Usefulness of the event for my business","Level of enjoyment I got from Hi-5 2008","Length of event","Logistics",
				"Look and feel","Pre-event communications","On-site communications","Event website","Event comments"};

		//start processing
		HSSFSheet sheet = wb.createSheet(GlobalKeys.EXCEL_OUTPUT_WORKSHEET);
		HSSFRow row=null;
		HSSFCell cell=null;

		int rowCount = 0;
		row = sheet.createRow(rowCount);
		
		HSSFCellStyle headerStyle = wb.createCellStyle();
		HSSFFont headerFont = wb.createFont();
		headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headerStyle.setFont(headerFont);
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		for (int columnCount = 0; columnCount < tableHeader.length; columnCount++) {
			cell = row.createCell((short)columnCount);
			cell.setCellStyle(headerStyle);
			cell.setCellValue(tableHeader[columnCount]);
		}
		rowCount++;
		
		for (Iterator itr = userRegistrations.iterator(); itr.hasNext(); ) {
			UserRegistration userRegistration = (UserRegistration) itr.next();

			row = sheet.createRow(rowCount);
			//go thru' columns
			for (int columnCount = 0; columnCount < tableHeader.length; columnCount++) {
				cell = row.createCell((short)columnCount);

				switch (columnCount) {
				case 0:
					if (userRegistration.getFirstName() != null)
						cell.setCellValue(userRegistration.getFirstName());
					break;
				case 1:
					if (userRegistration.getLastName() != null)
						cell.setCellValue(userRegistration.getLastName());
					break;
				case 2:
					if (userRegistration.getTitle() != null)
						cell.setCellValue(userRegistration.getTitle());
					break;
				case 3:
					if (userRegistration.getCompany() != null)
						cell.setCellValue(userRegistration.getCompany());
					break;
				case 4:
					if (userRegistration.getUser().getEmail() != null)
						cell.setCellValue(userRegistration.getUser().getEmail());
					break;
				case 5:
					if (userRegistration.getTrack() != null) {
						String track = "";
						if (userRegistration.getTrack() == 1) track = "Sales Track";
						if (userRegistration.getTrack() == 2) track = "Technical Track";
						if (userRegistration.getTrack() == 3) track = "Business Track";
						if (userRegistration.getTrack() == 4) track = "Did not attend";
						cell.setCellValue(track);
					}
					break;
				case 6:
					if (userRegistration.getSpeaker01Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker01Pq());
					break;
				case 7:
					if (userRegistration.getSpeaker01Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker01Cr());
					break;
				case 8:
					if (userRegistration.getSpeaker02Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker02Pq());
					break;
				case 9:
					if (userRegistration.getSpeaker02Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker02Cr());
					break;
				case 10:
					if (userRegistration.getSpeaker03Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker03Pq());
					break;
				case 11:
					if (userRegistration.getSpeaker03Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker03Cr());
					break;
				case 12:
					if (userRegistration.getSpeaker04Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker04Pq());
					break;
				case 13:
					if (userRegistration.getSpeaker04Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker04Cr());
					break;
				case 14:
					if (userRegistration.getSpeaker05Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker05Pq());
					break;
				case 15:
					if (userRegistration.getSpeaker05Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker05Cr());
					break;
				case 16:
					if (userRegistration.getSpeaker06Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker06Pq());
					break;
				case 17:
					if (userRegistration.getSpeaker06Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker06Cr());
					break;
				case 18:
					if (userRegistration.getSpeaker07Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker07Pq());
					break;
				case 19:
					if (userRegistration.getSpeaker07Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker07Cr());
					break;
				case 20:
					if (userRegistration.getSpeaker08Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker08Pq());
					break;
				case 21:
					if (userRegistration.getSpeaker08Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker08Cr());
					break;
				case 22:
					if (userRegistration.getSpeaker09Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker09Pq());
					break;
				case 23:
					if (userRegistration.getSpeaker09Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker09Cr());
					break;
				case 24:
					if (userRegistration.getSpeaker10Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker10Pq());
					break;
				case 25:
					if (userRegistration.getSpeaker10Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker10Cr());
					break;
				case 26:
					if (userRegistration.getSpeaker11Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker11Pq());
					break;
				case 27:
					if (userRegistration.getSpeaker11Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker11Cr());
					break;
				case 28:
					if (userRegistration.getSpeaker12Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker12Pq());
					break;
				case 29:
					if (userRegistration.getSpeaker12Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker12Cr());
					break;
				case 30:
					if (userRegistration.getSpeaker13Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker13Pq());
					break;
				case 31:
					if (userRegistration.getSpeaker13Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker13Cr());
					break;
				case 32:
					if (userRegistration.getSpeaker14Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker14Pq());
					break;
				case 33:
					if (userRegistration.getSpeaker14Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker14Cr());
					break;
				case 34:
					if (userRegistration.getSpeaker15Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker15Pq());
					break;
				case 35:
					if (userRegistration.getSpeaker15Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker15Cr());
					break;
				case 36:
					if (userRegistration.getSpeaker16Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker16Pq());
					break;
				case 37:
					if (userRegistration.getSpeaker16Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker16Cr());
					break;
				case 38:
					if (userRegistration.getSpeaker17Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker17Pq());
					break;
				case 39:
					if (userRegistration.getSpeaker17Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker17Cr());
					break;
				case 40:
					if (userRegistration.getSpeaker18Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker18Pq());
					break;
				case 41:
					if (userRegistration.getSpeaker18Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker18Cr());
					break;
				case 42:
					if (userRegistration.getSpeaker19Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker19Pq());
					break;
				case 43:
					if (userRegistration.getSpeaker19Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker19Cr());
					break;
				case 44:
					if (userRegistration.getSpeaker20Pq() != null)
						cell.setCellValue(userRegistration.getSpeaker20Pq());
					break;
				case 45:
					if (userRegistration.getSpeaker20Cr() != null)
						cell.setCellValue(userRegistration.getSpeaker20Cr());
					break;
				case 46:
					if (userRegistration.getParticipateAgain() != null)
						cell.setCellValue(((userRegistration.getParticipateAgain())?"Yes":"No"));
					break;
				case 47:
					if (userRegistration.getCommentsMorning() != null)
						cell.setCellValue(userRegistration.getCommentsMorning());
					break;
				case 48:
					if (userRegistration.getNetworking01() != null)
						cell.setCellValue(userRegistration.getNetworking01());
					break;
				case 49:
					if (userRegistration.getNetworking02() != null) {
						if (userRegistration.getNetworking02() == 6) 
							cell.setCellValue("Did not attend");
						else
							cell.setCellValue(userRegistration.getNetworking02());
					}
					break;
				case 50:
					if (userRegistration.getNetworking03() != null) {
						if (userRegistration.getNetworking03() == 6) 
							cell.setCellValue("Did not attend");
						else
							cell.setCellValue(userRegistration.getNetworking03());
					}
				case 51:
					if (userRegistration.getNetworking04() != null) {
						if (userRegistration.getNetworking04() == 6) 
							cell.setCellValue("Did not attend");
						else
							cell.setCellValue(userRegistration.getNetworking04());
					}
				case 52:
					if (userRegistration.getNetworking05() != null) {
						if (userRegistration.getNetworking05() == 6) 
							cell.setCellValue("Did not attend");
						else
							cell.setCellValue(userRegistration.getNetworking05());
					}
				case 53:
					if (userRegistration.getNetworking06() != null) {
						if (userRegistration.getNetworking06() == 6) 
							cell.setCellValue("Did not attend");
						else
							cell.setCellValue(userRegistration.getNetworking06());
					}
				case 54:
					if (userRegistration.getNetworking07() != null) {
						if (userRegistration.getNetworking07() == 6) 
							cell.setCellValue("Did not attend");
						else
							cell.setCellValue(userRegistration.getNetworking07());
					}
				case 55:
					if (userRegistration.getCommentsNetworking() != null)
						cell.setCellValue(userRegistration.getCommentsNetworking());
					break;
				
				case 56:
					if (userRegistration.getServices01a() != null)
						cell.setCellValue(userRegistration.getServices01a());
					break;
				case 57:
					if (userRegistration.getServices01b() != null)
						cell.setCellValue(userRegistration.getServices01b());
					break;
				case 58:
					if (userRegistration.getServices02a() != null)
						cell.setCellValue(userRegistration.getServices02a());
					break;
				case 59:
					if (userRegistration.getServices02b() != null)
						cell.setCellValue(userRegistration.getServices02b());
					break;
				case 60:
					if (userRegistration.getServices03a() != null)
						cell.setCellValue(userRegistration.getServices03a());
					break;
				case 61:
					if (userRegistration.getServices03b() != null)
						cell.setCellValue(userRegistration.getServices03b());
					break;
				case 62:
					if (userRegistration.getServices04a() != null)
						cell.setCellValue(userRegistration.getServices04a());
					break;
				case 63:
					if (userRegistration.getServices04b() != null)
						cell.setCellValue(userRegistration.getServices04b());
					break;
				case 64:
					if (userRegistration.getServices05a() != null)
						cell.setCellValue(userRegistration.getServices05a());
					break;
				case 65:
					if (userRegistration.getServices05b() != null)
						cell.setCellValue(userRegistration.getServices05b());
					break;
				case 66:
					if (userRegistration.getServices05c() != null)
						cell.setCellValue(userRegistration.getServices05c());
					break;
				case 67:
					if (userRegistration.getCommentsServices() != null)
						cell.setCellValue(userRegistration.getCommentsServices());
					break;
				case 68:
					if (userRegistration.getGeneral01() != null)
						cell.setCellValue(userRegistration.getGeneral01());
					break;
				case 69:
					if (userRegistration.getGeneral02() != null)
						cell.setCellValue(userRegistration.getGeneral02());
					break;
				case 70:
					if (userRegistration.getGeneral03() != null)
						cell.setCellValue(userRegistration.getGeneral03());
					break;
				case 71:
					if (userRegistration.getGeneral04() != null)
						cell.setCellValue(userRegistration.getGeneral04());
					break;
				case 72:
					if (userRegistration.getGeneral05() != null)
						cell.setCellValue(userRegistration.getGeneral05());
					break;
				case 73:
					if (userRegistration.getGeneral06() != null)
						cell.setCellValue(userRegistration.getGeneral06());
					break;
				case 74:
					if (userRegistration.getGeneral07() != null)
						cell.setCellValue(userRegistration.getGeneral07());
					break;
				case 75:
					if (userRegistration.getGeneral08() != null)
						cell.setCellValue(userRegistration.getGeneral08());
					break;
				case 76:
					if (userRegistration.getCommentsGeneral() != null)
						cell.setCellValue(userRegistration.getCommentsGeneral());
					break;
		
				} //end switch
			}
			
			rowCount++;
		}
		
		try { wb.write(os); }
		catch (IOException e) { e.printStackTrace(); }
		finally {
			try { os.close(); }
			catch (IOException e) { e.printStackTrace(); }
		}
	}
	public void write(List userRegistrations, OutputStream os) {
		HSSFWorkbook wb = null;
		wb = new HSSFWorkbook();

		final String[]tableHeader = {"First Name","Last Name","Title","Company","Address 1","Address 2",
				"Postal Code","Email","Country","City","Phone","Fax","Special Dietary Needs","Special Needs",
				"Shirt Size","From Malaysia?","Arrival Airline","Arrival Flight No.","Arrival Date","Arrival Time",
				"Special Arrival Rqmt","Departure Airline","Departure Flight No.","Departure Date",
				"Departure Time","Special Departure Rqmt","Checkin Date","Checkout Date","Smoking Room",
				"Track","Cool Down Biz Social Event","No. of Handicap","Approved","Date Submitted","Time Submitted"};

		//start processing
		HSSFSheet sheet = wb.createSheet(GlobalKeys.EXCEL_OUTPUT_WORKSHEET);
		HSSFRow row=null;
		HSSFCell cell=null;

		int rowCount = 0;
		row = sheet.createRow(rowCount);
		
		HSSFCellStyle headerStyle = wb.createCellStyle();
		HSSFFont headerFont = wb.createFont();
		headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headerStyle.setFont(headerFont);
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		for (int columnCount = 0; columnCount < tableHeader.length; columnCount++) {
			cell = row.createCell((short)columnCount);
			cell.setCellStyle(headerStyle);
			cell.setCellValue(tableHeader[columnCount]);
		}
		rowCount++;
		
		for (Iterator itr = userRegistrations.iterator(); itr.hasNext(); ) {
			UserRegistration userRegistration = (UserRegistration) itr.next();

			row = sheet.createRow(rowCount);
			//go thru' columns
			for (int columnCount = 0; columnCount < tableHeader.length; columnCount++) {
				cell = row.createCell((short)columnCount);

				switch (columnCount) {
				case 0:
					if (userRegistration.getFirstName() != null)
						cell.setCellValue(userRegistration.getFirstName());
					break;
				case 1:
					if (userRegistration.getLastName() != null)
						cell.setCellValue(userRegistration.getLastName());
					break;
				case 2:
					if (userRegistration.getTitle() != null)
						cell.setCellValue(userRegistration.getTitle());
					break;
				case 3:
					if (userRegistration.getCompany() != null)
						cell.setCellValue(userRegistration.getCompany());
					break;
				case 4:
					if (userRegistration.getAddress1() != null)
						cell.setCellValue(userRegistration.getAddress1());
					break;
				case 5:
					if (userRegistration.getAddress2() != null)
						cell.setCellValue(userRegistration.getAddress2());
					break;
				case 6:
					if (userRegistration.getPostalCode() != null)
						cell.setCellValue(userRegistration.getPostalCode());
					break;
				case 7:
					if (userRegistration.getUser().getEmail() != null)
						cell.setCellValue(userRegistration.getUser().getEmail());
					break;
				case 8:
					if (userRegistration.getCountry() != null)
						cell.setCellValue(userRegistration.getCountry().getName());
					break;
				case 9:
					if (userRegistration.getCity() != null)
						cell.setCellValue(userRegistration.getCity());
					break;
				case 10:
					if (userRegistration.getPhone() != null)
						cell.setCellValue(userRegistration.getPhone());
					break;
				case 11:
					if (userRegistration.getFax() != null)
						cell.setCellValue(userRegistration.getFax());
					break;
				case 12:
					if (userRegistration.getAdditionalInfoSpecialDietaryNeeds() != null)
						cell.setCellValue(userRegistration.getAdditionalInfoSpecialDietaryNeeds());
					break;
				case 13:
					if (userRegistration.getAdditionalInfoSpecialNeeds() != null)
						cell.setCellValue(userRegistration.getAdditionalInfoSpecialNeeds());
					break;
				case 14:
					if (userRegistration.getShirtSize() != null)
						cell.setCellValue(userRegistration.getShirtSize());
					break;
				case 15:
					if (userRegistration.getFromSingapore() != null)
						cell.setCellValue((userRegistration.getFromSingapore())?"Yes":"No");
					break;
				case 16:
					if (userRegistration.getFlightInfoArrivalAirline() != null)
						cell.setCellValue(userRegistration.getFlightInfoArrivalAirline());
					break;
				case 17:
					if (userRegistration.getFlightInfoArrivalFlightNo() != null)
						cell.setCellValue(userRegistration.getFlightInfoArrivalFlightNo());
					break;
				case 18:
					if (userRegistration.getFlightInfoArrivalDate() != null)
						cell.setCellValue(Utility.getInstance().buildStringFromCalendar(userRegistration.getFlightInfoArrivalDate()));
					break;
				case 19:
					if (userRegistration.getFlightInfoArrivalTime() != null)
						cell.setCellValue(userRegistration.getFlightInfoArrivalTime());
					break;
				case 20:
					if (userRegistration.getFlightInfoSpecialArrivalRqmt() != null)
						cell.setCellValue(userRegistration.getFlightInfoSpecialArrivalRqmt());
					break;
				case 21:
					if (userRegistration.getFlightInfoDepartureAirline() != null)
						cell.setCellValue(userRegistration.getFlightInfoDepartureAirline());
					break;
				case 22:
					if (userRegistration.getFlightInfoDepartureFlightNo() != null)
						cell.setCellValue(userRegistration.getFlightInfoDepartureFlightNo());
					break;
				case 23:
					if (userRegistration.getFlightInfoDepartureDate() != null)
						cell.setCellValue(Utility.getInstance().buildStringFromCalendar(userRegistration.getFlightInfoDepartureDate()));
					break;
				case 24:
					if (userRegistration.getFlightInfoDepartureTime() != null)
						cell.setCellValue(userRegistration.getFlightInfoDepartureTime());
					break;
				case 25:
					if (userRegistration.getFlightInfoSpecialDepartureRqmt() != null)
						cell.setCellValue(userRegistration.getFlightInfoSpecialDepartureRqmt());
					break;
				case 26:
					if (userRegistration.getHotelCheckinDate() != null)
						cell.setCellValue(Utility.getInstance().buildStringFromCalendar(userRegistration.getHotelCheckinDate()));
					break;
				case 27:
					if (userRegistration.getHotelCheckoutDate() != null)
						cell.setCellValue(Utility.getInstance().buildStringFromCalendar(userRegistration.getHotelCheckoutDate()));
					break;
				case 28:
					if (userRegistration.getHotelSmokingRoom() != null)
						cell.setCellValue((userRegistration.getHotelSmokingRoom())?"Yes":"No");
					break;
				case 29:
					if (userRegistration.getTrack() != null) {
						String track = "";
						if (userRegistration.getTrack() == 1) track = "Sales Track";
						if (userRegistration.getTrack() == 2) track = "Technical Track";
						if (userRegistration.getTrack() == 3) track = "Business Track";
						cell.setCellValue(track);
					}
					break;
				case 30:
					if (userRegistration.getCoolDownSocialEvents() != null) {
						String coolDownBizSocialEvent = "";
						if (userRegistration.getCoolDownSocialEvents() == 1) coolDownBizSocialEvent = "Third F5 Hi-5 Golf Tournament";
						if (userRegistration.getCoolDownSocialEvents() == 2) coolDownBizSocialEvent = "Go-Kart at Sepang International Circuit";
						if (userRegistration.getCoolDownSocialEvents() == 3) coolDownBizSocialEvent = "Horse Back Riding at Taman Equnie Club";
						if (userRegistration.getCoolDownSocialEvents() == 4) coolDownBizSocialEvent = "Spa Indrani @ StarHill Gallery";
						if (userRegistration.getCoolDownSocialEvents() == 5) coolDownBizSocialEvent = "City Tour of Kuala Lumpur";						
						if (userRegistration.getCoolDownSocialEvents() == 6) coolDownBizSocialEvent = "None of the Above";
						cell.setCellValue(coolDownBizSocialEvent);
					}
					break;
				case 31:
					if (userRegistration.getGolfNoOfHandicap() != null && userRegistration.getCoolDownSocialEvents() != null && userRegistration.getCoolDownSocialEvents() == 1)
						cell.setCellValue(userRegistration.getGolfNoOfHandicap());
					break;
				case 32:
					if (userRegistration.getApprovedStatus() != null) {
						String approvedStatus = "";
						if (userRegistration.getApprovedStatus() == GlobalKeys.REGISTRATION_APPROVED) approvedStatus = "Approved";
						if (userRegistration.getApprovedStatus() == GlobalKeys.REGISTRATION_NOT_APPROVED_YET) approvedStatus = "Not Approved Yet";
						if (userRegistration.getApprovedStatus() == GlobalKeys.REGISTRATION_DISAPPROVED) approvedStatus = "Rejected";						
						cell.setCellValue(approvedStatus);
					}
					break;
				case 33:
					cell.setCellValue(Utility.getInstance().buildStringFromCalendar(userRegistration.getDateSaved()));
					break;
				case 34:				
					StringBuffer time = new StringBuffer();
					time.append(Utility.getInstance().buildDigitNumber(userRegistration.getDateSaved().get(Calendar.HOUR_OF_DAY),2) + ":" + Utility.getInstance().buildDigitNumber(userRegistration.getDateSaved().get(Calendar.MINUTE),2));
					cell.setCellValue(time.toString());
					break;
				} //end switch
			}
			
			rowCount++;
		}
		
		try { wb.write(os); }
		catch (IOException e) { e.printStackTrace(); }
		finally {
			try { os.close(); }
			catch (IOException e) { e.printStackTrace(); }
		}
	}
	public static void main(String[]args) {
		for (int i = 100; i < 150; i++) {
		System.out.println("<form-property name=\"spnidesc" + i + "\" type=\"java.lang.String\" initial=\"\"/>");
		System.out.println("<form-property name=\"spnipos" + i + "\" type=\"java.lang.String\" initial=\"\"/>");
		System.out.println("<form-property name=\"spniqty" + i + "\" type=\"java.lang.String\" initial=\"\"/>");
		System.out.println("<form-property name=\"spnicond" + i + "\" type=\"java.lang.String\" initial=\"\"/>");
		System.out.println("<form-property name=\"spniwe" + i + "\" type=\"java.lang.String\" initial=\"\"/>");
		System.out.println("<form-property name=\"spniore" + i + "\" type=\"java.lang.String\" initial=\"\"/>");
		}
	}
}
