package org.whole.lang.reusables.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.reusables.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ClassPathURIAdapter extends AbstractEntityAdapter implements ClassPathURI {
    private static final long serialVersionUID = 1;

    public ClassPathURIAdapter(IEntity implementor) {
        super(implementor);
    }

    public ClassPathURIAdapter() {
    }

    public void accept(IReusablesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ClassPathURI> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.ClassPathURI;
    }

    public String getValue() {
        return wStringValue();
    }

    public void setValue(String value) {
        wSetValue(value);
    }
}
