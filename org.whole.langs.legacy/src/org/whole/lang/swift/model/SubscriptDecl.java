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
package org.whole.lang.swift.model;


/**
 *  @generator Whole
 */
public interface SubscriptDecl extends ISwiftEntity, Decl {


    public AttributeList getAttributes();

    public void setAttributes(AttributeList attributes);

    public ModifierList getModifiers();

    public void setModifiers(ModifierList modifiers);

    public GenericParameterList getGenericParameterClause();

    public void setGenericParameterClause(GenericParameterList genericParameterClause);

    public FunctionParameterList getIndices();

    public void setIndices(FunctionParameterList indices);

    public Type getResult();

    public void setResult(Type result);

    public GenericRequirementList getGenericWhereClause();

    public void setGenericWhereClause(GenericRequirementList genericWhereClause);

    public AbstractAccessor getAccessor();

    public void setAccessor(AbstractAccessor accessor);
}
