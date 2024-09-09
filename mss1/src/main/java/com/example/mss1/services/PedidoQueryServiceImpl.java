package com.example.mss1.services;

import com.example.mss1.domain.Pedido;
import com.example.mss1.infra.PedidoRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoQueryServiceImpl implements PedidoQueryService {

    private final EventStore eventStore;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoQueryServiceImpl(EventStore eventStore, PedidoRepository pedidoRepository) {
        this.eventStore = eventStore;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Object> listEvents(String id) {
        List<Object> retorno = eventStore.readEvents(id, 0)
                .asStream()
                .map(record -> record.getPayload()).collect(Collectors.toList());
        return retorno;
    }

    public Optional<Pedido> getById(String id) {
        return pedidoRepository.findById(id);
    }


}
