package org.whole.lang.types.visitors;

import org.whole.lang.types.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class TypesFailureVisitor extends TypesIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(TypeSystem entity) {
		throw new VisitException();
	}

	public void visit(TypeRules entity) {
		throw new VisitException();
	}

	public void visit(TypeRule entity) {
		throw new VisitException();
	}

	public void visit(AnyType entity) {
		throw new VisitException();
	}

	public void visit(LegacyType entity) {
		throw new VisitException();
	}

	public void visit(VariableType entity) {
		throw new VisitException();
	}

	public void visit(EntityType entity) {
		throw new VisitException();
	}

	public void visit(UnionType entity) {
		throw new VisitException();
	}

	public void visit(FeatureType entity) {
		throw new VisitException();
	}

	public void visit(FeatureTableType entity) {
		throw new VisitException();
	}

	public void visit(Arguments entity) {
		throw new VisitException();
	}

	public void visit(Cases entity) {
		throw new VisitException();
	}

	public void visit(Case entity) {
		throw new VisitException();
	}

	public void visit(OrExpressions entity) {
		throw new VisitException();
	}

	public void visit(TypeExpressions entity) {
		throw new VisitException();
	}

	public void visit(Subtype entity) {
		throw new VisitException();
	}

	public void visit(Supertype entity) {
		throw new VisitException();
	}
}
