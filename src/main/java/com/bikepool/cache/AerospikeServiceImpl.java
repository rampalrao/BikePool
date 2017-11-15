package com.bikepool.cache;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Host;
import com.aerospike.client.policy.ClientPolicy;
import com.bikepool.properties.BikeShareProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by rampal on 15/11/17.
 */
@Service("aerospikeServiceImpl")
public class AerospikeServiceImpl implements IAerospikeService {
    private static final Logger LOG = LoggerFactory.getLogger(AerospikeServiceImpl.class);
    private volatile static AerospikeClient client;

    public synchronized void loadAerospikeClient(String aerospikeIPs) {
        if (client == null) {
            LOG.info("Loading Aerospike Client");
            if (aerospikeIPs == null) {
                LOG.error("aerospike-hosts entry is missing in property table");
                return;
            }
            String[] hostIPs = aerospikeIPs.split(",");
            Host[] hosts = new Host[hostIPs.length];
            for (int i = 0; i < hostIPs.length; i++) {
                hosts[i] = new Host(hostIPs[i], 3000);
            }

            try {
                ClientPolicy policy = new ClientPolicy();
                policy.readPolicyDefault.timeout = 4000;
                policy.readPolicyDefault.maxRetries = 2;
                policy.readPolicyDefault.sleepBetweenRetries = 10;
                policy.writePolicyDefault.timeout = 4000;
                policy.writePolicyDefault.maxRetries = 2;
                policy.writePolicyDefault.sleepBetweenRetries = 50;

                client = new AerospikeClient(policy, hosts);
                LOG.info("Aerospike Loaded successfully");
            } catch (Exception e) {
                LOG.error("Error in loading aerospike client: " + e.getLocalizedMessage());
            }
        }
    }

    public AerospikeClient getAerospikeClient() {
        if (client == null) {
            loadAerospikeClient(BikeShareProperties.getInstance().getProperty("aerospike.hosts"));
        }
        return client;
    }
}
