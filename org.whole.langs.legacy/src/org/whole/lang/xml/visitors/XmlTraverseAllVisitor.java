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

import org.whole.lang.xml.visitors.XmlIdentityUnaryVisitor;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.xml.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class XmlTraverseAllVisitor extends XmlIdentityUnaryVisitor<IXmlVisitor> {

    public XmlTraverseAllVisitor() {
        wSetVisitor1(this);
    }

    public XmlTraverseAllVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Document entity) {
        entity.getProlog().accept(wGetVisitor1());
        entity.getElement().accept(wGetVisitor1());
    }

    public void visit(Prolog entity) {
        entity.getXmlDecl().accept(wGetVisitor1());
        entity.getDocTypeDecl().accept(wGetVisitor1());
        entity.getMisc().accept(wGetVisitor1());
    }

    public void visit(XMLDecl entity) {
        entity.getVersion().accept(wGetVisitor1());
        entity.getEncoding().accept(wGetVisitor1());
        entity.getStandalone().accept(wGetVisitor1());
    }

    public void visit(DocTypeDecl entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getExternalId().accept(wGetVisitor1());
    }

    public void visit(SystemId entity) {
        entity.getSystemLiteral().accept(wGetVisitor1());
    }

    public void visit(PublicId entity) {
        entity.getPubidLiteral().accept(wGetVisitor1());
        entity.getSystemLiteral().accept(wGetVisitor1());
    }

    public void visit(Misc entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(PI entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getInstruction().accept(wGetVisitor1());
    }

    public void visit(Comment entity) {
        entity.getText().accept(wGetVisitor1());
    }

    public void visit(Element entity) {
        entity.getTag().accept(wGetVisitor1());
        entity.getAttributes().accept(wGetVisitor1());
        entity.getContent().accept(wGetVisitor1());
    }

    public void visit(Attributes entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Attribute entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getValue().accept(wGetVisitor1());
    }

    public void visit(QualifiedName entity) {
        entity.getNameSpace().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
    }

    public void visit(Content entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(CDataSect entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }
}
