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
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class ValidatorOperation extends AbstractOperation {
	public static final String ID = "validator";
	private IDecorationManager decorationManager;

	public static void validate(IEntity entity, IBindingManager args) {
		validate(entity, args, null);
	}
	public static void validate(IEntity entity, IBindingManager args, IDecorationManager decorationManager) {
		boolean needUnset = false;
		if (decorationManager != null) {
			args.wDefValue("decorationManager", decorationManager);
			needUnset = true;
		} else if (args.wIsSet("decorationManager")) {
			decorationManager = (IDecorationManager) args.wGetValue("decorationManager");
		} else {
			args.wDefValue("decorationManager",
					decorationManager = FailureDecorationManager.instance);
			needUnset = true;
		}

		decorationManager.deleteDecorations(entity, true);
		new ValidatorOperation(args).stagedVisit(entity);
		
		if (needUnset)
			args.wUnset("decorationManager");
	}

	protected ValidatorOperation(IBindingManager args) {
		super(ID, args, null);
	}

	public IDecorationManager getDecorationManager() {
		if (decorationManager == null)
			decorationManager = (IDecorationManager) getOperationEnvironment().wGetValue("decorationManager");
		return decorationManager;
	}

	private static final class FailureDecorationManager extends AbstractDecorationManager {
		private static final FailureDecorationManager instance = new FailureDecorationManager();

		public void addDecoration(DecorationKind kind, IEntity entity, String message, String location) {
			if (kind.isError())
				throw new IllegalStateException("missing decoration manager");
		}
		public void deleteDecorations(IEntity entity, boolean deep) {
		}
	}
}
