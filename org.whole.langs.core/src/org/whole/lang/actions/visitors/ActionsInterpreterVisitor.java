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
package org.whole.lang.actions.visitors;

import org.whole.lang.actions.model.ActionCall;
import org.whole.lang.actions.model.ContextMenuActions;
import org.whole.lang.actions.model.GuardedAction;
import org.whole.lang.actions.model.LanguageActionFactory;
import org.whole.lang.actions.model.Name;
import org.whole.lang.actions.model.SimpleAction;
import org.whole.lang.actions.model.ToolbarActions;
import org.whole.lang.actions.model.URI;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.resources.ActionsRegistry;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.operations.ValidatorOperation;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.DynamicContentAssistVisitor;
import org.whole.lang.visitors.DynamicGeneratorVisitor;
import org.whole.lang.visitors.DynamicInterpreterVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/**
 * @author Riccardo Solmi
 */
public class ActionsInterpreterVisitor extends ActionsTraverseAllVisitor {
	protected String name;
	protected String uri;
	protected ILanguageKit languageKit;
	public enum WholeAction {VALUE_ASSIST, VALIDATOR, NORMALIZER, PRETTY_PRINTER, INTERPRETER, GENERATOR};
	protected WholeAction wholeAction;

    @Override
    public void visit(LanguageActionFactory entity) {
    	entity = NormalizerOperation.normalize(EntityUtils.clone(entity));

		ActionsRegistry.instance().addResource(entity, entity.getUri().getValue(), false);

    	entity.getName().accept(this);
		entity.getTargetLanguage().accept(this);
		entity.getToolbarActions().accept(this);
		entity.getContextMenuActions().accept(this);

		setResult(BindingManagerFactory.instance.createVoid());
    }

    protected String actionsUri;
    protected String getActionsUri(IEntity entity) {
		if (actionsUri == null) {
			LanguageActionFactory laf = Matcher.findAncestor(ActionsEntityDescriptorEnum.LanguageActionFactory, entity);
			actionsUri = laf != null ? laf.getUri().getValue() : getBindings().wStringValue("actionsUri");
		}
		return actionsUri;
    }

    @Override
    public boolean visitAdapter(IEntityAdapter entity) {
		if (!EntityUtils.isResolver(entity))
			stagedVisit(entity.wGetAdaptee(false));
		return false;
    }

    @Override
    public void visit(ActionCall entity) {
    	handleCancelRequest();
    	DynamicCompilerOperation.compile(entity, getBindings());
    }

	@Override
	public void visit(URI entity) {
		uri = entity.wStringValue();
	}

	@Override
	public void visit(Name entity) {
		name = entity.wStringValue();
	}

	@Override
	public void visit(ToolbarActions entity) {
		if (uri == null)
			return;

		wholeAction = WholeAction.VALIDATOR;
		entity.getValidatorAction().accept(this);

		wholeAction = WholeAction.NORMALIZER;
		entity.getNormalizerAction().accept(this);

		wholeAction = WholeAction.PRETTY_PRINTER;
		entity.getPrettyPrinterAction().accept(this);

		wholeAction = WholeAction.INTERPRETER;
		entity.getInterpreterAction().accept(this);

		wholeAction = WholeAction.GENERATOR;
		entity.getGeneratorAction().accept(this);
	}

	@Override
	public void visit(GuardedAction entity) {
		ActionsRegistry.instance().putFunctionModel(
				getActionsUri(entity)+"#"+entity.getName().getValue(), entity);

		IBindingManager bm = getBindings();
    	if (!bm.wIsSet("LazyInterpretation") || !bm.wBooleanValue("LazyInterpretation"))
	   		DynamicCompilerOperation.compile(entity, getBindings());
	}

	@Override
	public void visit(SimpleAction entity) {
		String functionUri = getActionsUri(entity)+"#"+entity.getName().getValue();
		ActionsRegistry.instance().putFunctionModel(functionUri, entity);

		IBindingManager bm = getBindings();
    	if (!bm.wIsSet("LazyInterpretation") || !bm.wBooleanValue("LazyInterpretation"))
	   		DynamicCompilerOperation.compile(entity, getBindings());

		if (languageKit == null) {
			String contextUri = getBindings().wIsSet("contextURI") ? getBindings().wStringValue("contextURI") : null;
			languageKit = ReflectionFactory.getLanguageKit(uri, true, contextUri);
		}

		switch (wholeAction) {
		case VALUE_ASSIST:
			addVisitorFactory(languageKit, ContentAssistOperation.ID,
					DynamicContentAssistVisitor.createVisitorFactory(ActionsRegistry.instance(), functionUri));
			break;
		case VALIDATOR:
			addVisitorFactory(languageKit, ValidatorOperation.ID, functionUri, false);
			break;
		case NORMALIZER:
			addVisitorFactory(languageKit, NormalizerOperation.ID, functionUri, false);
			break;
		case PRETTY_PRINTER:
			addVisitorFactory(languageKit, PrettyPrinterOperation.ID, functionUri, false);
			break;
		case INTERPRETER:
			addVisitorFactory(languageKit, InterpreterOperation.ID, functionUri, true);
			break;
		case GENERATOR:
			addVisitorFactory(languageKit, ArtifactsGeneratorOperation.ID,
						DynamicGeneratorVisitor.createVisitorFactory(ActionsRegistry.instance(), functionUri));
			break;
		}
	}

	protected void addVisitorFactory(ILanguageKit languageKit, String operationId, String functionUri, boolean stage0Only) {
		addVisitorFactory(languageKit, operationId, DynamicInterpreterVisitor.createVisitorFactory(ActionsRegistry.instance(), functionUri, stage0Only));
	}
	protected void addVisitorFactory(ILanguageKit languageKit, String operationId, IVisitorFactory visitorFactory) {
		languageKit.addVisitorFactory(operationId, visitorFactory);
	}

	@Override
	public void visit(ContextMenuActions entity) {
		wholeAction = WholeAction.VALUE_ASSIST;
		entity.getValueAssistActions().accept(this);

		entity.getSourceMenuActions().accept(this);
		entity.getRefactorMenuActions().accept(this);
		entity.getTranslateMenuActions().accept(this);
		entity.getAnalyzeMenuActions().accept(this);
		entity.getMigrateMenuActions().accept(this);
	}
}
