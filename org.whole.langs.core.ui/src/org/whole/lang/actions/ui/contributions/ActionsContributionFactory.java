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
package org.whole.lang.actions.ui.contributions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.Category;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISources;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.menus.AbstractContributionFactory;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.services.IServiceLocator;
import org.whole.lang.WholePlugin;
import org.whole.lang.actions.model.ContextMenuActions;
import org.whole.lang.actions.model.GuardedAction;
import org.whole.lang.actions.model.LanguageActionFactory;
import org.whole.lang.actions.model.MenuActions;
import org.whole.lang.actions.model.URI;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.resources.ActionsRegistry;
import org.whole.lang.iterators.AbstractPatternFilterIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.resources.IResource;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.resources.Resource;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.menu.WholeMenu;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class ActionsContributionFactory extends AbstractContributionFactory {
	public static final String CATEGORY_ID = WholeUIPlugin.PLUGIN_ID+".category.dynamic.generators";

	protected WholeMenu wholeMenu;
	protected Map<String, List<IHandlerActivation>> activations;

	public ActionsContributionFactory(WholeMenu wholeMenu) {
		super("popup:"+wholeMenu.id, WholePlugin.PLUGIN_ID);

		this.wholeMenu = wholeMenu;
		this.activations = new HashMap<String, List<IHandlerActivation>>();
	}

	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		IMenuService menuService = (IMenuService) serviceLocator.getService(IMenuService.class);
		IEvaluationContext context = menuService.getCurrentState();

		String languageURI;
		switch (UIUtils.calculateSelectionKind(context)) {
		case OTHER:
			return;
		case ENTITY_PART:
			ISelection selection = (ISelection) context.getVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME);
			Object firstElement = ((IStructuredSelection) selection).getFirstElement();
			IEntity model = EntityUtils.getCompoundRoot(((IEntityPart) firstElement).getModelEntity());
			languageURI = model.wGetLanguageKit().getURI();
			break;
		default:
			languageURI = null;
		}

		List<CommandContributionItemParameter> parametersList = new ArrayList<CommandContributionItemParameter>();
		IResourceRegistry<Resource> registry = ActionsRegistry.instance();
		for (IResource resource : registry.getResources(false)) {
			LanguageActionFactory actionsModule = resource.getEntity();
			URI targetLanguage = actionsModule.getTargetLanguage();
			if (languageURI != null && DataTypeUtils.getDataKind(targetLanguage).isString() &&
					!languageURI.equals(targetLanguage.getValue()))
				continue;

			redefineHandlers(serviceLocator, actionsModule);
			AbstractPatternFilterIterator<GuardedAction> i = IteratorFactory.<GuardedAction>childMatcherIterator()
					.withPattern(ActionsEntityDescriptorEnum.GuardedAction);
			i.reset(getActions(actionsModule));
			for (GuardedAction action : i) {
				String actionName = action.getName().getValue();
				String uniqueId = resource.getURI()+'#'+actionName;
				parametersList.add(new CommandContributionItemParameter(
								serviceLocator, uniqueId, uniqueId,
								null, null, null, null, actionName,
								null, null, CommandContributionItem.STYLE_PUSH, null, false));
			}
		}
		if (!parametersList.isEmpty()) {
			Collections.sort(parametersList, new Comparator<CommandContributionItemParameter>() {
				public int compare(CommandContributionItemParameter p1, CommandContributionItemParameter p2) {
					return p1.label.compareTo(p2.label);
				}
			});
			for (CommandContributionItemParameter parameter : parametersList)
				additions.addContributionItem(new CommandContributionItem(parameter), null);
		}
	}

	protected MenuActions getActions(LanguageActionFactory actionsModule) {
		ContextMenuActions actions = actionsModule.getContextMenuActions();
		switch (wholeMenu) {
		case SOURCE:
			return actions.getSourceMenuActions();
		case REFACTOR:
			return actions.getRefactorMenuActions();
		case TRANSLATE:
			return actions.getTranslateMenuActions();
		case ANALYZE:
			return actions.getAnalyzeMenuActions();
		case MIGRATE:
		default:
			return actions.getMigrateMenuActions();
		}
	}
	protected void redefineHandlers(IServiceLocator serviceLocator, LanguageActionFactory actionsModule) {
		ICommandService commandService = (ICommandService) serviceLocator.getService(ICommandService.class);
		final IHandlerService handlerService = (IHandlerService) serviceLocator.getService(IHandlerService.class);

		String uri = actionsModule.getUri().getValue();
		if (activations.containsKey(uri))
			handlerService.deactivateHandlers(activations.remove(uri));

		Category category = commandService.getCategory(CATEGORY_ID);
		if (!category.isDefined())
			category.define("Whole Dynamic Generators", null);

		final List<IHandlerActivation> activationList = new ArrayList<IHandlerActivation>();
		AbstractPatternFilterIterator<GuardedAction> i = IteratorFactory.<GuardedAction>childMatcherIterator()
				.withPattern(ActionsEntityDescriptorEnum.GuardedAction);
		i.reset(getActions(actionsModule));
		for (GuardedAction action : i) {

			final IEntity predicate = action.getEnablerPredicate().wGetAdaptee(false);
			final IEntity transformation =  action.getTransformation().wGetAdaptee(false);

			String name = action.getName().getValue();
			final String uniqueId = uri+'#'+name;

			Command command = commandService.getCommand(uniqueId);
			if (!command.isDefined())
				command.define(name, name, category);

			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					Expression expression = new PredicateExpression(predicate);
					IHandler handler = new TransformationHandler(wholeMenu, predicate, transformation);
					activationList.add(handlerService.activateHandler(uniqueId, handler, expression, true));
				}
			});
		}
		activations.put(uri, activationList);
	}
}
