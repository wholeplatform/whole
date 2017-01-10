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
package org.whole.lang.e4.ui.handler;

import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.e4.ui.dialogs.E4FindReplaceDialog;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class FindReplaceHandler {
	private static E4FindReplaceDialog instance = null;
	private static MWindow contextWindow = null;
	
	@Execute
	public void execute(IEclipseContext context, @Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) {
		if (instance == null || instance.getShell() == null || instance.getShell().isDisposed())
			// initially create ad new find replace dialog
			instance = ContextInjectionFactory.make(E4FindReplaceDialog.class, context);
		else if (contextWindow != context.get(MWindow.class)) {
			// if find replace dialog already created but context window has changed recreate the dialog
			instance.close();
			instance = ContextInjectionFactory.make(E4FindReplaceDialog.class, context);
		}

		// update context window
		contextWindow = context.get(MWindow.class);

		// display the dialog with updated contents
		instance.getShell().setActive();
		instance.setTemplate(bm.wIsSet("primarySelectedEntity") && 
				!Matcher.matchImpl(CommonsEntityDescriptorEnum.RootFragment, bm.wGet("primarySelectedEntity")) ?
						EntityUtils.clone(bm.wGet("primarySelectedEntity")) : CommonsEntityFactory.instance.createResolver());
	}
}
