package producer;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

public class CustomPartitioner implements Partitioner{

    private static final int PARTITION_COUNT=1;

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        Integer keyInteger = Integer.parseInt(key.toString());
        return keyInteger % PARTITION_COUNT;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
