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
package org.whole.lang.ui.actions;

import java.util.List;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.commands.CompositeAddCommand;
import org.whole.lang.ui.commands.ITextCommand;
import org.whole.lang.ui.commands.ReplaceChildCommand;
import org.whole.lang.ui.commands.TextTransactionCommand;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.requests.TextualRequest;
import org.whole.lang.ui.util.ClipboardUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class ModelPasteAction extends AbstractClipboardAction {
	public ModelPasteAction(IWorkbenchPart part) {
		super(part);		

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE_DISABLED));
		setId(ActionFactory.PASTE.getId());
		setText("Paste");
	}

	protected boolean calculateEnabled() {
		IEntity clipboardEntity = Clipboard.instance().getInternalOrNativeEntityContents();

		List<?> selectedObjects = getSelectedObjects();
		if (selectedObjects.size() == 1 && selectedObjects.get(0) instanceof IEntityPart) {
			IEntityPart selectedPart = (IEntityPart) getSelectedObjects().get(0);
			IEntity selectedEntity = selectedPart.getModelEntity();
			EntityDescriptor<?> selectedED = selectedEntity.wGetEntityDescriptor();

			// BEWARE!
			// Immediately after the paste action the original target part is no more available
			// and the selection is set to contain only the RootBaseFragmentPart.
			if (clipboardEntity != null && !CommonsEntityDescriptorEnum.RootFragment.equals(selectedED)) {
				boolean isCompositeTarget = getHilightPosition(selectedPart) >= 0;

				if (!isCompositeTarget && !EntityUtils.isComposite(selectedEntity.wGetParent())
						&& clipboardEntity.wSize() > 1)
					return false;

				EntityDescriptor<?> targetED = isCompositeTarget ?
						selectedEntity.wGetEntityDescriptor(0) :
							selectedEntity.wGetParent().wGetEntityDescriptor(selectedEntity);

				IEntityIterator<IEntity> iterator = IteratorFactory.childIterator();
				iterator.reset(clipboardEntity);
				while (iterator.hasNext()) {
					IEntity entity = iterator.next();
					if (!Matcher.isAssignableFrom(targetED, entity))
						return false;
				}
				return true;
			} else if (Clipboard.instance().getTextContents() != null) {
				GraphicalViewer viewer = getViewer();
				return viewer != null && (ClipboardUtils.hasTextFocus(viewer) ||  ClipboardUtils.hasTextSeletion(viewer));
			}
		}
		return false; 
	}

	public void run() {
		IEntity clipboardEntity = Clipboard.instance().getInternalOrNativeEntityContents();

		IEntityPart selectedPart = (IEntityPart) getSelectedObjects().get(0);
		IEntity selectedEntity = selectedPart.getModelEntity();
		EntityDescriptor<?> selectedED = selectedEntity.wGetEntityDescriptor();

		Command paste;
		if (clipboardEntity != null && !CommonsEntityDescriptorEnum.RootFragment.equals(selectedED)) {
			CompoundCommand compound = new CompoundCommand();
			IEntityIterator<IEntity> iterator = IteratorFactory.childReverseIterator();
			iterator.reset(clipboardEntity);
			IEntity prevChild = EntityUtils.clone(iterator.next());
			IEntity parent;
			int index = getHilightPosition(selectedPart);
			if (index >= 0) {
				CompositeAddCommand add = new CompositeAddCommand();
				add.setComposite(parent = selectedPart.getModelEntity());
				add.setNewChild(prevChild);
				add.setIndex(index);
				compound.add(add);
			} else {
				ReplaceChildCommand replace = new ReplaceChildCommand();
				replace.setParent(parent = selectedPart.getParentModelEntity());
				replace.setOldChild(selectedPart.getModelEntity());
				replace.setNewChild(prevChild);
				compound.add(replace);
			}
			while (iterator.hasNext()) {
				CompositeAddCommand add = new CompositeAddCommand();
				add.setComposite(parent);
				add.setPrevChild(prevChild);
				add.setNewChild(prevChild = EntityUtils.clone(iterator.next()));
				compound.add(add);
			}
			paste = compound;
		} else {
			ITextualEntityPart textualEntityPart = (ITextualEntityPart) getViewer().getFocusEditPart();
			String text = Clipboard.instance().getTextContents();
			Command command = textualEntityPart.getCommand(TextualRequest.createInsertRequest(text));

			if (command instanceof ITextCommand) {
				TextTransactionCommand transactionCommand = new TextTransactionCommand();
				transactionCommand.setModel(selectedEntity);
				transactionCommand.merge((ITextCommand) command);
				paste = transactionCommand;
			} else
				paste = command;
		}

		if (paste != null) {
			paste.setLabel(getText());
			execute(paste);
		}
	}
}
