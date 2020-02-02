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
 *  10
 *  4 3
 *  3 8
 *  6 5
 *  9 4
 *  2 1
 *  8 9
 *  5 0
 *  7 2
 *  6 1
 *  1 0
 *  6 7
 * 
 *  output: 
 *  1 | 1 | 1 | 8 | 8 | 1 | 1 | 1 | 8 | 8 |
 */
public class UnionFinderQuadratic implements UnionFinder {
    private int[] id;

    public UnionFinderQuadratic(int size) {
        this.id = new int[size];
        for (int i=0; i<size; i++)
            this.id[i] = i;
    }

    @Override
    public boolean connected(int p, int q) {
        return this.id[p] == this.id[q];
    }

    @Override
    public void union(int p, int q) {
        int pid = this.id[p];
        int qid = this.id[q];
        for (int i=0; i<this.id.length; i++)
            if(this.id[i] == pid) id[i] = qid;
    }
    
    public void print(){
        for (int i=0; i<this.id.length; i++)
            System.out.print(this.id[i]);
    }

}
