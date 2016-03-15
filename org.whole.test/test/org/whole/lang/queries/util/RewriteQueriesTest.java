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
package org.whole.lang.queries.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.Name;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.util.TestXmlGrammar;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.codebase.ModelsModel;
import org.whole.lang.models.model.CompositeEntity;
import org.whole.lang.models.model.DataEntity;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.Features;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.ModelDeclarations;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ITemplateManager;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class RewriteQueriesTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
    public void testDelete1() {
		Model model = new ModelsModel().create();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("delete1");

		for (DataEntity dataEntity : BehaviorUtils.<DataEntity>compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(ModelsEntityDescriptorEnum.DataEntity, dataEntity));

		assertFalse(BehaviorUtils.compileAndLazyEvaluate(query, model).hasNext());
	}

    @Test
    public void testDelete2() {
		Grammar model = new TestXmlGrammar().create();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("delete2");

		for (Name name : BehaviorUtils.<Name>compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(GrammarsEntityDescriptorEnum.Name, name));

		for (IEntity name : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(EntityUtils.isResolver(name));
	}

    @Test
    public void testDelete3() {
		Grammar model = new TestXmlGrammar().create();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("delete3");

		for (IEntity entity : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(GrammarsEntityDescriptorEnum.Name, entity) ||
					EntityUtils.isResolver(entity));

		for (IEntity entity : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(EntityUtils.isResolver(entity));
	}

    @Test
    public void testUpdate1() {
		Model model = new ModelsModel().create();
		ModelDeclarations declarations = model.getDeclarations();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("update1");

		for (IEntity entity : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(ModelsEntityDescriptorEnum.SimpleName, entity) ||
					Matcher.match(ModelsEntityDescriptorEnum.DataType, entity));

		assertEquals("MyModelName", model.getName().getValue());

		int j=0;
		for (int i=0; i<declarations.wSize(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.DataEntity, decl)) {
				if (j++ == 0) {
					assertEquals("MyFirstName", ((DataEntity) decl).getName().getValue());
					assertEquals("MyFirstDataType", ((DataEntity) decl).getDataType().getValue());
				} else {
					assertEquals("MySecondName", ((DataEntity) decl).getName().getValue());
					return;
				}
			}
		}
	}

    @Test
    public void testUpdate2() {
		Model model = new ModelsModel().create();
		ModelDeclarations declarations = model.getDeclarations();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("update2");

		for (IEntity entity : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(ModelsEntityDescriptorEnum.SimpleName, entity) ||
					Matcher.match(ModelsEntityDescriptorEnum.DataType, entity));

		for (int i=0; i<declarations.wSize(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.DataEntity, decl)) {
				assertEquals("MyDataEntityName", ((DataEntity) decl).getName().getValue());
				assertEquals("MyDataType", ((DataEntity) decl).getDataType().getValue());
			}
		}
	}

    @Test
    public void testUpdate3() {
		Model model = new ModelsModel().create();
		ModelDeclarations declarations = model.getDeclarations();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("update3");

		List<String> names = new ArrayList<String>();
		for (int i=0; i<declarations.wSize(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.DataEntity, decl))
				names.add(((DataEntity) decl).getName().getValue());
		}

		for (IEntity entity : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(ModelsEntityDescriptorEnum.SimpleName, entity));

		Iterator<String> iterator = names.iterator();
		for (int i=0; i<declarations.wSize() && iterator.hasNext(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.SimpleEntity, decl))
				assertEquals(iterator.next(), ((SimpleEntity) decl).getName().getValue());
		}
	}

    @Test
    public void testUpdate4() {
		Model model = new ModelsModel().create();
		ModelDeclarations declarations = model.getDeclarations();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("update4");

		List<String> dataEntityNames = new ArrayList<String>();
		for (int i=0; i<declarations.wSize(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.DataEntity, decl))
				dataEntityNames.add(((DataEntity) decl).getName().getValue());
		}

		for (IEntity entity : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(ModelsEntityDescriptorEnum.SimpleName, entity));

		Iterator<String> dataEntityNamesIterator = dataEntityNames.iterator();
		for (int i=0; i<declarations.wSize() && dataEntityNamesIterator.hasNext(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.SimpleEntity, decl))
				assertEquals(dataEntityNamesIterator.next(), ((SimpleEntity) decl).getName().getValue());
		}

		for (int i=0; i<declarations.wSize(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.DataEntity, decl))
				assertTrue(EntityUtils.isResolver(((DataEntity) decl).getName()));
		}
	}

    @Test
    public void testUpdate5() {
		Model model = new ModelsModel().create();
		ModelDeclarations declarations = model.getDeclarations();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("update5");

		List<String> dataEntityNames = new ArrayList<String>();
		for (int i=0; i<declarations.wSize(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.DataEntity, decl))
				dataEntityNames.add(((DataEntity) decl).getName().getValue());
		}

		for (IEntity entity : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(ModelsEntityDescriptorEnum.SimpleName, entity));

		Iterator<String> dataEntityNamesIterator = dataEntityNames.iterator();
		for (int i=0; i<declarations.wSize() && dataEntityNamesIterator.hasNext(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.SimpleEntity, decl))
				assertEquals(dataEntityNamesIterator.next(), ((SimpleEntity) decl).getName().getValue());
		}
		dataEntityNamesIterator = dataEntityNames.iterator();
		for (int i=0; i<declarations.wSize() && dataEntityNamesIterator.hasNext(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.CompositeEntity, decl))
				assertEquals(dataEntityNamesIterator.next(), ((CompositeEntity) decl).getName().getValue());
		}
	}

	@Test
    public void testUpdate6() {
		Model model = new ModelsModel().create();
		ModelDeclarations declarations = model.getDeclarations();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("update6");

		for (IEntity entity : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(ModelsEntityDescriptorEnum.SimpleName, entity));

		for (int i=0; i<declarations.wSize(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.DataEntity, decl))
				assertEquals("DataEntityName", ((DataEntity) decl).getName().getValue());
		}
	}

	@Test
    public void testUpdate7() {
		Model model = new ModelsModel().create();
		ModelDeclarations declarations = model.getDeclarations();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("update7");

		for (IEntity entity : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(ModelsEntityDescriptorEnum.SimpleName, entity));

		for (int i=0; i<declarations.wSize(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.DataEntity, decl))
				assertEquals("DataEntityName", ((DataEntity) decl).getName().getValue());
		}
	}

	@Test
    public void testUpdate8() {
		Model model = new ModelsModel().create();
		ModelDeclarations declarations = model.getDeclarations();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("update8");

		for (IEntity entity : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(ModelsEntityDescriptorEnum.DataEntity, entity));

		for (int i=0; i<declarations.wSize(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.DataEntity, decl)) {
				assertEquals("Object", ((DataEntity) decl).getDataType().getValue());
				assertTrue(((DataEntity) decl).getName().getValue().startsWith("My"));
			}
		}
	}

	@Test
    public void testUpdate9() {
		Model model = new ModelsModel().create();
		ModelDeclarations declarations = model.getDeclarations();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("update9");

		for (IEntity entity : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(ModelsEntityDescriptorEnum.DataEntity, entity));

		for (int i=0; i<declarations.wSize(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.DataEntity, decl)) {
				assertEquals("Object", ((DataEntity) decl).getDataType().getValue());
				assertTrue(((DataEntity) decl).getName().getValue().startsWith("My"));
			}
		}
	}

	@Test
    public void testUpdate10() {
		Model model = new ModelsModel().create();
		ModelDeclarations declarations = model.getDeclarations();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("update10");

		for (IEntity entity : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(ModelsEntityDescriptorEnum.SimpleName, entity));

		for (int i=0; i<declarations.wSize(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.DataEntity, decl)) {
				String name = ((DataEntity) decl).getName().getValue();
				assertEquals(StringUtils.toLowerCap(name), name);
			}
		}
	}

	@Test
    public void testUpdate11() {
		Model model = new ModelsModel().create();
		ModelDeclarations declarations = model.getDeclarations();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("update11");

		for (IEntity entity : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(ModelsEntityDescriptorEnum.SimpleName, entity) ||
					Matcher.match(ModelsEntityDescriptorEnum.DataType, entity));

		for (int i=0; i<declarations.wSize(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.DataEntity, decl)) {
				String name = ((DataEntity) decl).getName().getValue();
				assertEquals(StringUtils.toLowerCap(name), name);
				assertEquals("MyDataType", ((DataEntity) decl).getDataType().getValue());
			}
		}
	}

	@Test
    public void testInsert1() {
		Model model = new ModelsModel().create();
		ModelDeclarations declarations = model.getDeclarations();

		ITemplateManager tm = RewriteQueriesTemplateManager.instance();
		PathExpression query = (PathExpression) tm.create("insert1");

		for (IEntity entity : BehaviorUtils.compileAndLazyEvaluate(query, model))
			assertTrue(Matcher.match(ModelsEntityDescriptorEnum.Feature, entity));

		for (int i=0; i<declarations.wSize(); i++) {
			IEntity decl = declarations.wGet(i);
			if (Matcher.match(ModelsEntityDescriptorEnum.SimpleEntity, decl)) {
				Features features = ((SimpleEntity) decl).getFeatures();
				int size = features.wSize();
				assertTrue(size >= 2);
				String name1 = ((Feature) features.wGet(size-2)).getName().getValue();
				assertEquals("n1", name1);
				String name2 = ((Feature) features.wGet(size-1)).getName().getValue();
				assertEquals("n2", name2);
			}
		}
	}
}
