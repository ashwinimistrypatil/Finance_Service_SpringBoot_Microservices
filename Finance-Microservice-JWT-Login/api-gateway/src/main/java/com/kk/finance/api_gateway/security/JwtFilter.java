package com.kk.finance.api_gateway.security;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

import org.springframework.web.server.ServerWebExchange;

@Component
public class JwtFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();

        // ✅ Allow public endpoints
        if (path.contains("/login") || path.contains("/register")) {
            return chain.filter(exchange);
        }

        // 🔐 Get Authorization Header
        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        	return onError(exchange, "Missing Authorization Header", 401);
        }

        String token = authHeader.substring(7);

        try {
            JwtUtil.validateToken(token);
        } catch (Exception e) {
        	return onError(exchange, "Invalid Token", 401);
        }

        return chain.filter(exchange);
    }
    
    private Mono<Void> onError(ServerWebExchange exchange, String err, int status) {

        exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.valueOf(status));

        byte[] bytes = err.getBytes();

        org.springframework.core.io.buffer.DataBuffer buffer =
                exchange.getResponse().bufferFactory().wrap(bytes);

        return exchange.getResponse().writeWith(Mono.just(buffer));
    }
}