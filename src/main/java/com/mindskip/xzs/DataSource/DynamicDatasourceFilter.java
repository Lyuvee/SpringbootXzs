package com.mindskip.xzs.DataSource;

import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "dsFilter", urlPatterns = {"/filter/*"})
public class DynamicDatasourceFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig){
        log.info("loading filter {}", filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        log.info("经过多数据源filter,当前路径是{}", requestURI);
//        String headerDs = request.getHeader("ds");
//        Object sessionDs = request.getSession().getAttribute("ds");
        String s = requestURI.replaceFirst("/filter/", "");
        String dsKey = "master";
        if (s.startsWith("xiaoshan")) {
           dsKey = "slave1";
        } else if (s.startsWith("shaoxing")) {
            dsKey = "slave2";
        } else {
            dsKey = "slave3";
        }
        //执行
        try {
            DynamicDataSourceContextHolder.push(dsKey);
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            DynamicDataSourceContextHolder.poll();
        }
    }

    @Override
    public void destroy() {

    }
}