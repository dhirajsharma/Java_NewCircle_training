
package io;

import java.io.File;
import java.io.FileFilter;

public abstract class CompositeFileFilter implements FileFilter {
    protected final FileFilter[] filters;

    protected static enum NextMatchAction {
        RETURN_TRUE, RETURN_FALSE, CONTINUE
    }

    public CompositeFileFilter(FileFilter... fileFilters) {
        this.filters = fileFilters;
    }

    @Override
    public boolean accept(File pathname) {
        if (this.filters != null && this.filters.length > 0) {
            for (FileFilter filter : this.filters) {
                switch (this.onNextMatch(filter.accept(pathname))) {
                    case CONTINUE:
                        // do nothing
                        break;
                    case RETURN_FALSE:
                        return false;
                    case RETURN_TRUE:
                        return true;
                }
            }
            return this.getDefaultValue();
        } else {
            return true;
        }
    }

    protected abstract NextMatchAction onNextMatch(boolean accepted);

    protected boolean getDefaultValue() {
        return true;
    }
}
