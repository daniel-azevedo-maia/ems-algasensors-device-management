package com.algaworks.algasensors.device.management.domain.model;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class SensorId implements Serializable {

    private TSID value; // O verdadeiro identificador do sensor (um TSID)

    // Construtor recebendo diretamente um TSID já pronto
    public SensorId(TSID value) {
        Objects.requireNonNull(value); // Evita null
        this.value = value;
    }

    // Construtor recebendo um número longo (como vem do banco)
    public SensorId(Long value) {
        Objects.requireNonNull(value);
        this.value = TSID.from(value); // Converte long para TSID
    }

    // Construtor recebendo uma string (como vem de APIs ou JSON)
    public SensorId(String value) {
        Objects.requireNonNull(value);
        this.value = TSID.from(value); // Converte string para TSID
    }

    @Override
    public String toString() {
        return value.toString(); // Quando imprimir, mostra a forma string do TSID
    }
}
