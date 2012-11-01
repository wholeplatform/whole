package org.whole.lang.xml.visitors;

import org.whole.lang.xml.model.*;

/** 
 * @generator Whole
 */
public class XmlForwardStagedVisitor extends XmlIdentityVisitor {
	public void visit(Document entity) {
		stagedVisit(entity);
	}

	public void visit(Prolog entity) {
		stagedVisit(entity);
	}

	public void visit(XMLDecl entity) {
		stagedVisit(entity);
	}

	public void visit(Version entity) {
		stagedVisit(entity);
	}

	public void visit(Encoding entity) {
		stagedVisit(entity);
	}

	public void visit(Standalone entity) {
		stagedVisit(entity);
	}

	public void visit(DocTypeDecl entity) {
		stagedVisit(entity);
	}

	public void visit(SystemId entity) {
		stagedVisit(entity);
	}

	public void visit(SystemLiteral entity) {
		stagedVisit(entity);
	}

	public void visit(PublicId entity) {
		stagedVisit(entity);
	}

	public void visit(PubidLiteral entity) {
		stagedVisit(entity);
	}

	public void visit(Misc entity) {
		stagedVisit(entity);
	}

	public void visit(PI entity) {
		stagedVisit(entity);
	}

	public void visit(Instruction entity) {
		stagedVisit(entity);
	}

	public void visit(Comment entity) {
		stagedVisit(entity);
	}

	public void visit(CommentText entity) {
		stagedVisit(entity);
	}

	public void visit(Element entity) {
		stagedVisit(entity);
	}

	public void visit(Attributes entity) {
		stagedVisit(entity);
	}

	public void visit(Attribute entity) {
		stagedVisit(entity);
	}

	public void visit(Name entity) {
		stagedVisit(entity);
	}

	public void visit(QualifiedName entity) {
		stagedVisit(entity);
	}

	public void visit(NameSpace entity) {
		stagedVisit(entity);
	}

	public void visit(Value entity) {
		stagedVisit(entity);
	}

	public void visit(Content entity) {
		stagedVisit(entity);
	}

	public void visit(CharData entity) {
		stagedVisit(entity);
	}

	public void visit(CDataSect entity) {
		stagedVisit(entity);
	}

	public void visit(CDataSectData entity) {
		stagedVisit(entity);
	}
}
