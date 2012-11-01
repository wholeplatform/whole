package org.whole.lang.templates.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.templates.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class TemplatesIdentitySwitchVisitor extends AbstractVisitor
		implements ITemplatesVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case TemplatesEntityDescriptorEnum.TemplateManager_ord:
			visit((TemplateManager) entity);
			break;
		case TemplatesEntityDescriptorEnum.Templates_ord:
			visit((Templates) entity);
			break;
		case TemplatesEntityDescriptorEnum.TemplateFactory_ord:
			visit((TemplateFactory) entity);
			break;
		case TemplatesEntityDescriptorEnum.Names_ord:
			visit((Names) entity);
			break;
		case TemplatesEntityDescriptorEnum.QualifiedName_ord:
			visit((QualifiedName) entity);
			break;
		case TemplatesEntityDescriptorEnum.SimpleName_ord:
			visit((SimpleName) entity);
			break;
		}
	}
}
