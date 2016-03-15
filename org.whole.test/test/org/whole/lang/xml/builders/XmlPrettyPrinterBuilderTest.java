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
package org.whole.lang.xml.builders;

import static org.whole.lang.operations.PrettyPrinterOperation.toPrettyPrintString;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.codebase.StreamPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.codebase.BPELModel;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ModelTemplate;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;
import org.whole.lang.xml.codebase.XmlPrettyPrinterBuilderOperation;
import org.whole.lang.xml.codebase.XmlSourcePersistenceKit;
import org.whole.lang.xml.reflect.XmlLanguageKit;
import org.whole.lang.xml.util.XmlStoreProducerBuilder;
import org.whole.lang.xml.util.XmlStoreProducerBuilderOperation;

public class XmlPrettyPrinterBuilderTest {

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	private void comparePrettyPrints(String filename) throws Exception {
		IEntity model = XmlSourcePersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getClass().getResourceAsStream(filename)));
		StringWriter stringWriter = new StringWriter();
		XmlPrettyPrinterBuilderOperation xppbop = new XmlPrettyPrinterBuilderOperation(new PrintWriter(stringWriter, true));
		new ModelTemplate(model).apply(new XmlGenericBuilderAdapter((IXmlBuilder) xppbop.wGetBuilder(XmlLanguageKit.URI)));

		assertEquals(toPrettyPrintString(model), stringWriter.toString());
	}

	@Test
    public void testConformanceWithVisitor() throws Exception {
		comparePrettyPrints("read.xml");
		comparePrettyPrints("../../xsd/util/wsbpel_2_0.xsd");
		comparePrettyPrints("testwspace.xml");
	}

	public void _testPerformance() {
		IEntity model = new BPELModel().create();

		PrintStream nullPrintStream = new PrintStream(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				// do nothing
			}
		});

		try {
			long timestamp = new Date().getTime(); 
			for (int i=0; i<1000; i++) {
				XmlPrettyPrinterBuilderOperation op = new XmlPrettyPrinterBuilderOperation(new PrintWriter(nullPrintStream));
				XmlStoreProducerBuilderOperation xmlOp = new XmlStoreProducerBuilderOperation(op);
				((XmlStoreProducerBuilder) xmlOp.wGetBuilder()).buildStartDocument();
				new ModelTemplate(model).apply(xmlOp);
				((XmlStoreProducerBuilder) xmlOp.wGetBuilder()).buildEndDocument();
			}
			long timediff = new Date().getTime() - timestamp;
			System.out.println("PrettyPrinterBuilder elapsed time: "+timediff+"ms");
	
			timestamp = new Date().getTime();
			for (int i=0; i<1000; i++)
				XmlBuilderPersistenceKit.instance().writeModel(model,
						new StreamPersistenceProvider(nullPrintStream));
			timediff = new Date().getTime() - timestamp;
			System.out.println("PrettyPrinterVisitor elapsed time: "+timediff+"ms");

		} catch (Exception e) {
			fail();
		}
	}
}
