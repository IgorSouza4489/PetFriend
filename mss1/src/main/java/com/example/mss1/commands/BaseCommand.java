package com.example.mss1.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.Date;


public class BaseCommand<T> {

    @TargetAggregateIdentifier
    public final T id;

    public BaseCommand(T id) {
        this.id = id;
    }
}

