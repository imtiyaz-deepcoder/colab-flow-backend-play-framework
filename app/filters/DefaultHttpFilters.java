package filters;

import play.filters.cors.CORSFilter;
import play.mvc.EssentialFilter;
import play.http.HttpFilters;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class DefaultHttpFilters implements HttpFilters {

    private final List<EssentialFilter> filters;

    @Inject
    public DefaultHttpFilters(CORSFilter corsFilter) {
        // Only enable CORS, disable everything else (e.g., CSRF)
        this.filters = Arrays.asList(corsFilter.asJava());
    }

    @Override
    public List<EssentialFilter> getFilters() {
        return filters;
    }
}
