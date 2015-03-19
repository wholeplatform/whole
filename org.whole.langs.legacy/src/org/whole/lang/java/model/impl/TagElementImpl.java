/**
 *  Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.java.model.TagElement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.TagName;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.DocElements;

/**
 *  @generator Whole
 */
public class TagElementImpl extends AbstractSimpleEntity implements TagElement {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<TagElement> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.TagElement;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.TagElement_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private TagName tagName;

    public TagName getTagName() {
        return notifyRequested(JavaFeatureDescriptorEnum.tagName, tagName);
    }

    public void setTagName(TagName tagName) {
        notifyChanged(JavaFeatureDescriptorEnum.tagName, this.tagName, this.tagName = tagName);
    }
    private DocElements fragments;

    public DocElements getFragments() {
        return notifyRequested(JavaFeatureDescriptorEnum.fragments, fragments);
    }

    public void setFragments(DocElements fragments) {
        notifyChanged(JavaFeatureDescriptorEnum.fragments, this.fragments, this.fragments = fragments);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getTagName().wGetAdaptee(false);
            case 1 :
            return getFragments().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setTagName(value.wGetAdapter(JavaEntityDescriptorEnum.TagName));
            break;
            case 1 :
            setFragments(value.wGetAdapter(JavaEntityDescriptorEnum.DocElements));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
