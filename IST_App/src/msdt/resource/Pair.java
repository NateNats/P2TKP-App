/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msdt.resource;

import java.io.Serializable;

/**
 *
 * @author nicol
 */
public class Pair<T, U> implements Serializable {

    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;

    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(U second) {
        this.second = second;
    }
}
