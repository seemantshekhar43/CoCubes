//package com.company;
//
//import java.util.concurrent.Semaphore;
//
//public class WithSemaphore{
//
//    static int rc = 0;
//    static Semaphore mutex = 1;
//    static Semaphore db = 1;
//
//    public class TreeNode{
//        int val;
//        Semaphore locked = 0;
//        TreeNode parent;
//        Vector<TreeNode> child;
//        int lockedDescendent = 0;
//    }
//
//
//    static TreeNode newNode(int key){
//
//        TreeNode temp = new TreeNode();
//        temp.val = key;
//        temp.child = new Vector<TreeNode>();
//        return temp;
//    }
//
//    public static boolean isLocked(TreeNode node){
//
//        return (boolean)node.locked;
//
//    }
//
//    public static boolean lock(TreeNode node){
//
//        if(isLocked(node)){
//
//            return false;
//        }
//
//        if(!canLockOrUnlock(node)){
//            return false;
//        }
//
//        signal(node.locked); // if India is locked then descendent childs are not even able to come here bcoz we already locked parent
//
//
//        //here we are writing the data
//        while(true){
//            mute(db);// it becomes 0
//
//            // critical section
//
//            TreeNode parentNode = node.parent;
//
//
//            while(parentNode != null){
//
//                parentNode.lockedDescendent +=  1;
//                parentNode = parentNode.parent;
//            }
//
//            signal(db);// 1 again
//
//            if(parentNode == null){
//                break;
//            }
//        }
//
//        return true;
//
//    }
//
//    public boolean unLock(TreeNode node){
//        //in unlock we are only writing not reading
//
//        if(!isLocked(node)){
//            return false;
//        }
//        mute(node.locked); // false making it 0
//        TreeNode parentNode = new TreeNode();
//
//        //writing start
//        while(true){
//
//            //we mute or down db at start so no other writer will come here
//            //because if new writer want to access then they are trying to down db
//            //and db is already 0 so it will return false
//
//            mute(db);
//            //writing section
//            while(parentNode != null){
//                parentNode.lockeddescendent -= 1;
//                parentNode = parentNode.parent;
//            }
//            //after completing the writing section we increase db variable so other writers can come
//            signal(db);
//
//            if(parentNode == null){
//                break;
//            }
//
//        }
//        return true;
//    }
//
//    public boolean canLockOrUnlock(TreeNode node){
//
//        if(node.lockedDescendent >0){
//            return false;
//        }
//
//        TreeNode parentNode = new TreeNode();
//
//        //here we are reading the data
//        while(true){
//
//            down(mutex);
//
//            rc = rc + 1;
//
//            if(rc== 1){
//                down(db);
//            }
//            //so many reader can able to read the data
//            up(mutex);
//
//            //reading the data
//            while(parentNode != null){
//
//                if(isLocked(parentNode)){
//
//                    return false;
//
//                }
//                parentNode = parentNode.parent;
//
//            }
//            down(mutex);
//            rc = rc-1;
//            if(rc == 0){
//                //so read count is zero so other writers can now access data
//                signal(db);
//            }
//            signal(mutex);
//            //we reached at the top of tree
//            if(parentNode == null){
//                break;
//            }
//
//        }
//
//        return true;
//
//    }
//}
//}