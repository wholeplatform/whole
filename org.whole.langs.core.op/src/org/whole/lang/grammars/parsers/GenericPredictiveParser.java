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
package org.whole.lang.grammars.parsers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.grammars.model.As;
import org.whole.lang.grammars.model.Bound;
import org.whole.lang.grammars.model.ByDelimiter;
import org.whole.lang.grammars.model.ByLines;
import org.whole.lang.grammars.model.BySize;
import org.whole.lang.grammars.model.Choose;
import org.whole.lang.grammars.model.CompiledPattern;
import org.whole.lang.grammars.model.Concatenate;
import org.whole.lang.grammars.model.DataTerminal;
import org.whole.lang.grammars.model.Empty;
import org.whole.lang.grammars.model.LiteralTerminal;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Optional;
import org.whole.lang.grammars.model.Predicate;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Repeat;
import org.whole.lang.grammars.model.Rule;
import org.whole.lang.grammars.model.Size;
import org.whole.lang.grammars.model.Split;
import org.whole.lang.grammars.model.Template;
import org.whole.lang.grammars.model.When;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsLanguageKit;
import org.whole.lang.grammars.visitors.GrammarsIdentityVisitor;
import org.whole.lang.grammars.visitors.GrammarsTraverseAllVisitor;
import org.whole.lang.iterators.AbstractPatternFilterIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.EnumType;
import org.whole.lang.parsers.Lexer;
import org.whole.lang.parsers.ParseException;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.templates.ModelTemplate;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class GenericPredictiveParser extends AbstractPredictiveParser {
	private GenericMatcherVisitor genericMatcher;
	private GenericParserVisitor genericParser;
	private Map<String, Production> productionsMap;
	private IBuilder builder;
	private ICommonsBuilder cb;

	public GenericPredictiveParser(CharSequence source, String grammarUri, IBuilderOperation op) {
		this(Lexer.createLexer(source), grammarUri, op);
	}
	public GenericPredictiveParser(Lexer lexer, String grammarUri, IBuilderOperation op) {
		super(lexer, grammarUri);

		genericMatcher = new GenericMatcherVisitor();
		genericParser = new GenericParserVisitor();
		productionsMap = new HashMap<String, Production>();
		if (ModelBuilderOperation.ID.equals(op.wGetOperationId())) {
			//FIXME workaround, should use a generic builder
			builder = op.wGetBuilder(GrammarsLanguageKit.URI, false);
		} else
			builder = op.wGetBuilder();

		cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);

		AbstractPatternFilterIterator<Production> i = IteratorFactory.<Production>descendantOrSelfMatcherIterator().withPattern(GrammarsEntityDescriptorEnum.Production);
		i.reset(this.grammar);
		for (Production production : i)
			productionsMap.put(production.getName().getValue(), production);
		productionsMap = Collections.unmodifiableMap(productionsMap);
	}

	private boolean isLexicon(Production production) {
		return grammar.getLexicalStructure().wContains(production);
	}

	private Production getProduction(NonTerminal nt) {
		return getProduction(nt.getValue());
	}
	private Production getProduction(String nt) {
		return productionsMap.get(nt);
	}

	public void wParseStartSymbol() {
		Production production = getProduction(grammar.getStartSymbol());
		if (production == null)
			throw createParseError("mising start symbol production");
		assert !isLexicon(production);
		wParse(production);
	}

	public void wParse(EntityDescriptor<?> ed) {
		wParse(ed.getName());
	}
	public void wParse(String nt) {
		wParse(getProduction(nt));
	}
	protected void wParse(Rule rule) {
		rule.accept(genericParser);
	}
	@Override
	protected int wMatch(Rule rule) {
		return genericMatcher.match(rule);
	}

	public class GenericParserVisitor extends GrammarsIdentityVisitor {
		private EntityDescriptor<?> productionED;

		@Override
		public void visit(Production entity) {
			Template template = entity.getTemplate();
			if (EntityUtils.isStageUpFragment(template))//TODO check for template interpretation
				new ModelTemplate(template).apply(builder);
			else {
				productionED = ed(entity.getName().getValue());
				if (EntityUtils.isData(productionED))
					entity.getRule().accept(this);
				else if (!productionED.isAbstract()) {
					builder.wEntity_(productionED);
					entity.getRule().accept(this);
					builder._wEntity(productionED);
				} else
					entity.getRule().accept(this);
				productionED = null;
			}
		}

		@Override
		public void visit(NonTerminal entity) {
			EntityDescriptor<?> productionED = this.productionED;
			Production production = getProduction(entity);
			if (isLexicon(production)) {
				if (Matcher.match(GrammarsEntityDescriptorEnum.DataTerminal, production.getRule()) &&
						Matcher.match(GrammarsEntityDescriptorEnum.Production, entity.wGetParent()))
					production.getRule().accept(this);
				else
					wMatch(production);
			} else
				production.accept(this);
			this.productionED = productionED;
		}

		@Override
		public void visit(Choose entity) {
			int prediction = wPredict(entity);
			if (isMatch(prediction))
				((Rule) entity.wGet(indexOfMatch(prediction))).accept(this);
			else
				throw createParseError("missing choose step");
		}

		@Override
		public void visit(Concatenate entity) {
			for (int i=0, size=entity.wSize(); i<size; i++)
				((Rule) entity.wGet(i)).accept(this);
		}

		@Override
		public void visit(Repeat entity) {
			int lowerBoundValue = entity.getLowerBound().getValue();
			Bound upperBound = entity.getUpperBound();
			int upperBoundValue = Matcher.match(GrammarsEntityDescriptorEnum.Unbounded, upperBound) ?
					-1 : ((Size) upperBound).getValue();

			Rule rule = entity.getRule();
			Rule separator = entity.getSeparator();
			Rule effectiveSeparator = Matcher.matchImpl(GrammarsEntityDescriptorEnum.NonTerminal, separator) ?
					getProduction((NonTerminal) separator).getRule() : separator;
					boolean useSeparator = !EntityUtils.isResolver(separator) && 
					!Matcher.isAssignableAsIsFrom(GrammarsEntityDescriptorEnum.EpsilonRule, effectiveSeparator);

					int count = 0;
					Rule nextPredictionRule = useSeparator ? separator : rule;
					while (count != upperBoundValue) { // always true if upperBoundValue is negative
						if (count >= lowerBoundValue &&
								(count == 0 && !isConsumingMatch(wPredict(rule)) ||
										count > 0 && !isConsumingMatch(wPredict(nextPredictionRule))))
							break;
						if (useSeparator && count > 0)
							separator.accept(this);
						rule.accept(this);
						count++;
					}
		}

		@Override
		public void visit(Optional entity) {
			Rule rule = entity.getRule();
			if (isConsumingMatch(wPredict(rule)))
				rule.accept(this);
		}

		@Override
		public void visit(When entity) {
			if (isMatch(wPredict(entity)))
				entity.getRule().accept(this);
			else
				throw createParseError("cannot apply when rule");
		}

		@Override
		public void visit(LiteralTerminal entity) {
			throw createParseError("unreachable code"); //FIXME better error handling
		}

		private String lastPatternMatched;
		@Override
		public void visit(CompiledPattern entity) {
			lastPatternMatched = nextToken(entity.getValue());
		}
		@Override
		public void visit(DataTerminal entity) {
			entity.getPattern().accept(this);
			try {
				DataTypeUtils.buildFromPersistenceString(builder, productionED, lastPatternMatched);
			} catch (IllegalArgumentException e) {
				cb.StageDownFragment_();
				builder.wEntity(TextEntityDescriptorEnum.Text, lastPatternMatched);
				cb._StageDownFragment();
			}
		}

		@Override
		public void visit(Empty entity) {
			// do nothing
		}

		@Override
		public void visit(As entity) {
			if (productionED.getDataKind().isEnumValue()) {
				EnumType<?> dataEnumType = productionED.getDataEnumType();
				entity.getRule().accept(this);
				builder.wEntity(productionED, dataEnumType.valueOf(entity.getName().getValue()));
			} else {
				builder.wFeature(fd(entity.getName().getValue()));
				entity.getRule().accept(this);
			}
		}

		private int lastHorizon;
		@Override
		public void visit(ByDelimiter entity) {
			lastHorizon = setHorizonByDelimiter(((CompiledPattern) entity.getDelimiter()).getValue());
		}
		@Override
		public void visit(ByLines entity) {
			lastHorizon = setHorizonByLines(entity.getValue());
		}
		@Override
		public void visit(BySize entity) {
			lastHorizon = setHorizonBySize(entity.getValue());
		}
		@Override
		public void visit(Split entity) {
			entity.getSplitter().accept(this);
			int horizon = lastHorizon;
			entity.getRule().accept(this);
			if (hitEnd())
				setHorizonPosition(horizon, true);
			else
				throw createParseError("bad horizon constraint");
		}
	}

	public class GenericMatcherVisitor extends GrammarsTraverseAllVisitor {
		private int lastPrediction;

		public int match(Rule rule) {
			lastPrediction = 0;
			rule.accept(wGetVisitor1());
			return lastPrediction;
		}

		@Override
		public void visit(Production entity) {
			entity.getRule().accept(wGetVisitor1());
		}

		@Override
		public void visit(NonTerminal entity) {
			int oldLastPrediction = lastPrediction;
			getProduction(entity).accept(wGetVisitor1());
			lastPrediction = oldLastPrediction;
		}

		@Override
		public void visit(Choose entity) {
			Lexer.Memento memento = mark();
			for (int i=0, size=entity.wSize(); i<size; i++) {
				try {
					((Rule) entity.wGet(i)).accept(wGetVisitor1());
					lastPrediction = i;
					return;
				} catch (ParseException e) {
					reset(memento);
				} catch (Exception e) {
					reset(memento);
				}
			}
			throw createParseError("cannot apply choose rule");
		}

		@Override
		public void visit(Repeat entity) {
			int lowerBoundValue = entity.getLowerBound().getValue();
			Bound upperBound = entity.getUpperBound();
			int upperBoundValue = Matcher.match(GrammarsEntityDescriptorEnum.Unbounded, upperBound) ?
					-1 : ((Size) upperBound).getValue();

			Rule rule = entity.getRule();
			Rule separator = entity.getSeparator();
			Rule effectiveSeparator = Matcher.matchImpl(GrammarsEntityDescriptorEnum.NonTerminal, separator) ?
					getProduction((NonTerminal) separator).getRule() : separator;
					boolean useSeparator = !EntityUtils.isResolver(separator) && 
					!Matcher.isAssignableAsIsFrom(GrammarsEntityDescriptorEnum.EpsilonRule, effectiveSeparator);

					int count = 0;
					while (true) {
						boolean added = false;
						Lexer.Memento memento = mark();
						try {
							rule.accept(wGetVisitor1());
							count++;
							added = true;
							if (count == upperBoundValue || (count >= lowerBoundValue && isSame(memento))) // always false if upperBoundValue is negative
								break;

							if (useSeparator) {
								memento = mark();
								separator.accept(wGetVisitor1());
							}

						} catch (ParseException e) {

							if (useSeparator && !added && count > 0)
								throw createParseError("cannot apply repeat rule");

							if (count < lowerBoundValue)
								throw createParseError("lower bound not reached in repeat rule");

							reset(memento);
							break;
						}
					}
		}

		@Override
		public void visit(Optional entity) {
			Lexer.Memento memento = mark();
			try {
				entity.getRule().accept(wGetVisitor1());
			} catch (ParseException e) {
				reset(memento);
			}
		}

		protected void evaluate(Predicate predicate) {
			IEntityIterator<Predicate> iterator;

			switch (predicate.wGetEntityOrd()) {
			case GrammarsEntityDescriptorEnum.And_ord:
				iterator = IteratorFactory.<Predicate>childIterator();
				iterator.reset(predicate);
				while (iterator.hasNext()) {
					Lexer.Memento memento = mark();
					evaluate(iterator.next());
					reset(memento);
				}
				break;

			case GrammarsEntityDescriptorEnum.Or_ord:
				iterator = IteratorFactory.<Predicate>childIterator();
				iterator.reset(predicate);
				while (iterator.hasNext()) {
					Lexer.Memento memento = mark();
					try {
						evaluate(iterator.next());
						return;
					} catch (Exception e) {
						reset(memento);
					}
				}
				throw createParseError("cannot evaluate predicate");

			case GrammarsEntityDescriptorEnum.Not_ord:
				try {
					evaluate((Predicate) predicate.wGet(GrammarsFeatureDescriptorEnum.predicate));
				} catch (Exception e) {
					break;
				}
				throw createParseError("cannot evaluate predicate");

			default:
				((Rule) predicate).accept(this);
			}
		}

		@Override
		public void visit(When entity) {
			Lexer.Memento memento = mark(); //++
			evaluate(entity.getPredicate());
			reset(memento);//++
			entity.getRule().accept(this);//++ remove to obtain strict when semantics
		}

		@Override
		public void visit(LiteralTerminal entity) {
			entity.getPattern().accept(wGetVisitor1());
		}

		@Override
		public void visit(DataTerminal entity) {
			entity.getPattern().accept(wGetVisitor1());
		}

		@Override
		public void visit(Empty entity) {
			// always match
		}

		@Override
		public void visit(CompiledPattern entity) {
			nextToken(entity.getValue());
		}

		@Override
		public void visit(As entity) {
			entity.getRule().accept(wGetVisitor1());
		}

		private int lastHorizon;
		@Override
		public void visit(ByDelimiter entity) {
			lastHorizon = setHorizonByDelimiter(((CompiledPattern) entity.getDelimiter()).getValue());
		}
		@Override
		public void visit(ByLines entity) {
			lastHorizon = setHorizonByLines(entity.getValue());
		}
		@Override
		public void visit(BySize entity) {
			lastHorizon = setHorizonBySize(entity.getValue());
		}
		@Override
		public void visit(Split entity) {
			entity.getSplitter().accept(wGetVisitor1());
			int horizon = lastHorizon;
			entity.getRule().accept(wGetVisitor1());
			if (hitEnd())
				setHorizonPosition(horizon, true);
			else
				throw createParseError("bad horizon constraint");
		}
	}
}
