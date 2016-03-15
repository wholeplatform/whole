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
package org.whole.lang.model;

import java.io.Serializable;

import org.whole.lang.commands.ICommand;

/**
 * @author Riccardo Solmi
 */
public interface InternalIEntity extends IEntity {
    public IEntity wShallowClone();

	public void wSetPid(Serializable pid);


//  ** inverse management methods **

	public void wSetModel(IFragmentModel model);
	public void wSetParent(IEntity parent);
	public void wRemoveParent(IEntity parent);
	public void wAddInverseAdjacent(IEntity inverseAdjacent);
	public void wRemoveInverseAdjacent(IEntity inverseAdjacent);


//  ** intensional support methods **

    public ICommand wGetBindingCommand();
    public void wSetBindingCommand(ICommand command);
	public ICommand wGetLastCommand();
	public ICommand wSetLastCommand(ICommand command);
}
