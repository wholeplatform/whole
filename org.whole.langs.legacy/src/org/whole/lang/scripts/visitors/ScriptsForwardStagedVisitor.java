package org.whole.lang.scripts.visitors;

import org.whole.lang.scripts.model.*;

/** 
 * @generator Whole
 */
public class ScriptsForwardStagedVisitor extends ScriptsIdentityVisitor {
	public void visit(Script entity) {
		stagedVisit(entity);
	}

	public void visit(LanguageName entity) {
		stagedVisit(entity);
	}
}
