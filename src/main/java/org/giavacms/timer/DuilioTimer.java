package org.giavacms.timer;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

import org.giavacms.api.DuilioInfoService;
import org.giavacms.api.DuilioService;
import org.giavacms.api.util.DuilioInfoServiceUtils;
import org.giavacms.model.DuilioAction;
import org.giavacms.timer.util.TimerUtils;
import org.jboss.logging.Logger;

@Stateless
@LocalBean
public class DuilioTimer {

	Logger logger = Logger.getLogger(getClass());

	@Resource
	private TimerService timerService;

	public void createTimers(Date date, String username, DuilioAction action) {
		TimerConfig timerConfig = new TimerConfig();
		timerConfig.setPersistent(true);

		Timer timer = this.timerService.createCalendarTimer(
				TimerUtils.fromDate(date), timerConfig);
		logger.info("NEW DUILIO SERVICE CREATED FOR: " + username + " - date:"
				+ timer.getNextTimeout());

	}

	@Timeout
	public void timeout(Timer timer) {
		DuilioAction action = (DuilioAction) timer.getInfo();
		try {
			DuilioService duilioService = (DuilioService) Class.forName(
					action.getServiceType().getClassName()).newInstance();
			DuilioInfoService duilioInfoService = DuilioInfoServiceUtils
					.fromAction(action);
			duilioService.setDuilioInfoService(duilioInfoService);
			duilioService.execute(duilioInfoService);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
