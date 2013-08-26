/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.e4.ui.handler;

import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.e4.ui.dialogs.E4FindReplaceDialog;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class FindReplaceHandler {
	@Execute
	public void execute(IEclipseContext context, @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) {

		E4FindReplaceDialog dialog = ContextInjectionFactory.make(E4FindReplaceDialog.class, context);
		if (dialog.getShell() == null) {
			dialog.create();
			dialog.open();
		} else
			dialog.getShell().setActive();

		IEntity template = bm.wGet("primarySelectedEntity");

		dialog.setTemplate(EntityUtils.isFragment(template) ?
				CommonsEntityFactory.instance.createResolver() : EntityUtils.clone(template));
	}
}
