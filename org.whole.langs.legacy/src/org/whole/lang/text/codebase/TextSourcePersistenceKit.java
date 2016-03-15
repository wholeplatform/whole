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
package org.whole.lang.text.codebase;

import org.whole.lang.codebase.AbstractSpecificPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.text.factories.TextEntityFactory;
import org.whole.lang.text.model.IRow;
import org.whole.lang.text.model.Row;
import org.whole.lang.text.reflect.TextLanguageKit;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class TextSourcePersistenceKit extends AbstractSpecificPersistenceKit {
	private static class SingletonHolder {
		private static final TextSourcePersistenceKit instance = new TextSourcePersistenceKit();
	}
	public static final TextSourcePersistenceKit instance() {
		return SingletonHolder.instance;
	}
	private TextSourcePersistenceKit() {
		super("Text", "text", TextLanguageKit.URI);
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

	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
        String[] strRows = StringUtils.readAsStringRows(pp.getInputStream(), pp.getEncoding());
        TextEntityFactory lf = TextEntityFactory.instance;
        
        IRow[] rows = new Row[strRows.length];
        for (int i=0; i<rows.length; i++)
            rows[i] = lf.createRow(lf.createText(strRows[i]));
        return lf.createDocument(rows);
	}

	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		if (!model.wGetLanguageKit().getURI().equals(TextLanguageKit.URI))
			throw new IllegalArgumentException("A Text model is required. Was: "+model.wGetLanguageKit());

		PrettyPrinterOperation.prettyPrint(model, pp.getOutputStream(), pp.getEncoding());
	}
}
