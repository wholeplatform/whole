/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.e4.ui.jobs;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.gef.commands.CommandStack;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class ContentAssistRunnable extends AbstractRunnableWithProgress {

	public ContentAssistRunnable(IEclipseContext context, IBindingManager bm) {
		super(context, bm, "generate content assist");
	}

	@Override
	public void run(IOperationProgressMonitor pm) throws InvocationTargetException, InterruptedException {
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		CommandStack commandStack = viewer.getEditDomain().getCommandStack();
		ModelTransactionCommand mtc = new ModelTransactionCommand(bm.wGet("compoundRoot"), label);

		IEntity[] contentAssist = null;
		pm.beginTask("Content assit generation...", IOperationProgressMonitor.TOTAL_WORK);
		try {
			mtc.begin();
			contentAssist = ContentAssistOperation.getContentAssist(bm.wGet("focusEntity"), bm);
			mtc.commit();
			if (mtc.canUndo())
				commandStack.execute(mtc);
		} catch (OperationCanceledException e) {
			mtc.rollbackIfNeeded();
		} catch (RuntimeException e) {
			mtc.rollbackIfNeeded();
			throw e;
		} finally {
			bm.setResult(BindingManagerFactory.instance.createValue(contentAssist));
			pm.endTask();
		}
	}
}
