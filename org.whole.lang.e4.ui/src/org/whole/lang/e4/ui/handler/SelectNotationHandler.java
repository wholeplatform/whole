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

import static org.whole.lang.e4.ui.actions.IE4UIConstants.*;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class SelectNotationHandler {

	@CanExecute
	public boolean canExecute(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) {
		try {
			return HandlersBehavior.isValidFocusEntityPart(bm);
		} catch (Exception e) {
			return false;
		}
	}

	@Execute
	public void execute(@Optional @Named(EDITORKIT_ID_PARAMETER_ID) String editorKitId,
			@Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm,
			final IEntityPartViewer viewer, UISynchronize synchronize) {
		IEditorKit editorKit = ReflectionFactory.getEditorKit(editorKitId);
		final IEntity focusEntity = bm.wGet("focusEntity");

		focusEntity.wGetModel().setEditorKit(editorKit);

		ModelTransactionCommand command = new ModelTransactionCommand(focusEntity);
		try {
			command.begin();
			IEntity fragmentRoot = EntityUtils.getLanguageFragmentRoot(focusEntity);
			viewer.rebuildNotation(fragmentRoot);
			command.commit();
			if (command.canUndo())
				viewer.getEditDomain().getCommandStack().execute(command);
		} catch (Exception e) {
			command.rollbackIfNeeded();
		}
			
		synchronize.asyncExec(new Runnable() {
			public void run() {
				viewer.selectAndReveal(focusEntity);	
			}				
		});
	}
}
