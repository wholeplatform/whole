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
package org.whole.product.e4.lw.handlers;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.whole.lang.e4.ui.parts.AbstractE4Part;

/**
 * @author Enrico Persiani
 */
public class SaveHandler {

	@CanExecute
	public boolean canExecute(EPartService partService) {
		return partService.getActivePart().isDirty();
	}

	@Execute
	public void execute(IEclipseContext context, EPartService partService) {
		IEclipseContext saveContext = context.createChild();
		AbstractE4Part part = (AbstractE4Part) partService.getActivePart().getObject();
		ContextInjectionFactory.invoke(part, Persist.class, saveContext);
		saveContext.dispose();
	}
}