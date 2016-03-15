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
package org.whole.lang.types.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.types.model.AnyType;
import org.whole.lang.types.model.Arguments;
import org.whole.lang.types.model.Case;
import org.whole.lang.types.model.Cases;
import org.whole.lang.types.model.EntityType;
import org.whole.lang.types.model.FeatureTableType;
import org.whole.lang.types.model.FeatureType;
import org.whole.lang.types.model.ITypesEntity;
import org.whole.lang.types.model.LegacyType;
import org.whole.lang.types.model.OrExpressions;
import org.whole.lang.types.model.Subtype;
import org.whole.lang.types.model.Supertype;
import org.whole.lang.types.model.TypeExpressions;
import org.whole.lang.types.model.TypeRule;
import org.whole.lang.types.model.TypeRules;
import org.whole.lang.types.model.TypeSystem;
import org.whole.lang.types.model.VariableType;
import org.whole.lang.types.visitors.TypesIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.LiteralDataEntityPart;
import org.whole.lang.ui.editparts.EntityTypePart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;

/**
 * @author Riccardo Solmi
 */
public class TypesPartFactoryVisitor extends TypesIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((ITypesEntity) modelEntity).accept(this);
		return part;
	}

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	@Override
	public void visit(ITypesEntity entity) {
		part = TablePartFactory.instance().createEditPart(context, entity);
	}

	@Override
	public void visit(TypeSystem entity) {
		part = new TypeSystemPart();
	}

	@Override
	public void visit(TypeRules entity) {
		part = new TypesRulesTablePart();
	}

	@Override
	public void visit(TypeRule entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(AnyType entity) {
		part = new AnyTypePart();
	}

	@Override
	public void visit(LegacyType entity) {
		part = new LiteralDataEntityPart();
	}

	@Override
	public void visit(VariableType entity) {
		part = new VariableTypePart();
	}

	@Override
	public void visit(EntityType entity) {
		part = new EntityTypePart();
	}

	@Override
	public void visit(FeatureType entity) {
		part = new FeatureTypePart();
	}

	@Override
	public void visit(FeatureTableType entity) {
		part = new FeatureTableTypeTablePart();
	}

	@Override
	public void visit(Arguments entity) {
		part = new ArgumentsTableRowPart();
	}

	@Override
	public void visit(Cases entity) {
		part = new CasesTablePart();
	}

	@Override
	public void visit(Case entity) {
		part = new CaseTableRowPart();
	}

	@Override
	public void visit(OrExpressions entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(TypeExpressions entity) {
		part = new TypeExpressionsTableRowPart();
	}

	@Override
	public void visit(Subtype entity) {
		part = new SubtypePart();
	}

	@Override
	public void visit(Supertype entity) {
		part = new SupertypePart();
	}
}
