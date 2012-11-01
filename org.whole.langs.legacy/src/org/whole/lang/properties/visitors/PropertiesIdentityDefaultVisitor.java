package org.whole.lang.properties.visitors;

import org.whole.lang.properties.model.*;

/** 
 * @generator Whole
 */
public class PropertiesIdentityDefaultVisitor extends PropertiesIdentityVisitor {
	public void visit(IPropertiesEntity entity) {
	}

	public void visit(Properties entity) {
		visit((IPropertiesEntity) entity);
	}

	public void visit(Entries entity) {
		visit((IPropertiesEntity) entity);
	}

	public void visit(Property entity) {
		visit((IPropertiesEntity) entity);
	}

	public void visit(Comment entity) {
		visit((IPropertiesEntity) entity);
	}

	public void visit(PropertyName entity) {
		visit((IPropertiesEntity) entity);
	}

	public void visit(PropertyValue entity) {
		visit((IPropertiesEntity) entity);
	}
}
