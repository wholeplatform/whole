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
package org.whole.lang.visitors;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.resources.CompoundResourceRegistry;

/**
 * @author Riccardo Solmi
 */
public class DynamicGeneratorVisitor extends AbstractDynamicVisitor {
	public DynamicGeneratorVisitor(CompoundResourceRegistry<?> registry, String functionUri) {
		super(registry, functionUri);
	}

	public static IVisitorFactory createVisitorFactory(final CompoundResourceRegistry<?> registry, final String functionUri) {
		return new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new DynamicGeneratorVisitor(registry, functionUri);
			}
		};
	}

	@Override
	protected void apply(IEntityIterator<?> iterator) {
		if (iterator.hasNext()) {
			IEntity result = iterator.next();

			//TODO workaround for old style artifact generator actions
			if ("http://lang.whole.org/Artifacts".equals(result.wGetLanguageKit().getURI())) {
				EntityDescriptor<?> resultEd = result.wGetEntityDescriptor();
				if (!"http://lang.whole.org/Artifacts#Workspace".equals(resultEd.getURI()))
					throw new IllegalArgumentException();

				//see ArtifactsUtils.moveArtifactsIntoWorkspace();
				IEntity projectsPoint = getBindings().wGet("projectsPoint");
				if (projectsPoint == null)
					throw new IllegalArgumentException("projectsPoint is undefined");

				IEntityIterator<IEntity> projectIterator = IteratorFactory.childIterator();
				projectIterator.reset(result.wGet(resultEd.getFeatureDescriptorEnum().valueOf("projects")));
				for (IEntity project : projectIterator) {
					projectIterator.remove();
					projectsPoint.wAdd(project);
				}
			}
		}
	}
}
