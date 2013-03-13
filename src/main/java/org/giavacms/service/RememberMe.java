package org.giavacms.service;

import java.util.HashMap;
import java.util.Map;

import org.giavacms.api.DuilioInfoService;
import org.giavacms.api.DuilioService;
import org.jboss.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;

public class RememberMe implements DuilioService {

	Logger logger = Logger.getLogger(getClass());
	private DuilioInfoService duilioInfoService;

	public RememberMe() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DuilioInfoService getDuilioInfoService() {
		return duilioInfoService;
	}

	@Override
	public void setDuilioInfoService(DuilioInfoService duilioInfoService) {
		this.duilioInfoService = duilioInfoService;
	}

	@Override
	public boolean execute(DuilioInfoService duilioInfoService) {
		this.duilioInfoService = duilioInfoService;
		return execute();
	}

	@Override
	public boolean execute() {
		// Create a rest client
		try {
			final TwilioRestClient client = new TwilioRestClient(
					getDuilioInfoService().getValue("ACCOUNT_SID"),
					getDuilioInfoService().getValue("AUTH_TOKEN"));

			// Get the main account (The one we used to authenticate the client)
			final Account mainAccount = client.getAccount();

			// Make a call
			final CallFactory callFactory = mainAccount.getCallFactory();
			final Map<String, String> callParams = new HashMap<String, String>();
			callParams.put("To", getDuilioInfoService().getValue("to"));
			// Replace with a valid phone number
			callParams.put("From", getDuilioInfoService().getValue("from"));
			callParams.put("message", getDuilioInfoService()
					.getValue("message"));
			// Replace with a valid phone number in your account
			callParams
					.put("Url", getDuilioInfoService().getValue("twilio-url"));
			Call call = callFactory.create(callParams);
			logger.info("duilio call sid:" + call.getSid());
		} catch (TwilioRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
