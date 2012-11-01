package org.whole.lang.xml.visitors;

import org.whole.lang.xml.model.*;

/** 
 * @generator Whole
 */
public class XmlIdentityDefaultVisitor extends XmlIdentityVisitor {
	public void visit(IXmlEntity entity) {
	}

	public void visit(Document entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(Prolog entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(XMLDecl entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(Version entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(Encoding entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(Standalone entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(DocTypeDecl entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(IExternalId entity) {
	}

	public void visit(SystemId entity) {
		visit((IXmlEntity) entity);
		visit((IExternalId) entity);
	}

	public void visit(SystemLiteral entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(PublicId entity) {
		visit((IXmlEntity) entity);
		visit((IExternalId) entity);
	}

	public void visit(PubidLiteral entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(Misc entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(IMisc entity) {
	}

	public void visit(PI entity) {
		visit((IXmlEntity) entity);
		visit((IMisc) entity);
		visit((IContent) entity);
	}

	public void visit(IContent entity) {
	}

	public void visit(Instruction entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(Comment entity) {
		visit((IXmlEntity) entity);
		visit((IMisc) entity);
		visit((IContent) entity);
	}

	public void visit(CommentText entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(Element entity) {
		visit((IXmlEntity) entity);
		visit((IContent) entity);
	}

	public void visit(Attributes entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(Attribute entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(IName entity) {
	}

	public void visit(Name entity) {
		visit((IXmlEntity) entity);
		visit((IName) entity);
	}

	public void visit(QualifiedName entity) {
		visit((IXmlEntity) entity);
		visit((IName) entity);
	}

	public void visit(NameSpace entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(Value entity) {
		visit((IXmlEntity) entity);
	}

	public void visit(Content entity) {
		visit((IXmlEntity) entity);
		visit((IContent) entity);
	}

	public void visit(CharData entity) {
		visit((IXmlEntity) entity);
		visit((IContent) entity);
	}

	public void visit(CDataSect entity) {
		visit((IXmlEntity) entity);
		visit((IContent) entity);
	}

	public void visit(CDataSectData entity) {
		visit((IXmlEntity) entity);
	}
}
