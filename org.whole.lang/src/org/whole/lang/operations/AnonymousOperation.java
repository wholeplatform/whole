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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;

/**
 * @author Riccardo Solmi
 */
public class AnonymousOperation extends AbstractOperation {
	public static final String ID = "AnonymousOperation";

	public AnonymousOperation() {
		super(ID, BindingManagerFactory.instance.createNull(), BindingManagerFactory.instance.createBindingManager(), true);
		getEnvironmentManager().enterOperation(this);
	}

	public AnonymousOperation(IBindingManager bm) {
		super(ID, bm.wIsSet("self") ? bm.wGet("self") : BindingManagerFactory.instance.createNull(), bm, null);
		getEnvironmentManager().enterOperation(this);
	}
}
