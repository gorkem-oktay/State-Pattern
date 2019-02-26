package com.zafiru.observers;

import com.zafiru.observables.IObservable;

public interface IObserver {

    void updated(IObservable observable, Object value);
}
