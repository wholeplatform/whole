package org.whole.lang.models.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.models.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ModelsIdentityVisitor extends AbstractVisitor implements
		IModelsVisitor {
	public void visit(IEntity entity) {
		((IModelsEntity) entity).accept(this);
	}

	public void visit(Model entity) {
	}

	public void visit(ModelDeclarations entity) {
	}

	public void visit(SimpleEntity entity) {
	}

	public void visit(CompositeEntity entity) {
	}

	public void visit(MapEntity entity) {
	}

	public void visit(DataEntity entity) {
	}

	public void visit(EnumEntity entity) {
	}

	public void visit(EntityModifiers entity) {
	}

	public void visit(EntityModifier entity) {
	}

	public void visit(Features entity) {
	}

	public void visit(Feature entity) {
	}

	public void visit(FeatureModifiers entity) {
	}

	public void visit(FeatureModifier entity) {
	}

	public void visit(ComponentModifiers entity) {
	}

	public void visit(ComponentModifier entity) {
	}

	public void visit(DataType entity) {
	}

	public void visit(EnumValues entity) {
	}

	public void visit(EnumValue entity) {
	}

	public void visit(Types entity) {
	}

	public void visit(TypeRelations entity) {
	}

	public void visit(SupertypesOf entity) {
	}

	public void visit(SubtypesOf entity) {
	}

	public void visit(TypeAliasOf entity) {
	}

	public void visit(AnyType entity) {
	}

	public void visit(EntityType entity) {
	}

	public void visit(SimpleName entity) {
	}

	public void visit(Namespace entity) {
	}

	public void visit(Version entity) {
	}

	public void visit(URI entity) {
	}
}
