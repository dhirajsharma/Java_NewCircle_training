

/**
 * Operation factory interface.
 */
public interface OperationFactory {

    /**
     * Get operation for name.
     * 
     * @param name the name of the operation to get.
     * @return the operation for the specified name or null if no such operation
     *         exists.
     */
    public Operation getOperation(String name);
}
