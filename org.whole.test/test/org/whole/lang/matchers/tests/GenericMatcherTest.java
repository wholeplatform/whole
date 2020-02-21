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
            assertThat("at /testCases/0/tests/0/body/0", subject, equalToValue(true));
            subject = evaluate("fragment1");
            assertThat("at /testCases/0/tests/0/body/1", subject, equalToValue(false));
            subject = evaluate("fragment2");
            assertThat("at /testCases/0/tests/0/body/2", subject, equalToValue(false));
            subject = evaluate("fragment3");
            assertThat("at /testCases/0/tests/0/body/3", subject, equalToValue(true));
            subject = evaluate("fragment4");
            assertThat("at /testCases/0/tests/0/body/4", subject, equalToValue(true));
            subject = evaluate("fragment5");
            assertThat("at /testCases/0/tests/0/body/5", subject, equalToValue(true));
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
            subject = evaluate("fragment6");
            assertThat("at /testCases/0/tests/1/body/0", subject, equalToValue(false));
            subject = evaluate("fragment7");
            assertThat("at /testCases/0/tests/1/body/1", subject, equalToValue(true));
            subject = evaluate("fragment8");
            assertThat("at /testCases/0/tests/1/body/2", subject, equalToValue(true));
            subject = evaluate("fragment9");
            assertThat("at /testCases/0/tests/1/body/3", subject, equalToValue(true));
            subject = evaluate("fragment10");
            assertThat("at /testCases/0/tests/1/body/4", subject, equalToValue(false));
            subject = evaluate("fragment11");
            assertThat("at /testCases/0/tests/1/body/5", subject, equalToValue(false));
            subject = evaluate("fragment12");
            assertThat("at /testCases/0/tests/1/body/6", subject, equalToValue(true));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
