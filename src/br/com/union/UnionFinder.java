package br.com.union;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gamedu
 */
public interface UnionFinder {    
    boolean connected(int p, int q);
    void union(int p, int q);    
    void print();    
}
