package sg.com.stellarstudios.imser.helper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import sg.com.stellarstudios.imser.common.ServiceLocator;
import sg.com.stellarstudios.imser.exception.HelperException;

public class HTTPHelper extends BaseHelper {
	public String getContent(String url) throws HelperException {
		if (ServiceLocator.getInstance().getLogHelper() != null) ServiceLocator.getInstance().getLogHelper().info("accessing url: " + url);
		
		//retrieve content from url
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(url);
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		String content = null;
		
		InputStream is = null;
		try {
			int statusCode = client.executeMethod(method);
			if (statusCode != HttpStatus.SC_OK) ServiceLocator.getInstance().getLogHelper().error("HTTP Method failed: " + method.getStatusLine());

			// Read the response body.
//			is = method.getResponseBodyAsStream();
//			byte[] responseBody = new byte[is.available()];
//			is.read(responseBody);
			byte[] responseBody = method.getResponseBody();

			// Deal with the response.
			// Use caution: ensure correct character encoding and is not binary data
			content = new String(responseBody);
			
			if (ServiceLocator.getInstance().getLogHelper() != null) ServiceLocator.getInstance().getLogHelper().info("done accessing url: " + url);			
		}
		catch (HttpException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
			throw new HelperException(e);
		}
		catch (IOException e) {
			ServiceLocator.getInstance().getLogHelper().error(e);
			throw new HelperException(e);
		}
		finally {
			if (is != null) {
				try { is.close(); }
				catch (IOException e) {
					ServiceLocator.getInstance().getLogHelper().error(e);
					throw new HelperException(e);
				}
			}
			method.releaseConnection();
		}
		
		return content;
	}
}
