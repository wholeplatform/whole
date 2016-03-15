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

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class XmlForwardStrategyVisitor extends GenericForwardStrategyVisitor<IXmlVisitor> implements IXmlVisitor {

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
