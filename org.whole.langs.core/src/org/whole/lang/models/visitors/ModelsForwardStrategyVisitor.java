package org.whole.lang.models.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.models.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ModelsForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IModelsVisitor> implements IModelsVisitor {
	public ModelsForwardStrategyVisitor() {
		this(new ModelsIdentityVisitor());
	}

	public ModelsForwardStrategyVisitor(IModelsVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IModelsEntity) entity).accept(this);
	}

	public void visit(Model entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ModelDeclarations entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CompositeEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MapEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DataEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EnumEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EntityModifiers entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EntityModifier entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Features entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Feature entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FeatureModifiers entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FeatureModifier entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ComponentModifiers entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ComponentModifier entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DataType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EnumValues entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EnumValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Types entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TypeRelations entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SupertypesOf entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SubtypesOf entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TypeAliasOf entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AnyType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EntityType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Namespace entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Version entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(URI entity) {
		wGetStrategy().visit(entity);
	}
}
