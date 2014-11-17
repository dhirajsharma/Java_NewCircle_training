

/**
 * A factory that gets an operation using Java Reflection over the operation
 * name.
 */
public class DynamicOperationFactory implements OperationFactory {

    public Operation getOperation(String name) {
        try {
            return (Operation) Class.forName(name).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
