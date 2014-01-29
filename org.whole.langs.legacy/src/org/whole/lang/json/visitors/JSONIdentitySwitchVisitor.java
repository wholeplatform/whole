package org.whole.lang.json.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.json.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.model.String;

/**
 *  @generator  Whole
 */
public abstract class JSONIdentitySwitchVisitor extends AbstractVisitor implements IJSONVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case JSONEntityDescriptorEnum.Object_ord :
            visit((Object) entity);
            break;
            case JSONEntityDescriptorEnum.Pair_ord :
            visit((Pair) entity);
            break;
            case JSONEntityDescriptorEnum.Name_ord :
            visit((Name) entity);
            break;
            case JSONEntityDescriptorEnum.Array_ord :
            visit((Array) entity);
            break;
            case JSONEntityDescriptorEnum.String_ord :
            visit((String) entity);
            break;
            case JSONEntityDescriptorEnum.Decimal_ord :
            visit((Decimal) entity);
            break;
            case JSONEntityDescriptorEnum.Int_ord :
            visit((Int) entity);
            break;
            case JSONEntityDescriptorEnum.Bool_ord :
            visit((Bool) entity);
            break;
            case JSONEntityDescriptorEnum.Null_ord :
            visit((Null) entity);
            break;
        }
    }
}
