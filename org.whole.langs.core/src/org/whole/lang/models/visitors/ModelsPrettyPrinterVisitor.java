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
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.models.model.AnyType;
import org.whole.lang.models.model.ComponentModifier;
import org.whole.lang.models.model.CompositeEntity;
import org.whole.lang.models.model.DataEntity;
import org.whole.lang.models.model.DataType;
import org.whole.lang.models.model.EntityModifier;
import org.whole.lang.models.model.EntityType;
import org.whole.lang.models.model.EnumEntity;
import org.whole.lang.models.model.EnumValue;
import org.whole.lang.models.model.EnumValues;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.FeatureModifier;
import org.whole.lang.models.model.MapEntity;
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
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Matteo Necci
 */
public class ModelsPrettyPrinterVisitor extends ModelsTraverseAllVisitor {
	protected final IPrettyPrintWriter out;

	public ModelsPrettyPrinterVisitor(PrettyPrinterOperation operation) {
		out = operation.getPrettyPrintWriter();
	}

	protected final void printKeyword(String text) {
		out.printRaw(text);
	}
	protected final void printIdentifier(String text) {
		out.printRaw(text);
	}
	protected final void printDelimiter(String text) {
		out.printRaw(text);
	}
	protected final void printParenthesis(String text) {
		out.printRaw(text);
	}
	protected final void printLiteral(String text) {
		out.printRaw(text);
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false));
		return false;
	}

	public void visit(SimpleName entity) {
		printIdentifier(entity.getValue());
	}

	public void visit(Model entity) {
		printKeyword("model ");
		entity.getName().accept(this);
		out.println();
		entity.getTypeRelations().accept(this);
		entity.getDeclarations().accept(this);
	}

	public void visit(TypeRelations entity) {
		if (!EntityUtils.isResolver(entity) && !entity.wIsEmpty()) {
			printKeyword("type relations ");
			Iterator<TypeRelation> typeIterator = entity.iterator();
			if (typeIterator.hasNext()) {
				typeIterator.next().accept(this);
				while (typeIterator.hasNext()) {
					printDelimiter(", ");
					typeIterator.next().accept(this);
				}
			}
		}
		out.println();
	}
	@Override
	public void visit(SupertypesOf entity) {
		entity.getForeignType().accept(this);
		printKeyword(" super");
		entity.getTypes().accept(this);
	}
	@Override
	public void visit(SubtypesOf entity) {
		entity.getForeignType().accept(this);
		printKeyword(" sub");
		entity.getTypes().accept(this);
	}
	@Override
	public void visit(TypeAliasOf entity) {
		entity.getForeignType().accept(this);
		printKeyword(" alias ");
		entity.getType().accept(this);
	}
	@Override
	public void visit(AnyType entity) {
		printKeyword("any");
	}
	@Override
	public void visit(EntityType entity) {
		out.print(entity.getValue());
	}

	public void visit(SimpleEntity entity) {
		out.println();
		entity.getModifiers().accept(this);
		printKeyword("entity ");
		entity.getName().accept(this);
		entity.getTypes().accept(this);
		out.setRelativeIndentation((+1));
		entity.getFeatures().accept(this);
		out.setRelativeIndentation((-1));
	}

	public void visit(CompositeEntity entity) {
		out.println();
		entity.getModifiers().accept(this);
		printKeyword("entity ");
		entity.getName().accept(this);
		entity.getTypes().accept(this);
		out.setRelativeIndentation((+1));
		entity.getComponentModifiers().accept(this);
		printKeyword("composite ");
		printDelimiter("<");
		entity.getComponentType().accept(this);
		printDelimiter(">");
		out.println();
		out.setRelativeIndentation((-1));
	}

	public void visit(DataEntity entity) {
		out.println();
		entity.getModifiers().accept(this);
		printKeyword("entity ");
		entity.getName().accept(this);
		entity.getTypes().accept(this);
		out.setRelativeIndentation((+1));
		printKeyword("value ");
		printDelimiter("<");
		entity.getDataType().accept(this);
		printDelimiter(">");
		out.println();
		out.setRelativeIndentation((-1));
	}
	
	public void visit(EnumEntity entity) {
		out.println();
		entity.getModifiers().accept(this);
		printKeyword("entity ");
		entity.getName().accept(this);
		entity.getTypes().accept(this);
		out.setRelativeIndentation((+1));
		printKeyword("enum ");
		printDelimiter("<");
		entity.getValues().accept(this);
		printDelimiter(">");
		out.setRelativeIndentation((-1));
		out.println();
	}
	
	
	
	public void visit(MapEntity entity) {
		out.println();
		entity.getModifiers().accept(this);
		printKeyword("entity ");
		entity.getName().accept(this);
		entity.getTypes().accept(this);
		out.setRelativeIndentation((+1));
		printKeyword("map ");
		printDelimiter("<");
		entity.getKeyType().accept(this);
		printDelimiter(", ");
		entity.getValueType().accept(this);
		printDelimiter(">");
		out.setRelativeIndentation((-1));
		out.println();		
	}

	public void visit(EnumValues entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				printDelimiter(", ");
			
			entity.get(i).accept(this);
		}
	}

	public void visit(EnumValue entity) {
		out.printRaw(entity.getValue());
	}

	public void visit(DataType entity) {
		printLiteral(entity.getValue());
	}

	public void visit(Types entity) {
		if (!EntityUtils.isResolver(entity) && !entity.wIsEmpty()) {
			if (EntityUtils.hasParent(entity) && Matcher.isAssignableAsIsFrom(ModelsEntityDescriptorEnum.TypeRelation, entity.wGetParent()))
				printKeyword("types ");
			else
				printKeyword(" types ");
				
			entity.get(0).accept(this);
			for (int i = 1; i<entity.wSize(); i++) {
				printDelimiter(", ");
				entity.get(i).accept(this);
			}
		}
		out.println();
	}

	public void visit(Feature entity) {
		entity.getModifiers().accept(this);
		printKeyword("feature ");
		entity.getType().accept(this);
		printDelimiter(" ");
		entity.getName().accept(this);
		out.println();
	}
	
	public void visit(EntityModifier entity) {
		out.printRaw(entity.getValue().getName());
		out.printRaw(" ");
	}

	public void visit(FeatureModifier entity) {
		printKeyword(entity.wStringValue());
		printDelimiter(" ");
	}

	public void visit(ComponentModifier entity) {
		printKeyword(entity.wStringValue());
		printDelimiter(" ");
	}
}
