package consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import pojo.CustomObject;

import java.util.Map;

public class CustomDeserializer implements Deserializer<CustomObject> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public CustomObject deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        CustomObject object = null;
        try {
            object = mapper.readValue(data, CustomObject.class);
        } catch (Exception exception) {
            System.out.println("Error in deserializer " + exception);
        }
        return object;
    }

    @Override
    public void close() {

    }
}
