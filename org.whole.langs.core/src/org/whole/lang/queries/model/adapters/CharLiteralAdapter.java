package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public class CharLiteralAdapter extends AbstractEntityAdapter implements CharLiteral {
    private static final long serialVersionUID = 1;

    public CharLiteralAdapter(IEntity implementor) {
        super(implementor);
    }

    public CharLiteralAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<CharLiteral> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.CharLiteral;
    }

    public char getValue() {
        return wCharValue();
    }

    public void setValue(char value) {
        wSetValue(value);
    }
}
