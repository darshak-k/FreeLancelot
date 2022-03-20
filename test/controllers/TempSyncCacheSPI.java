package controllers;

import play.cache.SyncCacheApi;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;

/**
 * @author Darshak
 */
public class TempSyncCacheSPI implements SyncCacheApi {
    private final HashMap<String, Object> cache = new HashMap();
    @Override
    public <T> Optional<T> get(String key) {
        if(cache.containsKey(key)) {
            return (Optional<T>) Optional.of(this.cache.get(key));
        }

        return  Optional.empty();
    }

    @Override
    public <T> T getOrElseUpdate(String key, Callable<T> block, int expiration) {
        return this.getOrElseUpdate(key, block);
    }

    @Override
    public <T> T getOrElseUpdate(String key, Callable<T> block) {
        Object o = this.cache.get(key);
        if (Objects.isNull(o)) {
            try {
                return block.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ((T) o);
    }

    @Override
    public void set(String key, Object value, int expiration) {
        this.set(key, value);
    }

    @Override
    public void set(String key, Object value) {
        this.cache.put(key, value);
    }

    @Override
    public void remove(String key) {
        this.cache.remove(key);
    }
}
