package org.whole.lang.matchers.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.bindings.*;
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

    protected static IEntity evaluateInScope(String templateName) {
        return evaluate(create(templateName), false);
    }

    /**
     *
     */
    @Test
    public void testAnyTypeVariables() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment");
            assertThat("at /testCases/0/tests/0/body/0", subject, matches(evaluate("fragment1")));
            subject = evaluate("fragment2");
            assertThat("at /testCases/0/tests/0/body/1", subject, not(matches(evaluate("fragment3"))));
            subject = evaluate("fragment4");
            assertThat("at /testCases/0/tests/0/body/2", subject, not(matches(evaluate("fragment5"))));
            subject = evaluate("fragment6");
            assertThat("at /testCases/0/tests/0/body/3", subject, matches(evaluate("fragment7")));
            subject = evaluate("fragment8");
            assertThat("at /testCases/0/tests/0/body/4", subject, matches(evaluate("fragment9")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testTypedVariables() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment10");
            assertThat("at /testCases/0/tests/1/body/0", subject, not(matches(evaluate("fragment11"))));
            subject = evaluate("fragment12");
            assertThat("at /testCases/0/tests/1/body/1", subject, matches(evaluate("fragment13")));
            subject = evaluate("fragment14");
            assertThat("at /testCases/0/tests/1/body/2", subject, matches(evaluate("fragment15")));
            subject = evaluate("fragment16");
            assertThat("at /testCases/0/tests/1/body/3", subject, matches(evaluate("fragment17")));
            subject = evaluate("fragment18");
            assertThat("at /testCases/0/tests/1/body/4", subject, not(matches(evaluate("fragment19"))));
            subject = evaluate("fragment20");
            assertThat("at /testCases/0/tests/1/body/5", subject, not(matches(evaluate("fragment21"))));
            subject = evaluate("fragment22");
            assertThat("at /testCases/0/tests/1/body/6", subject, matches(evaluate("fragment23")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
