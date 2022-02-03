package com.example.demo.filter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
	private static final Logger logger = LogManager.getLogger(CustomFilter.class);
    public CustomFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        //filter에서 하고 싶은 내용을 재정의
        //pre filter 동작
        /*return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("Custom PRE filter : request id -> {}", request.getId());

            //post filter 동작
            return chain.filter(exchange).then(Mono.fromRunnable(()->{  //스프링5에서 지원하는 기능으로 비동기로 값을 전달할때 사용되는 객체
                log.info("Custom POST filter : response id -> {}", response.getStatusCode());
            }));
        });*/
        GatewayFilter filter = new OrderedGatewayFilter((exchange, chain)->{    //WebFlux를 활용하여 비동기 처리에서 request와 response를 가져올 수 있다.
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            logger.info("Custom PRE filter : request id -> {}", request.getId());

            //post filter 동작
            return chain.filter(exchange).then(Mono.fromRunnable(()->{  //스프링5에서 지원하는 기능으로 비동기로 값을 전달할때 사용되는 객체
            	logger.info("Custom POST filter : response id -> {}", response.getStatusCode());
            }));
        }, Ordered.HIGHEST_PRECEDENCE); //필터의 우선순위
        return filter;
    }


    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
        public boolean isPreLogger() {
			return preLogger;
		}
        public void setPreLogger(boolean preLogger) {
			this.preLogger = preLogger;
		}
        public boolean isPostLogger() {
			return postLogger;
		}
        public void setPostLogger(boolean postLogger) {
			this.postLogger = postLogger;
		}
        public String getBaseMessage() {
			return baseMessage;
		}
        public void setBaseMessage(String baseMessage) {
			this.baseMessage = baseMessage;
		}
    }
}