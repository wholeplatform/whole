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
package org.whole.lang.swiftsyntax.model;


/**
 *  @generator Whole
 */
public interface ProtocolDecl extends ISwiftSyntaxEntity, Decl {


    public AttributeList getAttributes();

    public void setAttributes(AttributeList attributes);

    public ModifierList getModifiers();

    public void setModifiers(ModifierList modifiers);

    public Token getProtocolKeyword();

    public void setProtocolKeyword(Token protocolKeyword);

    public Token getIdentifier();

    public void setIdentifier(Token identifier);

    public TypeInheritanceClause getInheritanceClause();

    public void setInheritanceClause(TypeInheritanceClause inheritanceClause);

    public GenericWhereClause getGenericWhereClause();

    public void setGenericWhereClause(GenericWhereClause genericWhereClause);

    public MemberDeclBlock getMembers();

    public void setMembers(MemberDeclBlock members);
}
