/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package c.dictionary;

/**
 *
 * @author hp
 */
public class Tree {
    private Node root ;
    private int size;

    public Tree() {
        this.root = null;
        this.size = 0;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Tree{" + "root=" + root + ", size=" + size + '}';
    }
  
    
    
}
