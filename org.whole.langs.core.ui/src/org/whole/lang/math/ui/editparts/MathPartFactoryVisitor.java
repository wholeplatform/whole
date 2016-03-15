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
package org.whole.lang.math.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.whole.lang.math.model.AbsoluteValue;
import org.whole.lang.math.model.Addition;
import org.whole.lang.math.model.And;
import org.whole.lang.math.model.ApproximatelyEqual;
import org.whole.lang.math.model.Arccosecant;
import org.whole.lang.math.model.Arccosine;
import org.whole.lang.math.model.Arccotangent;
import org.whole.lang.math.model.Arcsecant;
import org.whole.lang.math.model.Arcsine;
import org.whole.lang.math.model.Arctangent;
import org.whole.lang.math.model.BigDecimal;
import org.whole.lang.math.model.BigInteger;
import org.whole.lang.math.model.Builder;
import org.whole.lang.math.model.ByteInteger;
import org.whole.lang.math.model.Cardinality;
import org.whole.lang.math.model.Ceiling;
import org.whole.lang.math.model.Constant;
import org.whole.lang.math.model.Cosecant;
import org.whole.lang.math.model.Cosine;
import org.whole.lang.math.model.Cotangent;
import org.whole.lang.math.model.Difference;
import org.whole.lang.math.model.Division;
import org.whole.lang.math.model.Double;
import org.whole.lang.math.model.Empty;
import org.whole.lang.math.model.Enumeration;
import org.whole.lang.math.model.Equals;
import org.whole.lang.math.model.ExclusiveOr;
import org.whole.lang.math.model.Exponential;
import org.whole.lang.math.model.Exponentiation;
import org.whole.lang.math.model.FactorOf;
import org.whole.lang.math.model.Factorial;
import org.whole.lang.math.model.Float;
import org.whole.lang.math.model.Floor;
import org.whole.lang.math.model.GreaterOrEqual;
import org.whole.lang.math.model.GreaterThan;
import org.whole.lang.math.model.GreatestCommonDivisor;
import org.whole.lang.math.model.HyperbolicArccosecant;
import org.whole.lang.math.model.HyperbolicArccosine;
import org.whole.lang.math.model.HyperbolicArccotangent;
import org.whole.lang.math.model.HyperbolicArcsecant;
import org.whole.lang.math.model.HyperbolicArcsine;
import org.whole.lang.math.model.HyperbolicArctangent;
import org.whole.lang.math.model.HyperbolicCosecant;
import org.whole.lang.math.model.HyperbolicCosine;
import org.whole.lang.math.model.HyperbolicCotangent;
import org.whole.lang.math.model.HyperbolicSecant;
import org.whole.lang.math.model.HyperbolicSine;
import org.whole.lang.math.model.HyperbolicTangent;
import org.whole.lang.math.model.IMathEntity;
import org.whole.lang.math.model.Identifier;
import org.whole.lang.math.model.Implies;
import org.whole.lang.math.model.In;
import org.whole.lang.math.model.IntegerNumber;
import org.whole.lang.math.model.Intersection;
import org.whole.lang.math.model.LessOrEqual;
import org.whole.lang.math.model.LessThan;
import org.whole.lang.math.model.List;
import org.whole.lang.math.model.Logarithm;
import org.whole.lang.math.model.LongInteger;
import org.whole.lang.math.model.LowestCommonMultiple;
import org.whole.lang.math.model.Maximum;
import org.whole.lang.math.model.Minimum;
import org.whole.lang.math.model.Minus;
import org.whole.lang.math.model.Multiplication;
import org.whole.lang.math.model.NaturalLogarithm;
import org.whole.lang.math.model.Not;
import org.whole.lang.math.model.NotANumber;
import org.whole.lang.math.model.NotEquals;
import org.whole.lang.math.model.NotIn;
import org.whole.lang.math.model.NotProperSubset;
import org.whole.lang.math.model.NotSubset;
import org.whole.lang.math.model.Or;
import org.whole.lang.math.model.OrderedPair;
import org.whole.lang.math.model.ProperSubset;
import org.whole.lang.math.model.Quotient;
import org.whole.lang.math.model.Rational;
import org.whole.lang.math.model.Remainder;
import org.whole.lang.math.model.Root;
import org.whole.lang.math.model.Secant;
import org.whole.lang.math.model.Selector;
import org.whole.lang.math.model.Set;
import org.whole.lang.math.model.ShortInteger;
import org.whole.lang.math.model.Sine;
import org.whole.lang.math.model.Stream;
import org.whole.lang.math.model.Subset;
import org.whole.lang.math.model.Subtraction;
import org.whole.lang.math.model.Tangent;
import org.whole.lang.math.model.Tuple;
import org.whole.lang.math.model.Union;
import org.whole.lang.math.ui.figures.FixedApplicationFigure;
import org.whole.lang.math.ui.figures.NumberFigure;
import org.whole.lang.math.visitors.MathIdentityDefaultVisitor;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.ui.editparts.AbstractDataEntityPart;
import org.whole.lang.ui.editparts.CommaSeparatedCompositeFlowPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.IdentifierTextualEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.text.editparts.TextPartFactory;

/**
 * @author Riccardo Solmi
 */
public class MathPartFactoryVisitor extends MathIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IMathEntity) modelEntity).accept(this);
		return part;
	}

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	@Override
	public void visit(IMathEntity entity) {
		part = TextPartFactory.instance().createEditPart(context, entity);
	}

	@Override
	public void visit(Addition entity) {
		part = new AdditionPart();
	}

	@Override
	public void visit(Multiplication entity) {
		part = new MultiplicationPart();
	}

	@Override
	public void visit(Subtraction entity) {
		part = new SubtractionPart();
	}

	@Override
	public void visit(Division entity) {
		part = new DivisionPart();
	}

	@Override
	public void visit(Quotient entity) {
		part = new QuotientPart();
	}

	@Override
	public void visit(Remainder entity) {
		part = new RemainderPart();
	}

	@Override
	public void visit(Exponentiation entity) {
		part = new ExponentiationPart();
	}

	@Override
	public void visit(Root entity) {
		part = new RootPart();
	}

	@Override
	public void visit(Minus entity) {
		part = new MinusPart();
	};

	@Override
	public void visit(AbsoluteValue entity) {
		part = new AbsoluteValuePart();
	}

	@Override
	public void visit(Floor entity) {
		part = new FloorPart();
	}

	public void visit(Ceiling entity) {
		part = new CeilingPart();
	};
	
	@Override
	public void visit(Factorial entity) {
		part = new FactorialPart();
	}

	@Override
	public void visit(GreatestCommonDivisor entity) {
		part = new GreatestCommonDivisorPart();
	}
	@Override
	public void visit(LowestCommonMultiple entity) {
		part = new LowestCommonMultiplePart();
	}

	@Override
	public void visit(Maximum entity) {
		part = new MaximumPart();
	}
	@Override
	public void visit(Minimum entity) {
		part = new MinimumPart();
	}

	@Override
	public void visit(And entity) {
		part = new AndPart();
	}
	@Override
	public void visit(Or entity) {
		part = new OrPart();
	}
	@Override
	public void visit(ExclusiveOr entity) {
		part = new ExclusiveOrPart();
	}
	@Override
	public void visit(Not entity) {
		part = new NotPart();
	};
	@Override
	public void visit(Implies entity) {
		part = new ImpliesPart();
	}

	@Override
	public void visit(Equals entity) {
		part = new EqualsPart();
	}
	@Override
	public void visit(NotEquals entity) {
		part = new NotEqualsPart();
	}
	@Override
	public void visit(ApproximatelyEqual entity) {
		part = new ApproximatelyEqualPart();
	}
	@Override
	public void visit(GreaterThan entity) {
		part = new GreaterThanPart();
	}
	@Override
	public void visit(LessThan entity) {
		part = new LessThanPart();
	}
	@Override
	public void visit(GreaterOrEqual entity) {
		part = new GreaterOrEqualPart();
	}
	@Override
	public void visit(LessOrEqual entity) {
		part = new LessOrEqualPart();
	}

	@Override
	public void visit(FactorOf entity) {
		part = new FactorOfPart();
	}
	@Override
	public void visit(Exponential entity) {
		part = new ExponentialPart();
	}
	@Override
	public void visit(NaturalLogarithm entity) {
		part = new NaturalLogarithmPart();
	}
	@Override
	public void visit(Logarithm entity) {
		part = new LogarithmPart();
	}

	@Override
	public void visit(Sine entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("sin");
			}
		};
	}
	@Override
	public void visit(Cosine entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("cos");
			}
		};
	}
	@Override
	public void visit(Tangent entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("tan");
			}
		};
	}
	@Override
	public void visit(Cosecant entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("csc");
			}
		};
	}
	@Override
	public void visit(Secant entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("sec");
			}
		};
	}
	@Override
	public void visit(Cotangent entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("cot");
			}
		};
	}
	@Override
	public void visit(Arcsine entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("arcsin");
			}
		};
	}
	@Override
	public void visit(Arccosine entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("arccos");
			}
		};
	}
	@Override
	public void visit(Arctangent entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("arctan");
			}
		};
	}
	@Override
	public void visit(Arccosecant entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("arccsc");
			}
		};
	}
	@Override
	public void visit(Arcsecant entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("arcsec");
			}
		};
	}
	@Override
	public void visit(Arccotangent entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("arccot");
			}
		};
	}
	@Override
	public void visit(HyperbolicSine entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("sinh");
			}
		};
	}
	@Override
	public void visit(HyperbolicCosine entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("cosh");
			}
		};
	}
	@Override
	public void visit(HyperbolicTangent entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("tanh");
			}
		};
	}
	@Override
	public void visit(HyperbolicCosecant entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("csch");
			}
		};
	}
	@Override
	public void visit(HyperbolicSecant entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("sech");
			}
		};
	}
	@Override
	public void visit(HyperbolicCotangent entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("coth");
			}
		};
	}
	@Override
	public void visit(HyperbolicArcsine entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("arcsinh");
			}
		};
	}
	@Override
	public void visit(HyperbolicArccosine entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("arccosh");
			}
		};
	}
	@Override
	public void visit(HyperbolicArctangent entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("arctanh");
			}
		};
	}
	@Override
	public void visit(HyperbolicArccosecant entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("arccsch");
			}
		};
	}
	@Override
	public void visit(HyperbolicArcsecant entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("arcsech");
			}
		};
	}
	@Override
	public void visit(HyperbolicArccotangent entity) {
		part = new TrigonometricExpressionPart() {
			protected IFigure createFigure() {
				return new FixedApplicationFigure("arccoth");
			}
		};
	}


	@Override
	public void visit(Empty entity) {
		part = new EmptyPart();
	}
	@Override
	public void visit(Set entity) {
		part = new SetPart();
	}
	@Override
	public void visit(OrderedPair entity) {
		part = new OrderedPairPart();
	}
	@Override
	public void visit(Tuple entity) {
		part = new TuplePart();
	}
	@Override
	public void visit(List entity) {
		part = new ListPart();
	}
	@Override
	public void visit(Stream entity) {
		part = new StreamPart();
	}
	@Override
	public void visit(Enumeration entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}
	@Override
	public void visit(Builder entity) {
		part = new BuilderPart();
	}

	@Override
	public void visit(Union entity) {
		part = new UnionPart();
	}
	@Override
	public void visit(Intersection entity) {
		part = new IntersectionPart();
	}
	@Override
	public void visit(Difference entity) {
		part = new DifferencePart();
	}

	@Override
	public void visit(In entity) {
		part = new InPart();
	}
	@Override
	public void visit(NotIn entity) {
		part = new NotInPart();
	}
	@Override
	public void visit(Subset entity) {
		part = new SubsetPart();
	}
	@Override
	public void visit(ProperSubset entity) {
		part = new ProperSubsetPart();
	}
	@Override
	public void visit(NotSubset entity) {
		part = new NotSubsetPart();
	}
	@Override
	public void visit(NotProperSubset entity) {
		part = new NotProperSubsetPart();
	}

	@Override
	public void visit(Cardinality entity) {
		part = new CardinalityPart();
	}

	@Override
	public void visit(Selector entity) {
		part = new SelectorPart();
	}


	@Override
	public void visit(Identifier entity) {
		part = new IdentifierTextualEntityPart();
	}

	@Override
	public void visit(ByteInteger entity) {
		part = new AbstractDataEntityPart() {
			public IFigure createFigure() {
				return new NumberFigure("B");
			}
		};
	}
	@Override
	public void visit(ShortInteger entity) {
		part = new AbstractDataEntityPart() {
			public IFigure createFigure() {
				return new NumberFigure("S");
			}
		};
	}
	@Override
	public void visit(IntegerNumber entity) {
		super.visit(entity);
	}
	@Override
	public void visit(LongInteger entity) {
		part = new AbstractDataEntityPart() {
			public IFigure createFigure() {
				return new NumberFigure("L");
			}
		};
	}
	@Override
	public void visit(BigInteger entity) {
		part = new AbstractDataEntityPart() {
			public IFigure createFigure() {
				return new NumberFigure("\u2124");
			}
		};
	}
	@Override
	public void visit(Float entity) {
		part = new AbstractDataEntityPart() {
			public IFigure createFigure() {
				return new NumberFigure("F");
			}
		};
	}
	@Override
	public void visit(Double entity) {
		part = new AbstractDataEntityPart() {
			public IFigure createFigure() {
				return new NumberFigure("D");
			}
		};
	}
	@Override
	public void visit(BigDecimal entity) {
		part = new AbstractDataEntityPart() {
			public IFigure createFigure() {
				return new NumberFigure("\u211d");
			}
		};
	}
	@Override
	public void visit(Rational entity) {
		part = new RationalPart();
	}
	@Override
	public void visit(Constant entity) {
		part = new ConstantPart();
	}
	@Override
	public void visit(NotANumber entity) {
		part = new NotANumberPart();
	}
}
