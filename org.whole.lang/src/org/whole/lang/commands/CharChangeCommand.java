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
package org.whole.lang.commands;

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class CharChangeCommand extends AbstractCommand {
	private static final long serialVersionUID = 1L;
	private char oldValue;
	public final char newValue;

	public CharChangeCommand(int executionTime, IEntity source, char oldValue, char newValue) {
		super(executionTime, source);
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

    public Object getOldObject() {
    	return oldValue;
    }
    public void setOldObject(Object object) {
    	oldValue = (Character) object;
    }
    public Object getNewObject() {
    	return newValue;
    }

	public void undo() {
		source.wSetLastCommand(getPrevCommand());
		source.wSetValue(oldValue);
	}
	public void redo() {
		source.wSetLastCommand(this);
		source.wSetValue(newValue);
	}

	@Override
	protected void appendChange(StringBuilder builder) {
		builder.append('\'');
		builder.append(oldValue);
		builder.append("' -> '");
		builder.append(newValue);
		builder.append('\'');
	}
}
