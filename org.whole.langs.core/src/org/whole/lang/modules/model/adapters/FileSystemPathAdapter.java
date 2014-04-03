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
public class FileSystemPathAdapter extends AbstractEntityAdapter implements FileSystemPath {
    private static final long serialVersionUID = 1;

    public FileSystemPathAdapter(IEntity implementor) {
        super(implementor);
    }

    public FileSystemPathAdapter() {
    }

    public void accept(IModulesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<FileSystemPath> wGetEntityDescriptor() {
        return ModulesEntityDescriptorEnum.FileSystemPath;
    }

    public String getValue() {
        return wStringValue();
    }

    public void setValue(String value) {
        wSetValue(value);
    }
}
