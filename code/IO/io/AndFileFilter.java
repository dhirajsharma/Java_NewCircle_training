
package io;

import java.io.FileFilter;

public class AndFileFilter extends CompositeFileFilter {

    public AndFileFilter(FileFilter... fileFilters) {
        super(fileFilters);
    }

    @Override
    protected NextMatchAction onNextMatch(boolean accepted) {
        return accepted ? NextMatchAction.CONTINUE : NextMatchAction.RETURN_FALSE;
    }
}
