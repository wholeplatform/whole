package org.whole.lang.queries.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.bindings.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class QueriesRelativeIndexesTest extends TestCase {

    protected static IEntity create(String templateName) {
        return QueriesRelativeIndexesTestTemplateManager.instance().create(templateName);
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
    public void testRelativeIndexes() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment");
            assertThat("at /testCases/5/tests/0/body/0", subject, matches(evaluate("fragment1")));
            subject = evaluate("fragment2");
            assertThat("at /testCases/5/tests/0/body/1", subject, matches(evaluate("fragment3")));
            subject = evaluate("fragment4");
            assertThat("at /testCases/5/tests/0/body/2", subject, matches(evaluate("fragment5")));
            subject = evaluate("fragment6");
            assertThat("at /testCases/5/tests/0/body/3", subject, matches(evaluate("fragment7")));
            subject = evaluate("fragment8");
            assertThat("at /testCases/5/tests/0/body/4", subject, matches(evaluate("fragment9")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
