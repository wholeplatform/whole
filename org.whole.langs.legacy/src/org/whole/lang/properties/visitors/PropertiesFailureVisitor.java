package org.whole.lang.properties.visitors;

import org.whole.lang.properties.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class PropertiesFailureVisitor extends PropertiesIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Properties entity) {
		throw new VisitException();
	}

	public void visit(Entries entity) {
		throw new VisitException();
	}

	public void visit(Property entity) {
		throw new VisitException();
	}

	public void visit(Comment entity) {
		throw new VisitException();
	}

	public void visit(PropertyName entity) {
		throw new VisitException();
	}

	public void visit(PropertyValue entity) {
		throw new VisitException();
	}
}
