package org.whole.lang.modules.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.modules.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.modules.visitors.IModulesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.modules.reflect.ModulesEntityDescriptorEnum;
import org.whole.lang.modules.reflect.ModulesFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ModuleAdapter extends AbstractEntityAdapter implements Module {
    private static final long serialVersionUID = 1;

    public ModuleAdapter(IEntity implementor) {
        super(implementor);
    }

    public ModuleAdapter() {
    }

    public void accept(IModulesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Module> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.Module;
    }

    public Content getContent() {
        return wGet(ModulesFeatureDescriptorEnum.content).wGetAdapter(ModulesEntityDescriptorEnum.Content);
    }

    public void setContent(Content content) {
        wSet(ModulesFeatureDescriptorEnum.content, content);
    }
}
