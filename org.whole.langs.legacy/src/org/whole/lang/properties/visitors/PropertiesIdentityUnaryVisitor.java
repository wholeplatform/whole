package org.whole.lang.properties.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.properties.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PropertiesIdentityUnaryVisitor<V extends IVisitor> extends
		AbstractUnaryVisitor<V> implements IPropertiesVisitor {
	public PropertiesIdentityUnaryVisitor() {
		super(null);
	}

	public PropertiesIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

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
