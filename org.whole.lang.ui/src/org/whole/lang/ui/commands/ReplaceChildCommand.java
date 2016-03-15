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
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.EntityUtils;


/** 
 * @author Riccardo Solmi
 */
public class ReplaceChildCommand extends Command implements ILegacyCommand {
	protected IEntity parent;
	protected IEntity oldChild;
	protected IEntity newChild;
	
	public void execute() {
		parent.wSet(oldChild, newChild);
	}

	public void undo() {
		parent.wSet(newChild, oldChild);
	}

	public void setParent(IEntity parent) {
		this.parent = parent;
	}
	public void setOldChild(IEntity oldChild) {
		this.oldChild = oldChild;
	}
	public void setNewChild(IEntity newChild) {
		this.newChild = newChild;
	}

	public boolean canExecute() {
		if (!EntityUtils.hasParent(oldChild))
			return false;

		if (EntityUtils.isVariable(parent) && Matcher.matchImpl(CommonsEntityDescriptorEnum.VarType, newChild))
			return !EntityUtils.hasParent(parent) || parent.wGetParent().wGetEntityDescriptor(parent)
					.isPlatformSupertypeOf((EntityDescriptor<?>) newChild.wGetValue());
		else
			return EntityUtils.isFragment(parent) ||
					parent.wContains(oldChild) && 
					parent.wGetEntityDescriptor(oldChild).isPlatformSupertypeOf(newChild.wGetEntityDescriptor());
	}
}
