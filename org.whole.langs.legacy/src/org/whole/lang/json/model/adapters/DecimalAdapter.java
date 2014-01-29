package org.whole.lang.json.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.json.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class DecimalAdapter extends AbstractEntityAdapter implements Decimal {
    private static final long serialVersionUID = 1;

    public DecimalAdapter(IEntity implementor) {
        super(implementor);
    }

    public DecimalAdapter() {
    }

    public void accept(IJSONVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Decimal> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Decimal;
    }

    public double getValue() {
        return wDoubleValue();
    }

    public void setValue(double value) {
        wSetValue(value);
    }
}
