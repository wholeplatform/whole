package org.whole.lang.models.visitors;

import org.whole.lang.models.visitors.ModelsIdentityUnaryVisitor;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.models.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class ModelsTraverseAllChildrenVisitor extends
		ModelsIdentityUnaryVisitor<IModelsVisitor> {
	public ModelsTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public ModelsTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Model entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getTypeRelations().accept(wGetVisitor1());
		entity.getDeclarations().accept(wGetVisitor1());
		entity.getNamespace().accept(wGetVisitor1());
		entity.getVersion().accept(wGetVisitor1());
		entity.getUri().accept(wGetVisitor1());
	}

	public void visit(ModelDeclarations entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ModelDeclaration entity) {
		entity.getModifiers().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getTypes().accept(wGetVisitor1());
	}

	public void visit(SimpleEntity entity) {
		entity.getModifiers().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getTypes().accept(wGetVisitor1());
		entity.getFeatures().accept(wGetVisitor1());
	}

	public void visit(CompositeEntity entity) {
		entity.getModifiers().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getTypes().accept(wGetVisitor1());
		entity.getComponentModifiers().accept(wGetVisitor1());
		entity.getComponentType().accept(wGetVisitor1());
	}

	public void visit(MapEntity entity) {
		entity.getModifiers().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getTypes().accept(wGetVisitor1());
		entity.getKeyType().accept(wGetVisitor1());
		entity.getValueType().accept(wGetVisitor1());
	}

	public void visit(DataEntity entity) {
		entity.getModifiers().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getTypes().accept(wGetVisitor1());
		entity.getDataType().accept(wGetVisitor1());
	}

	public void visit(EnumEntity entity) {
		entity.getModifiers().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getTypes().accept(wGetVisitor1());
		entity.getValues().accept(wGetVisitor1());
	}

	public void visit(EntityModifiers entity) {
		for (EntityModifier child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(Features entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Feature entity) {
		entity.getModifiers().accept(wGetVisitor1());
		entity.getType().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getOppositeName().accept(wGetVisitor1());
	}

	public void visit(FeatureModifiers entity) {
		for (FeatureModifier child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(ComponentModifiers entity) {
		for (ComponentModifier child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(EnumValues entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Types entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(TypeRelations entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(SupertypesOf entity) {
		entity.getTypes().accept(wGetVisitor1());
		entity.getForeignType().accept(wGetVisitor1());
	}

	public void visit(SubtypesOf entity) {
		entity.getTypes().accept(wGetVisitor1());
		entity.getForeignType().accept(wGetVisitor1());
	}

	public void visit(TypeAliasOf entity) {
		entity.getType().accept(wGetVisitor1());
		entity.getForeignType().accept(wGetVisitor1());
	}
}
