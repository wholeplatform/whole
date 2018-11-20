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
package org.whole.lang;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.AbstractFunctionLibraryDeployer;
import org.whole.lang.reflect.Descriptor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.WholeURIResolver;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IDataTypeWrapper;
import org.whole.lang.util.IRunnable;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class ReflectLibraryDeployer extends AbstractFunctionLibraryDeployer {
	public static final String URI = "whole:org.whole.lang:ReflectLibrary";
	public static final String KIND_ED = "http://lang.whole.org/Queries#KindTest";
	public static final String COMPOSITE_KIND_ED = "http://lang.whole.org/Queries#CompositeKindTest";
	public static final String DATA_KIND_ED = "http://lang.whole.org/Queries#DataKindTest";

	//ILanguageKit, EntityDescriptor, FeatureDescriptor, IEntity APIs
	public void deploy(ReflectionFactory platform) {
		putFunctionLibrary(URI);

		putFunctionCode("languages", languagesIterator());

		//self = DataEntity<languageURI | entityURI | featureURI | LK | ED | FD>
		putFunctionCode("languageURI", languageURIIterator());
		putFunctionCode("languageNamespace", languageNamespaceIterator());
		putFunctionCode("languageName", languageNameIterator());
		putFunctionCode("languageSimpleName", languageSimpleNameIterator());
		putFunctionCode("languageQualifiedName", languageQualifiedNameIterator());
		putFunctionCode("languageVersion", languageVersionIterator());
		putFunctionCode("languageIsDynamic", languageIsDynamicIterator());
		putFunctionCode("languageMetamodel", languageMetamodelIterator());
		putFunctionCode("languageEntities", languageEntitiesIterator());
		putFunctionCode("languageFeatures", languageFeaturesIterator());

		//self = DataEntity<entityURI | ED>
		putFunctionCode("entityLanguage", entityLanguageIterator());
		putFunctionCode("entityURI", entityUriIterator());
		putFunctionCode("entityOrdinal", entityOrdinalIterator());
		putFunctionCode("entityName", entityNameIterator());
		putFunctionCode("entityImplName", entityImplNameIterator());
		putFunctionCode("entityIsAbstract", entityIsAbstractIterator());
		putFunctionCode("entityIsRelationship", entityIsRelationshipIterator());
		putFunctionCode("entityIsToManyRelationship", entityIsToManyRelationshipIterator());
		putFunctionCode("entityKind", entityKindIterator());
		putFunctionCode("entityCompositeKind", entityCompositeKindIterator());
		putFunctionCode("entityDataKind", entityDataKindIterator());
		putFunctionCode("entitySize", entitySizeIterator());
		putFunctionCode("entityChildSize", entityChildSizeIterator());
		putFunctionCode("entityAdjacentSize", entityAdjacentSizeIterator());
		putFunctionCode("entityFeature", entityFeatureIterator());
		putFunctionCode("entityFeatures", entityFeaturesIterator());
		putFunctionCode("entitySupertypes", entitySupertypesIterator());
		putFunctionCode("entitySubtypes", entitySubtypesIterator());
		putFunctionCode("entityExtendedConcreteSubtypes", entityExtendedConcreteSubtypesIterator());

		//self = DataEntity<featureURI | FD>
		putFunctionCode("featureLanguage", featureLanguageIterator());
		putFunctionCode("featureURI", featureUriIterator());
		putFunctionCode("featureOrdinal", featureOrdinalIterator());
		putFunctionCode("featureName", featureNameIterator());
		putFunctionCode("featureImplName", featureImplNameIterator());
		putFunctionCode("featureIsOptional", featureIsOptionalIterator());
		putFunctionCode("featureIsId", featureIsIdIterator());
		putFunctionCode("featureIsReference", featureIsReferenceIterator());
		putFunctionCode("featureIsDerived", featureIsDerivedIterator());
		putFunctionCode("featureIsShared", featureIsSharedIterator());
		putFunctionCode("featureIsToMany", featureIsToManyIterator());
		putFunctionCode("featureParentType", featureParentTypeIterator());
		putFunctionCode("featureOpposite", featureOppositeIterator());
		putFunctionCode("featureType", featureTypeIterator());

		//self = IEntity
		putFunctionCode("instanceLanguage", instanceLanguageIterator());
		putFunctionCode("instanceKind", instanceKindIterator());
		putFunctionCode("instanceCompositeKind", instanceCompositeKindIterator());
		putFunctionCode("instanceDataKind", instanceDataKindIterator());
		putFunctionCode("instanceType", instanceTypeIterator());
		putFunctionCode("instanceAtType", instanceAtTypeIterator());
		putFunctionCode("instanceAtFeature", instanceAtFeatureIterator());
		putFunctionCode("instanceAtIndex", instanceAtIndexIterator());
		putFunctionCode("instanceSupertypes", instanceSupertypesIterator());
		putFunctionCode("instanceSubtypes", instanceSubtypesIterator());
		putFunctionCode("instanceExtendedConcreteSubtypes", instanceExtendedConcreteSubtypesIterator());
		putFunctionCode("instanceFeatureStep", instanceFeatureStepIterator());
		putFunctionCode("instanceFeature", instanceFeatureIterator());
		putFunctionCode("instanceFeatures", instanceFeaturesIterator());
		putFunctionCode("instanceAspectualFeatures", instanceAspectualFeaturesIterator());
		putFunctionCode("instanceChildSize", instanceChildSizeIterator());
		putFunctionCode("instanceAdjacentSize", instanceAdjacentSizeIterator());
		putFunctionCode("instanceInverseAdjacentSize", instanceInverseAdjacentSizeIterator());

		//self = DataEntity<resourceURI>
		putFunctionCode("uriLanguage", uriLanguageIterator());
		putFunctionCode("uriEntity", uriEntityIterator());
		putFunctionCode("uriFeature", uriFeatureIterator());
		putFunctionCode("uriResourcePart", uriResourcePartIterator());
		putFunctionCode("uriFragmentPart", uriFragmentPartIterator());
		putFunctionCode("uriIsWholeScheme", uriIsWholeSchemeIterator());
		putFunctionCode("uriWithNamespaceNameVersion", uriWithNamespaceNameVersionIterator());
		putFunctionCode("uriNamespace", uriNamespaceIterator());
		putFunctionCode("uriWithNamespace", uriWithNamespaceIterator());
		putFunctionCode("uriWithNamespaceSuffix", uriWithNamespaceSuffixIterator());
		putFunctionCode("uriName", uriNameIterator());
		putFunctionCode("uriWithName", uriWithNameIterator());
		putFunctionCode("uriWithNameSuffix", uriWithNameSuffixIterator());
		putFunctionCode("uriVersion", uriVersionIterator());
		putFunctionCode("uriWithVersion", uriWithVersionIterator());
	}


	public static IExecutable languagesIterator() {
		return ExecutableFactory.instance.createMultiValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setExecutableResult(ExecutableFactory.instance.createCollection(
						ReflectionFactory.getLanguageKits(false, ResourceUtils.SIMPLE_COMPARATOR),
						IDataTypeWrapper.envObjectValue));
			}
		});
	}


	public static IExecutable languageURIIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return BindingManagerFactory.instance.createValue(languageKit.getURI());
			}
		});
	}
	public static IExecutable languageNamespaceIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return BindingManagerFactory.instance.createValue(languageKit.getNamespace());
			}
		});
	}
	public static IExecutable languageNameIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return BindingManagerFactory.instance.createValue(languageKit.getName());
			}
		});
	}
	public static IExecutable languageSimpleNameIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return BindingManagerFactory.instance.createValue(ResourceUtils.getSimpleName(languageKit));
			}
		});
	}
	public static IExecutable languageQualifiedNameIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return BindingManagerFactory.instance.createValue(ResourceUtils.getQualifiedName(languageKit));
			}
		});
	}
	public static IExecutable languageVersionIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return //TODO ? languageKit.getVersion().equals("") ? CommonsEntityFactory.instance.createResolver() :
						BindingManagerFactory.instance.createValue(languageKit.getVersion());
			}
		});
	}
	public static IExecutable languageIsDynamicIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return BindingManagerFactory.instance.createValue(languageKit.isDynamic());
			}
		});
	}
	public static IExecutable languageMetamodelIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new LanguageSingleValuedPropertyRunnable() {
			protected IEntity getProperty(ILanguageKit languageKit) {
				return languageKit.getMetaModel();
			}
		});
	}
	public static IExecutable languageEntitiesIterator() {
		return ExecutableFactory.instance.createMultiValuedRunnable(new LanguageMultiValuedPropertyRunnable() {
			protected IExecutable getPropertyIterator(ILanguageKit languageKit) {
				return ExecutableFactory.instance.createCollection(
						languageKit.getEntityDescriptorEnum(),
						IDataTypeWrapper.envEnumValue);
			}
		});
	}
	public static IExecutable languageFeaturesIterator() {
		return ExecutableFactory.instance.createMultiValuedRunnable(new LanguageMultiValuedPropertyRunnable() {
			protected IExecutable getPropertyIterator(ILanguageKit languageKit) {
				return ExecutableFactory.instance.createCollection(
						languageKit.getFeatureDescriptorEnum(),
						IDataTypeWrapper.envEnumValue);
			}
		});
	}
	protected abstract static class LanguagePropertyRunnable implements IRunnable {
		public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
			ILanguageKit languageKit = null;

			if (DataTypeUtils.getDataKind(selfEntity).isString()) {
				String languageUri = ResourceUtils.stripFragmentPart(selfEntity.wStringValue());
				languageKit = ReflectionFactory.safeGetLanguageKit(languageUri, true, bm);
			} else if (DataTypeUtils.getDataKind(selfEntity).isEnumValue() && selfEntity.wEnumValue() instanceof Descriptor)
				languageKit = ((Descriptor) selfEntity.wEnumValue()).getLanguageKit();
			else if (DataTypeUtils.getDataKind(selfEntity).isObject()) {
				if (selfEntity.wGetValue() instanceof ILanguageKit)
					languageKit = (ILanguageKit) selfEntity.wGetValue();
				else if (selfEntity.wGetValue() instanceof Descriptor)
					languageKit = ((Descriptor) selfEntity.wGetValue()).getLanguageKit();
			}

			if (languageKit != null)
				setResult(bm, languageKit);
			else
				bm.setResult(null);
		}
		protected abstract void setResult(IBindingManager bm, ILanguageKit languageKit);
	}
	protected abstract static class LanguageSingleValuedPropertyRunnable extends LanguagePropertyRunnable {
		protected void setResult(IBindingManager bm, ILanguageKit languageKit) {
			bm.setResult(getProperty(languageKit));
		}
		protected abstract IEntity getProperty(ILanguageKit languageKit);
	}
	protected abstract static class LanguageMultiValuedPropertyRunnable extends LanguagePropertyRunnable {
		protected void setResult(IBindingManager bm, ILanguageKit languageKit) {
			bm.setExecutableResult(getPropertyIterator(languageKit));
		}
		protected abstract IExecutable getPropertyIterator(ILanguageKit languageKit);
	}


	public static IExecutable entityLanguageIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.getLanguageKit());
			}
		});
	}
	public static IExecutable entityUriIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.getURI());
			}
		});
	}
	public static IExecutable entityOrdinalIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.getOrdinal());
			}
		});
	}
	public static IExecutable entityNameIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.getName());
			}
		});
	}
	public static IExecutable entityImplNameIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.getImplName());
			}
		});
	}
	public static IExecutable entityIsAbstractIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.isAbstract());
			}
		});
	}
	public static IExecutable entityIsRelationshipIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.isRelationship());
			}
		});
	}
	public static IExecutable entityIsToManyRelationshipIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.isToManyRelationship());
			}
		});
	}
	public static IExecutable entityKindIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				EntityDescriptor<?> kindEd = CommonsDataTypePersistenceParser.getEntityDescriptor(KIND_ED, false, null);
				return GenericEntityFactory.instance.create(
						kindEd, kindEd.getDataEnumType().valueOf(ed.getEntityKind().toString()));
			}
		});
	}
	public static IExecutable entityCompositeKindIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				EntityDescriptor<?> kindEd = CommonsDataTypePersistenceParser.getEntityDescriptor(COMPOSITE_KIND_ED, false, null);
				return GenericEntityFactory.instance.create(
						kindEd, kindEd.getDataEnumType().valueOf(ed.getCompositeKind().toString()));
			}
		});
	}
	public static IExecutable entityDataKindIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				EntityDescriptor<?> kindEd = CommonsDataTypePersistenceParser.getEntityDescriptor(DATA_KIND_ED, false, null);
				return GenericEntityFactory.instance.create(
						kindEd, kindEd.getDataEnumType().valueOf(ed.getDataKind().toString()));
			}
		});
	}
	public static IExecutable entitySizeIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.featureSize());
			}
		});
	}
	public static IExecutable entityChildSizeIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.childFeatureSize());
			}
		});
	}
	public static IExecutable entityAdjacentSizeIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntitySingleValuedPropertyRunnable() {
			protected IEntity getProperty(EntityDescriptor<?> ed) {
				return BindingManagerFactory.instance.createValue(ed.adjacentFeatureSize());
			}
		});
	}
	public static IExecutable entityFeatureIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new EntityPropertyRunnable() {
			protected void setResult(IBindingManager bm, EntityDescriptor<?> ed) {
				setFeatureDescriptorResult(bm, ed);
			}
		});
	}
	public static void setFeatureDescriptorResult(IBindingManager bm, EntityDescriptor<?> ed) {
		FeatureDescriptor fd = bm.wIsSet("feature") ? getFeatureDescriptor(bm.wGet("feature"), bm) : null;
		String featureName = fd == null && bm.wIsSet("featureName") ? bm.wStringValue("featureName") : null;
		int featureIndex = fd == null && featureName == null && bm.wIsSet("featureIndex") ? bm.wIntValue("featureIndex") : -1;

		FeatureDescriptor lfd = null;
		if (fd != null) {
			if (fd.getLanguageKit().equals(ed.getLanguageKit()))
				lfd = fd;
			else
				featureName = fd.getName();
		}
		if (featureName != null)
			lfd = ed.getFeatureDescriptorEnum().valueOf(featureName);

		FeatureDescriptor efd = null;
		if (lfd != null)
			featureIndex = ed.indexOf(lfd);
		if (featureIndex > -1 && featureIndex < ed.featureSize())
			efd = ed.getEntityFeatureDescriptor(featureIndex);
		
		bm.setResult(efd != null ? BindingManagerFactory.instance.createValue(efd) : null);
	}
	public static IExecutable entityFeaturesIterator() {
		return ExecutableFactory.instance.createMultiValuedRunnable(new EntityMultiValuedPropertyRunnable() {
			protected IExecutable getPropertyIterator(EntityDescriptor<?> ed) {
				return ExecutableFactory.instance.createCollection(
						ed.getEntityFeatureDescriptors(),
						IDataTypeWrapper.envEnumValue);
			}
		});
	}
	public static IExecutable entitySupertypesIterator() {
		return ExecutableFactory.instance.createMultiValuedRunnable(new EntityMultiValuedPropertyRunnable() {
			protected IExecutable getPropertyIterator(EntityDescriptor<?> ed) {
				return supertypesIterator(ed);
			}
		});
	}
	public static IExecutable entitySubtypesIterator() {
		return ExecutableFactory.instance.createMultiValuedRunnable(new EntityMultiValuedPropertyRunnable() {
			protected IExecutable getPropertyIterator(EntityDescriptor<?> ed) {
				return subtypesIterator(ed);
			}
		});
	}
	public static IExecutable entityExtendedConcreteSubtypesIterator() {
		return ExecutableFactory.instance.createMultiValuedRunnable(new EntityMultiValuedPropertyRunnable() {
			protected IExecutable getPropertyIterator(EntityDescriptor<?> ed) {
				return extendedConcreteSubtypesIterator(ed);
			}
		});
	}
	protected abstract static class EntityPropertyRunnable implements IRunnable {
		public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
			EntityDescriptor<?> ed = null;

			if (DataTypeUtils.getDataKind(selfEntity).isString()) {
				String uri = selfEntity.wStringValue();
				if (ResourceUtils.hasFragmentPart(uri)) {
					String languageUri = ResourceUtils.stripFragmentPart(uri);
					String descriptorName = ResourceUtils.getFragmentPart(uri);
					ILanguageKit languageKit = ReflectionFactory.safeGetLanguageKit(languageUri, true, bm);
					if (languageKit != null)
						ed = languageKit.getEntityDescriptorEnum().valueOf(descriptorName);
				}
			} else if (DataTypeUtils.getDataKind(selfEntity).isEnumValue() && selfEntity.wEnumValue() instanceof EntityDescriptor)
				ed = (EntityDescriptor<?>) selfEntity.wEnumValue();
			else if (DataTypeUtils.getDataKind(selfEntity).isObject() && selfEntity.wGetValue() instanceof EntityDescriptor)
				ed = (EntityDescriptor<?>) selfEntity.wGetValue();


			if (ed != null)
				setResult(bm, ed);
			else
				bm.setResult(null);
		}
		protected abstract void setResult(IBindingManager bm, EntityDescriptor<?> ed);
	}
	protected abstract static class EntitySingleValuedPropertyRunnable extends EntityPropertyRunnable {
		protected void setResult(IBindingManager bm, EntityDescriptor<?> ed) {
			bm.setResult(getProperty(ed));
		}
		protected abstract IEntity getProperty(EntityDescriptor<?> ed);
	}
	protected abstract static class EntityMultiValuedPropertyRunnable extends EntityPropertyRunnable {
		protected void setResult(IBindingManager bm, EntityDescriptor<?> ed) {
			bm.setExecutableResult(getPropertyIterator(ed));
		}
		protected abstract IExecutable getPropertyIterator(EntityDescriptor<?> ed);
	}


	public static IExecutable featureLanguageIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				return BindingManagerFactory.instance.createValue(fd.getLanguageKit());
			}
		});
	}
	public static IExecutable featureUriIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				return BindingManagerFactory.instance.createValue(fd.getURI());
			}
		});
	}
	public static IExecutable featureOrdinalIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				return BindingManagerFactory.instance.createValue(fd.getOrdinal());
			}
		});
	}
	public static IExecutable featureNameIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				return BindingManagerFactory.instance.createValue(fd.getName());
			}
		});
	}
	public static IExecutable featureImplNameIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				return BindingManagerFactory.instance.createValue(fd.getImplName());
			}
		});
	}
	public static IExecutable featureIsOptionalIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.isOptional());
				} catch (UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IExecutable featureIsIdIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.isId());
				} catch (UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IExecutable featureIsReferenceIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.isReference());
				} catch (UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IExecutable featureIsDerivedIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.isDerived());
				} catch (UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IExecutable featureIsSharedIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.isShared());
				} catch (UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IExecutable featureIsToManyIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.isToMany());
				} catch (UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IExecutable featureParentTypeIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.getParentEntityDescriptor());
				} catch (UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IExecutable featureOppositeIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.getOppositeFeatureDescriptor());
				} catch (UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	public static IExecutable featureTypeIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new FeatureSingleValuedPropertyRunnable() {
			protected IEntity getProperty(FeatureDescriptor fd) {
				try {
					return BindingManagerFactory.instance.createValue(fd.getEntityDescriptor());
				} catch (UnsupportedOperationException e) {
					return null;
				}
			}
		});
	}
	protected abstract static class FeatureSingleValuedPropertyRunnable implements IRunnable {
		public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
			FeatureDescriptor fd = getFeatureDescriptor(selfEntity, bm);
			bm.setResult(fd != null ? getProperty(fd) : null);
		}
		protected abstract IEntity getProperty(FeatureDescriptor d);
	}
	public static FeatureDescriptor getFeatureDescriptor(IEntity selfEntity, IBindingManager bm) {
		FeatureDescriptor fd = null;

		if (DataTypeUtils.getDataKind(selfEntity).isString()) {
			String uri = selfEntity.wStringValue();
			if (ResourceUtils.hasFragmentPart(uri)) {
				String languageUri = ResourceUtils.stripFragmentPart(uri);
				String descriptorName = ResourceUtils.getFragmentPart(uri);
				ILanguageKit languageKit = ReflectionFactory.safeGetLanguageKit(languageUri, true, bm);
				if (languageKit != null)
					fd = languageKit.getFeatureDescriptorEnum().valueOf(descriptorName);
			}
		} else if (DataTypeUtils.getDataKind(selfEntity).isEnumValue() && selfEntity.wEnumValue() instanceof FeatureDescriptor)
			fd = (FeatureDescriptor) selfEntity.wEnumValue();
		else if (DataTypeUtils.getDataKind(selfEntity).isObject() && selfEntity.wGetValue() instanceof FeatureDescriptor)
			fd = (FeatureDescriptor) selfEntity.wGetValue();
		return fd;
	}

	public static IExecutable instanceLanguageIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResult(BindingManagerFactory.instance.createValue(
						selfEntity.wGetLanguageKit()));
			}
		});
	}

	public static IExecutable instanceKindIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(KIND_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(
						ed, ed.getDataEnumType().valueOf(selfEntity.wGetEntityKind().toString())));
			}
		});
	}
	public static IExecutable instanceCompositeKindIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(COMPOSITE_KIND_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(
						ed, ed.getDataEnumType().valueOf(selfEntity.wGetEntityDescriptor().getCompositeKind().toString())));
			}
		});
	}
	public static IExecutable instanceDataKindIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(DATA_KIND_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(
						ed, ed.getDataEnumType().valueOf(selfEntity.wGetEntityDescriptor().getDataKind().toString())));
			}
		});
	}

	public static IExecutable instanceTypeIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResult(BindingManagerFactory.instance.createValue(
						selfEntity.wGetEntityDescriptor()));
			}
		});
	}

	public static IExecutable instanceAtTypeIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResult(EntityUtils.hasParent(selfEntity) ? 
						BindingManagerFactory.instance.createValue(selfEntity.wGetParent().wGetEntityDescriptor(selfEntity)) : null);
			}
		});
	}
	public static IExecutable instanceAtFeatureIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResult(EntityUtils.hasParent(selfEntity) ?
						BindingManagerFactory.instance.createValue(selfEntity.wGetParent().wGetFeatureDescriptor(selfEntity)) : null);
			}
		});
	}
	public static IExecutable instanceAtIndexIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResult(EntityUtils.hasParent(selfEntity) ?
						BindingManagerFactory.instance.createValue(selfEntity.wGetParent().wIndexOf(selfEntity)) : null);
			}
		});
	}

	public static IExecutable instanceSupertypesIterator() {
		return ExecutableFactory.instance.createMultiValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setExecutableResult(supertypesIterator(selfEntity.wGetEntityDescriptor()));
			}
		});
	}
	public static IExecutable supertypesIterator(EntityDescriptor<?> ed) {
		return ExecutableFactory.instance.createCollection(
				ed.languageSupertypesIterable(),
				IDataTypeWrapper.envEnumValue);
	}

	public static IExecutable instanceSubtypesIterator() {
		return ExecutableFactory.instance.createMultiValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setExecutableResult(subtypesIterator(selfEntity.wGetEntityDescriptor()));
			}
		});
	}
	public static IExecutable subtypesIterator(EntityDescriptor<?> ed) {
		return ExecutableFactory.instance.createCollection(
				ed.languageSubtypesIterable(),
				IDataTypeWrapper.envEnumValue);
	}

	public static IExecutable instanceExtendedConcreteSubtypesIterator() {
		return ExecutableFactory.instance.createMultiValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setExecutableResult(extendedConcreteSubtypesIterator(selfEntity.wGetEntityDescriptor()));
			}
		});
	}
	public static IExecutable extendedConcreteSubtypesIterator(EntityDescriptor<?> ed) {
		return ExecutableFactory.instance.createCollection(
				ed.getEntityDescriptorEnum().getExtendedLanguageConcreteSubtypesOf(ed),
				IDataTypeWrapper.envEnumValue);
	}

	public static IExecutable instanceFeatureStepIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = selfEntity.wGetEntityDescriptor();

				FeatureDescriptor fd = bm.wIsSet("feature") ? getFeatureDescriptor(bm.wGet("feature"), bm) : null;
				String featureName = fd == null && bm.wIsSet("featureName") ? bm.wStringValue("featureName") : null;
				int featureIndex = fd == null && featureName == null && bm.wIsSet("featureIndex") ? bm.wIntValue("featureIndex") : -1;

				FeatureDescriptor efd = null;
				if (featureName != null)
					fd = ed.getFeatureDescriptorEnum().valueOf(featureName);
				if (fd != null)
					featureIndex = ed.indexOf(fd);
				
				
				IEntity child = null;
				if (featureIndex > -1 && featureIndex < selfEntity.wSize())
					child = selfEntity.wGet(featureIndex);
				else if (fd != null && selfEntity.wGetAspectualFeatureDescriptors().contains(fd))
					child = selfEntity.wGet(efd);

				bm.setResult(child != null ? child : null);
			}
		});
	}

	public static IExecutable instanceFeatureIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				setFeatureDescriptorResult(bm, selfEntity.wGetEntityDescriptor());
			}
		});
	}

	public static IExecutable instanceFeaturesIterator() {
		return ExecutableFactory.instance.createMultiValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setExecutableResult(featuresIterator(selfEntity.wGetEntityDescriptor()));
			}
		});
	}
	public static IExecutable featuresIterator(EntityDescriptor<?> ed) {
		return ExecutableFactory.instance.createCollection(
				ed.getEntityFeatureDescriptors(),
				IDataTypeWrapper.envEnumValue);
	}
	public static IExecutable instanceAspectualFeaturesIterator() {
		return ExecutableFactory.instance.createMultiValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setExecutableResult(ExecutableFactory.instance.createCollection(
						selfEntity.wGetAspectualFeatureDescriptors(),
						IDataTypeWrapper.envEnumValue));
			}
		});
	}

	public static IExecutable instanceChildSizeIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResult(BindingManagerFactory.instance.createValue(selfEntity.wSize()));
			}
		});
	}

	public static IExecutable instanceAdjacentSizeIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResult(BindingManagerFactory.instance.createValue(selfEntity.wAdjacentSize()));
			}
		});
	}

	public static IExecutable instanceInverseAdjacentSizeIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResult(BindingManagerFactory.instance.createValue(selfEntity.wInverseAdjacentSize()));
			}
		});
	}

	public static IExecutable uriLanguageIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String languageUri = ResourceUtils.stripFragmentPart(selfEntity.wStringValue());
					ILanguageKit languageKit = ReflectionFactory.safeGetLanguageKit(languageUri, true, bm);
					if (languageKit != null)
						result = BindingManagerFactory.instance.createValue(languageKit);
				}

				bm.setResult(result);
			}
		});
	}
	public static IExecutable uriEntityIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String uri = selfEntity.wStringValue();
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(uri, true, bm);
					if (ed != null)
						result = BindingManagerFactory.instance.createValue(ed);
				}

				bm.setResult(result);
			}
		});
	}
	public static IExecutable uriFeatureIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String uri = selfEntity.wStringValue();
					FeatureDescriptor fd = CommonsDataTypePersistenceParser.getFeatureDescriptor(uri, true, bm);
					if (fd != null)
						result = BindingManagerFactory.instance.createValue(fd);
				}

				bm.setResult(result);
			}
		});
	}
	public static IExecutable uriResourcePartIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String resourcePart = ResourceUtils.getResourcePart(selfEntity.wStringValue());
					if (resourcePart != null)
						result = BindingManagerFactory.instance.createValue(resourcePart);
				}

				bm.setResult(result);
			}
		});
	}
	public static IExecutable uriFragmentPartIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String fragmentPart = ResourceUtils.getFragmentPart(selfEntity.wStringValue());
					if (fragmentPart != null)
						result = BindingManagerFactory.instance.createValue(fragmentPart);
				}

				bm.setResult(result);
			}
		});
	}

	public static IExecutable uriIsWholeSchemeIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResult(BindingManagerFactory.instance.createValue(
						DataTypeUtils.getDataKind(selfEntity).isString() ?
								WholeURIResolver.isWholeScheme(selfEntity.wStringValue()) : false));
			}
		});
	}

	public static IExecutable uriWithNamespaceNameVersionIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				String namespace = bm.wIsSet("namespace") ? bm.wStringValue("namespace") : null;
				String name = bm.wIsSet("name") ? bm.wStringValue("name") : null;
				String version = bm.wIsSet("version") ? bm.wStringValue("version") : "";
				if (namespace != null && name != null)
					result = BindingManagerFactory.instance.createValue(WholeURIResolver.getURI(namespace, name, version));

				bm.setResult(result);
			}
		});
	}
	public static IExecutable uriNamespaceIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString())
					try {
						result = BindingManagerFactory.instance.createValue(WholeURIResolver.getNamespace(selfEntity.wStringValue()));
					} catch (IllegalArgumentException e) {
					}

				bm.setResult(result);
			}
		});
	}
	public static IExecutable uriWithNamespaceIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String namespace = bm.wIsSet("namespace") ? bm.wStringValue("namespace") : null;
					if (namespace != null)
						try {
							result = BindingManagerFactory.instance.createValue(WholeURIResolver.setNamespace(selfEntity.wStringValue(), namespace));
						} catch (IllegalArgumentException e) {
						}
				}

				bm.setResult(result);
			}
		});
	}
	public static IExecutable uriWithNamespaceSuffixIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String suffix = bm.wIsSet("suffix") ? bm.wStringValue("suffix") : "";
					try {
						result = BindingManagerFactory.instance.createValue(WholeURIResolver.addNamespaceSuffix(selfEntity.wStringValue(), suffix));
					} catch (IllegalArgumentException e) {
					}
				}

				bm.setResult(result);
			}
		});
	}
	public static IExecutable uriNameIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString())
					try {
						result = BindingManagerFactory.instance.createValue(WholeURIResolver.getName(selfEntity.wStringValue()));
					} catch (IllegalArgumentException e) {
					}

				bm.setResult(result);
			}
		});
	}
	public static IExecutable uriWithNameIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String name = bm.wIsSet("name") ? bm.wStringValue("name") : null;
					if (name != null)
						try {
							result = BindingManagerFactory.instance.createValue(WholeURIResolver.setName(selfEntity.wStringValue(), name));
						} catch (IllegalArgumentException e) {
						}
				}

				bm.setResult(result);
			}
		});
	}
	public static IExecutable uriWithNameSuffixIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String suffix = bm.wIsSet("suffix") ? bm.wStringValue("suffix") : "";
					result = BindingManagerFactory.instance.createValue(WholeURIResolver.addNameSuffix(selfEntity.wStringValue(), suffix));
				}

				bm.setResult(result);
			}
		});
	}
	public static IExecutable uriVersionIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString())
					result = BindingManagerFactory.instance.createValue(WholeURIResolver.getVersion(selfEntity.wStringValue()));

				bm.setResult(result);
			}
		});
	}
	public static IExecutable uriWithVersionIterator() {
		return ExecutableFactory.instance.createSingleValuedRunnable(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String version = bm.wIsSet("version") ? bm.wStringValue("version") : "";
					result = BindingManagerFactory.instance.createValue(WholeURIResolver.setVersion(selfEntity.wStringValue(), version));
				}

				bm.setResult(result);
			}
		});
	}
}
