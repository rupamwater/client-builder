package guru.learningjournal.kafka.examples;

import guru.learningjournal.kafka.examples.serde.AppSerdes;
import guru.learningjournal.kafka.examples.types.EntityIdentifier;
import guru.learningjournal.kafka.examples.types.CorporateEntity;
import guru.learningjournal.kafka.examples.types.Corporate;

import guru.learningjournal.kafka.examples.types.PosInvoice;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Properties;
import java.util.Map;

public class RewardsApp {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, AppConfigs.applicationID);
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.bootstrapServers);
        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG,0);

        StreamsBuilder builder = new StreamsBuilder();
        KStream <String, EntityIdentifier> KS0 =  builder.stream(AppConfigs.sysIdentTopicName,
            Consumed.with(AppSerdes.String(), AppSerdes.SystemIdentifier())
        )
        .mapValues( (value) -> {return Notifications.getEntityIdentifierFrom(value); });


        KGroupedStream<String, EntityIdentifier> KGS0 = KS0.groupByKey(Grouped.with(AppSerdes.String(), AppSerdes.EntityIdentifier()));

        KTable<String, EntityIdentifier> KT0 = KGS0.reduce((aggValue, newValue) -> {

            Map<String, String> identifiers = aggValue.getIdentifiers();
            Map<String, String> newIdentifiers = newValue.getIdentifiers();

            Map<String, String> combIdentifiers = new HashMap<String, String>();
            combIdentifiers.putAll(identifiers);
            combIdentifiers.putAll(newIdentifiers);
            newValue.withIdentifiers(combIdentifiers);
            return newValue;

        });

        KTable<String , CorporateEntity> KT1 = builder.table(AppConfigs.corpEntityTopicName,
                Consumed.with(AppSerdes.String(), AppSerdes.CorporateEntity())
        );

        KT0.join(KT1 , (v1 , v2 ) -> {
            Corporate v3 = new Corporate();
              v2.setIdentifiers(v2.getIdentifiers());
              return v2;
        }  )
        .toStream().to(AppConfigs.corpTopicName, Produced.with(AppSerdes.String(), AppSerdes.Corporate()));


        logger.info("Starting Stream");
        KafkaStreams stream = new KafkaStreams(builder.build(), props);
        stream.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Stopping Streams");
            stream.cleanUp();
        }));
    }
}
