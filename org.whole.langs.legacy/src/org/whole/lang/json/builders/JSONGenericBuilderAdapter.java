package org.whole.lang.json.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.json.reflect.JSONFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class JSONGenericBuilderAdapter extends GenericIdentityBuilder {
    private IJSONBuilder specificBuilder;

    public JSONGenericBuilderAdapter(IJSONBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public JSONGenericBuilderAdapter(IJSONBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case JSONEntityDescriptorEnum.Object_ord :
            specificBuilder.Object();
            break;
            case JSONEntityDescriptorEnum.Pair_ord :
            specificBuilder.Pair();
            break;
            case JSONEntityDescriptorEnum.Array_ord :
            specificBuilder.Array();
            break;
            case JSONEntityDescriptorEnum.Null_ord :
            specificBuilder.Null();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case JSONEntityDescriptorEnum.Object_ord :
            specificBuilder.Object_();
            break;
            case JSONEntityDescriptorEnum.Pair_ord :
            specificBuilder.Pair_();
            break;
            case JSONEntityDescriptorEnum.Array_ord :
            specificBuilder.Array_();
            break;
            case JSONEntityDescriptorEnum.Null_ord :
            specificBuilder.Null_();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case JSONEntityDescriptorEnum.Object_ord :
            specificBuilder.Object_(initialCapacity);
            break;
            case JSONEntityDescriptorEnum.Array_ord :
            specificBuilder.Array_(initialCapacity);
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case JSONEntityDescriptorEnum.Object_ord :
            specificBuilder._Object();
            break;
            case JSONEntityDescriptorEnum.Pair_ord :
            specificBuilder._Pair();
            break;
            case JSONEntityDescriptorEnum.Array_ord :
            specificBuilder._Array();
            break;
            case JSONEntityDescriptorEnum.Null_ord :
            specificBuilder._Null();
            break;
        }
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case JSONFeatureDescriptorEnum.name_ord :
            specificBuilder.name();
            break;
            case JSONFeatureDescriptorEnum.value_ord :
            specificBuilder.value();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case JSONEntityDescriptorEnum.Name_ord :
            specificBuilder.Name(value);
            break;
            case JSONEntityDescriptorEnum.String_ord :
            specificBuilder.String(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, double value) {
        switch (entityDesc.getOrdinal()) {
            case JSONEntityDescriptorEnum.Decimal_ord :
            specificBuilder.Decimal(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, long value) {
        switch (entityDesc.getOrdinal()) {
            case JSONEntityDescriptorEnum.Int_ord :
            specificBuilder.Int(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
        switch (entityDesc.getOrdinal()) {
            case JSONEntityDescriptorEnum.Bool_ord :
            specificBuilder.Bool(value);
            break;
        }
    }
}
