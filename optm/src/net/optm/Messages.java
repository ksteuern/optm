package net.optm;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "net.optm.messages"; //$NON-NLS-1$
	public static String BettingScheduleView_10;
	public static String BettingScheduleView_11;
	public static String BettingScheduleView_8;
	public static String BettingScheduleView_9;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
