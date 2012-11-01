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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.dialogs.IImportAsModelDialog;
import org.whole.lang.ui.dialogs.ImportAsModelDialogFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.util.ClipboardUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class ModelPasteAsAction extends AbstractClipboardAction {
	public ModelPasteAsAction(IWorkbenchPart part) {
		super(part);		

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE_DISABLED));
		setId("paste as");
		setText("Paste As");
	}

	protected boolean calculateEnabled() {
		IEntity clipboardEntity = Clipboard.instance().getEntityContents();

		if (clipboardEntity != null)
			return true;

		return Clipboard.instance().getTextContents() != null;
	}

	public void run() {
		IEntity clipboardEntity = Clipboard.instance().getEntityContents();

		Shell shell = getWorkbenchPart().getSite().getShell();
		IImportAsModelDialog dialog = ImportAsModelDialogFactory.instance().createImplicitElementImportAsModelDialog(shell, "Paste As");
		if (!dialog.show())
			return;

		IPersistenceKit persistenceKit = dialog.getPersistenceKit();
		EntityDescriptor<?> stage = dialog.getStage();

		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		IEntity entity = null;
		if (clipboardEntity != null && ReflectionFactory.getDefaultPersistenceKit().equals(persistenceKit))
			entity = clipboardEntity;
		else {
			String text;
			if (clipboardEntity != null) {
				StringBuilder sb = new StringBuilder(1024);
				for (int i=0; i<clipboardEntity.wSize(); i++)
					sb.append(PrettyPrinterOperation.toPrettyPrintString(clipboardEntity.wGet(i)));
				text = sb.toString();
			} else
				text = Clipboard.instance().getTextContents();
			
			bm.wDefValue("parseFragments", true);
			try {
				if (text != null)
					entity = persistenceKit.readModel(new StringPersistenceProvider(text, bm));
			} catch (Exception e) {
				MessageDialog.openError(shell, "Paste As Error", "Parse failed using the selected persistence.\n\n(See error log for details)");
				WholeUIPlugin.log(e);
				return;
			}
		}

		//FIXME workaround for selections with multiple entities
		if (EntityUtils.isTuple(entity))
			bm.wDef("syntheticRoot", entity);
		boolean hasSyntheticRoot = bm.wIsSet("syntheticRoot");

		IEntityPart selectedPart = getSelectedEntityParts().get(0);
		IEntity selectedEntity = selectedPart.getModelEntity();
		EntityDescriptor<?> selectedED = selectedEntity.wGetEntityDescriptor();

		CompoundCommand paste = new CompoundCommand();
		paste.setLabel(getText());

		List<EditPart> editParts = new ArrayList<EditPart>();
		EditPartFactory factory = ((GraphicalViewer) getWorkbenchPart().getAdapter(GraphicalViewer.class)).getEditPartFactory();

		if (!CommonsEntityDescriptorEnum.RootFragment.equals(selectedED)) {
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

			while (iterator.hasNext()) {
				IEntity stageEntity = EntityUtils.clone(iterator.next());
				stageEntity = ClipboardUtils.conditionalStageAdd(selectedEntity, stage, stageEntity, needsCompositeTarget);
				editParts.add(ClipboardUtils.createEditPart(factory, stageEntity));
			}
		}

		if (editParts.isEmpty())
			return;

		ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_ADD);
		request.setEditParts(editParts);
		request.setLocation(calculateTargetLocation(selectedPart));
		paste.add(selectedPart.getCommand(request));
		execute(paste);
	}
}
