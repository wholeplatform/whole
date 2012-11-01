package org.whole.lang.properties.visitors;

import org.whole.lang.properties.visitors.PropertiesIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.properties.model.*;

/** 
 * @generator Whole
 */
public class PropertiesTraverseAllSwitchVisitor extends
		PropertiesIdentityUnaryVisitor<IVisitor> {
	public PropertiesTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Properties entity) {
		wGetVisitor1().visit(entity.getComment());
		wGetVisitor1().visit(entity.getDefaults());
		wGetVisitor1().visit(entity.getEntries());
	}

	public void visit(Entries entity) {
		for (Property child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(Property entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getValue());
	}
}
