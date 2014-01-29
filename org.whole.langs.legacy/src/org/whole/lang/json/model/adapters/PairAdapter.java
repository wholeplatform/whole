package org.whole.lang.json.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.json.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.json.reflect.JSONFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class PairAdapter extends AbstractEntityAdapter implements Pair {
    private static final long serialVersionUID = 1;

    public PairAdapter(IEntity implementor) {
        super(implementor);
    }

    public PairAdapter() {
    }

    public void accept(IJSONVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Pair> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Pair;
    }

    public Name getName() {
        return wGet(JSONFeatureDescriptorEnum.name).wGetAdapter(JSONEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(JSONFeatureDescriptorEnum.name, name);
    }

    public Value getValue() {
        return wGet(JSONFeatureDescriptorEnum.value).wGetAdapter(JSONEntityDescriptorEnum.Value);
    }

    public void setValue(Value value) {
        wSet(JSONFeatureDescriptorEnum.value, value);
    }
}
