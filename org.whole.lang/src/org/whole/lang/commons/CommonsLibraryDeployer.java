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
package org.whole.lang.commons;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.AbstractMultiValuedRunnableIterator;
import org.whole.lang.iterators.AbstractSingleValuedRunnableIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.AbstractFunctionLibraryDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class CommonsLibraryDeployer extends AbstractFunctionLibraryDeployer {
	public static final String URI = "whole:org.whole.lang:CommonsLibrary";

	public void deploy(ReflectionFactory platform) {
		try {
			putFunctionLibrary(URI);
		} catch (IllegalArgumentException e) {
			//FIXME missing domain library resource
		}

		putFunctionCode("constantStageUpFragmentCompiler", constantStageUpFragmentCompilerIterator());
		putFunctionCode("stageUpFragmentCompiler", stageUpFragmentCompilerIterator());
		putFunctionCode("stageUpFragmentAtStage0", stageUpFragmentAtStage0Iterator());
	}

	public static IEntityIterator<IEntity> constantStageUpFragmentCompilerIterator() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				selfEntity = EntityUtils.clone(selfEntity);
				IEntity rootEntity = selfEntity.wGetRoot();
				
				bm.setResult(BindingManagerFactory.instance.createValue(
						IteratorFactory.chooseIterator(
								IteratorFactory.ifIterator(
										IteratorFactory.atStageIterator(0),
										IteratorFactory.constantIterator(rootEntity, true)),
								IteratorFactory.templateInterpreterIterator(selfEntity)
						)
				));
			}
		};
	}

	public static IEntityIterator<IEntity> stageUpFragmentCompilerIterator() {
		return new AbstractSingleValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				selfEntity = EntityUtils.clone(selfEntity);
				IEntity rootEntity = selfEntity.wGetRoot();
				
				bm.setResult(BindingManagerFactory.instance.createValue(
						IteratorFactory.chooseIterator(
								IteratorFactory.ifIterator(IteratorFactory.atStageIterator(0),
										IteratorFactory.composeIterator(
												IteratorFactory.functionApplicationIterator(URI+"#stageUpFragmentAtStage0"),
												IteratorFactory.constantIterator(rootEntity, true))),
								IteratorFactory.templateInterpreterIterator(selfEntity)
						)
				));
			}
		};
	}

	public static IEntityIterator<IEntity> stageUpFragmentAtStage0Iterator() {
		return new AbstractMultiValuedRunnableIterator<IEntity>() {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResultIterator(
						IteratorFactory.chooseIterator(
							IteratorFactory.ifIterator(
									IteratorFactory.constantIterator(BindingManagerFactory.instance.createValue(false), true),
									IteratorFactory.constantIterator(selfEntity, true)),
							IteratorFactory.cloneIterator(IteratorFactory.functionApplicationIterator(URI+"#stageUpFragmentAtStage0"))//FIXME IteratorFactory.recursiveFunctionApplicationIterator())
						)
				);
			}
		};
	}
}

