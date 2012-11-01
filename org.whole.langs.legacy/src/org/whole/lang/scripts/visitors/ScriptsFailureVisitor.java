package org.whole.lang.scripts.visitors;

import org.whole.lang.scripts.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class ScriptsFailureVisitor extends ScriptsIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Script entity) {
		throw new VisitException();
	}

	public void visit(LanguageName entity) {
		throw new VisitException();
	}
}
