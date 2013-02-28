/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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

import java.util.Arrays;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValue;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class EnumValueDataPropertyDescriptor extends PropertyDescriptor {
	private final EntityDescriptor<?> ed;
	private final IDataTypeParser parser;
	private EnumType<?> enumType;
	private String[] labels;

	public EnumValueDataPropertyDescriptor(Object id, String displayName, final EntityDescriptor<?> ed) {
		super(id, displayName);
		parser = DataTypeUtils.getDataTypeParser(this.ed = ed, DataTypeParsers.PRESENTATION);
		this.enumType = ed.getDataEnumType();

		setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return element == null ? "" : parser.unparse(ed, element);
			}
		});
	}

	@Override
    public CellEditor createPropertyEditor(Composite parent) {
		if (labels == null) {
			labels = new String[enumType.size()];
			for (int i=0; i<enumType.size(); i++)
				labels[i] = parser.unparse(ed, enumType.valueOf(i));
				
			Arrays.sort(labels);
		}
        CellEditor editor = new ComboBoxCellEditor(parent, labels, SWT.READ_ONLY) {
        	@Override
        	protected Object doGetValue() {
        		int offset = ((Integer) super.doGetValue()).intValue();
        		return parser.parse(ed, labels[offset]);
        	}
        	@Override
        	protected void doSetValue(Object value) {
        		int offset = Arrays.binarySearch(getItems(), parser.unparse(ed, (EnumValue) value)); 
        		super.doSetValue(new Integer(offset >= 0 ? offset : 0));
        	}
        };
        if (getValidator() != null)
			editor.setValidator(getValidator());
        return editor;
    }
}
