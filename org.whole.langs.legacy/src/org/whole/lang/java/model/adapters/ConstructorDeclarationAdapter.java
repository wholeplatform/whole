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
package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class ConstructorDeclarationAdapter extends AbstractEntityAdapter implements ConstructorDeclaration {
    private static final long serialVersionUID = 1;

    public ConstructorDeclarationAdapter(IEntity implementor) {
        super(implementor);
    }

    public ConstructorDeclarationAdapter() {
    }

    public void accept(IJavaVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ConstructorDeclaration> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.ConstructorDeclaration;
    }

    public Javadoc getJavadoc() {
        return wGet(JavaFeatureDescriptorEnum.javadoc).wGetAdapter(JavaEntityDescriptorEnum.Javadoc);
    }

    public void setJavadoc(Javadoc javadoc) {
        wSet(JavaFeatureDescriptorEnum.javadoc, javadoc);
    }

    public ExtendedModifiers getModifiers() {
        return wGet(JavaFeatureDescriptorEnum.modifiers).wGetAdapter(JavaEntityDescriptorEnum.ExtendedModifiers);
    }

    public void setModifiers(ExtendedModifiers modifiers) {
        wSet(JavaFeatureDescriptorEnum.modifiers, modifiers);
    }

    public TypeParameters getTypeParameters() {
        return wGet(JavaFeatureDescriptorEnum.typeParameters).wGetAdapter(JavaEntityDescriptorEnum.TypeParameters);
    }

    public void setTypeParameters(TypeParameters typeParameters) {
        wSet(JavaFeatureDescriptorEnum.typeParameters, typeParameters);
    }

    public SimpleName getName() {
        return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(JavaEntityDescriptorEnum.SimpleName);
    }

    public void setName(SimpleName name) {
        wSet(JavaFeatureDescriptorEnum.name, name);
    }

    public Parameters getParameters() {
        return wGet(JavaFeatureDescriptorEnum.parameters).wGetAdapter(JavaEntityDescriptorEnum.Parameters);
    }

    public void setParameters(Parameters parameters) {
        wSet(JavaFeatureDescriptorEnum.parameters, parameters);
    }

    public ExtraDimensions getExtraDimensions() {
        return wGet(JavaFeatureDescriptorEnum.extraDimensions).wGetAdapter(JavaEntityDescriptorEnum.ExtraDimensions);
    }

    public void setExtraDimensions(ExtraDimensions extraDimensions) {
        wSet(JavaFeatureDescriptorEnum.extraDimensions, extraDimensions);
    }

    public Types getThrownExceptions() {
        return wGet(JavaFeatureDescriptorEnum.thrownExceptions).wGetAdapter(JavaEntityDescriptorEnum.Types);
    }

    public void setThrownExceptions(Types thrownExceptions) {
        wSet(JavaFeatureDescriptorEnum.thrownExceptions, thrownExceptions);
    }

    public Block getBody() {
        return wGet(JavaFeatureDescriptorEnum.body).wGetAdapter(JavaEntityDescriptorEnum.Block);
    }

    public void setBody(Block body) {
        wSet(JavaFeatureDescriptorEnum.body, body);
    }
}
