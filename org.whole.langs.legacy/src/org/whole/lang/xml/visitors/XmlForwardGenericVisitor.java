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

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class XmlForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements IXmlVisitor {

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
