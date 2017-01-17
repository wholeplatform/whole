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
package org.whole.product.e4.lw.addons;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.whole.lang.ui.dialogs.DisabledImportAsModelDialogFactory;
import org.whole.lang.ui.dialogs.IImportAsModelDialogFactory;

/**
 * @author Enrico Persiani
 */
public class ImportAsModelDialogFactoryAddon {
	@Inject protected IEclipseContext context;
	
	@PostConstruct
	protected void initialize() throws CoreException {
		IImportAsModelDialogFactory factory = ContextInjectionFactory.make(DisabledImportAsModelDialogFactory.class, context);
		context.set(IImportAsModelDialogFactory.class, factory);
	}
}
