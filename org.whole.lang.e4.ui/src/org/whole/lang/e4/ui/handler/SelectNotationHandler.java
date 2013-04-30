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

import static org.whole.lang.e4.ui.api.IUIConstants.*;

import java.util.Map;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings({"restriction"})
public class SelectNotationHandler {

	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) {
		try {
			return HandlersBehavior.isValidEntityPartSelection(bm, true);
		} catch (Exception e) {
			return false;
		}
	}

	@Execute
	public void execute(@Named(EDITORKIT_ID_PARAMETER_ID) String editorKitId,
			@Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm,
			final IEntityPartViewer viewer, UISynchronize synchronize) {
		IEditorKit editorKit = ReflectionFactory.getEditorKit(editorKitId);
		final IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");

		boolean historyEnabled = ReflectionFactory.getHistoryManager(primarySelectedEntity).setHistoryEnabled(false);

		primarySelectedEntity.wGetModel().setEditorKit(editorKit);

		Map<IEntity, IEntityPart> editPartRegistry = viewer.getEditPartRegistry();
		IEntity fragmentRoot = primarySelectedEntity.wGetModel().getFragment();
		IEntityPart fragmentPart = ModelObserver.getObserver(fragmentRoot, editPartRegistry);
		fragmentPart.rebuild();

		synchronize.asyncExec(new Runnable() {
			public void run() {
				viewer.selectAndReveal(primarySelectedEntity);	
			}				
		});

		ReflectionFactory.getHistoryManager(primarySelectedEntity).setHistoryEnabled(historyEnabled);
	}
}
