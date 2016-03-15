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

import java.io.Serializable;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public interface ICommand extends Serializable {
	public CommandKind getKind();

	public int getExecutionTime();
	public void setExecutionTime(int executionTime); //for IHistoryManager use only
    public ICommand getPrevCommand();
    public void setPrevCommand(ICommand command); //for IHistoryManager use only
	public ICommand getCommand(int contextTime);

    public IEntity getSource();
    public FeatureDescriptor getSourceFeatureDescriptor();
    public int getSourceIndex();
    public IEntity getOldEntity();
    public void setOldEntity(IEntity entity); //for IHistoryManager use only
    public IEntity getNewEntity();
    public Object getOldObject();
    public void setOldObject(Object object); //for IHistoryManager use only
    public Object getNewObject();

	public void undo(); //for IHistoryManager use only
	public void redo(); //for IHistoryManager use only

	public void dispose(); //for IHistoryManager use only
}
