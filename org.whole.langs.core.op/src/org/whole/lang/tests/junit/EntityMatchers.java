package org.whole.lang.tests.junit;

import org.hamcrest.Matcher;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.tests.matchers.TestsMatcherFactory;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Enrico Persiani
 */
public class EntityMatchers {
	public static <T> Matcher<IEntity> equalToEntity(IEntity toEntity) {
		return new VisitorMatcher(TestsMatcherFactory.instance.equals(toEntity));
	}
	public static <T> Matcher<IEntity> sameAsEntity(IEntity asEntity) {
		return new VisitorMatcher(TestsMatcherFactory.instance.same(asEntity));
	}
	public static <T> Matcher<IEntity> defined(IBindingManager bindings) {
		IVisitor v = TestsMatcherFactory.instance.defined();
		v.setBindings(bindings);
		return new VisitorMatcher(v);
	}
	public static <T> Matcher<IEntity> equalToValue(final Object toValue) {
		return new VisitorMatcher(TestsMatcherFactory.instance.equalsValue(toValue));
	}
	public static <T> Matcher<IEntity> isNull() {
		return new VisitorMatcher(TestsMatcherFactory.instance.isNull());
	}
	public static <T> Matcher<IEntity> matches(IEntity pattern) {
		return new VisitorMatcher(GenericMatcherFactory.instance.match(pattern));
	}
	public static <T> Matcher<IEntity> assignableTo(String edName) {
   		return new VisitorMatcher(GenericMatcherFactory.instance.isPlatformSubtypeOfMatcher(edName));
	}
	public static <T> Matcher<IEntity> hasType(String edName) {
   		return new VisitorMatcher(GenericMatcherFactory.instance.hasTypeMatcher(edName));
	}
	public static <T> Matcher<IEntity> hasKind(EntityKinds kind) {
   		return new VisitorMatcher(GenericMatcherFactory.instance.hasKindMatcher(kind));
	}
	public static <T> Matcher<IEntity> hasThrown(String className) {
		return new VisitorMatcher(TestsMatcherFactory.instance.hasThrown(className));
	}
}
