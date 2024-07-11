package com.gabrielrocha.dao;

import java.util.List;
import java.util.Map;

public interface DAOGenerico<K, V> {
    V incluir(K id, V obj);
    V alterar(K id, V obj);
    Map<K, V> getMap();
    void setMap(Map<K, V> map);
    V remover(K id);
    V recuperarPorId(K id);
    List<V> recuperarTodos();
}
