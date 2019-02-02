/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.matchers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.lifecycle.IHistoryManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.FreshNameGenerator;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.ITraversalFilter;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.TraverseAllFilter;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi
 */
public class Matcher {
	public static IEntity find(EntityKinds kind, IEntity model, boolean includeAdjacents) {
		GenericMatcherFactory mf = GenericMatcherFactory.instance;
		return find(mf.hasKindMatcher(kind), model, includeAdjacents);
	}
	@SuppressWarnings("unchecked")
	public static <E extends IEntity> E find(EntityDescriptor<E> descriptor, IEntity model, boolean includeAdjacents) {
		GenericMatcherFactory mf = GenericMatcherFactory.instance;
		return (E) find(mf.hasTypeMatcher(descriptor), model, includeAdjacents);
	}
	@SuppressWarnings("unchecked")
	public static <E extends IEntity> E find(E pattern, IEntity model, boolean includeAdjacents) {
		GenericMatcherFactory mf = GenericMatcherFactory.instance;
		return (E) find(mf.match(pattern), model, includeAdjacents);
	}
	@SuppressWarnings("unchecked")
	public static <E extends IEntity> E find(E pattern, IEntity model, IBindingManager bindings, boolean includeAdjacents) {
		GenericMatcherFactory mf = GenericMatcherFactory.instance;
		IVisitor mv = mf.matchInScope(pattern);
		mv.setBindings(bindings);
		return (E) find(mv, model, includeAdjacents);
	}
	public static IEntity find(IVisitor matcherVisitor, IEntity model, boolean includeAdjacents) {
		GenericTraversalFactory tf = GenericTraversalFactory.instance;
		Set<IEntity> c = new HashSet<IEntity>();
		try {
			tf.onceTopDown(tf.collect(matcherVisitor, c), includeAdjacents).visit(model);
		} catch (VisitException e) {
		}
		if (c.isEmpty())
			return null;
		else
			return c.iterator().next();
	}

	@SuppressWarnings("unchecked")
	public static <E extends IEntity> E findAncestor(EntityDescriptor<E> descriptor, IEntity model) {
		return (E) findAncestor(ExecutableFactory.instance.createHasType(descriptor.getURI()), model);
	}
	public static IEntity findAncestor(IExecutable predicate, IEntity model) {
		ExecutableFactory f = ExecutableFactory.instance;
		IExecutable i = f.createFilter(f.createAncestor(), predicate);
		i.reset(model);
		for (IEntity e : i)
			return e;
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <E extends IEntity> E findAncestorOrSelf(EntityDescriptor<E> descriptor, IEntity model) {
		return (E) findAncestorOrSelf(ExecutableFactory.instance.createHasType(descriptor.getURI()), model);
	}
	public static IEntity findAncestorOrSelf(IExecutable predicate, IEntity model) {
		ExecutableFactory f = ExecutableFactory.instance;
		IExecutable i = f.createFilter(f.createAncestorOrSelf(), predicate);
		i.reset(model);
		for (IEntity e : i)
			return e;
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <E extends IEntity> E findChild(EntityDescriptor<E> descriptor, IEntity model) {
		return (E) findChild(ExecutableFactory.instance.createHasType(descriptor.getURI()), model);
	}
	@SuppressWarnings("unchecked")
	public static <E extends IEntity> E findChild(E pattern, IEntity model) {
		ExecutableFactory f = ExecutableFactory.instance;
		return (E) findChild(f.createMatchInScope(f.createConstant(pattern, false)), model);
	}
	public static IEntity findChild(IExecutable predicate, IEntity model) {
		return findChild(predicate, model, BindingManagerFactory.instance.createBindingManager());
	}
	public static IEntity findChild(IExecutable predicate, IEntity model, IBindingManager bm) {
		ExecutableFactory f = ExecutableFactory.instance(bm);
		IExecutable i = f.createFilter(f.createChild(), predicate);
		i.setBindings(bm);
		i.reset(model);
		for (IEntity e : i)
			return e;
		return null;
	}

	public static <E extends IEntity> Collection<E> findAll(EntityDescriptor<E> descriptor, IEntity model, boolean includeAdjacents) {
		GenericMatcherFactory mf = GenericMatcherFactory.instance;
		return findAll(mf.hasTypeMatcher(descriptor), model, new HashSet<E>(), includeAdjacents);
	}
	public static  <E extends IEntity> Collection<E> findAll(IEntity pattern, IEntity model, boolean includeAdjacents) {
		GenericMatcherFactory mf = GenericMatcherFactory.instance;
		return findAll(mf.match(pattern), model, new HashSet<E>(), includeAdjacents);
	}
	public static <E extends IEntity> Collection<E> findAll(IVisitor matcherVisitor, IEntity model, Collection<E> result, boolean includeAdjacents) {
		GenericTraversalFactory tf = GenericTraversalFactory.instance;
		tf.topDownUntil(tf.collect(matcherVisitor, result), includeAdjacents).visit(model);
		return result;
	}

	public static int indexOf(IEntity pattern, IEntity model) {
		GenericMatcherFactory mf = GenericMatcherFactory.instance;
		return indexOf(mf.match(pattern), model);
	}
	public static int indexOf(IVisitor matcherVisitor, IEntity model) {
		GenericTraversalFactory tf = GenericTraversalFactory.instance;
		try {
			Set<IEntity> c = new HashSet<IEntity>();
			tf.traverseOne(tf.collect(matcherVisitor, c), true).visit(model);
			return model.wIndexOf(c.iterator().next());
		} catch (VisitException e) {
			return -1;
		}
	}

	public static boolean match(EntityKinds kind, IEntity model) {
		return model.wGetEntityKind().equals(kind);
	}
	public static boolean match(EntityKinds kind, IEntity model, IBindingScope bindings, String name) {
		if (match(kind, model)) {
			bindings.wDef(name, model);
			return true;
		}
		return false;
	}

	public static boolean matchAny(IEntity model, EntityDescriptor<?>... descriptors) {
		EntityDescriptor<?> ed = model.wGetEntityDescriptor();
		for (EntityDescriptor<?> descriptor : descriptors) {
			if (ed.equals(descriptor))
				return true;
		}
		return false;
	}
	public static boolean matchAnyImpl(IEntity model, EntityDescriptor<?>... descriptors) {
		return matchAny(model.wGetAdaptee(true), descriptors);
	}

	public static boolean matchImpl(EntityDescriptor<?> descriptor, IEntity model) {
		return match(descriptor, model.wGetAdaptee(true));
	}

	public static boolean matchAtFeature(FeatureDescriptor fd, IEntity model) {
		return EntityUtils.hasParent(model) && fd.equals(model.wGetParent().wGetFeatureDescriptor(model));
	}
	public static boolean matchAtEntityFeature(FeatureDescriptor efd, IEntity model) {
		return matchAtEntityFeature(efd.getParentEntityDescriptor(), efd, model);
	}
	public static boolean matchAtEntityFeature(EntityDescriptor<?> ed, FeatureDescriptor fd, IEntity model) {
		IEntity parent = model.wGetParent();
		return !EntityUtils.isNull(parent) && isAssignableAsIsFrom(ed, parent) && fd.equals(parent.wGetFeatureDescriptor(model));
	}

	public static boolean isAssignableAsIsFrom(EntityDescriptor<?> descriptor, IEntity model) {
		return descriptor.isLanguageSupertypeOf(model.wGetEntityDescriptor());
	}
	public static boolean isAssignableFrom(EntityDescriptor<?> descriptor, IEntity model) {
		return descriptor.isPlatformSupertypeOf(model.wGetEntityDescriptor());
	}

	public static boolean match(EntityDescriptor<?> descriptor, IEntity model) {
		return model.wGetEntityDescriptor().equals(descriptor);
	}
	public static boolean matchImplAndBind(EntityDescriptor<?> descriptor, IEntity model, IBindingScope bindings, String name) {
		if (matchImpl(descriptor, model)) {
			bindings.wDef(name, model);
			return true;
		}
		return false;
	}

	public static boolean forceMatch(IEntity pattern, IEntity model) {
		return forceMatch(pattern, model, TraverseAllFilter.instance);
	}
	public static boolean forceMatch(IEntity pattern, IEntity model, ITraversalFilter traversalFilter) {
		try {
			new GenericMatcher()
			.withAsIsMatching()
			.withTraversalFilter(traversalFilter)
			.withMismatchStrategy(IMatchStrategy.ReplaceWithResolver)
			.match(pattern, model);
			return true;
		} catch (MatchException|VisitException e) {
			return false;
		}
	}
	public static boolean forceMatchUsingVariables(IEntity pattern, IEntity model) {
		try {
			GenericMatcher gm = new GenericMatcher();

			final Set<String> boundNames = new HashSet<String>();
			gm.withMatchStrategy(IMatchStrategy.CollectVariableNames(boundNames),
					CommonsEntityDescriptorEnum.Variable, CommonsEntityDescriptorEnum.InlineVariable)
			.withMismatchStrategy(IMatchStrategy.IgnoreSubtree)
			.match(model, pattern);

			final FreshNameGenerator fng = new FreshNameGenerator(boundNames);
			gm.withAsIsMatching()
			.withMismatchStrategy(IMatchStrategy.ReplaceWithVariable(fng))
			.match(pattern, model);
			return true;
		} catch (MatchException|VisitException e) {
			return false;
		}
	}
	public static boolean match(IEntity pattern, IEntity model) {
		return match(pattern, model, TraverseAllFilter.instance);
	}
	public static boolean match(IEntity pattern, IEntity model, ITraversalFilter traversalFilter) {
		try {
			new GenericMatcher().withTraversalFilter(traversalFilter).match(pattern, model);
			return true;
		} catch (MatchException|VisitException e) {
			return false;
		}
	}
	public static boolean match(IEntity pattern, IEntity model, IBindingManager bindings) {
		return match(pattern, model, new GenericMatcher().withBindings(bindings));
	}
	public static boolean match(IEntity pattern, IEntity model, GenericMatcher matcher) {
		boolean mergeScope = true;
		try {
			matcher.getBindings().wEnterScope();
			matcher.match(pattern, model);
		} catch (MatchException|VisitException e) {
			mergeScope = false;
		} finally {
			matcher.getBindings().wExitScope(mergeScope);
		}
		return mergeScope;
	}

	public static boolean match(IVisitor matcherVisitor, IEntity model) {
		try {
			matcherVisitor.visit(model);
			return true;
		} catch (MatchException|VisitException e) {
			return false;
		}
	}

	public static IEntity merge(IEntity mergingModel, IEntity model) {
		IHistoryManager hm = ReflectionFactory.getHistoryManager(model);

		hm.begin();
		try {
			new GenericMatcher()
			.withAsIsMatching()
			.withMismatchStrategy(IMatchStrategy.ReplaceWithClone)
			.match(mergingModel, model);

			hm.commit();
		} catch (MatchException e) {
			hm.rollbackIfNeeded();

			if (e.model == model && e.pattern == mergingModel)
				return mergingModel;

			throw e;
		} catch (RuntimeException e) {
			hm.rollbackIfNeeded();
			throw e;
		}
		
		return model;
	}

	public static void rename(IEntity pattern, final Map<String, String> nameMap, boolean includeAdjacents) {
	    GenericTraversalFactory.instance.topDown(
	    		GenericMatcherFactory.instance.rename(nameMap), includeAdjacents).visit(pattern);
	}
	public static void rename(IEntity pattern, final String oldName, final String newName, boolean includeAdjacents) {
	    GenericTraversalFactory.instance.topDown(
	    		GenericMatcherFactory.instance.rename(oldName, newName), includeAdjacents).visit(pattern);
	}
	public static void substitute(IEntity pattern, final IBindingScope bindings, boolean includeAdjacents) {
	    GenericTraversalFactory.instance.topDown(
	    		GenericMatcherFactory.instance.substitute(bindings), includeAdjacents).visit(pattern);
	}
	public static void substitute(IEntity pattern, final IBindingScope inBindings, final IBindingScope outBindings, boolean includeAdjacents) {
	    GenericTraversalFactory.instance.topDown(
	    		GenericMatcherFactory.instance.substitute(inBindings, outBindings), includeAdjacents).visit(pattern);
	}

	public static boolean removeVars(IEntity pattern, boolean force) {
		boolean allVarsAreOptional = true;

		ExecutableFactory f = ExecutableFactory.instance;
		IExecutable variableExecutable = f.createFilter(f.createDescendantOrSelf(), f.createIsVariable());
		variableExecutable.reset(pattern);
		for (IEntity variableAdapter : variableExecutable) {
			Variable variable = (Variable) variableAdapter.wGetAdaptee(false);
			
			boolean isOptional = variable.getQuantifier().getValue().isOptional();
			allVarsAreOptional &= isOptional;
			
			if (force || isOptional)
				variableExecutable.remove();
		}
		
		return allVarsAreOptional;
	}
	public static boolean removeVars(IEntity pattern, final Set<String> names, boolean useNamesComplement) {
		if (names.isEmpty() && !useNamesComplement)
			return true;

		boolean allVarsAreOptional = true;

		ExecutableFactory f = ExecutableFactory.instance;
		IExecutable variableExecutable = f.createFilter(f.createDescendantOrSelf(), f.createIsVariable());
		variableExecutable.reset(pattern);
		for (IEntity variableAdapter : variableExecutable) {
			Variable variable = (Variable) variableAdapter.wGetAdaptee(false);
			if (names.contains(variable.getVarName().getValue()) ^ useNamesComplement) {
				boolean isOptional = variable.getQuantifier().getValue().isOptional();
				allVarsAreOptional &= isOptional;

				if (isOptional)
					variableExecutable.remove();
			}
		}
		return allVarsAreOptional;
	}
	public static Set<String> vars(IEntity pattern, boolean includeOptionals) {
		Set<String> names = new HashSet<String>();

		ExecutableFactory f = ExecutableFactory.instance;
		IExecutable variableExecutable = f.createFilter(f.createDescendantOrSelf(), f.createIsVariable());
		variableExecutable.reset(pattern);
		for (IEntity variableAdapter : variableExecutable) {
			Variable variable = (Variable) variableAdapter.wGetAdaptee(false);
			if (includeOptionals || !variable.getQuantifier().getValue().isOptional())
				names.add(variable.getVarName().getValue());
		}
		return names;
	}
}
