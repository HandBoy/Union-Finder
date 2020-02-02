package br.com.union;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gamedu
 */
public class UnionFinderWaightedPathCompression {
    private int[] id;
    private int[] size;

    public UnionFinderWaightedPathCompression(int size) {
        //Set id of each object to itself
        this.id = new int[size];
        this.size = new int[size];
        Arrays.fill(this.size, 1);
        
        for (int i=0; i<size; i++)
            this.id[i] = i;
    }
    
    private int root(int i){
        //Chase parent pointers until reach root
        //(depth of i array accesses)
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        
        return i;
    }

    boolean connected(int p, int q) {
        //Check if p and p have same root
        // depth of p and q array accesses)
        return root(p) == root(q);
    }

    void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
        if (size[i] < size[j]){
            id[i] = j ; 
            size[j] += size[i];
        } else {
            id[j] = i ; 
            size[i] += size[j];
        }
    }
    
    public void print(){
        for (int i=0; i<this.id.length; i++)
            System.out.print(this.id[i] + " | ");
    }
}
