package io.arex.agent.bootstrap.model;

public class MockResult {
    public static final MockResult IGNORE_MOCK_RESULT = new MockResult(true, null, null, false);
    private final boolean ignoreMockResult;
    private final Object result;
    private final Throwable throwable;
    private final boolean needRecord;

    private MockResult(boolean ignoreMockResult, Object mockResult, Throwable throwable, boolean needRecord) {
        this.ignoreMockResult = ignoreMockResult;
        this.result = mockResult;
        this.throwable = throwable;
        this.needRecord = needRecord;
    }

    public boolean isIgnoreMockResult() {
        return ignoreMockResult;
    }

    public boolean isNeedRecord() {
        return needRecord;
    }

    public boolean notIgnoreMockResult() {
        return !isIgnoreMockResult();
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public Object getResult() {
        return result;
    }

    public static MockResult success(boolean ignoreMockResult, Object mockResult) {
        if (mockResult instanceof Throwable) {
            return new MockResult(ignoreMockResult, null, (Throwable) mockResult,false );
        }
        return new MockResult(ignoreMockResult, mockResult, null,false );
    }

    public static MockResult success(boolean ignoreMockResult, Object mockResult, boolean needRecord) {
        if (mockResult instanceof Throwable) {
            return new MockResult(ignoreMockResult, null, (Throwable) mockResult, needRecord);
        }
        return new MockResult(ignoreMockResult, mockResult, null, needRecord);
    }

    public static MockResult success(Object mockResult) {
        return success(false, mockResult);
    }
}
