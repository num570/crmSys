package com.bjpowernode.web;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse reps, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        reps.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, reps);
    }
}
