package org.whole.lang.properties.visitors;

import org.whole.lang.properties.visitors.PropertiesIdentityUnaryVisitor;
import org.whole.lang.properties.visitors.IPropertiesVisitor;
import org.whole.lang.properties.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class PropertiesTraverseAllChildrenVisitor extends
		PropertiesIdentityUnaryVisitor<IPropertiesVisitor> {
	public PropertiesTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public PropertiesTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Properties entity) {
		entity.getComment().accept(wGetVisitor1());
		entity.getDefaults().accept(wGetVisitor1());
		entity.getEntries().accept(wGetVisitor1());
	}

	public void visit(Entries entity) {
		for (Property child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(Property entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
	}
}
