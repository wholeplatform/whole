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
package org.whole.lang.models.visitors;

import org.whole.lang.model.IEntity;
import org.whole.lang.models.model.CompositeEntity;
import org.whole.lang.models.model.DataEntity;
import org.whole.lang.models.model.EnumEntity;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.MapEntity;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.operations.MetaModelMapperOperation;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public class MetaModelMapperVisitor extends ModelsIdentityVisitor {
	private IEntity currentEntity;
	private boolean isEntityName;

	public static IVisitor create(MetaModelMapperOperation operation) {
		return ModelsTraversalFactory.instance.topDownWhile(new MetaModelMapperVisitor(operation), false);
	}

	protected MetaModelMapperVisitor(MetaModelMapperOperation operation) {
		setOperation(operation);
	}

	public MetaModelMapperOperation getOperation() {
		return (MetaModelMapperOperation) super.getOperation();
	}
	protected String getMetaEntityName() {
		return getOperation().getMetaEntityName();
	}
	protected String getMetaFeatureName() {
		return getOperation().getMetaFeatureName();
	}
	protected void setMetaEntity(IEntity result) {
		getOperation().setResult(result);
	}


	public void visit(SimpleEntity entity) {
		currentEntity = entity;
		isEntityName = true;
	}

	public void visit(CompositeEntity entity) {
		currentEntity = entity;
		isEntityName = true;
	}

	public void visit(MapEntity entity) {
		currentEntity = entity;
		isEntityName = true;
	}

	public void visit(DataEntity entity) {
		currentEntity = entity;
		isEntityName = true;
	}

	public void visit(EnumEntity entity) {
		currentEntity = entity;
		isEntityName = true;
	}

	public void visit(Feature entity) {
		currentEntity = entity;
		isEntityName = false;
	}

	public void visit(SimpleName entity) {
		String name = entity.getValue();
		if ((isEntityName && name.equals(getMetaEntityName()) ||
				(!isEntityName && name.equals(getMetaFeatureName())))) {
			setMetaEntity(currentEntity);
		}
	}
}
