package com.itsthatjun.ecommerce.service;

import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisService {

    // shared operations

    @ApiOperation(value = "set expiration")
    Boolean expire(String key, long time);

    @ApiOperation(value = "get expiration")
    Long getExpire(String key);

    @ApiOperation(value = "check if key exist")
    Boolean hasKey(String key);


    // String related operations

    @ApiOperation(value = "Set a value with an optional expiration time")
    void set(String key, Object value, long time);

    @ApiOperation(value = "Set a value")
    void set(String key, Object value);

    @ApiOperation(value = "Get the value for a given key")
    Object get(String key);

    @ApiOperation(value = "Delete a key-value pair")
    Boolean del(String key);

    @ApiOperation(value = "Delete multiple key-value pairs")
    Long del(List<String> keys);

    @ApiOperation(value = "Increment the value of a key by a specified delta")
    Long incr(String key, int delta);

    @ApiOperation(value = "Decrement the value of a key by a specified delta")
    Long decr(String key, int delta);


    // List related operations

    @ApiOperation(value = "Get a range of elements from a list")
    List<Object> lRange(String key, int start, int end);

    @ApiOperation(value = "Get the size of a list")
    Long lSize(String key);

    @ApiOperation(value = "Get the element at a specific index in a list")
    Object lIndex(String key, int index);

    @ApiOperation(value = "Push an element to the left of a list")
    Long lPush(String key, Object value);

    @ApiOperation(value = "Push an element to the left of a list with an expiration time")
    Long lPush(String key, Object value, long time);

    @ApiOperation(value = "Push multiple elements to the left of a list")
    Long lPushAll(String key, Object... values);

    @ApiOperation(value = "Push multiple elements to the left of a list with an expiration time")
    Long lPushAll(String key, Long time, Object... values);

    @ApiOperation(value = "Remove elements from a list by count")
    Long lRemove(String key, int count, Object value);


    // Set operations related

    @ApiOperation(value = "Get all members of a set")
    Set<Object> sMembers(String key);

    @ApiOperation(value = "Add one or more members to a set")
    Long sAdd(String key, Object... values);

    @ApiOperation(value = "Add members to a set with an expiration time")
    Long sAdd(String key, long time, Object... values);

    @ApiOperation(value = "Check if a value is a member of a set")
    Boolean sIsMember(String key, Object value);

    @ApiOperation(value = "Get the size of a set")
    Long sSize(String key);

    @ApiOperation(value = "Remove one or more members from a set")
    Long sRemove(String key, Object... values);


    // Hash or map related operations

    @ApiOperation(value = "Get the value associated with a hash key")
    Object hGet(String key, String hashKey);

    @ApiOperation(value = "Set a hash key-value pair with an optional expiration time")
    Boolean hSet(String key, String hashKey, Object value, long time);

    @ApiOperation(value = "Set a hash key-value pair")
    void hSet(String key, String hashKey, Object value);

    @ApiOperation(value = "Get all key-value pairs in a hash")
    Map<Object, Object> hGetAll(String key);

    @ApiOperation(value = "Set multiple key-value pairs in a hash with an optional expiration time")
    Boolean hSetAll(String key, Map<String, Object> map, long time);

    @ApiOperation(value = "Set multiple key-value pairs in a hash")
    void hSetAll(String key, Map<String, ?> map);

    @ApiOperation(value = "Delete one or more hash keys")
    void hDel(String key, Object... hashKey);

    @ApiOperation(value = "Check if a hash key exists")
    Boolean hHasKey(String key, String hashKey);

    @ApiOperation(value = "Increment the value associated with a hash key")
    Long hIncr(String key, String hashKey, Long delta);

    @ApiOperation(value = "Decrement the value associated with a hash key")
    Long hDecr(String key, String hashKey, Long delta);
}
