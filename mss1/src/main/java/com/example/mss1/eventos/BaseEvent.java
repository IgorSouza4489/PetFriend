package com.example.mss1.eventos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public abstract class BaseEvent<T> {
    public final T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}