package org.whole.lang.tests.matchers;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.BindingUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.GenericIdentityVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.VisitException;

/**
 * @author Enrico Persiani
 */
public class TestsMatcherFactory {
	public static final TestsMatcherFactory instance = new TestsMatcherFactory();

	public IVisitor equals(final IEntity toEntity) {
		return new GenericIdentityVisitor() {
			@Override
			public void visit(IEntity entity) {
				if (entity.wEquals(toEntity))
					return;
				if (EntityUtils.isData(entity) && EntityUtils.isData(toEntity) && entity.wGetValue().equals(toEntity.wGetValue()))
					return;
				throw new VisitException();
			}
			public void toString(StringBuilder sb) {
				sb.append("equals(");
				sb.append(toEntity);
				sb.append(")");
			}
		};
	}

	public IVisitor same(final IEntity asEntity) {
		return new GenericIdentityVisitor() {
			@Override
			public void visit(IEntity entity) {
				if (entity != asEntity)
					throw new VisitException();
			}
			public void toString(StringBuilder sb) {
				sb.append("same(");
				sb.append(asEntity);
				sb.append(")");
			}
		};
	}

	public IVisitor defined() {
		return new GenericIdentityVisitor() {
			@Override
			public void visit(IEntity entity) {
				if (!EntityUtils.isData(entity) || !BindingUtils.wIsSet(getBindings(), entity.wStringValue()))
					throw new VisitException();
			}
			public void toString(StringBuilder sb) {
				sb.append("defined");
			}
		};
	}

	public IVisitor equalsValue(final Object toValue) {
		return new GenericIdentityVisitor() {
			@Override
			public void visit(IEntity entity) {
				try {
					if (entity.wGetValue().equals(toValue))
						return;
				} catch (Exception e) {
				}
				throw new VisitException();
			}
			public void toString(StringBuilder sb) {
				sb.append("equals(");
				sb.append(String.valueOf(toValue));
				sb.append(")");
			}
		};
	}

	public IVisitor isNull() {
		return new GenericIdentityVisitor() {
			@Override
			public void visit(IEntity entity) {
				try {
					if (EntityUtils.isNull(entity) || entity.wGetValue() == null)
						return;
				} catch (Exception e) {
				}
				throw new VisitException();
			}
			public void toString(StringBuilder sb) {
				sb.append("null");
			}
		};
	}

	public IVisitor hasThrown(final String className) {
		return new GenericIdentityVisitor() {
			@Override
			public void visit(IEntity entity) {
				try {
					if (getBindings().wIsSet("thrownException")) {
						ClassLoader loader = ReflectionFactory.getClassLoader(getBindings());
						Class<?> clazz = Class.forName(className, true, loader);
						if (clazz.isAssignableFrom(getBindings().wGetValue("thrownException").getClass())) {
							getBindings().wUnset("thrownException");
							return;
						}
					}
				} catch (Exception e) {
				}
				throw new VisitException();
			}
			public void toString(StringBuilder sb) {
				sb.append("has thrown(");
				sb.append(className);
				sb.append(")");
			}
		};
	}
}
