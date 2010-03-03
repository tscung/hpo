package sg.com.stellarstudios.imser.helper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.common.Utility;
import sg.com.stellarstudios.imser.entity.User;
import sg.com.stellarstudios.imser.entity.UserRegistration;
import sg.com.stellarstudios.imser.exception.HelperException;
import sg.com.stellarstudios.imser.service.ConfigurationService;
import sg.com.stellarstudios.imser.web.common.WebKeys;
import freemarker.template.Configuration;

public class EmailHelper extends BaseHelper {
	private Long EMAIL_PAUSE_INTERVAL = new Long(1000*3);
	
	private MailSender mailSender;
	private FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean;
	private Configuration freeMarkerConfiguration;
	public void setMailSender(MailSender mailSender) { this.mailSender = mailSender; }
	public void setFreeMarkerConfigurationFactoryBean(FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean) { this.freeMarkerConfigurationFactoryBean = freeMarkerConfigurationFactoryBean; }
	private ConfigurationService configurationService;
	public void setConfigurationService(ConfigurationService configurationService) { this.configurationService = configurationService; }
	private HTTPHelper httpHelper;
	public void setHttpHelper(HTTPHelper httpHelper) { this.httpHelper = httpHelper; }
	
	private String adminEmail;
	public void setAdminEmail(String adminEmail) { this.adminEmail = adminEmail; }
	
	public EmailHelper() {
		/* unable to inject due to:
		 * org.springframework.beans.TypeMismatchException: Failed to convert property value of type [freemarker.template.Configuration] to
		 * required type [org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean] for property
		 * 'freeMarkerConfigurationFactoryBean'; nested exception is java.lang.IllegalArgumentException: No matching
		 * editors or conversion strategy found
		 * Caused by: 
		 * java.lang.IllegalArgumentException: No matching editors or conversion strategy found
		 */
		freeMarkerConfigurationFactoryBean = new FreeMarkerConfigurationFactoryBean();
//		freeMarkerConfigurationFactoryBean = (FreeMarkerConfigurationFactoryBean) ServiceLocator.getInstance().getApplicationContext().getBean("freeMarkerConfigurationFactoryBean");
	}
	public void setTemplateLoaderPath(String templateLoaderPath) throws Exception { 
		freeMarkerConfigurationFactoryBean.setTemplateLoaderPath(templateLoaderPath);
		freeMarkerConfiguration = freeMarkerConfigurationFactoryBean.createConfiguration();
	}

	public void sendRequestForPasswordEmail(User user) {
		this.sendEmail("F5 Hi-5 Pump It Up 2008", new String[]{user.getEmail()}, "user", user, "requestForPassword.ftl");
	}
	public void sendUserRegistrationEmail(UserRegistration userRegistration) {
		String url = configurationService.getAppWebRoot()+"/retrieveForEmailUserRegistration." + WebKeys.ACTION_EXTENSION + "?id=" + userRegistration.getId() + "&contentOnly=true&toEmail=true";

		try {
			String content = httpHelper.getContent(url);
			this.sendEmail("F5 Hi-5 Pump It Up 2008", new String[]{userRegistration.getUser().getEmail(), this.adminEmail}, content);
		}
		catch (HelperException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
		}
	}
	public void sendReminderEmail(String[]emails,String emailSubject) {
		for (int i = 0; i < emails.length; i++) {
			this.sendEmail(emailSubject, new String[]{emails[i]}, null, null, "reminderEmail.ftl");

			//sleep for 3 secs.
			try { Thread.sleep(EMAIL_PAUSE_INTERVAL); }
			catch (Exception e) { ServiceLocator.getInstance().getLogHelper().error(e); }
		}	
	}
	
	//threaded methods
	private void sendEmail(String subject, String[] emailTos, String content) {
		ServiceLocator.getInstance().getLogHelper().info("sending email. addresses: " + Utility.getInstance().buildStringFromStringArray(emailTos, ","));
		mailSender.sendMail(subject, emailTos, content);
		ServiceLocator.getInstance().getLogHelper().info("email successfully sent.");
	}
	private void sendEmail(String subject, String[] emailTos, Map models, String template) {
		try {
			ServiceLocator.getInstance().getLogHelper().info("sending email. addresses: " + Utility.getInstance().buildStringFromStringArray(emailTos, ","));
			models.put("configurationService", configurationService);
			mailSender.sendMail(subject, emailTos, FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfiguration.getTemplate(template), models));
			ServiceLocator.getInstance().getLogHelper().info("email successfully sent.");
		}
		catch (Exception e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
		}
	}
	private void sendEmail(String subject, String[] emailTos, String modelKey, Object modelObject, String template) {
		Map model = new HashMap();
		if (modelKey != null) model.put(modelKey, modelObject);
		this.sendEmail(subject, emailTos, model, template);
	}
}
