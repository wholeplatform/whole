package org.whole.lang.xml.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class XmlForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IXmlVisitor> implements IXmlVisitor {
	public XmlForwardStrategyVisitor() {
		this(new XmlIdentityVisitor());
	}

	public XmlForwardStrategyVisitor(IXmlVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IXmlEntity) entity).accept(this);
	}

	public void visit(Document entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Prolog entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(XMLDecl entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Version entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Encoding entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Standalone entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DocTypeDecl entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SystemId entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SystemLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PublicId entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PubidLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Misc entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PI entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Instruction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Comment entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CommentText entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Element entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Attributes entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Attribute entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Name entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(QualifiedName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NameSpace entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Value entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Content entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CharData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CDataSect entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CDataSectData entity) {
		wGetStrategy().visit(entity);
	}
}
