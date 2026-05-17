
package c.dictionary;

public class Node {
    private String color;
    private String data;
    private Node left;
    private Node right;
    private Node parent;

    public Node(String data) {
        this.data = data;
        this.color="red";
        this.right=null;
        this.left=null;
        this.parent=null;
    }

    
    public Node() {
    this.color="red";
       this.right=null;
        this.left=null;
        this.parent=null;
    }

   

    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

   
    
}
