package com.example.intern2.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CorsFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(CorsFilter.class);

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        logger.info("Reached the filter");
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*"); // TODO: devi says, in production environments, face this * inwards
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, X-Auth-Token, Content-Type");
        logger.info("CORS headers were set");
        chain.doFilter(req,res);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
