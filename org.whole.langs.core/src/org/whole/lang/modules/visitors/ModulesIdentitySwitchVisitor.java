package org.whole.lang.modules.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.modules.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.modules.reflect.ModulesEntityDescriptorEnum;

/**
 *  @generator  Whole
 */
public abstract class ModulesIdentitySwitchVisitor extends AbstractVisitor implements IModulesVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case ModulesEntityDescriptorEnum.Module_ord :
            visit((Module) entity);
            break;
            case ModulesEntityDescriptorEnum.Include_ord :
            visit((Include) entity);
            break;
            case ModulesEntityDescriptorEnum.Reuse_ord :
            visit((Reuse) entity);
            break;
            case ModulesEntityDescriptorEnum.Resource_ord :
            visit((Resource) entity);
            break;
            case ModulesEntityDescriptorEnum.WorkspacePath_ord :
            visit((WorkspacePath) entity);
            break;
            case ModulesEntityDescriptorEnum.FileSystemPath_ord :
            visit((FileSystemPath) entity);
            break;
            case ModulesEntityDescriptorEnum.ClassPathURI_ord :
            visit((ClassPathURI) entity);
            break;
            case ModulesEntityDescriptorEnum.URI_ord :
            visit((URI) entity);
            break;
            case ModulesEntityDescriptorEnum.Persistence_ord :
            visit((Persistence) entity);
            break;
            case ModulesEntityDescriptorEnum.Registry_ord :
            visit((Registry) entity);
            break;
        }
    }
}
