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
public interface InitializerDecl extends ISwiftEntity, Decl {


    public AttributeList getAttributes();

    public void setAttributes(AttributeList attributes);

    public ModifierList getModifiers();

    public void setModifiers(ModifierList modifiers);

    public OptionalMarkEnum getOptionalMark();

    public void setOptionalMark(OptionalMarkEnum optionalMark);

    public GenericParameterList getGenericParameterClause();

    public void setGenericParameterClause(GenericParameterList genericParameterClause);

    public FunctionParameterList getParameters();

    public void setParameters(FunctionParameterList parameters);

    public ThrowsOrRethrowsKeywordEnum getThrowsOrRethrowsKeyword();

    public void setThrowsOrRethrowsKeyword(ThrowsOrRethrowsKeywordEnum throwsOrRethrowsKeyword);

    public GenericRequirementList getGenericWhereClause();

    public void setGenericWhereClause(GenericRequirementList genericWhereClause);

    public CodeBlockItemList getBody();

    public void setBody(CodeBlockItemList body);
}
