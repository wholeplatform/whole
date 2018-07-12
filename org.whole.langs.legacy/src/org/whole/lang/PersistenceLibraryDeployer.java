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

import java.io.File;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.java.codebase.JavaBuilderPersistenceKit;
import org.whole.lang.java.util.JavaStoreProducerBuilder;
import org.whole.lang.java.util.JavaStoreProducerBuilderOperation;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.AbstractFunctionLibraryDeployer;
import org.whole.lang.reflect.IDeployer;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ModelTemplate;
import org.whole.lang.util.IRunnable;
import org.whole.lang.util.ResourceUtils;
import org.whole.lang.util.StringUtils;
import org.whole.lang.xml.util.XmlStoreConsumerVisitor;
import org.whole.lang.xml.util.XmlStoreProducerBuilder;
import org.whole.lang.xml.util.XmlStoreProducerBuilderOperation;

import bsh.EvalError;
import bsh.Interpreter;

/**
 * @author Riccardo Solmi
 */
public class PersistenceLibraryDeployer extends AbstractFunctionLibraryDeployer {
	public static final String URI = "whole:org.whole.lang:PersistenceLibrary";

	@Override
	public int getDeployLevel() {
		return IDeployer.LEVEL_LANGUAGE_EXTENSION-1;//FIXME workaround
	}

	public void deploy(ReflectionFactory platform) {
		putFunctionLibrary(URI);

		putFunctionCode("stringToModel", stringToModelIterator());
		putFunctionCode("modelToString", modelToStringIterator());

		putFunctionCode("toJavaBuilderCompilationUnit", toJavaBuilderCompilationUnit());
		putFunctionCode("toJavaBuilderBlock", toJavaBuilderBlock());
		putFunctionCode("fromJavaBuilderModel", fromJavaBuilderModel());

		putFunctionCode("toXmlBuilderDocument", toXmlBuilderDocument());
		putFunctionCode("toXmlBuilderContent", toXmlBuilderContent());
		putFunctionCode("fromXmlBuilderModel", fromXmlBuilderModel());
	}

	public static IEntityIterator<IEntity> stringToModelIterator() {
		return IteratorFactory.instance.singleValuedRunnableIterator(
				(IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
					StringPersistenceProvider pp = new StringPersistenceProvider(selfEntity.wStringValue());
					
					IPersistenceKit persistenceKit = null;
					try {
						persistenceKit = derivePersistenceKit(bm, pp);
					} catch (Exception e) {
						throw new IllegalArgumentException("Failed to load the persistence kit", e);
					}
					try {
						bm.setResult(persistenceKit.readModel(pp));
					} catch (Exception e) {
						throw new IllegalArgumentException("Failed to load the resource with the given persistence: " + persistenceKit.getId(), e);
					}
				});
	}
	public static IEntityIterator<IEntity> modelToStringIterator() {
		return IteratorFactory.instance.singleValuedRunnableIterator(
				(IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
					StringPersistenceProvider pp = new StringPersistenceProvider();
					pp.getBindings().wDefValue("entityURI", selfEntity.wGetEntityDescriptor().getURI());

					IPersistenceKit persistenceKit = null;
					try {
						persistenceKit = derivePersistenceKit(bm, pp);
					} catch (Exception e) {
						throw new IllegalArgumentException("Failed to load the persistence kit", e);
					}
					try {
						persistenceKit.writeModel(selfEntity, pp);
					} catch (Exception e) {
						throw new IllegalArgumentException("Failed to load the resource with the given persistence: " + persistenceKit.getId(), e);
					}

					bm.setResult(BindingManagerFactory.instance.createValue(pp.getStore()));
				});
	}
	protected static IPersistenceKit derivePersistenceKit(IBindingManager bm, StringPersistenceProvider pp) {
		String persistenceKitId = null;

		if (bm.wIsSet("grammarURI")) {
			pp.getBindings().wDefValue("grammarURI", bm.wStringValue("grammarURI"));
			persistenceKitId = "org.whole.lang.grammars.codebase.GrammarsPersistenceKit";
		} else if (bm.wIsSet("persistenceId"))
			persistenceKitId = bm.wStringValue("persistenceId");
		
		if (bm.wIsSet("entityURI")) {
			String entityURI = bm.wStringValue("entityURI");
			pp.getBindings().wDefValue("entityURI", entityURI);
		}
		if (pp.getBindings().wIsSet("entityURI")) {
			String entityURI = pp.getBindings().wStringValue("entityURI");
			ILanguageKit languageKit = ResourceUtils.hasFragmentPart(entityURI) ?
					CommonsDataTypePersistenceParser.getEntityDescriptor(entityURI, true, bm).getLanguageKit()
					: ReflectionFactory.getLanguageKit(entityURI, true, bm);
			
			if (persistenceKitId == null)
				for (IPersistenceKit persistenceKit : languageKit.getPersistenceKits())
					if (!persistenceKit.isGeneric()) {
						persistenceKitId = persistenceKit.getId();
						break;
					}
			if (persistenceKitId == null)
				persistenceKitId = languageKit.getDefaultPersistenceKit().getId();
		}

		if (persistenceKitId == null)
			persistenceKitId = "org.whole.lang.xml.codebase.XmlBuilderPersistenceKit";

		if (!ReflectionFactory.hasPersistenceKit(persistenceKitId))
			throw new IllegalArgumentException("Missing persistence");
		return ReflectionFactory.getPersistenceKit(persistenceKitId);
	}

	public static IEntityIterator<IEntity> toJavaBuilderCompilationUnit() {
		return IteratorFactory.instance.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				if (bm.wIsSet("file")) {
					Object file = bm.wGetValue("file");
					if (file instanceof File)
						bm.wDefValue("className",
								StringUtils.stripFileExtension(((File) file).getName()));
				}
				if (bm.wIsSet("fileName"))//TODO test was !bm.wIsSet("className") && 
					bm.wDefValue("className", bm.wStringValue("fileName"));

				IEntity packageNameEntity = bm.wGet("packageName");
				String packageName = packageNameEntity != null ? packageNameEntity.wStringValue() : null;
				IEntity classNameEntity = bm.wGet("className");
				String className = classNameEntity != null ? bm.wStringValue("className") : "AnonymousClass";

				ModelBuilderOperation op = new ModelBuilderOperation();
				JavaStoreProducerBuilderOperation javaOp = new JavaStoreProducerBuilderOperation(op);

				((JavaStoreProducerBuilder) javaOp.wGetBuilder()).buildStartCompilationUnit(
						packageName, className, selfEntity.wGetEntityDescriptor().getEntityType().getName());
				new ModelTemplate(selfEntity).apply(javaOp);
				((JavaStoreProducerBuilder) javaOp.wGetBuilder()).buildEndCompilationUnit();

				bm.setResult(op.wGetResult());
			}
		});
	}
	public static IEntityIterator<IEntity> toJavaBuilderBlock() {
		return IteratorFactory.instance.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				ModelBuilderOperation op = new ModelBuilderOperation();
				JavaStoreProducerBuilderOperation javaOp = new JavaStoreProducerBuilderOperation(op);

				((JavaStoreProducerBuilder) javaOp.wGetBuilder()).buildStartBlock();
				new ModelTemplate(selfEntity).apply(javaOp);
				((JavaStoreProducerBuilder) javaOp.wGetBuilder()).buildEndBlock();

				bm.setResult(op.wGetResult());
			}
		});
	}
	//FIXME
	public static IEntityIterator<IEntity> fromJavaBuilderModel() {
		return IteratorFactory.instance.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				//TODO test selftEntity is a java model
				
				String javaText = PrettyPrinterOperation.toPrettyPrintString(selfEntity);
				
				Interpreter javaInterpreter = new Interpreter();
				javaInterpreter.setClassLoader(ReflectionFactory.getPlatformClassLoader());

				try {
					Object result = javaInterpreter.eval(JavaBuilderPersistenceKit.toBeanShellScript(javaText));
					if (result instanceof IEntity) {
						bm.setResult((IEntity) result);
						return;
					}
				} catch (EvalError e) {
				}
				
				bm.setResultIterator(IteratorFactory.instance.emptyIterator());
			}
		});
	}

	public static IEntityIterator<IEntity> toXmlBuilderDocument() {
		return IteratorFactory.instance.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				ModelBuilderOperation op = new ModelBuilderOperation();
				XmlStoreProducerBuilderOperation xmlOp = new XmlStoreProducerBuilderOperation(op);

				((XmlStoreProducerBuilder) xmlOp.wGetBuilder()).buildStartDocument();
				new ModelTemplate(selfEntity).apply(xmlOp);
				((XmlStoreProducerBuilder) xmlOp.wGetBuilder()).buildEndDocument();

				bm.setResult(op.wGetResult());
			}
		});
	}
	public static IEntityIterator<IEntity> toXmlBuilderContent() {
		return IteratorFactory.instance.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				ModelBuilderOperation op = new ModelBuilderOperation();
				XmlStoreProducerBuilderOperation xmlOp = new XmlStoreProducerBuilderOperation(op);

				((XmlStoreProducerBuilder) xmlOp.wGetBuilder()).buildStartContent();
				new ModelTemplate(selfEntity).apply(xmlOp);
				((XmlStoreProducerBuilder) xmlOp.wGetBuilder()).buildEndContent();

				bm.setResult(op.wGetResult());
			}
		});
	}
	public static IEntityIterator<IEntity> fromXmlBuilderModel() {
		return IteratorFactory.instance.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				try {
					ModelBuilderOperation op = new ModelBuilderOperation().withBindings(bm);
					new XmlStoreConsumerVisitor(op).visit(selfEntity);
					bm.setResult(op.wGetResult());
					return;
				} catch (Exception e) {
				}
				bm.setResultIterator(IteratorFactory.instance.emptyIterator());
			}
		});
	}
}
