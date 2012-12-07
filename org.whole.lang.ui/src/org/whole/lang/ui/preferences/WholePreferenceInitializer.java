/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.whole.lang.ui.PreferenceConstants;
import org.whole.lang.ui.WholeUIPlugin;

/**
 * @author Riccardo Solmi
 */
public class WholePreferenceInitializer extends AbstractPreferenceInitializer {
	private static boolean initialized;

	public void initializeDefaultPreferences() {
		if (initialized)
			return;
		initialized = true;

		IPreferenceStore store = WholeUIPlugin.getDefault().getPreferenceStore();
		
		PreferenceConstants.initializeDefaultValues(store,
				WholeUIPlugin.getDefault().getColorRegistry(),
				WholeUIPlugin.getDefault().getFontRegistry());
	}

}
