package org.whole.lang.models.visitors;

import org.whole.lang.models.visitors.ModelsIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.models.model.*;

/** 
 * @generator Whole
 */
public class ModelsTraverseAllSwitchVisitor extends
		ModelsIdentityUnaryVisitor<IVisitor> {
	public ModelsTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Model entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTypeRelations());
		wGetVisitor1().visit(entity.getDeclarations());
		wGetVisitor1().visit(entity.getNamespace());
		wGetVisitor1().visit(entity.getVersion());
		wGetVisitor1().visit(entity.getUri());
	}

	public void visit(ModelDeclarations entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ModelDeclaration entity) {
		wGetVisitor1().visit(entity.getModifiers());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTypes());
	}

	public void visit(SimpleEntity entity) {
		wGetVisitor1().visit(entity.getModifiers());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTypes());
		wGetVisitor1().visit(entity.getFeatures());
	}

	public void visit(CompositeEntity entity) {
		wGetVisitor1().visit(entity.getModifiers());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTypes());
		wGetVisitor1().visit(entity.getComponentModifiers());
		wGetVisitor1().visit(entity.getComponentType());
	}

	public void visit(MapEntity entity) {
		wGetVisitor1().visit(entity.getModifiers());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTypes());
		wGetVisitor1().visit(entity.getKeyType());
		wGetVisitor1().visit(entity.getValueType());
	}

	public void visit(DataEntity entity) {
		wGetVisitor1().visit(entity.getModifiers());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTypes());
		wGetVisitor1().visit(entity.getDataType());
	}

	public void visit(EnumEntity entity) {
		wGetVisitor1().visit(entity.getModifiers());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTypes());
		wGetVisitor1().visit(entity.getValues());
	}

	public void visit(EntityModifiers entity) {
		for (EntityModifier child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(Features entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Feature entity) {
		wGetVisitor1().visit(entity.getModifiers());
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getOppositeName());
	}

	public void visit(FeatureModifiers entity) {
		for (FeatureModifier child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(ComponentModifiers entity) {
		for (ComponentModifier child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(EnumValues entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Types entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(TypeRelations entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(SupertypesOf entity) {
		wGetVisitor1().visit(entity.getTypes());
		wGetVisitor1().visit(entity.getForeignType());
	}

	public void visit(SubtypesOf entity) {
		wGetVisitor1().visit(entity.getTypes());
		wGetVisitor1().visit(entity.getForeignType());
	}

	public void visit(TypeAliasOf entity) {
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getForeignType());
	}
}
