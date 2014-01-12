package net.optm.view;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import net.optm.Messages;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import swing2swt.layout.BorderLayout;

public class BettingScheduleView {
	private Table table;
	private String[][] schedule = { { "1", "5", "10", "20" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			{ "2", "10", "20", "20" } }; //$NON-NLS-1$ //$NON-NLS-2$

	@Inject
	public BettingScheduleView() {
		// TODO Your code here
	}

	@PostConstruct
	public void postConstruct(Composite parent) {

		parent.setLayout(new BorderLayout(0, 0));

		ScrolledComposite scrolledComposite = new ScrolledComposite(parent,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tblclmnLevel = new TableColumn(table, SWT.NONE);
		tblclmnLevel.setWidth(100);
		tblclmnLevel.setText(Messages.BettingScheduleView_8);

		TableColumn tblclmnBigBlind = new TableColumn(table, SWT.NONE);
		tblclmnBigBlind.setWidth(100);
		tblclmnBigBlind.setText(Messages.BettingScheduleView_9);

		TableColumn tblclmnSmallBlind = new TableColumn(table, SWT.NONE);
		tblclmnSmallBlind.setWidth(100);
		tblclmnSmallBlind.setText(Messages.BettingScheduleView_10);

		TableColumn tblclmnDauer = new TableColumn(table, SWT.NONE);
		tblclmnDauer.setWidth(100);
		tblclmnDauer.setText(Messages.BettingScheduleView_11);
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table
				.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		for (String[] level : schedule) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(level);
		}
		// TODO Your code here
	}

	@Focus
	public void onFocus() {
		// TODO Your code here
	}

	@Persist
	public void save() {
		// TODO Your code here
	}
}