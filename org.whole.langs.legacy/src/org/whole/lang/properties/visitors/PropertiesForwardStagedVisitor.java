package org.whole.lang.properties.visitors;

import org.whole.lang.properties.model.*;

/** 
 * @generator Whole
 */
public class PropertiesForwardStagedVisitor extends PropertiesIdentityVisitor {
	public void visit(Properties entity) {
		stagedVisit(entity);
	}

	public void visit(Entries entity) {
		stagedVisit(entity);
	}

	public void visit(Property entity) {
		stagedVisit(entity);
	}

	public void visit(Comment entity) {
		stagedVisit(entity);
	}

	public void visit(PropertyName entity) {
		stagedVisit(entity);
	}

	public void visit(PropertyValue entity) {
		stagedVisit(entity);
	}
}
