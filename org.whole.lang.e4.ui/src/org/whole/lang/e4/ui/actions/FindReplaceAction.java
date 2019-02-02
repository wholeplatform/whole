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
package org.whole.lang.e4.ui.actions;

import static org.whole.lang.e4.ui.actions.IE4UIConstants.*;

import java.util.function.BooleanSupplier;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;

/**
 * @author Enrico Persiani
 */
public class FindReplaceAction extends AbstractE4Action {
	private static final Object NO_METHOD = new Object();

	protected IFindAction action;

	public FindReplaceAction(IEclipseContext context, IFindAction action) {
		super(context, action.getOperation().getLabel());
		this.action = action;
	}

	@Override
	public void run() {
		if (NO_METHOD == ContextInjectionFactory.invoke(action, Execute.class, getContext(), NO_METHOD))
			throw new IllegalStateException("missing method annotated with @Execute");
		update();
	}

	@Override
	public void update() {
		setEnabled((Boolean) ContextInjectionFactory.invoke(action, CanExecute.class, getContext(), Boolean.TRUE));
	}

	protected IEntity createDefaultContents() {
		return E4Utils.createEmptyStatusContents();
	}

	public interface IFindAction {
		public Operation getOperation();
	}
	private static class FindAction implements IFindAction {
		private final Operation operation;
		private BooleanSupplier enabler;
		private Runnable runnable;

		public FindAction(Operation operation, BooleanSupplier enabler, Runnable runnable) {
			this.operation = operation;
			this.enabler = enabler;
			this.runnable = runnable;
		}
		public Operation getOperation() {
			return operation;
		}
		@CanExecute
		public boolean canExecute() {
			return enabler.getAsBoolean();
		}
		@Execute
		public void execute() {
			runnable.run();
		}
	}
	public static IFindAction create(Operation operation, BooleanSupplier enabler, Runnable runnable) {
		return new FindAction(operation, enabler, runnable);
	}

	public static enum Operation {
		FIND, REPLACE, REPLACEFIND, REPLACEALL;

		public String getLabel() {
			switch (this) {
			case FIND:
				return FIND_LABEL;
			case REPLACE:
				return REPLACE_LABEL;
			case REPLACEFIND:
				return REPLACEFIND_LABEL;
			case REPLACEALL:
				return REPLACEALL_LABEL;
			default:
				throw new UnsupportedOperationException("unknown operation");
			}
		}
	}
}
