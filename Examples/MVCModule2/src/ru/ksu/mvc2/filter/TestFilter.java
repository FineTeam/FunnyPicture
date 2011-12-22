package ru.ksu.mvc2.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author alexander.shlyannikov
 *         24.11.11 10:59
 */
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Remote Host: " + request.getRemoteHost());
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
