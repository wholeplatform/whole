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

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.parts.AbstractE4Part;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.ui.input.IModelInput;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class RevertHandler {
	@Execute
	public void execute(EPartService partService, IModelInput modelInput, 
			@Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) {
		if (E4Utils.isLegacyApplication()) {
			IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
			viewer.setContents((IModelInput) bm.wGetValue("modelInput"), null);
		} else {
			AbstractE4Part part = (AbstractE4Part) partService.getActivePart().getObject();
			part.getViewer().setContents(modelInput, null);
		}
	}
}
