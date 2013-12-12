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

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Viewport;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
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
		if (entities.wSize() > 0)
			bm.wDef("primarySelectedEntity", entities.wGet(0));
	}

	//TODO convert to IEntityPartViewer.selectAndReveal(IEntity entity)
	public static void selectAndReveal(EditPartViewer viewer, IEntity entity) {
		IEntityPart linkPart = (IEntityPart) viewer.getEditPartRegistry().get(entity);

		if (linkPart != null) {
			viewer.reveal(linkPart);
			viewer.select(linkPart);
		}
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
}
