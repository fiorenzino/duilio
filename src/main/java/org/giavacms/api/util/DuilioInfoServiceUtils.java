package org.giavacms.api.util;

import org.giavacms.api.DuilioInfoService;
import org.giavacms.model.DuilioAction;

public class DuilioInfoServiceUtils {

	public static DuilioInfoService fromAction(DuilioAction action) {

		return new DuilioInfoService();
	}
}
