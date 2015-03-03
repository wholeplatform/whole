/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.exceptions;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public interface IWholeRuntimeException {
	public RuntimeException withSourceInfo(IEntity sourceEntity, IBindingManager bindings);
	public IEntity getSourceEntity();
	public IBindingManager getBindings();

	public IWholeRuntimeException getSourceCause();

	default public RuntimeException asException() {
		return (RuntimeException) this;
	}
	public static RuntimeException asWholeException(Throwable e, IEntity sourceEntity, IBindingManager bm) {
		if (e instanceof IWholeRuntimeException) {
			IWholeRuntimeException wre = (IWholeRuntimeException) e;
			return wre.getSourceEntity() != null ? wre.asException() : wre.withSourceInfo(sourceEntity, bm);
		} else if (e instanceof IllegalArgumentException)
			return new WholeIllegalArgumentException(e).withSourceInfo(sourceEntity, bm);
		else if (e instanceof IllegalStateException)
			return new WholeIllegalStateException(e).withSourceInfo(sourceEntity, bm);
		else if (e instanceof IWholeFrameworkException)
			return ((IWholeFrameworkException) e).asException();
		else
			return new WholeRuntimeException(e).withSourceInfo(sourceEntity, bm);
	}
}
