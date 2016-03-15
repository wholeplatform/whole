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
package org.whole.lang.html.codebase;

import nu.validator.htmlparser.common.XmlViolationPolicy;
import nu.validator.htmlparser.sax.HtmlParser;

import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.codebase.AbstractSpecificPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.xml.util.SaxConsumerHandler;
import org.whole.langs.legacy.LegacyMetaModelsDeployer;
import org.xml.sax.InputSource;

/**
 * @author Enrico Persiani
 */
public class HtmlPersistenceKit extends AbstractSpecificPersistenceKit {
	private static class SingletonHolder {
		private static final HtmlPersistenceKit instance = new HtmlPersistenceKit();
	}
	public static final HtmlPersistenceKit instance() {
		return SingletonHolder.instance;
	}
	private HtmlPersistenceKit() {
		super("HTML5", "html", LegacyMetaModelsDeployer.HTML5_URI);
	}

	public boolean isMultilanguage() {
		return false;
	}

	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		ModelBuilderOperation op = new ModelBuilderOperation();
		SaxConsumerHandler saxHandler = new SaxConsumerHandler(op, false);

		HtmlParser parser = new HtmlParser(XmlViolationPolicy.ALLOW);
        parser.setContentHandler(saxHandler);
        parser.setProperty("http://xml.org/sax/properties/lexical-handler", saxHandler);
        parser.parse(new InputSource(pp.getInputStream()));

        IEntity xhtmlDocument = NormalizerOperation.normalize(op.wGetResult());
		return BehaviorUtils.apply("whole:org.whole.lang.html:HTML5Semantics#toHtml", xhtmlDocument);
	}

	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		PrettyPrinterOperation.prettyPrint(model, pp.getOutputStream(), pp.getEncoding());
	}
}
