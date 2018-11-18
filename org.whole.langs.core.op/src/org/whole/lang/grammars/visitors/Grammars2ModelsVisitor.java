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
package org.whole.lang.grammars.visitors;

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.grammars.model.As;
import org.whole.lang.grammars.model.DataType;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.LanguageDescriptor;
import org.whole.lang.grammars.model.Name;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Productions;
import org.whole.lang.grammars.model.Repeat;
import org.whole.lang.grammars.model.Rule;
import org.whole.lang.grammars.model.Template;
import org.whole.lang.grammars.model.When;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.ComponentModifierEnum;
import org.whole.lang.models.model.CompositeEntity;
import org.whole.lang.models.model.DataEntity;
import org.whole.lang.models.model.EntityModifierEnum;
import org.whole.lang.models.model.EnumEntity;
import org.whole.lang.models.model.EnumValues;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.FeatureModifierEnum;
import org.whole.lang.models.model.Features;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.ModelDeclaration;
import org.whole.lang.models.model.ModelDeclarations;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.models.model.Types;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class Grammars2ModelsVisitor extends GrammarsTraverseAllVisitor {
	private ModelDeclarations modelDeclarations;
	private Map<String, ModelDeclaration> declarationMap = new HashMap<String, ModelDeclaration>(); // entityName -> ModelDeclaration
	private Map<String, Production> productionMap = new HashMap<String, Production>(); // ntName -> Production
	private Map<String, Production> lexiconMap = new HashMap<String, Production>(); // ntName -> Production
	private String name;
	protected boolean normalizeGrammar;

	public Grammars2ModelsVisitor(boolean normalizeGrammar) {
		this.normalizeGrammar = normalizeGrammar;
	}

	protected boolean isLexicalNonTerminal(NonTerminal nt) {
		return lexiconMap.keySet().contains(nt.getValue());
	}

	protected Grammar normalize(Grammar grammar) {
		if (normalizeGrammar) {
			grammar = EntityUtils.clone(grammar);
			NormalizerOperation.normalize(grammar);
		}
		return grammar;
	}

	@Override
	public void visit(Grammar entity) {
		entity = normalize(entity);

		IExecutable<Production> lexiconIiterator = executableFactory().<Production>createChild();
		lexiconIiterator.reset(entity.getLexicalStructure());
		for (Production p : lexiconIiterator)
			lexiconMap.put(p.getName().getValue(), p);

		LanguageDescriptor ld = (LanguageDescriptor) entity.getTargetLanguage();
		ModelsEntityFactory mf = ModelsEntityFactory.instance;
		Model model = mf.createModel(
				mf.createSimpleName(ld.getName().getValue()),
				mf.createTypeRelations(),
				modelDeclarations = mf.createModelDeclarations(),
				mf.createNamespace(ld.getNamespace().getValue()),
				EntityUtils.isResolver(ld.getVersion()) ?
						CommonsEntityAdapterFactory.createResolver(ModelsEntityDescriptorEnum.Version) :
						mf.createVersion(ld.getVersion().getValue()),
				mf.createURI(ld.getUri().getValue()));

		entity.getPhraseStructure().accept(this);
		
		setResult(model);
	}

	@Override
	public void visit(Productions entity) {
		ModelsEntityFactory mf = ModelsEntityFactory.instance;
		ExecutableFactory f = executableFactory();
		IExecutable<Production> i = f.createFilter(f.createChild(), f.createIsImpl());
		i.reset(entity);
		for (Production p : i) {
			String eName = getMappedEntityName(p);
			ModelDeclaration mDecl = CommonsEntityAdapterFactory.createResolver(ModelsEntityDescriptorEnum.ModelDeclaration);

			productionMap.put(p.getName().getValue(), p);
			declarationMap.put(eName, mDecl);
			modelDeclarations.wAdd(mDecl);
			
			mDecl.setModifiers(mf.createEntityModifiers());
			mDecl.setName(mf.createSimpleName(eName));
			mDecl.setTypes(mf.createTypes());
		}

		super.visit(entity);
	}

	@Override
	public void visit(Production entity) {
		ModelsEntityFactory mf = ModelsEntityFactory.instance;
		ExecutableFactory f = executableFactory();
		String eName = getMappedEntityName(entity);
		Rule rule = entity.getRule();
		
		IExecutable<IEntity> traversal = f.createDescendantOrSelf();
		IExecutable<IEntity> ruleExecutable = f.createFilter(traversal, f.createIsLanguageSubtypeOf(GrammarsEntityDescriptorEnum.Rule.getURI()));
		ruleExecutable.reset(rule);
		IEntity nextEntity = null;
		for (rule = (Rule) ruleExecutable.evaluateNext(); rule != null; rule = (Rule) (nextEntity != null ? nextEntity : ruleExecutable.evaluateNext())) {
			nextEntity = null;

			switch (rule.wGetEntityOrd()) {
			// map productions with a single lexical non-terminal as data entities
			case GrammarsEntityDescriptorEnum.NonTerminal_ord:
				if (!isLexicalNonTerminal((NonTerminal) rule) ||
						!EntityUtils.hasParent(rule) ||
						!Matcher.match(GrammarsEntityDescriptorEnum.Production, rule.wGetParent()) ||
						!Matcher.match(GrammarsEntityDescriptorEnum.DataTerminal, lexiconMap.get(((NonTerminal) rule).getValue()).getRule()))
					break;
			case GrammarsEntityDescriptorEnum.DataTerminal_ord:
				DataEntity de = getModelDeclaration(eName, ModelsEntityDescriptorEnum.DataEntity);
				Template template = entity.getTemplate();
				if (Matcher.matchImpl(GrammarsEntityDescriptorEnum.DataType, template))
					de.getDataType().wSetValue(GrammarsUtils.getDataType((DataType) template));
				else if (Matcher.matchImpl(GrammarsEntityDescriptorEnum.CustomDataType, template))
					de.getDataType().wSetValue(template.wStringValue());
				return;
			case GrammarsEntityDescriptorEnum.Choose_ord:

				boolean isPolymorphic = false;
				IExecutable<NonTerminal> ruleExecutable2 = f.createFilter(f.createDescendantOrSelf(), f.createHasType(GrammarsEntityDescriptorEnum.NonTerminal.getURI()));
				ruleExecutable2.reset(rule);
				for (NonTerminal nt2 : ruleExecutable2)
					if (!isLexicalNonTerminal(nt2)) {
						ensureType(getModelDeclaration(getMappedEntityName(nt2)).getTypes(), eName);
						isPolymorphic = true;
					}

				if (isPolymorphic) {
					SimpleEntity se = getModelDeclaration(eName, ModelsEntityDescriptorEnum.SimpleEntity);
					se.getModifiers().wAdd(mf.createEntityModifier(EntityModifierEnum._abstract));
					return;
				} else if (!rule.wIsEmpty() && Matcher.match(GrammarsEntityDescriptorEnum.As, rule.wGet(0))) {
					EnumEntity ee = getModelDeclaration(eName, ModelsEntityDescriptorEnum.EnumEntity);
					EnumValues enumValues = ModelsEntityFactory.instance.createEnumValues(0);
					IExecutable<As> ruleIterator3 = f.createFilter(f.createDescendantOrSelf(), f.createHasType(GrammarsEntityDescriptorEnum.As.getURI()));
					ruleIterator3.reset(rule);
					for (As as : ruleIterator3)
						enumValues.wAdd(ModelsEntityFactory.instance.createEnumValue(as.getName().getValue()));
					ee.setValues(enumValues);
					return;
				}
//				while (ruleIterator.skipTo(GrammarsEntityDescriptorEnum.NonTerminal)) {
//					NonTerminal nt = ruleIterator.next(GrammarsEntityDescriptorEnum.NonTerminal);
//					ensureType(getModelDeclaration(getMappedEntityName(nt)).getTypes(), eName);
//				}
				break;
			case GrammarsEntityDescriptorEnum.Repeat_ord:
				do {
					nextEntity = traversal.evaluateNext();
				} while (nextEntity != null && !Matcher.isAssignableAsIsFrom(GrammarsEntityDescriptorEnum.NonTerminal, nextEntity));

				if (nextEntity != null) {

					//FIXME wrongly assumes that the separator, if present, is a lexical token
					if (!EntityUtils.isResolver(((Repeat) rule).getSeparator())) {//if (Matcher.matchImpl(GrammarsEntityDescriptorEnum.NonTerminal, ((Repeat) rule).getSeparator())) {
						ruleExecutable.evaluateNext();
						do {
							nextEntity = traversal.evaluateNext();
						} while (nextEntity != null && !Matcher.isAssignableAsIsFrom(GrammarsEntityDescriptorEnum.NonTerminal, nextEntity));
					}

					NonTerminal nt = null;
					f = executableFactory();
					IExecutable<NonTerminal> ruleExecutable4 = f.createFilter(f.createDescendantOrSelf(), f.createHasType(GrammarsEntityDescriptorEnum.NonTerminal.getURI()));
					ruleExecutable4.reset(rule);
					for (NonTerminal nt2 : ruleExecutable4)
						if (!isLexicalNonTerminal(nt2)) {
							nt = nt2;
							break;
						}
					//FIXME after normalization, component type can be polymorphic
					// by now we assume that the separator, if present, is a lexical token
					if (nt == null)
						break;

// the above statements replace this code, allowing lexical Repeat rule
//					NonTerminal nt = ruleIterator.next(GrammarsEntityDescriptorEnum.NonTerminal);
//					while (isLexicalNonTerminal(nt)) {
//						nt = ruleIterator.next(GrammarsEntityDescriptorEnum.NonTerminal);
//					}
					
					CompositeEntity ce = getModelDeclaration(eName, ModelsEntityDescriptorEnum.CompositeEntity);
					
					ce.setComponentType(mf.createSimpleName(getMappedEntityName(nt)));
					ce.getComponentModifiers().wAdd(mf.createComponentModifier(ComponentModifierEnum.ordered));
				}
				return;
			case GrammarsEntityDescriptorEnum.As_ord:
				As asRule = (As) rule;
// normalization invariants assure that this branch is unreachable
//				if (Matcher.match(GrammarsEntityDescriptorEnum.LiteralTerminal, asRule.getRule())) {
//					EnumEntity ee = getModelDeclaration(eName, ModelsEntityDescriptorEnum.EnumEntity);
//					
//					ee.getValues().wAdd(mf.createEnumValue(getMappedName(asRule)));
//					
//					while (ruleIterator.skipTo(GrammarsEntityDescriptorEnum.As)) {
//						rule = ruleIterator.next(GrammarsEntityDescriptorEnum.As);
//						asRule = (As) rule;
//
//						ee.getValues().wAdd(mf.createEnumValue(getMappedName(asRule)));
//					}
//				} else {
					SimpleEntity se = getModelDeclaration(eName, ModelsEntityDescriptorEnum.SimpleEntity);
					Features features = se.getFeatures();
					
					ensureFeature(features, ruleExecutable, asRule);
					
					for (rule = (Rule) ruleExecutable.evaluateNext(); rule != null;
							 rule = (Rule) ruleExecutable.evaluateNext()) {
						
						switch (rule.wGetEntityOrd()) {
						case GrammarsEntityDescriptorEnum.As_ord:
							asRule = (As) rule;
							ensureFeature(features, ruleExecutable, asRule);
							break;
// normalization invariants assure that this branch is unreachable (choose rules nested into as rules always become fresh productions)
//						case GrammarsEntityDescriptorEnum.Choose_ord:
//							ruleIterator.prune();
//							
//							se.getModifiers().wAdd(mf.createEntityModifier(EntityModifierEnum._abstract));
//
//							for (NonTerminal nt2 : iteratorFactory().<NonTerminal>topDownMatcherIterator(rule).usePattern(GrammarsEntityDescriptorEnum.NonTerminal))
//								ensureType(getModelDeclaration(getMappedEntityName(nt2)).getTypes(), eName);
						}
					}
//				}
				return;
			case GrammarsEntityDescriptorEnum.Concatenate_ord:
				break;
			}
		}
		getModelDeclaration(eName, ModelsEntityDescriptorEnum.SimpleEntity);
	}

	@Override
	public void visit(Name entity) {
		name = entity.getValue();
	}

	@Override
	public void visit(NonTerminal entity) {
		name = entity.getValue();
	}

	protected void ensureType(Types types, String typeName) {
		ExecutableFactory ef = executableFactory();
		IExecutable<SimpleName> i = ef.createFilter(ef.createChild(), ef.createHasType(ModelsEntityDescriptorEnum.SimpleName.getURI()));
		i.reset(types);
		for (SimpleName type : i)
			if (typeName.equals(type.getValue()))
				return;
		types.wAdd(ModelsEntityFactory.instance.createSimpleName(typeName));
	}

	protected void ensureFeature(Features features, IExecutable<IEntity> ruleIterator, As asRule) {
		String featureName = getMappedName(asRule);
		ExecutableFactory ef = executableFactory();
		IExecutable<Feature> i = ef.createFilter(ef.createChild(), ef.createHasType(ModelsEntityDescriptorEnum.Feature.getURI()));
		i.reset(features);
		for (Feature feature : i)
			if (featureName.equals(feature.getName().getValue()))
				return;
		features.wAdd(createFeature(ruleIterator, featureName));
	}

	protected Feature createFeature(IExecutable<IEntity> ruleExecutable, String featureName) {
		ModelsEntityFactory mf = ModelsEntityFactory.instance;
		IEntityBuilder<Feature> fb = mf.buildFeature();
		fb.set(ModelsFeatureDescriptorEnum.name, featureName);
		IEntity nextEntity = null;
		for (Rule rule = (Rule) ruleExecutable.evaluateNext(); rule != null; rule = (Rule) (nextEntity != null ? nextEntity : ruleExecutable.evaluateNext())) {
			nextEntity = null;

			switch (rule.wGetEntityOrd()) {
//			case GrammarsEntityDescriptorEnum.Optional_ord:
//				fb.set(ModelsFeatureDescriptorEnum.modifiers,
//						mf.createFeatureModifiers(
//								mf.createFeatureModifier(FeatureModifierEnum.optional)));
//				break;
			case GrammarsEntityDescriptorEnum.When_ord:
				IEntity whenRule = ((When) rule).getRule();
				do {
					nextEntity = ruleExecutable.evaluateNext();
				} while (nextEntity != null && nextEntity != whenRule);

				break;
			case GrammarsEntityDescriptorEnum.NonTerminal_ord:
				if (isLexicalNonTerminal((NonTerminal) rule) &&
						EntityUtils.hasParent(rule) &&
						Matcher.match(GrammarsEntityDescriptorEnum.Concatenate, rule.wGetParent()))
					break;

				fb.set(ModelsFeatureDescriptorEnum.type,
						mf.createSimpleName(getMappedEntityName((NonTerminal) rule)));

				IEntity ancestor = null;
				IExecutable<IEntity> executable = executableFactory().createAncestor();
				executable.reset(Matcher.findAncestor(GrammarsEntityDescriptorEnum.As, rule));
				while ((ancestor = executable.evaluateNext()) != null && !Matcher.match(GrammarsEntityDescriptorEnum.Production, ancestor))
					if (Matcher.match(GrammarsEntityDescriptorEnum.Optional, ancestor))
						fb.set(ModelsFeatureDescriptorEnum.modifiers,
								mf.createFeatureModifiers(mf.createFeatureModifier(FeatureModifierEnum.optional)));

				return fb.getResult();
			}
		}
		throw new IllegalArgumentException("Missing NonTerminal");
	}

	protected String getMappedName(As as) {
		as.getName().accept(this);
		return name;
	}
	protected String getMappedEntityName(NonTerminal nt) {
		return getMappedEntityName(productionMap.get(nt.getValue()));
	}
	protected String getMappedEntityName(Production production) {
		return production.getName().getValue();//FIXME use template
	}

	protected ModelDeclaration getModelDeclaration(String name) {
		return declarationMap.get(name);
	}
	protected <T extends ModelDeclaration> T getModelDeclaration(String name, EntityDescriptor<T> ed) {
		ModelDeclaration e = declarationMap.get(name);
		T result = e.wResolveWith(ed);
		if (result != e)
			declarationMap.put(name, result);
		return result;
	}
}
