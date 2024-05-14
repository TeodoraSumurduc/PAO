package org.example;

import org.example.CustomContainer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CustomContainerImpl implements CustomContainer {
    private Map<Object, String> instances = new HashMap<>();
    private Map<Class<?>, Function<CustomContainer, ?>> factories = new HashMap<>();
    public CustomContainerImpl() {
        this.instances = new HashMap<>();
    }

    @Override
    public <T> boolean addInstance(T instance) {
        if (instance == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }
        String name = instance.getClass().getName();
        instances.put(instance, name);
        return true;
    }

    @Override
    public <T> boolean addInstance(T instance, String customName) {
        if (instance == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }
        if (instances.containsKey(customName)) {
            throw new IllegalStateException("Instances cannot be redeclared");
        }
        instances.put(instance, customName);
        return true;
    }

    @Override
    public <T> T getInstance(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }
        for (Object o : instances.values()) {
            if (type.isInstance(o)) {
                return type.cast(o);
            }
        }
        String name = type.getClass().getName();
        instances.put(type, name);
        return (T) instances.get(type);
    }

    @Override
    public <T> T getInstance(Class<T> type, String customName) {
        if(type == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }
        if (instances.containsKey(customName)) {
            throw new IllegalStateException("Invalid type for object");
        }
        for (Object o : instances.values()) {
            if (type.isInstance(o)) {
                return type.cast(o);
            }
        }
        instances.put(type, customName);
        return (T) instances.get(type);
    }

    @Override
    public <T> boolean addFactoryMethod(Class<T> type, Function<CustomContainer, T> factoryMethod) {
        if (type == null || factoryMethod == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }
        if (factories.containsKey(type)) {
            throw new IllegalStateException("Factory method already exists for type: " + type.getName());
        }
        factories.put(type, factoryMethod);
        return true;
    }

    @Override
    public <T> T create(Class<T> type) {
        return null;
    }

    @Override
    public <T> T create(Class<T> type, Map<String, Object> parameters) {
        if (type == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }
        Function<CustomContainer, T> factoryMethod = (Function<CustomContainer, T>) factories.get(type);
        if (factoryMethod != null) {
            return factoryMethod.apply(this);
        } else {
            try {
                Constructor<T> constructor = type.getDeclaredConstructor();
                constructor.setAccessible(true);
                return constructor.newInstance();
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                throw new IllegalStateException("Cannot provide instance", e);
            }
        }
    }

    @Override
    public void close() throws Exception {
        for (Object instance : instances.keySet()) {
            if (instance instanceof AutoCloseable) {
                ((AutoCloseable) instance).close();
            }
        }
    }

}