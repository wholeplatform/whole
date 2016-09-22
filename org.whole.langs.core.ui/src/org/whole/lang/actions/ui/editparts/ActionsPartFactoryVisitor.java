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
package org.whole.lang.actions.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.actions.model.ActionCall;
import org.whole.lang.actions.model.ContextMenuActions;
import org.whole.lang.actions.model.GuardedAction;
import org.whole.lang.actions.model.IActionsEntity;
import org.whole.lang.actions.model.Label;
import org.whole.lang.actions.model.LanguageActionFactory;
import org.whole.lang.actions.model.MenuActions;
import org.whole.lang.actions.model.Name;
import org.whole.lang.actions.model.Namespace;
import org.whole.lang.actions.model.SimpleAction;
import org.whole.lang.actions.model.ToolbarActions;
import org.whole.lang.actions.model.URI;
import org.whole.lang.actions.model.Version;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;
import org.whole.lang.actions.visitors.ActionsIdentityDefaultVisitor;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.ui.editparts.ContentDataEntityPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.LanguageURINamespacePart;
import org.whole.lang.ui.editparts.ModuleNameTextualEntityPart;
import org.whole.lang.ui.editparts.ModuleNamespaceTextualEntityPart;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ActionsPartFactoryVisitor extends ActionsIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IActionsEntity) modelEntity).accept(this);
		return part;
	}

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		part = new org.whole.lang.ui.editparts.PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	@Override
	public void visit(IActionsEntity entity) {
		part = TablePartFactory.instance().createEditPart(context, entity);
	}

	@Override
	public void visit(LanguageActionFactory entity) {
		part = new LanguageActionFactoryPart();
	}

	@Override
	public void visit(ToolbarActions entity) {
		part = new ToolbarActionsPart();
	}

	@Override
	public void visit(ContextMenuActions entity) {
		part = new ContextMenuActionsPart();
	}

	@Override
	public void visit(MenuActions entity) {
		part = new MenuActionsPart();
	}

	@Override
	public void visit(SimpleAction entity) {
		part = new SimpleActionPart();
	}
	
	@Override
	public void visit(GuardedAction entity) {
		part = new GuardedActionPart();
	}
	
	@Override
	public void visit(Label entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(ActionsEntityDescriptorEnum.ActionCall, parent)) {
				part = new LabelPart();
				return;
			}
		}
		part = new ContentDataEntityPart();
	}
	
	@Override
	public void visit(ActionCall entity) {
		part = new ActionCallPart();
	}

	public void visit(URI entity) {
		IEntity parent = entity.wGetParent();
		if (EntityUtils.hasParent(entity) && Matcher.match(ActionsEntityDescriptorEnum.LanguageActionFactory, parent) && parent.wGet(ActionsFeatureDescriptorEnum.targetLanguage) == entity)
			part = new LanguageURINamespacePart();
		else
			part = new ContentTextualEntityPart();
	}
	public void visit(Namespace entity) {
		part = new ModuleNamespaceTextualEntityPart();
	}
	@Override
	public void visit(Name entity) {
		part = new ModuleNameTextualEntityPart();
	}
	public void visit(Version entity) {
		part = new ContentTextualEntityPart();
	}
}
