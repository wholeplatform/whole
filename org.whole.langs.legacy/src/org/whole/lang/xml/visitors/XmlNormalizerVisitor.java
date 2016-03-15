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
package org.whole.lang.xml.visitors;

import static org.whole.lang.xml.reflect.XmlEntityDescriptorEnum.Content;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xml.factories.XmlEntityFactory;
import org.whole.lang.xml.model.CDataSect;
import org.whole.lang.xml.model.Content;
import org.whole.lang.xml.model.Element;
import org.whole.lang.xml.model.IContent;
import org.whole.lang.xml.model.IXmlEntity;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.util.XmlUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class XmlNormalizerVisitor extends XmlTraverseAllVisitor {
	@Override
	public void visit(CDataSect entity) {
		// pack children
		if (entity.wSize() > 1) {
			IEntityIterator<IEntity> i = IteratorFactory.childIterator();
			i.reset(entity);
			IEntity first = i.next();
			StringBuilder sb = getStringBuilder().append(first.wStringValue());
			while (i.hasNext()) {
				sb.append(i.next().wStringValue());
				i.remove();
			}
			first.wSetValue(sb.toString());
		}

		IEntity parent = entity.wGetParent();
		if (!EntityUtils.isNull(parent) && 
				getBindings().wIsSet("mergeCDataSect") && getBindings().wBooleanValue("mergeCDataSect"))
			parent.wSet(entity, XmlEntityFactory.instance.createCharData(entity.wGet(0).wStringValue()));
	}

	@Override
	public void visit(Content entity) {
		// recursively normalize nested composite entities
		IEntityIterator<IEntity> iterator = IteratorFactory.childMatcherIterator().withPattern(EntityKinds.COMPOSITE);
		iterator.reset(entity);
		while (iterator.hasNext()) {
			IEntity composite = iterator.next();
			((IXmlEntity) composite).accept(this);

			// move Content's children in place of Content entity
			if (Matcher.match(Content, composite)) {
				for (int i=composite.wSize()-1; i>=0; i--) {
					IEntity child = composite.wGet(i);
					composite.wRemove(i);
					iterator.add(child);
				}
				iterator.remove();
			}
		}

		for (int i = 0; i < entity.wSize(); i++) {
			IContent child = (IContent) entity.wGet(i);
			if (Matcher.matchImpl(XmlEntityDescriptorEnum.CharData, child)) {
				IEntity nextChild;
				if (i+1 < entity.wSize() && Matcher.matchImpl(XmlEntityDescriptorEnum.CharData, nextChild = entity.wGet(i+1))) {
					StringBuilder sb = getStringBuilder();
					sb.append(child.wStringValue());
					do {
						sb.append(nextChild.wStringValue());
						entity.wRemove(i+1);
					} while (i+1 < entity.wSize() && Matcher.matchImpl(XmlEntityDescriptorEnum.CharData, nextChild = entity.wGet(i+1)));
					child.wSetValue(sb.toString());
				}
				if (XmlUtils.isIgnorableWhitespace(child.wStringValue()))
					entity.wRemove(i--);
			}
			child.accept(this);
		}
	}
	@Override
	public void visit(Element entity) {
		IContent content = entity.getContent();
		if (!EntityUtils.isResolver(content) && !Matcher.match(Content, content)) {
			entity.wRemove(content);
			entity.setContent(XmlEntityFactory.instance.createContent(content));
		}
		super.visit(entity);
	}

	private StringBuilder charDataBuilder;
	protected StringBuilder getStringBuilder() {
		if (charDataBuilder == null)
			charDataBuilder = new StringBuilder(2048);
		else
			charDataBuilder.setLength(0);
		return charDataBuilder;
	}
}
