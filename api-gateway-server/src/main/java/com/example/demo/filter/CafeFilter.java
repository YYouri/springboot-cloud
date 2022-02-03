package com.example.demo.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CafeFilter extends AbstractGatewayFilterFactory<CafeFilter.Config> {
    private static final Logger logger = LogManager.getLogger(CafeFilter.class);
    public CafeFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            logger.info("GlobalFilter baseMessage>>>>>>" + config.getBaseMessage());
            if (config.isPreLogger()) {
                logger.info("GlobalFilter Start>>>>>>" + exchange.getRequest());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                if (config.isPostLogger()) {
                    logger.info("GlobalFilter End>>>>>>" + exchange.getResponse());
                }
            }));
        });
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