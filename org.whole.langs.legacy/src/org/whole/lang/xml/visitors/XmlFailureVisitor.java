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
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/**
 *  @generator Whole
 */
public class XmlFailureVisitor extends XmlIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(Document entity) {
        throw new VisitException();
    }

    public void visit(Prolog entity) {
        throw new VisitException();
    }

    public void visit(XMLDecl entity) {
        throw new VisitException();
    }

    public void visit(Version entity) {
        throw new VisitException();
    }

    public void visit(Encoding entity) {
        throw new VisitException();
    }

    public void visit(Standalone entity) {
        throw new VisitException();
    }

    public void visit(DocTypeDecl entity) {
        throw new VisitException();
    }

    public void visit(SystemId entity) {
        throw new VisitException();
    }

    public void visit(SystemLiteral entity) {
        throw new VisitException();
    }

    public void visit(PublicId entity) {
        throw new VisitException();
    }

    public void visit(PubidLiteral entity) {
        throw new VisitException();
    }

    public void visit(Misc entity) {
        throw new VisitException();
    }

    public void visit(PI entity) {
        throw new VisitException();
    }

    public void visit(Instruction entity) {
        throw new VisitException();
    }

    public void visit(Comment entity) {
        throw new VisitException();
    }

    public void visit(CommentText entity) {
        throw new VisitException();
    }

    public void visit(Element entity) {
        throw new VisitException();
    }

    public void visit(Attributes entity) {
        throw new VisitException();
    }

    public void visit(Attribute entity) {
        throw new VisitException();
    }

    public void visit(Name entity) {
        throw new VisitException();
    }

    public void visit(QualifiedName entity) {
        throw new VisitException();
    }

    public void visit(NameSpace entity) {
        throw new VisitException();
    }

    public void visit(Value entity) {
        throw new VisitException();
    }

    public void visit(Content entity) {
        throw new VisitException();
    }

    public void visit(CharData entity) {
        throw new VisitException();
    }

    public void visit(CDataSect entity) {
        throw new VisitException();
    }

    public void visit(CDataSectData entity) {
        throw new VisitException();
    }
}
