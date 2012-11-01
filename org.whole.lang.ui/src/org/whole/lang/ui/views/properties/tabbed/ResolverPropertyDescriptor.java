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
package org.whole.lang.ui.views.properties.tabbed;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.views.properties.PropertyDescriptor;

/**
 * @author Enrico Persiani
 */
public class ResolverPropertyDescriptor extends PropertyDescriptor {

	public ResolverPropertyDescriptor(Object id, String displayName) {
		super(id, displayName);
	}

	@Override
	public CellEditor createPropertyEditor(Composite parent) {
		return new CellEditor(parent) {
			protected Label text;
			protected Object lastValue;
			@Override
			protected Control createControl(Composite parent) {
				text = new Label(parent, SWT.LEFT);
				text.setText("");
				return text;
			}
			@Override
			protected Object doGetValue() {
				return lastValue;
			}
			@Override
			protected void doSetFocus() {
			}
			@Override
			protected void doSetValue(Object value) {
				lastValue = value;
				text.setText(String.valueOf(value));
			}
		};
	}
}
