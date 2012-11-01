package org.whole.lang.models.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.models.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class ModelsIdentitySwitchVisitor extends AbstractVisitor
		implements IModelsVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case ModelsEntityDescriptorEnum.Model_ord:
			visit((Model) entity);
			break;
		case ModelsEntityDescriptorEnum.ModelDeclarations_ord:
			visit((ModelDeclarations) entity);
			break;
		case ModelsEntityDescriptorEnum.SimpleEntity_ord:
			visit((SimpleEntity) entity);
			break;
		case ModelsEntityDescriptorEnum.CompositeEntity_ord:
			visit((CompositeEntity) entity);
			break;
		case ModelsEntityDescriptorEnum.MapEntity_ord:
			visit((MapEntity) entity);
			break;
		case ModelsEntityDescriptorEnum.DataEntity_ord:
			visit((DataEntity) entity);
			break;
		case ModelsEntityDescriptorEnum.EnumEntity_ord:
			visit((EnumEntity) entity);
			break;
		case ModelsEntityDescriptorEnum.EntityModifiers_ord:
			visit((EntityModifiers) entity);
			break;
		case ModelsEntityDescriptorEnum.EntityModifier_ord:
			visit((EntityModifier) entity);
			break;
		case ModelsEntityDescriptorEnum.Features_ord:
			visit((Features) entity);
			break;
		case ModelsEntityDescriptorEnum.Feature_ord:
			visit((Feature) entity);
			break;
		case ModelsEntityDescriptorEnum.FeatureModifiers_ord:
			visit((FeatureModifiers) entity);
			break;
		case ModelsEntityDescriptorEnum.FeatureModifier_ord:
			visit((FeatureModifier) entity);
			break;
		case ModelsEntityDescriptorEnum.ComponentModifiers_ord:
			visit((ComponentModifiers) entity);
			break;
		case ModelsEntityDescriptorEnum.ComponentModifier_ord:
			visit((ComponentModifier) entity);
			break;
		case ModelsEntityDescriptorEnum.DataType_ord:
			visit((DataType) entity);
			break;
		case ModelsEntityDescriptorEnum.EnumValues_ord:
			visit((EnumValues) entity);
			break;
		case ModelsEntityDescriptorEnum.EnumValue_ord:
			visit((EnumValue) entity);
			break;
		case ModelsEntityDescriptorEnum.Types_ord:
			visit((Types) entity);
			break;
		case ModelsEntityDescriptorEnum.TypeRelations_ord:
			visit((TypeRelations) entity);
			break;
		case ModelsEntityDescriptorEnum.SupertypesOf_ord:
			visit((SupertypesOf) entity);
			break;
		case ModelsEntityDescriptorEnum.SubtypesOf_ord:
			visit((SubtypesOf) entity);
			break;
		case ModelsEntityDescriptorEnum.TypeAliasOf_ord:
			visit((TypeAliasOf) entity);
			break;
		case ModelsEntityDescriptorEnum.AnyType_ord:
			visit((AnyType) entity);
			break;
		case ModelsEntityDescriptorEnum.EntityType_ord:
			visit((EntityType) entity);
			break;
		case ModelsEntityDescriptorEnum.SimpleName_ord:
			visit((SimpleName) entity);
			break;
		case ModelsEntityDescriptorEnum.Namespace_ord:
			visit((Namespace) entity);
			break;
		case ModelsEntityDescriptorEnum.Version_ord:
			visit((Version) entity);
			break;
		case ModelsEntityDescriptorEnum.URI_ord:
			visit((URI) entity);
			break;
		}
	}
}
