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
package org.whole.lang.e4.ui.jobs;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.gef.commands.CommandStack;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.BehaviorUtils;

/**
 * @author Enrico Persiani
 */
//TODO merge with DeriveModelRunnable ???
public class FunctionRunnable extends AbstractRunnableWithProgress {
	protected String functionUri;

	public FunctionRunnable(IEclipseContext context, IBindingManager bm, String label, String functionUri) {
		super(context, bm, label);
		this.functionUri = functionUri;
	}

	@Override
	public void run(IOperationProgressMonitor pm) throws InvocationTargetException, InterruptedException {
		//FIXME workaround for missing caret update events (no selection update is performed)
		E4Utils.defineCaretBindings(bm);
		
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		CommandStack commandStack = viewer.getEditDomain().getCommandStack();
		ModelTransactionCommand mtc = new ModelTransactionCommand(bm.wGet("self"), label);

		IEntity result = null;
		pm.beginTask("Executing function "+functionUri+"...", IOperationProgressMonitor.TOTAL_WORK);
		try {
			mtc.begin();
			result = BehaviorUtils.apply(functionUri, bm.wGet("self"), bm);
			mtc.commit();
			if (mtc.canUndo())
				commandStack.execute(mtc);
		} catch (OperationCanceledException e) {
			mtc.rollbackIfNeeded();
		} catch (RuntimeException e) {
			mtc.rollbackIfNeeded();
			throw e;
		} finally {
			bm.setResult(result);
			pm.endTask();
		}
	}
}
