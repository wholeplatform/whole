/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.AbstractFunctionLibraryDeployer;
import org.whole.lang.reflect.Descriptor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResource;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.IDataTypeWrapper;
import org.whole.lang.util.IRunnable;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class ReflectLibraryDeployer extends AbstractFunctionLibraryDeployer {
	public static final String URI = "whole:org.whole.lang:ReflectLibrary";
	public static final String LANGUAGE_ED = "http://lang.whole.org/Queries#LanguageTest";
	public static final String KIND_ED = "http://lang.whole.org/Queries#KindTest";
	public static final String TYPE_ED = "http://lang.whole.org/Queries#TypeTest";
	public static final String FEATURE_ED = "http://lang.whole.org/Queries#FeatureStep";
	public static final String INT_ED = "http://lang.whole.org/Queries#IntLiteral";
	public static final String STRING_ED = "http://lang.whole.org/Queries#StringLiteral";

	public void deploy(ReflectionFactory platform) {
		putFunctionLibrary(URI);

		putFunctionCode("languages", languagesIterator());
		putFunctionCode("languageSimpleName", languageSimpleNameIterator());
		putFunctionCode("languageQualifiedName", languageQualifiedNameIterator());
		putFunctionCode("languageEntities", languageEntitiesIterator());
		putFunctionCode("languageFeatures", languageFeaturesIterator());

		putFunctionCode("language", languageIterator());
		putFunctionCode("kind", kindIterator());
		putFunctionCode("type", typeIterator());
		putFunctionCode("formalType", formalTypeIterator());
		putFunctionCode("subtypes", subtypesIterator());
		putFunctionCode("supertypes", supertypesIterator());
		putFunctionCode("extendedConcreteSubtypes", extendedConcreteSubtypesIterator());
		putFunctionCode("features", featuresIterator());
		putFunctionCode("size", sizeIterator());
		putFunctionCode("adjacentSize", adjacentSizeIterator());
		putFunctionCode("inverseAdjacentSize", inverseAdjacentSizeIterator());

		putFunctionCode("resourceFragmentUri", resourceFragmentUriIterator());
		putFunctionCode("resourceFragmentName", resourceFragmentNameIterator());
	}


	public static IEntityIterator<IEntity> languagesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResultIterator(IteratorFactory.collectionIterator(
						ReflectionFactory.getLanguageKits(false, ResourceUtils.SIMPLE_COMPARATOR),
						new IDataTypeWrapper.CustomDatatypeWrapper(LANGUAGE_ED) {
							@Override
							public <E extends IEntity> E createEntity(Object value) {
								return super.createEntity(((IResource) value).getURI());
							}
						}));
			}
		});
	}


	public static IEntityIterator<IEntity> languageSimpleNameIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String languageUri = selfEntity.wStringValue();
					String contextUri = bm.wIsSet("contextURI") ? bm.wStringValue("contextURI") : null;
					ILanguageKit languageKit = ReflectionFactory.getLanguageKit(languageUri, true, contextUri);
					if (languageKit != null) {
						EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(STRING_ED, false, null);
						result = GenericEntityFactory.instance.create(ed, ResourceUtils.getSimpleName(languageKit));
					}
				}
				bm.setResult(result);
			}
		});
	}
	public static IEntityIterator<IEntity> languageQualifiedNameIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String languageUri = selfEntity.wStringValue();
					String contextUri = bm.wIsSet("contextURI") ? bm.wStringValue("contextURI") : null;
					ILanguageKit languageKit = ReflectionFactory.getLanguageKit(languageUri, true, contextUri);
					if (languageKit != null) {
						EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(STRING_ED, false, null);
						result = GenericEntityFactory.instance.create(ed, ResourceUtils.getQualifiedName(languageKit));
					}
				}
				bm.setResult(result);
			}
		});
	}

	public static IEntityIterator<IEntity> languageEntitiesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntityIterator<IEntity> resultIterator = IteratorFactory.emptyIterator();

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String languageUri = selfEntity.wStringValue();
					String contextUri = bm.wIsSet("contextURI") ? bm.wStringValue("contextURI") : null;
					ILanguageKit languageKit = ReflectionFactory.getLanguageKit(languageUri, true, contextUri);
					if (languageKit != null) {
						resultIterator = IteratorFactory.collectionIterator(
								languageKit.getEntityDescriptorEnum(),
								new IDataTypeWrapper.CustomDatatypeWrapper(TYPE_ED) {
									@Override
									public <E extends IEntity> E createEntity(Object value) {
										return super.createEntity(((Descriptor) value).getURI());
									}
								});
					}
				}
				bm.setResultIterator(resultIterator);
			}
		});
	}

	public static IEntityIterator<IEntity> languageFeaturesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntityIterator<IEntity> resultIterator = IteratorFactory.emptyIterator();

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String languageUri = selfEntity.wStringValue();
					String contextUri = bm.wIsSet("contextURI") ? bm.wStringValue("contextURI") : null;
					ILanguageKit languageKit = ReflectionFactory.getLanguageKit(languageUri, true, contextUri);
					if (languageKit != null) {
						resultIterator = IteratorFactory.collectionIterator(
								languageKit.getFeatureDescriptorEnum(),
								new IDataTypeWrapper.CustomDatatypeWrapper(FEATURE_ED) {
									@Override
									public <E extends IEntity> E createEntity(Object value) {
										return super.createEntity(((Descriptor) value).getURI());
									}
								});
					}
				}
				bm.setResultIterator(resultIterator);
			}
		});
	}

	public static IEntityIterator<IEntity> languageIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(LANGUAGE_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(
						ed, selfEntity.wGetLanguageKit().getURI()));
			}
		});
	}

	public static IEntityIterator<IEntity> kindIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(KIND_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(
						ed, ed.getDataEnumType().valueOf(selfEntity.wGetEntityKind().toString())));
			}
		});
	}

	public static IEntityIterator<IEntity> typeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(TYPE_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(
						ed, selfEntity.wGetEntityDescriptor().getURI()));
			}
		});
	}

	public static IEntityIterator<IEntity> formalTypeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(TYPE_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(
						ed, selfEntity.wGetParent().wGetEntityDescriptor(selfEntity).getURI()));
			}
		});
	}

	public static IEntityIterator<IEntity> subtypesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResultIterator(subtypesIterator(selfEntity.wGetEntityDescriptor(), TYPE_ED));
			}
		});
	}
	public static IEntityIterator<IEntity> subtypesIterator(EntityDescriptor<?> ed, String entityTypeUri) {
		return IteratorFactory.collectionIterator(
				ed.languageSubtypesIterable(), new IDataTypeWrapper.CustomDatatypeWrapper(entityTypeUri) {
					@Override
					public <E extends IEntity> E createEntity(Object value) {
						return super.createEntity(((Descriptor) value).getURI());
					}
				});
	}

	public static IEntityIterator<IEntity> supertypesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResultIterator(supertypesIterator(selfEntity.wGetEntityDescriptor(), TYPE_ED));
			}
		});
	}
	public static IEntityIterator<IEntity> supertypesIterator(EntityDescriptor<?> ed, String entityTypeUri) {
		return IteratorFactory.collectionIterator(
				ed.languageSupertypesIterable(), new IDataTypeWrapper.CustomDatatypeWrapper(entityTypeUri) {
					@Override
					public <E extends IEntity> E createEntity(Object value) {
						return super.createEntity(((Descriptor) value).getURI());
					}
				});
	}

	public static IEntityIterator<IEntity> extendedConcreteSubtypesIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResultIterator(extendedConcreteSubtypesIterator(selfEntity.wGetEntityDescriptor(), TYPE_ED));
			}
		});
	}
	public static IEntityIterator<IEntity> extendedConcreteSubtypesIterator(EntityDescriptor<?> ed, String entityTypeUri) {
		return IteratorFactory.collectionIterator(
				ed.getEntityDescriptorEnum().getExtendedLanguageConcreteSubtypesOf(ed), new IDataTypeWrapper.CustomDatatypeWrapper(entityTypeUri) {
					@Override
					public <E extends IEntity> E createEntity(Object value) {
						return super.createEntity(((Descriptor) value).getURI());
					}
				});
	}

	public static IEntityIterator<IEntity> featuresIterator() {
		return IteratorFactory.multiValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				bm.setResultIterator(featuresIterator(selfEntity.wGetEntityDescriptor(), FEATURE_ED));
			}
		});
	}
	public static IEntityIterator<IEntity> featuresIterator(EntityDescriptor<?> ed, String entityTypeUri) {
		return IteratorFactory.collectionIterator(
				ed.getEntityFeatureDescriptors(), new IDataTypeWrapper.CustomDatatypeWrapper(entityTypeUri) {
					@Override
					public <E extends IEntity> E createEntity(Object value) {
						return super.createEntity(((Descriptor) value).getURI());
					}
				});
	}

	public static IEntityIterator<IEntity> sizeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(INT_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(ed, selfEntity.wSize()));
			}
		});
	}

	public static IEntityIterator<IEntity> adjacentSizeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(INT_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(ed, selfEntity.wAdjacentSize()));
			}
		});
	}

	public static IEntityIterator<IEntity> inverseAdjacentSizeIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(INT_ED, false, null);
				bm.setResult(GenericEntityFactory.instance.create(ed, selfEntity.wInverseAdjacentSize()));
			}
		});
	}

	public static IEntityIterator<IEntity> resourceFragmentUriIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String resourceUri = selfEntity.wStringValue();
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(STRING_ED, false, null);
					result = GenericEntityFactory.instance.create(ed, ResourceUtils.getResourceFragmentUri(resourceUri));
				}
				bm.setResult(result);
			}
		});
	}
	public static IEntityIterator<IEntity> resourceFragmentNameIterator() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				IEntity result = null;

				if (DataTypeUtils.getDataKind(selfEntity).isString()) {
					String resourceUri = selfEntity.wStringValue();
					EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(STRING_ED, false, null);
					result = GenericEntityFactory.instance.create(ed, ResourceUtils.getResourceFragmentName(resourceUri));
				}
				bm.setResult(result);
			}
		});
	}
}
