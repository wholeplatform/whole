package org.whole.lang.environment.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.environment.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.environment.model.Void;

/** 
 * @generator Whole
 */
public abstract class EnvironmentIdentitySwitchVisitor extends AbstractVisitor
		implements IEnvironmentVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case EnvironmentEntityDescriptorEnum.BooleanData_ord:
			visit((BooleanData) entity);
			break;
		case EnvironmentEntityDescriptorEnum.ByteData_ord:
			visit((ByteData) entity);
			break;
		case EnvironmentEntityDescriptorEnum.CharData_ord:
			visit((CharData) entity);
			break;
		case EnvironmentEntityDescriptorEnum.DoubleData_ord:
			visit((DoubleData) entity);
			break;
		case EnvironmentEntityDescriptorEnum.FloatData_ord:
			visit((FloatData) entity);
			break;
		case EnvironmentEntityDescriptorEnum.IntData_ord:
			visit((IntData) entity);
			break;
		case EnvironmentEntityDescriptorEnum.LongData_ord:
			visit((LongData) entity);
			break;
		case EnvironmentEntityDescriptorEnum.ShortData_ord:
			visit((ShortData) entity);
			break;
		case EnvironmentEntityDescriptorEnum.StringData_ord:
			visit((StringData) entity);
			break;
		case EnvironmentEntityDescriptorEnum.DateData_ord:
			visit((DateData) entity);
			break;
		case EnvironmentEntityDescriptorEnum.ObjectData_ord:
			visit((ObjectData) entity);
			break;
		case EnvironmentEntityDescriptorEnum.Tuple_ord:
			visit((Tuple) entity);
			break;
		case EnvironmentEntityDescriptorEnum.ContainmentTuple_ord:
			visit((ContainmentTuple) entity);
			break;
		case EnvironmentEntityDescriptorEnum.Void_ord:
			visit((Void) entity);
			break;
		}
	}
}
