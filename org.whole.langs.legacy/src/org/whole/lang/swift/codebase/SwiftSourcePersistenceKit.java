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
package org.whole.lang.swift.codebase;

import org.whole.lang.codebase.AbstractSpecificPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.swiftsyntax.codebase.SwiftSyntaxSourcePersistenceKit;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class SwiftSourcePersistenceKit extends AbstractSpecificPersistenceKit {

	private static class SingletonHolder {
		private static final SwiftSourcePersistenceKit instance = new SwiftSourcePersistenceKit();
	}
	public static final SwiftSourcePersistenceKit instance() {
		return SingletonHolder.instance;
	}
	private SwiftSourcePersistenceKit() {
		super("Swift", "swift", "whole:org.whole.lang.swift:SwiftModel");
	}

	public boolean isMultilanguage() {
		return false;
	}

	protected void doInitDefaultEncoding(IEntity model, IPersistenceProvider pp) throws Exception {
		String encoding = getDefaultEncoding();

		if (model == null)
			encoding = StringUtils.encodingFromBOM(pp.getInputStream(), encoding);

		pp.withDefaultEncoding(encoding);
	}
	protected String getDefaultEncoding() {
		return "UTF-8";
	}

	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		IEntity swiftSyntax = ReflectionFactory.getPersistenceKit(SwiftSyntaxSourcePersistenceKit.class.getName()).readModel(pp);
		return BehaviorUtils.apply("whole:org.whole.lang.swift:SwiftMigrations#migrateSyntax", swiftSyntax);
	}

	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		IEntity syntaxModel = BehaviorUtils.apply("whole:org.whole.lang.swift:SwiftMigrations#migrateAST", model);
		pp.getBindings().wDefValue(SwiftSyntaxSourcePersistenceKit.FORMAT_PARAM, true);
		ReflectionFactory.getPersistenceKit(SwiftSyntaxSourcePersistenceKit.class.getName()).writeModel(syntaxModel, pp);
	}
}
