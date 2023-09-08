package bean;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public Integer val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(Integer val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public TreeNode addRecursive(TreeNode current, Integer value) {
		if (current == null) {
			return new TreeNode(value);
		}

		if (value < current.val) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.val) {
			current.right = addRecursive(current.right, value);
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	public void printFromLeftToRight(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			System.out.println(current.val);

			if (current.left != null) {
				queue.offer(current.left);
			}
			if (current.right != null) {
				queue.offer(current.right);
			}
		}
	}

}
