package org.whole.lang.scripts.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.scripts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.scripts.reflect.ScriptsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class ScriptsIdentitySwitchVisitor extends AbstractVisitor
		implements IScriptsVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case ScriptsEntityDescriptorEnum.Script_ord:
			visit((Script) entity);
			break;
		case ScriptsEntityDescriptorEnum.LanguageName_ord:
			visit((LanguageName) entity);
			break;
		}
	}
}
