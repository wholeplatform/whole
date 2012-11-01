package org.whole.lang.versions.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.versions.model.*;

/** 
 * @generator Whole
 */
public interface IVersionsVisitor extends IVisitor {
	public void visit(History entity);

	public void visit(Version entity);

	public void visit(Versions entity);

	public void visit(VersionsRefs entity);

	public void visit(VersionLabel entity);
}
