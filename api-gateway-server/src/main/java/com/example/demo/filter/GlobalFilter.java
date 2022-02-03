package com.example.demo.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {
    private static final Logger logger = LogManager.getLogger(GlobalFilter.class);
    public GlobalFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
    	  //filter���� �ϰ� ���� ������ ������
        //pre filter ����
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            logger.info("Global filter message : {}", config.getMessage());

            if(config.isPreLogger()){
            	logger.info("Global filter Start : request id -> {}", request.getId());
            }
            //post filter ����
            return chain.filter(exchange).then(Mono.fromRunnable(()->{  //������5���� �����ϴ� ������� �񵿱�� ���� �����Ҷ� ���Ǵ� ��ü
                if(config.isPostLogger()){
                	logger.info("Global filter End : response code -> {}", response.getStatusCode());
                }

            }));
        });
    }

    public static class Config {
    	private String Message;
        private boolean preLogger;
        private boolean postLogger;
		public String getMessage() {
			return Message;
		}
		public void setMessage(String message) {
			Message = message;
		}
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
        
    }
}