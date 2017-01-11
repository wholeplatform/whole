/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.product.e4.lw.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.e4.ui.preferences.EditorPreferencePage;
import org.whole.lang.e4.ui.preferences.WholePreferencePage;

/**
 * @author Enrico Persiani
 */
public class PreferencesHandler {
	@Execute
	public void execute(Shell shell) {
		PreferenceManager manager = new PreferenceManager();
		PreferenceNode wholeNode = new PreferenceNode(IE4UIConstants.WHOLE_PREFERENCE_PAGE_ID, new WholePreferencePage());
		PreferenceNode editorNode = new PreferenceNode(IE4UIConstants.EDITOR_PREFERENCE_PAGE_ID, new EditorPreferencePage());
		manager.addToRoot(wholeNode);
		wholeNode.add(editorNode);

		PreferenceDialog dialog = new PreferenceDialog(null, manager);
		dialog.setSelectedNode(IE4UIConstants.EDITOR_PREFERENCE_PAGE_ID);
		dialog.open();
	}
}
