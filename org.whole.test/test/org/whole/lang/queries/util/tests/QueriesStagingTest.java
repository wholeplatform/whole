package org.whole.lang.queries.util.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.bindings.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class QueriesStagingTest extends TestCase {

    protected static IEntity create(String templateName) {
        return QueriesStagingTestTemplateManager.instance().create(templateName);
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
    public void testCloneStageUpResult() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment");
            subject = evaluate("fragment1");
            assertThat("at /testCases/0/tests/0/body/1", subject, allOf(not(sameAsEntity(evaluate("fragment2"))), matches(evaluate("fragment3"))));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testCloneStageUpResult2() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment4");
            subject = evaluate("fragment5");
            assertThat("at /testCases/0/tests/1/body/1", subject, allOf(not(sameAsEntity(evaluate("fragment6"))), matches(evaluate("fragment7"))));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }

    /**
     *
     */
    @Test
    public void testRemoveVoidStageDownResult() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            evaluateInScope("fragment8");
            subject = evaluate("fragment9");
            assertThat("at /testCases/0/tests/2/body/1", subject, matches(evaluate("fragment10")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
