package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;


        String requestUUID = UUID.randomUUID().toString();

        httpResponse.setHeader("X-Request-ID",requestUUID);


        //Request Log
        System.out.println("Incoming Request "+httpRequest.getMethod()+" "+httpRequest.getRequestURI());

        //Call to next filter
        filterChain.doFilter(servletRequest,servletResponse);

        //response status log
        System.out.println("response status: "+httpResponse.getStatus());

    }
}
