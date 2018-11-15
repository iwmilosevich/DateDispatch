package com.ivan.repository;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * This will not be needed once DB is setup, this is only here to generate IDs for new objects
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class IdGenerator {

    private AtomicLong nextId = new AtomicLong(1);

    public long getNextId() {
        return nextId.getAndIncrement();
    }
}
