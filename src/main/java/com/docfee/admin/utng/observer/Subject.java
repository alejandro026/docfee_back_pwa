package com.docfee.admin.utng.observer;

public interface Subject
{
    void Subscribe(IObservador observer);
    void Unsubscribe(IObservador observer);
    void Notify();
}