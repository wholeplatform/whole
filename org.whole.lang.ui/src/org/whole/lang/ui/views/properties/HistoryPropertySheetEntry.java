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
package org.whole.lang.ui.views.properties;

import java.util.EventObject;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackListener;
import org.eclipse.ui.views.properties.IPropertySource2;
import org.eclipse.ui.views.properties.PropertySheetEntry;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.views.properties.tabbed.EntityPropertySource;

/**
 * @author Enrico Persiani
 */
public class HistoryPropertySheetEntry extends PropertySheetEntry {

	protected CommandStackListener csListener;
	protected CommandStack cs;

	protected HistoryPropertySheetEntry() {
	}
	public HistoryPropertySheetEntry(CommandStack cs) {
		setCommandStack(cs);
	}

	@Override
	protected HistoryPropertySheetEntry createChildEntry() {
		return new HistoryPropertySheetEntry();
	}
	@Override
	protected HistoryPropertySheetEntry getParent() {
		return (HistoryPropertySheetEntry) super.getParent();
	}

	@Override
	public void dispose() {
		if (cs != null)
			cs.removeCommandStackListener(csListener);
		super.dispose();
	}
	protected CommandStack getCommandStack() {
		HistoryPropertySheetEntry parent = getParent();
		if (parent != null)
			return parent.getCommandStack();
		return cs;
	}
	protected void setCommandStack(CommandStack cs) {
		this.cs = cs;
		csListener = new CommandStackListener() {
			public void commandStackChanged(EventObject e) {
				refreshFromRoot();
			}
		};
		this.cs.addCommandStackListener(csListener);
	}

	@Override
	protected EntityPropertySource getPropertySource(Object object) {
		return (EntityPropertySource) super.getPropertySource(object);
	}

	@Override
	public void resetPropertyValue() {
		HistoryPropertySheetEntry parent = getParent();
		if (parent == null)
			return;

		ModelTransactionCommand mtc = new ModelTransactionCommand();
		try {

			Object id = getDescriptor().getId();
			for (Object object : parent.getValues()) {

				if (mtc.getLabel() == null) {
					mtc.setLabel("Restore Default on "+getDisplayName()+" property");
					mtc.setModel(getPropertySource(object).getModelEntity());
					mtc.begin();
				}

				IPropertySource2 source = getPropertySource(object);
				if (source.isPropertyResettable(id) && source.isPropertySet(id))
					source.resetPropertyValue(id);
			}

			mtc.commit();
		} catch (Exception e) {
			mtc.rollback();
		}

		if (mtc.canUndo()) {
			getCommandStack().execute(mtc);
			refreshFromRoot();
		}
	}

	@Override
	protected void valueChanged(PropertySheetEntry entry) {
		HistoryPropertySheetEntry child = (HistoryPropertySheetEntry) entry;

		ModelTransactionCommand mtc = new ModelTransactionCommand();
		try {

			for (int i = 0; i < getValues().length; i++) {
				Object object = getValues()[i];

				if (mtc.getLabel() == null) {
					mtc.setLabel("Set "+child.getDisplayName()+" property");
					mtc.setModel(getPropertySource(object).getModelEntity());
					mtc.begin();
				}

				IPropertySource2 source = getPropertySource(object);
				Object id = child.getDescriptor().getId();
				Object value = child.getValues()[i];
				source.setPropertyValue(id, value);
			}

			mtc.commit();
		} catch (Exception e) {
			mtc.rollback();
		}

		if (mtc.canUndo()) {
			getCommandStack().execute(mtc);
			refreshFromRoot();
		}
	}
}
