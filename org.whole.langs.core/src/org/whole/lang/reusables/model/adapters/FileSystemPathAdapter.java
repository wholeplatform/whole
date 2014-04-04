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
public class FileSystemPathAdapter extends AbstractEntityAdapter implements FileSystemPath {
    private static final long serialVersionUID = 1;

    public FileSystemPathAdapter(IEntity implementor) {
        super(implementor);
    }

    public FileSystemPathAdapter() {
    }

    public void accept(IReusablesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<FileSystemPath> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.FileSystemPath;
    }

    public String getValue() {
        return wStringValue();
    }

    public void setValue(String value) {
        wSetValue(value);
    }
}
