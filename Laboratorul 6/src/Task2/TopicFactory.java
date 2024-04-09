package Task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopicFactory {
    private static Map<String, Topic> topics = new HashMap<>();

    public static Topic getTopic(String topicName) {
        if (!topics.containsKey(topicName)) {
            topics.put(topicName, new Topic(topicName));
        }
        return topics.get(topicName);
    }
}
