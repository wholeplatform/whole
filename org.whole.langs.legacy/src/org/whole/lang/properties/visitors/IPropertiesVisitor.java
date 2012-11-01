package org.whole.lang.properties.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.properties.model.*;

/** 
 * @generator Whole
 */
public interface IPropertiesVisitor extends IVisitor {
	public void visit(Properties entity);

	public void visit(Entries entity);

	public void visit(Property entity);

	public void visit(Comment entity);

	public void visit(PropertyName entity);

	public void visit(PropertyValue entity);
}
