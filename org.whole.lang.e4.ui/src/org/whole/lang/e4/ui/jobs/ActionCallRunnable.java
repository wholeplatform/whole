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

import static org.whole.lang.e4.ui.actions.IE4UIConstants.*;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.gef.commands.CommandStack;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class ActionCallRunnable extends AbstractRunnableWithProgress {

	public ActionCallRunnable(IEclipseContext context, IBindingManager bm, String label, boolean delayUpdates) {
		super(context, bm, label);
	}

	@Override
	protected boolean isTransactional() {
		return !bm.wBooleanValue("analyzing");
	}

	@Override
	public void run(IOperationProgressMonitor pm) throws InvocationTargetException {
		IEntity model = bm.wGet("self");
		boolean analyzing = bm.wBooleanValue("analyzing");
		if (analyzing) {
			// clone model if is analyzing
			model = EntityUtils.clone(model);
			CommonsEntityFactory.instance.createRootFragment(
					model.wGetAdapter(CommonsEntityDescriptorEnum.Any));
			ReflectionFactory.getHistoryManager(model).setHistoryEnabled(true);

			// map selected entities if analyzing
			IEntity tuple = bm.wGet("selectedEntities");
			int size = tuple.wSize();
			for (int i = 0; i < size; i++)
				tuple.wSet(i, EntityUtils.mapEntity(tuple.wGet(i), model));
			bm.wSet("primarySelectedEntity", EntityUtils.mapEntity(bm.wGet("primarySelectedEntity"), model));
			bm.wSet("focusEntity", EntityUtils.mapEntity(bm.wGet("focusEntity"), model));
		}

		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		final CommandStack commandStack = viewer.getEditDomain().getCommandStack();
		final ModelTransactionCommand mtc = new ModelTransactionCommand(model, label);

		pm.beginTask("executing action", 90, IOperationProgressMonitor.TOTAL_WORK);
		try {
			mtc.begin();
			HandlersBehavior.actionCall(bm);
			mtc.commit();
			if (analyzing) {
				E4Utils.revealPart(context, RESULTS_PART_ID);
				IEventBroker eventBroker = context.get(IEventBroker.class);
				eventBroker.post(IE4UIConstants.TOPIC_UPDATE_RESULTS, bm.getResult());
			} else if (mtc.canUndo()) {
				context.get(UISynchronize.class).syncExec(new Runnable() {
					public void run() {
						commandStack.execute(mtc);
					}
				});
			}
		} catch (OperationCanceledException e) {
			mtc.rollbackIfNeeded();
		} catch (RuntimeException e) {
			mtc.rollbackIfNeeded();
			throw e;
		} finally {
			pm.endTask();
		}
	}
}
