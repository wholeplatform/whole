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
package org.whole.lang.matchers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.iterators.FilterByIndexRangeIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.BindingUtils;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.ResourceUtils;
import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.VisitException;


/**
 * @author Riccardo Solmi
 */
public class GenericMatcherFactory {
	public static final GenericMatcherFactory instance = new GenericMatcherFactory();
	protected GenericMatcherFactory() {
	}

	public IVisitor isPlatformSubtypeOfMatcher(String edUri) {
		return new AbstractEntityDescriptorBasedMatcher(edUri) {
			public void visit(IEntity entity) {
				EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
				EntityDescriptor<?> otherEd = getOtherEntityDescriptor(ed);
				if (otherEd == null || !otherEd.isPlatformSupertypeOf(ed))
					throw new VisitException();
			}

			protected String predicateName() {
				return "isPlatformSubtypeOf";
			}
		};
	}
	public IVisitor isExtendedLanguageSubtypeOfMatcher(String edUri) {
		return new AbstractEntityDescriptorBasedMatcher(edUri) {
			public void visit(IEntity entity) {
				EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
				EntityDescriptor<?> otherEd = getOtherEntityDescriptor(ed);
				if (otherEd == null || !otherEd.isExtendedLanguageSupertypeOf(ed))
					throw new VisitException();
			}

			protected String predicateName() {
				return "isExtendedLanguageSubtypeOf";
			}
		};
	}
	public IVisitor isLanguageSubtypeOfMatcher(String edUri) {
		return new IsLanguageSubtypeOfMatcher(edUri);
	}
	public IVisitor isLanguageSubtypeOfMatcher(EntityDescriptor<?> ed) {
		return new IsLanguageSubtypeOfMatcher(ed);
	}
	public static class IsLanguageSubtypeOfMatcher extends AbstractEntityDescriptorBasedMatcher {
		public IsLanguageSubtypeOfMatcher(String edUri) {
			super(edUri);
		}
		public IsLanguageSubtypeOfMatcher(EntityDescriptor<?> ed) {
			super(ed);
		}

		public void visit(IEntity entity) {
			EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
			EntityDescriptor<?> otherEd = getOtherEntityDescriptor(ed);
			if (otherEd == null || !otherEd.isLanguageSupertypeOf(ed))
				throw new VisitException();
		}

		protected String predicateName() {
			return "isLanguageSubtypeOf";
		}
	}

	public IVisitor isPlatformSupertypeOfMatcher(String edUri) {
		return new AbstractEntityDescriptorBasedMatcher(edUri) {
			public void visit(IEntity entity) {
				EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
				EntityDescriptor<?> otherEd = getOtherEntityDescriptor(ed);
				if (otherEd == null || !ed.isPlatformSupertypeOf(otherEd))
					throw new VisitException();
			}

			protected String predicateName() {
				return "isPlatformSupertypeOf";
			}
		};
	}
	public IVisitor isExtendedLanguageSupertypeOfMatcher(String edUri) {
		return new AbstractEntityDescriptorBasedMatcher(edUri) {
			public void visit(IEntity entity) {
				EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
				EntityDescriptor<?> otherEd = getOtherEntityDescriptor(ed);
				if (otherEd == null || !ed.isExtendedLanguageSupertypeOf(otherEd))
					throw new VisitException();
			}

			protected String predicateName() {
				return "isExtendedLanguageSupertypeOf";
			}
		};
	}
	public IVisitor isLanguageSupertypeOfMatcher(String edUri) {
		return new AbstractEntityDescriptorBasedMatcher(edUri) {
			public void visit(IEntity entity) {
				EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
				EntityDescriptor<?> otherEd = getOtherEntityDescriptor(ed);
				if (otherEd == null || !ed.isLanguageSupertypeOf(otherEd))
					throw new VisitException();
			}
			
			protected String predicateName() {
				return "isLanguageSupertypeOf";
			}
		};
	}

	public IVisitor hasTypeMatcher(String edUri) {
		return new HasTypeMatcher(edUri);
	}
	public IVisitor hasTypeMatcher(EntityDescriptor<?> ed) {
		return new HasTypeMatcher(ed);
	}
	public static class HasTypeMatcher extends AbstractEntityDescriptorBasedMatcher {
		public HasTypeMatcher(String edUri) {
			super(edUri);
		}
		public HasTypeMatcher(EntityDescriptor<?> ed) {
			super(ed);
		}

		public void visit(IEntity entity) {
			EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
			EntityDescriptor<?> otherEd = getOtherEntityDescriptor(ed);
			if (otherEd == null || !ed.equals(otherEd))
				throw new VisitException();
		}

		protected String predicateName() {
			return "hasType";
		}
	}

	public IVisitor atTypeMatcher(String edUri) {
		return new AbstractEntityDescriptorBasedMatcher(edUri) {
			public void visit(IEntity entity) {
				EntityDescriptor<?> ed = entity.wGetParent().wGetEntityDescriptor(entity);
				EntityDescriptor<?> otherEd = getOtherEntityDescriptor(ed);
				if (otherEd == null || !ed.equals(otherEd))
					throw new VisitException();
			}

			protected String predicateName() {
				return "atType";
			}
		};
	}

	public IVisitor atFeatureMatcher(String fdUri) {
		return new AtFeatureMatcher(fdUri);
	}
	public IVisitor atFeatureMatcher(FeatureDescriptor fd) {
		return new AtFeatureMatcher(fd);
	}
	public static class AtFeatureMatcher extends AbstractFeatureDescriptorBasedMatcher {
		public AtFeatureMatcher(String fdUri) {
			super(fdUri);
		}
		public AtFeatureMatcher(FeatureDescriptor fd) {
			super(fd);
		}

		public void visit(IEntity entity) {
			try {
				FeatureDescriptor fd = entity.wGetParent().wGetFeatureDescriptor(entity);
				FeatureDescriptor otherFd = getOtherFeatureDescriptor(fd);
				if (otherFd != null && fd.equals(otherFd))
					return;
			} catch (RuntimeException e) {
			}
			throw new VisitException();
		}

		protected String predicateName() {
			return "atFeature";
		}
	}

	public static abstract class AbstractEntityDescriptorBasedMatcher extends AbstractVisitor {
		public final String edUri;
		protected EntityDescriptor<?> ed;

		public AbstractEntityDescriptorBasedMatcher(String edUri) {
			this.edUri = edUri;
		}
		public AbstractEntityDescriptorBasedMatcher(EntityDescriptor<?> ed) {
			this(ed.getURI());
			this.ed = ed;
		}

		protected EntityDescriptor<?> getOtherEntityDescriptor(EntityDescriptor<?> selfEd) {
			if (ed == null) {
				if (!ResourceUtils.hasFragmentPart(edUri))
					return selfEd.getEntityDescriptorEnum().valueOf(edUri);

		    	String contextUri = getBindings().wIsSet("contextURI") ? getBindings().wStringValue("contextURI") : null;
		    	ed = CommonsDataTypePersistenceParser.getEntityDescriptor(edUri, true, contextUri);
			}
			return ed;
		}

		public void toString(StringBuilder sb) {
			sb.append(predicateName());
			sb.append("(");
			sb.append(edUri);
			sb.append(")");
		}
		protected abstract String predicateName(); 
	}

	public static abstract class AbstractFeatureDescriptorBasedMatcher extends AbstractVisitor {
		public final String fdUri;
		protected FeatureDescriptor fd;

		public AbstractFeatureDescriptorBasedMatcher(String edUri) {
			this.fdUri = edUri;
		}
		public AbstractFeatureDescriptorBasedMatcher(FeatureDescriptor fd) {
			this(fd.getURI());
			this.fd = fd;
		}

		protected FeatureDescriptor getOtherFeatureDescriptor(FeatureDescriptor selfFd) {
			if (fd == null) {
				if (!ResourceUtils.hasFragmentPart(fdUri))
					return selfFd.getFeatureDescriptorEnum().valueOf(fdUri);

		    	String contextUri = getBindings().wIsSet("contextURI") ? getBindings().wStringValue("contextURI") : null;
		    	fd = CommonsDataTypePersistenceParser.getFeatureDescriptor(fdUri, true, contextUri);
			}
			return fd;
		}

		public void toString(StringBuilder sb) {
			sb.append(predicateName());
			sb.append("(");
			sb.append(fdUri);
			sb.append(")");
		}
		protected abstract String predicateName(); 
	}

	public IVisitor isLanguageMatcher(final String languageURI) {
		return new AbstractVisitor() {
			public void visit(IEntity entity) {
				if (!languageURI.equals(entity.wGetLanguageKit().getURI()))
					throw new VisitException();
			}

			public void toString(StringBuilder sb) {
				sb.append("isLanguage(");
				sb.append(languageURI);
				sb.append(")");
			}
		};
	}
	public IVisitor hasKindMatcher(final EntityKinds kind) {
		return new AbstractVisitor() {
			public void visit(IEntity entity) {
				if (!kind.equals(entity.wGetEntityKind()))
					throw new VisitException();
			}
			
			public void toString(StringBuilder sb) {
				sb.append("hasKind(");
				sb.append(kind);
				sb.append(")");
			}
		};
	}
	private static IVisitor matchImplVisitor;
	public IVisitor isImplMatcher() {
		if (matchImplVisitor == null)
			matchImplVisitor = new AbstractVisitor() {
				public void visit(IEntity entity) {
					if (!EntityUtils.isNotResolver(entity))
						throw new VisitException();
				}
				
				public void toString(StringBuilder sb) {
					sb.append("isImpl()");
				}
			};
		return matchImplVisitor;
	}
	private static IVisitor matchResolverVisitor;
	public IVisitor isResolverMatcher() {
		if (matchResolverVisitor == null)
			matchResolverVisitor = new AbstractVisitor() {
				public void visit(IEntity entity) {
					if (!EntityUtils.isResolver(entity))
						throw new VisitException();
				}
				
				public void toString(StringBuilder sb) {
					sb.append("isResolver()");
				}
			};
		return matchResolverVisitor;
	}
	private static IVisitor matchVariableVisitor;
	public IVisitor isVariableMatcher() {
		if (matchVariableVisitor == null)
			matchVariableVisitor = new AbstractVisitor() {
				public void visit(IEntity entity) {
					if (!EntityUtils.isVariable(entity))
						throw new VisitException();
				}
				
				public void toString(StringBuilder sb) {
					sb.append("isVariable()");
				}
			};
		return matchVariableVisitor;
	}
	private static IVisitor matchFragmentVisitor;
	public IVisitor isFragmentMatcher() {
		if (matchFragmentVisitor == null)
			matchFragmentVisitor = new AbstractVisitor() {
				public void visit(IEntity entity) {
					if (!EntityUtils.isFragment(entity))
						throw new VisitException();
				}
				
				public void toString(StringBuilder sb) {
					sb.append("isFragment()");
				}
			};
		return matchFragmentVisitor;
	}

	public IVisitor atHostStageMatcher() {
		return new AbstractVisitor() {
			public void visit(IEntity entity) {
				if (getOperation().getStage() > 0)
					throw new VisitException();
			}
			
			public void toString(StringBuilder sb) {
				sb.append("atHostStage()");
			}
		};
	}
	public IVisitor atTemplateStageMatcher() {
		return new AbstractVisitor() {
			public void visit(IEntity entity) {
				if (getOperation().getStage() <= 0)
					throw new VisitException();
			}
			
			public void toString(StringBuilder sb) {
				sb.append("atTemplateStage()");
			}
		};
	}
	public IVisitor atStageMatcher(final int stage) {
		return new AbstractVisitor() {
			public void visit(IEntity entity) {
				if (getOperation().getStage() != stage)
					throw new VisitException();
			}
			
			public void toString(StringBuilder sb) {
				sb.append("atStage(");
				sb.append(stage);
				sb.append(")");
			}
		};
	}

	public IVisitor atStageVariableMatcher(final String name) {
		if (BindingUtils.hasEnvironmentPart(name))
			return new AbstractVisitor() {
				public void visit(IEntity entity) {
					final IBindingManager bm = BindingUtils.getEnvironment(getBindings(), name);
					final String varName = BindingUtils.getVariableName(name);
	
					if (bm.wIsSet(varName)) {
						IEntity value = bm.wGet(name);
						DataKinds dataKind = DataTypeUtils.getDataKind(value);

						if (!dataKind.isInt() || value.wIntValue() != getOperation().getStage())
							throw new VisitException();
					} else
						bm.wDef(varName, entity);
				}
				
				public void toString(StringBuilder sb) {
					sb.append("atStageVariable(");
					sb.append(name);
					sb.append(")");
				}
			};
		else
			return new AbstractVisitor() {
				public void visit(IEntity entity) {
					final IBindingManager bm = getBindings();
	
					if (bm.wIsSet(name)) {
						IEntity value = bm.wGet(name);
						DataKinds dataKind = DataTypeUtils.getDataKind(value);
	
						if (!dataKind.isInt() || value.wIntValue() != getOperation().getStage())
							throw new VisitException();
					} else
						bm.wDef(name, entity);
				}
				
				public void toString(StringBuilder sb) {
					sb.append("atStageVariable(");
					sb.append(name);
					sb.append(")");
				}
			};
	}

	public IVisitor asVariableMatcher(final String name) {
		if (BindingUtils.hasEnvironmentPart(name))
			return new AbstractVisitor() {
				public void visit(IEntity entity) {
					final IBindingManager bm = BindingUtils.getEnvironment(getBindings(), name);
					final String varName = BindingUtils.getVariableName(name);
	
					if (bm.wIsSet(varName)) {
						if (!Matcher.match(bm.wGet(varName), entity))
							throw new VisitException();
					} else
						bm.wDef(varName, entity);
				}
	
				public void toString(StringBuilder sb) {
					sb.append("asVariable(");
					sb.append(name);
					sb.append(")");
				}
			};
		else
			return new AbstractVisitor() {
				public void visit(IEntity entity) {
					final IBindingManager bm = getBindings();
	
					if (bm.wIsSet(name)) {
						if (!Matcher.match(bm.wGet(name), entity))
							throw new VisitException();
					} else
						bm.wDef(name, entity);
				}
	
				public void toString(StringBuilder sb) {
					sb.append("asVariable(");
					sb.append(name);
					sb.append(")");
				}
			};
	}

	public IVisitor defineVariableMatcher(final String name) {
		if (BindingUtils.hasEnvironmentPart(name))
			return new AbstractVisitor() {
				public void visit(IEntity entity) {
					BindingUtils.wDef(getBindings(), name, entity);
				}
				
				public void toString(StringBuilder sb) {
					sb.append("defineVariable(");
					sb.append(name);
					sb.append(")");
				}
			};
		else
			return new AbstractVisitor() {
				public void visit(IEntity entity) {
					getBindings().wDef(name, entity);
				}
	
				public void toString(StringBuilder sb) {
					sb.append("defineVariable(");
					sb.append(name);
					sb.append(")");
				}
			};

	}

	public IVisitor atIndexMatcher(final int index) {
		return new AbstractVisitor() {
			public void visit(IEntity entity) {
				try {
					IEntity parent = entity.wGetParent();
					int indexOf = parent.wIndexOf(entity);
					if (index < 0)
						indexOf -= parent.wSize();
					if (indexOf == index)
						return;
				} catch (RuntimeException e) {
				}
				throw new VisitException();
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

	public IVisitor matchIteratorIndexVariable(FilterByIndexRangeIterator<?> iterator, String name) {
		if (BindingUtils.hasEnvironmentPart(name))
			return new MatchIteratorIndexLocalVariableVisitor(iterator, name);
		else
			return new MatchIteratorIndexVariableVisitor(iterator, name);
	}
	public static class MatchIteratorIndexLocalVariableVisitor extends AbstractVisitor {
		protected FilterByIndexRangeIterator<?> iterator;
		protected String name;

		public MatchIteratorIndexLocalVariableVisitor(FilterByIndexRangeIterator<?> iterator, String name) {
			this.iterator = iterator;
			this.name = name;
		}

		public IVisitor clone(ICloneContext cc) {
			MatchIteratorIndexVariableVisitor visitor = (MatchIteratorIndexVariableVisitor) super.clone(cc);
			visitor.iterator = cc.clone(iterator);
			return visitor;
		}

		@Override
		public void setBindings(IBindingManager bm) {
			super.setBindings(bm);
			iterator.setBindings(bm);
		}

		public void visit(IEntity entity) {
			int predicateIndex = iterator.predicateIndex(this);
			final IBindingManager bm = getBindings();
			
			if (bm.wIsSet(name)) {
				IEntity value = bm.wGet(name);
				DataKinds dataKind = DataTypeUtils.getDataKind(value);
				
				if (!dataKind.isInt() || value.wIntValue() != predicateIndex)
					throw new VisitException();
			} else
				bm.wDef(name, BindingManagerFactory.instance.createValue(predicateIndex));
		}

		public void toString(StringBuilder sb) {
			sb.append("matchIteratorIndexVariable(index as");
			sb.append(name);
			sb.append(")");
		}
	};
	public static class MatchIteratorIndexVariableVisitor extends MatchIteratorIndexLocalVariableVisitor {
		public MatchIteratorIndexVariableVisitor(FilterByIndexRangeIterator<?> iterator, String name) {
			super(iterator, name);
		}

		public void visit(IEntity entity) {
			int predicateIndex = iterator.predicateIndex(this);
			final IBindingManager bm = BindingUtils.getEnvironment(getBindings(), name);
			final String varName = BindingUtils.getVariableName(name);
			
			if (bm.wIsSet(varName)) {
				IEntity value = bm.wGet(varName);
				DataKinds dataKind = DataTypeUtils.getDataKind(value);
				
				if (!dataKind.isInt() || value.wIntValue() != predicateIndex)
					throw new VisitException();
			} else
				bm.wDef(varName, BindingManagerFactory.instance.createValue(predicateIndex));
		}
	};

	public IVisitor matchIteratorIndex(FilterByIndexRangeIterator<?> iterator, int index) {
		return new MatchIteratorIndexVisitor(iterator, index);
	}
	public static class MatchIteratorIndexVisitor extends AbstractVisitor {
		private FilterByIndexRangeIterator<?> iterator;
		private int index;

		public MatchIteratorIndexVisitor(FilterByIndexRangeIterator<?> iterator, int index) {
			this.iterator = iterator;
			this.index = index;
		}

		public IVisitor clone(ICloneContext cc) {
			MatchIteratorIndexVisitor visitor = (MatchIteratorIndexVisitor) super.clone(cc);
			visitor.iterator = cc.clone(iterator);
			return visitor;
		}

		@Override
		public void setBindings(IBindingManager bm) {
			super.setBindings(bm);
			iterator.setBindings(bm);
		}

		public void visit(IEntity entity) {
			if (iterator.predicateIndex(this) == index)
				return;
			else
				throw new VisitException();
		}

		public void toString(StringBuilder sb) {
			sb.append("matchIteratorIndex(");
			sb.append(index);
			sb.append(")");
		}
	}

	public IVisitor matchIteratorIndexRange(FilterByIndexRangeIterator<?> iterator, int startIndex, int endIndex) {
		return new MatchIteratorIndexRangeVisitor(iterator, startIndex, endIndex);
	}
	public static class MatchIteratorIndexRangeVisitor extends AbstractVisitor {
		private FilterByIndexRangeIterator<?> iterator;
		private int startIndex, endIndex;

		public MatchIteratorIndexRangeVisitor(FilterByIndexRangeIterator<?> iterator, int startIndex, int endIndex) {
			this.iterator = iterator;
			this.startIndex = startIndex;
			this.endIndex = endIndex;
		}

		public IVisitor clone(ICloneContext cc) {
			MatchIteratorIndexRangeVisitor visitor = (MatchIteratorIndexRangeVisitor) super.clone(cc);
			visitor.iterator = cc.clone(iterator);
			return visitor;
		}

		@Override
		public void setBindings(IBindingManager bm) {
			super.setBindings(bm);
			iterator.setBindings(bm);
		}

		public void visit(IEntity entity) {
			int index = iterator.predicateIndex(this);
			if (startIndex <= index && index <= endIndex)
				return;
			else
				throw new VisitException();
		}
		
		public void toString(StringBuilder sb) {
			sb.append("matchIteratorIndexRange(");
			sb.append(startIndex);
			sb.append("..");
			sb.append(endIndex == Integer.MAX_VALUE ? "*" : String.valueOf(endIndex));
			sb.append(")");
		}
	};

	public static IVisitor evalTrue(final IEntity program) {
		return new AbstractVisitor() {
			public void visit(IEntity entity) {
				IBindingManager bm = getBindings();

				IEntity selfEntity = bm.wGet("self");
				if (selfEntity != entity)
					bm.wDef("self", entity);

				IEntity result = BehaviorUtils.evaluate(program, 0, bm);			

				if (selfEntity != entity ) {
					if (selfEntity != null)
						bm.wDef("self", selfEntity);
					else
						bm.wUnset("self");
				}

				if (result == null || 
						!DataTypeUtils.getDataKind(result).isBoolean() ||
						!result.wBooleanValue())
					throw new VisitException();
			}
			
			public void toString(StringBuilder sb) {
				sb.append("evalTrue(");
				sb.append(program);//TODO startOf
				sb.append(")");
			}
		};
	}

	public IVisitor match(final IEntity pattern) {
		return new AbstractVisitor() {
			public void visit(IEntity entity) {
				if (!Matcher.match(pattern, entity))
					throw new VisitException();
			}

			public void toString(StringBuilder sb) {
				sb.append("match(");
				sb.append(pattern); //TODO startOf
				sb.append(")");
			}
		};
	}
	public IVisitor matchInScope(final IEntity pattern) {
		return new AbstractVisitor() {
			public void visit(IEntity entity) {
				if (!Matcher.match(pattern, entity, getBindings()))
					throw new VisitException();
			}
			
			public void toString(StringBuilder sb) {
				sb.append("match(");
				sb.append(pattern); //TODO startOf
				sb.append(")");
			}
		};
	}
	public IVisitor containsMatch(final IEntity pattern) {
		return new AbstractVisitor() {
			public void visit(IEntity entity) {
				if (!Matcher.containsMatch(pattern, entity))
					throw new VisitException();
			}
			
			public void toString(StringBuilder sb) {
				sb.append("containsMatch(");
				sb.append(pattern); //TODO startOf
				sb.append(")");
			}
		};
	}

	public IVisitor match(final IEntityIterator<?> iterator) {
		return new MatchVisitor(iterator);
	}
	public static class MatchVisitor extends AbstractVisitor {
		private IEntityIterator<?> iterator;

		public MatchVisitor(IEntityIterator<?> iterator) {
			this.iterator = iterator;
		}

		public IVisitor clone(ICloneContext cc) {
			MatchVisitor visitor = (MatchVisitor) super.clone(cc);
			visitor.iterator = cc.clone(iterator);
			return visitor;
		}

		public void visit(IEntity entity) {
			iterator.reset(entity);
			if (!iterator.hasNext())
				throw new VisitException();
			iterator.next(); // merge lookahead bindings
		}

		@Override
		public void setBindings(IBindingManager bm) {
			super.setBindings(bm);
			iterator.setBindings(bm);
		}

		public void toString(StringBuilder sb) {
			sb.append("match(");
			sb.append(iterator);
			sb.append(")");
		}
	}

	public IVisitor rename(final Map<String, String> nameMap) {
	    return new AbstractVariableVisitor() {
	    	public void visitVariable(Variable variable) {
	        	String oldName = variable.getVarName().getValue();
	        	String newName = nameMap.get(oldName);
	        	
	        	if (newName != null)
	        		variable.getVarName().setValue(newName);
	    	}
	    };
	}
	public IVisitor rename(final String oldName, final String newName) {
	    return new AbstractVariableVisitor() {
	    	public void visitVariable(Variable variable) {
	        	if (variable.getVarName().getValue().equals(oldName))
	        		variable.getVarName().setValue(newName);
	    	}
	    };
	}

	// NB substitute a copy of the binding values
	public IVisitor substitute(final IBindingScope bindings) {
	    return substitute(bindings, BindingManagerFactory.instance.createVoidScope());
	}

	// NB substitute a copy of the binding values
	public IVisitor substitute(final IBindingScope inBindings, final IBindingScope outBindings) {
	    return new AbstractVariableVisitor() {
	    	private Set<Variable> vars = new HashSet<Variable>();
	    	public void visitVariable(Variable variable) {
	    		if (!EntityUtils.hasParent(variable) || !vars.add(variable))
	    			return;

	        	String varName = variable.getVarName().getValue();
	        	IEntity value = inBindings.wGet(varName);
    			if (value != null && !BindingManagerFactory.instance.isVoid(value)) {
    				boolean isInline = EntityUtils.isInlineVariable(variable);
    	    		EntityDescriptor<?> varType = variable.getVarType().getValue();

    				if (!isInline)
    					value = EntityUtils.convertCloneIfParented(value, varType);//TODO convertCloneIfReparenting variable reference

    				outBindings.wDef(varName, value);

    				//TODO if has not a parent and has only one inverseAdjacent use it and use convertCloneIfReparenting
    				IEntity parentEntity = variable.wGetParent();
    				int variableIndex = parentEntity.wIndexOf(variable);
    				QuantifierEnum.Value quantifierValue = variable.getQuantifier().getValue();
    				boolean isCompositeVar = quantifierValue.isComposite();
    				
    				if (isCompositeVar)
    					variable.getQuantifier().setValue(quantifierValue.toOptional());

    				//TODO ? use EntityUtils.convert(value, varType?) instead of cloneIfParented 
    				if (isInline) {
    					if (!isCompositeVar)
    						parentEntity.wRemove(variableIndex);
    					for (int i=0, size=value.wSize(); i<size; i++)
    						parentEntity.wAdd(variableIndex+i, EntityUtils.clone(value.wGet(i)));
    				} else if (isCompositeVar)
    					parentEntity.wAdd(variableIndex, value);
    				else
    					parentEntity.wSet(variableIndex, value);
	    		}
	    	}
	    };
	}

	public IVisitor rewrite(final IEntity oldPattern, final IEntity newPattern, final boolean includeAdjacents) {
		return new AbstractVisitor() {
			public void visit(IEntity entity) {
				IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();

				if (!Matcher.match(oldPattern, entity, bindings))
					throw new VisitException();
				
				IEntity rewritePattern = EntityUtils.clone(newPattern);
				if (!entity.wGetParent().wSet(entity, rewritePattern))
					throw new VisitException();
				Matcher.substitute(rewritePattern, bindings, includeAdjacents);
			}
		};
	}

	public static abstract class AbstractVariableVisitor extends AbstractVisitor {
		public void visit(IEntity entity) {
			IEntity adaptee = entity.wGetAdaptee(false);
			if (EntityUtils.isVariable(adaptee.wGetEntityDescriptor()))
	        	visitVariable((Variable) adaptee);
		}

		public abstract void visitVariable(Variable entity);
	}
}
