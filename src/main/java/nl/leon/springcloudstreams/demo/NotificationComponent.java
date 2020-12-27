package nl.leon.springcloudstreams.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;
import java.sql.Timestamp;

/**
 * @author : Leon Jongsma
 */
@Component
public class NotificationComponent {

    private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Bean
    public Consumer<String> receiveNotification() {
        return payload -> {
            logger.info("notification: " + payload + " " + new Timestamp(System.currentTimeMillis()));
        };
    }
}
