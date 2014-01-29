package org.whole.lang.json.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.json.reflect.JSONFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class JSONModelContext extends EntityContext {

    public JSONModelContext(IEntity root) {
        super(root);
    }

    public JSONModelContext getName() {
        return (JSONModelContext) wGet(JSONFeatureDescriptorEnum.name);
    }

    public void setName(JSONModelContext name) {
        wSet(JSONFeatureDescriptorEnum.name, name);
    }

    public JSONModelContext getValue() {
        return (JSONModelContext) wGet(JSONFeatureDescriptorEnum.value);
    }

    public void setValue(JSONModelContext value) {
        wSet(JSONFeatureDescriptorEnum.value, value);
    }
}
