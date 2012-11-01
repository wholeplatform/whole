package org.whole.lang.properties.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.properties.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PropertiesForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements IPropertiesVisitor {
	public PropertiesForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Properties entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Entries entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Property entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Comment entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PropertyName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PropertyValue entity) {
		wGetVisitor1().visit(entity);
	}
}
