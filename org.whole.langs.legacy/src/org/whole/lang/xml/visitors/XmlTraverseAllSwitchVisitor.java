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
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.xml.model.*;

/**
 *  @generator Whole
 */
public class XmlTraverseAllSwitchVisitor extends XmlIdentityUnaryVisitor<IVisitor> {

    public XmlTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Document entity) {
        wGetVisitor1().visit(entity.getProlog());
        wGetVisitor1().visit(entity.getElement());
    }

    public void visit(Prolog entity) {
        wGetVisitor1().visit(entity.getXmlDecl());
        wGetVisitor1().visit(entity.getDocTypeDecl());
        wGetVisitor1().visit(entity.getMisc());
    }

    public void visit(XMLDecl entity) {
        wGetVisitor1().visit(entity.getVersion());
        wGetVisitor1().visit(entity.getEncoding());
        wGetVisitor1().visit(entity.getStandalone());
    }

    public void visit(DocTypeDecl entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getExternalId());
    }

    public void visit(SystemId entity) {
        wGetVisitor1().visit(entity.getSystemLiteral());
    }

    public void visit(PublicId entity) {
        wGetVisitor1().visit(entity.getPubidLiteral());
        wGetVisitor1().visit(entity.getSystemLiteral());
    }

    public void visit(Misc entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(PI entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getInstruction());
    }

    public void visit(Comment entity) {
        wGetVisitor1().visit(entity.getText());
    }

    public void visit(Element entity) {
        wGetVisitor1().visit(entity.getTag());
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getContent());
    }

    public void visit(Attributes entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Attribute entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getValue());
    }

    public void visit(QualifiedName entity) {
        wGetVisitor1().visit(entity.getNameSpace());
        wGetVisitor1().visit(entity.getName());
    }

    public void visit(Content entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(CDataSect entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }
}
