package com.semantic.sparql;

import java.util.LinkedList;

public class ServerList {

    private static LinkedList<String> servers;

    private static void setup() {
        servers = new LinkedList<>();
        servers.add("http://localhost:3030//Onto/sparql");
//        TODO add RDF4J Server
    }

    public static LinkedList<String> getServers() {
        if (servers == null || servers.size() == 0) {
            setup();
        }
        return servers;
    }
}
