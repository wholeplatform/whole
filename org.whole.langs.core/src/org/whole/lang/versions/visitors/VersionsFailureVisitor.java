package org.whole.lang.versions.visitors;

import org.whole.lang.versions.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class VersionsFailureVisitor extends VersionsIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(History entity) {
		throw new VisitException();
	}

	public void visit(Version entity) {
		throw new VisitException();
	}

	public void visit(Versions entity) {
		throw new VisitException();
	}

	public void visit(VersionsRefs entity) {
		throw new VisitException();
	}

	public void visit(VersionLabel entity) {
		throw new VisitException();
	}
}
