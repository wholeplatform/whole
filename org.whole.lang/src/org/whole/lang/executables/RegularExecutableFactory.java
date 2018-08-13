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
package org.whole.lang.executables;

import java.util.Set;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.evaluators.AbstractPureConditionalSupplierEvaluator;
import org.whole.lang.evaluators.AbstractSingleValuedRunnableEvaluator;
import org.whole.lang.evaluators.AbstractTypeRelationEvaluator;
import org.whole.lang.evaluators.CloneReplacingEvaluator;
import org.whole.lang.evaluators.ConstantEvaluator;
import org.whole.lang.evaluators.FeatureByIndexEvaluator;
import org.whole.lang.evaluators.FeatureByNameEvaluator;
import org.whole.lang.evaluators.LocalVariableEvaluator;
import org.whole.lang.evaluators.OuterLocalVariableEvaluator;
import org.whole.lang.evaluators.OuterVariableEvaluator;
import org.whole.lang.evaluators.VariableEvaluator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorBasedExecutableFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.CompositeKinds;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.BindingUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class RegularExecutableFactory extends IteratorBasedExecutableFactory {
	public <E extends IEntity> IEntityIterator<E> emptyIterator() {
		return new EmptyExecutable<E>();
	}

	public <E extends IEntity> IEntityIterator<E> failureIterator(Throwable failure) {
		return new FailureExecutable<E>(failure);
	}

	public <E extends IEntity> IEntityIterator<E> variableIterator(String varName) {
		return BindingUtils.hasEnvironmentPart(varName) ? new VariableEvaluator<E>(varName) : new LocalVariableEvaluator<E>(varName);
	}
	public <E extends IEntity> IEntityIterator<E> outerVariableIterator(String varName) {
		return BindingUtils.hasEnvironmentPart(varName) ? new OuterVariableEvaluator<E>(varName) : new OuterLocalVariableEvaluator<E>(varName);
	}

	public <E extends IEntity> IEntityIterator<E> constantIterator(E constant, boolean useClone) {
		return new ConstantEvaluator<E>(constant, useClone);
	}
	public <E extends IEntity> IEntityIterator<E> constantSubstituteIterator(E constant, boolean useClone) {
		return new ConstantEvaluator<E>(constant, useClone) {
			@Override
			public E evaluateNext() {
				E pattern = super.evaluateNext();
				if (pattern != null)
					Matcher.substitute(pattern, getBindings(), true);
				return pattern;
			}
		};
	}

	public <E extends IEntity> IEntityIterator<E> selfIterator() {
		return new AbstractPureConditionalSupplierEvaluator<E>() {
			@SuppressWarnings("unchecked")
			public E get() {
				return (E) selfEntity;
			}

		    @Override
			public void toString(StringBuilder sb) {
				sb.append("self()");
		    }
		};
	}

	public <E extends IEntity> IEntityIterator<E> repeatedSelfIterator() {
		return new AbstractPureConditionalSupplierEvaluator<E>() {
			@SuppressWarnings("unchecked")
			public E get() {
				isEvaluated = false;
				return (E) selfEntity;
			}

		    @Override
			public void toString(StringBuilder sb) {
				sb.append("repeatedSelf()");
		    }
		};
	}

	public IEntityIterator<IEntity> rootIterator() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return EntityUtils.getCompoundRoot(selfEntity);
			}

		    @Override
			public void toString(StringBuilder sb) {
				sb.append("root()");
		    }
		};
	}
	public IEntityIterator<IEntity> fragmentRootIterator() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return EntityUtils.getFragmentRoot(selfEntity);
			}

		    @Override
			public void toString(StringBuilder sb) {
				sb.append("fragment-root()");
		    }
		};
	}

	public <E extends IEntity> IEntityIterator<E> parentIterator() {
		return new AbstractPureConditionalSupplierEvaluator<E>() {
		    @Override
		    public boolean hasNext() {
		    	return super.hasNext() && EntityUtils.hasParent(selfEntity);
		    }
			@SuppressWarnings("unchecked")
			public E get() {
				return (E) selfEntity.wGetParent();
			}

		    @Override
			public void toString(StringBuilder sb) {
				sb.append("parent()");
		    }
		};
	}

	public IEntityIterator<IEntity> featureByNameIterator(String fdUri) {
		return new FeatureByNameEvaluator(fdUri);
	}
	public IEntityIterator<IEntity> featureByNameIterator(FeatureDescriptor fd) {
		return new FeatureByNameEvaluator(fd);
	}

	public IEntityIterator<IEntity> featureByIndexIterator(int relativeIndex) {
		return new FeatureByIndexEvaluator(relativeIndex);
	}

	public IEntityIterator<IEntity> matchInScopeIterator(IEntityIterator<IEntity> patternIterator) {
		return new AbstractSingleValuedRunnableEvaluator<IEntity>(patternIterator) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				IEntity pattern = argsIterators[0].evaluateNext();
				bm.setResult(BindingManagerFactory.instance.createValue(pattern != null && Matcher.match(pattern, selfEntity, bm)));
			}

			public void toString(StringBuilder sb) {
				sb.append("matchInScope(");
				argsIterators[0].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}

	public IEntityIterator<IEntity> atStageIterator(int stage) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						getBindings().wGetEnvironmentManager().getCurrentOperation().getStage() == stage);
			}

			public void toString(StringBuilder sb) {
				sb.append("atStage(");
				sb.append(stage);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> atHostStageIterator() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						getBindings().wGetEnvironmentManager().getCurrentOperation().getStage() <= 0);
			}

			public void toString(StringBuilder sb) {
				sb.append("atHostStage()");
			}
		};
	}
	public IEntityIterator<IEntity> atTemplateStageIterator() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						getBindings().wGetEnvironmentManager().getCurrentOperation().getStage() > 0);
			}

			public void toString(StringBuilder sb) {
				sb.append("atTemplateStage()");
			}
		};
	}

	public IEntityIterator<IEntity> hasKindIterator(EntityKinds kind) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						kind.equals(selfEntity.wGetEntityKind()));
			}

			public void toString(StringBuilder sb) {
				sb.append("hasKind(");
				sb.append(kind);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> hasCompositeKindIterator(CompositeKinds kind) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						kind.equals(selfEntity.wGetEntityDescriptor().getCompositeKind()));
			}

			public void toString(StringBuilder sb) {
				sb.append("hasCompositeKind(");
				sb.append(kind);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> hasDataKindIterator(DataKinds kind) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						kind.equals(selfEntity.wGetEntityDescriptor().getDataKind()));
			}

			public void toString(StringBuilder sb) {
				sb.append("hasDataKind(");
				sb.append(kind);
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> isFragmentIterator() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						EntityUtils.isFragment(selfEntity));
			}

			public void toString(StringBuilder sb) {
				sb.append("isFragment()");
			}
		};
	}
	public IEntityIterator<IEntity> isVariableIterator() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						EntityUtils.isVariable(selfEntity));
			}

			public void toString(StringBuilder sb) {
				sb.append("isVariable()");
			}
		};
	}
	public IEntityIterator<IEntity> isResolverIterator() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						EntityUtils.isResolver(selfEntity));
			}

			public void toString(StringBuilder sb) {
				sb.append("isResolver()");
			}
		};
	}
	public IEntityIterator<IEntity> isImplIterator() {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						EntityUtils.isNotResolver(selfEntity));
			}

			public void toString(StringBuilder sb) {
				sb.append("isImpl()");
			}
		};
	}

	public IEntityIterator<?> andIterator(IEntityIterator<?>... argsIterators) {
		return super.andIterator(argsIterators);
		//FIXME lookaheadScope
//		return new AbstractSingleValuedRunnableEvaluator<IEntity>(argsIterators) {
//			protected void run(IEntity selfEntity, IBindingManager bm) {
//				for (int i=0; i<argsIterators.length; i++)
//					if (!argsIterators[i].tryEvaluateAsBoolean(selfEntity, bm)) {
//						bm.setResult(BindingManagerFactory.instance.createValue(false));
//						return;
//					}
//
//				bm.setResult(BindingManagerFactory.instance.createValue(true));
//			}
//
//			public void toString(StringBuilder sb) {
//				sb.append("and");
//				super.toString(sb);
//			}
//		};
	}
	public IEntityIterator<?> orIterator(IEntityIterator<?>... argsIterators) {
		return new AbstractSingleValuedRunnableEvaluator<IEntity>(argsIterators) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				for (int i=0; i<argsIterators.length; i++)
					if (argsIterators[i].tryEvaluateAsBoolean(selfEntity, bm)) {
						bm.setResult(BindingManagerFactory.instance.createValue(true));
						return;
					}

				bm.setResult(BindingManagerFactory.instance.createValue(false));
			}

			public void toString(StringBuilder sb) {
				sb.append("or");
				super.toString(sb);
			}
		};
	}
	public IEntityIterator<?> notIterator(IEntityIterator<?> argIterator) {
		return new AbstractSingleValuedRunnableEvaluator<IEntity>(argIterator) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				bm.setResult(BindingManagerFactory.instance.createValue(!argsIterators[0].tryEvaluateAsBoolean(selfEntity, bm)));
			}

			public void toString(StringBuilder sb) {
				sb.append("not");
				super.toString(sb);
			}
		};
	}

	public IEntityIterator<IEntity> oneIterator(IEntityIterator<IEntity> fromClause, IEntityIterator<IEntity> satisfiesClause) {
		return super.oneIterator(fromClause, satisfiesClause);
		//FIXME lookaheadScope
//		return new AbstractSingleValuedRunnableEvaluator<IEntity>(fromClause, satisfiesClause) {
//			protected void run(IEntity selfEntity, IBindingManager bm) {
//				IBindingScope laScope = null;
//				
//				IEntity e = null;
//				while ((e = argsIterators[0].evaluateNext()) != null) {
//				//for (IEntity e : argsIterators[0]) {
//					if (!argsIterators[1].tryEvaluateAsBoolean(e, bm))
//						continue;
//
//					if (laScope != null) {
//						bm.setResult(BindingManagerFactory.instance.createValue(false));
//						return;
//					} else {
//						laScope = BindingManagerFactory.instance.createSimpleScope();
//						laScope.wAddAll(argsIterators[0].lookaheadScope());
//						laScope.wAddAll(argsIterators[1].lookaheadScope());
//					}
//				}
//
//				if (laScope == null) {
//					bm.setResult(BindingManagerFactory.instance.createValue(false));
//					return;
//				}
//				
//				bm.wAddAll(laScope);
//				bm.setResult(BindingManagerFactory.instance.createValue(true));
//			}
//
//			public void toString(StringBuilder sb) {
//				sb.append("one(");
//				argsIterators[0].toString(sb);//TODO startOf
//				sb.append(" satisfies ");
//				argsIterators[1].toString(sb);//TODO startOf
//				sb.append(")");
//			}
//		};
	}
	public IEntityIterator<IEntity> someIterator(IEntityIterator<IEntity> fromClause) {
		return new AbstractSingleValuedRunnableEvaluator<IEntity>(fromClause) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				if (argsIterators[0].evaluateNext() != null) {
					bm.setResult(BindingManagerFactory.instance.createValue(true));
					return;
				}

				bm.setResult(BindingManagerFactory.instance.createValue(false));
			}

			public void toString(StringBuilder sb) {
				sb.append("exists(");
				argsIterators[0].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> someIterator(IEntityIterator<IEntity> fromClause, IEntityIterator<IEntity> satisfiesClause) {
		return new AbstractSingleValuedRunnableEvaluator<IEntity>(fromClause, satisfiesClause) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				IEntity e = null;
				while ((e = argsIterators[0].evaluateNext()) != null) {
				//for (IEntity e : argsIterators[0]) {
					argsIterators[1].reset(e);

					if (argsIterators[1].evaluateNext().wBooleanValue()) {
						bm.setResult(BindingManagerFactory.instance.createValue(true));
						return;
					}
				}

				bm.setResult(BindingManagerFactory.instance.createValue(false));
			}

			public void toString(StringBuilder sb) {
				sb.append("some(");
				argsIterators[0].toString(sb);//TODO startOf
				sb.append(" satisfies ");
				argsIterators[1].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}
	public IEntityIterator<IEntity> everyIterator(IEntityIterator<IEntity> fromClause, IEntityIterator<IEntity> satisfiesClause) {
		return new AbstractSingleValuedRunnableEvaluator<IEntity>(fromClause, satisfiesClause) {
			protected void run(IEntity selfEntity, IBindingManager bm) {
				IEntity e = null;
				while ((e = argsIterators[0].evaluateNext()) != null)
				//for (IEntity e : argsIterators[0])
					if (!argsIterators[1].tryEvaluateAsBoolean(e, bm)) {
						bm.setResult(BindingManagerFactory.instance.createValue(false));
						return;
					}

				bm.setResult(BindingManagerFactory.instance.createValue(true));
			}

			public void toString(StringBuilder sb) {
				sb.append("every(");
				argsIterators[0].toString(sb);//TODO startOf
				sb.append(" satisfies ");
				argsIterators[1].toString(sb);//TODO startOf
				sb.append(")");
			}
		};
	}

	public IEntityIterator<IEntity> isLanguageIterator(String languageURI) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				return BindingManagerFactory.instance.createValue(
						languageURI.equals(selfEntity.wGetLanguageKit().getURI()));
			}

			public void toString(StringBuilder sb) {
				sb.append("isLanguage(\"");
				sb.append(languageURI);
				sb.append("\")");
			}
		};
	}

	public IEntityIterator<IEntity> hasTypeIterator(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.equals(typeEd);
			}
			protected String predicateName() {
				return "hasType";
			}
		};
	}
	public IEntityIterator<IEntity> isLanguageSubtypeOfIterator(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && typeEd.isLanguageSupertypeOf(selfEd);
			}
			protected String predicateName() {
				return "isLanguageSubtypeOf";
			}
		};
	}
	public IEntityIterator<IEntity> isLanguageSupertypeOfIterator(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.isLanguageSupertypeOf(typeEd);
			}
			protected String predicateName() {
				return "isLanguageSupertypeOf";
			}
		};
	}
	public IEntityIterator<IEntity> isExtendedLanguageSubtypeOfIterator(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && typeEd.isExtendedLanguageSupertypeOf(selfEd);
			}
			protected String predicateName() {
				return "isExtendedLanguageSubtypeOf";
			}
		};
	}
	public IEntityIterator<IEntity> isExtendedLanguageSupertypeOfIterator(String typeUri) {
		return new AbstractTypeRelationEvaluator(typeUri) {
			protected boolean test(EntityDescriptor<?> typeEd, EntityDescriptor<?> selfEd) {
				return typeEd != null && selfEd.isExtendedLanguageSupertypeOf(typeEd);
			}
			protected String predicateName() {
				return "isExtendedLanguageSupertypeOf";
			}
		};
	}
	public IEntityIterator<IEntity> atTypeIterator(String edUri) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				EntityDescriptor<?> selfEd = selfEntity.wGetParent().wGetEntityDescriptor(selfEntity);
				EntityDescriptor<?> ed = AbstractTypeRelationEvaluator.getEntityDescriptor(edUri, selfEd, getBindings());
				return BindingManagerFactory.instance.createValue(ed != null && ed.equals(selfEd));
			}

			public void toString(StringBuilder sb) {
				sb.append("atType(\"");
				sb.append(edUri);
				sb.append("\")");
			}
		};
	}

	public IEntityIterator<IEntity> atFeatureIterator(String fdUri) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				FeatureDescriptor selfFd = selfEntity.wGetParent().wGetFeatureDescriptor(selfEntity);
				FeatureDescriptor fd = getFeatureDescriptor(fdUri, selfFd, getBindings());
				return BindingManagerFactory.instance.createValue(fd != null && fd.equals(selfFd));
			}

			public void toString(StringBuilder sb) {
				sb.append("atFeature(\"");
				sb.append(fdUri);
				sb.append("\")");
			}
		};
	}

	public IEntityIterator<IEntity> atIndexIterator(int index) {
		return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
			public IEntity get() {
				IEntity parent = selfEntity.wGetParent();
				int selfIndex = parent.wIndexOf(selfEntity);
				if (index < 0)
					selfIndex -= parent.wSize();
				return BindingManagerFactory.instance.createValue(selfIndex == index);
			}

			public void toString(StringBuilder sb) {
				sb.append("atIndex(");
				if (index < 0)
					sb.append("size");
				sb.append(index);
				sb.append(")");
			}
		};
	}

	public IEntityIterator<?> cloneReplacingIterator(IEntityIterator<?> childMappingIterator) {
		return cloneReplacingIterator(childMappingIterator, null);
	}
	public IEntityIterator<?> cloneReplacingIterator(IEntityIterator<?> childMappingIterator, Set<String> shallowUriSet) {
		if (childMappingIterator.specificIterator() instanceof EmptyExecutable) {
			return new AbstractPureConditionalSupplierEvaluator<IEntity>() {
				public IEntity get() {
					return EntityUtils.clone(selfEntity);
				}
			};
		} else
			return new CloneReplacingEvaluator(shallowUriSet, childMappingIterator);
	}
}
