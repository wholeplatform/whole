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
package org.whole.lang.e4.ui.api;

import static org.whole.lang.e4.ui.api.IUIConstants.*;

import java.util.Collections;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.expressions.ContentAssistVisibleWhen;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.editparts.IEntityPart;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public abstract class AbstractUIBuilder<I, C extends I> implements IUIBuilder<I, C> {
	protected final IEclipseContext context;
	protected final ActionRegistry actionRegistry;
	protected final ContentAssistVisibleWhen contentAssistVisibleWhen;

	public AbstractUIBuilder(IEclipseContext context, ActionRegistry actionRegistry) {
		this.context = context;
		this.actionRegistry = actionRegistry;
		this.contentAssistVisibleWhen = new ContentAssistVisibleWhen();
	}

	@Override
	public void addRemoveItem() {
		C menu = createMenu(REMOVE_LABEL);
		addItem(menu);
		C previous = setContainer(menu);

		addDeleteItem();
		addDefaultItem();

		setContainer(previous);
	}

	@Override
	public void addSourceItem() {
		addActionsItem(SOURCE_LABEL, ActionsFeatureDescriptorEnum.sourceMenuActions);
	}
	@Override
	public void addRefactorItem() {
		addActionsItem(REFACTOR_LABEL, ActionsFeatureDescriptorEnum.refactorMenuActions);
	}
	@Override
	public void addTranslateItem() {
		addActionsItem(TRANSLATE_LABEL, ActionsFeatureDescriptorEnum.translateMenuActions);
	}
	@Override
	public void addAnalyzeItem() {
		addActionsItem(ANALYZE_LABEL, ActionsFeatureDescriptorEnum.analyzeMenuActions);
	}
	@Override
	public void addMigrateItem() {
		addActionsItem(MIGRATE_LABEL, ActionsFeatureDescriptorEnum.migrateMenuActions);
	}

	private final IBindingManager emptyBindings = E4Utils.createSelectionBindings(Collections.<IEntityPart>emptyList(), null);
	protected IBindingManager getBindings() {
		ESelectionService selectionService = context.get(ESelectionService.class);
		return selectionService.getSelection() instanceof IBindingManager ?
				(IBindingManager) selectionService.getSelection() : emptyBindings;
	}
	
	public ContentAssistVisibleWhen getContentAssistVisibleWhen() {
		return contentAssistVisibleWhen;
	}

	protected abstract C createMenu(String label);
	protected abstract void addItem(I item);
	protected abstract void addActionsItem(String menuLabel, FeatureDescriptor menuFD);
}