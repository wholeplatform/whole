package org.whole.lang.models.visitors;

import org.whole.lang.models.model.*;

/** 
 * @generator Whole
 */
public class ModelsForwardStagedVisitor extends ModelsIdentityVisitor {
	public void visit(Model entity) {
		stagedVisit(entity);
	}

	public void visit(ModelDeclarations entity) {
		stagedVisit(entity);
	}

	public void visit(SimpleEntity entity) {
		stagedVisit(entity);
	}

	public void visit(CompositeEntity entity) {
		stagedVisit(entity);
	}

	public void visit(MapEntity entity) {
		stagedVisit(entity);
	}

	public void visit(DataEntity entity) {
		stagedVisit(entity);
	}

	public void visit(EnumEntity entity) {
		stagedVisit(entity);
	}

	public void visit(EntityModifiers entity) {
		stagedVisit(entity);
	}

	public void visit(EntityModifier entity) {
		stagedVisit(entity);
	}

	public void visit(Features entity) {
		stagedVisit(entity);
	}

	public void visit(Feature entity) {
		stagedVisit(entity);
	}

	public void visit(FeatureModifiers entity) {
		stagedVisit(entity);
	}

	public void visit(FeatureModifier entity) {
		stagedVisit(entity);
	}

	public void visit(ComponentModifiers entity) {
		stagedVisit(entity);
	}

	public void visit(ComponentModifier entity) {
		stagedVisit(entity);
	}

	public void visit(DataType entity) {
		stagedVisit(entity);
	}

	public void visit(EnumValues entity) {
		stagedVisit(entity);
	}

	public void visit(EnumValue entity) {
		stagedVisit(entity);
	}

	public void visit(Types entity) {
		stagedVisit(entity);
	}

	public void visit(TypeRelations entity) {
		stagedVisit(entity);
	}

	public void visit(SupertypesOf entity) {
		stagedVisit(entity);
	}

	public void visit(SubtypesOf entity) {
		stagedVisit(entity);
	}

	public void visit(TypeAliasOf entity) {
		stagedVisit(entity);
	}

	public void visit(AnyType entity) {
		stagedVisit(entity);
	}

	public void visit(EntityType entity) {
		stagedVisit(entity);
	}

	public void visit(SimpleName entity) {
		stagedVisit(entity);
	}

	public void visit(Namespace entity) {
		stagedVisit(entity);
	}

	public void visit(Version entity) {
		stagedVisit(entity);
	}

	public void visit(URI entity) {
		stagedVisit(entity);
	}
}
