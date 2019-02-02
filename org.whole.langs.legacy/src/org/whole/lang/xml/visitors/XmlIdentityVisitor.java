/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
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
