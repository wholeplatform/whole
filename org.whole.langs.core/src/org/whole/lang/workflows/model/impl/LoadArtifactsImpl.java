/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.workflows.model.LoadArtifacts;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.workflows.model.Label;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.model.Variable;
import org.whole.lang.workflows.model.ResourceKind;
import org.whole.lang.workflows.model.Expression;
import org.whole.lang.workflows.model.ArtifactsTraversalStrategy;
import org.whole.lang.workflows.model.ArtifactsSynchronizeStrategy;

/**
 *  @generator Whole
 */
public class LoadArtifactsImpl extends AbstractSimpleEntity implements LoadArtifacts {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<LoadArtifacts> wGetEntityDescriptor() {
        return WorkflowsEntityDescriptorEnum.LoadArtifacts;
    }

    public int wGetEntityOrd() {
        return WorkflowsEntityDescriptorEnum.LoadArtifacts_ord;
    }

    public void accept(IWorkflowsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Label label;

    public Label getLabel() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.label, label);
    }

    public void setLabel(Label label) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.label, this.label, this.label = label);
    }
    private Variable model;

    public Variable getModel() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.model, model);
    }

    public void setModel(Variable model) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.model, this.model, this.model = model);
    }
    private ResourceKind rootResourceKind;

    public ResourceKind getRootResourceKind() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.rootResourceKind, rootResourceKind);
    }

    public void setRootResourceKind(ResourceKind rootResourceKind) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.rootResourceKind, this.rootResourceKind, this.rootResourceKind = rootResourceKind);
    }
    private Expression rootResource;

    public Expression getRootResource() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.rootResource, rootResource);
    }

    public void setRootResource(Expression rootResource) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.rootResource, this.rootResource, this.rootResource = rootResource);
    }
    private ArtifactsTraversalStrategy traversalStrategy;

    public ArtifactsTraversalStrategy getTraversalStrategy() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.traversalStrategy, traversalStrategy);
    }

    public void setTraversalStrategy(ArtifactsTraversalStrategy traversalStrategy) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.traversalStrategy, this.traversalStrategy, this.traversalStrategy = traversalStrategy);
    }
    private ArtifactsSynchronizeStrategy synchronizeStrategy;

    public ArtifactsSynchronizeStrategy getSynchronizeStrategy() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.synchronizeStrategy, synchronizeStrategy);
    }

    public void setSynchronizeStrategy(ArtifactsSynchronizeStrategy synchronizeStrategy) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.synchronizeStrategy, this.synchronizeStrategy, this.synchronizeStrategy = synchronizeStrategy);
    }
    private Expression defaultPersistence;

    public Expression getDefaultPersistence() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.defaultPersistence, defaultPersistence);
    }

    public void setDefaultPersistence(Expression defaultPersistence) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.defaultPersistence, this.defaultPersistence, this.defaultPersistence = defaultPersistence);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabel().wGetAdaptee(false);
            case 1 :
            return getModel().wGetAdaptee(false);
            case 2 :
            return getRootResourceKind().wGetAdaptee(false);
            case 3 :
            return getRootResource().wGetAdaptee(false);
            case 4 :
            return getTraversalStrategy().wGetAdaptee(false);
            case 5 :
            return getSynchronizeStrategy().wGetAdaptee(false);
            case 6 :
            return getDefaultPersistence().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLabel(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Label));
            break;
            case 1 :
            setModel(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Variable));
            break;
            case 2 :
            setRootResourceKind(value.wGetAdapter(WorkflowsEntityDescriptorEnum.ResourceKind));
            break;
            case 3 :
            setRootResource(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
            break;
            case 4 :
            setTraversalStrategy(value.wGetAdapter(WorkflowsEntityDescriptorEnum.ArtifactsTraversalStrategy));
            break;
            case 5 :
            setSynchronizeStrategy(value.wGetAdapter(WorkflowsEntityDescriptorEnum.ArtifactsSynchronizeStrategy));
            break;
            case 6 :
            setDefaultPersistence(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 7;
    }
}
