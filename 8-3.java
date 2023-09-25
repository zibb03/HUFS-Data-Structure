// import java.io.*;
// import java.util.Scanner;

// class BinarySearchTree {
// 	class TreeNode {
// 		String key;
// 		TreeNode left;
// 		TreeNode right;
// 	}
	
// 	private TreeNode rootNode;
	
// 	public void insert(String x) {
// 		rootNode = insertKey(rootNode, x);
// 	}
	
// 	public TreeNode find(String x) {
// 		TreeNode t = rootNode;
// 		int result;
		
// 		while (t != null) {
// 			if ((result = x.compareTo(t.key)) < 0) {
// 				t = t.left;
// 			} else if (result == 0) {
// 				return t;
// 			} else {
// 				t = t.right;
// 			}
// 		}
		
// 		return t;
// 	}
	
// 	private void printNode(TreeNode n) {
// 		if (n != null) {
// 			System.out.print("(");
// 			printNode(n.left);
// 			System.out.print(n.key);
// 			printNode(n.right);
// 			System.out.print(")");
// 		}
// 	}
	
// 	public void print() {
// 		printNode(rootNode);
// 		System.out.println();
// 	}
	
// 	// 아래 2개의 메소드 insertKey, delete를 완성하시오.
	
// 	/**
// 	 * 교재 p.325 참조
// 	 * 이원탐색트리의 노드 t에 데이터 x를 추가한다. 순환함수로 작성해야 한다.
// 	 * @param t 이원탐색트리의 노드. 이 노드 아래에 데이터를 삽입한다.
// 	 * @param x 삽입하고자 하는 데이터
// 	 * @return 사입한 이원탐색트리의 부모 노드
// 	 */
// 	private TreeNode insertKey(TreeNode t, String x) {
// 		if (t == null) {
// 			TreeNode newNode = new TreeNode();
// 			newNode.key = x;
// 			return newNode;
// 		} else if (x.compareTo(t.key) < 0) { // x < T.key이면 x를 T의 왼쪽
// 			t.left = insertKey(t.left, x); // 서브트리에 삽입
// 			return t;
// 		} else if (x.compareTo(t.key) > 0) { // x > T.key이면 x를 T의 오른쪽
// 			t.right = insertKey(t.right, x); // 서브트리에 삽입
// 			return t;
// 		} else { // key값 x가 이미 T에 있는 경우
// 			return t;
// 		}
// 		// return null;
// 	}

// 	/**
// 	 * 교재 p.324 참조
// 	 * 이진 트리에서 x 를 찾아서 그 노드를 삭제한다.
// 	 * @param x 삭제하고자 하는 데이터
// 	 */
// 	public void delete(String x) {
// 		TreeNode t = rootNode;
// 		TreeNode p = null;
// 		boolean isLeftChild = false;

// 		while (t != null && !t.key.equals(x)) {
// 			p = t;
// 			if (x.compareTo(t.key) < 0) {
// 				t = t.left;
// 				isLeftChild = true;
// 			} else {
// 				t = t.right;
// 			}
// 		}

// 		if (t == null) {
// 			return;
// 		}

// 		// If the node has no children, simply remove it.
// 		if (t.left == null && t.right == null) {
// 			if (isLeftChild) {
// 				p.left = null;
// 			} else {
// 				p.right = null;
// 			}
// 		} else if (t.left != null && t.right != null) {
// 			// If the node has two children, replace it with the maximum node in the left subtree.
// 			TreeNode max = maxNode(t.left);
// 			t.key = max.key;
// 			delete(max.key);
// 		} else {
// 			// If the node has only one child, simply replace it with the child.
// 			if (t.left != null) {
// 				if (isLeftChild) {
// 					p.left = t.left;
// 				} else {
// 					p.right = t.left;
// 				}
// 			} else {
// 				if (isLeftChild) {
// 					p.left = t.right;
// 				} else {
// 					p.right = t.right;
// 				}
// 			}
// 		}
// 	}
// }
	
// class Main {
	
// 	// 아래 main 메소드는 수정하지 마시오.
// 	public static void main(String[] args) throws Exception {
// 		Scanner scan = new Scanner(System.in);
// 		BinarySearchTree tree = new BinarySearchTree();
		
// 		while (scan.hasNext()) {
// 			String command = scan.next();
			
// 			if (command.equals("I")) {
// 				String data = scan.next();
// 				tree.insert(data);
// 			} else if (command.equals("D")) {
// 				String data = scan.next();
// 				tree.delete(data);
// 			} else if (command.equals("P")) {
// 				tree.print();
// 			}
// 		}
// 		scan.close();
// 	}
	
// }

import java.io.*;
import java.util.Scanner;

class BinarySearchTree {
    class TreeNode {
        String key;
        TreeNode left;
        TreeNode right;
    }
    
    private TreeNode rootNode;
    
    public void insert(String x) {
        rootNode = insertKey(rootNode, x);
    }
    
    public TreeNode find(String x) {
        TreeNode t = rootNode;
        int result;
        
        while (t != null) {
            if ((result = x.compareTo(t.key)) < 0) {
                t = t.left;
            } else if (result == 0) {
                return t;
            } else {
                t = t.right;
            }
        }
        
        return t;
    }
    
    private void printNode(TreeNode n) {
        if (n != null) {
            System.out.print("(");
            printNode(n.left);
            System.out.print(n.key);
            printNode(n.right);
            System.out.print(")");
        }
    }
    
    public void print() {
        printNode(rootNode);
        System.out.println();
    }
    
    // Implement the insertKey method to insert a key into the binary search tree.
    private TreeNode insertKey(TreeNode t, String x) {
        if (t == null) {
            TreeNode newNode = new TreeNode();
            newNode.key = x;
            return newNode;
        }

        int result = x.compareTo(t.key);
        if (result < 0) {
            t.left = insertKey(t.left, x);
        } else if (result > 0) {
            t.right = insertKey(t.right, x);
        }

        return t;
    }

    // Implement the delete method to delete a key from the binary search tree.
    public void delete(String x) {
        rootNode = deleteKey(rootNode, x);
    }

    private TreeNode deleteKey(TreeNode t, String x) {
        if (t == null) {
            return null;
        }

        int result = x.compareTo(t.key);
        if (result < 0) {
            t.left = deleteKey(t.left, x);
        } else if (result > 0) {
            t.right = deleteKey(t.right, x);
        } else {
            if (t.left == null) {
                return t.right;
            } else if (t.right == null) {
                return t.left;
            }

            TreeNode minNode = findMinNode(t.right);
            t.key = minNode.key;
            t.right = deleteKey(t.right, minNode.key);
        }

        return t;
    }

    private TreeNode findMinNode(TreeNode t) {
        if (t.left == null) {
            return t;
        }
        return findMinNode(t.left);
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        
        while (scan.hasNext()) {
            String command = scan.next();
            
            if (command.equals("I")) {
                String data = scan.next();
                tree.insert(data);
            } else if (command.equals("D")) {
                String data = scan.next();
                tree.delete(data);
            } else if (command.equals("P")) {
                tree.print();
            }
        }
        scan.close();
    }
}
