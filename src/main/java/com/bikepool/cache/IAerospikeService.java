package com.bikepool.cache;

import com.aerospike.client.AerospikeClient;

/**
 * Created by rampal on 15/11/17.
 */
public interface IAerospikeService {

     void loadAerospikeClient(String aerospikeIPs);

     AerospikeClient getAerospikeClient();
}
