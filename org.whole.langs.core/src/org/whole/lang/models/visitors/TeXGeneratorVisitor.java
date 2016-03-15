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
package org.whole.lang.models.visitors;

import java.util.Iterator;

import org.whole.lang.matchers.Matcher;
import org.whole.lang.models.model.AnyType;
import org.whole.lang.models.model.ComponentModifier;
import org.whole.lang.models.model.CompositeEntity;
import org.whole.lang.models.model.DataEntity;
import org.whole.lang.models.model.DataType;
import org.whole.lang.models.model.EntityType;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.FeatureModifier;
import org.whole.lang.models.model.IModelsEntity;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.models.model.SubtypesOf;
import org.whole.lang.models.model.SupertypesOf;
import org.whole.lang.models.model.TypeAliasOf;
import org.whole.lang.models.model.TypeRelation;
import org.whole.lang.models.model.TypeRelations;
import org.whole.lang.models.model.Types;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.operations.ExportTexOperation;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class TeXGeneratorVisitor extends ModelsTraverseAllVisitor {
	public TeXGeneratorVisitor(ExportTexOperation operation) {
    	super(null);
    	wSetVisitor1(this);
		setOperation(operation);
	}

	public ExportTexOperation getOperation() {
		return (ExportTexOperation) super.getOperation();
	}

	protected final void print(String text) {
		getOperation().print(text);
	}
	protected final void setIndentation(int indentation) {
		getOperation().setIndentation(indentation);
	}
	protected final void indent() {
		getOperation().indent();
	}
	protected final void unindent() {
		getOperation().unindent();
	}
	
	protected final void println() {
		print("\\\\");
		getOperation().println();
	}
	protected final void printIndentation() {
		print("\\wstyleb ");
		getOperation().printIndentation();
	}
	protected final void printKeyword(String text) {
		print("\\wstylek ");
		print(text);
	}
	protected final void printIdentifier(String text) {
		print("\\wstylei ");
		print(text);
	}
	protected final void printDelimiter(String text) {
		print("\\wstyled ");
		print(text);
	}
	protected final void printParenthesis(String text) {
		print("\\wstylep ");
		print(text);
	}
	protected final void printLiteral(String text) {
		print("\\wstylel ");
		print(text);
	}

	public void visit(SimpleName entity) {
		printIdentifier(entity.getValue());
	}

	public void visit(Model entity) {
		printKeyword("model~");
		entity.getName().accept(this);
		println();
		entity.getTypeRelations().accept(this);
		entity.getDeclarations().accept(this);
	}

	public void visit(TypeRelations entity) {
		if (!EntityUtils.isResolver(entity) && !entity.wIsEmpty()) {
			printKeyword("type~relations~");
			Iterator<TypeRelation> typeIterator = entity.iterator();
			if (typeIterator.hasNext()) {
				typeIterator.next().accept(this);
				while (typeIterator.hasNext()) {
					printDelimiter(",~");
					typeIterator.next().accept(this);
				}
			}
		}
		println();
	}
	@Override
	public void visit(SupertypesOf entity) {
		entity.getForeignType().accept(this);
		printKeyword("~super");
		entity.getTypes().accept(this);
	}
	@Override
	public void visit(SubtypesOf entity) {
		entity.getForeignType().accept(this);
		printKeyword("~sub");
		entity.getTypes().accept(this);
	}
	@Override
	public void visit(TypeAliasOf entity) {
		entity.getForeignType().accept(this);
		printKeyword("~alias~");
		entity.getType().accept(this);
	}
	@Override
	public void visit(AnyType entity) {
		printKeyword("any");
	}
	@Override
	public void visit(EntityType entity) {
		print(entity.getValue());
	}

	public void visit(SimpleEntity entity) {
		setIndentation(1);
		printIndentation();
		printKeyword("entity~");
		entity.getName().accept(this);
		entity.getTypes().accept(this);
		entity.getFeatures().accept(this);
	}

	public void visit(CompositeEntity entity) {
		setIndentation(1);
		printIndentation();
		printKeyword("entity~");
		entity.getName().accept(this);
		entity.getTypes().accept(this);
		setIndentation(2);
		printIndentation();
		entity.getComponentModifiers().accept(this);
		printKeyword("composite~");
		printDelimiter("<");
		entity.getComponentType().accept(this);
		printDelimiter(">");
		println();
	}

	public void visit(DataEntity entity) {
		setIndentation(1);
		printIndentation();
		printKeyword("entity~");
		entity.getName().accept(this);
		entity.getTypes().accept(this);
		setIndentation(2);
		printIndentation();
		printKeyword("value~");
		printDelimiter("<");
		entity.getDataType().accept(this);
		printDelimiter(">");
		println();
	}

	public void visit(DataType entity) {
		printLiteral(entity.getValue());
	}

	public void visit(Types entity) {
		if (!EntityUtils.isResolver(entity) && !entity.wIsEmpty()) {
			if (EntityUtils.hasParent(entity) && Matcher.isAssignableAsIsFrom(ModelsEntityDescriptorEnum.TypeRelation, entity.wGetParent()))
				printKeyword("types~");
			else
				printKeyword("~types~");
			((IModelsEntity) entity.wGet(0)).accept(this);
			for (int i = 1; i<entity.wSize(); i++) {
				printDelimiter(",~");
				((IModelsEntity) entity.wGet(i)).accept(this);
			}
		}
		println();
	}

	public void visit(Feature entity) {
		setIndentation(2);
		printIndentation();
		entity.getModifiers().accept(this);
		printKeyword("feature ");
		entity.getType().accept(this);
		printDelimiter("~");
		entity.getName().accept(this);
		println();
	}
	
	public void visit(FeatureModifier entity) {
		printKeyword(entity.wStringValue());
		printDelimiter("~");
	}

	public void visit(ComponentModifier entity) {
		printKeyword(entity.wStringValue());
		printDelimiter("~");
	}
}
