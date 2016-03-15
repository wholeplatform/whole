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
