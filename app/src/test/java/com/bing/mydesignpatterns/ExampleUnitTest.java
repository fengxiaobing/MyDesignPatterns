package com.bing.mydesignpatterns;

import com.bing.mydesignpatterns.tree.BinaryTree;

import org.junit.Test;

import static com.bing.mydesignpatterns.tree.BinaryTree.inOrder;
import static com.bing.mydesignpatterns.tree.BinaryTree.postOrder;
import static com.bing.mydesignpatterns.tree.BinaryTree.preOrder;
import static org.junit.Assert.*;


public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        int[] array = {24,76,35,22,16,48,90,46,9,40};
        BinaryTree root = new BinaryTree(array[0]);   //创建二叉树
        for(int i=1;i<array.length;i++){
            root.insert(root, array[i]);       //向二叉树中插入数据
        }
        System.out.println("先根遍历：");
        preOrder(root);
        System.out.println();
        System.out.println("中根遍历：");
        inOrder(root);
        System.out.println();
        System.out.println("后根遍历：");
        postOrder(root);
    }

}