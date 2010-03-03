package sg.com.stellarstudios.imser.web.struts.action;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts.util.LabelValueBean;
import org.directwebremoting.WebContextFactory;

import sg.com.stellarstudios.imser.common.GlobalKeys;
import sg.com.stellarstudios.imser.common.Utility;
import sg.com.stellarstudios.imser.entity.BaseEntity;
import sg.com.stellarstudios.imser.entity.Country;
import sg.com.stellarstudios.imser.entity.User;
import sg.com.stellarstudios.imser.entity.UserRegistration;
import sg.com.stellarstudios.imser.entity.search.PickCriteria;
import sg.com.stellarstudios.imser.entity.search.SearchCriteria;
import sg.com.stellarstudios.imser.exception.ServiceException;
import sg.com.stellarstudios.imser.helper.ExcelHelper;
import sg.com.stellarstudios.imser.service.UserRegistrationService;
import sg.com.stellarstudios.imser.web.common.WebConstants;
import sg.com.stellarstudios.imser.web.common.WebKeys;
import sg.com.stellarstudios.imser.web.struts.ModelDrivenAction;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.Validateable;

public class UserRegistrationAction extends ModelDrivenAction implements Preparable, Validateable {
	private static final String ACTIONCOMMAND_MAKENEW = "makeNew";
	private static final String ACTIONCOMMAND_SAVEONLY = "saveOnly";
	private static final Integer NONE_OF_THE_ABOVE = 6;
	
	private Integer userRegistrationId; 
	private ExcelHelper excelHelper;
	private String emails, emailSubject;

	public void prepare() throws Exception {
		super.prepare();
	}

	public void validateUpdateEvaluationForm() {
		UserRegistration model = (UserRegistration)getModel();

		if (model.getSpeaker01Pq() == null || model.getSpeaker01Pq() == 0) super.addFieldError("speaker01Pq", super.getText("error.requiredstring"));
		if (model.getSpeaker01Cr() == null || model.getSpeaker01Cr() == 0) super.addFieldError("speaker01Cr", super.getText("error.requiredstring"));
		if (model.getSpeaker02Pq() == null || model.getSpeaker02Pq() == 0) super.addFieldError("speaker02Pq", super.getText("error.requiredstring"));
		if (model.getSpeaker02Cr() == null || model.getSpeaker02Cr() == 0) super.addFieldError("speaker02Cr", super.getText("error.requiredstring"));
		if (model.getSpeaker03Pq() == null || model.getSpeaker03Pq() == 0) super.addFieldError("speaker03Pq", super.getText("error.requiredstring"));
		if (model.getSpeaker03Cr() == null || model.getSpeaker03Cr() == 0) super.addFieldError("speaker03Cr", super.getText("error.requiredstring"));
		if (model.getSpeaker04Pq() == null || model.getSpeaker04Pq() == 0) super.addFieldError("speaker04Pq", super.getText("error.requiredstring"));
		if (model.getSpeaker04Cr() == null || model.getSpeaker04Cr() == 0) super.addFieldError("speaker04Cr", super.getText("error.requiredstring"));
		if (model.getSpeaker05Pq() == null || model.getSpeaker05Pq() == 0) super.addFieldError("speaker05Pq", super.getText("error.requiredstring"));
		if (model.getSpeaker05Cr() == null || model.getSpeaker05Cr() == 0) super.addFieldError("speaker05Cr", super.getText("error.requiredstring"));
		if (model.getSpeaker06Pq() == null || model.getSpeaker06Pq() == 0) super.addFieldError("speaker06Pq", super.getText("error.requiredstring"));
		if (model.getSpeaker06Cr() == null || model.getSpeaker06Cr() == 0) super.addFieldError("speaker06Cr", super.getText("error.requiredstring"));
		if (model.getSpeaker07Pq() == null || model.getSpeaker07Pq() == 0) super.addFieldError("speaker07Pq", super.getText("error.requiredstring"));
		if (model.getSpeaker07Cr() == null || model.getSpeaker07Cr() == 0) super.addFieldError("speaker07Cr", super.getText("error.requiredstring"));
		if (model.getSpeaker08Pq() == null || model.getSpeaker08Pq() == 0) super.addFieldError("speaker08Pq", super.getText("error.requiredstring"));
		if (model.getSpeaker08Cr() == null || model.getSpeaker08Cr() == 0) super.addFieldError("speaker08Cr", super.getText("error.requiredstring"));
		if (model.getSpeaker09Pq() == null || model.getSpeaker09Pq() == 0) super.addFieldError("speaker09Pq", super.getText("error.requiredstring"));
		if (model.getSpeaker09Cr() == null || model.getSpeaker09Cr() == 0) super.addFieldError("speaker09Cr", super.getText("error.requiredstring"));
		if (model.getSpeaker10Pq() == null || model.getSpeaker10Pq() == 0) super.addFieldError("speaker10Pq", super.getText("error.requiredstring"));
		if (model.getSpeaker10Cr() == null || model.getSpeaker10Cr() == 0) super.addFieldError("speaker10Cr", super.getText("error.requiredstring"));
		
		if (model.getTrack() == null || model.getTrack() == 0) super.addFieldError("track", super.getText("error.requiredstring"));

		if (model.getTrack() != null && model.getTrack() == 1) {
			if (model.getSpeaker11Pq() == null || model.getSpeaker11Pq() == 0) super.addFieldError("speaker11Pq", super.getText("error.requiredstring"));
			if (model.getSpeaker11Cr() == null || model.getSpeaker11Cr() == 0) super.addFieldError("speaker11Cr", super.getText("error.requiredstring"));
			if (model.getSpeaker12Pq() == null || model.getSpeaker12Pq() == 0) super.addFieldError("speaker12Pq", super.getText("error.requiredstring"));
			if (model.getSpeaker12Cr() == null || model.getSpeaker12Cr() == 0) super.addFieldError("speaker12Cr", super.getText("error.requiredstring"));
			if (model.getSpeaker13Pq() == null || model.getSpeaker13Pq() == 0) super.addFieldError("speaker13Pq", super.getText("error.requiredstring"));
			if (model.getSpeaker13Cr() == null || model.getSpeaker13Cr() == 0) super.addFieldError("speaker13Cr", super.getText("error.requiredstring"));
			if (model.getSpeaker14Pq() == null || model.getSpeaker14Pq() == 0) super.addFieldError("speaker14Pq", super.getText("error.requiredstring"));
			if (model.getSpeaker14Cr() == null || model.getSpeaker14Cr() == 0) super.addFieldError("speaker14Cr", super.getText("error.requiredstring"));
			if (model.getSpeaker15Pq() == null || model.getSpeaker15Pq() == 0) super.addFieldError("speaker15Pq", super.getText("error.requiredstring"));
			if (model.getSpeaker15Cr() == null || model.getSpeaker15Cr() == 0) super.addFieldError("speaker15Cr", super.getText("error.requiredstring"));
			model.setSpeaker16Pq(null);
			model.setSpeaker16Cr(null);
			model.setSpeaker17Pq(null);
			model.setSpeaker17Cr(null);
			model.setSpeaker18Pq(null);
			model.setSpeaker18Cr(null);
			model.setSpeaker19Pq(null);
			model.setSpeaker19Cr(null);
			model.setSpeaker20Pq(null);
			model.setSpeaker20Cr(null);
			model.setParticipateAgain(null);
		}
		if (model.getTrack() != null && model.getTrack() == 2) {
			if (model.getSpeaker16Pq() == null || model.getSpeaker16Pq() == 0) super.addFieldError("speaker16Pq", super.getText("error.requiredstring"));
			if (model.getSpeaker16Cr() == null || model.getSpeaker16Cr() == 0) super.addFieldError("speaker16Cr", super.getText("error.requiredstring"));
			if (model.getSpeaker17Pq() == null || model.getSpeaker17Pq() == 0) super.addFieldError("speaker17Pq", super.getText("error.requiredstring"));
			if (model.getSpeaker17Cr() == null || model.getSpeaker17Cr() == 0) super.addFieldError("speaker17Cr", super.getText("error.requiredstring"));
			if (model.getSpeaker18Pq() == null || model.getSpeaker18Pq() == 0) super.addFieldError("speaker18Pq", super.getText("error.requiredstring"));
			if (model.getSpeaker18Cr() == null || model.getSpeaker18Cr() == 0) super.addFieldError("speaker18Cr", super.getText("error.requiredstring"));
			if (model.getSpeaker19Pq() == null || model.getSpeaker19Pq() == 0) super.addFieldError("speaker19Pq", super.getText("error.requiredstring"));
			if (model.getSpeaker19Cr() == null || model.getSpeaker19Cr() == 0) super.addFieldError("speaker19Cr", super.getText("error.requiredstring"));
			model.setSpeaker11Pq(null);
			model.setSpeaker11Cr(null);
			model.setSpeaker12Pq(null);
			model.setSpeaker12Cr(null);
			model.setSpeaker13Pq(null);
			model.setSpeaker13Cr(null);
			model.setSpeaker14Pq(null);
			model.setSpeaker14Cr(null);
			model.setSpeaker15Pq(null);
			model.setSpeaker15Cr(null);
			model.setSpeaker20Pq(null);
			model.setSpeaker20Cr(null);
			model.setParticipateAgain(null);
		}
		if (model.getTrack() != null && model.getTrack() == 3) {
			if (model.getSpeaker20Pq() == null || model.getSpeaker20Pq() == 0) super.addFieldError("speaker20Pq", super.getText("error.requiredstring"));
			if (model.getSpeaker20Cr() == null || model.getSpeaker20Cr() == 0) super.addFieldError("speaker20Cr", super.getText("error.requiredstring"));
			if (model.getParticipateAgain() == null) super.addFieldError("participateAgain", super.getText("error.requiredstring"));
			model.setSpeaker11Pq(null);
			model.setSpeaker11Cr(null);
			model.setSpeaker12Pq(null);
			model.setSpeaker12Cr(null);
			model.setSpeaker13Pq(null);
			model.setSpeaker13Cr(null);
			model.setSpeaker14Pq(null);
			model.setSpeaker14Cr(null);
			model.setSpeaker15Pq(null);
			model.setSpeaker15Cr(null);
			model.setSpeaker16Pq(null);
			model.setSpeaker16Cr(null);
			model.setSpeaker17Pq(null);
			model.setSpeaker17Cr(null);
			model.setSpeaker18Pq(null);
			model.setSpeaker18Cr(null);
			model.setSpeaker19Pq(null);
			model.setSpeaker19Cr(null);			
		}
		if (model.getTrack() != null && model.getTrack() == 4) {
			model.setSpeaker11Pq(null);
			model.setSpeaker11Cr(null);
			model.setSpeaker12Pq(null);
			model.setSpeaker12Cr(null);
			model.setSpeaker13Pq(null);
			model.setSpeaker13Cr(null);
			model.setSpeaker14Pq(null);
			model.setSpeaker14Cr(null);
			model.setSpeaker15Pq(null);
			model.setSpeaker15Cr(null);
			model.setSpeaker16Pq(null);
			model.setSpeaker16Cr(null);
			model.setSpeaker17Pq(null);
			model.setSpeaker17Cr(null);
			model.setSpeaker18Pq(null);
			model.setSpeaker18Cr(null);
			model.setSpeaker19Pq(null);
			model.setSpeaker19Cr(null);	
			model.setSpeaker20Pq(null);
			model.setSpeaker20Cr(null);
			model.setParticipateAgain(null);	
		}
		
		if (model.getNetworking01() == null || model.getNetworking01() == 0) super.addFieldError("networking01", super.getText("error.requiredstring"));
		if (model.getNetworking02() == null || model.getNetworking02() == 0) super.addFieldError("networking02", super.getText("error.requiredstring"));
		if (model.getNetworking03() == null || model.getNetworking03() == 0) super.addFieldError("networking03", super.getText("error.requiredstring"));
		if (model.getNetworking04() == null || model.getNetworking04() == 0) super.addFieldError("networking04", super.getText("error.requiredstring"));
		if (model.getNetworking05() == null || model.getNetworking05() == 0) super.addFieldError("networking05", super.getText("error.requiredstring"));
		if (model.getNetworking06() == null || model.getNetworking06() == 0) super.addFieldError("networking06", super.getText("error.requiredstring"));
		if (model.getNetworking07() == null || model.getNetworking07() == 0) super.addFieldError("networking07", super.getText("error.requiredstring"));

		if (model.getServices01a() == null || model.getServices01a() == 0) super.addFieldError("services01a", super.getText("error.requiredstring"));
		if (model.getServices01b() == null || model.getServices01b() == 0) super.addFieldError("services01b", super.getText("error.requiredstring"));
		if (model.getServices02a() == null || model.getServices02a() == 0) super.addFieldError("services02a", super.getText("error.requiredstring"));
		if (model.getServices02b() == null || model.getServices02b() == 0) super.addFieldError("services02b", super.getText("error.requiredstring"));
		if (model.getServices03a() == null || model.getServices03a() == 0) super.addFieldError("services03a", super.getText("error.requiredstring"));
		if (model.getServices03b() == null || model.getServices03b() == 0) super.addFieldError("services03b", super.getText("error.requiredstring"));
		if (model.getServices04a() == null || model.getServices04a() == 0) super.addFieldError("services04a", super.getText("error.requiredstring"));
		if (model.getServices04b() == null || model.getServices04b() == 0) super.addFieldError("services04b", super.getText("error.requiredstring"));
		if (model.getServices05a() == null || model.getServices05a() == 0) super.addFieldError("services05a", super.getText("error.requiredstring"));
		if (model.getServices05b() == null || model.getServices05b() == 0) super.addFieldError("services05b", super.getText("error.requiredstring"));
		if (model.getServices05c() == null || model.getServices05c() == 0) super.addFieldError("services05c", super.getText("error.requiredstring"));

		if (model.getGeneral01() == null || model.getGeneral01() == 0) super.addFieldError("general01", super.getText("error.requiredstring"));
		if (model.getGeneral02() == null || model.getGeneral02() == 0) super.addFieldError("general02", super.getText("error.requiredstring"));
		if (model.getGeneral03() == null || model.getGeneral03() == 0) super.addFieldError("general03", super.getText("error.requiredstring"));
		if (model.getGeneral04() == null || model.getGeneral04() == 0) super.addFieldError("general04", super.getText("error.requiredstring"));
		if (model.getGeneral05() == null || model.getGeneral05() == 0) super.addFieldError("general05", super.getText("error.requiredstring"));
		if (model.getGeneral06() == null || model.getGeneral06() == 0) super.addFieldError("general06", super.getText("error.requiredstring"));
		if (model.getGeneral07() == null || model.getGeneral07() == 0) super.addFieldError("general07", super.getText("error.requiredstring"));
		if (model.getGeneral08() == null || model.getGeneral08() == 0) super.addFieldError("general08", super.getText("error.requiredstring"));
		
		if (super.getFieldErrors().size() > 0) {
			super.addActionError("Kindly fill up all required fields.");
		}
	}
	public void validate() {
		//validate these only for registration
		UserRegistration model = (UserRegistration)getModel();
		if (!request.getRequestURL().toString().contains("/updateEvaluationForm") &&
				(request.getRequestURL().toString().contains("/makeNew") || 
				(request.getRequestURL().toString().contains("/update") && model.getRegistrationStatus() == GlobalKeys.REGISTRATION_STATUS_SUBMITTED)
				)
				) {
			//if golf
			if (model.getCoolDownSocialEvents() != null && model.getCoolDownSocialEvents() == 1) {
				if (model.getGolfNoOfHandicap() == null || model.getGolfNoOfHandicap() == 0)
					super.addFieldError("golfNoOfHandicap", super.getText("error.requiredstring"));
			}

			if (model.getFromSingapore() != null && !model.getFromSingapore()) {
				if (model.getFlightInfoArrivalAirline() == null || model.getFlightInfoArrivalAirline().trim().equals(""))
					super.addFieldError("flightInfoArrivalAirline", super.getText("error.requiredstring"));
				if (model.getFlightInfoArrivalFlightNo() == null || model.getFlightInfoArrivalFlightNo().trim().equals(""))
					super.addFieldError("flightInfoArrivalFlightNo", super.getText("error.requiredstring"));
				if (model.getFlightInfoArrivalDate() == null)
					super.addFieldError("flightInfoArrivalDate", super.getText("error.requiredstring"));
				if (model.getFlightInfoArrivalTimeHour() == null || model.getFlightInfoArrivalTimeHour().trim().equals(""))
					super.addFieldError("flightInfoArrivalTimeHour", super.getText("error.requiredstring"));
				if (model.getFlightInfoArrivalTimeMinute() == null || model.getFlightInfoArrivalTimeMinute().trim().equals(""))
					super.addFieldError("flightInfoArrivalTimeMinute", super.getText("error.requiredstring"));
				
				if (model.getFlightInfoDepartureAirline() == null || model.getFlightInfoDepartureAirline().trim().equals(""))
					super.addFieldError("flightInfoDepartureAirline", super.getText("error.requiredstring"));
				if (model.getFlightInfoDepartureFlightNo() == null || model.getFlightInfoDepartureFlightNo().trim().equals(""))
					super.addFieldError("flightInfoDepartureFlightNo", super.getText("error.requiredstring"));
				if (model.getFlightInfoDepartureDate() == null)
					super.addFieldError("flightInfoDepartureDate", super.getText("error.requiredstring"));
				if (model.getFlightInfoDepartureTimeHour() == null || model.getFlightInfoDepartureTimeHour().trim().equals(""))
					super.addFieldError("flightInfoDepartureTimeHour", super.getText("error.requiredstring"));
				if (model.getFlightInfoDepartureTimeMinute() == null || model.getFlightInfoDepartureTimeMinute().trim().equals(""))
					super.addFieldError("flightInfoDepartureTimeMinute", super.getText("error.requiredstring"));
			}
			
			//check if social activity exceeds limit
			try {
				//event max cap is 0 indexed. hence must minus 1.
				//if not None of the Above
				if (model.getCoolDownSocialEvents() != null && model.getCoolDownSocialEvents() != NONE_OF_THE_ABOVE &&
						((UserRegistrationService)service).retrieveCountByCoolDownSocialEvent(model.getCoolDownSocialEvents(),model.getId()).intValue() >= GlobalKeys.EVENT_MAX_CAP[model.getCoolDownSocialEvents()-1]) {
					//noneed to add cos once return, preload update will add.
					super.addActionError("The social event that you have selected is full. Kindly select another event.");
					//add a token into session to indicate its already added so preload update need not check again.
					session.put(WebKeys.ACTION_ERROR_ALREADY_ADDED, new Boolean(true));
					model.setCoolDownSocialEvents(0);
				}
			}
			catch (ServiceException e) { }
			
			if (super.getFieldErrors().size() > 0) {
				super.addActionError("Kindly fill up all required fields.");
			}
		}
	}
	
	//****************************** STRUTS 2 METHODS ********************************
		// EVALUATION FORM
	public String preloadEvaluationForm() throws Exception {
		super.buildPagePreloadData("preloadEvaluationForm", getModel());

		return "preloadEvaluationForm";
	}

	public String updateEvaluationForm() throws Exception {
		intercept("updateEvaluationForm", params, formData, session, getModel());
		setModel(((UserRegistrationService)service).update(getModel()));
		
		request.setAttribute("justCompletedEvaluationForm", new Boolean(true));
		
		session.put(WebKeys.USER_OBJECT_PRINCIPAL, ((UserRegistration)getModel()).getUser());
		request.setAttribute(WebKeys.ACTION_COMMAND, "updateEvaluationForm");
		return "updateEvaluationForm";
	}
		// REMINDER EMAIL
	public String preloadReminderEmail() throws Exception {
		return "preloadReminderEmail";
	}
	public String sendReminderEmail() throws Exception {
		((UserRegistrationService)service).sendReminderEmail(emails,emailSubject);
		super.addActionMessage("Email sent successfully!");
		return "preloadReminderEmail";
	}
		// EXCEL TEMPLATE
	public String retrieveAllEvaluationForms() throws Exception {
		List userRegistrations = ((UserRegistrationService)service).retrieveAllUserRegistrationsWhoCompletedEvaluationForm();
		prepareResponse(response, "AllEvaluationForms");
		excelHelper.writeEvaluationForms(userRegistrations, response.getOutputStream());
		return null;
	}
	public String retrieveAllSubmitted() throws Exception {
		List userRegistrations = ((UserRegistrationService)service).retrieveAll(GlobalKeys.REGISTRATION_STATUS_SUBMITTED);
		prepareResponse(response, "AllSubmitted");
		excelHelper.write(userRegistrations, response.getOutputStream());
		return null;
	}
	
	public String retrieveAllSaved() throws Exception {
		List userRegistrations = ((UserRegistrationService)service).retrieveAll(GlobalKeys.REGISTRATION_STATUS_SAVED);
		prepareResponse(response, "AllSaved");
		excelHelper.write(userRegistrations, response.getOutputStream());
		return null;
	}
	
	public String retrieveByDateSubmitted() throws Exception {
		String date = params.get("date").toString();
		prepareResponse(response, "SubmittedByDate");
		List userRegistrations = ((UserRegistrationService)service).retrieveSubmitted(date);
		excelHelper.write(userRegistrations, response.getOutputStream());
		return null;
	}
	
	private void prepareResponse(HttpServletResponse response,String filenamePrefix) {
		response.setContentType(Utility.getInstance().resolveContentType("0.xls"));
		//set file name if the file when download
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filenamePrefix + "_" +
				Utility.getInstance().buildStringFromCalendar(Calendar.getInstance()).replace('/','-') + "_" +
				Utility.getInstance().buildDigitNumber(Calendar.getInstance().get(Calendar.HOUR_OF_DAY), 2) +
				Utility.getInstance().buildDigitNumber(Calendar.getInstance().get(Calendar.MINUTE), 2) +
				Utility.getInstance().buildDigitNumber(Calendar.getInstance().get(Calendar.SECOND), 2) +
				".xls\"");
	}
	
	public String preloadSelectTemplate() throws Exception {
		super.buildPagePreloadData("preloadSelectTemplate", getModel());

		request.setAttribute(WebKeys.ACTION_COMMAND, "preloadSelectTemplate");
		return "preloadSelectTemplate";
	}

		// USER REGISTRATION
	public String retrieveForEmail() throws Exception {
		super.buildPagePreloadData("retrieveForEmail", getModel());

		request.setAttribute(WebKeys.ACTION_COMMAND, "retrieveForEmail");
		return "retrieveForEmail";
	}
	
	public String makeNew() throws Exception {
		intercept(ACTIONCOMMAND_MAKENEW, params, formData, session, getModel());
		setModel(((UserRegistrationService)service).makeNew(getModel()));
		
		session.put(WebKeys.USER_OBJECT_PRINCIPAL, ((UserRegistration)getModel()).getUser());
		request.setAttribute(WebKeys.ACTION_COMMAND, "makeNew");
		return "preloadUpdateUserRegistrationRedirect";
	}
	
	public String saveOnly() throws Exception {
		intercept(ACTIONCOMMAND_SAVEONLY, params, formData, session, getModel());
		setModel(((UserRegistrationService)service).saveOnly(getModel()));
		super.addActionMessage("Registration saved successfully!");
		
		session.put(WebKeys.USER_OBJECT_PRINCIPAL, ((UserRegistration)getModel()).getUser());
		request.setAttribute(WebKeys.ACTION_COMMAND, "saveOnly");
		//chain cos need to display actionmsg 
		return "preloadUpdateUserRegistrationChain";
	}

	//****************************** DELEGATE METHODS ********************************
	public UserRegistration getNewModel() {
		return new UserRegistration();
	}

	public BaseEntity intercept(String command, Map myParams, Map formData, Map session, BaseEntity abstractModel) throws Exception {
		UserRegistration model = (UserRegistration) abstractModel;

		if (command.equals(ACTIONCOMMAND_MAKENEW) || command.equals(ACTIONCOMMAND_SAVEONLY)) {
			model.setDateSaved(Calendar.getInstance());
			model.setApprovedStatus(GlobalKeys.REGISTRATION_NOT_APPROVED_YET);
			if (model.getUser().getPassword() == null || model.getUser().getPassword().trim().equals("")) model.getUser().setPassword(configurationService.getUserDefaultPassword());
			
			this.setUserRegistrationId(((UserRegistration)getModel()).getId());
		}
		if (command.equals(ACTIONCOMMAND_MAKENEW)) model.setRegistrationStatus(GlobalKeys.REGISTRATION_STATUS_SUBMITTED);
		if (command.equals(ACTIONCOMMAND_SAVEONLY)) model.setRegistrationStatus(GlobalKeys.REGISTRATION_STATUS_SAVED);
		if (command.equals(ACTIONCOMMAND_MAKENEW) || command.equals(ACTIONCOMMAND_SAVEONLY) || command.equals(WebConstants.ACTIONCOMMAND_UPDATE)) {
			model.setFlightInfoArrivalTime(model.getFlightInfoArrivalTimeHour() + ":" + model.getFlightInfoArrivalTimeMinute());
			model.setFlightInfoDepartureTime(model.getFlightInfoDepartureTimeHour() + ":" + model.getFlightInfoDepartureTimeMinute());
						
			if (model.getCountry().getId() == null) model.setCountry(null);
		}
		if (command.equals("updateEvaluationForm")) {
			model.setCompletedEvaluation(true);
			model.setDateCompletedEvaluation(Calendar.getInstance());
			
			super.addActionMessage("Feedback submitted successfully.");
		}
		
		return model;
	}
	
	protected Map[] buildPagePreloadData(String command, Map myParams, Map preloadData, Map formData, BaseEntity abstractModel, Map session) throws Exception {
		Map[] ret = super.buildPagePreloadData(command, myParams, preloadData, formData, abstractModel, session);
		
		UserRegistration model = (UserRegistration) abstractModel;

		if (command.equals(WebConstants.ACTIONCOMMAND_PRELOADCREATE) || command.equals(WebConstants.ACTIONCOMMAND_PRELOADUPDATE) || command.equals(WebConstants.ACTIONCOMMAND_PRELOADSEARCH)) {
			List countries = preloadDataService.retrieveAll(Country.class, "name");
			List countryTypes = new ArrayList();
			countryTypes.add(new LabelValueBean(WebConstants.PRELOAD_DEFAULTLABEL, WebConstants.PRELOAD_DEFAULTVALUE));
			for (Iterator itr = countries.iterator(); itr.hasNext(); ) {
				Country entity = (Country) itr.next();
				countryTypes.add(new LabelValueBean(entity.getName(),entity.getId().toString()));
			}
			preloadData.put("countryTypes", countryTypes);
			
		}
		if (command.equals(WebConstants.ACTIONCOMMAND_PRELOADCREATE) || command.equals(WebConstants.ACTIONCOMMAND_PRELOADUPDATE)) {
			List hourTypes = new ArrayList();
			for (int i = 0; i < 24; i++) {
				hourTypes.add(new LabelValueBean(Utility.getInstance().buildDigitNumber(i, 2), Utility.getInstance().buildDigitNumber(i, 2)));
			}
			preloadData.put("hourTypes", hourTypes);
			
			List minuteTypes = new ArrayList();
			for (int i = 0; i < 60; i++) {
				minuteTypes.add(new LabelValueBean(Utility.getInstance().buildDigitNumber(i, 2), Utility.getInstance().buildDigitNumber(i, 2)));
			}
			preloadData.put("minuteTypes", minuteTypes);
		}
		if (command.equals(WebConstants.ACTIONCOMMAND_PRELOADUPDATE) || command.equals("updateEvaluationForm")) {
			String[] arrivalTime = Utility.getInstance().buildStringArrayFromString(model.getFlightInfoArrivalTime(), ":");
			String[] departureTime = Utility.getInstance().buildStringArrayFromString(model.getFlightInfoDepartureTime(), ":");
			
			if (arrivalTime != null) {
				if (arrivalTime[0] == null) arrivalTime[0] = "";
				if (arrivalTime[1] == null) arrivalTime[1] = "";
				
				model.setFlightInfoArrivalTimeHour(arrivalTime[0]);
				model.setFlightInfoArrivalTimeMinute(arrivalTime[1]);
			}
			if (departureTime != null) {
				if (departureTime[0] == null) departureTime[0] = "";
				if (departureTime[1] == null) departureTime[1] = "";
				
				model.setFlightInfoDepartureTimeHour(departureTime[0]);
				model.setFlightInfoDepartureTimeMinute(departureTime[1]);
			}
			
			Map coolDownSocialEventsFigures = new HashMap();
			List coolDownSocialEventsFiguresList = ((UserRegistrationService)service).retrieveCountByCoolDownSocialEvents(model.getId());
			for (Iterator itr = coolDownSocialEventsFiguresList.iterator(); itr.hasNext(); ) {
				Object[] obj = (Object[]) itr.next();
				Long count = (Long)obj[0];
				Integer coolDownSocialEvents = (Integer)obj[1];
				coolDownSocialEventsFigures.put("event"+coolDownSocialEvents, count);
			}
			//try to initialise for all 5. if empty, set to 0.
			for (int coolDownSocialEvents = 1; coolDownSocialEvents <= GlobalKeys.EVENT_MAX_CAP.length; coolDownSocialEvents++) {
				Long count = (Long) coolDownSocialEventsFigures.get("event"+new Integer(coolDownSocialEvents));
				if (count == null) {
					count = new Long(0);
					coolDownSocialEventsFigures.put("event"+new Integer(coolDownSocialEvents), count);
				}

				//check if social activity exceeds limit
				//event max cap is 0 indexed. hence must minus 1.
				if (session.get(WebKeys.ACTION_ERROR_ALREADY_ADDED) == null || ((Boolean)session.get(WebKeys.ACTION_ERROR_ALREADY_ADDED)) != true) {
					if (model.getCoolDownSocialEvents() != null && model.getCoolDownSocialEvents() == coolDownSocialEvents &&
							count.intValue() >= GlobalKeys.EVENT_MAX_CAP[coolDownSocialEvents-1]) {
						super.addActionError("The social event that you have selected is full. Kindly select another event.");
						model.setCoolDownSocialEvents(0);
					}
				}
				
				coolDownSocialEventsFigures.put("eventMax"+new Integer(coolDownSocialEvents), GlobalKeys.EVENT_MAX_CAP[coolDownSocialEvents-1]);
			}
			//include reserved seats.
			for (int coolDownSocialEvents = 1; coolDownSocialEvents <= GlobalKeys.EVENT_MAX_CAP.length; coolDownSocialEvents++) {
				Long count = (Long)coolDownSocialEventsFigures.get("event"+coolDownSocialEvents);
				count += ((UserRegistrationService)service).getReservedSeats(coolDownSocialEvents);
				coolDownSocialEventsFigures.put("event"+coolDownSocialEvents, count);
			}
			
			preloadData.put("coolDownSocialEventsFigures", coolDownSocialEventsFigures);
		}
		if (command.equals("preloadSelectTemplate")) {
			List dataFigures = ((UserRegistrationService)service).retrieveDataFigures();
			preloadData.put("dataFigureSubmitted", dataFigures.get(0));
			preloadData.put("dataFigureSaved", dataFigures.get(1));
			
			List submittedDatesList = new ArrayList();
			List submittedDates = ((UserRegistrationService)service).retrieveDistinctSaveDates();
			
			Boolean archivePage = params.get("archivePage") != null && params.get("archivePage").toString().equals("true");
			Calendar today = Calendar.getInstance();
			for (Iterator itr = submittedDates.iterator(); itr.hasNext(); ) {
				Calendar date = (Calendar) itr.next();

				if (archivePage) {
					submittedDatesList.add(Utility.getInstance().buildStringFromCalendar(date));
				}
				else {
					//if going for archive page, add only today's date (if any)
					if (date.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
							date.get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
							date.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)) {
						submittedDatesList.add(Utility.getInstance().buildStringFromCalendar(date));
						break;
					}
				}
			}

			preloadData.put("submittedDates", submittedDatesList);
			
			if (!archivePage) {
				List notApprovedYet = ((UserRegistrationService)service).retrieveUserRegistrationsByApprovedStatus(GlobalKeys.REGISTRATION_NOT_APPROVED_YET);
				List disapproved = ((UserRegistrationService)service).retrieveUserRegistrationsByApprovedStatus(GlobalKeys.REGISTRATION_DISAPPROVED);
				
				preloadData.put("notApprovedYet", notApprovedYet);
				preloadData.put("disapproved", disapproved);
			}
		}
		if (command.equals("retrieveForEmail")) {
			boolean displayHotelNote = true;
			if (displayHotelNote && model.getHotelCheckinDate() != null &&
					model.getHotelCheckinDate().get(Calendar.YEAR) == 2008 && model.getHotelCheckinDate().get(Calendar.MONTH) == 0 && 
					(model.getHotelCheckinDate().get(Calendar.DAY_OF_MONTH) == 28 || model.getHotelCheckinDate().get(Calendar.DAY_OF_MONTH) == 29 || model.getHotelCheckinDate().get(Calendar.DAY_OF_MONTH) == 30)) {
				displayHotelNote = false;
			}
			if (displayHotelNote && model.getHotelCheckoutDate() != null &&
					model.getHotelCheckoutDate().get(Calendar.YEAR) == 2008 && model.getHotelCheckoutDate().get(Calendar.MONTH) == 0 && 
					(model.getHotelCheckoutDate().get(Calendar.DAY_OF_MONTH) == 28 || model.getHotelCheckoutDate().get(Calendar.DAY_OF_MONTH) == 29 || model.getHotelCheckoutDate().get(Calendar.DAY_OF_MONTH) == 30)) {
				displayHotelNote = true;
			}
			preloadData.put("displayHotelNote", displayHotelNote);
		}
		
		return ret;
	}
	
	public SearchCriteria buildSearchDetails(Map myParams, BaseEntity model) throws Exception {
		int matchType = resolveSearchMatchType(myParams.get("searchBooleanType").toString(), myParams.get("searchMatchType").toString());
		boolean andSearch = (matchType == PickCriteria.KEY_PARTIAL_MATCHES_ALL_VALUE || matchType == PickCriteria.KEY_FULL_MATCHES_ALL_VALUES)?true:false;

		SearchCriteria criteria = new SearchCriteria();
		
		// add retrieve fields
		criteria.getRetrieveFields().add("o");

		// add target objects
		criteria.getTargetObjects().add(model.getClass().getName()+" o");
		
		criteria.getCustomCriteria().add("o.user.id != " + GlobalKeys.ADMIN_USER_ID);

		// add criteria
		criteria = super.addPickCriteria(criteria, "o.", "firstName", model, matchType);
		criteria = super.addPickCriteria(criteria, "o.", "lastName", model, matchType);		
		criteria = super.addPickCriteria(criteria, "o.", "user.email", model, matchType);
		criteria = super.addPickCriteria(criteria, "o.", "company", model, matchType);
		criteria = super.addPickCriteria(criteria, "o.", "country.id", model, PickCriteria.KEY_FULL_MATCHES_ALL_VALUES);	

		return criteria;
	}
	
	public BaseEntity buildEntityFromSearchResults(List resultRecord, int count) throws Exception {
		return (UserRegistration)resultRecord.get(count);
	}
	
	//****************************** GET/SET METHODS ********************************
	public Integer getUserRegistrationId() {
		return userRegistrationId;
	}

	public void setUserRegistrationId(Integer userRegistrationId) {
		this.userRegistrationId = userRegistrationId;
	}
	
	public ExcelHelper getExcelHelper() {
		return excelHelper;
	}

	public void setExcelHelper(ExcelHelper excelHelper) {
		this.excelHelper = excelHelper;
	}
	
	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}
	
	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	//****************************** DWR METHODS ********************************
	public Boolean updateApprovedStatus(Integer id, Boolean approveOrNot) throws Exception {
		Boolean ret = true;
		UserRegistration toRetrieve = this.getNewModel();
		toRetrieve.setId(id);
		
		UserRegistration userRegistration = (UserRegistration) ((UserRegistrationService)service).retrieve(toRetrieve);
		if (approveOrNot) {
			userRegistration.setApprovedStatus(GlobalKeys.REGISTRATION_APPROVED);
			((UserRegistrationService)service).sendUserRegistrationEmail(userRegistration);
		}
		else userRegistration.setApprovedStatus(GlobalKeys.REGISTRATION_DISAPPROVED);
		((UserRegistrationService)service).update(userRegistration);
		
		return ret;
	}

	public void save(String fieldName, String fieldValue) throws Exception {
		if (!fieldValue.equals("")) {
			UserRegistration userRegistration = ((User) WebContextFactory.get().getSession().getAttribute(WebKeys.USER_OBJECT_PRINCIPAL)).getUserRegistration();

			//autosave only for client
			if (userRegistration != null && userRegistration.getUser().getAuthorizedModules() == null) {
				//try String first
				Method method = null;
				int methodParamType = 0;
				try { 
					if (method == null) {
						method = userRegistration.getClass().getMethod(Utility.getInstance().buildFieldSetter(fieldName), new Class[]{String.class});
						methodParamType = GlobalKeys.PARAM_TYPE_STRING;
					}
				}
				catch (NoSuchMethodException e) { }
				try { 
					if (method == null) {
						method = userRegistration.getClass().getMethod(Utility.getInstance().buildFieldSetter(fieldName), new Class[]{Integer.class});
						methodParamType = GlobalKeys.PARAM_TYPE_INTEGER;
					}
				}
				catch (NoSuchMethodException e) { }
				try { 
					if (method == null) {
						method = userRegistration.getClass().getMethod(Utility.getInstance().buildFieldSetter(fieldName), new Class[]{Boolean.class});
						methodParamType = GlobalKeys.PARAM_TYPE_BOOLEAN;
					}
				}
				catch (NoSuchMethodException e) { }		

				Boolean update = false;
				if (fieldName.equals("country.id")) {
					if (userRegistration.getCountry() == null) userRegistration.setCountry(new Country());
					userRegistration.getCountry().setId(new Integer(fieldValue));
					methodParamType = GlobalKeys.PARAM_TYPE_INTEGER;
				}
				if (fieldName.equals("flightInfoArrivalDate")) {
					userRegistration.setFlightInfoArrivalDate(Utility.getInstance().buildCalendarFromString(fieldValue));
					methodParamType = GlobalKeys.PARAM_TYPE_CALENDAR;
					fieldValue = Utility.getInstance().convertDDMMYYtoYYYYMMDDNoDelim(fieldValue);
				}
				if (fieldName.equals("flightInfoArrivalTimeHour") || fieldName.equals("flightInfoArrivalTimeMinute")) {
					if (fieldName.equals("flightInfoArrivalTimeHour")) userRegistration.setFlightInfoArrivalTimeHour(fieldValue);
					if (fieldName.equals("flightInfoArrivalTimeMinute")) userRegistration.setFlightInfoArrivalTimeMinute(fieldValue);
					userRegistration.setFlightInfoArrivalTime(userRegistration.getFlightInfoArrivalTimeHour()+":"+userRegistration.getFlightInfoArrivalTimeMinute());
					methodParamType = GlobalKeys.PARAM_TYPE_STRING;
					fieldValue = userRegistration.getFlightInfoArrivalTime();
					fieldName = "flightInfoArrivalTime";
				}
				if (fieldName.equals("flightInfoDepartureDate")) {
					userRegistration.setFlightInfoDepartureDate(Utility.getInstance().buildCalendarFromString(fieldValue));
					methodParamType = GlobalKeys.PARAM_TYPE_CALENDAR;
					fieldValue = Utility.getInstance().convertDDMMYYtoYYYYMMDDNoDelim(fieldValue);
				}
				if (fieldName.equals("flightInfoDepartureTimeHour") || fieldName.equals("flightInfoDepartureTimeMinute")) {
					if (fieldName.equals("flightInfoDepartureTimeHour")) userRegistration.setFlightInfoDepartureTimeHour(fieldValue);
					if (fieldName.equals("flightInfoDepartureTimeMinute")) userRegistration.setFlightInfoDepartureTimeMinute(fieldValue);
					userRegistration.setFlightInfoDepartureTime(userRegistration.getFlightInfoDepartureTimeHour()+":"+userRegistration.getFlightInfoDepartureTimeMinute());
					methodParamType = GlobalKeys.PARAM_TYPE_STRING;
					fieldValue = userRegistration.getFlightInfoDepartureTime();
					fieldName = "flightInfoDepartureTime";
				}
				if (fieldName.equals("hotelCheckinDate")) {
					userRegistration.setHotelCheckinDate(Utility.getInstance().buildCalendarFromString(fieldValue));
					methodParamType = GlobalKeys.PARAM_TYPE_CALENDAR;
					fieldValue = Utility.getInstance().convertDDMMYYtoYYYYMMDDNoDelim(fieldValue);
				}
				if (fieldName.equals("hotelCheckoutDate")) {
					userRegistration.setHotelCheckoutDate(Utility.getInstance().buildCalendarFromString(fieldValue));
					methodParamType = GlobalKeys.PARAM_TYPE_CALENDAR;
					fieldValue = Utility.getInstance().convertDDMMYYtoYYYYMMDDNoDelim(fieldValue);
				}

				if (methodParamType != 0) update = true;

				if (!update) {
					if (methodParamType == GlobalKeys.PARAM_TYPE_STRING) method.invoke(userRegistration, new Object[]{(String)fieldValue});
					if (methodParamType == GlobalKeys.PARAM_TYPE_INTEGER) method.invoke(userRegistration, new Object[]{new Integer(fieldValue)});
					if (methodParamType == GlobalKeys.PARAM_TYPE_BOOLEAN) method.invoke(userRegistration, new Object[]{new Boolean(fieldValue)});

					update = true;
				}

				if (update) ((UserRegistrationService)service).updateField(userRegistration.getId(), fieldName, fieldValue, methodParamType);
			}
		}
	}
}
