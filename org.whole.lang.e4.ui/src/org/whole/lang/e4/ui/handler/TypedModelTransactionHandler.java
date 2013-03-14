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

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.gef.commands.CommandStack;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.ui.commands.ModelTransactionCommand;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public abstract class TypedModelTransactionHandler {
	@CanExecute
	public boolean canExecute(@Named(ED_URI_PARAMETER_ID) String edUri,
			@Optional @Named(FD_URI_PARAMETER_ID) String fdUri,
			@Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) {
		try {
			bm.wEnterScope();
			defineBindings(edUri, fdUri, bm);
			return isEnabled(bm);
		} finally {
			bm.wExitScope();
		}
	}

	@Execute
	public void execute(@Named(ED_URI_PARAMETER_ID) String edUri,
			@Optional @Named(FD_URI_PARAMETER_ID) String fdUri,
			@Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm,
			E4GraphicalViewer viewer) throws Exception {
		CommandStack commandStack = viewer.getEditDomain().getCommandStack();
		ModelTransactionCommand mtc = new ModelTransactionCommand(bm.wGet("primarySelectedEntity"), getLabel(bm));
		try {
			bm.wEnterScope();
			defineBindings(edUri, fdUri, bm);

			mtc.begin();
			run(bm);
			mtc.commit();
			if (mtc.canUndo())
				commandStack.execute(mtc);
		} catch (RuntimeException e) {
			mtc.rollback();
			throw e;
		} finally {
			bm.wExitScope();
		}
	}

	protected void defineBindings(String edUri, String fdUri, IBindingManager bm) {
		bm.wDefValue("entityDescriptor", CommonsDataTypePersistenceParser.parseEntityDescriptor(edUri));
		if (fdUri != null)
			bm.wDefValue("featureDescriptor", CommonsDataTypePersistenceParser.parseFeatureDescriptor(fdUri));
	}

	public abstract boolean isEnabled(IBindingManager bm);
	public abstract void run(IBindingManager bm);
	public abstract String getLabel(IBindingManager bm);
}
