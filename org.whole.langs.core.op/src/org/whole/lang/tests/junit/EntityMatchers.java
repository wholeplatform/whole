package org.whole.lang.tests.junit;

import org.hamcrest.Factory;
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
	@Factory
	public static <T> Matcher<IEntity> equalToEntity(IEntity toEntity) {
		return new VisitorMatcher(TestsMatcherFactory.instance.equals(toEntity));
	}
	@Factory
	public static <T> Matcher<IEntity> sameAsEntity(IEntity asEntity) {
		return new VisitorMatcher(TestsMatcherFactory.instance.same(asEntity));
	}
	@Factory
	public static <T> Matcher<IEntity> defined(IBindingManager bindings) {
		IVisitor v = TestsMatcherFactory.instance.defined();
		v.setBindings(bindings);
		return new VisitorMatcher(v);
	}
	@Factory
	public static <T> Matcher<IEntity> equalToValue(final Object toValue) {
		return new VisitorMatcher(TestsMatcherFactory.instance.equalsValue(toValue));
	}
	@Factory
	public static <T> Matcher<IEntity> isNull() {
		return new VisitorMatcher(TestsMatcherFactory.instance.isNull());
	}
	@Factory
	public static <T> Matcher<IEntity> matches(IEntity pattern) {
		return new VisitorMatcher(GenericMatcherFactory.instance.match(pattern));
	}
	@Factory
	public static <T> Matcher<IEntity> assignableTo(String edName) {
   		return new VisitorMatcher(GenericMatcherFactory.instance.isPlatformSubtypeOfMatcher(edName));
	}
	@Factory
	public static <T> Matcher<IEntity> hasType(String edName) {
   		return new VisitorMatcher(GenericMatcherFactory.instance.hasTypeMatcher(edName));
	}
	@Factory
	public static <T> Matcher<IEntity> hasKind(EntityKinds kind) {
   		return new VisitorMatcher(GenericMatcherFactory.instance.hasKindMatcher(kind));
	}
	@Factory
	public static <T> Matcher<IEntity> hasThrown(String className) {
		return new VisitorMatcher(TestsMatcherFactory.instance.hasThrown(className));
	}
}
