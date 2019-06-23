package com.semantic.sparql;

import java.util.LinkedList;

public class ServerList {

    private static LinkedList<String> servers;

    private static ServerList instance;

    private ServerList() {
        servers = new LinkedList<>();
        servers.add("http://localhost:3030//ds/query");
    }

    public static ServerList getInstance() {
        if (ServerList.instance == null) {
            ServerList.instance = new ServerList();
        }
        return ServerList.instance;
    }

    public LinkedList<String> getServers() {
        return servers;
    }

    public boolean add(String newServer) {
        int index = servers.indexOf(newServer);

        if (index >= 0) {
            return false;
        }
        servers.addLast(newServer);
        return true;
    }

    public boolean remove(String rem) {
        int index = servers.indexOf(rem);

        if (index >= 0) {
            servers.remove(index);
            return true;
        }
        return false;
    }
}
