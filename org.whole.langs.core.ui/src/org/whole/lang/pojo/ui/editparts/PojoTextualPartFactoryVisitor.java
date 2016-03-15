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
package org.whole.lang.pojo.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.pojo.model.AnnotationDeclaration;
import org.whole.lang.pojo.model.Annotations;
import org.whole.lang.pojo.model.ArrayData;
import org.whole.lang.pojo.model.ArrayType;
import org.whole.lang.pojo.model.CollectionInterface;
import org.whole.lang.pojo.model.CollectionType;
import org.whole.lang.pojo.model.Constructor;
import org.whole.lang.pojo.model.DataTypeDeclaration;
import org.whole.lang.pojo.model.EnumDeclaration;
import org.whole.lang.pojo.model.FactoryDeclaration;
import org.whole.lang.pojo.model.FactoryMethod;
import org.whole.lang.pojo.model.IPojoEntity;
import org.whole.lang.pojo.model.Library;
import org.whole.lang.pojo.model.MapType;
import org.whole.lang.pojo.model.MarkerAnnotation;
import org.whole.lang.pojo.model.Modifier;
import org.whole.lang.pojo.model.MultiplePropertiesAnnotation;
import org.whole.lang.pojo.model.Names;
import org.whole.lang.pojo.model.Parameter;
import org.whole.lang.pojo.model.Parameters;
import org.whole.lang.pojo.model.PojoDeclaration;
import org.whole.lang.pojo.model.PrimitiveType;
import org.whole.lang.pojo.model.Property;
import org.whole.lang.pojo.model.PropertyValuePair;
import org.whole.lang.pojo.model.SinglePropertyAnnotation;
import org.whole.lang.pojo.visitors.PojoIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.CommaSeparatedCompositeFlowPart;
import org.whole.lang.ui.editparts.CompositeRowPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.KeywordDataEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;

/** 
 * @author Riccardo Solmi
 */
public class PojoTextualPartFactoryVisitor extends PojoIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IPojoEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(IPojoEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(Library entity) {
		part = new LibraryPart();
	}

	public void visit(EnumDeclaration entity) {
		part = new EnumDeclarationPart();
	}

	public void visit(AnnotationDeclaration entity) {
		part = new AnnotationDeclarationPart();
	}

	public void visit(DataTypeDeclaration entity) {
		part = new DataTypeDeclarationPart();
	}

	public void visit(PojoDeclaration entity) {
		part = new PojoDeclarationPart();
	}

	public void visit(FactoryDeclaration entity) {
		part = new FactoryDeclarationPart();
	}

	public void visit(FactoryMethod entity) {
		part = new FactoryMethodPart();
	}

	public void visit(Property entity) {
		part = new PropertyPart();
	}

	public void visit(Constructor entity) {
		part = new ConstructorPart();
	}

	public void visit(Parameters entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(Parameter entity) {
		part = new ParameterPart();
	}

	public void visit(ArrayType entity) {
		part = new ArrayTypePart();
	}

	public void visit(MapType entity) {
		part = new MapTypePart();
	}

	public void visit(CollectionType entity) {
		part = new CollectionTypePart();
	}

	public void visit(CollectionInterface entity) {
		part = new KeywordDataEntityPart();
	}

	public void visit(PrimitiveType entity) {
		part = new KeywordDataEntityPart();
	}

	public void visit(Modifier entity) {
		part = new KeywordDataEntityPart();
	}

	public void visit(MarkerAnnotation entity) {
		part = new MarkerAnnotationPart();
	}

	public void visit(SinglePropertyAnnotation entity) {
		part = new SinglePropertyAnnotationPart();
	}

	public void visit(MultiplePropertiesAnnotation entity) {
		part = new MultiplePropertiesAnnotationPart();
	}

	public void visit(PropertyValuePair entity) {
		part = new PropertyValuePairPart();
	}

	public void visit(Annotations entity) {
		part = new CompositeRowPart();
	}

	public void visit(Names entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(ArrayData entity) {
		part = new CompositeRowPart();
	}
}