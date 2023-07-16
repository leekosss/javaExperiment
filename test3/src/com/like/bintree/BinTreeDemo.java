package com.like.bintree;


import java.io.IOException;
import java.util.Scanner;

public class BinTreeDemo {

    public static void main(String[] args) throws IOException {
        BinTree binTree = new BinTree();
        System.out.println("请输入前序建树序列:");
        binTree.create();
        System.out.println("前序遍历:");
        binTree.pre();
//        System.out.println("\n中序遍历:");
//        binTree.mid();
        System.out.println("\n后序遍历");
        binTree.post();
        System.out.println("前序遍历:");
        binTree.preN();
        System.out.println("\n中序遍历:");
        binTree.midN();
    }
}

// 存储char型数据的链式二叉树结构
class BinTree {
    char root;
    BinTree left,right;

    public BinTree() {
        root = '#';
        left = null;
        right = null;
    }



    /**
     * 二叉树的创建
     */
    public void create() throws IOException {

        char x = (char) System.in.read();
        if(x=='#')
            return;
        root = x;
        left = new BinTree();
        left.create();
        right = new BinTree();
        right.create();
    }

    /**
     * 前序递归遍历
     */
    public void pre() {

        if (root!='#') {
            System.out.print(root);
        }
        if (left!=null) {
            left.pre();
        }
        if (right!=null) {
            right.pre();
        }
    }

    /**
     * 中序递归遍历
     */
    public void mid() {
        if(left!=null) {
            left.mid();
        }

        if (root!='#') {
            System.out.print(root);
        }
        if(right!=null) {
            right.mid();
        }
    }

    /**
     * 后序递归遍历
     */
    public void post() {
        if(left!=null) {
            left.post();
        }
        if(right!=null) {
            right.post();
        }
        if (root!='#') {
            System.out.print(root);
        }
    }

    /**
     * 前序非递归遍历
     */
    public void preN() {

        Stack s = new Stack();
        s.init();
        BinTree p = this;

        while(p!=null || !s.isEmpty()) {
            if(p!=null) {
                if (p.root!='#') {
                    System.out.print(p.root);
                }
                s.push(p);
                p=p.left;
            } else {
                 p = s.pop();
                 p = p.right;
            }
        }

    }

    /**
     * 中序非递归遍历
     */
    public void midN() {
        Stack s = new Stack();
        s.init();
        BinTree p = this;
        while(p!=null || !s.isEmpty()) {
            if(p!=null) {
                s.push(p);
                p=p.left;

            } else {
                p = s.pop();
                if(p.root!='#') {
                    System.out.print(p.root);
                }
                p=p.right;
            }
        }
    }
}

class Stack {
    BinTree[] stack;
    int top;

    //栈的初始化
    public void init() {
        top = 0;
        stack = new BinTree[50];
    }

    //入栈
    public void push(BinTree binTree) {
        stack[top] = binTree;
        top++;
    }

    //出栈
    public BinTree pop() {
        top--;
        return stack[top];
    }

    //判空
    public boolean isEmpty() {
        if (top == 0) {
            return true;
        }
        return false;
    }
}