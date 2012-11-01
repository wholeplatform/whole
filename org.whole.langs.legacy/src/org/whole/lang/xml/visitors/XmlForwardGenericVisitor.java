package org.whole.lang.xml.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class XmlForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor>
		implements IXmlVisitor {
	public XmlForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Document entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Prolog entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(XMLDecl entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Version entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Encoding entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Standalone entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DocTypeDecl entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SystemId entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SystemLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PublicId entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PubidLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Misc entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PI entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Instruction entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Comment entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CommentText entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Element entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Attributes entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Attribute entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Name entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(QualifiedName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(NameSpace entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Value entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Content entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CharData entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CDataSect entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CDataSectData entity) {
		wGetVisitor1().visit(entity);
	}
}
