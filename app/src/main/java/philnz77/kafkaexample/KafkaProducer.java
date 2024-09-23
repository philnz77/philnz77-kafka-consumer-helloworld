package philnz77.kafkaexample;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 10000) // Execute every 10 seconds
    public void performTask() {
        long t0 = System.currentTimeMillis();
        System.out.println("Task executed at " + t0);
        kafkaTemplate.send("my-topic", "foo" + t0);
    }
}
