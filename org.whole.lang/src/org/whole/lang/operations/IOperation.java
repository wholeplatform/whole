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
package org.whole.lang.operations;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.IEnvironmentManager;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public interface IOperation {
	public String getOperationId();
    public IOperation getEnclosingOperation();

    public IEnvironmentManager getEnvironmentManager();
	public IBindingManager getOperationEnvironment();
	public IBindingScope getResultsScope();
//	public IBindingScope getArgumentsScope();

	public String getPhase();
	public int getStage();
	public void stagedVisit(IEntity entity, int relativeStage);
	public void stagedVisit(IEntity entity, int relativeStage, String phase);
	public void stagedDefaultVisit(IEntity entity, int relativeStage);

    public boolean isCanceled();
    public void setCanceled(boolean value);
    public IOperationProgressMonitor getProgressMonitor();

	public boolean isSelectedFeature(String name);
    public IEntity setFeature(String name, boolean value);
    public IEntity setFeature(String name, IEntity value);
}
