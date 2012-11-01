package org.whole.lang.types.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class TypesIdentitySwitchVisitor extends AbstractVisitor
		implements ITypesVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case TypesEntityDescriptorEnum.TypeSystem_ord:
			visit((TypeSystem) entity);
			break;
		case TypesEntityDescriptorEnum.TypeRules_ord:
			visit((TypeRules) entity);
			break;
		case TypesEntityDescriptorEnum.TypeRule_ord:
			visit((TypeRule) entity);
			break;
		case TypesEntityDescriptorEnum.AnyType_ord:
			visit((AnyType) entity);
			break;
		case TypesEntityDescriptorEnum.LegacyType_ord:
			visit((LegacyType) entity);
			break;
		case TypesEntityDescriptorEnum.VariableType_ord:
			visit((VariableType) entity);
			break;
		case TypesEntityDescriptorEnum.EntityType_ord:
			visit((EntityType) entity);
			break;
		case TypesEntityDescriptorEnum.UnionType_ord:
			visit((UnionType) entity);
			break;
		case TypesEntityDescriptorEnum.FeatureType_ord:
			visit((FeatureType) entity);
			break;
		case TypesEntityDescriptorEnum.FeatureTableType_ord:
			visit((FeatureTableType) entity);
			break;
		case TypesEntityDescriptorEnum.Arguments_ord:
			visit((Arguments) entity);
			break;
		case TypesEntityDescriptorEnum.Cases_ord:
			visit((Cases) entity);
			break;
		case TypesEntityDescriptorEnum.Case_ord:
			visit((Case) entity);
			break;
		case TypesEntityDescriptorEnum.OrExpressions_ord:
			visit((OrExpressions) entity);
			break;
		case TypesEntityDescriptorEnum.TypeExpressions_ord:
			visit((TypeExpressions) entity);
			break;
		case TypesEntityDescriptorEnum.Subtype_ord:
			visit((Subtype) entity);
			break;
		case TypesEntityDescriptorEnum.Supertype_ord:
			visit((Supertype) entity);
			break;
		}
	}
}
