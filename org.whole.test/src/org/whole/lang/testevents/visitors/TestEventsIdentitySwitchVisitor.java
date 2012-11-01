package org.whole.lang.testevents.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.testevents.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class TestEventsIdentitySwitchVisitor extends AbstractVisitor
		implements ITestEventsVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case TestEventsEntityDescriptorEnum.TestEvents_ord:
			visit((TestEvents) entity);
			break;
		case TestEventsEntityDescriptorEnum.CompositeShape_ord:
			visit((CompositeShape) entity);
			break;
		case TestEventsEntityDescriptorEnum.Rectangle_ord:
			visit((Rectangle) entity);
			break;
		case TestEventsEntityDescriptorEnum.Labels_ord:
			visit((Labels) entity);
			break;
		case TestEventsEntityDescriptorEnum.Val_ord:
			visit((Val) entity);
			break;
		case TestEventsEntityDescriptorEnum.Label_ord:
			visit((Label) entity);
			break;
		}
	}
}
