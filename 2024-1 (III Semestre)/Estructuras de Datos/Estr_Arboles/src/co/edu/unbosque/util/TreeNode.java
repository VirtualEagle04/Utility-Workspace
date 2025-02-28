package co.edu.unbosque.util;

public class TreeNode<T> {

	private T data;

	// Because it's Binary Tree
	private TreeNode<T> left;
	private TreeNode<T> right;

	public TreeNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String printTree() {
		return printTreeHelper(this, 1);
	}

	public String printTreeHelper(TreeNode<T> node, int level) {
		StringBuilder sb = new StringBuilder();
		sb.append(node.getData() + "\n");
		if (node.getLeft() != null) {
			for (int i = 0; i < level; i++) {
				if(i == level-1) {
					sb.append("->");
				}else {
					sb.append("--");
				}
			}
			sb.append(printTreeHelper(node.getLeft(), level + 1));
		}
		if (node.getRight() != null) {
			for (int i = 0; i < level; i++) {
				if(i == level-1) {
					sb.append("->");
				}else {
					sb.append("--");
				}
			}
			sb.append(printTreeHelper(node.getRight(), level + 1));
		}
		return sb.toString();
	}

}
