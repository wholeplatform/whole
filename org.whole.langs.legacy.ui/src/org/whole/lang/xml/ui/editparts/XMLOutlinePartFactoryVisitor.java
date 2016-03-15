/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.xml.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.ui.editparts.CompositeColumnWithPlaceholderPart;
import org.whole.lang.ui.editparts.CompositeRowWithPlaceholderPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.ContentLighterTextualEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.outline.editparts.DefaultOutlinePartFactory;
import org.whole.lang.xml.model.Attribute;
import org.whole.lang.xml.model.Attributes;
import org.whole.lang.xml.model.CDataSect;
import org.whole.lang.xml.model.Comment;
import org.whole.lang.xml.model.CommentText;
import org.whole.lang.xml.model.Content;
import org.whole.lang.xml.model.DocTypeDecl;
import org.whole.lang.xml.model.Document;
import org.whole.lang.xml.model.Element;
import org.whole.lang.xml.model.IXmlEntity;
import org.whole.lang.xml.model.Misc;
import org.whole.lang.xml.model.Name;
import org.whole.lang.xml.model.NameSpace;
import org.whole.lang.xml.model.PI;
import org.whole.lang.xml.model.Prolog;
import org.whole.lang.xml.model.PublicId;
import org.whole.lang.xml.model.QualifiedName;
import org.whole.lang.xml.model.SystemId;
import org.whole.lang.xml.model.XMLDecl;
import org.whole.lang.xml.visitors.XmlIdentityDefaultVisitor;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class XMLOutlinePartFactoryVisitor extends XmlIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IXmlEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(IXmlEntity entity) {
		part = DefaultOutlinePartFactory.instance().createEditPart(context, entity);
	}

	public void visit(Document entity) {
		part = new DocumentPart();
	}

	public void visit(Prolog entity) {
		part = new PrologPart();
	}

	public void visit(XMLDecl entity) {
		part = new XMLDeclPart();
	}

	public void visit(Element entity) {
		part = new ElementOutlinePart();
	}

	public void visit(Attributes entity) {
		part = new CompositeRowWithPlaceholderPart();
	}

	public void visit(Attribute entity) {
		part = new AttributePart();
	}

	public void visit(Content entity) {
		part = new CompositeColumnWithPlaceholderPart();
	}

	public void visit(DocTypeDecl entity) {
		part = new DocTypeDeclOutlinePart();
	}

	public void visit(PublicId entity) {
		part = new PublicIdPart();
	}

	public void visit(SystemId entity) {
		part = new SystemIdPart();
	}

	public void visit(CDataSect entity) {
		part = new CDataSectOutlinePart();
	}

	public void visit(PI entity) {
		part = new PIOutlinePart();
	}

	public void visit(Comment entity) {
		part = new CommentOutlinePart();
	}

	public void visit(CommentText entity) {
		part = new ContentLighterTextualEntityPart();
	}

	public void visit(Misc entity) {
		part = new CompositeColumnWithPlaceholderPart();
	}

	public void visit(QualifiedName entity) {
		part = new QualifiedNamePart();
	}

	public void visit(NameSpace entity) {
		part = new ContentTextualEntityPart();
	}
	
	public void visit(Name entity) {
		part = new ContentTextualEntityPart();
	}
}
