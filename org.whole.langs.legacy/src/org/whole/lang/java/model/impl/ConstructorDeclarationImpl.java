/**
 *  Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.ConstructorDeclaration;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.Javadoc;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.ExtendedModifiers;
import org.whole.lang.java.model.TypeParameters;
import org.whole.lang.java.model.SimpleName;
import org.whole.lang.java.model.Parameters;
import org.whole.lang.java.model.ExtraDimensions;
import org.whole.lang.java.model.Types;
import org.whole.lang.java.model.Block;

/**
 *  @generator Whole
 */
public class ConstructorDeclarationImpl extends AbstractSimpleEntity implements ConstructorDeclaration {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ConstructorDeclaration> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.ConstructorDeclaration;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.ConstructorDeclaration_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Javadoc javadoc;

    public Javadoc getJavadoc() {
        return notifyRequested(JavaFeatureDescriptorEnum.javadoc, javadoc);
    }

    public void setJavadoc(Javadoc javadoc) {
        notifyChanged(JavaFeatureDescriptorEnum.javadoc, this.javadoc, this.javadoc = javadoc);
    }
    private ExtendedModifiers modifiers;

    public ExtendedModifiers getModifiers() {
        return notifyRequested(JavaFeatureDescriptorEnum.modifiers, modifiers);
    }

    public void setModifiers(ExtendedModifiers modifiers) {
        notifyChanged(JavaFeatureDescriptorEnum.modifiers, this.modifiers, this.modifiers = modifiers);
    }
    private TypeParameters typeParameters;

    public TypeParameters getTypeParameters() {
        return notifyRequested(JavaFeatureDescriptorEnum.typeParameters, typeParameters);
    }

    public void setTypeParameters(TypeParameters typeParameters) {
        notifyChanged(JavaFeatureDescriptorEnum.typeParameters, this.typeParameters, this.typeParameters = typeParameters);
    }
    private SimpleName name;

    public SimpleName getName() {
        return notifyRequested(JavaFeatureDescriptorEnum.name, name);
    }

    public void setName(SimpleName name) {
        notifyChanged(JavaFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Parameters parameters;

    public Parameters getParameters() {
        return notifyRequested(JavaFeatureDescriptorEnum.parameters, parameters);
    }

    public void setParameters(Parameters parameters) {
        notifyChanged(JavaFeatureDescriptorEnum.parameters, this.parameters, this.parameters = parameters);
    }
    private ExtraDimensions extraDimensions;

    public ExtraDimensions getExtraDimensions() {
        return notifyRequested(JavaFeatureDescriptorEnum.extraDimensions, extraDimensions);
    }

    public void setExtraDimensions(ExtraDimensions extraDimensions) {
        notifyChanged(JavaFeatureDescriptorEnum.extraDimensions, this.extraDimensions, this.extraDimensions = extraDimensions);
    }
    private Types thrownExceptions;

    public Types getThrownExceptions() {
        return notifyRequested(JavaFeatureDescriptorEnum.thrownExceptions, thrownExceptions);
    }

    public void setThrownExceptions(Types thrownExceptions) {
        notifyChanged(JavaFeatureDescriptorEnum.thrownExceptions, this.thrownExceptions, this.thrownExceptions = thrownExceptions);
    }
    private Block body;

    public Block getBody() {
        return notifyRequested(JavaFeatureDescriptorEnum.body, body);
    }

    public void setBody(Block body) {
        notifyChanged(JavaFeatureDescriptorEnum.body, this.body, this.body = body);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getJavadoc().wGetAdaptee(false);
            case 1 :
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getTypeParameters().wGetAdaptee(false);
            case 3 :
            return getName().wGetAdaptee(false);
            case 4 :
            return getParameters().wGetAdaptee(false);
            case 5 :
            return getExtraDimensions().wGetAdaptee(false);
            case 6 :
            return getThrownExceptions().wGetAdaptee(false);
            case 7 :
            return getBody().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setJavadoc(value.wGetAdapter(JavaEntityDescriptorEnum.Javadoc));
            break;
            case 1 :
            setModifiers(value.wGetAdapter(JavaEntityDescriptorEnum.ExtendedModifiers));
            break;
            case 2 :
            setTypeParameters(value.wGetAdapter(JavaEntityDescriptorEnum.TypeParameters));
            break;
            case 3 :
            setName(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
            break;
            case 4 :
            setParameters(value.wGetAdapter(JavaEntityDescriptorEnum.Parameters));
            break;
            case 5 :
            setExtraDimensions(value.wGetAdapter(JavaEntityDescriptorEnum.ExtraDimensions));
            break;
            case 6 :
            setThrownExceptions(value.wGetAdapter(JavaEntityDescriptorEnum.Types));
            break;
            case 7 :
            setBody(value.wGetAdapter(JavaEntityDescriptorEnum.Block));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 8;
    }
}
