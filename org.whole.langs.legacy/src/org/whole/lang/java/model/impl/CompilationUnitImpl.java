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
import org.whole.lang.java.model.CompilationUnit;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.PackageDeclaration;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.ImportDeclarations;
import org.whole.lang.java.model.TypeDeclarations;

/**
 *  @generator Whole
 */
public class CompilationUnitImpl extends AbstractSimpleEntity implements CompilationUnit {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<CompilationUnit> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.CompilationUnit;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.CompilationUnit_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private PackageDeclaration _package;

    public PackageDeclaration getPackage() {
        return notifyRequested(JavaFeatureDescriptorEnum._package, _package);
    }

    public void setPackage(PackageDeclaration _package) {
        notifyChanged(JavaFeatureDescriptorEnum._package, this._package, this._package = _package);
    }
    private ImportDeclarations imports;

    public ImportDeclarations getImports() {
        return notifyRequested(JavaFeatureDescriptorEnum.imports, imports);
    }

    public void setImports(ImportDeclarations imports) {
        notifyChanged(JavaFeatureDescriptorEnum.imports, this.imports, this.imports = imports);
    }
    private TypeDeclarations types;

    public TypeDeclarations getTypes() {
        return notifyRequested(JavaFeatureDescriptorEnum.types, types);
    }

    public void setTypes(TypeDeclarations types) {
        notifyChanged(JavaFeatureDescriptorEnum.types, this.types, this.types = types);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getPackage().wGetAdaptee(false);
            case 1 :
            return getImports().wGetAdaptee(false);
            case 2 :
            return getTypes().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setPackage(value.wGetAdapter(JavaEntityDescriptorEnum.PackageDeclaration));
            break;
            case 1 :
            setImports(value.wGetAdapter(JavaEntityDescriptorEnum.ImportDeclarations));
            break;
            case 2 :
            setTypes(value.wGetAdapter(JavaEntityDescriptorEnum.TypeDeclarations));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
