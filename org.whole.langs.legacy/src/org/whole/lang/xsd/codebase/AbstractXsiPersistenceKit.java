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
package org.whole.lang.xsd.codebase;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.codebase.AbstractGenericPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.templates.ITemplate;
import org.whole.lang.xml.codebase.XmlNormalizerBuilderOperation;
import org.whole.lang.xml.codebase.XmlPrettyPrinterBuilderOperation;
import org.whole.lang.xml.util.SaxConsumerHandler;
import org.whole.lang.xml.util.XmlUtils;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractXsiPersistenceKit extends AbstractGenericPersistenceKit {
	public AbstractXsiPersistenceKit(String name, String fileExtension) {
		super(name, fileExtension);
	}

	@Override
	public boolean isGeneric() {
		return false;
	}
	@Override
	public boolean canApply(ILanguageKit languageKit) {
		throw new IllegalStateException();
	}

	@Override
	protected void doInitDefaultEncoding(IEntity model, IPersistenceProvider pp) throws Exception {
		String encoding = getDefaultEncoding();

		if (model == null)
			encoding = XmlUtils.guessEncoding(pp.getInputStream(), encoding);

		pp.withDefaultEncoding(encoding);
	}

	@Override
	protected String getDefaultEncoding() {
		return "UTF-8";
	}
	
	@Override
	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		IBindingManager bm = pp.getBindings();

		ModelBuilderOperation mop = new ModelBuilderOperation(RegistryConfigurations.RESOLVER);
		IBuilderOperation xsiBuilderOperation = getBuilderOperation(mop, bm);
		bm.wDefValue("mergeCDataSect", true);
		XmlNormalizerBuilderOperation normalizerOp = new XmlNormalizerBuilderOperation(xsiBuilderOperation, bm);
		SaxConsumerHandler.parse(pp.getInputStream(), pp.getEncoding(), normalizerOp);
		return mop.wGetResult();
	}

	protected abstract IBuilderOperation getBuilderOperation(IBuilderOperation targetOperation, IBindingManager bindingManager);

	@Override
	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(pp.getOutputStream(), pp.getEncoding()));
		XmlPrettyPrinterBuilderOperation op = new XmlPrettyPrinterBuilderOperation(printWriter);
		ITemplate template = getXsiModelTemplate(model, pp.getEncoding());
		template.apply(op);
		printWriter.flush();
	}

	protected abstract ITemplate getXsiModelTemplate(IEntity model, String encoding);
}
