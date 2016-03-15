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
package org.whole.lang.ui.dnd;

import static org.eclipse.gef.RequestConstants.REQ_ADD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.dialogs.IImportAsModelDialog;
import org.whole.lang.ui.dialogs.IImportAsModelDialogFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.util.ClipboardUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class TextTransferDropTargetListener extends AbstractTransferDropTargetListener {
	protected IImportAsModelDialogFactory factory;

	public TextTransferDropTargetListener(EditPartViewer viewer, IImportAsModelDialogFactory factory) {
		super(viewer, TextTransfer.getInstance());
		this.factory = factory;
	}

	@Override
	protected void handleDragOver() {
		getCurrentEvent().feedback = DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;
		super.handleDragOver();
	}

	@Override
	protected Request createTargetRequest() {
		return new ChangeBoundsRequest(REQ_ADD);
	}

	@Override
	protected void updateTargetRequest() {
		ChangeBoundsRequest request = (ChangeBoundsRequest) getTargetRequest();
		request.setEditParts(Collections.EMPTY_LIST);
		request.setLocation(getDropLocation());
	}

	@Override
	protected void handleDrop() {
		super.handleDrop();
		if (getCurrentEvent().detail != DND.DROP_NONE) {
			getViewer().setSelection(StructuredSelection.EMPTY);
			getViewer().getControl().setFocus();
		}
	}

	@Override
	protected Command getCommand() {
		String text = (String) getCurrentEvent().data; 

		Shell shell = getViewer().getControl().getShell();
		IImportAsModelDialog dialog = factory.createImplicitElementImportAsModelDialog(shell, "Drop As", false);
		if (!dialog.show())
			return null;

		IPersistenceKit persistenceKit = dialog.getPersistenceKit();
		EntityDescriptor<?> stage = dialog.getStage();

		try {
			IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
			bm.wDefValue("parseFragments", true);
			IEntity entity = persistenceKit.readModel(new StringPersistenceProvider(text, bm));
			//FIXME workaround for selections with multiple entities
			if (EntityUtils.isTuple(entity))
				bm.wDef("syntheticRoot", entity);
			boolean hasSyntheticRoot = bm.wIsSet("syntheticRoot");

			IEntityIterator<IEntity> iterator;
			boolean needsCompositeTarget = false;
			if (hasSyntheticRoot) {
				IEntity syntheticRoot = bm.wGet("syntheticRoot");
				iterator = IteratorFactory.childIterator();
				iterator.reset(syntheticRoot);
				needsCompositeTarget = syntheticRoot.wSize() > 1;
			} else {
				iterator = IteratorFactory.selfIterator();
				iterator.reset(entity);
			}

			List<IEntityPart> editParts = new ArrayList<IEntityPart>();
			while (iterator.hasNext()) {
				IEntity stageEntity = EntityUtils.clone(iterator.next());
				stageEntity = ClipboardUtils.conditionalStageAdd(getTargetEditPart(), stage, stageEntity, needsCompositeTarget);
				editParts.add(ClipboardUtils.createEditPart(getViewer().getEditPartFactory(), stageEntity));
			}

			ChangeBoundsRequest request = (ChangeBoundsRequest) getTargetRequest();
			request.setEditParts(editParts);

			return super.getCommand();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean isEnabled(DropTargetEvent event) {
		for (TransferData dataType : event.dataTypes)
			if (EditPartsTransfer.instance().isSupportedType(dataType))
				return false;
		return super.isEnabled(event);
	}
}
