/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.xml.visitors;

import org.whole.lang.xml.model.*;

/**
 *  @generator Whole
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
