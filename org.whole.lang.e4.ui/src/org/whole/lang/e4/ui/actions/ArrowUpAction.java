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
package org.whole.lang.e4.ui.actions;

import org.eclipse.e4.core.contexts.IEclipseContext;

/**
 * @author Enrico Persiani
 */
public class ArrowUpAction extends AbstractModelTextAction {
	public ArrowUpAction(IEclipseContext context) {
		super(context, IE4UIConstants.LEFT_LABEL);
	}
	

	protected String getEnablementUri() {
		return "whole:org.whole.lang.ui:CaretActionsSemantics#arrowUpEnabled";
	}

	protected String getBehaviorUri() {
		return "whole:org.whole.lang.ui:CaretActionsSemantics#arrowUp";
	}
}
