package org.whole.lang.commons.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.commons.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class CommonsIdentitySwitchVisitor extends AbstractVisitor implements ICommonsVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case CommonsEntityDescriptorEnum.Resolver_ord:
			visit((Resolver) entity);
			break;
		case CommonsEntityDescriptorEnum.RootFragment_ord:
			visit((RootFragment) entity);
			break;
		case CommonsEntityDescriptorEnum.SameStageFragment_ord:
			visit((SameStageFragment) entity);
			break;
		case CommonsEntityDescriptorEnum.StageUpFragment_ord:
			visit((StageUpFragment) entity);
			break;
		case CommonsEntityDescriptorEnum.StageDownFragment_ord:
			visit((StageDownFragment) entity);
			break;
		case CommonsEntityDescriptorEnum.TemplateFragment_ord:
			visit((TemplateFragment) entity);
			break;
		case CommonsEntityDescriptorEnum.BaseFragment_ord:
			visit((BaseFragment) entity);
			break;
		case CommonsEntityDescriptorEnum.Phase_ord:
			visit((Phase) entity);
			break;
		case CommonsEntityDescriptorEnum.Multiplexer_ord:
			visit((Multiplexer) entity);
			break;
		case CommonsEntityDescriptorEnum.Variable_ord:
			visit((Variable) entity);
			break;
		case CommonsEntityDescriptorEnum.InlineVariable_ord:
			visit((InlineVariable) entity);
			break;
		case CommonsEntityDescriptorEnum.VarName_ord:
			visit((VarName) entity);
			break;
		case CommonsEntityDescriptorEnum.VarType_ord:
			visit((VarType) entity);
			break;
		case CommonsEntityDescriptorEnum.Quantifier_ord:
			visit((Quantifier) entity);
			break;
		}
	}
}
