package org.whole.lang.misc.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.misc.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.misc.reflect.MiscEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class MiscIdentitySwitchVisitor extends AbstractVisitor
		implements IMiscVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case MiscEntityDescriptorEnum.Misc_ord:
			visit((Misc) entity);
			break;
		}
	}
}
