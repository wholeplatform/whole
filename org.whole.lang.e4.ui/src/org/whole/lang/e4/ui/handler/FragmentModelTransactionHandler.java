/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.gef.commands.CommandStack;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.commands.ModelTransactionCommand;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public abstract class FragmentModelTransactionHandler {

	@CanExecute
	public boolean canExecute(@Named(FRAGMENT_XWL_PARAMETER_ID) String prototypeXwl, @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm) throws Exception {
		bm.wDef("fragmentEntity", ReflectionFactory.getDefaultPersistenceKit().readModel(new StringPersistenceProvider(prototypeXwl)));
		return isEnabled(bm);
	}

	@Execute
	public void execute(@Named(FRAGMENT_XWL_PARAMETER_ID) String prototypeXwl, @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager bm, E4GraphicalViewer viewer) throws Exception {
		IEntity prototypeEntity = ReflectionFactory.getDefaultPersistenceKit().readModel(new StringPersistenceProvider(prototypeXwl));
		bm.wDef("fragmentEntity", prototypeEntity);
		CommandStack commandStack = viewer.getEditDomain().getCommandStack();
		ModelTransactionCommand mtc = new ModelTransactionCommand(bm.wGet("primarySelectedEntity"), getLabel(bm));
		try {
			mtc.begin();
			run(bm);
			mtc.commit();
			if (mtc.canUndo())
				commandStack.execute(mtc);
		} catch (RuntimeException e) {
			mtc.rollback();
			throw e;
		}
	}

	public abstract boolean isEnabled(IBindingManager bm);
	public abstract void run(IBindingManager bm);
	public abstract String getLabel(IBindingManager bm);
}
