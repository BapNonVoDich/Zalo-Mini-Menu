package com.zalominimenu.springboot.security.jwt;

import com.zalominimenu.springboot.constant.SecurityConstants;
import com.zalominimenu.springboot.mapper.CustomerMapper;
import com.zalominimenu.springboot.model.Customer;
import com.zalominimenu.springboot.repository.customer_portal.CustomerRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

import static java.lang.Long.parseLong;

@Component
@Slf4j
@AllArgsConstructor
public class CustomerJwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenManager jwtTokenManager;
    private final CustomerRepository customerRepository;
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (request.getRequestURI().contains("/v1/customer-portal/auth/get-token")) {
            chain.doFilter(request, response);
            return;
        }

        final String header = request.getHeader("Authorization");
        String authToken;
        Long customerId = null;
        if (Objects.nonNull(header) && header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            authToken = header.replace(SecurityConstants.TOKEN_PREFIX, StringUtils.EMPTY);
            try {
                customerId = Long.parseLong(jwtTokenManager.getSubjectFromToken(authToken));
            }
            catch (Exception e) {
                log.error("Authentication Exception : {}", e.getMessage());
            }
        }
        Customer c = customerRepository.findCustomerById(customerId);

        CustomUserDetails userDetails = CustomerMapper.INSTANCE.convertToCustomUserDetails(c);

        final SecurityContext securityContext = SecurityContextHolder.getContext();

        if (Objects.isNull(securityContext.getAuthentication())) {
                final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(c, null,userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                securityContext.setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }
}