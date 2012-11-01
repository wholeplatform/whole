/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.grammars.util;

import java.io.InputStream;
import java.nio.charset.Charset;

import junit.framework.TestCase;

import org.whole.lang.codebase.StreamPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.grammars.codebase.GrammarsRegistry;
import org.whole.lang.grammars.codebase.XmlGrammar;
import org.whole.lang.grammars.factories.GrammarsEntityFactory;
import org.whole.lang.grammars.model.DataTerminal;
import org.whole.lang.grammars.model.Format;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.LiteralTerminal;
import org.whole.lang.grammars.model.Name;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Pattern;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Productions;
import org.whole.lang.grammars.model.Repeat;
import org.whole.lang.grammars.model.Rule;
import org.whole.lang.grammars.model.TargetLanguage;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.ComponentModifierEnum;
import org.whole.lang.models.model.EntityModifierEnum;
import org.whole.lang.models.model.FeatureModifierEnum;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.StringUtils;
import org.whole.lang.xml.codebase.XmlSourcePersistenceKit;
import org.whole.lang.xml.factories.XmlEntityFactory;
import org.whole.lang.xml.model.Element;

/**
 * @author Riccardo Solmi
 */
public class GrammarsUtilsTest extends TestCase {
	private String testGrammarURI;
	private String xmlGrammarURI;

	protected void setUp() throws Exception {
		ReflectionFactory.deployWholePlatform();
		Grammar testGrammar1 = new TestGrammar1().create();
		testGrammarURI = testGrammar1.getUri().getValue();
		if (!GrammarsRegistry.instance().containsGrammar(testGrammarURI))
			InterpreterOperation.interpret(testGrammar1);
		Grammar xmlGrammar = new XmlGrammar().create();
		xmlGrammarURI = xmlGrammar.getUri().getValue();
		if (!GrammarsRegistry.instance().containsGrammar(xmlGrammarURI))
			InterpreterOperation.interpret(xmlGrammar);
	}

	public void testNormalizer() throws Exception {
		Grammar testGrammar = NormalizerOperation.normalize(new TestGrammar().create());
		Grammar testGrammarNormalized = new TestGrammarNormalized().create();

		assertTrue(Matcher.match(testGrammarNormalized, testGrammar));
	}

	public void testParseSingleLiteral() {
		IEntity result = GrammarsUtils.parse(
				"a literal terminal", testGrammarURI, "SingleLiteral");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "SingleLiteral");
	}

	public void testParseSinglePatternLiteral() {
		IEntity result = GrammarsUtils.parse(
				"a1b2C3de", testGrammarURI, "SinglePatternLiteral");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "SinglePatternLiteral");
	}

	public void testParseLiteralSequence() {
		IEntity result = GrammarsUtils.parse(
				"BEGINA666,12,23,34END", testGrammarURI, "LiteralSequence");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "LiteralSequence");
	}

	public void testParseSingleData() {
		IEntity result = GrammarsUtils.parse(
				"a string", testGrammarURI, "SingleData");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "SingleData");
		assertEquals(result.wStringValue(), "a string");
	}

	public void testParseDataSequence() {
		IEntity result = GrammarsUtils.parse(
				"(A125,732)", testGrammarURI, "DataSequence");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "DataSequence");
		assertEquals(result.wGet(0).wStringValue(), "A");
		assertEquals(DataTypeUtils.getAsPersistenceString(result.wGet(1)), "125");
		assertEquals(DataTypeUtils.getAsPersistenceString(result.wGet(2)), "732");    	
	}

	public void testParseDataSequenceWithDatatypes() {
		IEntity result = GrammarsUtils.parse(
				"(A125,732)", testGrammarURI, "DataSequenceWithDataTypes");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "DataSequenceWithDataTypes");
		assertEquals(result.wGet(0).wCharValue(), 'A');
		assertEquals(result.wGet(1).wIntValue(), 125);
		assertEquals(result.wGet(2).wIntValue(), 732); 	
	}

	public void testParseOptionalLiteral() {
		IEntity result1 = GrammarsUtils.parse(
				"an optional literal terminal", testGrammarURI, "OptionalLiteral");
		assertNotNull(result1);
		assertEquals(result1.wGetEntityDescriptor().getName(), "OptionalLiteral");

		IEntity result2 = GrammarsUtils.parse(
				"a literal terminal", testGrammarURI, "OptionalLiteral");
		assertNotNull(result2);
		assertEquals(result2.wGetEntityDescriptor().getName(), "OptionalLiteral");
	}

	public void testParseUnparseOptionalConcatenate() {
		String source = "an optional concatenate";

		IEntity result1 = GrammarsUtils.parse(source, testGrammarURI, "OptionalConcatenate");
		assertNotNull(result1);
		assertEquals(result1.wGetEntityDescriptor().getName(), "OptionalConcatenate");
		
		StringBuilder sb = new StringBuilder();
		GrammarsUtils.unparse(result1, sb, testGrammarURI);
		assertEquals(source, sb.toString());

		IEntity result2 = GrammarsUtils.parse("a concatenate", testGrammarURI, "OptionalConcatenate");
		assertNotNull(result2);
		assertEquals(result2.wGetEntityDescriptor().getName(), "OptionalConcatenate");
		
		sb.setLength(0);
		GrammarsUtils.unparse(result2, sb, testGrammarURI);
		assertEquals(source, sb.toString());
	}

	public void testParseRepeatedLiteral() {
		IEntity result;
		try {
			result = GrammarsUtils.parse("Message: .", testGrammarURI, "RepeatedLiteral");
			fail();
		} catch (Exception e) {
		}

		result = GrammarsUtils.parse("Message: bla.", testGrammarURI, "RepeatedLiteral");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "RepeatedLiteral");

		result = GrammarsUtils.parse(
				"Message: bla bla bla.", testGrammarURI, "RepeatedLiteral");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "RepeatedLiteral");

		try {
			result = GrammarsUtils.parse("Message: bla bla bla bla.", testGrammarURI, "RepeatedLiteral");
			fail();
		} catch (Exception e) {
		}
	}

	public void testParseRepeatedOptionalLiteral() {
		IEntity result = GrammarsUtils.parse(
				"Message: .", testGrammarURI, "RepeatedOptionalLiteral");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "RepeatedOptionalLiteral");

		result = GrammarsUtils.parse(
				"Message: bla.", testGrammarURI, "RepeatedOptionalLiteral");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "RepeatedOptionalLiteral");

		result = GrammarsUtils.parse(
				"Message: bla bla bla.", testGrammarURI, "RepeatedOptionalLiteral");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "RepeatedOptionalLiteral");

		try {
			result = GrammarsUtils.parse(
				"Message: bla bla bla bla.", testGrammarURI, "RepeatedOptionalLiteral");
			fail();
		} catch (Exception e) {
		}
	}

	public void testUnparseXmlElement() {
		XmlEntityFactory xf = XmlEntityFactory.instance;

		Element e = xf.createElement(
				xf.createQualifiedName(
						xf.createNameSpace("ns"), xf.createName("tag")),
						xf.createAttributes(
								xf.createAttribute(xf.createName("attr"), xf.createValue("val")),
								xf.createAttribute(xf.createName("attr2"), xf.createValue("val2"))),
								xf.createCharData("test"));

		StringBuilder sb = new StringBuilder();
		GrammarsUtils.unparse(e, sb, xmlGrammarURI);
		assertEquals("<ns:tag attr=\"val\" attr2=\"val2\">test</ns:tag>", sb.toString());
	}

	//FIXME
	public void testUnparseXmlDocument() throws Exception {
		IEntity xmlDocument = XmlSourcePersistenceKit.instance().readModel(
				new StreamPersistenceProvider(getClass().getResourceAsStream("sample.xwl")));

		StringBuilder sb = new StringBuilder();
		GrammarsUtils.unparse(xmlDocument, sb, xmlGrammarURI);
		assertEquals("FIXME encoding and indentation", sb.toString());
	}


	//FIXME
	public void testParseXmlDocument() throws Exception {
		InputStream is = getClass().getResourceAsStream("smallSample.xwl");
		IEntity xmlDocument = XmlSourcePersistenceKit.instance().readModel(
				new StreamPersistenceProvider(is));
		is.close();

		is = getClass().getResourceAsStream("smallSample.xwl");
		String source = StringUtils.readAsString(is, Charset.defaultCharset().name());
		is.close();
		IEntity xmlDocumentUsingGrammar = GrammarsUtils.parse(source, xmlGrammarURI);

		assertTrue(Matcher.match(xmlDocument, xmlDocumentUsingGrammar));
	}

	public void testParseRepeatedUnboundedLiteral() {
		IEntity result = GrammarsUtils.parse(
				"Message: .", testGrammarURI, "RepeatedUnboundedLiteral");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "RepeatedUnboundedLiteral");

		result = GrammarsUtils.parse(
				"Message: bla.", testGrammarURI, "RepeatedUnboundedLiteral");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "RepeatedUnboundedLiteral");

		result = GrammarsUtils.parse(
				"Message: bla bla bla bla bla.", testGrammarURI, "RepeatedUnboundedLiteral");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "RepeatedUnboundedLiteral");
	}

	public void testParseChooseLiteral() {
		IEntity result = GrammarsUtils.parse(
				"My dog is sleeping.", testGrammarURI, "ChooseLiteral");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "ChooseLiteral");

		result = GrammarsUtils.parse(
				"My cat is sleeping.", testGrammarURI, "ChooseLiteral");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "ChooseLiteral");

		try {
			result = GrammarsUtils.parse(
					"My mouse is sleeping.", testGrammarURI, "ChooseLiteral");
			fail();
		} catch (Exception e) {
		}
	}

	private String getCSVData() {
		return "a string, an int, a char, a double\n"+
		"abcdefg,123,a,123.45\n"+ //TODO add spaces after commas
		"defghilm,45,b,789.1";
	}

	public void testParseCSVSimple() {
		IEntity result = GrammarsUtils.parse(getCSVData(), testGrammarURI, "CSVSimple");
		assertNotNull(result);
		assertEquals(result.wGetEntityDescriptor().getName(), "CSVSimple");
	}

	public void testGrammarToModelMapping() {
		Model m = new XmlModel().create();
		Grammar g = new XmlGrammar().create();

		Model m1 = GrammarsUtils.deriveModel(g, true);

		assertTrue(Matcher.match(m, m1));
	}

	
	public Grammar createGrammar(Name name, TargetLanguage targetLanguage,
			Productions lexicalStructure, Productions phraseStructure) {
		GrammarsEntityFactory gf = GrammarsEntityFactory.instance;
		return gf.buildGrammar()
			.set(GrammarsFeatureDescriptorEnum.name, name)
			.set(GrammarsFeatureDescriptorEnum.targetLanguage, targetLanguage)
			.set(GrammarsFeatureDescriptorEnum.lexicalStructure, lexicalStructure)
			.set(GrammarsFeatureDescriptorEnum.phraseStructure, phraseStructure)
			.getResult();
	}
	public LiteralTerminal createLiteralTerminal(String value) {
		GrammarsEntityFactory gf = GrammarsEntityFactory.instance;
		return gf.buildLiteralTerminal().set(GrammarsFeatureDescriptorEnum.literal, value).getResult();
	}
	public Production createProduction(NonTerminal name, Rule rule) {
		GrammarsEntityFactory gf = GrammarsEntityFactory.instance;
		return gf.create(GrammarsEntityDescriptorEnum.Production, name, rule);
	}
	public Repeat createRepeat(Rule rule) {
		GrammarsEntityFactory gf = GrammarsEntityFactory.instance;
		return gf.buildRepeat().set(GrammarsFeatureDescriptorEnum.rule, rule).getResult();
	}
	public DataTerminal createDataTerminal(Pattern pattern, Format format) {
		GrammarsEntityFactory gf = GrammarsEntityFactory.instance;
		return gf.buildDataTerminal().set(GrammarsFeatureDescriptorEnum.pattern, pattern).set(GrammarsFeatureDescriptorEnum.format, format).getResult();
	}

	public Grammar buildGrammar() {
		GrammarsEntityFactory gf = GrammarsEntityFactory.instance;

		Production data1 = createProduction(
				gf.createNonTerminal("MyDataNT1"),
				gf.createAs(
						createDataTerminal(
								gf.createRegExp(".*"), gf.createFormat("%s")),
								gf.createName("MyDataEntity1")));

		Production data2 = createProduction(
				gf.createNonTerminal("MyDataNT2"),
				gf.createAs(
						gf.createConcatenate(
								createLiteralTerminal("BEFORE_DELIMITER"),
								createDataTerminal(
										gf.createRegExp(".*"), gf.createFormat("%s")),
										createLiteralTerminal("AFTER_DELIMITER")),
										gf.createName("MyDataEntity2")));

		Production enum1 = createProduction(
				gf.createNonTerminal("MyEnumNT1"),
				gf.createAs(
						gf.createChoose(
								gf.createAs(createLiteralTerminal("L1"), gf.createName("V1")),
								createLiteralTerminal("V2"),
								gf.createAs(createLiteralTerminal("L3"), gf.createName("V3"))),
								gf.createName("MyEnumEntity1")));

		Production composite1 = createProduction(
				gf.createNonTerminal("MyCompositeNT1"),
				gf.createAs(
						createRepeat(gf.createNonTerminal("MyComponentNT")),
						gf.createName("MyCompositeEntity1")));

		Production composite2 = createProduction(
				gf.createNonTerminal("MyCompositeNT2"),
				gf.createAs(
						gf.createConcatenate(
								createLiteralTerminal("BEFORE_DELIMITER"),
								gf.createRepeat(
										gf.createSize(0), gf.createUnbounded(),
										createLiteralTerminal(","),//FIXME gf.createFormat(", "))),
										gf.createNonTerminal("MyComponentNT")),
										createLiteralTerminal("AFTER_DELIMITER")),
										gf.createName("MyCompositeEntity2")));

		Production simple1 = createProduction(
				gf.createNonTerminal("MySimpleNT1"),
				gf.createAs(
						gf.createConcatenate(
								gf.createAs(gf.createNonTerminal("MyEnumNT1"), gf.createName("feature1")),
								gf.createAs(gf.createNonTerminal("MyDataNT1"), gf.createName("feature2"))),
								gf.createName("MySimpleEntity1")));

		Production simple2 = createProduction(
				gf.createNonTerminal("MySimpleNT2"),
				gf.createAs(
						gf.createConcatenate(
								createLiteralTerminal("BEFORE_DELIMITER"),
								gf.createAs(gf.createNonTerminal("MyEnumNT1"), gf.createName("feature1")),

								gf.createOptional(
										gf.createConcatenate(
												createLiteralTerminal("FEATURE_DELIMITER"),
												gf.createAs(gf.createNonTerminal("MyDataNT1"), gf.createName("feature2")))),

												createLiteralTerminal("AFTER_DELIMITER")),
												gf.createName("MySimpleEntity2")));

		Production abstract1 = createProduction(
				gf.createNonTerminal("MyComponentNT"),
				gf.createAs(
						gf.createChoose(
								gf.createNonTerminal("MySimpleEntity1"),
								gf.createNonTerminal("MyDataNT1")),
								gf.createName("MyAbstractEntity1")));

		Production abstract2 = createProduction(
				gf.createNonTerminal("MyComponentNT2"),
				gf.createAs(
						gf.createConcatenate(
								gf.createAs(gf.createNonTerminal("MyEnumNT1"), gf.createName("inheritedFeature1")),
								gf.createAs(gf.createNonTerminal("MyDataNT1"), gf.createName("inheritedFeature2")),
								gf.createChoose(
										gf.createNonTerminal("MySimpleEntity1"),
										gf.createNonTerminal("MySimpleEntity2"))),
										gf.createName("MyAbstractEntity2")));

		return createGrammar(
				gf.createName("MyGrammar"), gf.createURI("MyLanguage"),
				gf.createProductions(),
				gf.createProductions(simple1, simple2, abstract1, abstract2, composite1, composite2, enum1, data1, data2));
	}

	public Model buildModel() {
		ModelsEntityFactory mf = ModelsEntityFactory.instance;

		return mf.createModel(
				mf.createSimpleName("MyLanguage"),
				mf.createTypeRelations(),
				mf.createModelDeclarations(
						mf.createSimpleEntity(
								mf.createEntityModifiers(),
								mf.createSimpleName("MySimpleEntity1"),
								mf.createTypes(
										mf.createSimpleName("MyAbstractEntity1"),
										mf.createSimpleName("MyAbstractEntity2")),
										mf.createFeatures(
												mf.createFeature(
														mf.createFeatureModifiers(),
														mf.createSimpleName("MyEnumEntity1"),
														mf.createSimpleName("feature1"),
														CommonsEntityAdapterFactory.createResolver(ModelsEntityDescriptorEnum.SimpleName)),
														mf.createFeature(
																mf.createFeatureModifiers(),
																mf.createSimpleName("MyDataEntity1"),
																mf.createSimpleName("feature2"),
																CommonsEntityAdapterFactory.createResolver(ModelsEntityDescriptorEnum.SimpleName)))),
																mf.createSimpleEntity(
																		mf.createEntityModifiers(),
																		mf.createSimpleName("MySimpleEntity2"),
																		mf.createTypes(mf.createSimpleName("MyAbstractEntity2")),
																		mf.createFeatures(
																				mf.createFeature(
																						mf.createFeatureModifiers(),
																						mf.createSimpleName("MyEnumEntity1"),
																						mf.createSimpleName("feature1"),
																						CommonsEntityAdapterFactory.createResolver(ModelsEntityDescriptorEnum.SimpleName)),
																						mf.createFeature(
																								mf.createFeatureModifiers(
																										mf.createFeatureModifier(FeatureModifierEnum.optional)),
																										mf.createSimpleName("MyDataEntity1"),
																										mf.createSimpleName("feature2"),
																										CommonsEntityAdapterFactory.createResolver(ModelsEntityDescriptorEnum.SimpleName)))),
																										mf.createSimpleEntity(
																												mf.createEntityModifiers(mf.createEntityModifier(EntityModifierEnum._abstract)),
																												mf.createSimpleName("MyAbstractEntity1"),
																												mf.createTypes(),
																												mf.createFeatures()),
																												mf.createSimpleEntity(
																														mf.createEntityModifiers(mf.createEntityModifier(EntityModifierEnum._abstract)),
																														mf.createSimpleName("MyAbstractEntity2"),
																														mf.createTypes(),
																														mf.createFeatures(
																																mf.createFeature(
																																		mf.createFeatureModifiers(),
																																		mf.createSimpleName("MyEnumEntity1"),
																																		mf.createSimpleName("inheritedFeature1"),
																																		CommonsEntityAdapterFactory.createResolver(ModelsEntityDescriptorEnum.SimpleName)),
																																		mf.createFeature(
																																				mf.createFeatureModifiers(),
																																				mf.createSimpleName("MyDataEntity1"),
																																				mf.createSimpleName("inheritedFeature2"),
																																				CommonsEntityAdapterFactory.createResolver(ModelsEntityDescriptorEnum.SimpleName)))),
																																				mf.createCompositeEntity(
																																						mf.createEntityModifiers(),
																																						mf.createSimpleName("MyCompositeEntity1"),
																																						mf.createTypes(),
																																						mf.createComponentModifiers(mf.createComponentModifier(ComponentModifierEnum.ordered)),
																																						mf.createSimpleName("MyAbstractEntity1")),
																																						mf.createCompositeEntity(
																																								mf.createEntityModifiers(),
																																								mf.createSimpleName("MyCompositeEntity2"),
																																								mf.createTypes(),
																																								mf.createComponentModifiers(mf.createComponentModifier(ComponentModifierEnum.unique)),
																																								mf.createSimpleName("MyAbstractEntity1")),
																																								mf.createEnumEntity(
																																										mf.createEntityModifiers(),
																																										mf.createSimpleName("MyEnumEntity1"),
																																										mf.createTypes(),
																																										mf.createEnumValues(
																																												mf.createEnumValue("V1"), mf.createEnumValue("V2"), mf.createEnumValue("V3"))),
																																												mf.createDataEntity(
																																														mf.createEntityModifiers(),
																																														mf.createSimpleName("MyDataEntity1"),
																																														mf.createTypes(mf.createSimpleName("MyAbstractEntity1")),
																																														mf.createDataType("string")),
																																														mf.createDataEntity(
																																																mf.createEntityModifiers(),
																																																mf.createSimpleName("MyDataEntity2"),
																																																mf.createTypes(),
																																																mf.createDataType("string"))
				),
				mf.createNamespace("org.whole.lang"),
				mf.createVersion(""),
				mf.createURI("http://lang.whole.org/MyLanguage"));
	}
}
