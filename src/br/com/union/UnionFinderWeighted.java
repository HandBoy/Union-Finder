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
 * 
 * input:
 * 10
 * 4 3
 * 3 8
 * 6 5
 * 9 4
 * 2 1
 * 5 0
 * 7 2
 * 6 1
 * 7 3
 * 
 * output: 6 | 2 | 6 | 4 | 6 | 6 | 6 | 2 | 4 | 4 |
 * 
 */
public class UnionFinderWeighted implements UnionFinder{
    private int[] id;
    private int[] size;

    public UnionFinderWeighted(int size) {
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
        while(i != id[i])
            i = id[i];
        
        return i;
    }

    @Override
    public boolean connected(int p, int q) {
        //Check if p and p have same root
        // (depth of p and q array accesses)
        return root(p) == root(q);
    }

    @Override
    public void union(int p, int q) {
        // Change root of p to point to root of q
        // (depth of p and q array accesses)
        int i = root(p);
        int j = root(q);
        if ( i==j)
            return ;
        
        if (this.size[i] < this.size[j]){
            this.id[i] = j;
            this.size[j] += this.size[i];
        } else {
            this.id[j] = i;
            this.size[i] += this.size[j];
        }
    }
    
    @Override
    public void print(){
        for (int i=0; i<this.id.length; i++)
            System.out.print(i + " | ");
        
        System.out.println();
        
        for (int i=0; i<this.id.length; i++)
            System.out.print(this.size[i] + " | ");
        
        System.out.println();
        
        for (int i=0; i<this.id.length; i++)
            System.out.print(this.id[i] + " | ");
        
    }
}
