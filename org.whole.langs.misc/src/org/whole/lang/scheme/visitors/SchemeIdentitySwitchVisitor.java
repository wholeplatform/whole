package org.whole.lang.scheme.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.scheme.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class SchemeIdentitySwitchVisitor extends AbstractVisitor
		implements ISchemeVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case SchemeEntityDescriptorEnum.Definitions_ord:
			visit((Definitions) entity);
			break;
		case SchemeEntityDescriptorEnum.Definition_ord:
			visit((Definition) entity);
			break;
		case SchemeEntityDescriptorEnum.Branches_ord:
			visit((Branches) entity);
			break;
		case SchemeEntityDescriptorEnum.Branch_ord:
			visit((Branch) entity);
			break;
		case SchemeEntityDescriptorEnum.SchemeExpressions_ord:
			visit((SchemeExpressions) entity);
			break;
		case SchemeEntityDescriptorEnum.ApplyExpression_ord:
			visit((ApplyExpression) entity);
			break;
		case SchemeEntityDescriptorEnum.LambdaExpression_ord:
			visit((LambdaExpression) entity);
			break;
		case SchemeEntityDescriptorEnum.AndExpression_ord:
			visit((AndExpression) entity);
			break;
		case SchemeEntityDescriptorEnum.OrExpression_ord:
			visit((OrExpression) entity);
			break;
		case SchemeEntityDescriptorEnum.CondExpression_ord:
			visit((CondExpression) entity);
			break;
		case SchemeEntityDescriptorEnum.LocalExpression_ord:
			visit((LocalExpression) entity);
			break;
		case SchemeEntityDescriptorEnum.IdExpression_ord:
			visit((IdExpression) entity);
			break;
		case SchemeEntityDescriptorEnum.ClosureValue_ord:
			visit((ClosureValue) entity);
			break;
		case SchemeEntityDescriptorEnum.BuiltinValue_ord:
			visit((BuiltinValue) entity);
			break;
		case SchemeEntityDescriptorEnum.BooleanValue_ord:
			visit((BooleanValue) entity);
			break;
		case SchemeEntityDescriptorEnum.IntValue_ord:
			visit((IntValue) entity);
			break;
		case SchemeEntityDescriptorEnum.StringValue_ord:
			visit((StringValue) entity);
			break;
		case SchemeEntityDescriptorEnum.PairValue_ord:
			visit((PairValue) entity);
			break;
		case SchemeEntityDescriptorEnum.Names_ord:
			visit((Names) entity);
			break;
		case SchemeEntityDescriptorEnum.Name_ord:
			visit((Name) entity);
			break;
		case SchemeEntityDescriptorEnum.SchemeEnvironment_ord:
			visit((SchemeEnvironment) entity);
			break;
		}
	}
}
