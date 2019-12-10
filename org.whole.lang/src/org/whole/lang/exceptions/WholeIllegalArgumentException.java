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

/**
 * @author Riccardo Solmi
 */
public class WholeIllegalArgumentException extends IllegalArgumentException implements IWholeRuntimeException {
	private static final long serialVersionUID = 1L;

	public WholeIllegalArgumentException(String message) {
		super(message);
	}
	public WholeIllegalArgumentException(Throwable cause) {
		super(cause);
	}
	public WholeIllegalArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

//begin same code in: WholeRuntimeException, WholeIllegalStateException and WholeIllegalArgumentException
	private IEntity sourceEntity;
	private IBindingManager bindings;

	public WholeIllegalArgumentException withSourceEntity(IEntity sourceEntity) {
		this.sourceEntity = sourceEntity;
		return this;
	}
	public WholeIllegalArgumentException withBindings(IBindingManager bindings) {
		this.bindings = bindings.clone();
		IWholeRuntimeException sourceCause = getSourceCause();
		if (sourceCause != this)
			sourceCause.withBindings(this.bindings);
		return this;
	}

	public IEntity getSourceEntity() {
		IWholeRuntimeException sourceCause = getSourceCause();
		return sourceCause != this ? sourceCause.getSourceEntity() : sourceEntity;
	}
	public IBindingManager getBindings() {
		IWholeRuntimeException sourceCause = getSourceCause();
		return sourceCause != this ? sourceCause.getBindings() : bindings;
	}

	private IWholeRuntimeException sourceCause;
	public IWholeRuntimeException getSourceCause() {
		if (sourceCause == null) {
			sourceCause = this;
			Throwable cause = getCause();
			if (cause instanceof IWholeRuntimeException) {
				IWholeRuntimeException sourceCauseRec = ((IWholeRuntimeException) cause).getSourceCause();
				if (sourceCauseRec.getSourceEntity() != null)
					sourceCause = sourceCauseRec;
			}
		}
		return sourceCause;
	}
//end same code
}
