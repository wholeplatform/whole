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
public class ModuleDeclarationAdapter extends AbstractEntityAdapter implements ModuleDeclaration {
    private static final long serialVersionUID = 1;

    public ModuleDeclarationAdapter(IEntity implementor) {
        super(implementor);
    }

    public ModuleDeclarationAdapter() {
    }

    public void accept(IJavaVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ModuleDeclaration> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.ModuleDeclaration;
    }

    public Javadoc getJavadoc() {
        return wGet(JavaFeatureDescriptorEnum.javadoc).wGetAdapter(JavaEntityDescriptorEnum.Javadoc);
    }

    public void setJavadoc(Javadoc javadoc) {
        wSet(JavaFeatureDescriptorEnum.javadoc, javadoc);
    }

    public Annotations getAnnotations() {
        return wGet(JavaFeatureDescriptorEnum.annotations).wGetAdapter(JavaEntityDescriptorEnum.Annotations);
    }

    public void setAnnotations(Annotations annotations) {
        wSet(JavaFeatureDescriptorEnum.annotations, annotations);
    }

    public Open getOpen() {
        return wGet(JavaFeatureDescriptorEnum.open).wGetAdapter(JavaEntityDescriptorEnum.Open);
    }

    public void setOpen(Open open) {
        wSet(JavaFeatureDescriptorEnum.open, open);
    }

    public Name getName() {
        return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(JavaEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(JavaFeatureDescriptorEnum.name, name);
    }

    public ModuleDirectives getModuleDirectives() {
        return wGet(JavaFeatureDescriptorEnum.moduleDirectives).wGetAdapter(JavaEntityDescriptorEnum.ModuleDirectives);
    }

    public void setModuleDirectives(ModuleDirectives moduleDirectives) {
        wSet(JavaFeatureDescriptorEnum.moduleDirectives, moduleDirectives);
    }
}
