package com.hi.weiliao.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class MapUtils {

    private static final Logger logger = LoggerFactory.getLogger(MapUtils.class);

    /**
     * Map 按照value排序
     *
     * @param map 需要排序的Map
     * @param method 排序方式，-1为降序， 1为升序
     * @return 排序结果
     *
     * @auth LD
     * @Create date 2018-12-28
     * */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, int method){
        if (map == null || map.isEmpty()) {
            return null;
        }

        List<Map.Entry<K, V>> linkedList = new LinkedList<>(map.entrySet());
        Collections.sort(linkedList, new Comparator<Map.Entry<K, V>>(){
            @Override
            public int compare(Map.Entry<K, V> map1, Map.Entry<K, V> map2)
            {
                return (map1.getValue().compareTo(map2.getValue())) * method;
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : linkedList) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    /**
     * Map 按照key排序
     *
     * @param map 需要排序的Map
     * @param method 排序方式，-1为降序， 1为升序
     * @return 排序结果
     *
     * @auth LD
     * @Create date 2018-12-28
     * */
    public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map, int method){
        if (map == null || map.isEmpty()) {
            return null;
        }

        List<Map.Entry<K, V>> linkedList = new LinkedList<>(map.entrySet());
        Collections.sort(linkedList, new Comparator<Map.Entry<K, V>>(){
            @Override
            public int compare(Map.Entry<K, V> map1, Map.Entry<K, V> map2)
            {
                return (map1.getKey().compareTo(map2.getKey())) * method;
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : linkedList) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    /**
     * 使用List初始化MAP,（个人用来初始化Excel标题）
     *
     * @param keys 需要排序的Map
     * @param values 排序方式，1为降序， -1为升序
     * @return 排序结果
     *
     * @auth LD
     * @Create date 2018-12-28
     * */
    public static <K, V> Map<K, V> initMapByList(List<K> keys, List<V> values){
        if(keys == null || keys.size() == 0){
            return null;
        }
        Map<K, V> result = new LinkedHashMap<>();
        for (int i = 0; i<keys.size(); i++){
            result.put(keys.get(i), values.get(i));
        }
        return result;
    }

    /**
     * 迭代器遍历MAP
     *
     * @param map 待遍历的Map
     * @param invoke 操作map数据，实现Invoke中execute方法
     * @return 排序结果
     *
     * @auth LD
     * @Create date 2018-12-28
     * */
    public static <K, V> void ergodicMapByIterator(Map<K, V> map, Invoke<K, V> invoke){
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<K, V> entry = it.next();
            invoke.excute(entry.getKey(), entry.getValue());
        }
    }

    /**
     * EntrySet遍历MAP（MAP容量大建议使用）
     *
     * @param map 待遍历的Map
     * @param invoke 操作map数据，实现Invoke中execute方法
     * @return 排序结果
     *
     * @auth LD
     * @Create date 2018-12-28
     * */
    public static <K, V> void ergodicMapByEntrySet(Map<K, V> map, Invoke<K, V> invoke){

        for (Map.Entry<K, V> entry: map.entrySet()) {
            invoke.excute(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Map 操作， 使用时需要实现下面接口的方法
     * */
    public interface Invoke<K, V> {

        void excute(K key, V value);
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "d");
        map.put(2, "a");
        map.put(3, "c");
        map.put(4, "b");

        logger.info("===============================通过value升序排序！！！！");
        map = MapUtils.sortByValue(map, 1);

        MapUtils.ergodicMapByIterator(map, new Invoke<Integer, String>() {
            @Override
            public void excute(Integer key, String value) {
                logger.info("key=" + key + "           value=" + value);
            }
        });

        logger.info("===============================通过value降序排序！！！！");
        map = MapUtils.sortByValue(map, -1);

        MapUtils.ergodicMapByIterator(map, new Invoke<Integer, String>() {
            @Override
            public void excute(Integer key, String value) {
                logger.info("key=" + key + "           value=" + value);
            }
        });

        logger.info("===============================通过key降序排序！！！！");
        map = MapUtils.sortByKey(map, -1);

        MapUtils.ergodicMapByEntrySet(map, new Invoke<Integer, String>() {
            @Override
            public void excute(Integer key, String value) {
                logger.info("key=" + key + "           value=" + value);
            }
        });

        logger.info("===============================通过key升序排序！！！！");
        map = MapUtils.sortByKey(map, 1);

        MapUtils.ergodicMapByEntrySet(map, new Invoke<Integer, String>() {
            @Override
            public void excute(Integer key, String value) {
                logger.info("key=" + key + "           value=" + value);
            }
        });
    }
}
