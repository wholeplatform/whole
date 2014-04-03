package org.whole.lang.modules.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.modules.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.modules.visitors.IModulesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.modules.reflect.ModulesEntityDescriptorEnum;

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

    public void accept(IModulesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ClassPathURI> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.ClassPathURI;
    }

    public String getValue() {
        return wStringValue();
    }

    public void setValue(String value) {
        wSetValue(value);
    }
}
