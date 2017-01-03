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
package org.whole.lang.e4.ui.dialogs;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.Active;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
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
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.actions.E4KeyHandler;
import org.whole.lang.e4.ui.actions.E4NavigationKeyHandler;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.iterators.MatcherIterator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IPartFocusListener;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class E4FindReplaceDialog extends E4Dialog {
	private static final int FIND_ID = IDialogConstants.CLIENT_ID + 1;
	private static final int REPLACE_ID = IDialogConstants.CLIENT_ID + 2;
	private static final int REPLACE_FIND_ID = IDialogConstants.CLIENT_ID + 3;
	private static final int REPLACE_ALL_ID = IDialogConstants.CLIENT_ID + 4;
	private static final int VIEWER_MINIMUM_HEIGHT = 200;
	private static final int VIEWER_MINIMUM_WIDTH = 400;

	protected MatcherIterator<IEntity> iterator;
	protected IBindingManager bindings;
	protected IBindingManager selection;
	protected boolean selectionTracking;
	protected Control replaceArea;
	protected E4GraphicalViewer replaceViewer;
	protected ActionRegistry replaceActionRegistry;
	protected Control buttonPanel;
	protected Control statusPanel;
	protected Label statusLabel;
	protected IEntity foundEntity;
	protected boolean freshTemplate;

	@Inject
	public E4FindReplaceDialog(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		super(shell);
		setShellStyle(getShellStyle() ^ SWT.APPLICATION_MODAL);
		setBlockOnOpen(false);
		this.iterator = IteratorFactory.descendantOrSelfMatcherIterator();
		this.bindings = BindingManagerFactory.instance.createArguments();
		enableSelectionTracking(true);
		clearFoundEntity();
		clearFreshTemplate();
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(IE4UIConstants.FIND_REPLACE_DIALOG_TEXT);
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
		IEclipseContext params = EclipseContextFactory.create();
		params.set("parent", parent);
		replaceViewer = ContextInjectionFactory.make(E4GraphicalViewer.class, context, params);
		replaceViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		replaceViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateSelection(E4Utils.createSelectionBindings(event, context));
			}
		});
		replaceViewer.getControl().addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			}

			@SuppressWarnings("unchecked")
			@Override
			public void focusGained(FocusEvent e) {
				context.set(IEntityPartViewer.class, replaceViewer);
				context.set(ActionRegistry.class, replaceActionRegistry);
				updateSelection(E4Utils.createSelectionBindings(replaceViewer.getSelectedEditParts(), replaceViewer, context));
			}
		});
		replaceViewer.addPartFocusListener(new IPartFocusListener() {
			@SuppressWarnings("unchecked")
			public void focusChanged(IEntityPart oldPart, IEntityPart newPart) {
				updateSelection(E4Utils.createSelectionBindings(replaceViewer.getSelectedEditParts(), replaceViewer, context));
			}
		});

		E4KeyHandler keyHandler = new E4KeyHandler(context);
		keyHandler.setParent(new E4NavigationKeyHandler(context));
		replaceViewer.setKeyHandler(keyHandler);
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
	protected Control createButtonBar(Composite parent) {
		buttonPanel = createButtonPanel(parent);
		statusPanel = createStatusPanel(parent);
		return buttonPanel;
	}

	protected Control createButtonPanel(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(-2, false);
		composite.setLayout(layout);
		
		//FIXME workaround to prevent button reordering on Shell.setDefaultButton()
		final Button button = createButton(composite, FIND_ID, IE4UIConstants.FIND_BUTTON_TEXT, false);
		getShell().addShellListener(new ShellAdapter() {
			@Override
			public void shellActivated(ShellEvent e) {
				((Shell) e.widget).setDefaultButton(button);
			}
		});

		createButton(composite, REPLACE_ID, IE4UIConstants.REPLACE_BUTTON_TEXT, false);
		createButton(composite, REPLACE_FIND_ID, IE4UIConstants.REPLACE_FIND_BUTTON_TEXT, false);
		createButton(composite, REPLACE_ALL_ID, IE4UIConstants.REPLACE_ALL_BUTTON_TEXT, false);
		composite.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, true, false));
		return composite;
	}
	
	protected Control createStatusPanel(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		composite.setLayout(layout);
		statusLabel = new Label(composite, SWT.LEFT);
		statusLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		Button button = createButton(composite, IDialogConstants.CLOSE_ID, "Close", false);
		GridData gridData = (GridData) button.getLayoutData();
		gridData.horizontalAlignment = SWT.RIGHT;
		gridData.verticalAlignment = SWT.BOTTOM;
		gridData.grabExcessHorizontalSpace = gridData.grabExcessVerticalSpace = false;
		composite.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false));
		return composite;
	}

	protected void updateButtonsEnablement(boolean enabled) {
		Button button = getButton(REPLACE_FIND_ID);
		if (button != null)
			button.setEnabled(enabled);
		button = getButton(REPLACE_ID);
		if (button != null)
			button.setEnabled(enabled);
	}

	protected Control getButtonPanel() {
		return buttonPanel;
	}
	protected Control getStatusPanel() {
		return statusPanel;
	}
	protected void setStatusMessage(String message) {
		statusLabel.setText(message);
	}

	@Override
	protected void buttonPressed(int buttonId) {
		super.buttonPressed(buttonId);

		clearFreshTemplate();

		boolean state = enableSelectionTracking(false);
		try {
			switch (buttonId) {
			case FIND_ID:
				doFind();
				break;
	
			case REPLACE_ID:
				doReplace(true);
				break;
	
			case REPLACE_FIND_ID:
				doReplace(false);
				doFind();
				break;
	
			case REPLACE_ALL_ID:
				doReplaceAll();
				break;
	
			case IDialogConstants.CLOSE_ID:
			default:
				okPressed();
				break;
			}
		} finally {
			enableSelectionTracking(state);
		}
	}

	protected void doFind() {
		iterator.withPattern(viewer.getEntityContents());
		if (findNext(true))
			selectAndReveal(getFoundEntity());
	}
	protected void doReplace(boolean updateSelection) {
		if (!hasFoundEntity())
			return;

		final IEntity replacement = EntityUtils.clone(replaceViewer.getEntityContents());
		Matcher.substitute(replacement, bindings, false);
		ModelTransactionCommand command = new ModelTransactionCommand();
		try {
			command.setModel(getFoundEntity());
			command.begin();
			iterator.set(replacement);
			command.commit();
		} catch (Exception e) {
			command.rollbackIfNeeded();
		} finally {
			clearFoundEntity();
		}
		IEntityPartViewer viewer = (IEntityPartViewer) selection.wGetValue("viewer");
		viewer.getCommandStack().execute(command);
		if (updateSelection) {
			Control control = viewer.getControl();
			control.getDisplay().asyncExec(new Runnable() {
				@Override
				public void run() {
					boolean state = enableSelectionTracking(false);
					selectAndReveal(replacement);
					enableSelectionTracking(state);
				}
			});
		}
	}
	protected void doReplaceAll() {
		IEntity self = selection.wGet("self");
		iterator.reset(self);

		if (!findNext(true))
			return;

		boolean state = enableSelectionTracking(false);
		IEntity replacement = replaceViewer.getEntityContents();
		IEntity lastReplaced = null;
		ModelTransactionCommand command = new ModelTransactionCommand();
		command.setModel(getFoundEntity());
		try {
			command.begin();
			do {
				lastReplaced = EntityUtils.clone(replacement);
				Matcher.substitute(lastReplaced, bindings, false);
				iterator.set(lastReplaced);
			} while (findNext(true));
			command.commit();
		} catch (Exception e) {
			command.rollbackIfNeeded();
		} finally {
			clearFoundEntity();
		}
		IEntityPartViewer viewer = (IEntityPartViewer) selection.wGetValue("viewer");
		viewer.getCommandStack().execute(command);
		Control control = viewer.getControl();
		if (lastReplaced != null) {
			final IEntity revealEntity = lastReplaced;
			control.getDisplay().asyncExec(new Runnable() {
				@Override
				public void run() {
					boolean state = enableSelectionTracking(false);
					selectAndReveal(revealEntity);
					enableSelectionTracking(state);
				}
			});
		}
		enableSelectionTracking(state);
	}

	protected void selectAndReveal(IEntity entity) {
		IEntityPartViewer viewer = (IEntityPartViewer) selection.wGetValue("viewer");
		viewer.selectAndReveal(entity);
	}

	@Inject
	protected void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager selection,@Named(IServiceConstants.ACTIVE_PART) Object aPart, @Active MPart activePart, MPart part) {
		if (getShell() == null || getShell().isDisposed())
			return;

		if (selection == null || !isSelectionTracking() || selection.wGetValue("viewer") == viewer || selection.wGetValue("viewer") == replaceViewer)
			return;
		
		this.selection = selection.clone();
		IEntity self = this.selection.wGet("self");
		iterator.reset(self);
		if (this.selection.wIsSet("primarySelectedEntity")) {
			IEntity primarySelectedEntity = this.selection.wGet("primarySelectedEntity");
			if (primarySelectedEntity != self) {
				iterator.skipToSame(primarySelectedEntity);
				if (isFreshTemplate())
					findNext(false);
			}
		}
	}

	protected boolean isSelectionTracking() {
		return selectionTracking;
	}
	protected boolean enableSelectionTracking(boolean enable) {
		boolean state = selectionTracking;
		selectionTracking = enable;
		return state;
	}

	protected boolean findNext(boolean updateStatus) {
		iterator.setBindings(bindings);
		boolean hasNext = iterator.hasNext();
		foundEntity = hasNext ? iterator.next() : null;
		updateButtonsEnablement(hasNext);
		if (updateStatus)
			setStatusMessage(hasNext ? "" : IE4UIConstants.PATTERN_NOT_FOUND_TEXT);
		return hasNext;
	}
	protected void clearFoundEntity() {
		foundEntity = null;
		updateButtonsEnablement(false);
	}
	protected IEntity getFoundEntity() {
		return foundEntity;
	}
	protected boolean hasFoundEntity() {
		return foundEntity != null;
	}

	protected void setFreshTemplate() {
		this.freshTemplate = true;
	}
	protected void clearFreshTemplate() {
		this.freshTemplate = false;
	}
	protected boolean isFreshTemplate() {
		return freshTemplate;
	}
	
	public void setTemplate(IEntity template) {
		viewer.setEntityContents(template);
		replaceViewer.setEntityContents(CommonsEntityFactory.instance.createResolver());

		// set dialog minimum size
		Point buttonBarSize = getStatusPanel().getSize();
		Point buttonPanelSize = getButtonPanel().getSize();
		int minWidth = Math.max(VIEWER_MINIMUM_WIDTH, Math.max(buttonBarSize.x, buttonPanelSize.x));
		int minHeight = VIEWER_MINIMUM_HEIGHT + buttonBarSize.y + buttonPanelSize.y;
		getShell().setMinimumSize(new Point(minWidth, minHeight));
		
		setFreshTemplate();
		setStatusMessage("");
	}
}
