

/**
 * An operation factory that uses other operation factories to get the
 * operation. The first operation factory to return a non-null operation wins.
 */
public class FallbackOperationFactory implements OperationFactory {

    private final OperationFactory[] factories;

    public FallbackOperationFactory() {
        this.factories = new OperationFactory[] { new StaticOperationFactory(),
                new DynamicOperationFactory() };
    }

    public FallbackOperationFactory(OperationFactory... factories) {
        this.factories = factories;
    }

    public Operation getOperation(String name) {
        Operation operation = null;
        for (int i = 0; i < this.factories.length && operation == null; i++) {
            operation = this.factories[i].getOperation(name);
        }
        return operation;
    }
}
