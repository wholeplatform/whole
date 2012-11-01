package org.whole.lang.properties.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.properties.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PropertiesIdentityVisitor extends AbstractVisitor implements
		IPropertiesVisitor {
	public void visit(IEntity entity) {
		((IPropertiesEntity) entity).accept(this);
	}

	public void visit(Properties entity) {
	}

	public void visit(Entries entity) {
	}

	public void visit(Property entity) {
	}

	public void visit(Comment entity) {
	}

	public void visit(PropertyName entity) {
	}

	public void visit(PropertyValue entity) {
	}
}
