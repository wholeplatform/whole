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
package org.whole.lang.environment.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.environment.model.Binding;
import org.whole.lang.environment.model.Bindings;
import org.whole.lang.environment.model.ContainmentTuple;
import org.whole.lang.environment.model.ContextViewModel;
import org.whole.lang.environment.model.DebugViewModel;
import org.whole.lang.environment.model.Environment;
import org.whole.lang.environment.model.Environments;
import org.whole.lang.environment.model.ExecutionFrame;
import org.whole.lang.environment.model.ExecutionStack;
import org.whole.lang.environment.model.IEnvironmentEntity;
import org.whole.lang.environment.model.Id;
import org.whole.lang.environment.model.Name;
import org.whole.lang.environment.model.Names;
import org.whole.lang.environment.model.ObjectData;
import org.whole.lang.environment.model.SampleViewModel;
import org.whole.lang.environment.model.Scope;
import org.whole.lang.environment.model.ScopedBindings;
import org.whole.lang.environment.model.StringData;
import org.whole.lang.environment.model.Tuple;
import org.whole.lang.environment.model.VariablesViewModel;
import org.whole.lang.environment.model.Void;
import org.whole.lang.environment.visitors.EnvironmentIdentityDefaultVisitor;
import org.whole.lang.queries.ui.editparts.TuplePart;
import org.whole.lang.queries.ui.editparts.VoidLiteralPart;
import org.whole.lang.ui.editparts.CommaSeparatedCompositeFlowPart;
import org.whole.lang.ui.editparts.CompositeRowPart;
import org.whole.lang.ui.editparts.ContentLightDataEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.ObjectDataEntityPart;
import org.whole.lang.ui.editparts.VariableDataEntityPart;
import org.whole.lang.ui.notations.editparts.QuotedStringDataEntityPart;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;

/**
 * @author Enrico Persiani
 */
public class EnvironmentPartFactoryVisitor extends EnvironmentIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IEnvironmentEntity) modelEntity).accept(this);
		return part;
	}

	@Override
	public void visit(IEnvironmentEntity entity) {
		part = TablePartFactory.instance().createEditPart(context, entity);
	}

	@Override
	public void visit(ContainmentTuple entity) {
		part = new TuplePart();
	}

	@Override
	public void visit(Tuple entity) {
		part = new TuplePart();
	}

	@Override
	public void visit(Void entity) {
		part = new VoidLiteralPart();
	}

	@Override
	public void visit(ContextViewModel entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(SampleViewModel entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(DebugViewModel entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(ExecutionStack entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(ExecutionFrame entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(VariablesViewModel entity) {
		part = new VariablesViewModelPart();
	}

	@Override
	public void visit(Environments entity) {
		part = new CompositeRowPart();
	}

	@Override
	public void visit(Environment entity) {
		part = new EnvironmentPart();
	}

	@Override
	public void visit(Names entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	@Override
	public void visit(ScopedBindings entity) {
		part = new ScopedBindingsTablePart();
	}

	@Override
	public void visit(Scope entity) {
		part = new ScopePart();
	}

	@Override
	public void visit(Bindings entity) {
		part = new BindingsTablePart();
	}

	@Override
	public void visit(Binding entity) {
		part = new BindingPart();
	}

	@Override
	public void visit(Id entity) {
		part = new ContentLightDataEntityPart();
	}

	@Override
	public void visit(Name entity) {
		part = new VariableDataEntityPart();
	}

	@Override
	public void visit(StringData entity) {
		part = new QuotedStringDataEntityPart();
	}

	@Override
	public void visit(ObjectData entity) {
		if (context instanceof BindingPart) {
			part = new ObjectDataEntityPart();
			return;
		}
		super.visit(entity);
	}
}
