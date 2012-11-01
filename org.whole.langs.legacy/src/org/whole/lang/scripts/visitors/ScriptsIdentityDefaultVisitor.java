package org.whole.lang.scripts.visitors;

import org.whole.lang.scripts.model.*;

/** 
 * @generator Whole
 */
public class ScriptsIdentityDefaultVisitor extends ScriptsIdentityVisitor {
	public void visit(IScriptsEntity entity) {
	}

	public void visit(Script entity) {
		visit((IScriptsEntity) entity);
	}

	public void visit(LanguageName entity) {
		visit((IScriptsEntity) entity);
	}
}
