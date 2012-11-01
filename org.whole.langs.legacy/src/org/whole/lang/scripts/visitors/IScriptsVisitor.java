package org.whole.lang.scripts.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.scripts.model.*;

/** 
 * @generator Whole
 */
public interface IScriptsVisitor extends IVisitor {
	public void visit(Script entity);

	public void visit(LanguageName entity);
}
