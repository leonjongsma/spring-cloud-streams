package nl.leon.springcloudstreams.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import java.sql.Timestamp;

/**
 * @author : Leon Jongsma
 */
@RestController
public class RestResource {

    @Autowired
    private StreamBridge streamBridge;

    private static Logger logger = LoggerFactory.getLogger(RestResource.class);

    @GetMapping(value= "/notification")
    public void createNotification() {
        logger.info("notification: " + new Timestamp(System.currentTimeMillis()));
        streamBridge.send("notification-out-0", "notification");

    }
}