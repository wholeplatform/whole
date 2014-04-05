package org.whole.lang.reusables.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.reusables.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public abstract class ReusablesIdentitySwitchVisitor extends AbstractVisitor implements IReusablesVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case ReusablesEntityDescriptorEnum.Adapt_ord :
            visit((Adapt) entity);
            break;
            case ReusablesEntityDescriptorEnum.Reuse_ord :
            visit((Reuse) entity);
            break;
            case ReusablesEntityDescriptorEnum.Include_ord :
            visit((Include) entity);
            break;
            case ReusablesEntityDescriptorEnum.Reusables_ord :
            visit((Reusables) entity);
            break;
            case ReusablesEntityDescriptorEnum.Resource_ord :
            visit((Resource) entity);
            break;
            case ReusablesEntityDescriptorEnum.Registry_ord :
            visit((Registry) entity);
            break;
            case ReusablesEntityDescriptorEnum.WorkspacePath_ord :
            visit((WorkspacePath) entity);
            break;
            case ReusablesEntityDescriptorEnum.FileSystemPath_ord :
            visit((FileSystemPath) entity);
            break;
            case ReusablesEntityDescriptorEnum.ClassPathURI_ord :
            visit((ClassPathURI) entity);
            break;
            case ReusablesEntityDescriptorEnum.URI_ord :
            visit((URI) entity);
            break;
            case ReusablesEntityDescriptorEnum.Persistence_ord :
            visit((Persistence) entity);
            break;
        }
    }
}
