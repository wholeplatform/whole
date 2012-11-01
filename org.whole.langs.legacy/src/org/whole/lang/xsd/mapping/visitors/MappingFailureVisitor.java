package org.whole.lang.xsd.mapping.visitors;

import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class MappingFailureVisitor extends MappingIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(MappingStrategy entity) {
		throw new VisitException();
	}

	public void visit(Mappings entity) {
		throw new VisitException();
	}

	public void visit(Types entity) {
		throw new VisitException();
	}

	public void visit(RootMapping entity) {
		throw new VisitException();
	}

	public void visit(ContentMapping entity) {
		throw new VisitException();
	}

	public void visit(MixedStructuralMapping entity) {
		throw new VisitException();
	}

	public void visit(AnyStructuralMapping entity) {
		throw new VisitException();
	}

	public void visit(AnyElementMapping entity) {
		throw new VisitException();
	}

	public void visit(AnyAttributeMapping entity) {
		throw new VisitException();
	}

	public void visit(StructuralMapping entity) {
		throw new VisitException();
	}

	public void visit(ElementMapping entity) {
		throw new VisitException();
	}

	public void visit(AttributeMapping entity) {
		throw new VisitException();
	}

	public void visit(UnionMapping entity) {
		throw new VisitException();
	}

	public void visit(DataTypes entity) {
		throw new VisitException();
	}

	public void visit(EnumDataType entity) {
		throw new VisitException();
	}

	public void visit(EnumValues entity) {
		throw new VisitException();
	}

	public void visit(EnumValue entity) {
		throw new VisitException();
	}

	public void visit(CustomDataType entity) {
		throw new VisitException();
	}

	public void visit(URI entity) {
		throw new VisitException();
	}

	public void visit(BooleanType entity) {
		throw new VisitException();
	}

	public void visit(NCName entity) {
		throw new VisitException();
	}

	public void visit(Value entity) {
		throw new VisitException();
	}

	public void visit(BuiltInType entity) {
		throw new VisitException();
	}
}
