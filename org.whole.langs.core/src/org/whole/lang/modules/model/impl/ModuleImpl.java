package org.whole.lang.modules.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.modules.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.modules.reflect.ModulesEntityDescriptorEnum;
import org.whole.lang.modules.visitors.IModulesVisitor;
import org.whole.lang.modules.reflect.ModulesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class ModuleImpl extends AbstractSimpleEntity implements Module {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Module> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.Module;
    }

    public int wGetEntityOrd() {
        return ModulesEntityDescriptorEnum.Module_ord;
    }

    public void accept(IModulesVisitor visitor) {
        visitor.visit(this);
    }
    private Content content;

    public Content getContent() {
        return notifyRequested(ModulesFeatureDescriptorEnum.content, content);
    }

    public void setContent(Content content) {
        notifyChanged(ModulesFeatureDescriptorEnum.content, this.content, this.content = content);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getContent().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setContent(value.wGetAdapter(ModulesEntityDescriptorEnum.Content));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
