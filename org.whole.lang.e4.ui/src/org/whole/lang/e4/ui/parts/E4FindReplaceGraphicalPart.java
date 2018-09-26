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

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.actions.E4KeyHandler;
import org.whole.lang.e4.ui.actions.E4NavigationKeyHandler;
import org.whole.lang.e4.ui.actions.FindReplaceAction;
import org.whole.lang.e4.ui.actions.FindReplaceAction.IFindAction;
import org.whole.lang.e4.ui.actions.FindReplaceAction.Operation;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.iterators.ExecutableFactory;
import org.whole.lang.iterators.MatcherIterator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.actions.IUpdatableAction;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IPartFocusListener;
import org.whole.lang.ui.editpolicies.TextFeedbackEditPolicy;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class E4FindReplaceGraphicalPart extends E4GraphicalPart {
	protected MatcherIterator<IEntity> iterator;
	protected IBindingManager bindings;
	protected IUpdatableAction[] findReplaceActions;
	protected IEntityPartViewer replaceViewer;
	protected ActionRegistry replaceActionRegistry;
	protected IBindingManager selection;
	protected boolean selectionTracking;
	protected IEntity foundEntity;


	@Override
	protected IEntityPartViewer createEntityViewer(Composite parent) {
		IEntityPartViewer viewer = super.createEntityViewer(parent);
		viewer.setOperationExecutable(false);
		return viewer;
	}

	@PostConstruct
	public void createPartControl(Composite parent) {
		SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL | SWT.SMOOTH);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		super.createPartControl(sashForm);
		createReplaceArea(sashForm);

		E4FindReplaceGraphicalPart.this.iterator = ExecutableFactory.instance.createDescendantOrSelfMatcher();
		E4FindReplaceGraphicalPart.this.bindings = BindingManagerFactory.instance.createArguments();
		findReplaceActions = new IUpdatableAction[Operation.values().length];
		setPattern(CommonsEntityFactory.instance.createResolver());
		setReplacement(CommonsEntityFactory.instance.createResolver());
		enableSelectionTracking(true);
		clearFoundEntity();
	}

	protected boolean singleReplaceEnabled;
	protected void updateButtonsEnablement(boolean singleReplaceEnabled) {
		this.singleReplaceEnabled = singleReplaceEnabled;
		for (Operation operation : Operation.values())
			getFindReplaceAction(operation).update();
	}

	public IUpdatableAction getFindReplaceAction(Operation operation) {
		if (findReplaceActions[operation.ordinal()] == null)
			findReplaceActions[operation.ordinal()] = new FindReplaceAction(context, createFindReplaceAction(operation));
		return findReplaceActions[operation.ordinal()];
	}

	protected IFindAction createFindReplaceAction(Operation operation) {
		switch (operation) {
		case FIND:
			return FindReplaceAction.create(operation, () -> true, () -> doFind());
		case REPLACE:
			return FindReplaceAction.create(operation, () -> singleReplaceEnabled, () -> doReplace(true));
		case REPLACEFIND:
			return FindReplaceAction.create(operation, () -> singleReplaceEnabled, () -> doReplaceFind());
		case REPLACEALL:
			return FindReplaceAction.create(operation, () -> true, () -> doReplaceAll());
		default:
			throw new IllegalStateException("unknown operation");
		}
	}

	protected void showStatusMessage(String message, boolean replacementStatus) {
		if (message != null && !message.isEmpty()) {
			EditPart contents = (replacementStatus ? replaceViewer : getViewer()).getContents();
			contents.installEditPolicy(TextFeedbackEditPolicy.TEXT_FEEDBACK_ROLE, new TextFeedbackEditPolicy(message));
		}
	}

	public IEntityPartViewer getReplaceViewer() {
		return replaceViewer;
	}

	protected Control createReplaceArea(Composite parent) {
		IEclipseContext params = EclipseContextFactory.create();
		params.set("parent", parent);
		replaceViewer = E4Utils.makeGraphicalViewer(context, params);
		replaceViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		replaceViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateSelection(E4Utils.createSelectionBindings(event, context));
			}
		});
		replaceViewer.getControl().addFocusListener(new FocusAdapter() {
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
		actionRegistry.registerKeyActions(replaceViewer.getKeyHandler());
		context.set(ActionRegistry.class, replaceActionRegistry);

		replaceViewer.setContextMenu(new ContextMenuProvider(replaceViewer) {
			@Override
			public void buildContextMenu(IMenuManager menuManager) {
				contextMenuProvider.populate(menuManager);
			}
		});
		return parent;
	}

	protected IEntity getPattern() {
		return getViewer().getEntityContents();
	}
	protected void setPattern(IEntity pattern) {
		getViewer().setEntityContents(pattern);
	}
	protected IEntity getReplacement() {
		return replaceViewer.getEntityContents();
	}
	protected void setReplacement(IEntity replacement) {
		replaceViewer.setEntityContents(replacement);
	}

	protected boolean doFind() {
		boolean found = findNext(true);
		if (found)
			selectAndReveal(getFoundEntity(), false);
		return found;
	}
	protected IEntity doReplace(boolean updateSelection) {
		if (!hasFoundEntity())
			return null;

		final RootFragment replacementWrapper = CommonsEntityFactory.instance.createRootFragment(EntityUtils.clone(getReplacement()).wGetAdapter(CommonsEntityDescriptorEnum.Any));
		Matcher.substitute(replacementWrapper.getRootEntity(), bindings, false);
		IEntity replacement = EntityUtils.remove(replacementWrapper.getRootEntity());
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
		if (updateSelection)
			selectAndReveal(replacement, true);
		return replacement;
	}
	protected void doReplaceFind() {
		final IEntity lastReplaced = doReplace(false);
		if (!doFind()) {
			IEntity parent = lastReplaced.wGetParent();
			int index = parent.wIndexOf(lastReplaced);
			selectAndReveal(parent.wGet(index), true);
		}
	}
	protected void doReplaceAll() {
		IEntity self = selection.wGet("compoundRoot");
		iterator.reset(self);

		if (!findNext(true))
			return;

		int replaced = 0, skipped = 0;
		boolean state = enableSelectionTracking(false);
		IEntity replacement = getReplacement();
		IEntity lastReplaced = null;
		ModelTransactionCommand command = new ModelTransactionCommand();
		command.setModel(getFoundEntity());
		try {
			command.begin();
			do {
				lastReplaced = EntityUtils.clone(replacement);
				Matcher.substitute(lastReplaced, bindings, false);
				iterator.set(lastReplaced);
				replaced += 1;
			} while (findNext(false));
			command.commit();
		} catch (Exception e) {
			command.rollbackIfNeeded();
			skipped += 1;
		} finally {
			clearFoundEntity();
			enableSelectionTracking(state);
		}
		IEntityPartViewer viewer = (IEntityPartViewer) selection.wGetValue("viewer");
		viewer.getCommandStack().execute(command);
		if (lastReplaced != null)
			selectAndReveal(lastReplaced, true);
		String message = String.format("Replaced %d entities", replaced);
		if (skipped > 0)
			message = String.format("%s (%d skipped)", message, skipped);
		showStatusMessage(message, true);
	}

	protected void selectAndReveal(IEntity entity, boolean preventTracking) {
		IEntityPartViewer viewer = (IEntityPartViewer) selection.wGetValue("viewer");
		viewer.getControl().getDisplay().asyncExec(() -> {
			boolean state = enableSelectionTracking(preventTracking ? false : isSelectionTracking());
			try {
				viewer.selectAndReveal(entity);
			} finally {
				enableSelectionTracking(state);
			}
		});
	}

	@Inject
	protected void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) IBindingManager selection) {
		if (selection == null || !isSelectionTracking() ||
				selection.wGetValue("viewer") == getViewer() ||
				selection.wGetValue("viewer") == replaceViewer)
			return;
		
		this.selection = selection.clone();
		IEntity self = this.selection.wGet("compoundRoot");
		iterator.reset(self);
		iterator.setBindings(this.bindings);
		if (this.selection.wIsSet("primarySelectedEntity")) {
			IEntity primarySelectedEntity = this.selection.wGet("primarySelectedEntity");
			if (primarySelectedEntity != self && EntityUtils.isAncestorOrSelf(self, primarySelectedEntity))
				iterator.skipToSame(primarySelectedEntity);
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
		iterator.withPattern(viewer.getEntityContents());
		boolean hasNext = iterator.hasNext();
		foundEntity = hasNext ? iterator.next() : null;
		updateButtonsEnablement(hasNext);
		if (updateStatus && !hasNext)
			showStatusMessage(IE4UIConstants.PATTERN_NOT_FOUND_TEXT, false);
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

	@Inject
	@Optional
	public void setTemplate(@UIEventTopic(IE4UIConstants.TOPIC_UPDATE_FINDREPLACE) IEntity template) {
		setPattern(template);
		iterator.reset(null);
		updateButtonsEnablement(false);
	}
}
