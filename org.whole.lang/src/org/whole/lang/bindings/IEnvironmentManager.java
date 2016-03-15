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
package org.whole.lang.bindings;

import java.util.Set;

import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.ICloneable;
import org.whole.lang.operations.IOperation;

/**
 * @author Riccardo Solmi
 */
public interface IEnvironmentManager extends ICloneable {
	public static final String CONFIGURATION = "Configuration";

	public IEnvironmentManager clone();
	public IEnvironmentManager clone(ICloneContext cc);

	public IOperation getCurrentOperation();
	public void enterOperation(IOperation operation);
	public void exitOperation();

	public Set<String> getEnvironmentNames();
	public String getEnvironmentName(IBindingManager env);

	public IBindingManager getEnvironment(String name);
	public IBindingManager createEnvironment(String namePrefix);
	public IBindingManager createEnvironment(String namePrefix, IBindingScope env);
	public IBindingManager removeEnvironment(String name);
}
