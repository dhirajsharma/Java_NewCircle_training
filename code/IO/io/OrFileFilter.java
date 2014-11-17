
package io;

import java.io.FileFilter;

public class OrFileFilter extends CompositeFileFilter {

    public OrFileFilter(FileFilter... fileFilters) {
        super(fileFilters);
    }

    @Override
    protected NextMatchAction onNextMatch(boolean accepted) {
        return accepted ? NextMatchAction.RETURN_TRUE : NextMatchAction.CONTINUE;
    }

    @Override
    protected boolean getDefaultValue() {
        return false;
    }
}
