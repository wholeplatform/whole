package org.whole.lang.properties.visitors;

import org.whole.lang.visitors.AbstractBinaryVisitor;
import org.whole.lang.properties.visitors.IPropertiesVisitor;
import org.whole.lang.properties.model.*;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PropertiesSequenceVisitor extends
		AbstractBinaryVisitor<IPropertiesVisitor> implements IPropertiesVisitor {
	public PropertiesSequenceVisitor(IVisitor visitor1, IVisitor visitor2) {
		super(visitor1, visitor2);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Properties entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Entries entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Property entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Comment entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(PropertyName entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(PropertyValue entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}
}
