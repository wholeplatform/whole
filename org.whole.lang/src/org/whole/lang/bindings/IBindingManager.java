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

import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.ICloneable;



/**
 * @author Riccardo Solmi
 */
public interface IBindingManager extends IBindingScope, ICloneable {
	public static final String SELF = "self";
	public static final String OUTER_SELF = "staging#outerSelf";

	public static final String INSTRUMENTATION_ENABLED = "debug#instrumentationEnabled";
	public static final String BREAKPOINTS_ENABLED = "debug#breakpointsEnabled";
	public static final String REPORT_MODE_ENABLED = "debug#reportModeEnabled";
	public static final String DEBUG_MODE_ENABLED = "debug#debugModeEnabled";

	public static final String ECLIPSE_CONTEXT = "eclipse#eclipseContext";

	public static final String FIND_SKIPTO = "findReplace#skipTo";
	public static final String FIND_PATTERN = "findReplace#pattern";


	public IBindingManager withSourceEntity(IEntity entity);

	public IBindingManager clone();
	public IBindingManager clone(ICloneContext cc);

	public IEnvironmentManager wGetEnvironmentManager();

	public void wEnterScope();
	public void wEnterScope(INestableScope scope);
	public void wEnterScope(IBindingScope scope, boolean dynamic);
	public void wExitScope();
	public void wExitScope(boolean merge);

	public default void enforceSelfBinding(IEntity selfEntity) {
//		assert selfEntity != null;
//		if (selfEntity == null)
//			return;

		if (wGet(IBindingManager.SELF) != selfEntity)
			wDef(IBindingManager.SELF, selfEntity);
	}
}
