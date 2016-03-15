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
package org.whole.lang.templates;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.visitors.AbstractVisitor;


/**
 * @author Riccardo Solmi
 */
public class ModelTemplate extends AbstractVisitor implements ITemplate {
	protected IEntity model;
	protected IBuilder builder;
//	protected Map<IEntity, String> map = new HashMap<IEntity, String>(1024);
//	protected static final String NOT_REFERENCED = "";

	public ModelTemplate(IEntity model) {
		this.model = model;
	}
	public ModelTemplate(IBuilder builder) {
		this.builder = builder;
	}
	public ModelTemplate(IBuilderOperation operation) {
		this(operation.wGetBuilder());
	}

	public void apply(IBuilderOperation operation) {
		apply(operation.wGetBuilder());
	}
	public void apply(IBuilder builder) {
		this.builder = builder;
		visit(model);
	}

	public void visit(IEntity entity) {
		if (entity.wIsAdapter())
			entity = entity.wGetAdaptee(false);

//		//TODO add is reference case
//		String uri = map.get(entity);
//		if (uri == null)
//			map.put(entity, NOT_REFERENCED);
//		else if (uri == NOT_REFERENCED) {
//			uri = EntityUtils.getLocation(entity);
//			map.put(entity, uri);
//			builder.wEntity(CommonsEntityDescriptorEnum.REFERENCE, uri);
//		}

//		if (entity.wIsAdapter())
//			visit(entity.wGetAdaptee());
//		else 
		{
			EntityKinds entityKind = entity.wGetEntityKind();
			EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
			if (entityKind.isData()) {
				switch (ed.getDataKind()) {
				case BOOLEAN:
					builder.wEntity(ed, entity.wBooleanValue());
					break;
				case BYTE:
					builder.wEntity(ed, entity.wByteValue());
					break;
				case CHAR:
					builder.wEntity(ed, entity.wCharValue());
					break;
				case DOUBLE:
					builder.wEntity(ed, entity.wDoubleValue());
					break;
				case FLOAT:
					builder.wEntity(ed, entity.wFloatValue());
					break;
				case INT:
					builder.wEntity(ed, entity.wIntValue());
					break;
				case LONG:
					builder.wEntity(ed, entity.wLongValue());
					break;
				case SHORT:
					builder.wEntity(ed, entity.wShortValue());
					break;
				case STRING:
					builder.wEntity(ed, entity.wStringValue());
					break;
				case DATE:
					builder.wEntity(ed, entity.wDateValue());
					break;
				case ENUM_VALUE:
					builder.wEntity(ed, entity.wEnumValue());
					break;
				case OBJECT:
					builder.wEntity(ed, entity.wGetValue());
					break;
				}
			} else {
				int size = entity.wSize();
				if (entityKind.isComposite())
					builder.wEntity_(ed, size);
				else {// isSimple()
					if (entity.wIsEmpty()) {
						builder.wEntity(ed);
						return;
					}
					builder.wEntity_(ed);
				}

				for (int i=0; i<size; i++)
					visit(entity.wGet(i));
				builder._wEntity(ed);
			}
		}
	}
}
