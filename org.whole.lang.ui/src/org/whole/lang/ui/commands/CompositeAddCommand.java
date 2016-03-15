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
package org.whole.lang.ui.commands;

import org.eclipse.gef.commands.Command;
import org.whole.lang.model.IEntity;


public class CompositeAddCommand extends Command implements ILegacyCommand {
	private IEntity composite; 
	private IEntity newChild;
	private IEntity prevChild;
	private int index = -1;

	public void execute() {
		if (index == -1)
			index = (prevChild != null)
				? composite.wIndexOf(prevChild)
				: composite.wSize();			

		composite.wAdd(index, newChild);
	}

	public void undo() {
		composite.wRemove(newChild);
	}

	public void setComposite(IEntity composite) {
		this.composite = composite;
	}

	public void setNewChild(IEntity newChild) {
		this.newChild = newChild;
	}

	public void setPrevChild(IEntity prevChild) {
		this.prevChild = prevChild;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean canExecute() {
		return composite.wGetEntityDescriptor(0).isPlatformSupertypeOf(newChild.wGetEntityDescriptor());
	}
}
