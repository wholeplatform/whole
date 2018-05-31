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
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
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

	@Deprecated
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
				EntityDescriptor<?> entityEd = entity.wGetEntityDescriptor();
				EntityDescriptor<?> ed = getOtherEntityDescriptor(entityEd);
				if (ed == null || !ed.isExtendedLanguageSupertypeOf(entityEd))
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
			EntityDescriptor<?> entityEd = entity.wGetEntityDescriptor();
			EntityDescriptor<?> ed = getOtherEntityDescriptor(entityEd);
			if (ed == null || !ed.isLanguageSupertypeOf(entityEd))
				throw new VisitException();
		}

		protected String predicateName() {
			return "isLanguageSubtypeOf";
		}
	}

	public IVisitor isExtendedLanguageSupertypeOfMatcher(String edUri) {
		return new AbstractEntityDescriptorBasedMatcher(edUri) {
			public void visit(IEntity entity) {
				EntityDescriptor<?> entityEd = entity.wGetEntityDescriptor();
				EntityDescriptor<?> ed = getOtherEntityDescriptor(entityEd);
				if (ed == null || !entityEd.isExtendedLanguageSupertypeOf(ed))
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
				EntityDescriptor<?> entityEd = entity.wGetEntityDescriptor();
				EntityDescriptor<?> ed = getOtherEntityDescriptor(entityEd);
				if (ed == null || !entityEd.isLanguageSupertypeOf(ed))
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
			EntityDescriptor<?> entityEd = entity.wGetEntityDescriptor();
			EntityDescriptor<?> ed = getOtherEntityDescriptor(entityEd);
			if (ed == null || !entityEd.equals(ed))
				throw new VisitException();
		}

		protected String predicateName() {
			return "hasType";
		}
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

		    	ed = CommonsDataTypePersistenceParser.getEntityDescriptor(edUri, true, getBindings());
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

		    	fd = CommonsDataTypePersistenceParser.getFeatureDescriptor(fdUri, true, getBindings());
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

	public IVisitor matchInScope(final IEntityIterator<?> patternIterator) {
		return new MatchPatternVisitor(patternIterator);
	}
	public static class MatchPatternVisitor extends AbstractVisitor {
		private IEntityIterator<?> patternIterator;

		public MatchPatternVisitor(IEntityIterator<?> patternIterator) {
			this.patternIterator = patternIterator;
		}

		public IVisitor clone(ICloneContext cc) {
			MatchPatternVisitor visitor = (MatchPatternVisitor) super.clone(cc);
			visitor.patternIterator = cc.clone(patternIterator);
			return visitor;
		}

		public void visit(IEntity entity) {
			IEntity pattern = (IEntity) patternIterator.evaluate(entity, getBindings());

			if (pattern == null || !Matcher.match(pattern, entity, getBindings()))
				throw new VisitException();
		}

		@Override
		public void setBindings(IBindingManager bm) {
			super.setBindings(bm);
			patternIterator.setBindings(bm);
		}

		public void toString(StringBuilder sb) {
			sb.append("match(");
			sb.append(patternIterator);
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
