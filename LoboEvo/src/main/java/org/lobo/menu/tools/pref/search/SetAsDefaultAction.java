package org.lobo.menu.tools.pref.search;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import org.lobo.store.ToolsStore;

public class SetAsDefaultAction<T> extends AbstractAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private transient ItemListControl<T> item;

	public SetAsDefaultAction(ItemListControl<T> item) {
		this.item = item;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
	 * ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (JOptionPane.showConfirmDialog(this.item, "Are you sure you want set as default the selected item?",
				"Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			setDefault();
		}
	}

	/**
	 * Removes the selected item.
	 */
	private void setDefault() {
		final ToolsStore tools = new ToolsStore();
		final String name = String.valueOf(this.item.getComboBox().getSelectedItem());
		tools.unselectedSearch();
		tools.selectedSearch(name);
	}
}
