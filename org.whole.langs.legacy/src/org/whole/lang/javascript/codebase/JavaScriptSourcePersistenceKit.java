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
package org.whole.lang.javascript.codebase;

import org.whole.lang.codebase.AbstractSpecificPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.javascript.reflect.JavaScriptLanguageKit;
import org.whole.lang.javascript.util.RhinoTransformerVisitor;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class JavaScriptSourcePersistenceKit extends AbstractSpecificPersistenceKit {
	private static class SingletonHolder {
		private static final JavaScriptSourcePersistenceKit instance = new JavaScriptSourcePersistenceKit();
	}
	public static final JavaScriptSourcePersistenceKit instance() {
		return SingletonHolder.instance;
	}
	private JavaScriptSourcePersistenceKit() {
		super("JS", "js", JavaScriptLanguageKit.URI);
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
		return RhinoTransformerVisitor.transform(pp);
	}

	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		PrettyPrinterOperation.prettyPrint(model, pp.getOutputStream(), pp.getEncoding());
	}
}
