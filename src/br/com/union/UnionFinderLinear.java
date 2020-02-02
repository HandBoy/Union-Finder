package br.com.union;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gamedu
 * 
 *  input:
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
 * output: 1 | 8 | 1 | 8 | 3 | 0 | 5 | 1 | 8 | 8 |
 */
public class UnionFinderLinear implements UnionFinder{
    private int[] id;

    public UnionFinderLinear(int size) {
        //Set id of each object to itself
        this.id = new int[size];
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
        this.id[i] = j;
    }
    
    @Override
    public void print(){
        for (int i=0; i<this.id.length; i++)
            System.out.print(this.id[i] + " | ");
        
    }
    
}
