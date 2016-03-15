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
package org.whole.gen;

import java.util.List;

import static org.junit.Assert.*;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.gen.lang.reflect.GenOperationsDeployer;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.codebase.ArtifactsModel;
import org.whole.lang.operations.JavaCompilerOperation;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * 
 * @author Enrico Persiani
 */
public class JavaGeneratorTest {

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
		ReflectionFactory.deploy(GenOperationsDeployer.class);
	}

    @Test
    public void testGenerateJava() throws Exception {
		IEntity artifactsModel = new ArtifactsModel().create();
		assertNotNull(artifactsModel);

		List<CompilationUnit> cuList = JavaCompilerOperation.compile(
				artifactsModel, BindingManagerFactory.instance.createArguments());
    	assertTrue(cuList.size() > 0);
	}
}
