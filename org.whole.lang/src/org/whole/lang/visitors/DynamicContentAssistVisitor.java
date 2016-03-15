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

import java.util.ArrayList;
import java.util.List;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.resources.CompoundResourceRegistry;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class DynamicContentAssistVisitor extends AbstractDynamicVisitor {
	public DynamicContentAssistVisitor(CompoundResourceRegistry<?> registry, String functionUri) {
		super(registry, functionUri);
	}

	public static IVisitorFactory createVisitorFactory(final CompoundResourceRegistry<?> registry, final String functionUri) {
		return new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new DynamicContentAssistVisitor(registry, functionUri);
			}
		};
	}

	@Override
	public void visit(IEntity entity) {
		IBindingManager bm = getBindings();
		bm.wDef("selectedEntities", BindingManagerFactory.instance.createTuple(entity));
		bm.wDef("primarySelectedEntity", entity);
		bm.wDef("focusEntity", entity);
		super.visit(EntityUtils.getCompoundRoot(entity));
	}

	@Override
	protected void apply(IEntityIterator<?> iterator) {
		List<IEntity> values = new ArrayList<IEntity>();
		while (iterator.hasNext())
			values.add(iterator.next());

		((ContentAssistOperation) super.getOperation())
				.setResult(values.toArray(new IEntity[values.size()]));
	}
}
