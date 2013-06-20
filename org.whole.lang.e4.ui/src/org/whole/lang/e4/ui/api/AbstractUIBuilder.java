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
import org.eclipse.jface.action.IContributionItem;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.e4.ui.expressions.ActionsVisibleWhen;
import org.whole.lang.e4.ui.expressions.ContentAssistVisibleWhen;
import org.whole.lang.e4.ui.expressions.FeatureAssistVisibleWhen;
import org.whole.lang.e4.ui.expressions.NotationsVisibleWhen;
import org.whole.lang.e4.ui.expressions.ValidSingleSelectionVisibleWhen;
import org.whole.lang.e4.ui.expressions.VisibilityExpression;
import org.whole.lang.e4.ui.menu.ActionsCompositeContributionItem;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.editparts.IEntityPart;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public abstract class AbstractUIBuilder<I, C extends I> implements IUIBuilder<I, C> {
	protected static final FeatureDescriptor[] actionMenus = new FeatureDescriptor[] {
		ActionsFeatureDescriptorEnum.sourceMenuActions,
		ActionsFeatureDescriptorEnum.refactorMenuActions,
		ActionsFeatureDescriptorEnum.translateMenuActions,
		ActionsFeatureDescriptorEnum.analyzeMenuActions,
		ActionsFeatureDescriptorEnum.migrateMenuActions,
	};

	protected IContextProvider contextProvider;
	private final ContentAssistVisibleWhen contentAssistVisibleWhen;
	private final ValidSingleSelectionVisibleWhen validSingleSelectionVisibleWhen;
	private final FeatureAssistVisibleWhen featureAssistVisibleWhen;
	private final NotationsVisibleWhen notationsVisibleWhen;

	public AbstractUIBuilder(IContextProvider contextProvider) {
		this.contextProvider = contextProvider;
		this.contentAssistVisibleWhen = new ContentAssistVisibleWhen();
		this.validSingleSelectionVisibleWhen = new ValidSingleSelectionVisibleWhen();
		this.featureAssistVisibleWhen = new FeatureAssistVisibleWhen();
		this.notationsVisibleWhen = new NotationsVisibleWhen();
	}

	private final IBindingManager emptyBindings = E4Utils.createSelectionBindings(Collections.<IEntityPart>emptyList(), null);
	protected IBindingManager getBindings() {
		ESelectionService selectionService = contextProvider.getContext().get(ESelectionService.class);
		return selectionService.getSelection() instanceof IBindingManager ?
				(IBindingManager) selectionService.getSelection() : emptyBindings;
	}

	protected ContentAssistVisibleWhen getContentAssistVisibleWhen() {
		return contentAssistVisibleWhen;
	}
	protected ValidSingleSelectionVisibleWhen getValidSingleSelectionVisibleWhen() {
		return validSingleSelectionVisibleWhen;
	}
	protected FeatureAssistVisibleWhen getFeatureAssistVisibleWhen() {
		return featureAssistVisibleWhen;
	}
	public NotationsVisibleWhen getNotationsVisibleWhen() {
		return notationsVisibleWhen;
	}

	@Override
	public void addRemoveItem() {
		C menu = createMenu(REMOVE_LABEL, getValidSingleSelectionVisibleWhen());
		addItem(menu);
		C previous = setContainer(menu);

		addDeleteItem();
		addDefaultItem();

		setContainer(previous);
	}

	@Override
	public void addSourceItem() {
		FeatureDescriptor menu = ActionsFeatureDescriptorEnum.sourceMenuActions;
		VisibilityExpression expression = new ActionsVisibleWhen(menu);
		IContributionItem ici = new ActionsCompositeContributionItem(contextProvider, menu);
		addActionsItem(SOURCE_LABEL, expression, ici);
	}
	@Override
	public void addRefactorItem() {
		FeatureDescriptor menu = ActionsFeatureDescriptorEnum.refactorMenuActions;
		VisibilityExpression expression = new ActionsVisibleWhen(menu);
		IContributionItem ici = new ActionsCompositeContributionItem(contextProvider, menu);
		addActionsItem(REFACTOR_LABEL, expression, ici);
	}
	@Override
	public void addTranslateItem() {
		FeatureDescriptor menu = ActionsFeatureDescriptorEnum.translateMenuActions;
		VisibilityExpression expression = new ActionsVisibleWhen(menu);
		IContributionItem ici = new ActionsCompositeContributionItem(contextProvider, menu);
		addActionsItem(TRANSLATE_LABEL, expression, ici);
	}
	@Override
	public void addAnalyzeItem() {
		FeatureDescriptor menu = ActionsFeatureDescriptorEnum.analyzeMenuActions;
		VisibilityExpression expression = new ActionsVisibleWhen(menu);
		IContributionItem ici = new ActionsCompositeContributionItem(contextProvider, menu);
		addActionsItem(ANALYZE_LABEL, expression, ici);
	}
	@Override
	public void addMigrateItem() {
		FeatureDescriptor menu = ActionsFeatureDescriptorEnum.migrateMenuActions;
		VisibilityExpression expression = new ActionsVisibleWhen(menu);
		IContributionItem ici = new ActionsCompositeContributionItem(contextProvider, menu);
		addActionsItem(MIGRATE_LABEL, expression, ici);
	}

	protected abstract C createMenu(String label, VisibilityExpression expression);
	protected abstract void addItem(I item);
	protected abstract void addActionsItem(String menuLabel, VisibilityExpression expression, IContributionItem ici);
}
