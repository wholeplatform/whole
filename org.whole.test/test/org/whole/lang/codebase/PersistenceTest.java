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
package org.whole.lang.codebase;


import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createResolver;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.java.util.JavaStoreProducerBuilder;
import org.whole.lang.java.util.JavaStoreProducerBuilderOperation;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.misc.codebase.WholeLanguage;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.codebase.ModelsModel;
import org.whole.lang.models.codebase.TestEntities;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.properties.model.Properties;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.properties.util.PropertiesUtils;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ModelTemplate;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xml.codebase.XmlSourcePersistenceKit;
import org.whole.lang.xml.model.Document;
import org.whole.lang.xml.util.SaxConsumerHandler;
import org.whole.lang.xml.util.SaxHandlerBuilderOperation;
import org.whole.lang.xml.util.XmlStoreConsumerBuilderOperation;
import org.whole.lang.xml.util.XmlStoreConsumerVisitor;
import org.whole.lang.xml.util.XmlStoreProducerBuilder;
import org.whole.lang.xml.util.XmlStoreProducerBuilderOperation;
import org.xml.sax.SAXException;

/**
 * @author Riccardo Solmi
 */
public class PersistenceTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
    public void testSingleBuilder2Java() {
		ModelBuilderOperation op = new ModelBuilderOperation();

		JavaStoreProducerBuilderOperation javaOp = new JavaStoreProducerBuilderOperation(op);
		((JavaStoreProducerBuilder) javaOp.wGetBuilder()).buildStartCompilationUnit("test", "Test");

		
		try {
			Properties props = PropertiesUtils.translate(System.getProperties());
			props.getEntries().wAdd(0, createResolver(PropertiesEntityDescriptorEnum.Property));
			new ModelTemplate(props).apply(javaOp);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		new TopDownTraversal(new ModelsModel().create()).apply(javaOp);
		
		((JavaStoreProducerBuilder) javaOp.wGetBuilder()).buildEndCompilationUnit();

//		new ModelsModel().apply(new JavaStoreProducerBuilderOperation(op));
		
		IEntity model = op.wGetResult();
		PrettyPrinterOperation.prettyPrint(model);
	}

    @Test
    public void testSingleBuilder2Xml() {
		ModelBuilderOperation op = new ModelBuilderOperation();

		new ModelsModel().apply(new XmlStoreProducerBuilderOperation(op));
		
		IEntity xmlModel = op.wGetResult();
		PrettyPrinterOperation.prettyPrint(xmlModel);
	}
    @Test
    public void testSingleModel2Xml() {
		ModelBuilderOperation op = new ModelBuilderOperation();

		IEntity model = new ModelsModel().create();
		new ModelTemplate(model).apply(new XmlStoreProducerBuilderOperation(op));

		IEntity xmlModel = op.wGetResult();
		PrettyPrinterOperation.prettyPrint(xmlModel);
	}

    @Test
    public void testMultipleBuilders2Xml() {
		ModelBuilderOperation op = new ModelBuilderOperation();
		XmlStoreProducerBuilderOperation xmlOp = new XmlStoreProducerBuilderOperation(op);
		((XmlStoreProducerBuilder) xmlOp.wGetBuilder()).buildStartDocument();
		new WholeLanguage().apply(xmlOp);
		((XmlStoreProducerBuilder) xmlOp.wGetBuilder()).buildEndDocument();
		IEntity xmlModel = op.wGetResult();

		PrettyPrinterOperation.prettyPrint(xmlModel);
	}

    @Test
    public void testXmlModel2Builder() throws ParserConfigurationException, SAXException, IOException {
		IEntity xmlModel = SaxConsumerHandler.parse(this.getClass().getResourceAsStream("persistenceTest.xwl"), "UTF-8", true);
		ModelBuilderOperation op = new ModelBuilderOperation();
		new XmlStoreConsumerVisitor(op).visit(xmlModel);
		
		PrettyPrinterOperation.prettyPrint(op.wGetResult());
	}

    public void _testXml2Builder() throws ParserConfigurationException, SAXException, IOException {
		ModelBuilderOperation op = new ModelBuilderOperation();
		SaxConsumerHandler.parse(
				this.getClass().getResourceAsStream("persistenceTest.xwl"), "UTF-8", true,
				new XmlStoreConsumerBuilderOperation(op));
	}
	
    @Test
    public void testXMLPersistence() {
		IEntity model1 = new TestEntities().create();
		IEntity model2 = xmlRoundtrip(model1);
		assertTrue(Matcher.match(model1, model2));
		
		model1 = new ModelsModel().create();
		model2 = xmlRoundtrip(model1);
		assertTrue(Matcher.match(model1, model2));
		
		model1 = new WholeLanguage().create();
		model2 = xmlRoundtrip(model1);
		assertTrue(Matcher.match(model1, model2));
	}

	private IEntity xmlRoundtrip(IEntity model1) {
		ModelBuilderOperation op = new ModelBuilderOperation();
		XmlStoreProducerBuilderOperation xmlOp = new XmlStoreProducerBuilderOperation(op);
		((XmlStoreProducerBuilder) xmlOp.wGetBuilder()).buildStartDocument();
		new ModelTemplate(model1).apply(xmlOp);
		((XmlStoreProducerBuilder) xmlOp.wGetBuilder()).buildEndDocument();
		IEntity xmlModel = op.wGetResult();

		op = new ModelBuilderOperation();
		new XmlStoreConsumerVisitor(op).visit(xmlModel);
		IEntity model2 = op.wGetResult();
		return model2;
	}

	@Test
    public void testSaxHandlerBuilder() throws Exception {
		Document xmlModel = (Document) XmlSourcePersistenceKit.instance().readModel(
				new ClasspathPersistenceProvider("org/whole/lang/xsd/util/javaee_web_services_client_1_2.xsd"));

		ModelBuilderOperation op = new ModelBuilderOperation();
		SaxConsumerHandler saxHandler = new SaxConsumerHandler(op, !EntityUtils.isResolver(xmlModel.getProlog().getXmlDecl()));
		SaxHandlerBuilderOperation sbop = new SaxHandlerBuilderOperation(saxHandler, saxHandler);
		new ModelTemplate(xmlModel).apply(sbop);

		assertTrue(Matcher.match(op.wGetResult(), xmlModel));
	}
}
