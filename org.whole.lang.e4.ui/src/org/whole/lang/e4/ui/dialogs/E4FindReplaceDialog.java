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
package org.whole.lang.e4.ui.dialogs;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.actions.E4KeyHandler;
import org.whole.lang.e4.ui.api.IUIConstants;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.e4.ui.viewers.IPartFocusListener;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.iterators.MatcherIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEntityPart;

/**
 * @author Enrico Persiani
 */
@Singleton
public class E4FindReplaceDialog extends E4Dialog {
	private static final int FIND_ID = IDialogConstants.CLIENT_ID + 1;
	private static final int REPLACE_ID = IDialogConstants.CLIENT_ID + 2;
	private static final int REPLACE_FIND_ID = IDialogConstants.CLIENT_ID + 3;
	private static final int REPLACE_ALL_ID = IDialogConstants.CLIENT_ID + 4;
	private static final int VIEWER_MINIMUM_HEIGHT = 200;
	private static final int VIEWER_MINIMUM_WIDTH = 400;

	protected MatcherIterator<IEntity> iterator;
	protected IBindingManager selection;
	protected boolean selectionTracking;
	protected Control replaceArea;
	protected E4GraphicalViewer replaceViewer;
	protected ActionRegistry replaceActionRegistry;
	protected Control buttonPanel;

	@Inject
	public E4FindReplaceDialog(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		super(shell);
		setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.RESIZE | SWT.TITLE);
		this.iterator = IteratorFactory.descendantOrSelfMatcherIterator();
		this.selectionTracking = true;
		this.buttonPanel = null;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(IUIConstants.FIND_REPLACE_DIALOG_TITLE);
		setBlockOnOpen(false);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL | SWT.SMOOTH);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		super.createDialogArea(sashForm);
		this.replaceArea = createReplaceArea(sashForm);

		return sashForm;
	}

	protected Control createReplaceArea(Composite parent) {
		replaceViewer = new E4GraphicalViewer(parent);
		replaceViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		replaceViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateSelection(E4Utils.createSelectionBindings(event));
			}
		});
		replaceViewer.getControl().addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				context.remove(IEntityPartViewer.class);
				context.remove(ActionRegistry.class);
			}

			@SuppressWarnings("unchecked")
			@Override
			public void focusGained(FocusEvent e) {
				context.set(IEntityPartViewer.class, replaceViewer);
				context.set(ActionRegistry.class, replaceActionRegistry);
				updateSelection(E4Utils.createSelectionBindings(replaceViewer.getSelectedEditParts(), replaceViewer));
			}
		});
		viewer.addPartFocusListener(new IPartFocusListener() {
			@SuppressWarnings("unchecked")
			public void focusChanged(IEntityPart oldPart, IEntityPart newPart) {
				updateSelection(E4Utils.createSelectionBindings(viewer.getSelectedEditParts(), viewer));
			}
		});

		replaceViewer.setKeyHandler(new E4KeyHandler(context));
		replaceViewer.setEntityContents(createDefaultContents());
		context.set(IEntityPartViewer.class, replaceViewer);

		replaceActionRegistry = ContextInjectionFactory.make(ActionRegistry.class, context);
		replaceActionRegistry.registerWorkbenchActions();
		context.set(ActionRegistry.class, replaceActionRegistry);

		replaceViewer.setContextMenu(new ContextMenuProvider(replaceViewer) {
			@Override
			public void buildContextMenu(IMenuManager menuManager) {
				contextMenuProvider.populate(menuManager);
			}
		});
		return parent;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.CLOSE_ID, "Close", false);
	}
	
	@Override
	protected void buttonPressed(int buttonId) {
		super.buttonPressed(buttonId);

		switch (buttonId) {
		case FIND_ID:
			IEntity entityContents = viewer.getEntityContents();
			iterator.withPattern(entityContents);
			if (iterator.hasNext()) {
				selectionTracking = false;
				IEntity next = iterator.next();
				IEntityPartViewer viewer = (IEntityPartViewer) selection.wGetValue("viewer");
				viewer.selectAndReveal(next);
				selectionTracking = true;
			}
			break;

		case IDialogConstants.CLOSE_ID:
		default:
			okPressed();
			break;
		}
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		buttonPanel = createButtonPanel(parent);
		return super.createButtonBar(parent);
	}

	protected Control createButtonPanel(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);
		createButton(composite, FIND_ID, "Find", true);
		createButton(composite, REPLACE_ID, "Replace", false);
		createButton(composite, REPLACE_FIND_ID, "Replace/Find", false);
		createButton(composite, REPLACE_ALL_ID, "Replace All", false);
		layout.numColumns = 2;
		composite.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, true, false));
		return composite;
	}

	protected Control getButtonPanel() {
		return buttonPanel;
	}

	@Inject
	protected void setSelection(@Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager selection) {
		if (!selectionTracking || selection.wGetValue("viewer") == viewer)
			return;

		this.selection = selection.wClone();
		IEntity self = this.selection.wGet("self");
		iterator.reset(self);
		if (this.selection.wIsSet("primarySelectedEntity")) {
			IEntity primarySelectedEntity = this.selection.wGet("primarySelectedEntity");
			if (primarySelectedEntity != self) {
				iterator.skipToSame(primarySelectedEntity);
				if (iterator.hasNext())
					iterator.next();
			}
		}
	}

	public void setTemplate(IEntity template) {
		viewer.setEntityContents(template);
		replaceViewer.setEntityContents(CommonsEntityFactory.instance.createResolver());

		// set dialog minimum size
		Point buttonBarSize = getButtonBar().getSize();
		Point buttonPanelSize = getButtonPanel().getSize();
		int minWidth = Math.max(VIEWER_MINIMUM_WIDTH, Math.max(buttonBarSize.x, buttonPanelSize.x));
		int minHeight = VIEWER_MINIMUM_HEIGHT + buttonBarSize.y + buttonPanelSize.y;
		getShell().setMinimumSize(new Point(minWidth, minHeight));
	}
}
