/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package c.dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mirol
 */
public class Dictionary {

    public static void main(String[] args) {
     Tree tree=new Tree();
     TreeOperation manager=new TreeOperation(tree);
        System.out.println(manager.getBlackHeight(tree.getRoot()));
        System.out.println(manager.getTreeHeight(tree.getRoot()));
           System.out.println(manager.getTreeSize(tree.getRoot()));
          

 
    }
}

