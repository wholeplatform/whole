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
package org.whole.lang.ui.util;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.IEvaluationService;
import org.eclipse.ui.services.IServiceLocator;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.model.Fragment;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class UIUtils {
	public static final String LOCATION_REGEXP = "/(?:(?:(?:\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*)|(?:\\d+))/)*(?:(?:\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*)|(?:\\d+))?";
	public static final Pattern LOCATION_PATTERN = Pattern.compile(LOCATION_REGEXP);

	public static List<IEntityPart> getSelectedEntityParts(IEditorPart editorPart) {
		GraphicalViewer viewer = (GraphicalViewer) editorPart.getAdapter(GraphicalViewer.class);
		return viewer == null ? Collections.<IEntityPart>emptyList() : getSelectedEntityParts(viewer.getSelection());
	}
	public static List<IEntityPart> getSelectedEntityParts(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size()>0 && structuredSelection.getFirstElement() instanceof IEntityPart)
				return getSelectedEntityParts(structuredSelection);
		}
		return Collections.emptyList();
	}
	@SuppressWarnings("unchecked")
	public static List<IEntityPart> getSelectedEntityParts(IStructuredSelection structuredSelection) {
		return (List<IEntityPart>) structuredSelection.toList();
	}
	public static IEntity getSelectedEntities(List<IEntityPart> selectedEntityParts) {
		IEntity selectedEntities = BindingManagerFactory.instance.createTuple();
		for (IEntityPart selectedEntityPart : selectedEntityParts)
			selectedEntities.wAdd(selectedEntityPart.getModelEntity());
		return selectedEntities;
	}

	public static void defSelectedEntities(IBindingManager bm, ISelection selection) {
		defSelectedEntities(bm, getSelectedEntityParts(selection));
	}
	public static void defSelectedEntities(IBindingManager bm, List<IEntityPart> selectedEntityParts) {
		defSelectedEntities(bm, getSelectedEntities(selectedEntityParts));
	}
	public static void defSelectedEntities(IBindingManager bm, IEntity entities) {
		bm.wDef("selectedEntities", entities);
		if (!entities.wIsEmpty())
			bm.wDef("primarySelectedEntity", entities.wGet(0));
	}

	public static IEditorInput getActiveEditorInput(IEvaluationContext context) {
		Object part = context.getVariable(ISources.ACTIVE_PART_NAME);
		if (!(part instanceof IWorkbenchPart))
			return null;
		IWorkbenchPart activePart = (IWorkbenchPart) part;
		Object activeEditor = context.getVariable(ISources.ACTIVE_EDITOR_NAME);
		return activePart == activeEditor && activeEditor instanceof IEditorPart ? ((IEditorPart) activeEditor).getEditorInput() : null;
	}
	public static IEditorPart getActiveEditor() {
		try {
			IServiceLocator serviceLocator = PlatformUI.getWorkbench();
			IEvaluationService evaluationService = (IEvaluationService) serviceLocator.getService(IEvaluationService.class);
			return (IEditorPart) evaluationService.getCurrentState().getVariable(ISources.ACTIVE_EDITOR_NAME);
		} catch (Throwable e) {
			return ActiveEditorHelper.findActiveEditor();
		}
	}
	public static IWorkbenchPart getActivePart() {
		try {
			return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		} catch (Throwable e) {
			return ActiveEditorHelper.findActiveEditor();
		}
	}

	public static void selectAndReveal(EditPartViewer viewer, IEntity entity) {
		IEntityPart linkPart = (IEntityPart) viewer.getEditPartRegistry().get(entity);

		if (linkPart != null) {
			viewer.reveal(linkPart);
			viewer.select(linkPart);
		}
	}

	public static void showInformationDialog(final String title, final String message) {
		final Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		shell.getDisplay().syncExec(new Runnable() {
			public void run() {
				MessageDialog.openInformation(shell, title, message);
			}
		});
	}

	public static int getButtonWidthHint(Composite composite) {
		GC gc = new GC(composite);
		gc.setFont(composite.getFont());
		FontMetrics fFontMetrics = gc.getFontMetrics();
		int widthHint = Dialog.convertHorizontalDLUsToPixels(fFontMetrics, IDialogConstants.BUTTON_WIDTH);
		gc.dispose();
		return widthHint;
	}

	public static IEditorKit getEditorKit(IEntityPart selectedPart) {
		IEditorKit editorKit;

		IEntity parent = selectedPart.getParentModelEntity();
		if (parent != null && EntityUtils.isFragment(parent))
			editorKit = ((Fragment) parent).getRootEntity().wGetEditorKit();
		else
			editorKit = ReflectionFactory.getEditorKit(selectedPart.getModelEntity());

		return editorKit;
	}

	public static Monitor getActiveMonitor() {
		Display display = Display.getCurrent();
		Rectangle bounds = display.getBounds();
		bounds.intersect(display.getActiveShell().getBounds());
		Point center = new Point(bounds.x+bounds.width/2, bounds.y+bounds.height/2);
		Monitor[] monitors = display.getMonitors();
		for (Monitor monitor : monitors)
			if (monitor.getBounds().contains(center))
				return monitor;
		return display.getPrimaryMonitor();
	}

	public static SelectionKind calculateSelectionKind(IEvaluationContext context) {
		Object activeSelection = context.getVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME);
		if (!(activeSelection instanceof ISelection))
			return SelectionKind.OTHER;
		ISelection selection = (ISelection) activeSelection;

		if (selection.isEmpty() || !(selection instanceof IStructuredSelection))
			return ResourceUtils.isAdaptableToFile(UIUtils.getActiveEditorInput(context)) ?
					SelectionKind.EDITOR_INPUT_FILE : SelectionKind.OTHER;
		
		Object firstElement = ((IStructuredSelection) selection).getFirstElement();
		if (firstElement instanceof IEntityPart)
			return SelectionKind.ENTITY_PART;
		else if (ResourceUtils.isAdaptableToFile(firstElement))
			return SelectionKind.WORKSPACE_FILE;
		else
			return SelectionKind.OTHER;
	}

}
