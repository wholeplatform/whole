package org.whole.lang.unifiedlambdadelta.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class UnifiedLambdaDeltaIdentitySwitchVisitor extends
		AbstractVisitor implements IUnifiedLambdaDeltaVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case UnifiedLambdaDeltaEntityDescriptorEnum.Declaration_ord:
			visit((Declaration) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Definition_ord:
			visit((Definition) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Top_ord:
			visit((Top) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Application_ord:
			visit((Application) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Cast_ord:
			visit((Cast) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Abstraction_ord:
			visit((Abstraction) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Abbreviation_ord:
			visit((Abbreviation) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Local_ord:
			visit((Local) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Sort_ord:
			visit((Sort) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Polarity_ord:
			visit((Polarity) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Index_ord:
			visit((Index) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Level_ord:
			visit((Level) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Name_ord:
			visit((Name) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Access_ord:
			visit((Access) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Prefix_ord:
			visit((Prefix) entity);
			break;
		case UnifiedLambdaDeltaEntityDescriptorEnum.Postfix_ord:
			visit((Postfix) entity);
			break;
		}
	}
}
