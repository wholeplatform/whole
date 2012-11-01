package org.whole.lang.xml.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class XmlIdentityVisitor extends AbstractVisitor implements IXmlVisitor {
	public void visit(IEntity entity) {
		((IXmlEntity) entity).accept(this);
	}

	public void visit(Document entity) {
	}

	public void visit(Prolog entity) {
	}

	public void visit(XMLDecl entity) {
	}

	public void visit(Version entity) {
	}

	public void visit(Encoding entity) {
	}

	public void visit(Standalone entity) {
	}

	public void visit(DocTypeDecl entity) {
	}

	public void visit(SystemId entity) {
	}

	public void visit(SystemLiteral entity) {
	}

	public void visit(PublicId entity) {
	}

	public void visit(PubidLiteral entity) {
	}

	public void visit(Misc entity) {
	}

	public void visit(PI entity) {
	}

	public void visit(Instruction entity) {
	}

	public void visit(Comment entity) {
	}

	public void visit(CommentText entity) {
	}

	public void visit(Element entity) {
	}

	public void visit(Attributes entity) {
	}

	public void visit(Attribute entity) {
	}

	public void visit(Name entity) {
	}

	public void visit(QualifiedName entity) {
	}

	public void visit(NameSpace entity) {
	}

	public void visit(Value entity) {
	}

	public void visit(Content entity) {
	}

	public void visit(CharData entity) {
	}

	public void visit(CDataSect entity) {
	}

	public void visit(CDataSectData entity) {
	}
}
