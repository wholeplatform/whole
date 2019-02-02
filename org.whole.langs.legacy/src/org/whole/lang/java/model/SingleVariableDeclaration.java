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
package org.whole.lang.java.model;


/**
 *  @generator Whole
 */
public interface SingleVariableDeclaration extends IJavaEntity, VariableDeclaration {


    public ExtendedModifiers getModifiers();

    public void setModifiers(ExtendedModifiers modifiers);

    public Type getType();

    public void setType(Type type);

    public Varargs getVarargs();

    public void setVarargs(Varargs varargs);

    public SimpleName getName();

    public void setName(SimpleName name);

    public ExtraDimensions getExtraDimensions();

    public void setExtraDimensions(ExtraDimensions extraDimensions);

    public Expression getInitializer();

    public void setInitializer(Expression initializer);

    public Annotations getVarargsAnnotations();

    public void setVarargsAnnotations(Annotations varargsAnnotations);
}
