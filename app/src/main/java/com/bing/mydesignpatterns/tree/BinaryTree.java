package com.bing.mydesignpatterns.tree;

/**
 * Created by Administrator on 2019/2/21.
 * 二叉树学习
 */

public class BinaryTree {
    int data;
    BinaryTree left; // 左子树
    BinaryTree right; // 右子树

    public BinaryTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public void insert(BinaryTree root,int data){     //向二叉树中插入子节点
        if(data>root.data)                               //二叉树的左节点都比根节点小
        {
            if(root.right==null){
                root.right = new BinaryTree(data);
            }else{
                this.insert(root.right, data);
            }
        }else{                                          //二叉树的右节点都比根节点大
            if(root.left==null){
                root.left = new BinaryTree(data);
            }else{
                this.insert(root.left, data);
            }
        }
    }
    public static void preOrder(BinaryTree root){  //先根遍历
        if(root!=null){
            System.out.print(root.data+"-");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void inOrder(BinaryTree root){     //中根遍历

        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data+"--");
            inOrder(root.right);
        }
    }

    public static void postOrder(BinaryTree root){    //后根遍历

        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+"---");
        }
    }

}
