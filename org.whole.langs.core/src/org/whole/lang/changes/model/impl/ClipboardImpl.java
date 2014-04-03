package org.whole.lang.changes.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.changes.model.*;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.changes.reflect.ChangesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator  Whole
 */
public class ClipboardImpl extends AbstractDataEntity implements Clipboard {
    private static final long serialVersionUID = 1;
    private int value;

    public int getValue() {
        return notifyRequested(value);
    }

    public void setValue(int value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IChangesVisitor visitor) {
        visitor.visit(this);
    }

    public int wGetEntityOrd() {
        return ChangesEntityDescriptorEnum.Clipboard_ord;
    }

    public EntityDescriptor<Clipboard> wGetEntityDescriptor() {
        return ChangesEntityDescriptorEnum.Clipboard;
    }

    public Object wGetValue() {
        return new Integer(getValue());
    }

    public void wSetValue(Object value) {
        setValue(((Integer) value).intValue());
    }

    public String wStringValue() {
        return toString();
    }

    public void wSetValue(String value) {
        try {
            setValue(Integer.valueOf(value).intValue());
        } catch (NumberFormatException e) {
        }
    }

    public int wIntValue() {
        return getValue();
    }

    public void wSetValue(int value) {
        setValue(value);
    }
}
