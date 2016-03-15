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
package org.whole.lang.semantics.util;

import java.util.List;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.IEntityFactory;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.FunctionLibraryRegistry;
import org.whole.lang.semantics.factories.SemanticsEntityFactory;
import org.whole.lang.semantics.model.EntityType;
import org.whole.lang.semantics.model.LocalIdentifier;
import org.whole.lang.semantics.model.Name;
import org.whole.lang.semantics.model.SemanticFunction;
import org.whole.lang.semantics.model.SemanticFunctions;
import org.whole.lang.semantics.model.SemanticTheory;
import org.whole.lang.semantics.model.StructuredVariable;
import org.whole.lang.semantics.model.Variable;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.FreshNameGenerator;
import org.whole.lang.util.IRunnable;
import org.whole.lang.util.ResourceUtils;
import org.whole.lang.util.StringUtils;
import org.whole.lang.visitors.GenericIdentityVisitor;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi
 */
public class SemanticsUtils {
	public static final String USE_IDENTIFIER_SEMANTICS = "USE_IDENTIFIER_SEMANTICS";

	public static IEntityIterator<IEntity> typeCastIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResult(BindingManagerFactory.instance.createSpecificValue(selfEntity));
			}
		});
	}
	public static IEntityIterator<IEntity> typeCastIterator(final String entityTypeUri) {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
//TODO				String contextUri = bm.wIsSet("contextURI") ? bm.wStringValue("contextURI") : null;
				
				EntityDescriptor<?> toEd = CommonsDataTypePersistenceParser.parseEntityDescriptor(entityTypeUri);
				bm.setResult(DataTypeUtils.convertCloneIfParented(selfEntity, toEd));
			}
		});
	}

	public static IEntityIterator<IEntity> semanticsTheoriesIterator() {
		return IteratorFactory.javaCollectionIterator(
				FunctionLibraryRegistry.instance().getResources(false, ResourceUtils.SIMPLE_COMPARATOR));
	}
	public static IEntity getSemanticTheory(String contextURI, String theoryURI, boolean loadOnDemand) {
		return theoryURI != null ? FunctionLibraryRegistry.instance().getResourceModel(theoryURI, loadOnDemand, contextURI) : null;
	}

	public static boolean abstractFilter(EntityDescriptor<?> ed, boolean excludeAbstract) {
		return !(ed.isAbstract() && excludeAbstract);
	}

	public static IEntity getEntitiesUri(IEntity type) {
		if (type == null)
			return BindingManagerFactory.instance.createTuple();
		else if (Matcher.matchImpl(SemanticsEntityDescriptorEnum.LanguageType, type)) {
			IEntity result = BindingManagerFactory.instance.createTuple();

			String languageUri = type.wStringValue();
			ILanguageKit languageKit = ReflectionFactory.getLanguageKit(languageUri, false, null);
			if (languageKit != null)
				for (EntityDescriptor<?> ed : languageKit.getEntityDescriptorEnum())
					result.wAdd(BindingManagerFactory.instance.createValue(ed.getURI()));
			return result;
		} else if (Matcher.matchImpl(SemanticsEntityDescriptorEnum.EntityType, type))
			try {
				return getEntitiesUri(CommonsDataTypePersistenceParser.parseEntityDescriptor(type.wStringValue()));
			} catch (IllegalArgumentException e) {
				return BindingManagerFactory.instance.createTuple();
			}
		else
			return getEntitiesUri(type.wGetEntityDescriptor());
	}
	public static IEntity getEntitiesUri(EntityDescriptor<?> ed) {
		IEntity result = BindingManagerFactory.instance.createTuple();

		if (ed.getEntityKind().isSimple()) {
			List<FeatureDescriptor> fdEnum = ed.getEntityFeatureDescriptors();
			for (FeatureDescriptor fd : fdEnum)
				result.wAdd(BindingManagerFactory.instance.createValue(fd.getURI()));
		}
		return result;
	}

	public static IEntity getFeaturesUri(IEntity termOrEntityType) {
		if (Matcher.matchImpl(SemanticsEntityDescriptorEnum.EntityType, termOrEntityType))
			try {
			return getFeaturesUri(
					CommonsDataTypePersistenceParser.parseEntityDescriptor(termOrEntityType.wStringValue()));
			} catch (IllegalArgumentException e) {
				return BindingManagerFactory.instance.createTuple();
			}
		else
			return getFeaturesUri(termOrEntityType.wGetEntityDescriptor());
	}
	public static IEntity getFeaturesUri(String edUri) {
		return getFeaturesUri(
				CommonsDataTypePersistenceParser.parseEntityDescriptor(edUri));
	}
	public static IEntity getFeaturesUri(EntityDescriptor<?> ed) {
		IEntity result = BindingManagerFactory.instance.createTuple();

		if (ed.getEntityKind().isSimple()) {
			List<FeatureDescriptor> fdEnum = ed.getEntityFeatureDescriptors();
			for (FeatureDescriptor fd : fdEnum)
				result.wAdd(BindingManagerFactory.instance.createValue(fd.getURI()));
		}
		return result;
	}

	public static IEntity createShallowCloneEntity(IEntity selfEntity) {
		EntityDescriptor<?> ed = selfEntity.wGetEntityDescriptor();
		return createShallowMigrateEntity(selfEntity, ed);
	}
	public static IEntity createShallowMigrateEntity(IEntity selfEntity, String targetUri) {
		String edUri = ResourceUtils.hasFragmentPart(targetUri) ?
				targetUri : targetUri+"#"+selfEntity.wGetEntityDescriptor().getName();

		EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(edUri, false, null);
		if (ed == null)
			throw new IllegalArgumentException("The migration target entity is not available: "+targetUri);

		return createShallowMigrateEntity(selfEntity, ed);
	}
	public static IEntity createShallowMigrateEntity(IEntity selfEntity, EntityDescriptor<?> targetEd) {
		IEntityFactory gef = GenericEntityFactory.instance(RegistryConfigurations.RESOLVER);
		
		switch (targetEd.getEntityKind()) {
		case DATA:
			return gef.create(targetEd, selfEntity.wGetValue());
		case COMPOSITE:
//			return gef.create(ed, bindings);
		default:
		case SIMPLE:			
			return gef.create(targetEd);
		}
	}
	//TODO test
	public static IEntity createMigrateEntityWithUri(IEntity selfEntity, String sourceUri, String targetUri) {
		final EntityDescriptor<?> selfEd = selfEntity.wGetEntityDescriptor();
		if (selfEd.getDataKind().isString()) {
			String sourceValue = selfEntity.wStringValue();
			if (sourceValue.startsWith(sourceUri))
				GenericEntityFactory.instance.create(selfEd,
						sourceValue.length() == sourceUri.length() ?
						targetUri : targetUri + sourceValue.substring(sourceUri.length()));
		}
		return BindingManagerFactory.instance.createVoid();
	}

	public static IEntity createTerm(String edUri, FreshNameGenerator nameGenerator) {
		EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(edUri, false, null);
		if (ed == null || (!EntityUtils.isSimple(ed) && !EntityUtils.isFragment(ed)))
			return SemanticsEntityFactory.instance.createEntityType(edUri);

		int size = ed.featureSize();
		IEntity[] values = new IEntity[size];

		SemanticsEntityFactory sf = SemanticsEntityFactory.instance;
		for (int i=0; i<size; i++) {
			FeatureDescriptor fd = ed.getEntityFeatureDescriptor(i);
			values[i] = sf.buildTypedVariable()
					.set(SemanticsFeatureDescriptorEnum.variable,
							sf.createVariable(nameGenerator.nextFreshName(fd.getName())))
					.set(SemanticsFeatureDescriptorEnum.signature,
							sf.createEntityType(fd.getEntityDescriptor().toString()))
					.getResult();
		}

		return CommonsEntityFactory.instance.createStageUpFragment(
				GenericEntityFactory.instance.create(ed, values).wGetAdapter(CommonsEntityDescriptorEnum.Any));
	}

	public static IEntity createTypedVariable(LocalIdentifier variable, FreshNameGenerator nameGenerator) {
		return variable instanceof StructuredVariable ?
				createTypedVariable((StructuredVariable) variable, nameGenerator) :
					createTypedVariable((Variable) variable, nameGenerator);
	}
	public static IEntity createTypedVariable(StructuredVariable variable, FreshNameGenerator nameGenerator) {
		SemanticsEntityFactory sf = SemanticsEntityFactory.instance;
			return sf.createTypedVariable(
					EntityUtils.clone(variable.getVariable()),
					EntityUtils.clone(variable.getIndex()),
					EntityUtils.clone(variable.getTime()),
					sf.createEntityType(EntityUtils.getFormalEntityDescriptor(variable).toString()));
	}
	public static IEntity createTypedVariable(Variable variable, FreshNameGenerator nameGenerator) {
		SemanticsEntityFactory sf = SemanticsEntityFactory.instance;
			return sf.buildTypedVariable()
					.set(SemanticsFeatureDescriptorEnum.variable, EntityUtils.clone(variable))
					.set(SemanticsFeatureDescriptorEnum.signature,
							sf.createEntityType(variable.wGetParent().wGetEntityDescriptor(variable).toString()))
					.getResult();
	}
	public static IEntity createTypedVariable(EntityType type, FreshNameGenerator nameGenerator) {
		SemanticsEntityFactory sf = SemanticsEntityFactory.instance;
			return sf.buildTypedVariable()
					.set(SemanticsFeatureDescriptorEnum.variable,
							sf.createVariable(nameGenerator.nextFreshName(StringUtils.toLowerPrefix(ResourceUtils.stripResourcePart(type.getValue())))))
					.set(SemanticsFeatureDescriptorEnum.signature,
							EntityUtils.clone(type))
					.getResult();
	}

	public static SemanticFunction findSemanticFunction(SemanticTheory semanticTheory, String name) {
		return findSemanticFunction(semanticTheory.getFunctions(), name);
	}
	public static SemanticFunction findSemanticFunction(SemanticFunctions semanticFunctions, String name) {
		for (SemanticFunction sf : semanticFunctions) {
			Name fName = sf.getName();
			if (Matcher.matchImpl(SemanticsEntityDescriptorEnum.Name, fName) && fName.getValue().equals(name))
				return sf;
		}
		return null;
	}

	public static boolean inStageDownContext(IEntity entity) {
		IEntity ancestor = Matcher.findAncestor(new GenericIdentityVisitor() {
			public void visit(IEntity entity) {
				EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
				if (!(ed.equals(SemanticsEntityDescriptorEnum.ExecutionRule) ||
						ed.equals(SemanticsEntityDescriptorEnum.InputBinding) ||
						ed.equals(SemanticsEntityDescriptorEnum.FunctionApplication) ||
//						ed.equals(SemanticsEntityDescriptorEnum.TypeCast) ||
						ed.equals(SemanticsEntityDescriptorEnum.EnvironmentVariable) ||
						ed.equals(SemanticsEntityDescriptorEnum.VariableValue) ||
						EntityUtils.isFragment(ed)))
					throw new VisitException();
			}
		}, entity);
		return ancestor != null && (
				Matcher.match(SemanticsEntityDescriptorEnum.VariableValue, ancestor) ||
				EntityUtils.isStageUpFragment(ancestor));
	}
}
