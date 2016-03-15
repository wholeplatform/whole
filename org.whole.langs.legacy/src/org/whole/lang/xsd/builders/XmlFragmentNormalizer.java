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
/**
 * 
 */
package org.whole.lang.xsd.builders;

import static org.whole.lang.xml.reflect.XmlEntityDescriptorEnum.NameSpace;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.xml.visitors.XmlTraverseAllVisitor;
import org.whole.lang.xsd.builders.utils.AttributesMatcherFactory;
import org.whole.lang.xsd.util.NamespaceUtils;

/**
 * @author Enrico Persiani
 */
final class XmlFragmentNormalizer extends XmlTraverseAllVisitor {
	private boolean calculateNeededNamespaces;
	private Set<String> neededNamespaces;
	private IBindingManager ns = BindingManagerFactory.instance.createBindingManager();

	public XmlFragmentNormalizer() {
		this(false);
	}
	public XmlFragmentNormalizer(boolean calculateNeededNamespaces) {
		this.calculateNeededNamespaces = calculateNeededNamespaces;
		this.neededNamespaces = calculateNeededNamespaces ? new HashSet<String>() : Collections.<String>emptySet();
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		if (calculateNeededNamespaces && Matcher.match(NameSpace, entity))
			updateNeededNamespaces(NamespaceUtils.DEFAULT_NAMESPACE_PREFIX);
		return super.visitAdapter(entity);
	}

	public void visit(org.whole.lang.xml.model.Element entity) {
		if (calculateNeededNamespaces) {
			ns.wEnterScope();
			IEntityIterator<IEntity> iterator = IteratorFactory.childMatcherIterator()
					.withPattern(AttributesMatcherFactory.matchNamespaceDeclaration(ns));
			iterator.reset(entity.getAttributes());
			while (iterator.hasNext()) {
				iterator.next();
				String uri = ns.wStringValue("uri");
				if (ns.wIsSet("xmlns"))
					ns.wDefValue(ns.wStringValue("xmlns"), uri);
				else
					NamespaceUtils.redefineDefaultNamespace(ns, uri);
			}
			super.visit(entity);
			ns.wExitScope();
		} else
			super.visit(entity);
	}

	public void visit(org.whole.lang.xml.model.CharData entity) {
		if (entity.getValue().length() == 0)
			entity.wGetParent().wRemove(entity);
	}

	public void visit(org.whole.lang.xml.model.NameSpace entity) {
		if (calculateNeededNamespaces) { 
			String prefix = DataTypeUtils.getAsPersistenceString(entity);
			if (!"xmlns".equals(prefix))
				updateNeededNamespaces(prefix);
		}
	}

	private void updateNeededNamespaces(String prefix) {
		if (!ns.wIsSet(prefix))
			neededNamespaces.add(prefix);
	}
	public Set<String> getNeededNamespaces() {
		return neededNamespaces;
	}
}