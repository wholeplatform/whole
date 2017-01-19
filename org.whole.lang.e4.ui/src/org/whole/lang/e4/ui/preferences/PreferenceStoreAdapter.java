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
package org.whole.lang.e4.ui.preferences;

import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.map.ObservableMap;
import org.eclipse.core.databinding.observable.map.WritableMap;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;
import org.whole.lang.ui.PreferenceConstants;

/**
 * @author Enrico Persiani
 */
public class PreferenceStoreAdapter extends FailurePreferenceStore {
	protected String bundleId;
	protected ObservableMap preferences;

	public PreferenceStoreAdapter(String bundleId) {
		this.bundleId = bundleId;
		this.preferences = new WritableMap();
		try {
			for (String name : DefaultScope.INSTANCE.getNode(bundleId).keys())
				this.preferences.put(name, PreferenceConstants.lookUpPreference(bundleId, name));

		} catch (BackingStoreException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void firePropertyChangeEvent(String name, Object oldValue, Object newValue) {
		// do nothing
	}

	@Override
	public boolean needsSaving() {
		return false;
	}

	@Override
	public void putValue(String name, String value) {
		preferences.put(name, value);
	}

	@Override
	public String getString(String name) {
		return preferences.containsKey(name) ? (String) preferences.get(name) : "";
	}
	@Override
	public boolean getBoolean(String name) {
		return Boolean.valueOf(getString(name));
	}

	@Override
	public String getDefaultString(String name) {
		return DefaultScope.INSTANCE.getNode(bundleId).get(name, "");
	}

	@Override
	public void setToDefault(String name) {
		putValue(name, getDefaultString(name));
	}

	public void addChangeListener(IChangeListener listener) {
		preferences.addChangeListener(listener);
	}

	public void removeChangeListener(IChangeListener listener) {
		preferences.removeChangeListener(listener);
	}

	public void resetToDefaults() {
		try {
			for (String name : DefaultScope.INSTANCE.getNode(bundleId).keys()) {
				this.preferences.put(name, DefaultScope.INSTANCE.getNode(bundleId).get(name, null));
			}

		} catch (BackingStoreException e) {
			throw new IllegalStateException(e);
		}
	}
	public void applyChanges() {
		try {
			IEclipsePreferences instance = InstanceScope.INSTANCE.getNode(bundleId);
			for (String name : DefaultScope.INSTANCE.getNode(bundleId).keys()) {
				String defaultValue = getDefaultString(name);
				String value = (String) this.preferences.get(name);
				if (defaultValue.equals(value))
					instance.remove(name);
				else
					instance.put(name, value);
			}
			// persist changes
			instance.flush();
		} catch (BackingStoreException e) {
			throw new IllegalStateException(e);
		}
	}
}
