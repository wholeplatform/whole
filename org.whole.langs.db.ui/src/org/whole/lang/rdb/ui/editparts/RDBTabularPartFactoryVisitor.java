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
package org.whole.lang.rdb.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.rdb.model.Column;
import org.whole.lang.rdb.model.ColumnIndex;
import org.whole.lang.rdb.model.ColumnIndices;
import org.whole.lang.rdb.model.ColumnNames;
import org.whole.lang.rdb.model.ColumnReference;
import org.whole.lang.rdb.model.Columns;
import org.whole.lang.rdb.model.Database;
import org.whole.lang.rdb.model.ForeignKey;
import org.whole.lang.rdb.model.ForeignKeys;
import org.whole.lang.rdb.model.IRDBEntity;
import org.whole.lang.rdb.model.Index;
import org.whole.lang.rdb.model.Indices;
import org.whole.lang.rdb.model.PrimaryKey;
import org.whole.lang.rdb.model.Schema;
import org.whole.lang.rdb.model.Table;
import org.whole.lang.rdb.visitors.RDBIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.CommaSeparatedCompositeFlowPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;

/**
 * @author Enrico Persiani
 */
public class RDBTabularPartFactoryVisitor extends RDBIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IRDBEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(IRDBEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(Database entity) {
		part = new DatabasePart();
	}

	public void visit(Schema entity) {
		part = new SchemaPart();
	}

	public void visit(Table entity) {
		part = new TablePart();
	}

	public void visit(Columns entity) {
		part = new ColumnsTablePart();
	}

	public void visit(Column entity) {
		part = new ColumnRowPart();
	}

	public void visit(PrimaryKey entity) {
		part = new PrimaryKeyPart();
	}

	public void visit(ColumnNames entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(ForeignKeys entity) {
		part = new ForeignKeysTablePart();
	}

	public void visit(ForeignKey entity) {
		part = new ForeignKeyRowPart();
	}

	public void visit(ColumnReference entity) {
		part = new ColumnReferencePart();
	}

	public void visit(Indices entity) {
		part = new IndicesTablePart();
	}

	public void visit(Index entity) {
		part = new IndexRowPart();
	}

	public void visit(ColumnIndices entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(ColumnIndex entity) {
		part = new ColumnIndexPart();
	}
}
