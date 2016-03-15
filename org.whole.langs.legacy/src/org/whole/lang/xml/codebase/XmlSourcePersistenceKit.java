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
package org.whole.lang.xml.codebase;

import org.whole.lang.codebase.AbstractSpecificPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xml.model.Encoding;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.xml.reflect.XmlLanguageKit;
import org.whole.lang.xml.util.SaxConsumerHandler;
import org.whole.lang.xml.util.XmlUtils;

/**
 * @author Riccardo Solmi
 */
public class XmlSourcePersistenceKit extends AbstractSpecificPersistenceKit {
	private static class SingletonHolder {
		private static final XmlSourcePersistenceKit instance = new XmlSourcePersistenceKit();
	}
	public static final XmlSourcePersistenceKit instance() {
		return SingletonHolder.instance;
	}
	private XmlSourcePersistenceKit() {
		super("XML", "xml", XmlLanguageKit.URI);
	}

	public boolean isMultilanguage() {
		return false;
	}

	protected void doInitDefaultEncoding(IEntity model, IPersistenceProvider pp) throws Exception {
		String encoding = getDefaultEncoding();

		if (model == null)
			encoding = XmlUtils.guessEncoding(pp.getInputStream(), encoding);
		else if (model != null && Matcher.matchImpl(XmlEntityDescriptorEnum.Document, model))  {
			Encoding encodingEntity = Matcher.find(XmlEntityDescriptorEnum.Encoding,
					model.wGet(XmlFeatureDescriptorEnum.prolog), false);
			if (encodingEntity != null)
				encoding = EntityUtils.safeStringValue(encodingEntity, encoding);
		}

		pp.withDefaultEncoding(encoding);
	}
	protected String getDefaultEncoding() {
		return "UTF-8";
	}

	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		return NormalizerOperation.normalize(
				SaxConsumerHandler.parse(pp.getInputStream(), pp.getEncoding()));
	}

	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		PrettyPrinterOperation.prettyPrint(model, pp.getOutputStream(), pp.getEncoding());
	}
}
