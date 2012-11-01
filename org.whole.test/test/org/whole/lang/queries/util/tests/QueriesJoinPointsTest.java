package org.whole.lang.queries.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class QueriesJoinPointsTest extends TestCase {

    protected static IEntity create(String templateName) {
        return QueriesJoinPointsTestTemplateManager.instance().create(templateName);
    }

    protected static IEntity evaluate(String templateName) {
        return evaluate(create(templateName));
    }

    /**
     *
     */
    @Test
    public void testJoinPoints() {
        bindings().wEnterScope();
        IEntity subject;
        subject = evaluate("fragment");
        assertThat("at /testCases/3/tests/0/body/0", subject, matches(evaluate("fragment1")));
        bindings().wExitScope();
    }
}
