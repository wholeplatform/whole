package org.whole.lang.models.visitors;

import org.whole.lang.models.model.*;

/** 
 * @generator Whole
 */
public class ModelsIdentityDefaultVisitor extends ModelsIdentityVisitor {
	public void visit(IModelsEntity entity) {
	}

	public void visit(Model entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(ModelDeclarations entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(ModelDeclaration entity) {
	}

	public void visit(SimpleEntity entity) {
		visit((IModelsEntity) entity);
		visit((ModelDeclaration) entity);
	}

	public void visit(CompositeEntity entity) {
		visit((IModelsEntity) entity);
		visit((ModelDeclaration) entity);
	}

	public void visit(MapEntity entity) {
		visit((IModelsEntity) entity);
		visit((ModelDeclaration) entity);
	}

	public void visit(DataEntity entity) {
		visit((IModelsEntity) entity);
		visit((ModelDeclaration) entity);
	}

	public void visit(EnumEntity entity) {
		visit((IModelsEntity) entity);
		visit((ModelDeclaration) entity);
	}

	public void visit(EntityModifiers entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(EntityModifier entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(Features entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(Feature entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(FeatureModifiers entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(FeatureModifier entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(ComponentModifiers entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(ComponentModifier entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(DataType entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(EnumValues entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(EnumValue entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(Types entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(TypeRelations entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(TypeRelation entity) {
	}

	public void visit(SupertypesOf entity) {
		visit((IModelsEntity) entity);
		visit((TypeRelation) entity);
	}

	public void visit(SubtypesOf entity) {
		visit((IModelsEntity) entity);
		visit((TypeRelation) entity);
	}

	public void visit(TypeAliasOf entity) {
		visit((IModelsEntity) entity);
		visit((TypeRelation) entity);
	}

	public void visit(ForeignType entity) {
	}

	public void visit(AnyType entity) {
		visit((IModelsEntity) entity);
		visit((ForeignType) entity);
	}

	public void visit(EntityType entity) {
		visit((IModelsEntity) entity);
		visit((ForeignType) entity);
	}

	public void visit(Type entity) {
	}

	public void visit(SimpleName entity) {
		visit((IModelsEntity) entity);
		visit((Type) entity);
	}

	public void visit(Namespace entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(Version entity) {
		visit((IModelsEntity) entity);
	}

	public void visit(URI entity) {
		visit((IModelsEntity) entity);
	}
}
