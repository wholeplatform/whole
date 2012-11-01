package org.whole.lang.queries.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class QueriesCartesianIteratorsTest extends TestCase {

    protected static IEntity create(String templateName) {
        return QueriesCartesianIteratorsTestTemplateManager.instance().create(templateName);
    }

    protected static IEntity evaluate(String templateName) {
        return evaluate(create(templateName));
    }

    /**
     *
     */
    @Test
    public void testCartesianUpdateIterator() {
        bindings().wEnterScope();
        IEntity subject;
        evaluate("fragment");
        subject = evaluate("fragment1");
        assertThat("at /testCases/1/tests/0/body/1", subject, matches(create("fragment2")));
        subject = evaluate("fragment3");
        assertThat("at /testCases/1/tests/0/body/2", subject, matches(create("fragment4")));
        bindings().wExitScope();
    }

    /**
     *
     */
    @Test
    public void testCartesianInsertIterator() {
        bindings().wEnterScope();
        IEntity subject;
        evaluate("fragment5");
        subject = evaluate("fragment6");
        assertThat("at /testCases/1/tests/1/body/1", subject, matches(create("fragment7")));
        subject = evaluate("fragment8");
        assertThat("at /testCases/1/tests/1/body/2", subject, matches(create("fragment9")));
        bindings().wExitScope();
    }
}
