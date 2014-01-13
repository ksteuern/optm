package net.optm;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "net.optm.messages"; //$NON-NLS-1$
	public static String BettingScheduleView_1;
	public static String BettingScheduleView_2;
	public static String BettingScheduleView_3;
	public static String BettingScheduleView_4;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
