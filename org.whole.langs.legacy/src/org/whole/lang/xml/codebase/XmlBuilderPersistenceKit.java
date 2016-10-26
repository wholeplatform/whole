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

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.codebase.AbstractGenericPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ModelTemplate;
import org.whole.lang.xml.util.SaxConsumerHandler;
import org.whole.lang.xml.util.XmlStoreConsumerVisitor;
import org.whole.lang.xml.util.XmlStoreProducerBuilder;
import org.whole.lang.xml.util.XmlStoreProducerBuilderOperation;
import org.whole.lang.xml.util.XmlUtils;

/**
 * @author Riccardo Solmi
 */
public class XmlBuilderPersistenceKit extends AbstractGenericPersistenceKit {
	private static class SingletonHolder {
		private static final XmlBuilderPersistenceKit instance = new XmlBuilderPersistenceKit();
	}
	public static final XmlBuilderPersistenceKit instance() {
		return SingletonHolder.instance;
	}
	private XmlBuilderPersistenceKit() {
		super("XML (Whole Builder Persistence)", "xwl");
	}

	protected void doInitDefaultEncoding(IEntity model, IPersistenceProvider pp) throws Exception {
		String encoding = getDefaultEncoding();

		if (model == null)
			encoding = XmlUtils.guessEncoding(pp.getInputStream(), encoding);

		pp.withDefaultEncoding(encoding);
	}

	protected String getDefaultEncoding() {
		return "UTF-8";
	}

	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		IEntity xmlModel = SaxConsumerHandler.parse(pp.getInputStream(), pp.getEncoding());
		ModelBuilderOperation op = new ModelBuilderOperation().withBindings(pp.getBindings());
		new XmlStoreConsumerVisitor(op).visit(xmlModel);
		return ReflectionFactory.makeRootEntity(op.wGetResult());
	}

	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(
				pp.getOutputStream(), pp.getEncoding()));

		XmlPrettyPrinterBuilderOperation op = new XmlPrettyPrinterBuilderOperation(printWriter);
		XmlStoreProducerBuilderOperation xmlOp = new XmlStoreProducerBuilderOperation(op);

		((XmlStoreProducerBuilder) xmlOp.wGetBuilder()).buildStartDocument();
		new ModelTemplate(model).apply(xmlOp);
		((XmlStoreProducerBuilder) xmlOp.wGetBuilder()).buildEndDocument();

		printWriter.flush();
	}
}
