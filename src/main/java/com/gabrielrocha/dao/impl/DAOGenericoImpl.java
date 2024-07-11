package com.gabrielrocha.dao.impl;

import com.gabrielrocha.dao.DAOGenerico;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DAOGenericoImpl<K, V> implements DAOGenerico<K, V> {

    protected Map<K, V> map = new LinkedHashMap<>(16);

    public Map<K, V> getMap() {
        return map;
    }

    public void setMap(Map<K, V> map) {
        this.map = map;
    }

    public V incluir(K id, V obj) {
        return map.put(id, obj);
    }

    public V alterar(K id, V obj) {
        return map.put(id, obj);
    }

    public V remover(K id) {
        return map.remove(id);
    }

    public V recuperarPorId(K id) {
        return map.get(id);
    }

    public List<V> recuperarTodos() {
        return new ArrayList<>(map.values()); // .stream().toList();
    }
}

