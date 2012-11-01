package org.whole.lang.matchers.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class GenericMatcherTest extends TestCase {

    protected static IEntity create(String templateName) {
        return GenericMatcherTestTemplateManager.instance().create(templateName);
    }

    protected static IEntity evaluate(String templateName) {
        return evaluate(create(templateName));
    }

    /**
     *
     */
    @Test
    public void testAnyTypeVariables() {
        bindings().wEnterScope();
        IEntity subject;
        subject = create("fragment");
        assertThat("at /testCases/0/tests/0/body/0", subject, matches(create("fragment1")));
        subject = create("fragment2");
        assertThat("at /testCases/0/tests/0/body/1", subject, not(matches(create("fragment3"))));
        subject = create("fragment4");
        assertThat("at /testCases/0/tests/0/body/2", subject, not(matches(create("fragment5"))));
        subject = create("fragment6");
        assertThat("at /testCases/0/tests/0/body/3", subject, matches(create("fragment7")));
        subject = create("fragment8");
        assertThat("at /testCases/0/tests/0/body/4", subject, matches(create("fragment9")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testTypedVariables() {
        bindings().wEnterScope();
        IEntity subject;
        subject = create("fragment10");
        assertThat("at /testCases/0/tests/1/body/0", subject, not(matches(create("fragment11"))));
        subject = create("fragment12");
        assertThat("at /testCases/0/tests/1/body/1", subject, matches(create("fragment13")));
        subject = create("fragment14");
        assertThat("at /testCases/0/tests/1/body/2", subject, matches(create("fragment15")));
        subject = create("fragment16");
        assertThat("at /testCases/0/tests/1/body/3", subject, matches(create("fragment17")));
        subject = create("fragment18");
        assertThat("at /testCases/0/tests/1/body/4", subject, not(matches(create("fragment19"))));
        subject = create("fragment20");
        assertThat("at /testCases/0/tests/1/body/5", subject, not(matches(create("fragment21"))));
        subject = create("fragment22");
        assertThat("at /testCases/0/tests/1/body/6", subject, matches(create("fragment23")));
        bindings().wExitScope();
    }
}
