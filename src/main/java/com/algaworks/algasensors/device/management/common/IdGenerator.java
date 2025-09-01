package com.algaworks.algasensors.device.management.common;

import io.hypersistence.tsid.TSID;

import java.util.Optional;

public class IdGenerator {

    private static final TSID.Factory tsidFactory;

    static {

        // 1) tenta ler do ambiente (SO/IDE)
        Optional.ofNullable(System.getenv("tsid.node"))
                .ifPresent(tsidNode -> System.setProperty("tsid.node", tsidNode));

        Optional.ofNullable(System.getenv("tsid.node.count"))
                .ifPresent(tsidNodeCount -> System.setProperty("tsid.node.count", tsidNodeCount));

        // 2) cria a “máquina de IDs” já considerando as system properties
        tsidFactory = TSID.Factory.builder().build();
    }

    // Impede que alguém instancie esta classe com new, sendo necessário
    // usar o método generateTSID
    private IdGenerator() {
    }

    // 3) ponto único para pedir um ID novo
    public static TSID generateTSID() {
        return tsidFactory.generate();
    }

}
