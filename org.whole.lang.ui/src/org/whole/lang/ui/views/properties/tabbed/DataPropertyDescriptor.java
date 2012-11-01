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
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class DataPropertyDescriptor extends PropertyDescriptor {
	private final EntityDescriptor<?> ed;
	private final IDataTypeParser parser;
	private Object parsedValue;

	public DataPropertyDescriptor(Object id, String displayName, final EntityDescriptor<?> ed) {
		super(id, displayName);
		parser = DataTypeUtils.getDataTypeParser(this.ed = ed, DataTypeParsers.PRESENTATION);

		setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return element == null ? "" : parser.unparse(ed, element);
			}
		});

		setValidator(new ICellEditorValidator() {
			public String isValid(Object value) {
				try {
					if (value instanceof String)
						setParsedValue(parser.parse(ed, (String) value));
					return null;
				} catch (IllegalArgumentException e) {
					return e.getLocalizedMessage();
				}
			}
		});
	}

	public Object getParsedValue() {
		return parsedValue;
	}
	public void setParsedValue(Object parsedValue) {
		this.parsedValue = parsedValue;
	}

	@Override
	public CellEditor createPropertyEditor(Composite parent) {
		CellEditor editor = new TextCellEditor(parent) {
			@Override
			protected Object doGetValue() {
				return getParsedValue();
			}
			@Override
			protected void doSetValue(Object value) {
				setParsedValue(value);
				super.doSetValue(parser.unparse(ed, value));
			}
		};
		if (getValidator() != null)
			editor.setValidator(getValidator());
		return editor;
	}
}
