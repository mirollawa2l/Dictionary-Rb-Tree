/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package c.dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mirol
 */
public class TreeOperation {
    
      private Tree tree;
    private ArrayList<String> words=new ArrayList<>();
    private String filename="Dictionary.txt";

    public TreeOperation(Tree tree) {
        this.tree = tree;
        loadDictionary(filename);
    }
    
        
    public Node search(String key, Node node) {
        if (node == null || node.getData() == null||key==null)
            return null;
 if (node == node.getLeft() || node == node.getRight()) {
        System.err.println("ERROR: Node links to itself at " + node.getData());
        return null;
    }
        if (node.getData().equalsIgnoreCase(key))
            return node;
        else if (node.getData().compareToIgnoreCase(key) < 0)
            return search(key, node.getRight());
        else if (node.getData().compareToIgnoreCase(key) > 0)
            return search(key, node.getLeft());
        return null;
    }
    
    public Node lastInsert(Node node, String key) {
    while (true) {
        if (node == null || node.getData() == null) return null;

        int cmp = key.compareToIgnoreCase(node.getData());

        if (cmp < 0) {
            if (node.getLeft() == null) {
                Node insertedNode = new Node();
                insertedNode.setData(key);
                insertedNode.setParent(node);
                node.setLeft(insertedNode);
                System.out.println("lastinsert");
                return insertedNode;
            }
            // Prevent infinite loop
            if (node == node.getLeft()) {
                System.err.println("ERROR: Node links to itself (left) at " + node.getData());
                return null;
            }
            node = node.getLeft();
        } else if (cmp > 0) {
            if (node.getRight() == null) {
                Node insertedNode = new Node();
                insertedNode.setData(key);
                insertedNode.setParent(node);
                node.setRight(insertedNode);
                return insertedNode;
            }
            // Prevent infinite loop
            if (node == node.getRight()) {
                System.err.println("ERROR: Node links to itself (right) at " + node.getData());
                return null;
            }
            node = node.getRight();
        } else {
            return null; // Key already exists
        }
    }
}

public Node getUncle(Node node) {
        if (node == null || node.getParent() == null || node.getParent().getParent() == null)
            return null;

        Node parent = node.getParent();
        Node grandparent = parent.getParent();

        if (grandparent.getLeft() == parent)
            return grandparent.getRight();
        else
            return grandparent.getLeft();
    }

    public boolean isLeftLeft(Node node) {
        if (node == null || node.getParent() == null || node.getParent().getParent() == null)
            return false;

        Node parent = node.getParent();
        Node gparent = parent.getParent();
        System.out.println("isLeftLeft");
        return (parent == gparent.getLeft() && node == parent.getLeft());
         
    }

    public boolean isLeftRight(Node node) {
        if (node == null || node.getParent() == null || node.getParent().getParent() == null)
            return false;

        Node parent = node.getParent();
        Node gparent = parent.getParent();
        return (parent == gparent.getLeft() && node == parent.getRight());
    }

    public boolean isRightLeft(Node node) {
        if (node == null || node.getParent() == null || node.getParent().getParent() == null)
            return false;

        Node parent = node.getParent();
        Node gparent = parent.getParent();
        return (parent == gparent.getRight() && node == parent.getLeft());
    }

    public boolean isRightRight(Node node) {
        if (node == null || node.getParent() == null || node.getParent().getParent() == null)
            return false;

        Node parent = node.getParent();
        Node gparent = parent.getParent();
        return (parent == gparent.getRight() && node == parent.getRight());
    }


    public void swapColor(Node node) {
        if (node == null || node.getColor() == null)
            return;

        if (node.getColor().equalsIgnoreCase("black"))
            node.setColor("red");
        else
            node.setColor("black");
    }
    
  
    public void printTree(Node node) {
        if (node == null)
            return;

        printTree(node.getLeft());
        System.out.println(node.getData() + " (" + node.getColor() + ")");
        printTree(node.getRight());
    }
      
private void leftRotate(Node x) {
    System.out.println("leftrotate");
   Node y=x.getRight();
   x.setRight(y.getLeft());
   if(y.getLeft()!=null)
   {
       y.getLeft().setParent(x);
   }
   y.setParent(x.getParent());
   if(x.getParent()==null)
   {
       tree.setRoot(y);
   }
   else if(x==x.getParent().getLeft())
   {
       x.getParent().setLeft(y);
   }
   else 
       x.getParent().setRight(y);
    y.setLeft(x);
    x.setParent(y);
}

/*


*/

private void rightRotate(Node x) {
    System.out.println("RIGHTrotate");
   Node y = x.getLeft();
x.setLeft(y.getRight());
if (y.getRight() != null) {
    y.getRight().setParent(x);
}
y.setParent(x.getParent());
if (x.getParent() == null) {
    tree.setRoot(y);
} else if (x == x.getParent().getRight()) {
    x.getParent().setRight(y);
} else {
    x.getParent().setLeft(y);
}
y.setRight(x);
x.setParent(y);

}

      
public int getTreeHeight(Node node) {
    if (node == null) return 0;
    return 1 + Math.max(getTreeHeight(node.getLeft()), getTreeHeight(node.getRight()));
}
     
    public int getBlackHeight(Node node) {
    if (node == null) 
        return 0; // Null (leaf) nodes are considered black
  if(node.getColor().equalsIgnoreCase("black"))
      return getBlackHeight(node.getLeft())+1;
  else
      return getBlackHeight(node.getLeft());
}
     
    public boolean checkBlackHeight(Node node)
    {
        int l=getBlackHeight(node.getLeft());
        int r=getBlackHeight(node.getRight());
      return r==l;
    }
    
    public int getTreeSize(Node node)
    {
            if (node == null) return 0;
    return 1 + getTreeSize(node.getLeft()) + getTreeSize(node.getRight());
    }


    
    public void loadDictionary(String filename) {
        int count=0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    insert(line);
                    words.add(line);
                    count++;
                }
            }
            reader.close();
            System.out.println("File loaded "+count+ " words");
        } catch (IOException e) {
            System.out.println("Error reading dictionary file: " + e.getMessage());
        }
    }
    
    public void Look_up_a_word(String name)
    {
       if(search(name,tree.getRoot())!=null)
            System.out.println("Yes");
       else 
            System.out.println("No");
    }
    
    public void insertWord(String key)
    {
        insert(key);
        words.add(key);
        save(words,filename);
    }
    
    
     public static void save(ArrayList<String> list, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String item : list) {
                writer.write(item);
                writer.newLine();
            }
            System.out.println("ArrayList saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving ArrayList to file: " + e.getMessage());
        }
    }
    
     
  public boolean checkRedNodeViolation(Node node) {
    // Base case: If the node is null, it is valid
    if (node == null) {
        return true;
    }

    // Check if the current node is red
    if (node.getColor().equalsIgnoreCase("red")) {
        // If the node is red, check if its left or right child is red
        if ((node.getLeft() != null && node.getLeft().getColor().equalsIgnoreCase("red")) ||
            (node.getRight() != null && node.getRight().getColor().equalsIgnoreCase("red"))) {
            
            // Log detailed information about the violation
            System.out.println("Red node violation detected!");
            System.out.println("Violation at node: " + nodeToString(node));
            if (node.getLeft() != null && node.getLeft().getColor().equalsIgnoreCase("red")) {
                System.out.println("Violation due to left child: " + nodeToString(node.getLeft()));
            }
            if (node.getRight() != null && node.getRight().getColor().equalsIgnoreCase("red")) {
                System.out.println("Violation due to right child: " + nodeToString(node.getRight()));
            }
            return false; // Violation found
        }
    }

    // Recursively check left and right subtrees
    boolean leftValid = checkRedNodeViolation(node.getLeft());
    boolean rightValid = checkRedNodeViolation(node.getRight());

    // If a violation is found in any subtree, log it
    if (!leftValid || !rightValid) {
        System.out.println("Violation detected in one of the subtrees of node: " + nodeToString(node));
    }

    return leftValid && rightValid; // If both subtrees are valid, return true, else false
}

// Helper method to convert node details to a string for better logging
private String nodeToString(Node node) {
    String parentInfo = (node.getParent() != null) ? "Parent: " + node.getParent().getData() : "No parent";
    String leftInfo = (node.getLeft() != null) ? "Left: " + node.getLeft().getData() : "No left child";
    String rightInfo = (node.getRight() != null) ? "Right: " + node.getRight().getData() : "No right child";

    return "Node: " + node.getData() + " | Color: " + (node.getColor().equalsIgnoreCase("red") ? "RED" : "BLACK") +
            " | " + parentInfo + " | " + leftInfo + " | " + rightInfo;
}

     public void checkRBTree(Node node)
     {
         if(checkRedNodeViolation(node)==true)
             System.out.println("Tree is valid");
         else 
             System.out.println("Tree is invalid");
     }

     
     public void fixInsert(Node node)
     {
        while (node != tree.getRoot() && node.getParent().getColor().equalsIgnoreCase("red")) {
        Node parent = node.getParent();
        Node grandparent = parent.getParent();
        Node uncle = getUncle(node);

        // Case 1: Uncle is red – recolor
        if (uncle != null && uncle.getColor().equalsIgnoreCase("red")) {
            parent.setColor("black");
            uncle.setColor("black");
            grandparent.setColor("red");
            node = grandparent;
        } else {
            // Uncle is black or null – do rotations
            if (isLeftLeft(node)) {
                rightRotate(grandparent);
                parent.setColor("black");
                grandparent.setColor("red");
            } else if (isRightRight(node)) {
                leftRotate(grandparent);
                parent.setColor("black");
                grandparent.setColor("red");
            } else if (isLeftRight(node)) {
                leftRotate(parent);
                rightRotate(grandparent);
                node.setColor("black");
                grandparent.setColor("red");
            } else if (isRightLeft(node)) {
                rightRotate(parent);
                leftRotate(grandparent);
                node.setColor("black");
                grandparent.setColor("red");
            }

            break; // Fix is complete
        }
    }

    tree.getRoot().setColor("black"); // Ensure root stays black
}
     
      
   public void insert(String key)
   {
       Node node=new Node(key);
       Node y=null;
       Node x=tree.getRoot();
       while(x!=null)
       {
           y=x;
           if(node.getData().compareToIgnoreCase(x.getData())<0)
               x=x.getLeft();
           else
               x=x.getRight();
       }
       node.setParent(y);
       if(y==null)
       {
           tree.setRoot(node);
       }
       else if(node.getData().compareToIgnoreCase(y.getData())<0)
           y.setLeft(node);
       else
           y.setRight(node);
       
       if(node.getParent()==null)
       {
           node.setColor("black");
           return;
       }
       if(node.getParent().getParent()==null)
           return;
       fixInsert(node);
       
   }
    
}
