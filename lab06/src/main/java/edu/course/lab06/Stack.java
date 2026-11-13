package edu.course.lab06;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public final class Stack<T> {
        private final ArrayList<T> arr = new ArrayList<>();

        public void push(T value){
            if (value == null){
                throw new IllegalArgumentException("Value is null");
            }
            this.arr.add(value);
        }
        public T pop(){
            if (this.isEmpty()){
                throw new NoSuchElementException("Stack is empty for pop");
            }
            return this.arr.remove(arr.size() - 1);
        }
        public T peek(){
            if (this.isEmpty()){
                throw new NoSuchElementException("Stack is empty for peek");
            }
            return this.arr.get(arr.size()-1);
        }
        public int size(){
            return this.arr.size();
        }
        public boolean isEmpty(){
            return this.arr.isEmpty();
        }
        
    }
