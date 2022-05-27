package com.mylib.cadastro.entidade;

import java.io.Serializable;

public interface Entidade<T> extends Serializable {
    T getId();

    void setId(T id);
}