package sg.com.stellarstudios.imser.entity;

import java.util.Calendar;

/**
 * UserRegistration generated by MyEclipse Persistence Tools
 */

public class UserRegistration extends
		sg.com.stellarstudios.imser.entity.BaseEntity implements
		java.io.Serializable {

	// Fields

	private Integer id;

	private User user;

	private Country country;

	private String firstName;

	private String lastName;

	private String title;

	private String company;

	private String address1;

	private String address2;

	private String city;

	private String postalCode;

	private String phone;

	private String fax;

	private String additionalInfoSpecialDietaryNeeds;

	private String additionalInfoSpecialNeeds;

	private String shirtSize;

	private Boolean fromSingapore;

	private String flightInfoArrivalAirline;

	private String flightInfoArrivalFlightNo;

	private Calendar flightInfoArrivalDate;

	private String flightInfoArrivalTime;

	private String flightInfoSpecialArrivalRqmt;

	private String flightInfoDepartureAirline;

	private String flightInfoDepartureFlightNo;

	private Calendar flightInfoDepartureDate;

	private String flightInfoDepartureTime;

	private String flightInfoSpecialDepartureRqmt;

	private Calendar hotelCheckinDate;

	private Calendar hotelCheckoutDate;

	private Boolean hotelSmokingRoom;

	private Integer track;

	private Integer coolDownSocialEvents;

	private Integer golfNoOfHandicap;

	private Integer registrationStatus;

	private Calendar dateSaved;

	private Integer approvedStatus;

	private Boolean f5Staff;

	private Boolean privilegedUser;

	private Integer speaker01Pq;

	private Integer speaker01Cr;

	private Integer speaker02Pq;

	private Integer speaker02Cr;

	private Integer speaker03Pq;

	private Integer speaker03Cr;

	private Integer speaker04Pq;

	private Integer speaker04Cr;

	private Integer speaker05Pq;

	private Integer speaker05Cr;

	private Integer speaker06Pq;

	private Integer speaker06Cr;

	private Integer speaker07Pq;

	private Integer speaker07Cr;

	private Integer speaker08Pq;

	private Integer speaker08Cr;

	private Integer speaker09Pq;

	private Integer speaker09Cr;

	private Integer speaker10Pq;

	private Integer speaker10Cr;

	private Integer speaker11Pq;

	private Integer speaker11Cr;

	private Integer speaker12Pq;

	private Integer speaker12Cr;

	private Integer speaker13Pq;

	private Integer speaker13Cr;

	private Integer speaker14Pq;

	private Integer speaker14Cr;

	private Integer speaker15Pq;

	private Integer speaker15Cr;

	private Integer speaker16Pq;

	private Integer speaker16Cr;

	private Integer speaker17Pq;

	private Integer speaker17Cr;

	private Integer speaker18Pq;

	private Integer speaker18Cr;

	private Integer speaker19Pq;

	private Integer speaker19Cr;

	private Integer speaker20Pq;

	private Integer speaker20Cr;

	private Integer speaker21Pq;

	private Integer speaker21Cr;

	private Integer speaker22Pq;

	private Integer speaker22Cr;
	
	private Boolean participateAgain;

	private String commentsMorning;

	private Integer networking01;

	private Integer networking02;

	private Integer networking03;

	private Integer networking04;

	private Integer networking05;

	private Integer networking06;

	private Integer networking07;

	private String commentsNetworking;

	private Integer services01a;

	private Integer services01b;

	private Integer services02a;

	private Integer services02b;

	private Integer services03a;

	private Integer services03b;

	private Integer services04a;

	private Integer services04b;

	private Integer services05a;

	private Integer services05b;

	private Integer services05c;

	private String commentsServices;

	private Integer general01;

	private Integer general02;

	private Integer general03;

	private Integer general04;

	private Integer general05;

	private Integer general06;

	private Integer general07;

	private Integer general08;

	private String commentsGeneral;

	private Boolean completedEvaluation;
	
	private Calendar dateCompletedEvaluation;
	
	//	not persisted
	
	private String flightInfoArrivalTimeHour;
	
	private String flightInfoArrivalTimeMinute;
	
	private String flightInfoDepartureTimeHour;
	
	private String flightInfoDepartureTimeMinute;
	
	//overloaded methods
	public String getName() { return getFirstName() + ", " + getLastName(); }

	// Constructors

	/** default constructor */
	public UserRegistration() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public void setId(Object id) {
    	if (id.getClass().isAssignableFrom(String[].class)) this.id = new Integer(((String[])id)[0]);
    	else this.id = (Integer)id;
    }

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAdditionalInfoSpecialDietaryNeeds() {
		return this.additionalInfoSpecialDietaryNeeds;
	}

	public void setAdditionalInfoSpecialDietaryNeeds(
			String additionalInfoSpecialDietaryNeeds) {
		this.additionalInfoSpecialDietaryNeeds = additionalInfoSpecialDietaryNeeds;
	}

	public String getAdditionalInfoSpecialNeeds() {
		return this.additionalInfoSpecialNeeds;
	}

	public void setAdditionalInfoSpecialNeeds(String additionalInfoSpecialNeeds) {
		this.additionalInfoSpecialNeeds = additionalInfoSpecialNeeds;
	}

	public String getShirtSize() {
		return this.shirtSize;
	}

	public void setShirtSize(String shirtSize) {
		this.shirtSize = shirtSize;
	}

	public Boolean getFromSingapore() {
		return this.fromSingapore;
	}

	public void setFromSingapore(Boolean fromSingapore) {
		this.fromSingapore = fromSingapore;
	}

	public String getFlightInfoArrivalAirline() {
		return this.flightInfoArrivalAirline;
	}

	public void setFlightInfoArrivalAirline(String flightInfoArrivalAirline) {
		this.flightInfoArrivalAirline = flightInfoArrivalAirline;
	}

	public String getFlightInfoArrivalFlightNo() {
		return this.flightInfoArrivalFlightNo;
	}

	public void setFlightInfoArrivalFlightNo(String flightInfoArrivalFlightNo) {
		this.flightInfoArrivalFlightNo = flightInfoArrivalFlightNo;
	}

	public Calendar getFlightInfoArrivalDate() {
		return this.flightInfoArrivalDate;
	}

	public void setFlightInfoArrivalDate(Calendar flightInfoArrivalDate) {
		this.flightInfoArrivalDate = flightInfoArrivalDate;
	}

	public String getFlightInfoArrivalTime() {
		return this.flightInfoArrivalTime;
	}

	public void setFlightInfoArrivalTime(String flightInfoArrivalTime) {
		this.flightInfoArrivalTime = flightInfoArrivalTime;
	}

	public String getFlightInfoSpecialArrivalRqmt() {
		return this.flightInfoSpecialArrivalRqmt;
	}

	public void setFlightInfoSpecialArrivalRqmt(
			String flightInfoSpecialArrivalRqmt) {
		this.flightInfoSpecialArrivalRqmt = flightInfoSpecialArrivalRqmt;
	}

	public String getFlightInfoDepartureAirline() {
		return this.flightInfoDepartureAirline;
	}

	public void setFlightInfoDepartureAirline(String flightInfoDepartureAirline) {
		this.flightInfoDepartureAirline = flightInfoDepartureAirline;
	}

	public String getFlightInfoDepartureFlightNo() {
		return this.flightInfoDepartureFlightNo;
	}

	public void setFlightInfoDepartureFlightNo(
			String flightInfoDepartureFlightNo) {
		this.flightInfoDepartureFlightNo = flightInfoDepartureFlightNo;
	}

	public Calendar getFlightInfoDepartureDate() {
		return this.flightInfoDepartureDate;
	}

	public void setFlightInfoDepartureDate(Calendar flightInfoDepartureDate) {
		this.flightInfoDepartureDate = flightInfoDepartureDate;
	}

	public String getFlightInfoDepartureTime() {
		return this.flightInfoDepartureTime;
	}

	public void setFlightInfoDepartureTime(String flightInfoDepartureTime) {
		this.flightInfoDepartureTime = flightInfoDepartureTime;
	}

	public String getFlightInfoSpecialDepartureRqmt() {
		return this.flightInfoSpecialDepartureRqmt;
	}

	public void setFlightInfoSpecialDepartureRqmt(
			String flightInfoSpecialDepartureRqmt) {
		this.flightInfoSpecialDepartureRqmt = flightInfoSpecialDepartureRqmt;
	}

	public Calendar getHotelCheckinDate() {
		return this.hotelCheckinDate;
	}

	public void setHotelCheckinDate(Calendar hotelCheckinDate) {
		this.hotelCheckinDate = hotelCheckinDate;
	}

	public Calendar getHotelCheckoutDate() {
		return this.hotelCheckoutDate;
	}

	public void setHotelCheckoutDate(Calendar hotelCheckoutDate) {
		this.hotelCheckoutDate = hotelCheckoutDate;
	}

	public Boolean getHotelSmokingRoom() {
		return this.hotelSmokingRoom;
	}

	public void setHotelSmokingRoom(Boolean hotelSmokingRoom) {
		this.hotelSmokingRoom = hotelSmokingRoom;
	}

	public Integer getTrack() {
		return this.track;
	}

	public void setTrack(Integer track) {
		this.track = track;
	}

	public Integer getCoolDownSocialEvents() {
		return this.coolDownSocialEvents;
	}

	public void setCoolDownSocialEvents(Integer coolDownSocialEvents) {
		this.coolDownSocialEvents = coolDownSocialEvents;
	}

	public Integer getGolfNoOfHandicap() {
		return this.golfNoOfHandicap;
	}

	public void setGolfNoOfHandicap(Integer golfNoOfHandicap) {
		this.golfNoOfHandicap = golfNoOfHandicap;
	}

	public Integer getRegistrationStatus() {
		return this.registrationStatus;
	}

	public void setRegistrationStatus(Integer registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	public Calendar getDateSaved() {
		return this.dateSaved;
	}

	public void setDateSaved(Calendar dateSaved) {
		this.dateSaved = dateSaved;
	}

	public Integer getApprovedStatus() {
		return this.approvedStatus;
	}

	public void setApprovedStatus(Integer approvedStatus) {
		this.approvedStatus = approvedStatus;
	}

	public Boolean getF5Staff() {
		return this.f5Staff;
	}

	public void setF5Staff(Boolean f5Staff) {
		this.f5Staff = f5Staff;
	}

	public Boolean getPrivilegedUser() {
		return this.privilegedUser;
	}

	public void setPrivilegedUser(Boolean privilegedUser) {
		this.privilegedUser = privilegedUser;
	}

	public Integer getSpeaker01Pq() {
		return this.speaker01Pq;
	}

	public void setSpeaker01Pq(Integer speaker01Pq) {
		this.speaker01Pq = speaker01Pq;
	}

	public Integer getSpeaker01Cr() {
		return this.speaker01Cr;
	}

	public void setSpeaker01Cr(Integer speaker01Cr) {
		this.speaker01Cr = speaker01Cr;
	}

	public Integer getSpeaker02Pq() {
		return this.speaker02Pq;
	}

	public void setSpeaker02Pq(Integer speaker02Pq) {
		this.speaker02Pq = speaker02Pq;
	}

	public Integer getSpeaker02Cr() {
		return this.speaker02Cr;
	}

	public void setSpeaker02Cr(Integer speaker02Cr) {
		this.speaker02Cr = speaker02Cr;
	}

	public Integer getSpeaker03Pq() {
		return this.speaker03Pq;
	}

	public void setSpeaker03Pq(Integer speaker03Pq) {
		this.speaker03Pq = speaker03Pq;
	}

	public Integer getSpeaker03Cr() {
		return this.speaker03Cr;
	}

	public void setSpeaker03Cr(Integer speaker03Cr) {
		this.speaker03Cr = speaker03Cr;
	}

	public Integer getSpeaker04Pq() {
		return this.speaker04Pq;
	}

	public void setSpeaker04Pq(Integer speaker04Pq) {
		this.speaker04Pq = speaker04Pq;
	}

	public Integer getSpeaker04Cr() {
		return this.speaker04Cr;
	}

	public void setSpeaker04Cr(Integer speaker04Cr) {
		this.speaker04Cr = speaker04Cr;
	}

	public Integer getSpeaker05Pq() {
		return this.speaker05Pq;
	}

	public void setSpeaker05Pq(Integer speaker05Pq) {
		this.speaker05Pq = speaker05Pq;
	}

	public Integer getSpeaker05Cr() {
		return this.speaker05Cr;
	}

	public void setSpeaker05Cr(Integer speaker05Cr) {
		this.speaker05Cr = speaker05Cr;
	}

	public Integer getSpeaker06Pq() {
		return this.speaker06Pq;
	}

	public void setSpeaker06Pq(Integer speaker06Pq) {
		this.speaker06Pq = speaker06Pq;
	}

	public Integer getSpeaker06Cr() {
		return this.speaker06Cr;
	}

	public void setSpeaker06Cr(Integer speaker06Cr) {
		this.speaker06Cr = speaker06Cr;
	}

	public Integer getSpeaker07Pq() {
		return this.speaker07Pq;
	}

	public void setSpeaker07Pq(Integer speaker07Pq) {
		this.speaker07Pq = speaker07Pq;
	}

	public Integer getSpeaker07Cr() {
		return this.speaker07Cr;
	}

	public void setSpeaker07Cr(Integer speaker07Cr) {
		this.speaker07Cr = speaker07Cr;
	}

	public Integer getSpeaker08Pq() {
		return this.speaker08Pq;
	}

	public void setSpeaker08Pq(Integer speaker08Pq) {
		this.speaker08Pq = speaker08Pq;
	}

	public Integer getSpeaker08Cr() {
		return this.speaker08Cr;
	}

	public void setSpeaker08Cr(Integer speaker08Cr) {
		this.speaker08Cr = speaker08Cr;
	}

	public Integer getSpeaker09Pq() {
		return this.speaker09Pq;
	}

	public void setSpeaker09Pq(Integer speaker09Pq) {
		this.speaker09Pq = speaker09Pq;
	}

	public Integer getSpeaker09Cr() {
		return this.speaker09Cr;
	}

	public void setSpeaker09Cr(Integer speaker09Cr) {
		this.speaker09Cr = speaker09Cr;
	}

	public Integer getSpeaker10Pq() {
		return this.speaker10Pq;
	}

	public void setSpeaker10Pq(Integer speaker10Pq) {
		this.speaker10Pq = speaker10Pq;
	}

	public Integer getSpeaker10Cr() {
		return this.speaker10Cr;
	}

	public void setSpeaker10Cr(Integer speaker10Cr) {
		this.speaker10Cr = speaker10Cr;
	}

	public Integer getSpeaker11Pq() {
		return this.speaker11Pq;
	}

	public void setSpeaker11Pq(Integer speaker11Pq) {
		this.speaker11Pq = speaker11Pq;
	}

	public Integer getSpeaker11Cr() {
		return this.speaker11Cr;
	}

	public void setSpeaker11Cr(Integer speaker11Cr) {
		this.speaker11Cr = speaker11Cr;
	}

	public Integer getSpeaker12Pq() {
		return this.speaker12Pq;
	}

	public void setSpeaker12Pq(Integer speaker12Pq) {
		this.speaker12Pq = speaker12Pq;
	}

	public Integer getSpeaker12Cr() {
		return this.speaker12Cr;
	}

	public void setSpeaker12Cr(Integer speaker12Cr) {
		this.speaker12Cr = speaker12Cr;
	}

	public Integer getSpeaker13Pq() {
		return this.speaker13Pq;
	}

	public void setSpeaker13Pq(Integer speaker13Pq) {
		this.speaker13Pq = speaker13Pq;
	}

	public Integer getSpeaker13Cr() {
		return this.speaker13Cr;
	}

	public void setSpeaker13Cr(Integer speaker13Cr) {
		this.speaker13Cr = speaker13Cr;
	}

	public Integer getSpeaker14Pq() {
		return this.speaker14Pq;
	}

	public void setSpeaker14Pq(Integer speaker14Pq) {
		this.speaker14Pq = speaker14Pq;
	}

	public Integer getSpeaker14Cr() {
		return this.speaker14Cr;
	}

	public void setSpeaker14Cr(Integer speaker14Cr) {
		this.speaker14Cr = speaker14Cr;
	}

	public Integer getSpeaker15Pq() {
		return this.speaker15Pq;
	}

	public void setSpeaker15Pq(Integer speaker15Pq) {
		this.speaker15Pq = speaker15Pq;
	}

	public Integer getSpeaker15Cr() {
		return this.speaker15Cr;
	}

	public void setSpeaker15Cr(Integer speaker15Cr) {
		this.speaker15Cr = speaker15Cr;
	}

	public Integer getSpeaker16Pq() {
		return this.speaker16Pq;
	}

	public void setSpeaker16Pq(Integer speaker16Pq) {
		this.speaker16Pq = speaker16Pq;
	}

	public Integer getSpeaker16Cr() {
		return this.speaker16Cr;
	}

	public void setSpeaker16Cr(Integer speaker16Cr) {
		this.speaker16Cr = speaker16Cr;
	}

	public Integer getSpeaker17Pq() {
		return this.speaker17Pq;
	}

	public void setSpeaker17Pq(Integer speaker17Pq) {
		this.speaker17Pq = speaker17Pq;
	}

	public Integer getSpeaker17Cr() {
		return this.speaker17Cr;
	}

	public void setSpeaker17Cr(Integer speaker17Cr) {
		this.speaker17Cr = speaker17Cr;
	}

	public Integer getSpeaker18Pq() {
		return this.speaker18Pq;
	}

	public void setSpeaker18Pq(Integer speaker18Pq) {
		this.speaker18Pq = speaker18Pq;
	}

	public Integer getSpeaker18Cr() {
		return this.speaker18Cr;
	}

	public void setSpeaker18Cr(Integer speaker18Cr) {
		this.speaker18Cr = speaker18Cr;
	}

	public Integer getSpeaker19Pq() {
		return this.speaker19Pq;
	}

	public void setSpeaker19Pq(Integer speaker19Pq) {
		this.speaker19Pq = speaker19Pq;
	}

	public Integer getSpeaker19Cr() {
		return this.speaker19Cr;
	}

	public void setSpeaker19Cr(Integer speaker19Cr) {
		this.speaker19Cr = speaker19Cr;
	}

	public Integer getSpeaker20Pq() {
		return this.speaker20Pq;
	}

	public void setSpeaker20Pq(Integer speaker20Pq) {
		this.speaker20Pq = speaker20Pq;
	}

	public Integer getSpeaker20Cr() {
		return this.speaker20Cr;
	}

	public void setSpeaker20Cr(Integer speaker20Cr) {
		this.speaker20Cr = speaker20Cr;
	}

	public Integer getSpeaker21Pq() {
		return this.speaker21Pq;
	}

	public void setSpeaker21Pq(Integer speaker21Pq) {
		this.speaker21Pq = speaker21Pq;
	}

	public Integer getSpeaker21Cr() {
		return this.speaker21Cr;
	}

	public void setSpeaker21Cr(Integer speaker21Cr) {
		this.speaker21Cr = speaker21Cr;
	}

	public Integer getSpeaker22Pq() {
		return this.speaker22Pq;
	}

	public void setSpeaker22Pq(Integer speaker22Pq) {
		this.speaker22Pq = speaker22Pq;
	}

	public Integer getSpeaker22Cr() {
		return this.speaker22Cr;
	}

	public void setSpeaker22Cr(Integer speaker22Cr) {
		this.speaker22Cr = speaker22Cr;
	}

	public String getCommentsMorning() {
		return this.commentsMorning;
	}

	public void setCommentsMorning(String commentsMorning) {
		this.commentsMorning = commentsMorning;
	}

	public Integer getNetworking01() {
		return this.networking01;
	}

	public void setNetworking01(Integer networking01) {
		this.networking01 = networking01;
	}

	public Integer getNetworking02() {
		return this.networking02;
	}

	public void setNetworking02(Integer networking02) {
		this.networking02 = networking02;
	}

	public Integer getNetworking03() {
		return this.networking03;
	}

	public void setNetworking03(Integer networking03) {
		this.networking03 = networking03;
	}

	public Integer getNetworking04() {
		return this.networking04;
	}

	public void setNetworking04(Integer networking04) {
		this.networking04 = networking04;
	}

	public Integer getNetworking05() {
		return this.networking05;
	}

	public void setNetworking05(Integer networking05) {
		this.networking05 = networking05;
	}

	public Integer getNetworking06() {
		return this.networking06;
	}

	public void setNetworking06(Integer networking06) {
		this.networking06 = networking06;
	}

	public Integer getNetworking07() {
		return this.networking07;
	}

	public void setNetworking07(Integer networking07) {
		this.networking07 = networking07;
	}

	public String getCommentsNetworking() {
		return this.commentsNetworking;
	}

	public void setCommentsNetworking(String commentsNetworking) {
		this.commentsNetworking = commentsNetworking;
	}

	public Integer getServices01a() {
		return this.services01a;
	}

	public void setServices01a(Integer services01a) {
		this.services01a = services01a;
	}

	public Integer getServices01b() {
		return this.services01b;
	}

	public void setServices01b(Integer services01b) {
		this.services01b = services01b;
	}

	public Integer getServices02a() {
		return this.services02a;
	}

	public void setServices02a(Integer services02a) {
		this.services02a = services02a;
	}

	public Integer getServices02b() {
		return this.services02b;
	}

	public void setServices02b(Integer services02b) {
		this.services02b = services02b;
	}

	public Integer getServices03a() {
		return this.services03a;
	}

	public void setServices03a(Integer services03a) {
		this.services03a = services03a;
	}

	public Integer getServices03b() {
		return this.services03b;
	}

	public void setServices03b(Integer services03b) {
		this.services03b = services03b;
	}

	public Integer getServices04a() {
		return this.services04a;
	}

	public void setServices04a(Integer services04a) {
		this.services04a = services04a;
	}

	public Integer getServices04b() {
		return this.services04b;
	}

	public void setServices04b(Integer services04b) {
		this.services04b = services04b;
	}

	public Integer getServices05a() {
		return this.services05a;
	}

	public void setServices05a(Integer services05a) {
		this.services05a = services05a;
	}

	public Integer getServices05b() {
		return this.services05b;
	}

	public void setServices05b(Integer services05b) {
		this.services05b = services05b;
	}

	public Integer getServices05c() {
		return this.services05c;
	}

	public void setServices05c(Integer services05c) {
		this.services05c = services05c;
	}

	public String getCommentsServices() {
		return this.commentsServices;
	}

	public void setCommentsServices(String commentsServices) {
		this.commentsServices = commentsServices;
	}

	public Integer getGeneral01() {
		return this.general01;
	}

	public void setGeneral01(Integer general01) {
		this.general01 = general01;
	}

	public Integer getGeneral02() {
		return this.general02;
	}

	public void setGeneral02(Integer general02) {
		this.general02 = general02;
	}

	public Integer getGeneral03() {
		return this.general03;
	}

	public void setGeneral03(Integer general03) {
		this.general03 = general03;
	}

	public Integer getGeneral04() {
		return this.general04;
	}

	public void setGeneral04(Integer general04) {
		this.general04 = general04;
	}

	public Integer getGeneral05() {
		return this.general05;
	}

	public void setGeneral05(Integer general05) {
		this.general05 = general05;
	}

	public Integer getGeneral06() {
		return this.general06;
	}

	public void setGeneral06(Integer general06) {
		this.general06 = general06;
	}

	public Integer getGeneral07() {
		return this.general07;
	}

	public void setGeneral07(Integer general07) {
		this.general07 = general07;
	}

	public Integer getGeneral08() {
		return this.general08;
	}

	public void setGeneral08(Integer general08) {
		this.general08 = general08;
	}

	public String getCommentsGeneral() {
		return this.commentsGeneral;
	}

	public void setCommentsGeneral(String commentsGeneral) {
		this.commentsGeneral = commentsGeneral;
	}

	public String getFlightInfoArrivalTimeHour() {
		return flightInfoArrivalTimeHour;
	}

	public void setFlightInfoArrivalTimeHour(String flightInfoArrivalTimeHour) {
		this.flightInfoArrivalTimeHour = flightInfoArrivalTimeHour;
	}

	public String getFlightInfoArrivalTimeMinute() {
		return flightInfoArrivalTimeMinute;
	}

	public void setFlightInfoArrivalTimeMinute(String flightInfoArrivalTimeMinute) {
		this.flightInfoArrivalTimeMinute = flightInfoArrivalTimeMinute;
	}

	public String getFlightInfoDepartureTimeHour() {
		return flightInfoDepartureTimeHour;
	}

	public void setFlightInfoDepartureTimeHour(String flightInfoDepartureTimeHour) {
		this.flightInfoDepartureTimeHour = flightInfoDepartureTimeHour;
	}

	public String getFlightInfoDepartureTimeMinute() {
		return flightInfoDepartureTimeMinute;
	}

	public void setFlightInfoDepartureTimeMinute(
			String flightInfoDepartureTimeMinute) {
		this.flightInfoDepartureTimeMinute = flightInfoDepartureTimeMinute;
	}

	public Boolean getCompletedEvaluation() {
		return completedEvaluation;
	}

	public void setCompletedEvaluation(Boolean completedEvaluation) {
		this.completedEvaluation = completedEvaluation;
	}

	public Calendar getDateCompletedEvaluation() {
		return dateCompletedEvaluation;
	}

	public void setDateCompletedEvaluation(Calendar dateCompletedEvaluation) {
		this.dateCompletedEvaluation = dateCompletedEvaluation;
	}

	public Boolean getParticipateAgain() {
		return participateAgain;
	}

	public void setParticipateAgain(Boolean participateAgain) {
		this.participateAgain = participateAgain;
	}


}