package org.whole.lang.models.visitors;

import org.whole.lang.models.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class ModelsFailureVisitor extends ModelsIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Model entity) {
		throw new VisitException();
	}

	public void visit(ModelDeclarations entity) {
		throw new VisitException();
	}

	public void visit(SimpleEntity entity) {
		throw new VisitException();
	}

	public void visit(CompositeEntity entity) {
		throw new VisitException();
	}

	public void visit(MapEntity entity) {
		throw new VisitException();
	}

	public void visit(DataEntity entity) {
		throw new VisitException();
	}

	public void visit(EnumEntity entity) {
		throw new VisitException();
	}

	public void visit(EntityModifiers entity) {
		throw new VisitException();
	}

	public void visit(EntityModifier entity) {
		throw new VisitException();
	}

	public void visit(Features entity) {
		throw new VisitException();
	}

	public void visit(Feature entity) {
		throw new VisitException();
	}

	public void visit(FeatureModifiers entity) {
		throw new VisitException();
	}

	public void visit(FeatureModifier entity) {
		throw new VisitException();
	}

	public void visit(ComponentModifiers entity) {
		throw new VisitException();
	}

	public void visit(ComponentModifier entity) {
		throw new VisitException();
	}

	public void visit(DataType entity) {
		throw new VisitException();
	}

	public void visit(EnumValues entity) {
		throw new VisitException();
	}

	public void visit(EnumValue entity) {
		throw new VisitException();
	}

	public void visit(Types entity) {
		throw new VisitException();
	}

	public void visit(TypeRelations entity) {
		throw new VisitException();
	}

	public void visit(SupertypesOf entity) {
		throw new VisitException();
	}

	public void visit(SubtypesOf entity) {
		throw new VisitException();
	}

	public void visit(TypeAliasOf entity) {
		throw new VisitException();
	}

	public void visit(AnyType entity) {
		throw new VisitException();
	}

	public void visit(EntityType entity) {
		throw new VisitException();
	}

	public void visit(SimpleName entity) {
		throw new VisitException();
	}

	public void visit(Namespace entity) {
		throw new VisitException();
	}

	public void visit(Version entity) {
		throw new VisitException();
	}

	public void visit(URI entity) {
		throw new VisitException();
	}
}
