/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.operations;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Riccardo Solmi
 */
public class MetaModelMapperOperation extends AbstractOperation {
	public static final String ID = "model2MetaModelMapper";

	public static IEntity getMetaEntity(IEntity entity) {
		return getMetaEntity(entity.wGetEntityDescriptor());
	}
	public static IEntity getMetaEntity(EntityDescriptor<?> entityDescriptor) {
		String entityName = entityDescriptor.getName();
		IEntity metaModel = entityDescriptor.getLanguageKit().getMetaModel();

		IBindingManager args = BindingManagerFactory.instance.createArguments();
		MetaModelMapperOperation op = new MetaModelMapperOperation(args);
		op.setMetaEntityName(entityName);
		op.stagedVisit(metaModel);
		return op.getResult();
	}
	public static IEntity getMetaEntity(IEntity entity, FeatureDescriptor featureDescriptor) {
		String entityName = entity.wGetEntityDescriptor().getName();
		IEntity metaModel = ReflectionFactory.getMetaModel(entity);
		String featureName = featureDescriptor.getName();

		IBindingManager args = BindingManagerFactory.instance.createArguments();
		MetaModelMapperOperation op = new MetaModelMapperOperation(args);
		op.setMetaEntityName(entityName);
		op.setMetaFeatureName(featureName);
		op.stagedVisit(metaModel);
		return op.getResult();
	}

	protected MetaModelMapperOperation(IBindingManager args) {
		super(ID, args, false);
	}

	private String metaEntityName;
	public String getMetaEntityName() {
		return metaEntityName;
	}
	public void setMetaEntityName(String metaEntityName) {
		this.metaEntityName = metaEntityName;
	}

	private String metaFeatureName;
	public String getMetaFeatureName() {
		return metaFeatureName;
	}
	public void setMetaFeatureName(String metaFeatureName) {
		this.metaFeatureName = metaFeatureName;
	}

	private IEntity result;
	public IEntity getResult() {
		return result;
	}
	public void setResult(IEntity result) {
		this.result = result;
	}
}
