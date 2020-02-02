/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gamedu
 */
public class UnionFinderQuadratic {
    private int[] id;

    public UnionFinderQuadratic(int size) {
        this.id = new int[size];
        for (int i=0; i<size; i++)
            this.id[i] = i;
    }

    boolean connected(int p, int q) {
        return this.id[p] == this.id[q];
    }

    void union(int p, int q) {
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
