package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 二叉树节点类 */
class TreeNode {
    int val;         // 节点值
    TreeNode left;   // 左子节点引用
    TreeNode right;  // 右子节点引用
    TreeNode(int x) { val = x; }
}

public class binary_tree_bfs {
    /* 层序遍历 */
    static List<Integer> levelOrder(TreeNode root) {
        // 初始化队列，加入根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 初始化一个列表，用于保存遍历序列
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            System.out.println("queue size is "+queue.size());
            TreeNode node = queue.poll(); // 队列出队
            list.add(node.val);           // 保存节点值
            System.out.println("list add "+ node.val);
            if (node.left != null){
                queue.offer(node.left);   // 左子节点入队
                System.out.println("queue offer" + node.left.val);
            }

            if (node.right != null){
                queue.offer(node.right);  // 右子节点入队
                System.out.println("queue offer"+ node.right.val);
            }

        }
        return list;
    }

    public static void main(String[] args) {
        // 初始化节点
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
// 构建节点之间的引用（指针）
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        var treeList = levelOrder(n1);

        for (int i = 0; i < treeList.size(); i++) {
            var t = treeList.get(i);
            System.out.println("index "+ i + " tree val " + t);
        }
    }
}
