/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.reflect.ISourceable;

/**
 * @author Riccardo Solmi
 */
public interface IWholeRuntimeException extends ISourceable {
	public IWholeRuntimeException withSourceEntity(IEntity sourceEntity);
	public IWholeRuntimeException withBindings(IBindingManager bindings);
	public IBindingManager getBindings();

	public IWholeRuntimeException getSourceCause();

	default public RuntimeException asException() {
		return (RuntimeException) this;
	}

	public static RuntimeException asWholeException(Throwable e, IEntity sourceEntity, IBindingManager bm) {
		if (e instanceof OperationCanceledException)
			return (OperationCanceledException) e;
		else if (e instanceof IWholeRuntimeException) {
			IWholeRuntimeException wre = (IWholeRuntimeException) e;
			return wre.getSourceEntity() != null ? wre.asException() : wre.withSourceEntity(sourceEntity).withBindings(bm).asException();
		} else if (e instanceof IllegalArgumentException)
			return new WholeIllegalArgumentException(e).withSourceEntity(sourceEntity).withBindings(bm);
		else if (e instanceof IllegalStateException)
			return new WholeIllegalStateException(e).withSourceEntity(sourceEntity).withBindings(bm);
		else if (e instanceof IWholeFrameworkException)
			return ((IWholeFrameworkException) e).asException();
		else
			return new WholeRuntimeException(e).withSourceEntity(sourceEntity).withBindings(bm);
	}

	public static RuntimeException withCause(RuntimeException e, IEntity sourceEntity, IBindingManager bm) {
		return withCause(e, new WholeRuntimeException().withSourceEntity(sourceEntity).withBindings(bm));
	}
	public static RuntimeException withCause(RuntimeException e, Throwable we) {
		Throwable cause = e.getCause();
		while (cause != null && !(cause instanceof IWholeRuntimeException))
			cause = cause.getCause();
		if (cause == null)
			e.initCause(we);
		//TODO else add lazy complete
		return e;
	}
}
