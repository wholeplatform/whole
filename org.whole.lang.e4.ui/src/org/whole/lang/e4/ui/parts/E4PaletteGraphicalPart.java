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
package org.whole.lang.e4.ui.parts;

import static org.whole.lang.e4.ui.actions.IE4UIConstants.*;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.swt.widgets.Composite;
import org.whole.lang.e4.ui.actions.ILinkableSelectionListener;
import org.whole.lang.e4.ui.handler.*;
import org.whole.lang.e4.ui.jobs.ShowingPolicy;
import org.whole.lang.e4.ui.menu.JFaceMenuBuilder;
import org.whole.lang.e4.ui.menu.PopupMenuProvider;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.e4.ui.viewers.E4PaletteGraphicalViewer;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public class E4PaletteGraphicalPart extends AbstractE4DerivedGraphicalPart {
	protected String getDerivationFunction() {
		return "whole:org.whole.lang:ViewDerivationLibrary#derivePaletteViewContents";
	}

	protected IEntityPartViewer createEntityViewer(Composite parent) {
		IEclipseContext params = EclipseContextFactory.create();
		params.set("parent", parent);
		IEntityPartViewer viewer = ContextInjectionFactory.make(E4PaletteGraphicalViewer.class, context, params);
		setSelectionLinkable(createSelectionLinkable(viewer));
		return viewer;
	}

	@Override
	protected IEclipseContext configureSelectionLinkable(IEclipseContext params) {
		params = super.configureSelectionLinkable(params);
		params.set(ILinkableSelectionListener.RESULTS_SHOWING_POLICY, ShowingPolicy.OPTIONAL);
		return params;
	}

	@Override
	protected void registerHandlers() {
		if (E4Utils.isLegacyApplication()) {
			handlerService.activateHandler(EDIT_CUT, UnexecutableHandler.instance());//new CutHandler());
			handlerService.activateHandler(EDIT_COPY, new CopyHandler());
			handlerService.activateHandler(EDIT_PASTE, UnexecutableHandler.instance());//new PasteHandler());
			handlerService.activateHandler(EDIT_SELECT_ALL, UnexecutableHandler.instance());//new SelectAllHandler());
			handlerService.activateHandler(COPY_ENTITY_PATH_COMMAND_ID, new CopyEntityPathHandler());
			handlerService.activateHandler(COPY_AS_IMAGE_COMMAND_ID, new CopyAsImageHandler());
		}
	}
	
	@Override
	protected void configureContextMenu() {
		JFaceMenuBuilder uiBuilder = ContextInjectionFactory.make(JFaceMenuBuilder.class, context);
		contextMenuProvider = new PopupMenuProvider<IContributionItem, IMenuManager>(uiBuilder) {
			@Override
			public void populate(IMenuManager menu) {
				uiBuilder.setContainer(menu);
				uiBuilder.before();

				uiBuilder.addCopyItem();
				uiBuilder.addCopyEntityPathItem();
				uiBuilder.addCopyAsImageItem();

				uiBuilder.after();
			}
		};

		viewer.setContextMenu(new ContextMenuProvider(viewer) {
			@Override
			public void buildContextMenu(IMenuManager menuManager) {
				try {
					if (!getViewer().getEditDomain().isDisabled())
						contextMenuProvider.populate(menuManager);
				} catch (Exception e) {
					getMenu().setVisible(false);
				}
			}
		});

	}
}
