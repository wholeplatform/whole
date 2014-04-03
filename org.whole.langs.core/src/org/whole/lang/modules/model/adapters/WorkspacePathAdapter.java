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
public class WorkspacePathAdapter extends AbstractEntityAdapter implements WorkspacePath {
    private static final long serialVersionUID = 1;

    public WorkspacePathAdapter(IEntity implementor) {
        super(implementor);
    }

    public WorkspacePathAdapter() {
    }

    public void accept(IModulesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<WorkspacePath> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.WorkspacePath;
    }

    public String getValue() {
        return wStringValue();
    }

    public void setValue(String value) {
        wSetValue(value);
    }
}
