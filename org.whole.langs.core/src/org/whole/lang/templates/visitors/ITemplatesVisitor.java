package org.whole.lang.templates.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.templates.model.*;

/** 
 * @generator Whole
 */
public interface ITemplatesVisitor extends IVisitor {
	public void visit(TemplateManager entity);

	public void visit(Templates entity);

	public void visit(TemplateFactory entity);

	public void visit(Names entity);

	public void visit(QualifiedName entity);

	public void visit(SimpleName entity);
}
